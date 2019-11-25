package org.restcomm.sdk.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author oleg.agafonov@telestax.com (Oleg Agafonov)
 */
@Builder(toBuilder = true)
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class IncomingPhoneNumber {

    private String sid;
    private String phoneNumber;
    private String accountSid;
    private String friendlyName;
    private String dateCreated;
    private String dateUpdated;
    private String voiceUrl;
    private String voiceMethod;
    private String voiceFallbackUrl;
    private String voiceFallbackMethod;
    private String voiceCallerIdLookup;
    private String voiceApplicationSid;
    private String statusCallback;
    private String statusCallbackMethod;
    private String smsUrl;
    private String smsMethod;
    private String smsFallbackUrl;
    private String smsFallbackMethod;
    private String smsApplicationSid;
    private String apiVersion;
    @JsonProperty("isSIP")
    private Boolean isSIP;
    private String uri;
}
