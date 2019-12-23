package com.karpuk.clashtrack.ui.test.context;

import com.karpuk.clashtrack.ui.core.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource("classpath:accounts.properties")
public class AccountsContext {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfig() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public User mainUser(@Value("${clashtrack.ui.user.login}") String email,
                         @Value("${clashtrack.ui.user.password}") String password,
                         @Value("${clashtrack.ui.user.name}") String name) {
        return new User(email, password, name);
    }

}
