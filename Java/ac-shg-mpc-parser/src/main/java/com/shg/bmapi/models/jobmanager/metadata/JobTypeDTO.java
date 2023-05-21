package com.shg.bmapi.models.jobmanager.metadata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class JobTypeDTO {
    /*
      "id": 3313,
        "technicalName": "runway_programs_1",
        "uniqueName": "caprograms",
        "displayName": "CA Programs",
        "respectRestrictionsByOrgUnits": false,
        "inheritance": "MULTIPLE_PARENTS",
        "forSubJobsOnly": false,
        "variables": [
     */
      Integer id;//": 3313,
      String technicalName; //": "runway_programs_1",
      String uniqueName; //": "caprograms",
      String displayName; //": "CA Programs",
      Boolean respectRestrictionsByOrgUnits; //": false,
      String inheritance; //": "MULTIPLE_PARENTS",
      Boolean forSubJobsOnly; //": false,
      List<MetadataTypeVariableDTO> variables;//        "variables": [
}
