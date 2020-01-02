package com.karpuk.clashtrack.api.test.base;


import com.karpuk.clashtrack.api.test.context.ConfigurationContext;
import com.karpuk.clashtrack.api.test.service.ClanSearchService;
import org.assertj.core.api.SoftAssertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

@ContextConfiguration(classes = {ConfigurationContext.class})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class SpringAwareTestBaseApi extends AbstractTestNGSpringContextTests {

    @Autowired
    protected SoftAssertions softAssert;

    @Autowired
    protected ClanSearchService clanSearchService;

}
