package com.JWT.Sample.Security;

// JWTAuthenticationFilter that extends OncePerRequestFilter
// and override method and write the logic to check the token
// that is comming in header.

// We have to write 5 important logic :-
// 1. Get Token from request
// 2. Validate Token
// 3. GetUsername from token
// 4. Load user associated with this token
// 5. Set authentication


import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JWTAuthenticationFilter extends OncePerRequestFilter {

    private Logger logger = LoggerFactory.getLogger(OncePerRequestFilter.class);

    @Autowired
    private JWTHelper jwtHelper;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException expobj) {
//            throw new RuntimeException(expobj);
//        }

        // Authorization
        String requestHeader = request.getHeader("Authorization");

        // Bearer 2352345235sdfrsfgsdfsdf
        logger.info(" Header : {}", requestHeader);

        String username = null;
        String token = null;
        if (requestHeader != null && requestHeader.startsWith("Bearer")) {
            // Looking good
            token = requestHeader.substring(7);
            try {
                username = this.jwtHelper.getUserNameFromToken(token);
            } catch (IllegalArgumentException expObj1) {
                logger.info("Illegal Argument while fetching the username !!!");
                expObj1.printStackTrace();
            } catch (ExpiredJwtException expObj2) {
                logger.info("Given JWT Token is expired !!!");
                expObj2.printStackTrace();
            } catch (MalformedJwtException expObj3) {
                logger.info("Some change has been done in token ! Invalid Token !");
                expObj3.printStackTrace();
            } catch (Exception expObj4) {
                logger.info("General Exception occured.");
                expObj4.printStackTrace();
            }
        } else {
            logger.info("Invalid Header Value !!!");
        }

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            // Fetch User detail from username
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
            Boolean validateToken = this.jwtHelper.validateToken(token, userDetails);

            if (validateToken) {

                // Set the authentication
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            } else {
                logger.info("Validation failed !!!");
            }
        }

        filterChain.doFilter(request, response);
    }
}
