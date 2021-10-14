package com.epistrophe.pageObjects;

import org.apache.tika.language.LanguageIdentifier;
import org.apache.tika.language.detect.LanguageDetector;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public class PortfolioPage extends Page {

    @FindBy(linkText = "Next page")
    private WebElement nextButton;

    @FindBy(css = "div.container ul li.label")
    private WebElement categoryLabel;

    @FindBy(css = "ul li a img")
    private List<WebElement> locateSaleImage;

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

    public void clickOnlocateOrSaleImage(Integer elt){
        clickOn(locateSaleImage.get(Optional.of(elt).orElse(0)));
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
