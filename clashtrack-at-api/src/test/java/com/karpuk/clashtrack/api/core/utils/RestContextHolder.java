package com.karpuk.clashtrack.api.core.utils;

import org.springframework.util.MultiValueMap;

public class RestContextHolder {

    private String url;
    private MultiValueMap<String, String> defaultHeaders;

    public RestContextHolder() {
    }

    public RestContextHolder(String url, MultiValueMap<String, String> defaultHeaders) {
        this.url = url;
        this.defaultHeaders = defaultHeaders;
    }

    public RestContextHolder(MultiValueMap<String, String> defaultHeaders) {
        this.defaultHeaders = defaultHeaders;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public MultiValueMap<String, String> getDefaultHeaders() {
        return defaultHeaders;
    }

    public void setDefaultHeaders(MultiValueMap<String, String> defaultHeaders) {
        this.defaultHeaders = defaultHeaders;
    }

    public String getClansSearchEndpoint() {
        return "/clans";
    }

}
