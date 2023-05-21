package com.shg.bmapi.models.jobmanager;

import java.io.Serializable;

public class LabelValueDto implements Serializable {
    private Serializable label;
    private Serializable value;

    public LabelValueDto() {
    }

    public LabelValueDto(Serializable label, Serializable value) {
        this.label = label;
        this.value = value;
    }

    public Serializable getLabel() {
        return this.label;
    }

    public void setLabel(Serializable label) {
        this.label = label;
    }

    public Serializable getValue() {
        return this.value;
    }

    public void setValue(Serializable value) {
        this.value = value;
    }
}
