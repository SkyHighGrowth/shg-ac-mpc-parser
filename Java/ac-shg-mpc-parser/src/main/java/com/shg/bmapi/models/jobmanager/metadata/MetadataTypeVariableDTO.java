package com.shg.bmapi.models.jobmanager.metadata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MetadataTypeVariableDTO {
    /*
    {
                "id": 3298,
                "metaTypeId": 9,
                "metaTypeName": "SingleSelectVariableType",
                "uniqueName": "visible",
                "displayName": "Visible",
                "technicalName": "visible",
                "rawLabel": "Visible",
                "mode": 1,
                "sharedLocale": false,
                "helpText": "",
                "system": false,
                "storageType": 1,
                "typeSpanning": true,
                "sourceCustomStructureName": "PM_Visible",
                "style": "0",
                "inheritFromParent": false,
                "interdependentCheckBox": false,
                "defaultValue": ""
            },

            https://elc.brandmaker.com/dse/rest/v1.0/job-manager/types
     */

    Integer id;
    Integer metaTypeId;
    String metaTypeName; // TODO : FILTER THIS ": "SingleSelectVariableType",
    String uniqueName;
    String technicalName; // TODO : try to use this to verify mapping table ": "visible",
    String rawLabel;
    Integer mode;
    Boolean sharedLocale;
    String helpText;
    Boolean system;
    Integer storageType;
    Boolean typeSpanning;
    String sourceCustomStructureName; // TODO: FK to request values!!1 ": "PM_Visible",
    String style;
    Boolean inheritFromParent;
    Boolean interdependentCheckBox;
    String defaultValue;
    MetadataTypeValueDTOCollection values; // TODO: to assemble in the response
}
