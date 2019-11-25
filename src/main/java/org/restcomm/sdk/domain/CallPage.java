package org.restcomm.sdk.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * Represents a paginated set of Calls bound to an Account.
 *
 * @author Henrique Rosa (henrique.rosa@telestax.com) created on 21/05/2018
 * @see <a href=https://www.restcomm.com/docs/connect/api/calls-api.html#paging-information>Calls API</a>
 */
@Builder(toBuilder = true)
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CallPage extends AbstractPageHeader {

    private List<Call> calls;

}
