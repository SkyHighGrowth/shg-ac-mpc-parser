package com.shg.bmapi.models.planner;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@AllArgsConstructor
@Getter
@Setter
public class DefinedDimensionCollectionDTO {
    List<DefinedDimensionDTO> values;

    public DefinedDimensionCollectionDTO() {
        this.values = new ArrayList<DefinedDimensionDTO>();
    }

    public DefinedDimensionDTO findDimensionByID(Integer dimensionID) throws Exception {
        for (DefinedDimensionDTO dim: values) {
            if(dim.id.equals(dimensionID))
                return dim;
        }
        throw new Exception("No dimension found with ID: " + dimensionID);
    }
}
