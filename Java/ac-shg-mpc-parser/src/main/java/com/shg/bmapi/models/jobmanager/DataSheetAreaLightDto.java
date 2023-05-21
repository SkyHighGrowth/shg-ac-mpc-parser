package com.shg.bmapi.models.jobmanager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DataSheetAreaLightDto implements Serializable {
    private List<String> variables = new ArrayList();

    public DataSheetAreaLightDto() {
    }

    public List<String> getVariables() {
        return this.variables;
    }

    public void setVariables(List<String> variables) {
        this.variables = variables;
    }
}
