package com.shg.bmapi.models.jobmanager;

import java.util.Map;

public class UpdateGridRowDto {
    private Map<String, String> values;

    public UpdateGridRowDto() {
    }

    public Map<String, String> getValues() {
        return this.values;
    }

    public void setValues(Map<String, String> values) {
        this.values = values;
    }
}
