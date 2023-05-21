package com.shg.bmapi.models.planner;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DimensionValueDTO {
    String value;
    Integer weight;
    Integer id;
    boolean inherited;

    public DimensionValueDTO() {
    }

    public DimensionValueDTO(String value, Integer weight, Integer id, boolean inherited) {
        this.value = value;
        this.weight = weight;
        this.id = id;
        this.inherited = inherited;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isInherited() {
        return inherited;
    }

    public void setInherited(boolean inherited) {
        this.inherited = inherited;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DimensionValueDTO that = (DimensionValueDTO) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "DimensionValueDTO{" +
                "value='" + value + '\'' +
                ", weight=" + weight +
                ", id=" + id +
                ", inherited=" + inherited +
                '}';
    }
}
