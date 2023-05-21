package com.shg.bmapi.models.planner;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.shg.bmapi.models.jobmanager.metadata.MetadataTypeValueDTOCollection;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@AllArgsConstructor
@Getter
@Setter
public class DimensionPossibleValueCollectionDTO {
    List<DimensionPossibleValueDTO> values;

    public DimensionPossibleValueCollectionDTO() {
        values = new ArrayList<DimensionPossibleValueDTO>();
    }

    public String getValueFromId(Integer id) throws Exception {
        for (DimensionPossibleValueDTO dimensionPossibleValueDTO : values) {
            if (dimensionPossibleValueDTO.getValueId().equals(id)) {
                return dimensionPossibleValueDTO.getValue();
            }
        }
        throw new Exception("No Value in dimension found for ID: " + id.toString());
    }

    //    public Integer getIdFromValue(String aValue) throws Exception {
//        for(DimensionPossibleValueDTO dimensionPossibleValueDTO : values) {
//            if(dimensionPossibleValueDTO.getValue().equals(aValue)){
//                return dimensionPossibleValueDTO.getValueId();
//            }
//        }
//        throw new Exception("No ID in dimension found for  value: " + aValue);
//    }

}
