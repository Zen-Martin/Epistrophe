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

        When("In the navigation bar, put the cursor on *Nom de domaine* and click on *Domaine en .Africa*", () -> {
            homePage.clickOnAfricaDomain();
        });

        When("In the navigation bar, put the cursor on *Contacts & infos* and click on *Press book*", () -> {
            homePage.clickOnPressBook();
        });

        Then("No reaction, the link is not associated with any url", () -> {
            homePage.saveScreenShotPNG();
            Assert.assertEquals(homePage.verifyPressBookLink(),true);
        });

        When("In the carousel, overlay the black text on the slides", () -> {
            homePage.goToElement();
        });

        Then("Text are placed in <a> tags instead of <p>", () -> {
            homePage.saveScreenShotPNG();
            Assert.assertEquals(homePage.verifyCarousselElement(),true);
        });

        When("Scroll down to the offers", () -> {
            homePage.scrollOnOffers();
        });

        Then("Note that the elements are note aligned", () -> {
            homePage.saveScreenShotPNG();
            Assert.assertEquals(homePage.verifyOfferSize(),true);
        });

        When("In the navigation bar, put the cursor on *Messagerie Pro* and click on *Google Workspace*", () -> {
            homePage.clickOnGoogleWorkspace();
        });




    }

}
