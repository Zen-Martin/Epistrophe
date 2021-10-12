package com.epistrophe.steps.test;

import com.epistrophe.context.ScenarioContext;
import com.epistrophe.pageObjects.HomePage;
import io.cucumber.java8.En;
import org.testng.Assert;

public class HomeStep implements En {

    public HomeStep(
            HomePage homePage,
            ScenarioContext scenario
    ){

        Given("I am on the homePage", () -> {
            homePage.navigateToHomePage();
        });

        When("Scroll down to the section *Nos références*, at the panel level *Contactez-nous* click on the Twitter link", () -> {
            homePage.scrollToTwitterReference();
            homePage.clickOnTwitterReference();
        });

        Then("A redirection is made to Twitter with a message mentioning that the page does not exist", () -> {
            homePage.saveScreenShotPNG();
            Assert.assertEquals(homePage.verifyTwitterLinkError(),true);
        });

        When("Click on the logo *g* of Google+ located at the header", () -> {
             homePage.clickOnGLogo();
        });

        Then("A redirection is made to the Instagram page of the Epistrophe site", () -> {
            homePage.saveScreenShotPNG();
            Assert.assertEquals(homePage.verifyLogoLinkError(),true);
        });

        When("In the navigation bar, put the cursor on *Site* and click on *Portfolio Site Web*", () -> {
            homePage.clickOnPortFolio();
        });

    }

}
