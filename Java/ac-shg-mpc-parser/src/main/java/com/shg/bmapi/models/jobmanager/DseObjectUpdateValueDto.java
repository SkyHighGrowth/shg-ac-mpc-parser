package com.shg.bmapi.models.jobmanager;


import com.shg.bmapi.enums.InheritFromParentEnum;

public class DseObjectUpdateValueDto {
    private InheritFromParentEnum inheritFromParent;
    private String value;
    private String technicalName;

    public DseObjectUpdateValueDto() {
        super();
    }

    public DseObjectUpdateValueDto(String technicalName, String value, InheritFromParentEnum inheritFromParent) {
        this.technicalName = technicalName;
        this.inheritFromParent = inheritFromParent;
        this.value = value;
    }

    public InheritFromParentEnum getInheritFromParent() {
        return this.inheritFromParent;
    }

    public void setInheritFromParent(InheritFromParentEnum inheritFromParent) {
        this.inheritFromParent = inheritFromParent;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getTechnicalName() {
        return this.technicalName;
    }

    public void setTechnicalName(String technicalName) {
        this.technicalName = technicalName;
    }
}
