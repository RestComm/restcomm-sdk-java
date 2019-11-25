package org.restcomm.sdk.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * Represents a paginated set of Recording bound to an Account.
 *
 * @author Henrique Rosa (henrique.rosa@telestax.com) created on 22/05/2018
 * @see <a href=https://www.restcomm.com/docs/connect/api/recordings-api.html#paging-information>Recordings API</a>
 */
@Builder(toBuilder = true)
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RecordingPage extends AbstractPageHeader {

    private List<Recording> recordings;

}
