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
public class JobTypeCollectionDTO {
    List<JobTypeDTO> types;

    public JobTypeCollectionDTO()
    {
        types = new ArrayList<>();
    }
}
