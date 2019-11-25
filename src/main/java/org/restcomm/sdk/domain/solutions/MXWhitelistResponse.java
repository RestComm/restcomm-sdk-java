package org.restcomm.sdk.domain.solutions;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder(toBuilder = true)
@Data
@NoArgsConstructor
public class MXWhitelistResponse extends SolutionsResponse<MXWhitelist, MXWhitelistRequest> {
}
