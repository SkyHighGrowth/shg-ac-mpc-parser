package com.shg.bmapi.models.jobmanager;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DseObjectTypeDto {
    private Integer id;
    private String technicalName;
    private String uniqueName;
    private String displayName;
    private String inheritance;
    private Integer parentTypeId;

    private List<BaseVariableTypeDto> variables;

}
