package org.restcomm.sdk.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

/**
 * @author Henrique Rosa (henrique.rosa@telestax.com) created on 21/05/2018
 */
@Builder(toBuilder = true)
@Getter
@ToString
public class CallPage {

    private int page;
    private int numPages;
    private int pageSize;
    private int total;
    private int start;
    private int end;
    private String uri;
    private String firstPageUri;
    private String previousPageUri;
    private String nextPageUri;
    private String lastPageUri;
    private List<Call> calls;

}
