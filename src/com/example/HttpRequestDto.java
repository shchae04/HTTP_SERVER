package com.example;

import java.util.ArrayList;
import java.util.Arrays;

public class HttpRequestDto {
    private String method;
    private String requestUrl;

    /**
     * Constructor : HTTP Request(String) method, requestUrl setting
     * @param httpRequest : Received from the client
     */
    public HttpRequestDto(String httpRequest) {
        // Request Split "GET /api/v1 HTTP/1.1" -> ["GET", "/api/v1", "HTTP/1.1"]
        ArrayList<String> requestList = new ArrayList<>(Arrays.asList(httpRequest.split(" ")));
        method = requestList.get(0);
        requestUrl = requestList.get(1);
    }

    /**
     *
     * @return HTTP Method(GET, POST...)
     */
    public String getMethod() {
        return method;
    }

    /**
     *
     * @return Requested URL
     */
    public String getRequestUrl() {
        return requestUrl;
    }
}
