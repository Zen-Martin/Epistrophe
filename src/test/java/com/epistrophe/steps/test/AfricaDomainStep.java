package com.epistrophe.steps.test;

import com.epistrophe.context.ScenarioContext;
import com.epistrophe.pageObjects.AfricaDomainPage;
import io.cucumber.java8.En;
import org.testng.Assert;

public class AfricaDomainStep implements En {

    public AfricaDomainStep(
            AfricaDomainPage africaDomainPage,
            ScenarioContext scenario
    ){

        Then("A redirection is made to the site *epistrophe.africa*, that is not secure", () -> {
            Assert.assertEquals(africaDomainPage.verifyHeaderSecurity(),true);
        });

    }
}
