package org.restcomm.sdk;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.Rule;
import org.junit.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

/**
 * @author oleg.agafonov@telestax.com (Oleg Agafonov)
 */
public class HttpClientTest {

    @Rule
    public WireMockRule wireMock = new WireMockRule();

    @Test
    public void checkAuthorizationHeaderTest() {
        String username = "username";
        String password = "password";
        String adminUsername = "usernameAdmin";
        String adminPassword = "passwordAdmin";

        stubFor(get(anyUrl())
                .withBasicAuth(username, password)
                .willReturn(aResponse()
                        .withStatus(200)));

        new HttpClient(username, password, adminUsername, adminPassword)
                .get("http://localhost:" + wireMock.port(), Object.class);

    }
}
