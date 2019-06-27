package com.karpuk.clashtrack.ui.test.base;

import com.karpuk.clashtrack.ui.core.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class BaseTestData extends SpringAwareTestBase {

    @Autowired
    @Qualifier("mainUser")
    protected User user;

}
