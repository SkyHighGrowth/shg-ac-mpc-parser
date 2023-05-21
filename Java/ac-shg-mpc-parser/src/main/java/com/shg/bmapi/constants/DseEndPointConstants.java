package com.shg.bmapi.constants;

public class DseEndPointConstants {

    public static final String VALUES_KEY = "values";

    private DseEndPointConstants() {

    }

    public static final String DSE_REST = "/dse/rest";
    public static final String DSE_REST_V1 = DSE_REST + "/v1.0";
    public static final String DSE_REST_JOBS = DSE_REST_V1 + "/jobs";
    public static final String DSE_REST_JOBS_WITH_ID = DSE_REST_JOBS + "/%s";
    public static final String DSE_REST_JOBS_SEARCH = DSE_REST_JOBS + "/_search";

    public static final String DSE_REST_UI = DSE_REST + "/ui";
    public static final String DSE_REST_UI_OBJECTS = DSE_REST_UI + "/objects";
    public static final String DSE_REST_UI_OBJECTS_WITH_ID = DSE_REST_UI_OBJECTS + "/%s";
    public static final String DSE_REST_UI_OBJECTS_WITH_ID_CUSTOM_STRUCTURES = DSE_REST_UI_OBJECTS_WITH_ID + "/custom-structures";

    public static final String DSE_REST_DSE_OBJECT = DSE_REST_V1 + "/dse-object";
    public static final String DSE_REST_DSE_OBJECT_WITH_ID = DSE_REST_DSE_OBJECT + "/%s/0";

    public static final String DSE_REST_INTERNAL = DSE_REST + "/internal";
    public static final String DSE_REST_INTERNAL_DSE_OBJECT = DSE_REST_INTERNAL + "/dse-object";
    public static final String DSE_REST_INTERNAL_DSE_OBJECT_CREATE = DSE_REST_INTERNAL_DSE_OBJECT + "/create";
    public static final String DSE_REST_INTERNAL_DSE_OBJECT_UPDATE = DSE_REST_INTERNAL_DSE_OBJECT + "/update";


    public static final String MAPS_REST_TASKS_BY_ID = "/maps/rest/api/v3.10/task/node/%s";


    //CLEAR ALL BCS IS TOO HARD TO FOLLOW
    public static final String DSE_REST_I_JOBS_ID = "/dse/rest/v1.0/dse-object/%s/0";
    public static final String DSE_REST_1_JOBS_ORDINAL_NUMBER = "/dse/rest/v1.0/jobs/%s";

    public static final String DSE_REST_1_JOBS_CREATE = "/dse/rest/v1.0/jobs";
    public static final String DSE_REST_1_MAPL_LINK_TASK = "/dse/rest/v1.0/mapl/_link-managed-task";
    public static final String DSE_REST_1_JOBS_PROCESS_WORKFLOW_STEP = "/dse/rest/dse-object-process-workflow/process-workflow-step";

    public static final String DSE_REST_CREATE_PROCESS = "/dse/rest/v1/process-types/%s/process";
    public static final String REST_1_ADD_TRANSACTION = "/api/v1/view-transactions/transactions";
    public static final String REST_1_ADD_TRANSACTION_BULK = "/api/v1/view-transactions/batch";

    public static final String REST_ADM_USR_CURRENT = "/rest/administration/users/current";

    public static final String DSE_REST_INTERNAL_FIND_GRID_BY_ORIDINALID_AND_VARIABLEIID = "/dse/rest/internal/jobs/%s/grids/%s/rows";
    public static final String DSE_REST_CREATE_GRID_BY_ORIDINALID_AND_VARIABLEIID = "/dse/rest/v1.0/jobs/%s/grids/%s/rows";
    public static final String DSE_REST_UPDATE_GRID_BY_ORIDINALID_AND_VARIABLEIID_AND_ROWID ="/dse/rest/v1.0/jobs/%s/grids/%s/rows/%s";
    public static final String DSE_REST_FIND_PROCESS_TYPES_BY_JOB_TYPE_ID = "/dse/rest/v1/process-types/%s";

    public static final String DSE_REST_1_JM_TYPES = "/dse/rest/v1.0/job-manager/types";
    public static final String DATA_STRUCTURE_REST_CUSTOM_OBJECT_STRUCTURE = "/data-structures/rest/custom-object?customStructureName=%s";

    public static final String DSE_REST_WORKFLOW_UPDATE_STEP_ASSIGNEES ="/dse/rest/dse-object-process-workflow/update-workflow-step-assignees";



}