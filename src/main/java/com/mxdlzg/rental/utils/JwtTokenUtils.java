package com.mxdlzg.rental.utils;

import com.mxdlzg.rental.domain.model.JwtUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;

public class JwtTokenUtils {
    public static final String TOKEN_HEADER = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";
    private static final String SECRET = "MxdlzgRental19ThisisasmartcarrentalprojectforSit19Createdbymxdlzg19mxdlzg";
    private static final String ISS = "echisan"; // 过期时间是3600秒，既是1个小时
    private static final long EXPIRATION = 3600L; // 选择了记住我之后的过期时间为7天
    private static final long EXPIRATION_REMEMBER = 604800L; // 创建token

    private static final String ROLE_CLAIMS = "rol";

    public static String createToken(JwtUser user, String role, boolean isRememberMe) {
        long expiration = isRememberMe ? EXPIRATION_REMEMBER : EXPIRATION;
        HashMap<String ,Object> map = new HashMap<>();
        map.put(ROLE_CLAIMS,role);
        map.put("id",user.getId());
        return Jwts.builder().signWith(SignatureAlgorithm.HS256, SECRET)
                .setClaims(map)
                .setIssuer(ISS)
                .setSubject(user.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration * 1000))
                .compact();
    }


    private static Claims getTokenBody(String token) {
        token = token.replace(TOKEN_PREFIX,"");
        return Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
    }

    // 是否已过期
    public static boolean isExpiration(String token) {
        return getTokenBody(token).getExpiration().before(new Date());
    }


    // 从token中获取用户名
    public static String getUsername(String token) {
        return getTokenBody(token).getSubject();
    }

    public static String getUserRole(String token) {
        return getTokenBody(token).get(ROLE_CLAIMS).toString();
    }

    public static int getUserId(String token){
        return Integer.valueOf(getTokenBody(token).get("id").toString());
    }

    public static boolean isValidUser(String name,String token){
        String serverSideName = JwtTokenUtils.getUsername(token);
        return serverSideName.equals(name);
    }
}
