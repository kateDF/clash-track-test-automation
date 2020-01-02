package com.karpuk.clashtrack.api.core.utils;

import org.springframework.util.MultiValueMap;

public class RestContextHolder {

    private String urlBase;
    private MultiValueMap<String, String> defaultHeaders;

    public RestContextHolder() {
    }

    public RestContextHolder(String urlBase, MultiValueMap<String, String> defaultHeaders) {
        this.urlBase = urlBase;
        this.defaultHeaders = defaultHeaders;
    }

    public RestContextHolder(MultiValueMap<String, String> defaultHeaders) {
        this.defaultHeaders = defaultHeaders;
    }

    public String getUrlBase() {
        return urlBase;
    }

    public MultiValueMap<String, String> getDefaultHeaders() {
        return defaultHeaders;
    }

    public String getClansSearchEndpoint() {
        return urlBase + "/clans";
    }

}
