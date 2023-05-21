package com.shg.bmapi.models.jobmanager;


import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.shg.bmapi.models.UserDTO;
import com.shg.bmapi.models.planner.ReadCustomValueDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class JobDTO {

    private Integer instanceId;
    private Integer l10nLocaleId;
    private Integer workflowObjectId;
    private String name;
    private String extendedName;
    private String state;
    private Integer ordinalNumber;
    private Integer typeId ;
    private UserDTO creator;
    private Integer workflowTypeId;
    private Integer currentStepTemplateId;
    private JobAssignmentDTO assignment;

    private Integer parentId;

    private Map<String, ReadCustomValueDTO> values = new HashMap<>();

}