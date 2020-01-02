package com.karpuk.clashtrack.api.core.interceptor;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

import static com.karpuk.clashtrack.core.listener.TestListener.logInfo;

public class RequestResponseLoggingInterceptor implements ClientHttpRequestInterceptor {

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        logRequest(request, body);
        ClientHttpResponse response = execution.execute(request, body);
        logResponse(response);
        return response;
    }

    private void logRequest(HttpRequest request, byte[] body) throws IOException {
        logInfo("=================request begin=================");
        logInfo("URI         : " + request.getURI());
        logInfo("Method      : " + request.getMethod());
        logInfo("Headers     : " + request.getHeaders());
        logInfo("=================request end===================");
    }

    private void logResponse(ClientHttpResponse response) throws IOException {
        logInfo("================response begin================");
        logInfo("Status code  : " + response.getStatusCode());
        logInfo("Status text  : " + response.getStatusText());
        logInfo("Headers      : " + response.getHeaders());
        logInfo("================response end==================");
    }

}
