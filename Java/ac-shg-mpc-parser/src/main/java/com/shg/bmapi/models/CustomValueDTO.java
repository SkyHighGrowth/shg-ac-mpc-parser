package com.shg.bmapi.models;


import com.shg.bmapi.enums.InheritFromParentEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CustomValueDTO {

    private String inheritFromParent;
    private String value;
    private String technicalName;



}
