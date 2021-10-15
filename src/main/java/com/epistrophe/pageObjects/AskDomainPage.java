package com.epistrophe.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class AskDomainPage extends Page{

    @FindBy(css = ".freebirdFormviewerViewNumberedItemContainer:nth-child(2) .quantumWizTextinputPaperinputInput")
    private WebElement domainWish;

    @FindBy(css = ".freebirdFormviewerViewNumberedItemContainer:nth-child(3) .quantumWizTextinputPaperinputInput")
    private WebElement name;

    @FindBy(css = ".freebirdFormviewerViewNumberedItemContainer:nth-child(4) .quantumWizTextinputPaperinputInput")
    private WebElement lastName;

    @FindBy(css = ".freebirdFormviewerViewNumberedItemContainer:nth-child(5) .quantumWizTextinputPaperinputInput")
    private WebElement email;

    @FindBy(css = ".freebirdFormviewerViewNumberedItemContainer:nth-child(6) .quantumWizTextinputPaperinputInput")
    private WebElement contact;

    @FindBy(css = ".appsMaterialWizButtonPaperbuttonFilled .appsMaterialWizButtonPaperbuttonLabel")
    private WebElement submit;

    @FindBy(css = ".freebirdFormviewerViewResponseConfirmationMessage")
    private WebElement infoRequest;

    public AskDomainPage() {
    }

    public void setField(WebElement element){
        clickOn(element);
        element.sendKeys("@@@@@@");
    }

    public void fillForm(){
        driver.switchTo().frame(0);
        setField(domainWish);
        setField(name);
        setField(lastName);
        setField(email);
        setField(contact);
        js.executeScript("arguments[0].click()", submit);
    }

    public boolean verifyFieldsControl(){
        middleUntil(visibilityOf(infoRequest));
        return !infoRequest.getText().contains("Votre commande a bien été reçu");
    }

}
