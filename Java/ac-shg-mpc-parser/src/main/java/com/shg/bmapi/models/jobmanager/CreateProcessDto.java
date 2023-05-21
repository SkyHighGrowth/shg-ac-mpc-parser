package com.shg.bmapi.models.jobmanager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProcessDto {
    private Integer parent;
    private CreateProcessValuesDto values;
}
