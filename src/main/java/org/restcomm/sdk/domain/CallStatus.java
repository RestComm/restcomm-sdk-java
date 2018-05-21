package org.restcomm.sdk.domain;

/**
 * A string representing the status of the call.
 * <p>
 * Possible values are queued, ringing, in-progress, completed, failed, busy and no-answer.
 *
 * @author Henrique Rosa (henrique.rosa@telestax.com) created on 21/05/2018
 */
public enum CallStatus {

    QUEUED("queued"), RINGING("ringing"), IN_PROGRESS("in-progress"), COMPLETED("completed"), FAILED("failed"), BUSY("busy"), NO_ANSWER("no-answer");

    private final String description;

    CallStatus(String description) {
        this.description = description;
    }

    public String description() {
        return description;
    }

    public static CallStatus fromDescription(String description) throws IllegalArgumentException {
        for (CallStatus value : values()) {
            if (value.description.equalsIgnoreCase(description)) {
                return value;
            }
        }
        throw new IllegalArgumentException("No such element matching description: " + description);
    }

}
