package org.restcomm.sdk.domain.solutions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.restcomm.sdk.domain.Restful;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class MXWhitelistRequest implements Restful {
    private String ipAddress;
}
