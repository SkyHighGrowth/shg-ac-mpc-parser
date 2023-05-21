package com.shg.bmapi.models.jobmanager;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GridRowDto {
    private Boolean isRowEditable;
    private Integer rowInstanceId;
    private Map<String, String> values;

    public GridRowDto() {
    }

    public Boolean getRowEditable() {
        return this.isRowEditable;
    }

    public void setRowEditable(Boolean rowEditable) {
        this.isRowEditable = rowEditable;
    }

    public Integer getRowInstanceId() {
        return this.rowInstanceId;
    }

    public void setRowInstanceId(Integer rowInstanceId) {
        this.rowInstanceId = rowInstanceId;
    }

    public Map<String, String> getValues() {
        return this.values;
    }

    public void setValues(Map<String, String> values) {
        this.values = values;
    }
}
