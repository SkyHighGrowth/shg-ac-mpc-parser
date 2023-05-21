package com.shg.bmapi.models.planner;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@AllArgsConstructor
@Getter
@Setter
public class DefinedDimensionDTO {
   String name;
   String info;
   String type;
   Boolean readOnly;
   Boolean required;
   Boolean copyable;
   Boolean inheritable;
   Boolean archived;
   Boolean quickFilter;
   Integer id;
   DimensionPossibleValueCollectionDTO possibleValues;

   public DefinedDimensionDTO() {
      possibleValues = new DimensionPossibleValueCollectionDTO();
   }

   public Boolean hasMultipleValues()
   {
      return !possibleValues.getValues().isEmpty();
   }

   public Integer getIdFromValue(String aValue) throws Exception {
      for(DimensionPossibleValueDTO dimensionPossibleValueDTO : possibleValues.getValues()) {
         if(dimensionPossibleValueDTO.getValue().equals(aValue)){
            return dimensionPossibleValueDTO.getValueId();
         }
      }
      throw new Exception("No ID  found for  value:" + aValue + " in dimension -- > ID:" + id + " NAME: " + name);
   }


}

// {
//         "name": "HTSM Geo Reach",
//         "info": "",
//         "type": "SELECTABLE_DIMENSION_TYPE",
//         "readOnly": false,
//         "required": false,
//         "copyable": true,
//         "inheritable": true,
//         "archived": false,
//         "quickFilter": false,
//         "id": 1
//         },
