package com.epistrophe.steps.test;

import com.epistrophe.context.ScenarioContext;
import com.epistrophe.pageObjects.AskDomainPage;
import io.cucumber.java8.En;
import org.testng.Assert;

public class AskDomainStep implements En {

    public AskDomainStep(
            AskDomainPage askDomainPage,
            ScenarioContext scenario
    ){

        When("Fill in all the form fields with *@@@@@* and send", () -> {
            askDomainPage.fillForm();
        });

        Then("The form is sent successfully although the values are incorrect", () -> {
            Assert.assertEquals(askDomainPage.verifyFieldsControl(),true);
        });

    }
}
