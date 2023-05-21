package com.shg.bmapi.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomAttributesDTO {

    private String attributeId;
    private String type;
    private Integer order;
    private String name;
    private String label;
    private String value;


    public CustomAttributesDTO() {
    }

    public CustomAttributesDTO(String attributeId, String type, Integer order, String name, String label, String value) {
        this.attributeId = attributeId;
        this.type = type;
        this.order = order;
        this.name = name;
        this.label = label;
        this.value = value;
    }

    public String getAttributeId() {
        return this.attributeId;
    }

    public void setAttributeId(String attributeId) {
        this.attributeId = attributeId;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getOrder() {
        return this.order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
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

    public CustomAttributesDTO attributeId(String attributeId) {
        this.attributeId = attributeId;
        return this;
    }

    public CustomAttributesDTO type(String type) {
        this.type = type;
        return this;
    }

    public CustomAttributesDTO order(Integer order) {
        this.order = order;
        return this;
    }

    public CustomAttributesDTO name(String name) {
        this.name = name;
        return this;
    }

    public CustomAttributesDTO label(String label) {
        this.label = label;
        return this;
    }

    public CustomAttributesDTO value(String value) {
        this.value = value;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CustomAttributesDTO)) {
            return false;
        }
        CustomAttributesDTO customAttributesDTO = (CustomAttributesDTO) o;
        return Objects.equals(attributeId, customAttributesDTO.attributeId) && Objects.equals(type, customAttributesDTO.type) && Objects.equals(order, customAttributesDTO.order) && Objects.equals(name, customAttributesDTO.name) && Objects.equals(label, customAttributesDTO.label) && Objects.equals(value, customAttributesDTO.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(attributeId, type, order, name, label, value);
    }

    @Override
    public String toString() {
        return "{" +
                " attributeId='" + getAttributeId() + "'" +
                ", type='" + getType() + "'" +
                ", order='" + getOrder() + "'" +
                ", name='" + getName() + "'" +
                ", label='" + getLabel() + "'" +
                ", value='" + getValue() + "'" +
                "}";
    }

}