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
public class MetadataTypeValueCustomStructureDTO {
    /*
     "customStructure": {
        "id": 274,
                "parentId": null,
                "name": "PM_Visible",
                "label": {
            "default": "PM_Visible"
        },
        "type": "DEFAULT",
                "defaultObjectId": null,
                "attributes": null,
                "affiliateType": "NON_AFFILIATE_STRUCTURE",
                "previewImageAttributeId": null,
                "createDate": "2022-06-13T13:14:08Z",
                "updateDate": "2022-06-13T13:14:54Z"
            },
     */

    MetadataTypeValueInnerCustomStructureDTO customStructure;
    String type;
    Integer defaultObjectId;
    List<Object> attributes; // TODO: this seems to be a collection of something -> ": null,
    String affiliateType;
    Integer previewImageAttributeId;
    String createDate;//": "2022-06-13T13:14:08Z",
    String updateDate;//": "2022-06-13T13:14:54Z"
}
