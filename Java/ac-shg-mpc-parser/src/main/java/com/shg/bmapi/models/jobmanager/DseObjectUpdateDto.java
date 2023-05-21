package com.shg.bmapi.models.jobmanager;



import java.util.List;

public class DseObjectUpdateDto {
    private Integer instanceId;
    private Integer l10nLocaleId;
    private Integer stepNumber;
    private List<DseObjectUpdateValueDto> values;

    public DseObjectUpdateDto() {
    }

    public DseObjectUpdateDto(Integer instanceId, Integer l10nLocaleId, Integer stepNumber, List<DseObjectUpdateValueDto> values) {
        this.instanceId = instanceId;
        this.l10nLocaleId = l10nLocaleId;
        this.stepNumber = stepNumber;
        this.values = values;
    }

    public Integer getInstanceId() {
        return this.instanceId;
    }

    public void setInstanceId(Integer instanceId) {
        this.instanceId = instanceId;
    }

    public Integer getL10nLocaleId() {
        return this.l10nLocaleId;
    }

    public void setL10nLocaleId(Integer l10nLocaleId) {
        this.l10nLocaleId = l10nLocaleId;
    }

    public Integer getStepNumber() {
        return this.stepNumber;
    }

    public void setStepNumber(Integer stepNumber) {
        this.stepNumber = stepNumber;
    }

    public List<DseObjectUpdateValueDto> getValues() {
        return this.values;
    }

    public void setValues(List<DseObjectUpdateValueDto> values) {
        this.values = values;
    }
}

