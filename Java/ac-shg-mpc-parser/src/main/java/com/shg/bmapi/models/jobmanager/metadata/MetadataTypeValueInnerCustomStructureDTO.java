package com.shg.bmapi.models.jobmanager.metadata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MetadataTypeValueInnerCustomStructureDTO {
        /*
     "customStructure": {
        "id": 274,
                "parentId": null,
                "name": "PM_Visible",
                "label": {
            "default": "PM_Visible"
        },
     */

     Integer id;
     Integer parentId;
     String name;// TODO -- > Search Field ": "PM_Visible",
     MetadataLabelDTO label;
}
