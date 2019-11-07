package org.restcomm.sdk;

import org.restcomm.sdk.domain.Account;
import org.restcomm.sdk.domain.Application;
import org.restcomm.sdk.domain.AvailablePhoneNumber;
import org.restcomm.sdk.domain.CallPage;
import org.restcomm.sdk.domain.Client;
import org.restcomm.sdk.domain.Conference;
import org.restcomm.sdk.domain.ConferencePage;
import org.restcomm.sdk.domain.ExtensionData;
import org.restcomm.sdk.domain.IncomingPhoneNumber;
import org.restcomm.sdk.domain.RecordingPage;
import org.restcomm.sdk.domain.ShortMessage;
import org.restcomm.sdk.domain.XmppDomain;
import org.restcomm.sdk.domain.XmppMapping;
import org.restcomm.sdk.domain.XmppWhitelistRule;
import org.restcomm.sdk.domain.solutions.MXEnterpriseResponse;
import org.restcomm.sdk.domain.solutions.MXEnterprisesResponse;
import org.restcomm.sdk.endpoints.RestEndpoints;
import org.restcomm.sdk.domain.solutions.MXDomainResponse;
import org.restcomm.sdk.domain.solutions.MXDomainsResponse;
import org.restcomm.sdk.domain.solutions.MXMappingResponse;
import org.restcomm.sdk.domain.solutions.MXMappingsResponse;
import org.restcomm.sdk.domain.solutions.MXWhitelistResponse;
import org.restcomm.sdk.domain.solutions.MXWhitelistsResponse;

import java.util.Collections;
import java.util.Map;

/**
 * @author oleg.agafonov@telestax.com (Oleg Agafonov)
 * @author sergey vetyutnev
 */
public class RestcommClient {

    private final HttpClient httpClient;

    private final String baseRestcommUrlWithoutAccount;

    private final String baseUrl;
    private final String accountSid;

    private final Map<String, String> endpoints;

    public RestcommClient(RestcommClientConfiguration config) {
        this.httpClient = new HttpClient(config.getAccountSid(), config.getAccountToken());

        this.baseUrl = config.getBaseUrl();
        this.baseRestcommUrlWithoutAccount = baseUrl + "/restcomm/2012-04-24/Accounts";
        if (config.getEndpoints() != null)
            this.endpoints = config.getEndpoints();
        else
            this.endpoints = Collections.emptyMap();
        this.accountSid = config.getAccountSid();
    }

    public String getAccountSid() {
        return this.accountSid;
    }

    public RestEndpoints<CallPage> getCallsEndpoint() {
        return getCallsEndpoint("calls", this.accountSid);
    }

    public RestEndpoints<CallPage> getCallsEndpoint(String accountSid) {
        return getCallsEndpoint("calls-" + accountSid, accountSid);
    }

    private RestEndpoints<CallPage> getCallsEndpoint(String endpoint, String accountSid) {
        return getEndpoints(endpoint, baseRestcommUrlWithoutAccount + "/" + accountSid + "/Calls.json", CallPage.class);
    }

    public RestEndpoints<RecordingPage> getRecordingsEndpoint() {
        return getRecordingsEndpoint("recordings", this.accountSid);
    }

    public RestEndpoints<RecordingPage> getRecordingsEndpoint(String accountSid) {
        return getRecordingsEndpoint("recordings-" + accountSid, accountSid);
    }

    private RestEndpoints<RecordingPage> getRecordingsEndpoint(String endpoint, String accountSid) {
        return getEndpoints(endpoint, baseRestcommUrlWithoutAccount + "/" + accountSid + "/Recordings.json",
                RecordingPage.class);
    }

    public RestEndpoints<Client> getClientsEndpoints() {
        return getClientsEndpoints("clients", this.accountSid);
    }

    public RestEndpoints<Client> getClientsEndpoints(String accountSid) {
        return getClientsEndpoints("clients-" + accountSid, accountSid);
    }

    private RestEndpoints<Client> getClientsEndpoints(String endpoint, String accountSid) {
        return getEndpoints(endpoint, baseRestcommUrlWithoutAccount + "/" + accountSid + "/Clients.json", Client.class);
    }

    public RestEndpoints<Account> getAccountsEndpoints() {
        return getEndpoints("accounts", baseRestcommUrlWithoutAccount + ".json", Account.class);
    }

    public RestEndpoints<Account> getAccountsEndpoints(String accountSid) {
        return getEndpoints("accounts-" + accountSid, baseRestcommUrlWithoutAccount + ".json/" + accountSid, Account.class);
    }

    public RestEndpoints<Application> getApplicationsEndpoints() {
        return getApplicationsEndpoints("applications", this.accountSid);
    }

    public RestEndpoints<Application> getApplicationsEndpoints(String accountSid) {
        return getApplicationsEndpoints("applications-" + accountSid, accountSid);
    }

    private RestEndpoints<Application> getApplicationsEndpoints(String endpoint, String accountSid) {
        return getEndpoints(endpoint, baseRestcommUrlWithoutAccount + "/" + accountSid + "/Applications.json",
                Application.class);
    }

    public RestEndpoints<AvailablePhoneNumber> getAvailablePhoneNumbersEndpoints() {
        return getAvailablePhoneNumbersEndpoints("available-phone-numbers", this.accountSid);
    }

    public RestEndpoints<AvailablePhoneNumber> getAvailablePhoneNumbersEndpoints(String accountSid) {
        return getAvailablePhoneNumbersEndpoints("available-phone-numbers-" + accountSid, accountSid);
    }

    private RestEndpoints<AvailablePhoneNumber> getAvailablePhoneNumbersEndpoints(String endpoint, String accountSid) {
        // FIXME Hard-coded U.S. country ISO in URL
        return getEndpoints(endpoint, baseRestcommUrlWithoutAccount + "/" + accountSid + "/AvailablePhoneNumbers/US/Local.json", AvailablePhoneNumber.class);
    }

    public RestEndpoints<IncomingPhoneNumber> getIncomingPhoneNumbersEndpoints() {
        return getIncomingPhoneNumbersEndpoints("incoming-phone-numbers", this.accountSid);
    }

    public RestEndpoints<IncomingPhoneNumber> getIncomingPhoneNumbersEndpoints(String accountSid) {
        return getIncomingPhoneNumbersEndpoints("incoming-phone-numbers-" + accountSid, accountSid);
    }

    private RestEndpoints<IncomingPhoneNumber> getIncomingPhoneNumbersEndpoints(String endpoint, String accountSid) {
        return getEndpoints(endpoint, baseRestcommUrlWithoutAccount + "/" + accountSid + "/IncomingPhoneNumbers.json",
                IncomingPhoneNumber.class);
    }

    public RestEndpoints<XmppMapping> getXmppMappingsEndpoints() {
        return getEndpoints("xmpp-mappings", baseUrl + "/xmpp/xmppMappings", XmppMapping.class);
    }

    public RestEndpoints<XmppDomain> getXmppDomainsEndpoints() {
        return getEndpoints("xmpp-domain", baseUrl + "/xmpp/domains", XmppDomain.class);
    }

    public RestEndpoints<XmppWhitelistRule> getXmppWhitelistRulesEndpoints() {
        return getEndpoints("xmpp-whitelistRules", baseUrl + "/xmpp/whitelistRules", XmppWhitelistRule.class);
    }

    public RestEndpoints<MXMappingResponse> getMXMappingsEndpoints() {
        return getEndpoints("mx-mappings", baseUrl + "/messageexchange/mappings", MXMappingResponse.class);
    }

    public RestEndpoints<MXMappingsResponse> getMXMappingsSearchEndpoints() {
        return getEndpoints("mx-mappings-search", baseUrl + "/messageexchange/mappings/search", MXMappingsResponse.class);
    }

    public RestEndpoints<MXDomainResponse> getMxDomainsEndpoints() {
        return getEndpoints("mx-domain", baseUrl + "/messageexchange/domains", MXDomainResponse.class);
    }

    public RestEndpoints<MXDomainsResponse> getXmppDomainsSearchEndpoints() {
        return getEndpoints("mx-domain-search", baseUrl + "/messageexchange/domains/search", MXDomainsResponse.class);
    }

    public RestEndpoints<MXWhitelistResponse> getMXWhitelistRulesEndpoints() {
        return getEndpoints("mx-whitelistRules", baseUrl + "/messageexchange/whitelist", MXWhitelistResponse.class);
    }

    public RestEndpoints<MXWhitelistsResponse> getMXWhitelistRulesSearchEndpoints() {
        return getEndpoints("mx-whitelistRules-search", baseUrl + "/messageexchange/whitelist/search", MXWhitelistsResponse.class);
    }

    public RestEndpoints<MXEnterpriseResponse> getMXEnterpriseEndpoints() {
        return getEndpoints("mx-enterprise", baseUrl + "/messageexchange/enterprise", MXEnterpriseResponse.class);
    }

    public RestEndpoints<MXEnterprisesResponse> getMXEnterprisesSearchEndpoints() {
        return getEndpoints("mx-enterprise-search", baseUrl + "/messageexchange/enterprise/search", MXEnterprisesResponse.class);
    }

    public RestEndpoints<ShortMessage> getShortMessagesEndpoints() {
        return getShortMessagesEndpoints("messages", this.accountSid);
    }

    public RestEndpoints<ShortMessage> getShortMessagesEndpoints(String accountSid) {
        return getShortMessagesEndpoints("messages-" + accountSid, accountSid);
    }

    private RestEndpoints<ShortMessage> getShortMessagesEndpoints(String endpoint, String accountSid) {
        return getEndpoints(endpoint, baseRestcommUrlWithoutAccount + "/" + accountSid + "/SMS/Messages.json",
                ShortMessage.class);
    }

    public RestEndpoints<Conference> getConferenceEndpoints() {
        return getConferenceEndpoints("conference", this.accountSid);
    }

    public RestEndpoints<Conference> getConferenceEndpoints(String accountSid) {
        return getConferenceEndpoints("conference-" + accountSid, accountSid);
    }

    private RestEndpoints<Conference> getConferenceEndpoints(String endpoint, String accountSid) {
        return getEndpoints(endpoint, baseRestcommUrlWithoutAccount + "/" + accountSid + "/Conferences.json",
                Conference.class);
    }

    public RestEndpoints<ConferencePage> getConferencesEndpoints() {
        return getConferencesEndpoints("conferences", this.accountSid);
    }

    public RestEndpoints<ConferencePage> getConferencesEndpoints(String accountSid) {
        return getConferencesEndpoints("conferences-" + accountSid, accountSid);
    }

    private RestEndpoints<ConferencePage> getConferencesEndpoints(String endpoint, String accountSid) {
        return getEndpoints(endpoint, baseRestcommUrlWithoutAccount + "/" + accountSid + "/Conferences.json",
                ConferencePage.class);
    }

//    public RestEndpoints<Participant> getParticipantsEndpoints(String conferenceSid) {
//        return getParticipantsEndpoints("participants-" + conferenceSid, this.accountSid, conferenceSid);
//    }
//
//    public RestEndpoints<Participant> getParticipantsEndpoints(String accountSid, String conferenceSid) {
//        return getParticipantsEndpoints("participants-" + conferenceSid + "-" + accountSid, accountSid, conferenceSid);
//    }
//
//    private RestEndpoints<Participant> getParticipantsEndpoints(String endpoint, String accountSid, String conferenceSid) {
//        return getEndpoints(endpoint, baseRestcommUrlWithoutAccount + "/" + accountSid + "/Conferences/" + conferenceSid
//                + "/Participants.json", Participant.class);
//    }

    public RestEndpoints<ExtensionData> getExtensions() {
        return getEndpoints("extensions", baseUrl + "/restcomm/2012-04-24/ExtensionsConfiguration.json", ExtensionData.class);
    }

    private <T> RestEndpoints<T> getEndpoints(String endpoint, String defaultUrl, Class<T> type) {
        String url = endpoints.getOrDefault(endpoint, defaultUrl);
        return new RestEndpoints(url, httpClient, type);
    }
}
