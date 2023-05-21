package com.shg.bmapi.utils;

import com.shg.bmapi.models.HttpResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class HttpUtils {

    private HttpUtils() {

    }

    /**
     * Create HTTP response
     *
     * @param httpStatus HTTP response status
     * @param message    Response message
     * @return created response of type {@link HttpResponse}
     */
    public static ResponseEntity<HttpResponse> createHttpResponse(final HttpStatus httpStatus, final String message) {

        final HttpResponse httpResponse =
                new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase(), message);

        return new ResponseEntity<>(httpResponse, httpStatus);
    }

    /**
     * Create endpoint path
     *
     * @param serverUrl    Server url
     * @param endpointPath Relative endpoint path
     * @return String of created URL
     */
    public static String createUrl(final String serverUrl, final String endpointPath) {

        return String.format("%s%s", serverUrl, endpointPath);
    }

}
