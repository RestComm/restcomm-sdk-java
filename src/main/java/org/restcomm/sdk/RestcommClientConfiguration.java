package org.restcomm.sdk;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * @author oleg.agafonov@telestax.com (Oleg Agafonov)
 */
@Data
@NoArgsConstructor
@Builder(toBuilder = true)
@AllArgsConstructor
public class RestcommClientConfiguration {

    private String accountSid;

    private String accountToken;

    @Builder.Default
    private String baseUrl = "https://cloud.restcomm.com";

    @Builder.Default
    private Map<String, String> endpoints = new HashMap();
}
