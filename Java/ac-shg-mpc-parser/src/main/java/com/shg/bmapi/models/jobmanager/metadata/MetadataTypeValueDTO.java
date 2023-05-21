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
public class MetadataTypeValueDTO {
    /*
     {
            "id": 1397,
            "parentId": null,
            "name": "Show",
            "label": {
                "default": "Show"
            },
            "state": "EDIT_AND_ADD",
            "affiliate": null,
            "lastEditedUserId": -1,
            "attributeValues": null,
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
            "createDate": "2022-06-13T13:15:13Z",
            "updateDate": "2022-06-13T13:15:18Z"
        },
     */

    Integer id; // TODO: this has nothing to do with the ID of the DataType": 1397,
    Integer parentId;
    String name; // TODO: this sieems to be the values that must be mapped ": "Show",
    MetadataLabelDTO label;
    String state;
    String affiliate; // TODO : dont know what data type is this - > ": null,
    Integer lastEditedUserId;
    List<AttributeValueDTO> attributeValues; // TODO: this seems be a collection of something - > ": null,
    MetadataTypeValueCustomStructureDTO customStructure;
    String createDate; //": "2022-06-13T13:15:13Z",
    String updateDate; //": "2022-06-13T13:15:18Z"

    public String getAttributeValuesDimensionValue(String ident) {
        if (attributeValues == null) {
            return null;
        }
        for (int i = 0; i < attributeValues.size(); i++) {
            if (attributeValues.get(i).getAttributeName().equals(ident)) {
                return attributeValues.get(i).getValue();
            }
        }
        return null;
    }


    public MetadataTypeValueDTO getAttributeValuesDimensionDTO(String ident) {
        for (int i = 0; i < attributeValues.size(); i++) {
            if (attributeValues.get(i).getAttributeName().equals(ident)) {
                return this;
            }
        }
        return null;
    }
}
