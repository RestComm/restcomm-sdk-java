package org.restcomm.sdk.domain.solutions;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.restcomm.sdk.domain.AbstractPageHeader;

import java.util.List;

@Builder(toBuilder = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MXMappings extends AbstractPageHeader {
    @JsonProperty("result")
    private List<MXMapping> mxMappings;
}
