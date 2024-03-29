package org.restcomm.sdk;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.Consts;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.apache.http.entity.ContentType;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.restcomm.sdk.domain.Restful;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.stream.Collectors;

import static com.fasterxml.jackson.databind.PropertyNamingStrategy.SNAKE_CASE;
import static org.apache.commons.codec.binary.Base64.encodeBase64String;

/**
 * @author oleg.agafonov@telestax.com (Oleg Agafonov)
 */
public class HttpClient {

    private final Executor executor;

    private final BasicHeader authoriztion;

    private final ObjectMapper serializer;

    private final ObjectMapper deserializer;

    public HttpClient(String accountSid, String accountToken) {
        this.executor = Executor.newInstance();

        String authorization = accountSid + ":" + accountToken;
        this.authoriztion = new BasicHeader("Authorization", "Basic " + encodeBase64String(authorization.getBytes()));

        this.serializer = new ObjectMapper();
        this.serializer.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        this.deserializer = new ObjectMapper();
        this.deserializer.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        this.deserializer.setPropertyNamingStrategy(SNAKE_CASE);
    }

    public <T> T post(String url, Object entity, Class<T> type) {
        Request request = Request.Post(url);
        addRequestBody(request, entity);
        return executeRequest(request, type);
    }

    public <T> T get(String url, Object entity, JavaType type) {
        String response = get(addRequestParams(url, entity), String.class);
        try {
            return deserializer.readValue(response, type);
        } catch (IOException e) {
            throw new RestcommClientException(e);
        }
    }

    public <T> T get(String url, Class<T> type) {
        return executeRequest(Request.Get(url), type);
    }

    public <T> ExtendedResponse<T> getWithHeaders(String url, Class<T> type) {
        return executeRequestWithHeaders(Request.Get(url), type);
    }

    public <T> T put(String url, Object entity, Class<T> type) {
        Request request = Request.Put(url);
        addRequestBody(request, entity);
        return executeRequest(request, type);
    }

    public <T> T delete(String url, Class<T> type) {
        return executeRequest(Request.Delete(url), type);
    }

    private String addRequestParams(String url, Object entity) {
        if (entity == null) {
            return url;
        }
        try {
            Map<String, Object> values = serializer.convertValue(entity, Map.class);
            if (values.size() == 0) {
                return url;
            }
            StringBuilder sb = new StringBuilder(url)
                    .append("?");
            values.forEach((k, v) -> {
                sb.append(k)
                        .append("=")
                        .append(v)
                        .append("&");
            });
            sb.setLength(sb.length() - 1);
            return sb.toString();
        } catch (Exception e) {
            throw new RestcommClientException(e);
        }
    }

    private void addRequestBody(Request request, Object entity) {
        try {
            if (entity instanceof Restful) {
                request.bodyString(serializer.writeValueAsString(entity), ContentType.APPLICATION_JSON);
            } else {
                Map<String, Object> values = serializer.convertValue(entity, Map.class);
                request.bodyForm(values.entrySet()
                        .stream()
                        .filter(entry -> entry.getValue() != null)
                        .map(entry -> {
                            String name = entry.getKey().toString();
                            // Restcomm.Connect inconsistent API: isSIP instead of IsSIP ;(
                            if (!name.equals("isSIP")) {
                                name = name.substring(0, 1).toUpperCase() + name.substring(1);
                            }
                            String value = entry.getValue().toString();
                            return new BasicNameValuePair(name, value);
                        })
                        .collect(Collectors.toList()), Consts.UTF_8);
            }
        } catch (Exception e) {
            throw new RestcommClientException(e);
        }
    }

    private <T> T executeRequest(Request request, Class<T> type) {
        try {
            request.addHeader(authoriztion);
            Content content = executor
                    .execute(request)
                    .returnContent();
            if (content == null) {
                return null;
            }
            String response = content.asString();
            if (response.isEmpty()) {
                return null;
            }
            if (type.equals(String.class)) {
                return (T) response;
            }
            return deserializer.readValue(response, type);
        } catch (Exception e) {
            throw new RestcommClientException(e);
        }
    }

    private <T> ExtendedResponse<T> executeRequestWithHeaders(Request request, Class<T> type) {
        try {
            request.addHeader(authoriztion);
            Response response = executor.execute(request);
            HttpResponse httpResponse = response.returnResponse();

            InputStream inputStream = httpResponse.getEntity().getContent();
            ByteArrayOutputStream result = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            for (int length; (length = inputStream.read(buffer)) != -1;) {
                result.write(buffer, 0, length);
            }
            String responseContent = result.toString(StandardCharsets.UTF_8.name());
            if (responseContent.isEmpty()) {
                return null;
            }
            if (type.equals(String.class)) {
                return new ExtendedResponse<T>((T) response, new Header[0]);
            }
            T jsonRes = deserializer.readValue(responseContent, type);

            ExtendedResponse<T> res = new ExtendedResponse<T>(jsonRes, httpResponse.getAllHeaders());
            return res;
        } catch (Exception e) {
            throw new RestcommClientException(e);
        }
    }

    public static class ExtendedResponse<T> {
        private T jsonResponse;
        private Header[] headers;

        public ExtendedResponse(T jsonResponse, Header[] headers) {
            this.jsonResponse = jsonResponse;
            this.headers = headers;
        }

        public T getJsonResponse() {
            return jsonResponse;
        }

        public Header[] getHeaders() {
            return headers;
        }

    }

}
