package org.restcomm.sdk.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * A Call represents a connection between a phone or user agent and RestComm. This may be inbound or outbound.
 * The Calls list resource represents the set of phone calls originated and terminated from an account.
 *
 * @author Henrique Rosa (henrique.rosa@telestax.com) created on 21/05/2018
 * @see <a href=https://www.restcomm.com/docs/connect/api/calls-api.html#resource-properties>Calls API</a>
 */
@Builder(toBuilder = true)
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Call {

    private String sid;
    private String parentCallSid;
    private String dateCreated;
    private String dateUpdated;
    private String accountSid;
    private String from;
    private String to;
    private String phoneNumberSid;
    private String status;
    private String startTime;
    private String endTime;
    private int duration;
    private double price;
    private String direction;
    private String answeredBy;
    private String apiVersion;
    private String forwardFrom;
    private String callerName;
    private String uri;

}
