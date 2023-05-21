package com.shg.bmapi.models.planner;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class NodeDTO {
    private Integer id;
    private Integer parentId;
    private String name;
    private String startDate;
    private String endDate;
    private NodeTypeDTO nodeType;
    private Integer nodeTypeId;
}
