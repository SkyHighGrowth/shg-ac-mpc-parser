package com.shg.bmapi.models.jobmanager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateProcessValuesDto {
    private String job__name;
    private Map<String, ?> creator__;
}
