package org.restcomm.sdk.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Henrique Rosa (henrique.rosa@telestax.com) created on 27/08/2018
 */
@Builder(toBuilder = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AvailablePhoneNumber {

    @JsonProperty("friendlyName")
    private String friendlyName;
    @JsonProperty("phoneNumber")
    private String phoneNumber;
    @JsonProperty("isoCountry")
    private String isoCountry;
    private String cost;
    @JsonProperty("voiceCapable")
    private Boolean voiceCapable;
    @JsonProperty("smsCapable")
    private Boolean smsCapable;

}
