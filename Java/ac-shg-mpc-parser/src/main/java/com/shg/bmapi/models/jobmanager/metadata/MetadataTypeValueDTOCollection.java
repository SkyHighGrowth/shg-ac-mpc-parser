package com.shg.bmapi.models.jobmanager.metadata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
//@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MetadataTypeValueDTOCollection {
    Integer totalCount;
    List<MetadataTypeValueDTO> data;

    public MetadataTypeValueDTOCollection(){
        data = new ArrayList<>();
    }
    public void addDataValue(MetadataTypeValueDTO valueDTO)
    {
        this.data.add(valueDTO);
    }
}
