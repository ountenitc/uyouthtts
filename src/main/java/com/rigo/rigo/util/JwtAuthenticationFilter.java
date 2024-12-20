package com.rigo.rigo.util;

import com.rigo.rigo.services.impl.UtilisateurImpl;
import java.io.IOException;


import org.springframework.lang.NonNull;
/*
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
*/
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter  {

	private final JwtService jwtService;	
	private final UtilisateurImpl userService;	
	public static final String BEARER_TOKEN_PREFIX = "Bearer ";
	public static final String BASIC_TOKEN_PREFIX = "Basic ";
	public static final String AUTH_HEADER = "Authorization";
	/*
	@Override
	protected void doFilterInternal(
		   @NonNull HttpServletRequest request, 
		   @NonNull HttpServletResponse response, 
		   @NonNull FilterChain filterChain)throws ServletException, IOException {	
		 
			final String authHeader = request.getHeader(AUTH_HEADER);
			final String jwt;
			final String uname ;
			logger.info("Authorization Header value: " + authHeader);
			if (authHeader == null || !authHeader.startsWith(BEARER_TOKEN_PREFIX)) {
				filterChain.doFilter(request, response);
				return;
			}
			jwt = authHeader.substring(7);
			logger.info("Authorization Header value testererere: " + authHeader);
			uname= jwtService.extractUsername(jwt); 
			logger.info("Authorization Header value testererere username: " + uname);
			logger.info("Authorization Header value testererere authentication: " + SecurityContextHolder.getContext().getAuthentication());
			
			if(uname !=null && SecurityContextHolder.getContext().getAuthentication() == null) {
				UserDetails userDetails = userService.loadUserByUsername(uname);
				if(jwtService.isTokenValid(jwt, userDetails.getUsername()));
				UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
						userDetails, 
						null, 
						userDetails.getAuthorities());
				authToken.setDetails(
						new WebAuthenticationDetailsSource().buildDetails(request)
						);
				SecurityContextHolder.getContext().setAuthentication(authToken);
			}
		filterChain.doFilter(request, response);

	}
*/
}
