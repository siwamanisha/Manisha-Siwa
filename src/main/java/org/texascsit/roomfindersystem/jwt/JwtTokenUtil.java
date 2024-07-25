package org.texascsit.roomfindersystem.jwt;

import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;
import org.texascsit.roomfindersystem.model.Renter;

import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Component
public class JwtTokenUtil {
    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(JwtTokenUtil.class);

    public static final long EXPIRE_DURATION = 24 * 60 * 60 * 1000; // 24 hour

    private String SECRET_KEY = "axb256";

    public String generateAccessToken(Renter renter) {
        Claims claims = Jwts.claims().setSubject( renter.getUsername());
        claims.put("username",renter.getUsername());
        claims.put("id",renter.getId());
        claims.put("role",renter.getRole().name());
        return Jwts.builder()
                .setClaims(claims)
                .setIssuer("ProfessionalClassApp")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE_DURATION))
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }

    public boolean validateAccessToken(String token) {
        try {
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException ex) {
            LOGGER.error("JWT expired", ex.getMessage());
        } catch (IllegalArgumentException ex) {
            LOGGER.error("Token is null, empty or only whitespace", ex.getMessage());
        } catch (MalformedJwtException ex) {
            LOGGER.error("JWT is invalid", ex);
        } catch (UnsupportedJwtException ex) {
            LOGGER.error("JWT is not supported", ex);
        } catch (SignatureException ex) {
            LOGGER.error("Signature validation failed");
        }
        return false;
    }
    public String getSubject(String token) {
        return parseClaims(token).getSubject();
    }

    private Claims parseClaims(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
}
}
