package org.restcomm.sdk.domain.solutions;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder(toBuilder = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MXMapping {
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
    @JsonProperty("jabberAddress")
    private String jabberAddress;
    @JsonProperty("externalAddress")
    private String externalAddress;
    @JsonProperty("enterpriseSid")
    private String enterpriseSid;
    @JsonProperty("name")
    private String name;
    @JsonProperty("enterpriseName")
    private String enterpriseName;
    @JsonProperty("domainSid")
    private String domainSid;
    @JsonProperty("domain")
    private String domain;

}
