package com.karpuk.clashtrack.ui.test.base;

import com.karpuk.clashtrack.ui.core.driver.WebDriverManager;
import com.karpuk.clashtrack.ui.core.page.BasesCollectionPage;
import com.karpuk.clashtrack.ui.core.page.DashboardPage;
import com.karpuk.clashtrack.ui.core.page.HomePage;
import com.karpuk.clashtrack.ui.core.page.TroopCostCalculatorPage;
import com.karpuk.clashtrack.ui.test.context.AccountsContext;
import com.karpuk.clashtrack.ui.test.context.ConfigurationContext;
import com.karpuk.clashtrack.ui.test.service.SignInService;
import com.karpuk.clashtrack.ui.test.service.TroopCalculationService;
import org.assertj.core.api.SoftAssertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterMethod;

@ContextConfiguration(classes = {ConfigurationContext.class, AccountsContext.class})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class SpringAwareTestBase extends AbstractTestNGSpringContextTests {

    @Autowired
    protected HomePage homePage;
    @Autowired
    protected DashboardPage dashboardPage;
    @Autowired
    protected BasesCollectionPage basesCollectionPage;
    @Autowired
    protected TroopCostCalculatorPage troopCostCalculatorPage;

    @Autowired
    protected SignInService signInService;
    @Autowired
    protected TroopCalculationService troopCalculationService;

    @Value("${application.url}${application.url.lang}")
    protected String baseUrl;

    @Autowired
    protected SoftAssertions softAssert;

    @AfterMethod
    public void cleanUp() {
        WebDriverManager.closeDriver();
    }
}
