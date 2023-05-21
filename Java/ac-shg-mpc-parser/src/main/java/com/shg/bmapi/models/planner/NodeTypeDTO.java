package com.shg.bmapi.models.planner;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class NodeTypeDTO {
    private Integer id;
    private String name;
    private String colour;
    private String backgroundColour;
    private Boolean bold;
    private Boolean italic;
    private Boolean active;
    private Boolean editable;
    private Integer icon;
}
