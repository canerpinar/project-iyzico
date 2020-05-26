package com.projectiyzico.entity;

import com.google.gson.Gson;


import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HttpClients {
    private static final String DEFAULT_CHARSET = "UTF-8";
    private static final String APPLICATION_JSON = "application/json";
    private static final String CONTENT_TYPE = "Content-Type";
    private static final String ACCEPT = "Accept";
    private static final int TIMEOUT = 140000;



    public static HttpClients create() {
        return new HttpClients();
    }

    public <T> T get(String url, Class<T> responseType) {
        return this.exchange(url, HttpMethods.GET, new HashMap<>(), (Object)null, responseType);
    }

    public <T> T post(String url, Map<String, String> headers, Object request, Class<T> responseType) {
        return this.exchange(url, HttpMethods.POST, headers, request, responseType);
    }

    public <T> T put(String url, Map<String, String> headers, Object request, Class<T> responseType) {
        return this.exchange(url, HttpMethods.PUT, headers, request, responseType);
    }

    public <T> T delete(String url, Map<String, String> headers, Object request, Class<T> responseType) {
        return this.exchange(url, HttpMethods.DELETE, headers, request, responseType);
    }

    private <T> T exchange(String url, HttpMethods httpMethod, Map<String, String> headers, Object request, Class<T> responseType) {
        Gson gson = new Gson();
        String body = gson.toJson(request);

        try {
            String response = this.send(url, httpMethod, new ByteArrayInputStream(body.getBytes("UTF-8")), headers);
            return gson.fromJson(response, responseType);
        } catch (UnsupportedEncodingException var9) {
            throw new HttpClientsException(var9.getMessage(), var9);
        }
    }

    private String send(String url, HttpMethods httpMethod, InputStream content, Map<String, String> headers) {
        HttpURLConnection conn = null;

        String var7;
        try {
            URLConnection raw = (new URL(url)).openConnection();
            conn = (HttpURLConnection)HttpURLConnection.class.cast(raw);
            conn.setRequestMethod(httpMethod.name());
            conn.setConnectTimeout(140000);
            conn.setReadTimeout(140000);
            conn.setUseCaches(false);
            conn.setInstanceFollowRedirects(false);
            this.prepareHeaders(headers, conn);
            this.prepareRequestBody(httpMethod, content, conn);
            var7 = new String(this.body(conn), Charset.forName("UTF-8"));
        } catch (Exception var11) {
            throw new HttpClientsException(var11.getMessage(), var11);
        } finally {
            if (conn != null) {
                conn.disconnect();
            }

        }

        return var7;
    }

    private void prepareHeaders(Map<String, String> headers, HttpURLConnection conn) {
        Iterator i$ = headers.entrySet().iterator();

        while(i$.hasNext()) {
            Map.Entry<String, String> header = (Map.Entry)i$.next();
            conn.addRequestProperty((String)header.getKey(), (String)header.getValue());
        }

        conn.addRequestProperty("Content-Type", "application/json");
        conn.addRequestProperty("Accept", "application/json");
    }

    private void prepareRequestBody(HttpMethods httpMethod, InputStream content, HttpURLConnection conn) throws IOException {
        if (HttpMethods.isValidRequestFor(httpMethod)) {
            conn.setDoOutput(true);
            OutputStream output = conn.getOutputStream();

            try {
                this.prepareOutputStream(content, output);
            } finally {
                output.close();
                content.close();
            }
        }

    }

    private void prepareOutputStream(InputStream content, OutputStream output) throws IOException {
        byte[] buffer = new byte[8192];

        for(int bytes = content.read(buffer); bytes != -1; bytes = content.read(buffer)) {
            output.write(buffer, 0, bytes);
        }

    }

    private byte[] body(HttpURLConnection conn) throws IOException {
        InputStream input;
        if (conn.getResponseCode() >= 400) {
            input = conn.getErrorStream();
        } else {
            input = conn.getInputStream();
        }

        byte[] body;
        if (input == null) {
            body = new byte[0];
        } else {
            try {
                byte[] buffer = new byte[8192];
                ByteArrayOutputStream output = new ByteArrayOutputStream();

                for(int bytes = input.read(buffer); bytes != -1; bytes = input.read(buffer)) {
                    output.write(buffer, 0, bytes);
                }

                body = output.toByteArray();
            } finally {
                input.close();
            }
        }

        return body;
    }
}
