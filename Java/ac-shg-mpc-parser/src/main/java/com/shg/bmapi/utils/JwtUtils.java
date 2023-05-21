package com.shg.bmapi.utils;


import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class JwtUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtUtils.class);

    private static final String BEARER = "Bearer";
    private static final int AUTHORIZATION_HEADER_PARTS = 2;
    private static final int BEARER_POSITION_LIST = 0;
    private static final int TOKEN_VALUE_POSITION_LIST = 1;

    private JwtUtils() {

    }

    /**
     * Validate that authorization header contains proper format and that JWT is not expired
     *
     * @param authHeader Authorization header
     * @throws JWTDecodeException If provided token is not valid
     * @return if token contains 2 parts (Bearer + token) and if token is not expired
     */
    public static boolean isJwtValidInAuthHeader(final String authHeader) {

        final List<String> parts = Arrays.asList(authHeader.split(" "));

        try {

            return (parts.size() == AUTHORIZATION_HEADER_PARTS) &&
                    BEARER.equals(parts.get(BEARER_POSITION_LIST)) &&
                    !JWT.decode(parts.get(TOKEN_VALUE_POSITION_LIST)).getExpiresAt().before(new Date());
        } catch (JWTDecodeException e) {

            LOGGER.error(
                    "Cannot decode the JWT token {}. Auth header is: {}",
                    e.getMessage(),
                    authHeader
            );
        }

        return false;
    }

}
