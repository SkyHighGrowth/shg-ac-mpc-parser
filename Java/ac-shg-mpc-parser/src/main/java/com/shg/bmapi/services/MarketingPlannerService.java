package com.shg.bmapi.services;

import com.shg.bmapi.models.planner.DimensionDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shg.bmapi.configurations.properties.ConfigProperties;
import com.shg.bmapi.constants.DseEndPointConstants;
import com.shg.bmapi.constants.MapsEndPointsConstants;
import com.shg.bmapi.models.jobmanager.JobDTO;
import com.shg.bmapi.models.planner.*;
import com.shg.bmapi.utils.HttpUtils;
import com.shg.bmapi.utils.MapsUtils;
import com.shg.bmapi.utils.RestUtils;
import lombok.var;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class MarketingPlannerService {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;
    private final ConfigProperties properties;

    public MarketingPlannerService(final RestTemplate restTemplate, final ObjectMapper objectMapper,
                      final ConfigProperties properties) {

        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
        this.properties = properties;
    }

    /**
     * Get the job by provided Node ID
     *
     * @param id ID of the tree node
     * @return found {@link JobDTO}
     */
    public NodeTaskCollectionDTO getJobByNodeId(final Integer id) {

        final Map<Object, Object> responseBody = RestUtils.sendGetRequest(
                restTemplate,
                HttpUtils.createUrl(properties.getUrl(), String.format(DseEndPointConstants.MAPS_REST_TASKS_BY_ID, id))
        );

        return this.objectMapper.convertValue(responseBody, NodeTaskCollectionDTO.class);
    }

    public NodeDTO CreateNodeInPlanner(Integer parentNodeId,
                                    CreatePlannerNodeDTO createPlannerNodeDto) throws JsonProcessingException {
        final MultiValueMap<Object, Object> params = MapsUtils.mapMapsNodeCreateRequest(createPlannerNodeDto);

        final Map<Object, Object> responseBody = RestUtils.sendPostRequest(
                restTemplate,
                MediaType.APPLICATION_JSON,
                HttpUtils.createUrl(properties.getUrl(), String.format(MapsEndPointsConstants.MAPS_REST_API_1_NODE_CREATE_PARENT_ID, parentNodeId)),
                params.toSingleValueMap()
        );

       return this.objectMapper.convertValue(responseBody, NodeDTO.class);
    }

    public NodeDTO getNodeDataByID(final int nodeId) {

        final Map<Object, Object> responseBody = RestUtils.sendGetRequest(
                restTemplate,
                HttpUtils.createUrl(properties.getUrl(), String.format(MapsEndPointsConstants.MAPS_REST_API_1_NODE_DATA_BY_ID, nodeId))
        );

        return this.objectMapper.convertValue(responseBody, NodeDTO.class);
    }

    public DimensionDTO getDimensionById(final int dimId) {

        final Map<Object, Object> responseBody = RestUtils.sendGetRequest(
                restTemplate,
                HttpUtils.createUrl(properties.getUrl(), String.format(MapsEndPointsConstants.MAPS_REST_API_35_DIMENSIONS+"/%s", dimId))
        );

        return this.objectMapper.convertValue(responseBody, DimensionDTO.class);
    }

    //TODO: Finish CreatePeriod
    public ResponseEntity<Object> createPeriod(Integer nodeId,
                                    CreatePeriodDTO createPeriodDTO)
    {
        final MultiValueMap<Object, Object> params = MapsUtils.mapCreatePeriod(createPeriodDTO);

        final ResponseEntity<Object> responseBody = RestUtils.sendPostRequestREO(
                restTemplate,
                MediaType.APPLICATION_JSON,
                HttpUtils.createUrl(properties.getUrl(), String.format(MapsEndPointsConstants.MAPS_REST_API_1_CREATE_PERIOD_NODE_ID, nodeId)),
                params.toSingleValueMap()
        );

        return responseBody;
    }


    public ResponseEntity<Object> updateDimensions(Integer dimensionID, Integer nodeID,
                                 DimensionUpdateDTO dimensionUpdateDTO) throws JsonProcessingException {
        final List<Map<Object, Object>> params = MapsUtils.mapDimensionUpdate(dimensionUpdateDTO);

        final ResponseEntity<Object> responseBody = RestUtils.sendPutRequest(
                restTemplate,
                MediaType.APPLICATION_JSON,
                HttpUtils.createUrl(properties.getUrl(), String.format(MapsEndPointsConstants.MAPS_REST_API_1_UPDATE_DIMENSIONS_BY_NODE_ID,dimensionID, nodeID)),
                params
        );

        return  responseBody;
    }

    /**
     * Find Dimensions for a node ID
     *
     * @param nodeId Job create parameters
     * @return found {@link NodeDimensionDTO}
     */
    public NodeDimensionCollectionDTO getNodeDimensions(final int nodeId) {

        final List<Object> responseBody = RestUtils.sendGetRequestLRT(
                restTemplate,
                HttpUtils.createUrl(properties.getUrl(), String.format(MapsEndPointsConstants.MAPS_REST_API_35_DIMENSIONS_BY_NODE_ID, nodeId))
        );

        NodeDimensionCollectionDTO result = new NodeDimensionCollectionDTO();

        List<NodeDimensionDTO> nodeDimensionDTOList = new ArrayList<>();

        for (var whatever:  responseBody) {
            nodeDimensionDTOList.add(this.objectMapper.convertValue(whatever, NodeDimensionDTO.class));
        }

        result.setDimensions(nodeDimensionDTOList);

        return result;
    }

    public DefinedDimensionCollectionDTO getSystemDimensionsConfiguration()
    {
        // TODO GET EVERYTHING
        final List<Object> responseBodyDimDefinition = RestUtils.sendGetRequestLRT(
                restTemplate,
                HttpUtils.createUrl(properties.getUrl(), MapsEndPointsConstants.MAPS_REST_API_31_ALL_DIMENSIONS)
        );

        DefinedDimensionCollectionDTO result = new DefinedDimensionCollectionDTO();

        for (var whatever:  responseBodyDimDefinition) {
            DefinedDimensionDTO definedDimensionDTO = this.objectMapper.convertValue(whatever, DefinedDimensionDTO.class);

            final List<Object> responseBodyDimValues = RestUtils.sendGetRequestLRT(
                    restTemplate,
                    HttpUtils.createUrl(properties.getUrl(), String.format(MapsEndPointsConstants. MAPS_REST_API_1_DIM_ID_POSSIBLE_VALUES, definedDimensionDTO.getId()))
            );

            for (var anything:  responseBodyDimValues) {
                DimensionPossibleValueDTO dimensionPossibleValueDTO = this.objectMapper.convertValue(anything, DimensionPossibleValueDTO.class);
                definedDimensionDTO.getPossibleValues().getValues().add(dimensionPossibleValueDTO);
            }

            result.getValues().add(definedDimensionDTO);

        }
        return  result;
    }

    public DimensionPossibleValueCollectionDTO getDimesionPossibleValues(int dimId)
    {
        final List<Object> responseBodyDimValues = RestUtils.sendGetRequestLRT(
                restTemplate,
                HttpUtils.createUrl(properties.getUrl(), String.format(MapsEndPointsConstants. MAPS_REST_API_1_DIM_ID_POSSIBLE_VALUES, dimId))
        );
        DimensionPossibleValueCollectionDTO result=new DimensionPossibleValueCollectionDTO();
        List<DimensionPossibleValueDTO> possibleValuesDimensionList = new ArrayList<>();

        for (var item:  responseBodyDimValues) {
            possibleValuesDimensionList.add(this.objectMapper.convertValue(item, DimensionPossibleValueDTO.class));
        }

        result.setValues(possibleValuesDimensionList);

        return result;

    }





}
