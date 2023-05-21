package com.shg.bmapi.utils;

import com.shg.bmapi.configurations.properties.ConfigProperties;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class RestUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestUtils.class);
    private static final ParameterizedTypeReference<Map<Object, Object>> MAP_RESPONSE_TYPE = new ParameterizedTypeReference<Map<Object, Object>>() {};
    private static final ParameterizedTypeReference<Object> OBJECT_RESPONSE_TYPE=new ParameterizedTypeReference<Object>() {};
    private static final ParameterizedTypeReference<List<Object>> LIST_RESPONSE_TYPE = new ParameterizedTypeReference<List<Object>>() {};

    private static final ParameterizedTypeReference<Collection<Object>> COLLECTION_RESPONSE_TYPE = new ParameterizedTypeReference<Collection<Object>>() {};

    private RestUtils() {

    }

    public static Map<Object, Object> sendGetRequest(@NotNull final RestTemplate restTemplate, final String endpoint) {

        LOGGER.info("GET: " + endpoint);

        final HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.AUTHORIZATION, getBearerToken());
        final HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

        return restTemplate.exchange(
                        endpoint,
                        HttpMethod.GET,
                        requestEntity,
                        MAP_RESPONSE_TYPE
                )
                .getBody();
    }


    public static Object sendGetRequestSO(@NotNull final RestTemplate restTemplate, final String endpoint) {

        LOGGER.info("GET: " + endpoint);

        final HttpHeaders headers = new HttpHeaders();
        //headers.set(HttpHeaders.COOKIE,getCookie());
        final HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

        return restTemplate.exchange(
                        endpoint,
                        HttpMethod.GET,
                        requestEntity,
                        Object.class
                )
                .getBody();
    }



    public static Map<Object, Object> sendPutRequestMapResponse(@NotNull final RestTemplate restTemplate, final String endpoint) {

        LOGGER.info("PUT: " + endpoint);

        final HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.AUTHORIZATION, getBearerToken());
        final HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

        return restTemplate.exchange(
                        endpoint,
                        HttpMethod.PUT,
                        requestEntity,
                        MAP_RESPONSE_TYPE
                )
                .getBody();
    }

    public static List<Object> sendGetRequestLRT(@NotNull final RestTemplate restTemplate, final String endpoint) {

        LOGGER.info("GET: " + endpoint);

        final HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.AUTHORIZATION, getBearerToken());
        final HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

        return restTemplate.exchange(
                        endpoint,
                        HttpMethod.GET,
                        requestEntity,
                        LIST_RESPONSE_TYPE
                )
                .getBody();
    }


    public static Collection<Object> sendGetRequestCRT(@NotNull final RestTemplate restTemplate, final String endpoint) {

        LOGGER.info("GET: " + endpoint);

        final HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.AUTHORIZATION, getBearerToken());
        final HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

        return restTemplate.exchange(
                        "https://aircanada-dev.brandmakerinc.com/dse/rest/internal/jobs/3791/grids/4005/rows",
                        HttpMethod.GET,
                        requestEntity,
                        COLLECTION_RESPONSE_TYPE
                )
                .getBody();
    }


    public static Map<Object, Object> sendPostRequest(@NotNull final RestTemplate restTemplate, final MediaType mediaType,
                                                      final String endpoint, final Object requestBody) {

        LOGGER.info("POST: " + endpoint);

        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(mediaType);
        headers.set(HttpHeaders.AUTHORIZATION, getBearerToken());
        final HttpEntity<?> request = new HttpEntity<>(requestBody, headers);

        return restTemplate.exchange(
                endpoint,
                HttpMethod.POST,
                request,
                MAP_RESPONSE_TYPE
        ).getBody();
    }


    public static ResponseEntity<?> sendPostRequest2(@NotNull final RestTemplate restTemplate, final MediaType mediaType,
                                                      final String endpoint, final Object requestBody) {

        LOGGER.info("POST: " + endpoint);

        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(mediaType);
        headers.set(HttpHeaders.AUTHORIZATION, getBearerToken());
        final HttpEntity<?> request = new HttpEntity<>(requestBody, headers);

        return restTemplate.exchange(
                endpoint,
                HttpMethod.POST,
                request,
                OBJECT_RESPONSE_TYPE
        );
    }

    public static  ResponseEntity<Object> sendPostRequestREO(@NotNull final RestTemplate restTemplate, final MediaType mediaType,
                                                      final String endpoint, final Object requestBody) {

        LOGGER.info("POST: " + endpoint);

        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(mediaType);
        headers.set(HttpHeaders.AUTHORIZATION, getBearerToken());
        final HttpEntity<?> request = new HttpEntity<>(requestBody, headers);

        return restTemplate.exchange(
                endpoint,
                HttpMethod.POST,
                request,
                Object.class
        );
    }



    public static ResponseEntity<Object> sendPutRequest(@NotNull final RestTemplate restTemplate, final MediaType mediaType,
                                                      final String endpoint, final Object requestBody) {

        LOGGER.info("PUT: " + endpoint);

        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(mediaType);
        headers.set(HttpHeaders.AUTHORIZATION, getBearerToken());
        final HttpEntity<?> request = new HttpEntity<>(requestBody, headers);

        return restTemplate.exchange(
                endpoint,
                HttpMethod.PUT,
                request,
                Object.class
        );
    }


    @Nullable
    public static String getBearerToken() {
            return "Bearer " + fToken;
    }

    @Nullable
    public static String getCookie()
    {
        return cookie;
    }


    @Nullable
    public static void resolveCallerBearerToken() throws  SecurityException{

        final ServletRequestAttributes servletRequestAttributes = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes());

        if (servletRequestAttributes != null) {
            fToken = servletRequestAttributes.getRequest().getHeader(HttpHeaders.AUTHORIZATION).replaceAll("Bearer","").trim();
            cookie = servletRequestAttributes.getRequest().getHeader(HttpHeaders.COOKIE).trim();
        }
        else
            throw new SecurityException("Caller auth verification failed");
    }

    static String fToken;
    static String cookie;
    public static void GetTheToken(@NotNull final RestTemplate restTemplate, ConfigProperties configProperties) {

        String endpoint = HttpUtils.createUrl(configProperties.getUrl(),"/rest/sso/auth");

        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.setBasicAuth(configProperties.getUsername(),configProperties.getPassword());
        final HttpEntity<?> request = new HttpEntity<>(null, headers);

        Map<Object, Object> response = restTemplate.exchange(
                endpoint,
                HttpMethod.POST,
                request,
                MAP_RESPONSE_TYPE
        ).getBody();

       fToken = response.get("access_token").toString();

        System.out.println("NEW TOKEN");
    }

}