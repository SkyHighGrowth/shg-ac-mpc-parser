package com.shg.bmapi.models.jobmanager;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ManagedTaskDataDTO {
    private Integer nodeId;
    private Integer id;
    private String name;

    //    private Date date;
    private String state;
    private Integer markerType;
}
