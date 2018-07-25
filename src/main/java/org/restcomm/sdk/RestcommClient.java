package org.restcomm.sdk;

import java.util.HashMap;
import java.util.Map;

import org.restcomm.sdk.domain.Account;
import org.restcomm.sdk.domain.Application;
import org.restcomm.sdk.domain.CallPage;
import org.restcomm.sdk.domain.Client;
import org.restcomm.sdk.domain.ExtensionData;
import org.restcomm.sdk.domain.IncomingPhoneNumber;
import org.restcomm.sdk.domain.RecordingPage;
import org.restcomm.sdk.domain.ShortMessage;
import org.restcomm.sdk.domain.XmppMapping;
import org.restcomm.sdk.endpoints.RestEndpoints;

/**
 * @author oleg.agafonov@telestax.com (Oleg Agafonov)
 * @author sergey vetyutnev
 */
public class RestcommClient {

    private final HttpClient httpClient;

    protected final String baseRestcommUrl;
    protected final String baseRestcommUrlWithoutAccount;

    protected final String baseUrl;
    private final String accountSid;

    protected final Map<String, String> endpoints;

    public RestcommClient(RestcommClientConfiguration config) {
        this.httpClient = new HttpClient(config.getAccountSid(), config.getAccountToken());

        this.baseUrl = config.getBaseUrl();
        this.baseRestcommUrlWithoutAccount = baseUrl + "/restcomm/2012-04-24/Accounts";
        this.baseRestcommUrl = baseUrl + "/restcomm/2012-04-24/Accounts/" + config.getAccountSid();
        if (config.getEndpoints() != null)
            this.endpoints = config.getEndpoints();
        else
            this.endpoints = new HashMap<String, String>();
        this.accountSid = config.getAccountSid();
    }

    public String getAccountSid() {
        return this.accountSid;
    }

    public RestEndpoints<CallPage> getCallsEndpoint() {
        return getEndpoints("calls", baseRestcommUrl + "/Calls.json", CallPage.class);
    }

    public RestEndpoints<CallPage> getCallsEndpoint(String accountSid) {
        return getEndpoints("calls", baseRestcommUrlWithoutAccount + "/" + accountSid + "/Calls.json", CallPage.class);
    }

    public RestEndpoints<RecordingPage> getRecordingsEndpoint() {
        return getEndpoints("recordings", baseRestcommUrl + "/Recordings.json", RecordingPage.class);
    }

    public RestEndpoints<RecordingPage> getRecordingsEndpoint(String accountSid) {
        return getEndpoints("recordings", baseRestcommUrlWithoutAccount + "/" + accountSid + "/Recordings.json",
                RecordingPage.class);
    }

    public RestEndpoints<Client> getClientsEndpoints() {
        return getEndpoints("clients", baseRestcommUrl + "/Clients.json", Client.class);
    }

    public RestEndpoints<Account> getAccountsEndpoints() {
        return getEndpoints("accounts", baseRestcommUrlWithoutAccount + ".json", Account.class);
    }

    public RestEndpoints<Account> getAccountsEndpoints(String accountSid) {
        return getEndpoints("accounts", baseRestcommUrlWithoutAccount + ".json/" + accountSid, Account.class);
    }

    public RestEndpoints<Application> getApplicationsEndpoints() {
        return getEndpoints("applications", baseRestcommUrl + "/Applications.json", Application.class);
    }

    public RestEndpoints<Application> getApplicationsEndpoints(String accountSid) {
        return getEndpoints("applications", baseRestcommUrlWithoutAccount + "/" + accountSid + "/Applications.json",
                Application.class);
    }

    public RestEndpoints<IncomingPhoneNumber> getIncomingPhoneNumbersEndpoints() {
        return getEndpoints("incoming-phone-numbers", baseRestcommUrl + "/IncomingPhoneNumbers.json", IncomingPhoneNumber.class);
    }

    public RestEndpoints<IncomingPhoneNumber> getIncomingPhoneNumbersEndpoints(String accountSid) {
        return getEndpoints("incoming-phone-numbers", baseRestcommUrlWithoutAccount + "/" + accountSid
                + "/IncomingPhoneNumbers.json", IncomingPhoneNumber.class);
    }

    public RestEndpoints<XmppMapping> getXmppMappingsEndpoints() {
        return getEndpoints("xmpp-mappings", baseUrl + "/xmpp/xmppMappings", XmppMapping.class);
    }

    public RestEndpoints<ShortMessage> getShortMessagesEndpoints() {
        return getEndpoints("messages", baseRestcommUrl + "/SMS/Messages.json", ShortMessage.class);
    }

    public RestEndpoints<ShortMessage> getShortMessagesEndpoints(String accountSid) {
        return getEndpoints("messages", baseRestcommUrlWithoutAccount + "/" + accountSid + "/SMS/Messages.json",
                ShortMessage.class);
    }

    public RestEndpoints<ExtensionData> getExtensions() {
        return getEndpoints("extensions", baseUrl + "/restcomm/2012-04-24/ExtensionsConfiguration.json", ExtensionData.class);
    }

    protected <T> RestEndpoints<T> getEndpoints(String endpoint, String defaultUrl, Class<T> type) {
        String url = endpoints.getOrDefault(endpoint, defaultUrl);
        return new RestEndpoints(url, httpClient, type);
    }
}
