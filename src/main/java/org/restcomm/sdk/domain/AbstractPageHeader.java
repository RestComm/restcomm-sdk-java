package org.restcomm.sdk.domain;

import lombok.Getter;
import lombok.ToString;

/**
 * Common content of a paginated result entry.
 *
 * @author Henrique Rosa (henrique.rosa@telestax.com) created on 22/05/2018
 */
@Getter
@ToString
public abstract class AbstractPageHeader {

    protected int page;
    protected int numPages;
    protected int pageSize;
    protected int total;
    protected int start;
    protected int end;
    protected String uri;
    protected String firstPageUri;
    protected String previousPageUri;
    protected String nextPageUri;
    protected String lastPageUri;

}
