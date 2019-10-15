package org.restcomm.sdk.domain.solutions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.restcomm.sdk.domain.Restful;

@Builder(toBuilder = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MXMappingRequest implements Restful {
    private String name;
    private String jabberAddress;
    private String externalAddress;
    private String enterpriseSid;
    private String domainSid;
}
