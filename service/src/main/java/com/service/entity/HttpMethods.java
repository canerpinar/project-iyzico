package com.service.entity;

public enum HttpMethods {
    GET,
    POST,
    DELETE,
    PUT;

    private HttpMethods() {
    }

    public static boolean isValidRequestFor(HttpMethods httpMethod) {
        return POST.equals(httpMethod) || PUT.equals(httpMethod) || DELETE.equals(httpMethod);
    }
}
