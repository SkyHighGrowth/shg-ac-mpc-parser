package com.shg.bmapi.models.jobmanager;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CreateLinkManagedTaskDTO {
    String instanceId;
    String nodeId;
    String markerTypeId;
}
