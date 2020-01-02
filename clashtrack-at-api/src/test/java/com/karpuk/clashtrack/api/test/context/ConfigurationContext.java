package com.karpuk.clashtrack.api.test.context;

import com.karpuk.clashtrack.api.core.interceptor.RequestResponseLoggingInterceptor;
import com.karpuk.clashtrack.api.core.utils.RestContextHolder;
import com.karpuk.clashtrack.api.test.service.ClanSearchService;
import org.assertj.core.api.SoftAssertions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Configuration
@PropertySource("classpath:${env}.properties")
public class ConfigurationContext {

    @Bean
    @Scope("prototype")
    public static PropertySourcesPlaceholderConfigurer propertyConfig() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    @Scope("prototype")
    public RestTemplate getRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        restTemplate.setInterceptors(Collections.singletonList(new RequestResponseLoggingInterceptor()));
        return restTemplate;
    }

    @Bean
    @Scope("prototype")
    public SoftAssertions getSoftAssertions() {
        return new SoftAssertions();
    }

    @Bean
    @Scope("prototype")
    public RestContextHolder getRestContextHolder(@Value("${clash.api.url}") String url,
                                                  @Value("${clash.api.authorization.token}") String token) {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Authorization", "Bearer " + token);
        return new RestContextHolder(url, headers);
    }

    @Bean
    @Scope("prototype")
    public ClanSearchService getClanSearchService() {
        return new ClanSearchService();
    }

}
