package com.example;

public class Dispatcher {

    public HttpHandler dispatch(HttpRequestDto requestDto) throws Exception {
        String method = requestDto.getMethod();
        String requestUrl = requestDto.getRequestUrl();

        if (method.equals("GET")) {
            //
        } else {
            throw new Exception("Not Supported method");
        }
        return null;
    }
}
