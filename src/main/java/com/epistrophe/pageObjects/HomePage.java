package com.epistrophe.pageObjects;

import com.google.common.base.Optional;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class HomePage extends Page {

    @FindBy(xpath = "//body/div[@id='Wrapper']/div[@id='mfn-offer-slider']/div[1]/div[1]")
    private WebElement caroussel;

    @FindBy(xpath = "//body/div[@id='Wrapper']/div[@id='Content']/div[1]/div[10]")
    private WebElement firstOffer;

    @FindBy(xpath = "//body/div[@id='Wrapper']/div[@id='Content']/div[1]/div[11]")
    private WebElement secondOffer;

    @FindBy(linkText = "Passez au Google Workspace ou à l'E-mail Pro")
    private WebElement firstCarousselElement;

    @FindBy(xpath = "//header/div[1]/div[1]/div[1]/div[1]/ul[1]/li[3]/a[1]")
    private WebElement twitterLogoHeader;

    @FindBy( css = "ul#menu-menu > li")
    private List<WebElement> lstNavBar;

    @FindBy(linkText = "Site web")
    private WebElement siteWebHeader;

    @FindBy(linkText = "Portfolio Sites Web")
    private WebElement portFolio;

    @FindBy(linkText = "Nom de domaine")
    private WebElement domainName;

    @FindBy(linkText = "Domaine en .Africa")
    private WebElement africaDomain;

    @FindBy(linkText = "Contacts & infos")
    private WebElement contactInfo;

    @FindBy(linkText = "Press book")
    private WebElement pressBook;

    @FindBy(linkText = "Messagerie Pro")
    private WebElement messageriePro;

    @FindBy(linkText = "Google Workspace")
    private WebElement googleWorspace;

    @FindBy(linkText = "Commandez votre nom de domaine")
    private WebElement commandDomainName;

    @FindBy(linkText = "Certificats SSL")
    private WebElement certificatSsl;

    @FindBy(linkText = "Offres Standard Epistrophe")
    private WebElement standardOffer;

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

    /*
    **/
    private final static By subMenuSelector = By.cssSelector("ul.sub-menu li");


    public HomePage() {
    }


    public void handleAccess() {
        waitForLoadingPage();
        try {
            driver.switchTo().frame(0);
            clickOn(messengerFrame);
        }catch (Exception e){}

        try {
            driver.switchTo().defaultContent();
            clickOn(adsFrame);
        }catch (Exception e){}

    }

    public void navigateToHomePage() {
        get(config.getEnvironment());
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

    private void clickOnNavBar( String elementNavigation, String subNavigation  ){
       WebElement button;
       WebElement perform = lstNavBar
                .stream()
                .filter( elt -> elt.getText().equals(elementNavigation))
                .findFirst()
                .get();

       if(perform == null) throw new RuntimeException("Perform Element not found !");

        action.moveToElement(perform).perform();
        button = perform.findElements(subMenuSelector)
                .stream()
                .filter( elt-> elt.getText().equals(subNavigation))
                .findFirst()
                .orElseThrow(()->new RuntimeException("Not element Found !"));

        clickOn(button);
        waitForLoadingPage();
    }

    private void clickOnHeaderMenu( WebElement movePerform, WebElement nextClick ){
        action.moveToElement(movePerform).perform();
        clickOn(nextClick);
        waitForLoadingPage();
    }

    public void clickOnPortFolio(){
        clickOnHeaderMenu(siteWebHeader, portFolio);
    }

    public void clickOnAfricaDomain(){
        clickOnHeaderMenu(domainName, africaDomain);
    }

    public void clickOnPressBook(){
        clickOnHeaderMenu(contactInfo, pressBook);
    }

    public void clickOnGoogleWorkspace(){
        action.moveToElement(messageriePro).perform();
        clickOn(googleWorspace);
        waitForLoadingPage();
    }

    public void clickOnStandardOffer(){
        action.moveToElement(certificatSsl).perform();
        clickOn(standardOffer);
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

    private boolean isLinkAttributePresent(WebElement element) {
        Boolean result = false;
        try {
            String value = element.getAttribute("href");
            if (value != null){
                result = true;
            }
        } catch (Exception e) {}

        return result;
    }

    public void goToElement(){
        longUntil(visibilityOf(firstCarousselElement));
        action.moveToElement(firstCarousselElement).perform();
    }

    private boolean isParagraphTag() {
        return firstCarousselElement.getTagName().equals("p");
    }

    public void scrollOnOffers(){
        scroll(firstOffer.getLocation().getY()+20);
    }

    public boolean isSameSize(){
        return (firstOffer.getSize().getHeight()==secondOffer.getSize().getHeight()
                && firstOffer.getSize().getWidth()==secondOffer.getSize().getWidth());
    }

    public boolean verifyPressBookLink(){
        return isLinkAttributePresent(pressBook);
    }

    public boolean verifyCarousselElement() {
        return (isLinkAttributePresent(firstCarousselElement)||isParagraphTag());
    }

    public boolean verifyOfferSize() {
        return isSameSize();
    }
}
