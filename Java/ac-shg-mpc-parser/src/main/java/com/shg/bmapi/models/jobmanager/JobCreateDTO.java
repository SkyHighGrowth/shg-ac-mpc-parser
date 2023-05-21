package com.shg.bmapi.models.jobmanager;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
public class JobCreateDTO {

    private Integer dseObjectTypeId;
    private Integer workflowTypeId;
    private String name;
    private Integer parentJobId;

    private Integer l10nLocaleId;

}
