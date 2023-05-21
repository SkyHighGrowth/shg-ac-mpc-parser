package com.shg.bmapi.models.jobmanager;


import com.shg.bmapi.enums.InheritFromParentEnum;

public class DseObjectValueDto {
    private InheritFromParentEnum inheritFromParent;
    private String inheritedValue;
    private String displayValue;
    private String value;

    public DseObjectValueDto() {
    }

    public DseObjectValueDto(String value, String displayValue, InheritFromParentEnum inheritFromParent, String inheritedValue) {
        this.value = value;
        this.displayValue = displayValue;
        this.inheritFromParent = inheritFromParent;
        this.inheritedValue = inheritedValue;
    }

    public InheritFromParentEnum getInheritFromParent() {
        return this.inheritFromParent;
    }

    public void setInheritFromParent(InheritFromParentEnum inheritFromParent) {
        this.inheritFromParent = inheritFromParent;
    }

    public String getInheritedValue() {
        return this.inheritedValue;
    }

    public void setInheritedValue(String inheritedValue) {
        this.inheritedValue = inheritedValue;
    }

    public String getDisplayValue() {
        return this.displayValue;
    }

    public void setDisplayValue(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

