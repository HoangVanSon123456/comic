package com.example.config.security;

import com.example.entity.User;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimNames;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider {

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.expiration}")
    private long jwtExpirationMs;

    public String generateToken(String email) {
       try {
           JWSSigner signer = new MACSigner(jwtSecret.getBytes());

           JWTClaimsSet claims = new JWTClaimsSet.Builder()
                   .subject(email)
                   .issuer("example.com")
                   .expirationTime(new java.util.Date(System.currentTimeMillis() + jwtExpirationMs))
                   .issueTime(new java.util.Date())
                   .build();

           SignedJWT signedJWT = new SignedJWT(
                   new JWSHeader(JWSAlgorithm.HS256),
                   claims
           );
           signedJWT.sign(signer);

              return signedJWT.serialize(); // Placeholder for actual token
         } catch (Exception e) {
              throw new RuntimeException("Error generating token", e);
       }
    }

    // Validate JWT token
    public boolean validateToken(String token) {
        try {
            SignedJWT signedJWT = SignedJWT.parse(token);
            JWSVerifier verifier = new MACVerifier(jwtSecret.getBytes());

            boolean signatureValid = signedJWT.verify(verifier);
            boolean notExpired = signedJWT.getJWTClaimsSet().getExpirationTime().after(new Date());

            return signatureValid && notExpired;

        } catch (Exception e) {
            return false;
        }
    }

    // Get email from JWT token
    public String getEmailFromToken(String token) {
        try {
            SignedJWT signedJWT = SignedJWT.parse(token);
            return signedJWT.getJWTClaimsSet().getSubject();
        } catch (Exception e) {
            throw new RuntimeException("Error parsing JWT", e);
        }
    }
}
