package org.restcomm.sdk.endpoints;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.Rule;
import org.junit.Test;
import org.restcomm.sdk.RestcommClient;
import org.restcomm.sdk.RestcommClientConfiguration;
import org.restcomm.sdk.domain.Call;
import org.restcomm.sdk.domain.CallPage;
import org.restcomm.sdk.domain.CallStatus;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collections;
import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Henrique Rosa (henrique.rosa@telestax.com) created on 22/05/2018
 */
public class CallsEndpointTest {

    @Rule
    public WireMockRule wireMock = new WireMockRule();

    @Test
    public void testGetCallPage() throws IOException {
        // given
        final String username = "username";
        final String password = "password";
        final String baseUrl = "http://localhost:" + wireMock.port();
        final RestcommClient client = new RestcommClient(RestcommClientConfiguration.builder().accountSid(username).accountToken(password).baseUrl(baseUrl).build());
        final RestEndpoints<CallPage> callsEndpoint = client.getCallsEndpoint();

        final File file = new File("src/test/resources/responses/calls-response.json");
        final String response = new String(Files.readAllBytes(file.toPath()));

        stubFor(get(urlPathEqualTo("/restcomm/2012-04-24/Accounts/" + username + "/Calls.json"))
                .withBasicAuth(username, password)
                .willReturn(okJson(response)));

        // when
        final CallPage callPage = callsEndpoint.findOne(Collections.emptyMap());

        // then
        assertNotNull(callPage);
        assertEquals(0, callPage.getPage());
        assertEquals(50, callPage.getPageSize());
        assertEquals(1, callPage.getTotal());
        assertEquals(0, callPage.getStart());
        assertEquals(1, callPage.getEnd());
        assertEquals("/2012-04-24/Accounts/ACa12345/Calls", callPage.getUri());
        assertEquals("/2012-04-24/Accounts/ACa12345/Calls?Page\u003d0\u0026PageSize\u003d50", callPage.getFirstPageUri());
        assertEquals("null", callPage.getPreviousPageUri());
        assertEquals("null", callPage.getNextPageUri());
        assertEquals("/2012-04-24/Accounts/ACa12345/Calls?Page\u003d0\u0026PageSize\u003d50", callPage.getLastPageUri());
        final List<Call> calls = callPage.getCalls();
        assertNotNull(calls);
        assertEquals(1, calls.size());
        assertEquals("ID12345-CA12345", calls.get(0).getSid());
        assertEquals("Fri, 18 May 2018 14:57:59 +0000", calls.get(0).getDateCreated());
        assertEquals("Fri, 18 May 2018 14:58:59 +0000", calls.get(0).getDateUpdated());
        assertEquals("ACa12345", calls.get(0).getAccountSid());
        assertEquals("1708a040dd94e22b04b721b21d", calls.get(0).getTo());
        assertEquals("fd5a300f60744d6eb013e06f64da2132", calls.get(0).getFrom());
        assertEquals("ACa12345", calls.get(0).getPhoneNumberSid());
        assertEquals(CallStatus.FAILED.description(), calls.get(0).getStatus());
        assertEquals("2018-05-18T14:57:59.000Z", calls.get(0).getStartTime());
        assertEquals("2018-05-18T14:58:59.000Z", calls.get(0).getEndTime());
        assertEquals(0, calls.get(0).getDuration());
        assertEquals(0.0, calls.get(0).getPrice(), 0);
        assertEquals("2012-04-24", calls.get(0).getApiVersion());
        assertEquals("Unknown", calls.get(0).getCallerName());
        assertEquals("/2012-04-24/Accounts/ACa12345/Calls/ID12345-CA12345.json", calls.get(0).getUri());
    }

}
