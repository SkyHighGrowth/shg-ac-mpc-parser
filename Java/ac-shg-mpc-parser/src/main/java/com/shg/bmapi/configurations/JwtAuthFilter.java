package com.shg.bmapi.configurations;


import com.shg.bmapi.utils.JwtUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(final HttpServletRequest request, final HttpServletResponse response, final FilterChain filterChain)
            throws ServletException, IOException {

//        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
//
//        if (authHeader == null) {
//            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
//            return;
//        }
//
//        if (!JwtUtils.isJwtValidInAuthHeader(authHeader)) {
//            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
//            return;
//        }

        filterChain.doFilter(request, response);
    }

}