package com.shg.bmapi.models.planner;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ReadCustomValueDTO {

    private String technicalName;
    private String inheritFromParent;
    //private String inheritedValue;
    private  String displayValue;
    private String value;

}
