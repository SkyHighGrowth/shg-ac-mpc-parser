package com.shg.bmapi.models.jobmanager;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchParamsDTO {
    
    private List<SearchVariableConditionDTO> variableCondition = new ArrayList<>();

    public SearchParamsDTO() {

    }

    public SearchParamsDTO(List<SearchVariableConditionDTO> variableCondition) {
        this.variableCondition = variableCondition;
    }

    public List<SearchVariableConditionDTO> getVariableCondition() {
        return this.variableCondition;
    }

    public SearchParamsDTO setVariableCondition(final List<SearchVariableConditionDTO> variableCondition) {
        this.variableCondition = variableCondition;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof SearchParamsDTO)) {
            return false;
        }
        SearchParamsDTO searchParamsDTO = (SearchParamsDTO) o;
        return Objects.equals(variableCondition, searchParamsDTO.variableCondition);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(variableCondition);
    }

    @Override
    public String toString() {
        return "{" +
            " variableCondition='" + getVariableCondition() + "'" +
            "}";
    }

    public void setLimit(int i) {
    }


}
