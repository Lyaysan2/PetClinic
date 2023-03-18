package ru.itis.security.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import ru.itis.service.JwtTokenService;
import ru.itis.util.http.HttpRequestUtil;
import ru.itis.util.http.HttpResponseUtil;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Stream;

//@RequiredArgsConstructor
//@Component
public class JwtAuthorizationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtTokenService jwtTokenService;

    @Autowired
    private UserDetailsService userDetailsService;

    private static final String[] PERMIT_ALL = {
            "/api/auth",
            "/api/token",
            "/v3/api-docs",
            "swagger-ui",
            "account-swagger",
            "api-docs"
    };

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        if (Arrays.stream(Arrays.stream(PERMIT_ALL).toArray()).anyMatch(a -> request.getRequestURI().contains(a.toString()))){
            filterChain.doFilter(request, response);
            return;
        }
        try {
            String token = HttpRequestUtil
                    .getTokenFromValidatedAuthorizationHeader(request.getHeader("AUTHORIZATION"));
            UserDetails userDetails = userDetailsService.loadUserByUsername(
                    jwtTokenService.getUserInfoByToken(token).getEmail());
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                    userDetails, null, userDetails.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            filterChain.doFilter(request, response);
        } catch (Exception exception){
            SecurityContextHolder.clearContext();
            HttpResponseUtil.putExceptionInResponse(request, response, exception, HttpServletResponse.SC_UNAUTHORIZED);
        }
    }
}
