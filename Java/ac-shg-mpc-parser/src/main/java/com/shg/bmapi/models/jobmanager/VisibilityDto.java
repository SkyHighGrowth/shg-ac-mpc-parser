package com.shg.bmapi.models.jobmanager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class VisibilityDto implements Serializable {
    private static final long serialVersionUID = 7419098328807937146L;
    private Integer variableId;
    private List<String> values = new ArrayList();

    public VisibilityDto() {
    }

    public Integer getVariableId() {
        return this.variableId;
    }

    public void setVariableId(Integer variableId) {
        this.variableId = variableId;
    }

    public List<String> getValues() {
        return this.values;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }
}
