package org.restcomm.sdk.domain;

import lombok.Builder;
import lombok.Getter;

@Builder(toBuilder = true)
@Getter
public class Conference {

    private String sid;
    private String friendlyName;
    private String status;
    private String dateCreated;
    private String dateUpdated;
    private String accountSid;
    private String apiVersion;
    private String uri;

}
