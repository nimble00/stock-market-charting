package com.nimble00.zuulgateway.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import io.jsonwebtoken.Jwts;
import static com.nimble00.zuulgateway.security.SecurityConstants.*;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

    public JWTAuthorizationFilter(AuthenticationManager authManager) {
        super(authManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest req,
                                    HttpServletResponse res,
                                    FilterChain chain) throws IOException, ServletException {
        String header = req.getHeader(HEADER_STRING);
        System.out.println("%%%%%%@@");
        System.out.println(header);
        System.out.println("%%%%%%@@");

        if (header == null || !header.startsWith(TOKEN_PREFIX)) {
            System.out.println("%%%%%%@@ WHAT!!!");

            chain.doFilter(req, res);
            return;
        }
        System.out.println("%%%%%%@@ 1111");
        UsernamePasswordAuthenticationToken authentication = getAuthentication(req);
        System.out.println("%%%%%%@@ 2222");
        SecurityContextHolder.getContext().setAuthentication(authentication);
        System.out.println("%%%%%%@@ 3333");
        chain.doFilter(req, res);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(HEADER_STRING).replace("Bearer ", "");
        System.out.println("%%%%%% $1");
        System.out.println(request.toString());
        System.out.println("%%%%%% $2");
        if (token != null) {
            // parse the token
            String user = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();
            System.out.println("#### 11");
            System.out.println(user);
            System.out.println("#### 22");
            if (user != null) {
                return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
            }
            return null;
        }
        return null;
    }
}
