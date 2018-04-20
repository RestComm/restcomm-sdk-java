package org.restcomm.sdk.endpoints;

import org.restcomm.sdk.HttpClient;

/**
 * @author oleg.agafonov@telestax.com (Oleg Agafonov)
 */
public abstract class Endpoints {

    protected final String url;

    protected final HttpClient httpClient;

    public Endpoints(String url, HttpClient httpClient) {
        this.url = url;
        this.httpClient = httpClient;
    }
}
