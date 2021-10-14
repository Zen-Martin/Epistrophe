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
            Assert.assertEquals(portfolioPage.verifyElementLangage(),true);
        });

        When("Page opens click on the image with the text *La location et la vente*", () -> {
            portfolioPage.clickOnSale();
        });

        When("The page opens, click on *voir le site*", () -> {
            portfolioPage.clickOnWebsiteAccess();
        });

        Then("Displaying the page with a site unreachable error", () -> {
            Assert.assertEquals(portfolioPage.verifyWebsiteAccess(),true);
        });

        When("Page opens click on one item, in the breadcrumb trail below the title click on *Portfolio item*", () -> {
            portfolioPage.clickOnItem();
            portfolioPage.clickOnPortfolioItem();
        });

        Then("A {int} error page is displayed", (Integer int1) -> {
            Assert.assertEquals(portfolioPage.verifyPortfolioItem(),true);
        });
    }

}
