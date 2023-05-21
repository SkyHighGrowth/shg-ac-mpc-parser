package com.shg.bmapi.models.jobmanager;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchVariableConditionDTO {

    private String value;
    private String name;
    private String operator;
    private String cmpCondition;
    private String jobTypeUniqueName;

    public SearchVariableConditionDTO() {

    }

    public SearchVariableConditionDTO(final String value, final String name,
                                      final String operator, final String cmpCondition, final String jobTypeUniqueName) {
        this.value = value;
        this.name = name;
        this.operator = operator;
        this.cmpCondition = cmpCondition;
        this.jobTypeUniqueName = jobTypeUniqueName;
    }

    public String getValue() {
        return this.value;
    }

    public SearchVariableConditionDTO setValue(final String value) {
        this.value = value;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public SearchVariableConditionDTO setName(final String name) {
        this.name = name;
        return this;
    }

    public String getOperator() {
        return this.operator;
    }

    public SearchVariableConditionDTO setOperator(final String operator) {
        this.operator = operator;
        return this;
    }

    public String getCmpCondition() {
        return this.cmpCondition;
    }

    public SearchVariableConditionDTO setCmpCondition(final String cmpCondition) {
        this.cmpCondition = cmpCondition;
        return this;
    }

    public String getJobTypeUniqueName() {
        return this.jobTypeUniqueName;
    }

    public SearchVariableConditionDTO setJobTypeUniqueName(final String jobTypeUniqueName) {
        this.jobTypeUniqueName = jobTypeUniqueName;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof SearchVariableConditionDTO)) {
            return false;
        }
        SearchVariableConditionDTO searchVariableConditionDTO = (SearchVariableConditionDTO) o;
        return Objects.equals(value, searchVariableConditionDTO.value) &&
                Objects.equals(name, searchVariableConditionDTO.name) &&
                Objects.equals(operator, searchVariableConditionDTO.operator) &&
                Objects.equals(cmpCondition, searchVariableConditionDTO.cmpCondition) &&
                Objects.equals(jobTypeUniqueName, searchVariableConditionDTO.jobTypeUniqueName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, name, operator, cmpCondition, jobTypeUniqueName);
    }

    @Override
    public String toString() {
        return "{" +
            " value='" + getValue() + "'" +
            ", name='" + getName() + "'" +
            ", operator='" + getOperator() + "'" +
            ", cmpCondition='" + getCmpCondition() + "'" +
            ", jobTypeUniqueName='" + getJobTypeUniqueName() + "'" +
            "}";
    }

}
