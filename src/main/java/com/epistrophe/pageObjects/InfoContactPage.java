package com.epistrophe.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;


public class InfoContactPage extends Page{

    @FindBy(xpath = "//a[contains(text(),'Poster sa candidature')]")
    private WebElement askJob;

    @FindBy(css = "div.wpcf7-response-output:nth-child(7)")
    private WebElement infoRequest;

    @FindBy(css = "span.wpcf7-form-control-wrap.file-14 input")
    private WebElement myCV;

    @FindBy(css = "span.wpcf7-form-control-wrap.file-71 input")
    private WebElement coverLetter;

    @FindBy(css = "span.wpcf7-form-control-wrap.your-name input")
    private WebElement name;

    @FindBy(css = "span.wpcf7-form-control-wrap.your-email input")
    private WebElement email;

    @FindBy(css = "input.wpcf7-form-control.has-spinner.wpcf7-submit")
    private WebElement submit;

    @FindBy(className = "wpcf7-spinner")
    private WebElement verification;

    @FindBy(className = "wpcf7-not-valid-tip")
    private WebElement fieldError;

    public InfoContactPage() {
    }

    public void clickOnCandidature(){
        js.executeScript("arguments[0].click()", askJob);
        waitForLoadingPage();
    }

    public void clickOnSubmit(){
        clickOn(submit);
        waitForLoadingPage();
    }

    public void FillForm(String requirement){
        name.sendKeys(config.getEmail().substring(0,4));
        email.sendKeys(config.getEmail());
        if(requirement.equals("complete"))
        {
            myCV.sendKeys(System.getProperty("user.dir")+"/src/test/resources/document/cv-modele.docx");
            coverLetter.sendKeys(System.getProperty("user.dir")+"/src/test/resources/document/cover-letter.pdf");
        }
    }

    public boolean verifyFieldsError(){
        middleUntil(visibilityOf(infoRequest));
        return !infoRequest.getText().contains("Un ou plusieurs champs contiennent une erreur");
    }

    public boolean verifyMandatoryFields(){
        middleUntil(visibilityOf(infoRequest));
        return !infoRequest.getText().contains("Il a bien été envoyé");
    }


}
