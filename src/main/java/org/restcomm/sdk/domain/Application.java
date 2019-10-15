package org.restcomm.sdk.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder(toBuilder = true)
@Getter
@NoArgsConstructor
@AllArgsConstructor
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
