package org.restcomm.sdk.endpoints;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import static com.fasterxml.jackson.databind.PropertyNamingStrategy.SNAKE_CASE;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.restcomm.sdk.RestcommClient;
import org.restcomm.sdk.RestcommClientConfiguration;
import org.restcomm.sdk.domain.AvailablePhoneNumber;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.okJson;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlPathEqualTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * @author Henrique Rosa (henrique.rosa@telestax.com) created on 27/08/2018
 */
public class AvailablePhoneNumbersEndpointTest {

    @Rule
    public WireMockRule wireMock = new WireMockRule();

    @Test
    public void testGetAvailablePhoneNumbersFromUS() throws IOException {
        // given
        final String username = "username";
        final String password = "password";
        final String baseUrl = "http://localhost:" + wireMock.port();
        final RestcommClient client = new RestcommClient(RestcommClientConfiguration.builder().accountSid(username).accountToken(password).baseUrl(baseUrl).build());
        final RestEndpoints<AvailablePhoneNumber> endpoint = client.getAvailablePhoneNumbersEndpoints();

        final File file = new File("src/test/resources/responses/available-phone-numbers-response.json");
        final String response = new String(Files.readAllBytes(file.toPath()));
        stubFor(get(urlPathEqualTo("/restcomm/2012-04-24/Accounts/" + username + "/AvailablePhoneNumbers/US/Local.json"))
                .withBasicAuth(username, password)
                .willReturn(okJson(response)));

        // when
        final List<AvailablePhoneNumber> availablePhoneNumbers = endpoint.getAll();

        // then
        assertNotNull(availablePhoneNumbers);
        assertEquals(3, availablePhoneNumbers.size());
        assertEquals("11111111111", availablePhoneNumbers.get(0).getFriendlyName());
        assertEquals("11111111111", availablePhoneNumbers.get(0).getPhoneNumber());
        assertEquals("US", availablePhoneNumbers.get(0).getIsoCountry());
        assertEquals("0.67", availablePhoneNumbers.get(0).getCost());
        assertTrue(availablePhoneNumbers.get(0).getVoiceCapable());
        assertTrue(availablePhoneNumbers.get(0).getSmsCapable());

        assertEquals("12222222222", availablePhoneNumbers.get(1).getFriendlyName());
        assertEquals("12222222222", availablePhoneNumbers.get(1).getPhoneNumber());
        assertEquals("US", availablePhoneNumbers.get(1).getIsoCountry());
        assertEquals("0.67", availablePhoneNumbers.get(1).getCost());
        assertTrue(availablePhoneNumbers.get(1).getVoiceCapable());
        assertFalse(availablePhoneNumbers.get(1).getSmsCapable());

        assertEquals("13333333333", availablePhoneNumbers.get(2).getFriendlyName());
        assertEquals("13333333333", availablePhoneNumbers.get(2).getPhoneNumber());
        assertEquals("US", availablePhoneNumbers.get(2).getIsoCountry());
        assertEquals("0.67", availablePhoneNumbers.get(2).getCost());
        assertTrue(availablePhoneNumbers.get(2).getVoiceCapable());
        assertTrue(availablePhoneNumbers.get(2).getSmsCapable());

    }

}
