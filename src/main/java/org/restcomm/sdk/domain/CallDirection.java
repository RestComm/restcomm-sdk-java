package org.restcomm.sdk.domain;

/**
 * Represents the direction of a call.
 * <p>
 * Possible values are inbound, outbound-api, and outbound-dial.
 *
 * @author Henrique Rosa (henrique.rosa@telestax.com) created on 21/05/2018
 * @see <a href=https://www.restcomm.com/docs/connect/api/calls-api.html#resource-properties>Call API</a>
 */
public enum CallDirection {

    INBOUND("inbound"), OUTBOUND_API("outbound-api"), OUTBOUND_DIAL("outbound-dial");

    private final String description;

    CallDirection(String description) {
        this.description = description;
    }

    public String description() {
        return description;
    }

    public static CallDirection fromDescription(String description) throws IllegalArgumentException {
        for (CallDirection value : values()) {
            if (value.description.equalsIgnoreCase(description)) {
                return value;
            }
        }
        throw new IllegalArgumentException("No such element matching description: " + description);
    }

}
