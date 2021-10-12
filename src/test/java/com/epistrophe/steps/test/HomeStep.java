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

        When("Scroll down to the section {string}, at the panel level {string} click on the Twitter link", (String string, String string2) -> {
            homePage.scrollToTwitterReference();
            homePage.clickOnTwitterReference();
        });

        Then("A redirection is made to Twitter with a message mentioning that the page does not exist", () -> {
            homePage.verifyTwitterLinkError();
            homePage.saveScreenShotPNG();
            Assert.assertEquals(homePage.verifyTwitterLinkError(),true);
        });

        When("Click on the logo {string} of Google+ located at the header", (String string) -> {
             homePage.clickOnGLogo();
        });

        Then("A redirection is made to the Instagram page of the Epistrophe site", () -> {
            homePage.verifyLogoLinkError();
        });

    }

}
