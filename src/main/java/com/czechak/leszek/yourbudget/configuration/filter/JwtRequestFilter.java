package com.czechak.leszek.yourbudget.configuration.filter;

import com.czechak.leszek.yourbudget.configuration.util.JwtUtil;
import com.czechak.leszek.yourbudget.model.UserEntity;
import com.czechak.leszek.yourbudget.service.UserContext;
import com.czechak.leszek.yourbudget.service.UserService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;


import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    private final UserService userService;
    private final JwtUtil jwtUtil;
    private final UserContext userContext;

    public JwtRequestFilter(UserService userService, JwtUtil jwtUtil, UserContext userContext) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
        this.userContext = userContext;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        final String authorizationHeader= request.getHeader("Authorization");

        String username = null;
        String jwt = null;

        if(authorizationHeader !=null && authorizationHeader.startsWith("Bearer")){
            jwt = authorizationHeader.substring(7);
            username = jwtUtil.extractUsername(jwt);
        }

        if (username != null && SecurityContextHolder.getContext().getAuthentication() ==null){
            UserDetails userDetails= this.userService.loadUserByUsername(username);
            if (userDetails instanceof UserEntity){
                userContext.setUserEntity((UserEntity) userDetails);
            }

            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken= new UsernamePasswordAuthenticationToken(
                    userDetails, null, userDetails.getAuthorities());
          usernamePasswordAuthenticationToken.setDetails((new WebAuthenticationDetailsSource().buildDetails(request)));
          SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        }

        filterChain.doFilter(request,response);
    }
}
