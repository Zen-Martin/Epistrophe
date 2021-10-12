package com.epistrophe.pageObjects;

import com.epistrophe.config.Configuration;
import com.epistrophe.config.Properties;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class HomePage extends Page {

    @FindBy(xpath = "//header/div[1]/div[1]/div[1]/div[1]/ul[1]/li[3]/a[1]")
    private WebElement twitterLogoHeader;

    @FindBy(xpath = "//header/div[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/a[1]")
    private WebElement gLogoHeader;

    @FindBy(partialLinkText = "https://twitter.com/")
    private WebElement twitterReferenceLink;

    @FindBy(id = "logo")
    private WebElement logo;

    @FindBy(css = ".\\_9q4i svg")
    private WebElement messengerFrame;

    @FindBy(css = ".sgpb-popup-close-button-1")
    private WebElement adsFrame;

    private final static Configuration PROP  = Properties.Config;

    public HomePage() {
    }


    public void handleAccess() {
        waitForLoadingPage();
        driver.switchTo().frame(0);
        clickOn(messengerFrame);
        driver.switchTo().defaultContent();
        clickOn(adsFrame);
    }

    public void navigateToHomePage() {
        get(PROP.getEnvironment());
        handleAccess();
    }

    public void scrollToTwitterReference(){
        shortUntil(visibilityOf(twitterReferenceLink));
        scroll((twitterReferenceLink.getLocation().getY()-15));
    }

    public boolean isTwitterLinkError(){
        return (!twitterLogoHeader.getAttribute("href")
                                  .equals(twitterReferenceLink.getAttribute("href")));
    }

    public boolean isLogoLinkError(){
        return (!gLogoHeader.getAttribute("href")
                                 .contains(gLogoHeader.getAttribute("title").toLowerCase()));
    }

    public void switchOnTab(int tabNumber){
        ArrayList<String> Tab = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(Tab.get(tabNumber));
    }

    public void clickOnTwitterReference(){
        clickOn(twitterReferenceLink);
        switchOnTab(1);
        waitForLoadingPage();
    }

    public void clickOnGLogo(){
        clickOn(gLogoHeader);
        switchOnTab(1);
        waitForLoadingPage();
    }

    public boolean verifyTwitterLinkError(){
        switchOnTab(0);
        return !isTwitterLinkError();
    }

    public boolean verifyLogoLinkError(){
        switchOnTab(0);
        return !isLogoLinkError();
    }

}
