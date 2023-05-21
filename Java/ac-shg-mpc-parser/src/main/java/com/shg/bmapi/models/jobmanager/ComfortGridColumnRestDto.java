package com.shg.bmapi.models.jobmanager;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ComfortGridColumnRestDto {
    private Integer id;
    private Integer metaTypeId;
    private String metaTypeName;
    private String uniqueName;
    private String displayName;
    private String technicalName;
    private String rawLabel;

}
