package org.restcomm.sdk.domain;

import lombok.Builder;
import lombok.Getter;

@Builder(toBuilder = true)
@Getter
public class ExtensionData {

    private String extensionName;
    private String enabled;
    private String accountSid;
    private String configurationData;

    // back data
    private String sid;
    private String extension;
    private String configuration;
    private String dateCreated;
    private String dateUpdated;

}
