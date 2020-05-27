package com.service.entity;


import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

public final class HashGenerate {
    private HashGenerate() {
    }
    public static String generateHash(String apiKey, String secretKey, String randomString, Object request) {
        return Base64.encodeBase64String(DigestUtils.sha1(apiKey + randomString + secretKey + request));
    }
}
