package com.epistrophe.steps.test;

import com.epistrophe.context.ScenarioContext;
import com.epistrophe.pageObjects.InfoContactPage;
import io.cucumber.java8.En;
import org.testng.Assert;

public class InfoContactStep implements En {

    public InfoContactStep(
            InfoContactPage infoContactPage,
            ScenarioContext scenario
    ){

        When("Scroll down and click on *poser sa candidature*", () -> {
            infoContactPage.clickOnCandidature();
        });

        When("Fill in the fields and select a word file for the cover letter and a PDF for the CV", () -> {
            infoContactPage.FillForm("complete");
        });

        When("Click on *Envoyer*", () -> {
            infoContactPage.clickOnSubmit();
        });

        Then("Errors are mentionned underneath that the files are not allowed", () -> {
            Assert.assertEquals(infoContactPage.verifyFieldsError(),true);
        });

        When("Fill in the fields without selecting a file for the CV and the cover letter", () -> {
            infoContactPage.FillForm("");
        });

        Then("Make the CV and cover letter fields mandatory", () -> {
            Assert.assertEquals(infoContactPage.verifyMandatoryFields(),true);
        });

    }
}
