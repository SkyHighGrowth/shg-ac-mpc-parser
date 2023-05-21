package com.shg.bmapi.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.shg.bmapi.constants.FieldNameConstants;
import com.shg.bmapi.models.planner.CreatePeriodDTO;
import com.shg.bmapi.models.planner.CreatePlannerNodeDTO;
import com.shg.bmapi.models.planner.DimensionUpdateDTO;
import com.shg.bmapi.models.planner.DimensionUpdateValueDTO;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class MapsUtils {

    private MapsUtils() {
        
    }

    public static MultiValueMap<Object, Object> mapMapsNodeCreateRequest(final CreatePlannerNodeDTO createPlannerNodeDTO) throws JsonProcessingException {

        final MultiValueMap<Object, Object> result = new LinkedMultiValueMap<>();
        result.add(FieldNameConstants.NODE_NAME, createPlannerNodeDTO.getName());
        result.add(FieldNameConstants.NODE_TYPE_ID, createPlannerNodeDTO.getNodeTypeId());

        return result;
    }

    public static MultiValueMap<Object, Object> mapCreatePeriod(CreatePeriodDTO createPeriodDTO) {
        final MultiValueMap<Object, Object> result = new LinkedMultiValueMap<>();

        result.add("startDate",createPeriodDTO.getStartDate());
        result.add("endDate", createPeriodDTO.getEndDate());
        result.add("categoryId",createPeriodDTO.getCategoryId());
        result.add("name", createPeriodDTO.getName());

        return result;
    }

    public static List<Map<Object, Object>> mapDimensionUpdate(DimensionUpdateDTO dimensionUpdateDTO) throws JsonProcessingException {

        ArrayList<Map<Object, Object>> result = new ArrayList();

        for (DimensionUpdateValueDTO dimensionValueUpdateDTO: dimensionUpdateDTO.getValues()) {

            final MultiValueMap<Object, Object> valueObject = new LinkedMultiValueMap<>();

            valueObject.add("value", dimensionValueUpdateDTO.getValue());//objectMapper.writeValueAsString(dimensionValueUpdateDTO.getValue()));
            valueObject.add("weight", dimensionValueUpdateDTO.getWeight());
            valueObject.add("id", dimensionValueUpdateDTO.getId());
            valueObject.add("inherited", dimensionValueUpdateDTO.getInherited());

            result.add(valueObject.toSingleValueMap());
        }
        return result;
    }
}
