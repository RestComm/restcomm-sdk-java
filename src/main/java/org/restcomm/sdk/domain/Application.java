package org.restcomm.sdk.domain;

import lombok.Builder;
import lombok.Getter;

@Builder(toBuilder = true)
@Getter
public class Application {

    private String sid;
    private String dateCreated;
    private String dateUpdated;
    private String friendlyName;
    private String accountSid;
    private String apiVersion;
    private String voiceCallerIdLookup;
    private String uri;
    private String rcmlUrl;
    private String kind;

}
