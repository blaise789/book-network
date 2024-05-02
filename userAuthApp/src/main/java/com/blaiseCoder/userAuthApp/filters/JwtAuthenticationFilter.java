package com.blaiseCoder.userAuthApp.filters;

import com.blaiseCoder.userAuthApp.repositories.UserRepository;
import com.blaiseCoder.userAuthApp.service.JWTService;
import com.blaiseCoder.userAuthApp.service.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
//import org.apache.catalina.util.StringUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter{
   private final JWTService  jwtService;
//
    private UserService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
   final String authHeader=request.getHeader("Authorization");
   final String  jwt;
   final String userEmail;
   if(StringUtils.isEmpty(authHeader) || org.apache.commons.lang3.StringUtils.startsWith(authHeader,"Bearer ")){
       filterChain.doFilter(request,response);
       return;
   }
 jwt=authHeader.substring(7);
  userEmail=jwtService.extractUsername(jwt);
  if(org.apache.commons.lang3.StringUtils.isNotEmpty(userEmail) && SecurityContextHolder.getContext().getAuthentication()==null){
      UserDetails userDetails

  }
    }
}
