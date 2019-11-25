package org.restcomm.sdk.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder(toBuilder = true)
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class XmppWhitelistRule implements Restful {
    private String id;
    
    @JsonProperty("ipAddress")
    private String ipAddress;

}
