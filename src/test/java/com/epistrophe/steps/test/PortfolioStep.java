package com.epistrophe.steps.test;

import com.epistrophe.context.ScenarioContext;
import com.epistrophe.pageObjects.PortfolioPage;
import io.cucumber.java8.En;
import org.testng.Assert;

public class PortfolioStep implements En {

    public PortfolioStep(
            PortfolioPage portfolioPage,
            ScenarioContext scenario
    ){

        Then("Page opens, some texts on the page are in English including *select category* and *next page*", () -> {
            portfolioPage.saveScreenShotPNG();
            Assert.assertEquals(portfolioPage.verifyElementLangage(),true);
        });

        When("Page opens click on the image with the text *La location et la vente*", () -> {
            portfolioPage.clickOnlocateOrSaleImage();
        });

        When("The page opens, click on *voir le site*", () -> {
            portfolioPage.clickOnWebsiteAccess();
        });

        Then("Displaying the page with a site unreachable error", () -> {
            portfolioPage.saveScreenShotPNG();
            Assert.assertEquals(portfolioPage.verifyWebsiteAccess(),true);
        });



    }

}
