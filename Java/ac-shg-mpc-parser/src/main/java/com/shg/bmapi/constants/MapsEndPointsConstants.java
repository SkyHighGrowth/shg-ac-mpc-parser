

package com.shg.bmapi.constants;

public class MapsEndPointsConstants {

    public static final String MAPS_REST_API_1_NODE_CREATE_PARENT_ID = "/maps/rest/api/v1.0/node/%s";

    public static final String MAPS_REST_API_1_NODE_DATA_BY_ID=  "/maps/rest/api/v1.0/node/%s";

    public static final String MAPS_REST_API_1_CREATE_PERIOD_NODE_ID = "/maps/rest/api/v1.0/period/node/%s";

    //TODO: duplicated remove after moving the other one here
    public static final String MAPS_REST_API_35_DIMENSIONS = "/maps/rest/api/v3.5/dimension";
    public static final String MAPS_REST_API_35_DIMENSIONS_BY_DIM_ID = "/maps/rest/api/v3.5/dimension/%s";
    public static final String MAPS_REST_API_35_DIMENSIONS_BY_NODE_ID = "/maps/rest/api/v3.5/dimension/node/%s";

    public static final String MAPS_REST_API_1_UPDATE_DIMENSIONS_BY_NODE_ID = "/maps/rest/api/v1.0/dimension/%s/node/%s";

    public static final String MAPS_REST_API_31_ALL_DIMENSIONS = "/maps/rest/api/v3.10/dimension?includeArchived=true";

    public static final String MAPS_REST_API_1_DIM_ID_POSSIBLE_VALUES = "/maps/rest/api/v1.0/dimension/%s/possible-values";

    public static final String MAPS_UI_API="/maps/ui";

    public static final String MAPS_UI_API_DIMENSIONS=MAPS_UI_API+"/r/dimension";

    public static final String MAPS_UI_API_DIMENSIONS_GET_DIMENSION_BY_ID=MAPS_UI_API_DIMENSIONS+"/%s";

    public static final String MAPS_UI_API_DIMENSIONS_EDIT_DIMENSION_BY_ID=MAPS_UI_API_DIMENSIONS+"/%s";


}
