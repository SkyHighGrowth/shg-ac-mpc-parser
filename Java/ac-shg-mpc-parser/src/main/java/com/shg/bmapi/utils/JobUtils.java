package com.shg.bmapi.utils;

import com.shg.bmapi.constants.FieldNameConstants;
import com.shg.bmapi.models.TransactionLogsDTO;
import com.shg.bmapi.models.jobmanager.*;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class JobUtils {

    public static final Integer TACTICS_JOB_ID =  3625 ; // from: /dse/rest/v1.0/job-manager/available-job-types
    public static final Integer TACTICS_WORKFLOW_ID = 105 ; // from: /dse/rest/v1.0/job-manager/available-job-types

    private JobUtils() {

    }

    public static MultiValueMap<Object, Object> mapJobCreateRequest(final JobCreateDTO jobCreateDTO) {

        final MultiValueMap<Object, Object> result = new LinkedMultiValueMap<>();

        result.add(FieldNameConstants.DSE_OBJECT_TYPE_ID, jobCreateDTO.getDseObjectTypeId());
        result.add(FieldNameConstants.WORKFLOW_TYPE_ID, jobCreateDTO.getWorkflowTypeId());
        result.add(FieldNameConstants.JOB_NAME, jobCreateDTO.getName());
        result.add(FieldNameConstants.PARENT_JOB_ID, jobCreateDTO.getParentJobId());
        result.add(FieldNameConstants.L10LOCALEID, jobCreateDTO.getL10nLocaleId());

        return result;
    }

    public static MultiValueMap<Object, Object> linkManagedTaskCreateRequest(CreateLinkManagedTaskDTO createLinkManagedTaskDTO) {
        final MultiValueMap<Object, Object> result = new LinkedMultiValueMap<>();

        result.add("instanceId",createLinkManagedTaskDTO.getInstanceId());
        result.add("nodeId",createLinkManagedTaskDTO.getNodeId());
        result.add("markerId", createLinkManagedTaskDTO.getMarkerTypeId());

        return result;
    }

    public static MultiValueMap<Object, Object> updateJobCreatorCreateRequest(JobUpdateCreatorDTO jobUpdateCreatorDTO) {
        final MultiValueMap<Object, Object> result =  new LinkedMultiValueMap<>();

        result.add("dseObjectId", jobUpdateCreatorDTO.getDseObjectId().toString());
        result.add("l10nLocaleId",jobUpdateCreatorDTO.getL10LocaleId().toString());
        result.add("comment", jobUpdateCreatorDTO.getComment());
        result.add("stepNumber",  jobUpdateCreatorDTO.getStepNumber().toString());
        result.add("userGroupIds", jobUpdateCreatorDTO.getUserGroupIds().toString());
        result.add("assigneeIds", jobUpdateCreatorDTO.getAssigneeIds().toString());

        return result;
    }

    public static MultiValueMap<Object, Object> processWorkflowCreateRequest(JobDTO jobDTO) {
        final MultiValueMap<Object, Object> result = new LinkedMultiValueMap<>();

        result.add("dseObjectId",jobDTO.getInstanceId());
        result.add("l10nLocaleId",jobDTO.getL10nLocaleId());
        result.add("comment", "Automatic step processing");
        result.add("stepNumber", "1");
        result.add("assigneeIds", jobDTO.getCreator().getId().toString());

        return result;
    }

    public static MultiValueMap<Object, Object> mapAddTransaction(TransactionLogsDTO transactionLogsDTO) {
        final MultiValueMap<Object, Object> result = new LinkedMultiValueMap<>();

        result.add("component",transactionLogsDTO.getComponent());
        result.add("createdBy", transactionLogsDTO.getCreatedBy());
        result.add("transactionRequest",transactionLogsDTO.getTransactionRequest());
        result.add("resultStatusCode", transactionLogsDTO.getResultStatusCode());
        result.add("details", transactionLogsDTO.getDetails());

        return result;
    }

    public static MultiValueMap<Object, Object> mapProcessCreateRequest(final CreateProcessDto processCreateDTO) {

        final MultiValueMap<Object, Object> result = new LinkedMultiValueMap<>();

        result.add(FieldNameConstants.DSE_OBJECT_TYPE_ID, processCreateDTO.getParent());

        return result;
    }

}
