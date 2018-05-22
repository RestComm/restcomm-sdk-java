package org.restcomm.sdk.endpoints;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.Rule;
import org.junit.Test;
import org.restcomm.sdk.RestcommClient;
import org.restcomm.sdk.RestcommClientConfiguration;
import org.restcomm.sdk.domain.Recording;
import org.restcomm.sdk.domain.RecordingPage;

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
public class RecordingsEndpointTest {

    @Rule
    public WireMockRule wireMock = new WireMockRule();

    @Test
    public void testGetRecordingPage() throws IOException {
        // given
        final String username = "username";
        final String password = "password";
        final String baseUrl = "http://localhost:" + wireMock.port();
        final RestcommClient client = new RestcommClient(RestcommClientConfiguration.builder().accountSid(username).accountToken(password).baseUrl(baseUrl).build());
        final RestEndpoints<RecordingPage> endpoint = client.getRecordingsEndpoint();

        final File file = new File("src/test/resources/responses/recordings-response.json");
        final String response = new String(Files.readAllBytes(file.toPath()));

        stubFor(get(urlPathEqualTo("/restcomm/2012-04-24/Accounts/" + username + "/Recordings.json"))
                .withBasicAuth(username, password)
                .willReturn(okJson(response)));

        // when
        final RecordingPage resultPage = endpoint.findOne(Collections.emptyMap());

        // then
        assertNotNull(resultPage);
        assertEquals(0, resultPage.getPage());
        assertEquals(397, resultPage.getNumPages());
        assertEquals(50, resultPage.getPageSize());
        assertEquals(19858, resultPage.getTotal());
        assertEquals(0, resultPage.getStart());
        assertEquals(49, resultPage.getEnd());
        assertEquals("/restcomm/2012-04-24/Accounts/AC12345/Recordings", resultPage.getUri());
        assertEquals("/restcomm/2012-04-24/Accounts/AC12345/Recordings?Page\u003d0\u0026PageSize\u003d50", resultPage.getFirstPageUri());
        assertEquals("null", resultPage.getPreviousPageUri());
        assertEquals("/restcomm/2012-04-24/Accounts/AC12345/Recordings?Page\u003d1\u0026PageSize\u003d50\u0026AfterSid\u003dRE22222", resultPage.getNextPageUri());
        assertEquals("/restcomm/2012-04-24/Accounts/AC12345/Recordings?Page\u003d397\u0026PageSize\u003d50", resultPage.getLastPageUri());
        final List<Recording> recordings = resultPage.getRecordings();
        assertNotNull(recordings);
        assertEquals(2, recordings.size());
        assertEquals("RE11111", recordings.get(0).getSid());
        assertEquals("Fri, 25 Sep 2015 15:59:56 +0000", recordings.get(0).getDateCreated());
        assertEquals("Fri, 25 Sep 2015 15:59:56 +0000", recordings.get(0).getDateUpdated());
        assertEquals("AC12345", recordings.get(0).getAccountSid());
        assertEquals("CA11111", recordings.get(0).getCallSid());
        assertEquals(9.72275, recordings.get(0).getDuration(), 0);
        assertEquals("2012-04-24", recordings.get(0).getApiVersion());
        assertEquals("/2012-04-24/Accounts/AC12345/Recordings/RE11111.json", recordings.get(0).getUri());
        assertEquals("https://some.domain.com/restcomm/2012-04-24/Accounts/AC12345/Recordings/RE11111.wav", recordings.get(0).getFileUri());
    }

}
