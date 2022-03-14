package io.scalaway.identity.api.security;

import io.scalaway.identity.model.Account;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

import static io.jsonwebtoken.security.Keys.secretKeyFor;
import static java.lang.String.format;

// TODO : move into infrastructure
@Component
public class JwtUtils {

    private final String jwtIssuer = "scalaway.io";
    // TODO : load secret key from settings
    private final SecretKey secretKey = secretKeyFor(SignatureAlgorithm.HS512);

    public String generateAccessToken(Account user) {
        return Jwts.builder()
                .setSubject(format("%s", user.getEmail()))
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 7 * 24 * 60 * 60 * 1000)) // 1 week
                .signWith(secretKey)
                .compact();
    }

    public String getEmailFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }

    public Date getExpirationDate(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();

        return claims.getExpiration();
    }

    public boolean validate(String token) {
        try {
            Jwts.parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(token)
                    .getBody();
            return true;
        } catch (MalformedJwtException ex) {
            System.out.println(ex);
        } catch (ExpiredJwtException ex) {
            System.out.println(ex);
        } catch (UnsupportedJwtException ex) {
            System.out.println(ex);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex);
        }
        return false;
    }
}
