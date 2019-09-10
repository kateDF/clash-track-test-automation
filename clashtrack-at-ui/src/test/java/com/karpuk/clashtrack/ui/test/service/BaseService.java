package com.karpuk.clashtrack.ui.test.service;

import com.karpuk.clashtrack.ui.core.page.AccountsGooglePage;
import com.karpuk.clashtrack.ui.core.page.HomePage;
import com.karpuk.clashtrack.ui.core.page.TroopCostCalculatorPage;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseService {

    @Autowired
    protected HomePage homePage;

    @Autowired
    protected AccountsGooglePage accountsGooglePage;

    @Autowired
    protected TroopCostCalculatorPage troopCostCalculatorPage;

}
