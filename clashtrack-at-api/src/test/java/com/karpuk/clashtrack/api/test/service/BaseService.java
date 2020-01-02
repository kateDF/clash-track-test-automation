package com.karpuk.clashtrack.api.test.service;

import com.karpuk.clashtrack.api.core.utils.RestContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class BaseService {

    @Autowired
    protected RestTemplate restTemplate;

    @Autowired
    protected RestContextHolder restContextHolder;

}
