package com.receipt.www.receiptbackend.jwt;

import com.receipt.www.receiptbackend.exception.TokenException;
import com.receipt.www.receiptbackend.login.command.application.dto.AccessTokenDTO;
import com.receipt.www.receiptbackend.member.command.application.dto.MemberDTO;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class TokenProvider {

    private static final Logger log = LoggerFactory.getLogger(TokenProvider.class);
    private static final String AUTHORITIES_KEY = "Auth";
    private static final String BEARER_TYPE ="bearer";

    private static final long ACCESS_TOKEN_EXPIRE_TIME = 1000 * 21599;
    private final UserDetailsService userDetailsService;
    private final Key key;

    public TokenProvider(@Value("${jwt.secret}") String secretKey, UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
        byte[] keyBytes = Decoders.BASE64URL.decode(secretKey);
        this.key = Keys.hmacShaKeyFor(keyBytes);
    }

    public AccessTokenDTO generateMemberTokenDTO(MemberDTO foundMember, int memberNum) {

        Claims claims = Jwts
                .claims()
                .setSubject(String.valueOf(foundMember.getMemberNum()));
        long now = (new Date()).getTime();

        Date accessTokenExpiresIn = new Date(now + ACCESS_TOKEN_EXPIRE_TIME);
        String jwtToken = Jwts.builder()
                .setClaims(claims)
                .setExpiration(accessTokenExpiresIn)
                .signWith(key, SignatureAlgorithm.HS512)
                .compact();

        return new AccessTokenDTO(BEARER_TYPE, memberNum, jwtToken,
                accessTokenExpiresIn.getTime());
    }

    public Authentication getAuthentication(String accessToken) {

        UserDetails userDetails = userDetailsService.loadUserByUsername(this.getUserId(accessToken));

        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    private String getUserId(String accessToken) {
        return Jwts
                .parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(accessToken)
                .getBody()
                .getSubject();
    }

    public boolean validateToken(String token) throws ExpiredJwtException {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (io.jsonwebtoken.security.SecurityException | MalformedJwtException e) {
            log.info("[TokenProvider] Malformed JWT Sign");
            throw new TokenException("잘못된 JWT 서명입니다.");
        } catch (ExpiredJwtException e) {
            log.info("[TokenProvider] Expired JWT Token");
            throw new TokenException("만료된 JWT 토큰입니다.");
        } catch (UnsupportedJwtException e) {
            log.info("[TokenProvider] Unsupported JWT token");
            throw new TokenException("지원되지 않는 JWT 토큰입니다.");
        } catch (IllegalArgumentException e) {
            log.info("[TokenProvider] JWT Token Illegal");
            throw new TokenException("JWT 토큰이 잘못되었습니다.");
        }
    }

    private Claims parseClaims(String accessToken) {
        try {
            return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(accessToken).getBody();
        } catch (ExpiredJwtException e) {
            return e.getClaims();
        }
    }

    public int getMemberNumFromToken(String token) {
        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

            // Subject에 저장된 memberNum 값을 int로 변환하여 반환합니다.
            return Integer.parseInt(claims.getSubject());
        } catch (Exception e) {
            throw new TokenException("JWT 토큰에서 memberNum 값을 추출하는 중 오류가 발생했습니다.", e);
        }
    }
}
