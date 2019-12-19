package com.karpuk.clashtrack.ui.test.context;

import com.karpuk.clashtrack.ui.core.page.*;
import com.karpuk.clashtrack.ui.test.service.SignInService;
import com.karpuk.clashtrack.ui.test.service.TroopCalculationService;
import com.karpuk.clashtrack.ui.test.service.WarWeightCalculationService;
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

    @Bean
    @Scope("prototype")
    public AccountsGooglePage getAccountsGooglePage() {
        return new AccountsGooglePage();
    }

    @Bean
    @Scope("prototype")
    public DashboardPage getDashboardPage() {
        return new DashboardPage();
    }

    @Bean
    @Scope("prototype")
    public BasesCollectionPage getBasesCollectionPage() {
        return new BasesCollectionPage();
    }

    @Bean
    @Scope("prototype")
    public TroopCostCalculatorPage getTroopCostCalculatorPage() {
        return new TroopCostCalculatorPage();
    }

    @Bean
    @Scope("prototype")
    public BaseLayoutPage getBaseLayoutPage() {
        return new BaseLayoutPage();
    }

    @Bean
    @Scope("prototype")
    public WarWeightCalculatorPage getWarWeightCalculatorPage() {
        return new WarWeightCalculatorPage();
    }

    @Bean
    @Scope("prototype")
    public SignInService getSignInService() {
        return new SignInService();
    }

    @Bean
    @Scope("prototype")
    public TroopCalculationService getTroopCalculationService() {
        return new TroopCalculationService();
    }

    @Bean
    @Scope("prototype")
    public WarWeightCalculationService getWarWeightCalculationService() {
        return new WarWeightCalculationService();
    }

}
