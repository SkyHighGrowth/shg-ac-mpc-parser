package com.shg.bmapi.models.jobmanager;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DataSheetLightDto implements Serializable {
    private String type;
    private String label;
    private String technicalName;
    private List<DataSheetSectionLightDto> sections = new ArrayList();

    public DataSheetLightDto() {
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<DataSheetSectionLightDto> getSections() {
        return this.sections;
    }

    public void setSections(List<DataSheetSectionLightDto> sections) {
        this.sections = sections;
    }

    public String getTechnicalName() {
        return this.technicalName;
    }

    public void setTechnicalName(String technicalName) {
        this.technicalName = technicalName;
    }
}
