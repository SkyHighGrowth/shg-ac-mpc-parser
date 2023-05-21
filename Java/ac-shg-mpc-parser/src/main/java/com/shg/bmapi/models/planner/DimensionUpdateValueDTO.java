package com.shg.bmapi.models.planner;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DimensionUpdateValueDTO {
    private String value;
    private Integer weight;
    private Integer id;
    private Boolean inherited;
}
