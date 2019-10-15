package org.restcomm.sdk.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder(toBuilder = true)
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    private String sid;
    private String organization;
    private String friendlyName;
    private String emailAddress;
    private String password;
    private String status;
    private String role;
    private String type;
    private String dateCreated;
    private String dateUpdated;
    private String authToken;
    private String uri;

}
