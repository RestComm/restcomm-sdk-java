package org.restcomm.sdk.endpoints;

import com.fasterxml.jackson.databind.type.TypeFactory;
import org.restcomm.sdk.HttpClient;
import org.restcomm.sdk.domain.solutions.SolutionsResponse;

import java.util.List;

/**
 * @author oleg.agafonov@telestax.com (Oleg Agafonov)
 * @author henrique.rosa@telestax.com (Henrique Rosa)
 */
public class RestEndpoints<T> extends Endpoints {

    private final Class<T> type;

    public RestEndpoints(String url, HttpClient httpClient, Class<T> type) {
        super(url, httpClient);
        this.type = type;
    }

    public List<T> getAll() {
        return find(null);
    }

    public T get(String id) {
        return httpClient.get(url + "/" + id, type);
    }

    public HttpClient.ExtendedResponse<T> getWithHeaders(String id) {
        return httpClient.getWithHeaders(url + "/" + id, type);
    }

    public List<T> find(Object query) {
        return httpClient.get(url, query, TypeFactory.defaultInstance().constructCollectionType(List.class, type));
    }

    public T findOne(Object query) {
        return httpClient.get(url, query, TypeFactory.defaultInstance().constructType(type));
    }

    public T create(T entity) {
        if (entity instanceof SolutionsResponse) {
            SolutionsResponse solutionsResponse = (SolutionsResponse) entity;
            return httpClient.post(url, solutionsResponse.getEntity(), type);
        } else {
            return httpClient.post(url, entity, type);
        }
    }

    public T updatePost(String id, T entity) {
        if (entity instanceof SolutionsResponse) {
            SolutionsResponse solutionsResponse = (SolutionsResponse) entity;
            return httpClient.post(url + "/" + id, solutionsResponse.getEntity(), type);
        } else {
            return httpClient.post(url + "/" + id, entity, type);
        }

    }

    public T update(T entity) {
        if (entity instanceof SolutionsResponse) {
            SolutionsResponse solutionsResponse = (SolutionsResponse) entity;
            return httpClient.put(url, solutionsResponse.getEntity(), type);
        } else {
            return httpClient.put(url, entity, type);
        }
    }

    public void delete(String id) {
        httpClient.delete(url + "/" + id, type);
    }

}
