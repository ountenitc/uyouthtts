package com.rigo.rigo.util;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/*
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
*/
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;


import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Configuration
//@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration  {
    /*
	@Autowired
	AuthenticationProvider authenticationProvider;
	@Autowired
	private final JwtAuthenticationFilter jwtAuthFilter;
	
	@SuppressWarnings({ "removal", "deprecation" })
	@Bean
	public SecurityFilterChain filterChain (HttpSecurity http) throws Exception
	{
        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .csrf(csrf -> csrf.disable())
                .cors(cors -> cors.configurationSource(new CorsConfigurationSource()
                {
                    @Override
                    public CorsConfiguration getCorsConfiguration(HttpServletRequest request)
                    {
                        CorsConfiguration cors = new CorsConfiguration();
                        cors.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
                        cors.setAllowedMethods(Collections.singletonList("*"));
                        cors.setAllowedHeaders(Collections.singletonList("*"));
                        cors.setExposedHeaders(Collections.singletonList("Authorization"));
                        return cors;
                    }
                }))
//		.authorizeHttpRequests( requests ->
//		requests.anyRequest().authenticated() );
        
                .authorizeHttpRequests(requests -> {
					try {
                        requests
                                .requestMatchers("/public/**").permitAll() // Autorisez l'accès aux endpoints publics
                               // .anyRequest().authenticated() // Exigez une authentification pour les autres requêtes
                                .and()
                                .sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}); // Utilisez une politique de session sans état
		
		return http.build();
	}
//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//	    http.csrf().disable()
//	        .exceptionHandling()
//	        .authenticationEntryPoint((request, response, authEx) -> {
//	            response.setHeader("WWW-Authenticate", "Basic realm=\"Access to /signin authentication endpoint\"");
//	            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//	            response.getWriter().write("{ \"Error\": \"" + authEx.getMessage() + " - You are not authenticated.\" }");
//	        })
//	        .and()
//	        .authorizeHttpRequests((authorize) -> authorize
//	            .requestMatchers("/**").permitAll()
//	            .anyRequest().authenticated()
//	        )
//	        .and()
//	        .sessionManagement()
//	        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//	        .and()
//	        .authenticationProvider(authenticationProvider)
//	        .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
//
//	    return http.build();
//	}

//	@SuppressWarnings("removal")
//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//
//        http.csrf(csrf -> csrf.disable())
//        		
//                .exceptionHandling(handling -> handling
//                        .authenticationEntryPoint((request, response, authEx) -> {
//                            response.setHeader("WWW-Authenticate", "Basic realm=\"Access to /signin authentication endpoint\"");
//                            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//                            response.getWriter().write("{ \"Error\": \"" + authEx.getMessage() + " - You are not authenticated.\" }");
//                        }));
//
//        http.csrf(csrf -> csrf.disable())
//                .authorizeHttpRequests((authorize) -> authorize
//                        .requestMatchers("/**").permitAll()
//                        .anyRequest()
//                        .authenticated().and())
//                .sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .authenticationProvider(authenticationProvider)
//                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
//		return http.build();
//	}
*/
}
