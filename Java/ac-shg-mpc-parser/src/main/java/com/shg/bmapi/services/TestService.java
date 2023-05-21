package com.shg.bmapi.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shg.bmapi.configurations.properties.ConfigProperties;
import com.shg.bmapi.constants.MapsEndPointsConstants;
import com.shg.bmapi.utils.HttpUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TestService {
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;
    private final ConfigProperties properties;
    private final AuthorizationService authorizationService;


    public TestService(RestTemplate restTemplate, ObjectMapper objectMapper, ConfigProperties properties, AuthorizationService authorizationService) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
        this.properties = properties;
        this.authorizationService = authorizationService;
    }

    public Object testMethod()
    {

        final HttpHeaders headers = new HttpHeaders();
        //headers.set(HttpHeaders.COOKIE,getCookie());
        headers.set(HttpHeaders.AUTHORIZATION,"Bearer eyJhbGciOiJSUzUxMiJ9.eyJzdWIiOiJzeXN0ZW0udXNlciIsIm5hbWUiOiJTeXN0ZW1Vc2VyIFN5c3RlbVVzZXIiLCJ1c2VybmFtZSI6bnVsbCwiZ2l2ZW5fbmFtZSI6IlN5c3RlbVVzZXIiLCJmYW1pbHlfbmFtZSI6IlN5c3RlbVVzZXIiLCJlbWFpbCI6Im5vcmVwbHlAYnJhbmRtYWtlci5jb20iLCJlbWFpbF92ZXJpZmllZCI6dHJ1ZSwiZ2VuZGVyIjoibSIsImxvY2FsZSI6IkVOLVVTIiwiem9uZWluZm8iOiJFdXJvcGUvQmVybGluIiwicmlnaHRzIjpbIlBJTUVESUFfT1JHQU5JU0FUSU9OX1NFRV9BTExfUEVSU09OQUxfREFUQSJdLCJyb2xlcyI6eyI0IjoiYWRtaW5pc3RyYXRvciJ9LCJub25jZSI6bnVsbCwiaWF0IjoxNjc1OTMyOTc5LCJleHAiOjE2NzU5MzQ3NzksImN1c3RvbWVyX2lkIjoia3NmLWl4by1ra2QiLCJzeXN0ZW1faWQiOiIyNTItMzU5LTk1MyIsImlzcyI6IkF1dGhTZXJ2aWNlIiwianRpIjoiTUFrUEdidVdKTGFZT3cySHN0U3lBdyIsIm5iZiI6MTY3NTkzMjkxOX0.DjYTYn8AxlpyPm_kS4lTjcvlG9d08uXGEgaxsvXFE1DdrJP3qlsLP6srPqkiq1C_B5Bhq_zRuevVj-wboYfLSpobKyt8vnpfd6P-r9mQVXtHQ640jJaRv_aq_4wdfqRigfl_IkA9Y0BPGx1K6C6WhsDrsdaIcn5HT-kmSnP9mVYc4y8e1JQW87NzqGYnrRSFfB0K1N175nzVbDdAlDUCQd1zW62sgTqUy5TTnoQTXQoY4SivjpaRXkVh4nhHOk-0lACbWsg_08jKYvuVcf2SSn5hBPgCELL2FqI4C7UNmS-Zd300Y9m8c6-ynaUQcHUkfjJI3f8kDQQgdaCrd9X7S14lhXmPjt-yLbqGginEvBq7uHeXZnHvG8XnUroU0qglecbuXPejPPRsJ4PjOpF4ngtPIMF34m9IbC6hfbDonCnhxOvBuCjru0AvuENO7zlbZqewIwAi5bPHp1mTks9AzJnV1wQKEIqHevOzH4O82UEBEGv08ZDVLslVYtCkcUVGUHnlYRjaMJSCLCKFkf81VbxrnU9UwLVqEU6kwVKhjg3LxWm4wH7TyILnqwBG487Epg7HEslr2kD8J0j5IiHryINBbys53XfkbzsuDxxC8h5J4A1dJdwSsvcbyf1O1RtG9LxyqfDqWi5B1fgGIoUIjwIZVnmtOm7da12lqTaUsec");
        headers.set("User-Agent", "test");
        final HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

        final Object responseBody = restTemplate.exchange(
                        HttpUtils.createUrl(properties.getUrl(), String.format(MapsEndPointsConstants.MAPS_UI_API_DIMENSIONS_GET_DIMENSION_BY_ID,23)),
                        HttpMethod.GET,
                        requestEntity,
                        Object.class
                )
                .getBody();


        return responseBody;
    }





}
