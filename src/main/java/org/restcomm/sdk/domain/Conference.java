package org.restcomm.sdk.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder(toBuilder = true)
@Getter
@NoArgsConstructor
@AllArgsConstructor
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
