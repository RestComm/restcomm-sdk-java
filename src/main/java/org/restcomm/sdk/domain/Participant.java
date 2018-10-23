package org.restcomm.sdk.domain;

import lombok.Builder;
import lombok.Getter;

@Builder(toBuilder = true)
@Getter
public class Participant {

    private String callSid;
    private String conferenceSid;
    private String dateCreated;
    private String dateUpdated;
    private String accountSid;
    private boolean muted;
    private boolean startConferenceOnEnter;
    private boolean endConferenceOnExit;
    private String uri;

    // action:
    private boolean mute;

}
