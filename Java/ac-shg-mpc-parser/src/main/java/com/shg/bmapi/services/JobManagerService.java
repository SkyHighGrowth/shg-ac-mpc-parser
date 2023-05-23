package com.shg.bmapi.services;


import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.google.gson.Gson;
import com.shg.bmapi.configurations.properties.ConfigProperties;
import com.shg.bmapi.constants.DseEndPointConstants;
import com.shg.bmapi.models.CustomStructureDTO;
import com.shg.bmapi.models.jobmanager.*;
import com.shg.bmapi.models.jobmanager.metadata.JobTypeCollectionDTO;
import com.shg.bmapi.models.jobmanager.metadata.JobTypeDTO;
import com.shg.bmapi.models.jobmanager.metadata.MetadataTypeValueDTOCollection
;
import com.shg.bmapi.utils.HttpUtils;
import com.shg.bmapi.utils.JobUtils;
import com.shg.bmapi.utils.RestUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import lombok.var;

@Service
public class JobManagerService {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    private final ConfigProperties properties;

    private static final Logger LOGGER = LoggerFactory.getLogger(JobManagerService.class);


    public JobManagerService(final RestTemplate restTemplate, final ObjectMapper objectMapper,
                             final ConfigProperties properties) {

        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
        this.properties = properties;
    }

    public JobDTO getJobByOrdinalNumber(final int ordinalNumber) {

        final Map<Object, Object> responseBody = RestUtils.sendGetRequest(
                restTemplate,
                HttpUtils.createUrl(properties.getUrl(), String.format(DseEndPointConstants.DSE_REST_1_JOBS_ORDINAL_NUMBER, ordinalNumber))
        );

        return this.objectMapper.convertValue(responseBody, JobDTO.class);
    }

    public JobDTO getJobById(final int jobId) {

        final Map<Object, Object> responseBody = RestUtils.sendGetRequest(
                restTemplate,
                HttpUtils.createUrl(properties.getUrl(), String.format(DseEndPointConstants.DSE_REST_I_JOBS_ID, jobId))
        );

        return this.objectMapper.convertValue(responseBody, JobDTO.class);
    }

    public List<JobDTO> findJobBySearchParams(final SearchParamsDTO searchParams) {

        try {
            final Map<Object, Object> response = RestUtils.sendPostRequest(
                    restTemplate,
                    MediaType.APPLICATION_JSON,
                    HttpUtils.createUrl(properties.getUrl(), DseEndPointConstants.DSE_REST_JOBS_SEARCH),
                    searchParams
            );

            final Object jobs;
            if (response != null) {
                jobs = response.get(DseEndPointConstants.VALUES_KEY);
            } else {
                jobs = null;
            }


            return this.objectMapper.convertValue(
                    jobs,
                    TypeFactory.defaultInstance().constructCollectionType(List.class, JobDTO.class)
            );
        }
        catch (RuntimeException e)
        {
            LOGGER.error(e.getMessage(),e);
            return null;
        }
    }


    public JobDTO createJob(final JobCreateDTO jobCreateDTO) {

        final MultiValueMap<Object, Object> params = JobUtils.mapJobCreateRequest(jobCreateDTO);

        final Map<Object, Object> responseBody = RestUtils.sendPostRequest(
                restTemplate,
                MediaType.APPLICATION_FORM_URLENCODED,
                //HttpUtils.createUrl(properties.getUrl(), EndpointConstants.DSE_REST_1_JOBS_CREATE),
                HttpUtils.createUrl(properties.getUrl(), DseEndPointConstants.DSE_REST_INTERNAL_DSE_OBJECT_CREATE),
                params
        );

        return this.objectMapper.convertValue(responseBody, JobDTO.class);
    }

    public ManagedTaskDataDTO linkManagedTask(CreateLinkManagedTaskDTO createLinkManagedTaskDTO) {

        final MultiValueMap<Object, Object> params = JobUtils.linkManagedTaskCreateRequest(createLinkManagedTaskDTO);

        final Map<Object, Object> responseBody = RestUtils.sendPostRequest(
                restTemplate,
                MediaType.APPLICATION_FORM_URLENCODED,
                HttpUtils.createUrl(properties.getUrl(), DseEndPointConstants.DSE_REST_1_MAPL_LINK_TASK),
                params
        );

        return this.objectMapper.convertValue(responseBody, ManagedTaskDataDTO.class);
    }

    public ResponseEntity<Object> processWorkflowStep(JobDTO jobDTO) {

        final MultiValueMap<Object, Object> params = JobUtils.processWorkflowCreateRequest(jobDTO);

        final ResponseEntity<Object> responseBody = RestUtils.sendPostRequestREO(
                restTemplate,
                MediaType.APPLICATION_FORM_URLENCODED,
                HttpUtils.createUrl(properties.getUrl(), DseEndPointConstants.DSE_REST_1_JOBS_PROCESS_WORKFLOW_STEP),
                params
        );

        return responseBody;
    }

    public DseObjectDto createProcess(Integer parentId, String jobName, Integer creator) {
        CreateProcessValuesDto processValues = new CreateProcessValuesDto();
        processValues.setJob__name(jobName);

        Map<String, Integer> creatorData = new HashMap<>();
        creatorData.put("id", creator);
        processValues.setCreator__(creatorData);

        CreateProcessDto createProcessObject = new CreateProcessDto(parentId, processValues);
        ResponseEntity<?> dseObjectResponse=RestUtils.sendPostRequest2(restTemplate,MediaType.APPLICATION_JSON,HttpUtils.createUrl(properties.getUrl(),String.format(DseEndPointConstants.DSE_REST_CREATE_PROCESS, "6043")),new Gson().toJson(createProcessObject));
        if (dseObjectResponse != null) {
            return objectMapper.convertValue(dseObjectResponse.getBody(), DseObjectDto.class);
        }
        return null;
    }

    public DseObjectDto updateJob(final DseObjectUpdateDto dseObjectUpdateDto) {
        try {

            final Map<Object, Object> responseBody = RestUtils.sendPostRequest(
                    restTemplate,
                    MediaType.APPLICATION_JSON,
                    HttpUtils.createUrl(properties.getUrl(), DseEndPointConstants.DSE_REST_INTERNAL_DSE_OBJECT_UPDATE),
                    dseObjectUpdateDto
            );

            return this.objectMapper.convertValue(responseBody, DseObjectDto.class);
        }
        catch (RuntimeException e)
        {
            LOGGER.error(e.getMessage(),e);
            return null;
        }
    }

    public Collection<GridRowDto> getGridRowsByJobOrdinalIdAndVariableInstanceId(Integer ordinalId, Integer variableInstanceId)
    {
        try {
            final Collection<Object> responseBodyTypeDefinition = RestUtils.sendGetRequestCRT(
                    restTemplate,
                    HttpUtils.createUrl(properties.getUrl(), String.format(DseEndPointConstants.DSE_REST_INTERNAL_FIND_GRID_BY_ORIDINALID_AND_VARIABLEIID, ordinalId, variableInstanceId))
            );

            Collection<GridRowDto> gridRowDtoCollection=new ArrayList<>();
            for (Object item:responseBodyTypeDefinition
            ) {
                gridRowDtoCollection.add(this.objectMapper.convertValue(item, GridRowDto.class));
            }

            return gridRowDtoCollection;
        }
        catch (RuntimeException e)
        {
            LOGGER.error(e.getMessage(),e);
            return null;
        }

    }

    public DseObjectTypeDto getDseObjectTypesByJobTypeId(Integer jobTypeId)
    {
        Object object = RestUtils.sendGetRequestSO(restTemplate,HttpUtils.createUrl(properties.getUrl(),String.format(DseEndPointConstants.DSE_REST_FIND_PROCESS_TYPES_BY_JOB_TYPE_ID,jobTypeId)));
        return this.objectMapper.convertValue(object,DseObjectTypeDto.class);
    }

    public ComfortGridDto getComfortGridByJobTypeId(Integer jobTypeId)
    {
        Object object = RestUtils.sendGetRequestSO(restTemplate,HttpUtils.createUrl(properties.getUrl(),String.format(DseEndPointConstants.DSE_REST_FIND_PROCESS_TYPES_BY_JOB_TYPE_ID,jobTypeId)));
        return this.objectMapper.convertValue(object,ComfortGridDto.class);
    }


    public Boolean updateGridRowByJobOrdinalIdAndVariableInstanceIdAndRowId(String updatedGridDto, Integer ordinalId, Integer variableInstanceId, Integer rowInstanceId)
    {
        try {
            ResponseEntity<Object> response = RestUtils.sendPutRequest(restTemplate, MediaType.APPLICATION_JSON,
                    HttpUtils.createUrl(properties.getUrl(), String.format(DseEndPointConstants.DSE_REST_UPDATE_GRID_BY_ORIDINALID_AND_VARIABLEIID_AND_ROWID, ordinalId, variableInstanceId, rowInstanceId)), updatedGridDto);

            return this.objectMapper.convertValue(response.getBody(), Boolean.class);
        }
        catch (RuntimeException e)
        {
            return false;
        }
    }
    public GridRowDto createNewGridRowByJobOrdinalIdAndVariableInstanceId(Object updatedGridDto,Integer ordinalId,Integer variableInstanceId)
    {
        //System.out.println(new Gson().toJson(updatedGridDto));
        try {
            Object object = RestUtils.sendPostRequestREO(restTemplate, MediaType.APPLICATION_JSON,
                    HttpUtils.createUrl(properties.getUrl(), String.format(DseEndPointConstants.DSE_REST_CREATE_GRID_BY_ORIDINALID_AND_VARIABLEIID, ordinalId, variableInstanceId)), updatedGridDto);

            return this.objectMapper.convertValue(object, GridRowDto.class);
        }
        catch (RuntimeException e)
        {
            LOGGER.error(e.getMessage(),e);
            return null;
        }
    }

    // FROM OBJECT SERVICE
    public Map<String, List<CustomStructureDTO>> getCustomStructures(final JobDTO jobDTO) {

        final Map<Object, Object> response = RestUtils.sendGetRequest(
                restTemplate,
                HttpUtils.createUrl(this.properties.getUrl(), String.format(DseEndPointConstants.DSE_REST_UI_OBJECTS_WITH_ID_CUSTOM_STRUCTURES, jobDTO.getInstanceId()))
        );

        return this.objectMapper.convertValue(response, TypeFactory.defaultInstance().constructMapType(
                HashMap.class,
                this.objectMapper.constructType(String.class),
                TypeFactory.defaultInstance().constructCollectionType(List.class, CustomStructureDTO.class))
        );
    }


    public JobTypeCollectionDTO getAllJobTypeData()
    {
        // TODO GET EVERYTHING
        final List<Object> responseBodyTypeDefinition = RestUtils.sendGetRequestLRT(
                restTemplate,
                HttpUtils.createUrl(properties.getUrl(), DseEndPointConstants.DSE_REST_1_JM_TYPES)
        );

        JobTypeCollectionDTO result = new JobTypeCollectionDTO();

        for (var whatever:  responseBodyTypeDefinition) {
            JobTypeDTO jobTypeDTO = this.objectMapper.convertValue(whatever, JobTypeDTO.class);

            for (var variable : jobTypeDTO.getVariables()) {
                if (variable.getSourceCustomStructureName() != null) {
                    System.out.println("     Variable: " + variable.getSourceCustomStructureName());

                    final Map<Object, Object> responseBodyTypeVariable = RestUtils.sendGetRequest(
                            restTemplate,
                            HttpUtils.createUrl(properties.getUrl(), String.format(DseEndPointConstants.DATA_STRUCTURE_REST_CUSTOM_OBJECT_STRUCTURE, variable.getSourceCustomStructureName()))
                    );

                    MetadataTypeValueDTOCollection metadataTypeValueDTOCollection = this.objectMapper.convertValue(responseBodyTypeVariable, MetadataTypeValueDTOCollection.class);

                    variable.setValues(metadataTypeValueDTOCollection);
                }
            }

            result.getTypes().add(jobTypeDTO);
            System.out.println("JOB TYPE: " + jobTypeDTO.getDisplayName());

        }
        return  result;
    }

    public ResponseEntity<Object> updateJobCreator(Integer instanceId, Integer newOwnerId)
    {
        JobUpdateCreatorDTO jobUpdateCreatorDTO = new JobUpdateCreatorDTO();
        jobUpdateCreatorDTO.setDseObjectId(instanceId);
        jobUpdateCreatorDTO.setL10LocaleId(0);
        jobUpdateCreatorDTO.setComment("");
        jobUpdateCreatorDTO.setStepNumber(0);
        jobUpdateCreatorDTO.setUserGroupIds(-1);
        jobUpdateCreatorDTO.setAssigneeIds(newOwnerId);

        final MultiValueMap<Object, Object> params = JobUtils.updateJobCreatorCreateRequest(jobUpdateCreatorDTO);

        final ResponseEntity<Object> responseBody = RestUtils.sendPutRequest(
                restTemplate,
                MediaType.APPLICATION_FORM_URLENCODED,
                HttpUtils.createUrl(properties.getUrl(), DseEndPointConstants.DSE_REST_WORKFLOW_UPDATE_STEP_ASSIGNEES),
                params
        );

        return  responseBody;

    }

    public MetadataTypeValueDTOCollection getCustomStructureValuesByName(String name) {
        try {
            final Map<Object, Object> responseBodyTypeVariable = RestUtils.sendGetRequest(
                    restTemplate,
                    HttpUtils.createUrl(properties.getUrl(), String.format(DseEndPointConstants.DATA_STRUCTURE_REST_CUSTOM_OBJECT_STRUCTURE, name))
            );

            return this.objectMapper.convertValue(responseBodyTypeVariable, MetadataTypeValueDTOCollection.class);
        }
        catch (RuntimeException e)
        {
            LOGGER.error(e.getMessage(),e);
            return null;
        }
    }


}
