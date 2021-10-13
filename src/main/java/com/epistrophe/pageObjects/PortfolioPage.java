package com.epistrophe.pageObjects;

import org.apache.tika.language.LanguageIdentifier;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PortfolioPage extends Page {

    @FindBy(linkText = "Next page")
    private WebElement nextButton;

    @FindBy(xpath = "//body/div[@id='Wrapper']/div[@id='Content']/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]")
    private WebElement categoryLabel;

    @FindBy(xpath = "//body/div[@id='Wrapper']/div[@id='Content']/div[1]/div[2]/ul[1]/li[6]/a[1]/img[1]")
    private WebElement locateSaleImage;

    @FindBy(linkText = "Voir le site")
    private WebElement websiteAccess;

    @FindBy(linkText = "Portfolio item")
    private WebElement portfolioItem;

    public PortfolioPage() {
    }

    public boolean isLangageError(){
        LanguageIdentifier nextButtonLangage = new LanguageIdentifier(nextButton.getText());
        LanguageIdentifier categoryLabelLangage = new LanguageIdentifier(categoryLabel.getText());
        return (!nextButtonLangage.getLanguage().equals("fr") && !categoryLabelLangage.getLanguage().equals("fr"));
    }

    public void clickOnlocateOrSaleImage(){
        clickOn(locateSaleImage);
    }

    public boolean verifyElementLangage(){
        return !isLangageError();
    }

    public void clickOnWebsiteAccess(){
        clickOn(websiteAccess);
    }

    public void clickOnPortfolioItem(){
        clickOn(portfolioItem);
    }

    public boolean verifyWebsiteAccess(){
        return verifyLink(websiteAccess);
    }

    public boolean verifyPortfolioItem(){
        return !driver.getTitle().contains("Page Not Found");
    }

}
