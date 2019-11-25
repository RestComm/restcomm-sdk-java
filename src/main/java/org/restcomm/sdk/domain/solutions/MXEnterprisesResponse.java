package org.restcomm.sdk.domain.solutions;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder(toBuilder = true)
@Data
@NoArgsConstructor
public class MXEnterprisesResponse extends SolutionsResponse<MXEnterprises, MXEnterpriseRequest> {
}
