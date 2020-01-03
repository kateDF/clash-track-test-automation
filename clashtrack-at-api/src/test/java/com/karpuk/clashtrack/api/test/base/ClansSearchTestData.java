package com.karpuk.clashtrack.api.test.base;

import org.testng.annotations.DataProvider;

public class ClansSearchTestData extends SpringAwareTestBaseApi {

    @DataProvider(name = "dp-min-clan-level")
    public Object[][] dataProviderMinClassLevel() {
        return new Object[][]{{"3"}, {"10"}, {"12"}
        };
    }

    @DataProvider(name = "dp-incorrect-min-clan-level")
    public Object[][] dataProviderIncorrectMinClassLevel() {
        return new Object[][]{{"0"}, {"1"}, {"-10"}
        };
    }

    @DataProvider(name = "dp-limits")
    public Object[][] dataProviderLimitNumberOfClans() {
        return new Object[][]{{"100"}, {"1"}, {"0"}
        };
    }

    @DataProvider(name = "dp-valid-clan-tags")
    public Object[][] dataProviderValidClanTags() {
        return new Object[][]{{"#PPGQJVC8"}, {"#RY089V89"}, {"#YLYQJ2QG"}
        };
    }

    @DataProvider(name = "dp-invalid-clan-tags")
    public Object[][] dataProviderInvalidClanTags() {
        return new Object[][]{{"invalid_class_tag"}, {"#0000000"}, {"=)"}
        };
    }

}
