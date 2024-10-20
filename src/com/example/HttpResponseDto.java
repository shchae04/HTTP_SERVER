package com.example;

public class HttpResponseDto {

    private String responseData;

    /**
     *
     * @param responseData responseData from the server (HTML, json...)
     */
    public HttpResponseDto(String responseData) {
        this.responseData = responseData;
    }

    /**
     *
     * @return getResponseData received from the server
     */
    public String getResponseData() {
        return responseData;
    }

}
