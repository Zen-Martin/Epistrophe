package com.epistrophe.pageObjects;

import org.apache.tika.language.LanguageIdentifier;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PortfolioPage extends Page {

    @FindBy(linkText = "Next page")
    private WebElement nextButton;

    @FindBy(xpath = "//div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]")
    private WebElement categoryLabel;

    @FindBy(linkText = "Voir le site")
    private WebElement websiteAccess;

    @FindBy(linkText = "Portfolio item")
    private WebElement portfolioItem;

    @FindBy(xpath = "//div[@id='Content']/div[1]/div[2]/ul[1]/li[1]/a[1]/img[1]")
    private WebElement item;

    @FindBy(xpath = "//div[@id='Content']/div[1]/div[2]/ul/li/a")
    private List<WebElement> slider;

    public PortfolioPage() {
    }

    public boolean isLangageError(){
        LanguageIdentifier nextButtonLangage = new LanguageIdentifier(nextButton.getText());
        LanguageIdentifier categoryLabelLangage = new LanguageIdentifier(categoryLabel.getText());
        return (!nextButtonLangage.getLanguage().equals("fr") && !categoryLabelLangage.getLanguage().equals("fr"));
    }

    public void clickOnItem() {
        clickOn(item);
    }

    public void clickOnSale(){
        int c = 0;
        while (c==0 && nextButton.isDisplayed()){
            for( WebElement product : slider){

                try {
                    if(product.getAttribute("href").equals(config.getEnvironment()+"portfolio-item/oceane-service/")){
                        clickOn(product);
                        waitForLoadingPage();
                        c++;
                        break;

                    }}catch (Exception e){

                }

            }
            if(c==0){
                clickOn(nextButton);
                waitForLoadingPage();
            }

        }
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
