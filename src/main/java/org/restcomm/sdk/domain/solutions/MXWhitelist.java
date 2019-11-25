package org.restcomm.sdk.domain.solutions;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MXWhitelist {
    @JsonProperty("sid")
    private String sid;
    @JsonProperty("dateUpdated")
    private String dateUpdated;
    @JsonProperty("dateCreated")
    private String dateCreated;
    @JsonProperty("accountSid")
    private String accountSid;
    @JsonProperty("accountEmail")
    private String accountEmail;
    @JsonProperty("uri")
    private String uri;
    @JsonProperty("ipAddress")
    private String ipAddress;
}
