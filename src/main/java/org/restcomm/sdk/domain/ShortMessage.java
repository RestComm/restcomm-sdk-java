package org.restcomm.sdk.domain;

import lombok.Builder;
import lombok.Getter;

@Builder(toBuilder = true)
@Getter
public class ShortMessage {

    private String sid;
    private String dateCreated;
    private String dateUpdated;
    private String dateSent;
    private String accountSid;
    private String from;
    private String to;
    private String body;
    private String status;
    private String direction;
    private String price;
    private String priceUnit;
    private String uri;
    private String error_code;
    private String error_message;

}
