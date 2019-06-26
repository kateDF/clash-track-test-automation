package com.karpuk.clashtrack.ui.test.context;

import com.karpuk.clashtrack.ui.core.page.HomePage;
import org.assertj.core.api.SoftAssertions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

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
    public SoftAssertions getSoftAssertions() {
        return new SoftAssertions();
    }

    @Bean
    @Scope("prototype")
    public HomePage getHomePage() {
        return new HomePage();
    }

}
