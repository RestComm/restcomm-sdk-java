package org.restcomm.sdk.domain.solutions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder(toBuilder = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SolutionsResponse<T, V> {
    private T data;
    private Integer code;
    private String message;

    @JsonIgnore
    private V entity;
}
