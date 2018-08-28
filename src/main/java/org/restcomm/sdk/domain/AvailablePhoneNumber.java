package org.restcomm.sdk.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Henrique Rosa (henrique.rosa@telestax.com) created on 27/08/2018
 */
@Builder(toBuilder = true)
@Getter
@Setter
public class AvailablePhoneNumber {

    private String friendlyName;
    private String phoneNumber;
    private String isoCountry;
    private String cost;
    private Boolean voiceCapable;
    private Boolean smsCapable;

}
