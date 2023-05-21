package com.shg.bmapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RolesDTO {
    //PimediasDTO PIMEDIA_PLANNING;
    String PIMEDIA_DATABASE;
    String TILE_VIEW;
    String JOB_MANAGER;
    String DASHBOARD;
    String REPORTING_CENTER;
    String REVIEW_MANAGER;
    String PIMEDIA_ORGANISATION;
    String TABLEAU;
}
