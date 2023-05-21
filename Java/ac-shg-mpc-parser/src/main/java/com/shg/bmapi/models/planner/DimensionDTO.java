package com.shg.bmapi.models.planner;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DimensionDTO {
    String name;
    String info;
    String type;
    Boolean readOnly;
    Boolean required;
    Boolean copyable;
    Boolean inheritable;
    Boolean archived;
    Boolean quickFilter;
    Integer id;
}
