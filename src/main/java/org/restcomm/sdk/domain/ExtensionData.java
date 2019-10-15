package org.restcomm.sdk.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder(toBuilder = true)
@Getter
@NoArgsConstructor
@AllArgsConstructor
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
