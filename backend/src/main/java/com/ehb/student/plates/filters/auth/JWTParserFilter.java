package com.ehb.student.plates.filters.auth;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.util.StringUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class JWTParserFilter extends BasicAuthenticationFilter {

    public JWTParserFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer"))
        {
            chain.doFilter(request, response);
            return;
        }

        UsernamePasswordAuthenticationToken authToken = null;
        try {
            authToken = getAuthenticationToken(request);
        } catch (JwtException e) {
            response.setStatus(401);
            response.sendError(401, "The provided authentication token is invalid or has expired.");
            return;
        }

        SecurityContextHolder.getContext().setAuthentication(authToken);
        chain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken getAuthenticationToken(HttpServletRequest request) throws JwtException {
        String token = request.getHeader("Authorization");
        if (token != null) {
            String username = getUsernameFromToken(token);

            if (username != null) {
                return new UsernamePasswordAuthenticationToken(username, null, new ArrayList<>());
            }

            return null;
        }

        return null;
    }

    private String getUsernameFromToken(String token) throws JwtException {
        return Jwts.parser()
                .setSigningKey("PlatesSecretKey".getBytes())
                .parseClaimsJws(StringUtils.replace(token,"Bearer", ""))
                .getBody()
                .getSubject();
    }
}
