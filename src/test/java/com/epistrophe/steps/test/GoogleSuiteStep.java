package com.epistrophe.steps.test;

import com.epistrophe.context.ScenarioContext;
import com.epistrophe.pageObjects.GoogleSuitePage;
import com.epistrophe.pageObjects.PortfolioPage;
import io.cucumber.java8.En;
import org.testng.Assert;

public class GoogleSuiteStep implements En {

    public GoogleSuiteStep(
            GoogleSuitePage googleSuitePage,
            ScenarioContext scenario
    ){

        Then("There is an empty space between the title and the list of applications presented below", () -> {
            Assert.assertEquals(googleSuitePage.verifyEmptySpace(),true);
        });

    }
}
