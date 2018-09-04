package org.restcomm.sdk.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

/**
 * @author oleg.agafonov@telestax.com (Oleg Agafonov)
 */
@Builder(toBuilder = true)
@Getter
public class XmppMapping implements Restful {

    private String id;
    @JsonProperty("jabberAddress")
    private String jabberAddress;
    @JsonProperty("externalAddress")
    private String externalAddress;
    @JsonProperty("domain")
    private String domain;
}
