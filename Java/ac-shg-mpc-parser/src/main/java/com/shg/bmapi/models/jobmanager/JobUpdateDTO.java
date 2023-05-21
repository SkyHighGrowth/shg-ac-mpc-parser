package com.shg.bmapi.models.jobmanager;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.shg.bmapi.models.CustomValueDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JobUpdateDTO {

    private Integer instanceId;
    private Integer l10nLocaleId;
    private Integer stepNumber;
    private List<CustomValueDTO> values = new ArrayList<>();

    public JobUpdateDTO() {

    }

    public JobUpdateDTO(final Integer instanceId, final Integer l10nLocaleId, final Integer stepNumber,
                        final List<CustomValueDTO> values) {
        this.instanceId = instanceId;
        this.l10nLocaleId = l10nLocaleId;
        this.stepNumber = stepNumber;
        this.values = values;
    }

    public Integer getInstanceId() {
        return this.instanceId;
    }

    public JobUpdateDTO setInstanceId(final Integer instanceId) {
        this.instanceId = instanceId;
        return this;
    }

    public Integer getL10nLocaleId() {
        return this.l10nLocaleId;
    }

    public JobUpdateDTO setL10nLocaleId(final Integer l10nLocaleId) {
        this.l10nLocaleId = l10nLocaleId;
        return this;
    }

    public Integer getStepNumber() {
        return stepNumber;
    }

    public void setStepNumber(Integer stepNumber) {
        this.stepNumber = stepNumber;
    }

    //    public Integer getStepNumber() {
//        return this.stepNumber;
//    }
//
//    public JobUpdateDTO setStepNumber(final Integer stepNumber) {
//        this.stepNumber = stepNumber;
//        return this;
//    }

    public List<CustomValueDTO> getValues() {
        return this.values;
    }

    public JobUpdateDTO setValues(final List<CustomValueDTO> values) {
        this.values = values;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof JobUpdateDTO)) {
            return false;
        }
        JobUpdateDTO jobUpdateDTO = (JobUpdateDTO) o;
        return Objects.equals(instanceId, jobUpdateDTO.instanceId) &&
                Objects.equals(l10nLocaleId, jobUpdateDTO.l10nLocaleId) &&
                //Objects.equals(stepNumber, jobUpdateDTO.stepNumber) &&
                Objects.equals(values, jobUpdateDTO.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(instanceId, l10nLocaleId,  values);
    }

    @Override
    public String toString() {
        return "{" +
                " instanceId='" + getInstanceId() + "'" +
                ", l10nLocaleId='" + getL10nLocaleId() + "'" +
                //", stepNumber='" + getStepNumber() + "'" +
                ", values='" + getValues() + "'" +
                "}";
    }

}