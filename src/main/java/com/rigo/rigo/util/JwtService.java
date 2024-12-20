package com.rigo.rigo.util;


import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.spec.SecretKeySpec;

/*
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
*/

import org.springframework.stereotype.Service;
@Service
public class JwtService {
/*
    private static Key hmacKey = new SecretKeySpec(Base64.getDecoder().decode(SecurityConstants.JWT_SECRET), 
    SignatureAlgorithm.HS512.getJcaName());

    public static String generateToken(UserDetails userDetails) {
    	return generateToken(new HashMap<>(), userDetails);
    }
    
    public static String generateToken(
    		Map<String, Object> extractClaims,
    		UserDetails userDetails
    		) {
        Date currentDate = new Date();
        Date expireDate = new Date(currentDate.getTime() + SecurityConstants.EXPIRATION_TIME);

        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(expireDate)
                .signWith(hmacKey)
                .compact();
    }

    public String extractUsername(String token) {
    	return extractClaim(token, Claims::getSubject);
    }
    
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
		final Claims claims =extractAllClaims(token);
    	return claimsResolver.apply(claims);
    	
    }
    
    private Claims extractAllClaims(String token) {
    	return Jwts.parserBuilder()
        .setSigningKey(hmacKey)
        .build()
        .parseClaimsJws(token)
        .getBody();
    }

    public boolean isTokenValid(String token, String userDetails) {
         	try { 
         		String username = extractUsername(token);
            return (username.equals(userDetails)) && !isTokenExpired(token);
        } catch (Exception ex) {
            throw new AuthenticationCredentialsNotFoundException("JWT was expired or incorrect");
        }
    }

    private boolean isTokenExpired(String token) {
		return extratExpiration(token).before(new Date());
	}

	private Date extratExpiration(String token) {
		return extractClaim(token, Claims::getExpiration);
	}

	public static String[] decodedBase64(String token) {

        byte[] decodedBytes = Base64.getDecoder().decode(token);
        String pairedCredentials = new String(decodedBytes);
        String[] credentials = pairedCredentials.split(":", 2);

        return credentials;

    }

   
   */ 
}
