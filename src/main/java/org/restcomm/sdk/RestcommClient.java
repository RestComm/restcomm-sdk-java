package org.restcomm.sdk;

import org.restcomm.sdk.domain.*;
import org.restcomm.sdk.endpoints.RestEndpoints;

import java.util.Map;

/**
 * @author oleg.agafonov@telestax.com (Oleg Agafonov)
 */
public class RestcommClient {

    private final HttpClient httpClient;

    private final String baseRestcommUrl;
    private final String baseRestcommUrlWithoutAccount;

    private final String baseUrl;
    private final String accountSid;

    private final Map<String, String> endpoints;

    public RestcommClient(RestcommClientConfiguration config) {
        this.httpClient = new HttpClient(config.getAccountSid(), config.getAccountToken(), config.getAdminAccountSid(),
                config.getAdminAccountToken());
        this.baseRestcommUrlWithoutAccount = config.getBaseUrl() + "/restcomm/2012-04-24/Accounts";
        this.baseRestcommUrl = config.getBaseUrl() + "/restcomm/2012-04-24/Accounts/" + config.getAccountSid();
        this.baseUrl = config.getBaseUrl();
        this.endpoints = config.getEndpoints();
        this.accountSid = config.getAccountSid();
    }

    public String getAccountSid() {
        return this.accountSid;
    }

    public RestEndpoints<CallPage> getCallsEndpoint() {
        return getEndpoints("calls", baseRestcommUrl + "/Calls.json", CallPage.class);
    }

    public RestEndpoints<RecordingPage> getRecordingsEndpoint() {
        return getEndpoints("recordings", baseRestcommUrl + "/Recordings.json", RecordingPage.class);
    }

    public RestEndpoints<Client> getClientsEndpoints() {
        return getEndpoints("clients", baseRestcommUrl + "/Clients.json", Client.class);
    }

    public RestEndpoints<Account> getAccountsEndpoints() {
        return getEndpoints("accounts", baseRestcommUrlWithoutAccount + ".json", Account.class);
    }

    public RestEndpoints<Account> getAccountsEndpoints(String subAccountSid) {
        return getEndpoints("accounts", baseRestcommUrlWithoutAccount + ".json/" + subAccountSid, Account.class);
    }

    public RestEndpoints<Application> getApplicationsEndpoints() {
        return getEndpoints("applications", baseRestcommUrl + "/Applications.json", Application.class);
    }

    public RestEndpoints<IncomingPhoneNumber> getIncomingPhoneNumbersEndpoints() {
        return getEndpoints("incoming-phone-numbers", baseRestcommUrl + "/IncomingPhoneNumbers.json", IncomingPhoneNumber.class);
    }

    public RestEndpoints<XmppMapping> getXmppMappingsEndpoints() {
        return getEndpoints("xmpp-mappings", baseUrl + "/xmpp/xmppMappings", XmppMapping.class);
    }

    public RestEndpoints<ShortMessage> getShortMessagesEndpoints() {
        return getEndpoints("messages", baseRestcommUrl + "/SMS/Messages.json", ShortMessage.class);
    }

    public RestEndpoints<ShortMessage> getShortMessagesEndpoints(String subAccountSid) {
        return getEndpoints("messages", baseRestcommUrlWithoutAccount + "/" + subAccountSid + "/SMS/Messages.json",
                ShortMessage.class);
    }

    public RestEndpoints<ExtensionData> getExtensions() {
        return getEndpoints("extensions", baseUrl + "/restcomm/2012-04-24/ExtensionsConfiguration.json", ExtensionData.class);
    }

    private <T> RestEndpoints<T> getEndpoints(String endpoint, String defaultUrl, Class<T> type) {
        String url = endpoints.getOrDefault(endpoint, defaultUrl);
        return new RestEndpoints(url, httpClient, type);
    }
}
