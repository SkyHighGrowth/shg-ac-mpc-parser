package com.shg.bmapi.models.planner;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.shg.bmapi.models.UserDTO;
import lombok.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TaskDTO {
    Integer id;
    String name;
    String date;
    TaskState state;
    Integer markerType;
    UserDTO responsibleUser;
    String info;
    Integer jobId;
    Integer nodeId;
}
