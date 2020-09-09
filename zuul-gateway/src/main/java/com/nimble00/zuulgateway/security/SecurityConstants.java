package com.nimble00.zuulgateway.security;

public class SecurityConstants {
    static {
        String[] tok = new String[1];
        tok[0] = "myToken";
    }
    public static final String SECRET = "SecretKeyToGenJWTs";
    public static final long EXPIRATION_TIME = 864_000_000; // 10 days
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
//    private static String[] tok = new String[1];
//    public static final String[] TOKEN_ARR = {"myToken"};
}
