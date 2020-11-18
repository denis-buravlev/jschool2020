package com.dsr.jschool.security;

import com.dsr.jschool.data.entity.Role;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class JwtProvider {

    private final Key key;
    private final JwtParser jwtParser;

//    private final String keyStr = Encoders.BASE64.encode(Keys.secretKeyFor(SignatureAlgorithm.HS512).getEncoded());

    public JwtProvider(@Value("${jwtSecret}") String key) {
        this.key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(key));
        this.jwtParser = Jwts.parserBuilder()
                .setSigningKey(this.key)
                .build();

    }

    public String generateToken(String login, List<Role> roles) {
        Date exDate = Date.from(
                LocalDate.now()
                .plusDays(15)
                .atStartOfDay(ZoneId.systemDefault()).toInstant()
        );

        return Jwts.builder()
                .setSubject(login)
                .claim("roles", roles.stream().map(Role::getName).collect(Collectors.joining(",")))
                .signWith(key)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            jwtParser.parse(token);
            return true;
        } catch (Exception e) {
            System.err.println("Invalid token");
            return false;
        }
    }

    public Claims getClaimsFromToken(String token) {
        return jwtParser.parseClaimsJws(token).getBody();
    }
}
