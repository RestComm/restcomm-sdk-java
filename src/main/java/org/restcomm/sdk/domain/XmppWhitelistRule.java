package org.restcomm.sdk.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;

@Builder(toBuilder = true)
@Getter
public class XmppWhitelistRule implements Restful {

    @JsonProperty("ipAddress")
    private String ipAddress;

}
