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
public class MXEnterprise {
    @JsonProperty("sid")
    private String sid;
    @JsonProperty("dateCreated")
    private String dateCreated;
    @JsonProperty("dateUpdated")
    private String dateUpdated;
    @JsonProperty("accountSid")
    private String accountSid;
    @JsonProperty("accountEmail")
    private String accountEmail;
    @JsonProperty("uri")
    private String uri;
    @JsonProperty("name")
    private String name;
    @JsonProperty("mappingsCount")
    private Integer mappingsCount;
}
