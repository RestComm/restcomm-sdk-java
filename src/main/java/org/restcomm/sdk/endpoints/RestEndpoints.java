package org.restcomm.sdk.endpoints;

import com.fasterxml.jackson.databind.type.TypeFactory;
import org.restcomm.sdk.HttpClient;

import java.util.List;

/**
 * @author oleg.agafonov@telestax.com (Oleg Agafonov)
 */
public class RestEndpoints<T> extends Endpoints {

    private final Class<T> type;

    public RestEndpoints(String url, HttpClient httpClient, Class<T> type) {
        super(url, httpClient);
        this.type = type;
    }

    public List<T> getAll() {
        return getAll(null);
    }

    public List<T> getAll(Object query) {
        return httpClient.get(url, query, TypeFactory
                .defaultInstance().constructCollectionType(List.class, type));
    }

    public T get(Object query) {
        return httpClient.get(url, query, TypeFactory.defaultInstance().constructType(type));
    }

    public T create(T entity) {
        return httpClient.post(url, entity, type);
    }

    public T get(String id) {
        return httpClient.get(url + "/" + id, type);
    }

    public T update(T entity) {
        return httpClient.put(url, entity, type);
    }

    public void delete(String id) {
        httpClient.delete(url + "/" + id, type);
    }
}
