package com.shg.bmapi.models.jobmanager;



import java.util.List;

public class ComfortGridDto extends BaseVariableTypeDto {
    private static final long serialVersionUID = 7650508639282198251L;
    private List<ComfortGridColumnRestDto> columns;
    private Boolean prefilledFromParent;
    private String defaultValue;

    public ComfortGridDto() {
    }



    public List<ComfortGridColumnRestDto> getColumns() {
        return this.columns;
    }

    public void setColumns(List<ComfortGridColumnRestDto> columns) {
        this.columns = columns;
    }

    public Boolean getPrefilledFromParent() {
        return this.prefilledFromParent;
    }

    public void setPrefilledFromParent(Boolean prefilledFromParent) {
        this.prefilledFromParent = prefilledFromParent;
    }

    public String getDefaultValue() {
        return this.defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }
}
