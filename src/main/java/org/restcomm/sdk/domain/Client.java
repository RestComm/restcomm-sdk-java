package org.restcomm.sdk.domain;

import lombok.Builder;
import lombok.Getter;

/**
 * @author oleg.agafonov@telestax.com (Oleg Agafonov)
 */
@Builder(toBuilder = true)
@Getter
public class Client {

    private String sid;
    private String login;
    private String password;
    private String dateCreated;
    private String dateUpdated;
    private String friendlyName;
    private String accountSid;
    private String apiVersion;
    private Integer status;
    private String voiceUrl;
    private String voiceMethod;
    private String voiceFallbackUrl;
    private String voiceFallbackMethod;
    private String voiceApplicationSid;
    private String uri;
}
