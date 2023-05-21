package com.shg.bmapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomStructureDTO {

    private String label;
    private String value;
    private String parent;
    private Integer state;
    private List<CustomAttributesDTO> attributes;


    public CustomStructureDTO() {
    }

    public CustomStructureDTO(String label, String value, String parent, Integer state, List<CustomAttributesDTO> attributes) {
        this.label = label;
        this.value = value;
        this.parent = parent;
        this.state = state;
        this.attributes = attributes;
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getParent() {
        return this.parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public Integer getState() {
        return this.state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public List<CustomAttributesDTO> getAttributes() {
        return this.attributes;
    }

    public void setAttributes(List<CustomAttributesDTO> attributes) {
        this.attributes = attributes;
    }

    public CustomStructureDTO label(String label) {
        this.label = label;
        return this;
    }

    public CustomStructureDTO value(String value) {
        this.value = value;
        return this;
    }

    public CustomStructureDTO parent(String parent) {
        this.parent = parent;
        return this;
    }

    public CustomStructureDTO state(Integer state) {
        this.state = state;
        return this;
    }

    public CustomStructureDTO attributes(List<CustomAttributesDTO> attributes) {
        this.attributes = attributes;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CustomStructureDTO)) {
            return false;
        }
        CustomStructureDTO customStructureDTO = (CustomStructureDTO) o;
        return Objects.equals(label, customStructureDTO.label) && Objects.equals(value, customStructureDTO.value) && Objects.equals(parent, customStructureDTO.parent) && Objects.equals(state, customStructureDTO.state) && Objects.equals(attributes, customStructureDTO.attributes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label, value, parent, state, attributes);
    }

    @Override
    public String toString() {
        return "{" +
                " label='" + getLabel() + "'" +
                ", value='" + getValue() + "'" +
                ", parent='" + getParent() + "'" +
                ", state='" + getState() + "'" +
                ", attributes='" + getAttributes() + "'" +
                "}";
    }


}
