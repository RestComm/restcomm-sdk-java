package org.restcomm.sdk.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Represents a Recording bound to a Call.
 *
 * @author Henrique Rosa (henrique.rosa@telestax.com) created on 22/05/2018
 * @see <a href=https://www.restcomm.com/docs/connect/api/recordings-api.html#Recordings>Calls API</a>
 */
@Builder(toBuilder = true)
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Recording {

    private String sid;
    private String dateCreated;
    private String dateUpdated;
    private String accountSid;
    private String callSid;
    private double duration;
    private String apiVersion;
    private String uri;
    private String fileUri;

}
