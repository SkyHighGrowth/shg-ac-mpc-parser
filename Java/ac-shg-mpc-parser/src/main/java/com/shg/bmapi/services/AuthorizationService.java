package com.shg.bmapi.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shg.bmapi.configurations.properties.ConfigProperties;
import com.shg.bmapi.constants.DseEndPointConstants;
import com.shg.bmapi.models.LoginInfoDTO;
import com.shg.bmapi.utils.HttpUtils;
import com.shg.bmapi.utils.RestUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class AuthorizationService {
    final RestTemplate restTemplate;
    final ConfigProperties properties;
    final ObjectMapper objectMapper;

    public AuthorizationService(RestTemplate restTemplate, ConfigProperties properties, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.properties = properties;
        this.objectMapper = objectMapper;
    }

    public void initializeAuthorization() {
        RestUtils.GetTheToken(
                restTemplate,
                properties);

    }

    public String getElevatedUser()
    {
        return properties.getUsername();
    }

    public LoginInfoDTO getCallerUser()
    {

        RestUtils.resolveCallerBearerToken();

        final Map<Object, Object> responseBody = RestUtils.sendGetRequest(
                restTemplate,
                HttpUtils.createUrl(properties.getUrl(), DseEndPointConstants.REST_ADM_USR_CURRENT)
        );

        return this.objectMapper.convertValue(responseBody, LoginInfoDTO.class);
    }

    public Boolean isCallerAdmin()
    {
        RestUtils.resolveCallerBearerToken();

        final Map<Object, Object> responseBody = RestUtils.sendGetRequest(
                restTemplate,
                HttpUtils.createUrl(properties.getUrl(), DseEndPointConstants.REST_ADM_USR_CURRENT)
        );

        return false;//this.objectMapper.convertValue(responseBody, LoginInfoDTO.class);
    }
}
