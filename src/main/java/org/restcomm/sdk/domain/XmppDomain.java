package org.restcomm.sdk.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;

@Builder(toBuilder = true)
@Getter
public class XmppDomain implements Restful {

    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("certificate")
    private String certificate;

}
