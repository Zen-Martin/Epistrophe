package com.epistrophe.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class HomePage extends Page {

    @FindBy(xpath = "//div[@id='mfn-offer-slider']/div[1]/div[1]")
    private WebElement caroussel;

    @FindBy(xpath = "//div[@id='Content']/div[1]/div[10]")
    private WebElement firstOffer;

    @FindBy(xpath = "//div[@id='Content']/div[1]/div[11]")
    private WebElement secondOffer;

    @FindBy(linkText = "Passez au Google Workspace ou à l'E-mail Pro")
    private WebElement firstCarousselElement;

    @FindBy(xpath = "//header/div[1]/div[1]/div[1]/div[1]/ul[1]/li[3]/a[1]")
    private WebElement twitterLogoHeader;

    @FindBy(linkText = "Press book")
    private WebElement pressBook;

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

    @FindBy( css = "ul.menu li")
    private List<WebElement> listNavBar;

    private final static By subMenuSelector = By.cssSelector("ul.menu li a");

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

    private void clickOnNavBarItem( String elementNavigation, String itemNavigation  ){
        WebElement button;
        WebElement perform = listNavBar
                .stream()
                .filter( elt -> elt.getText().equals(elementNavigation))
                .findFirst()
                .get();

        if(perform == null) throw new RuntimeException("Perform Element not found !");

        action.moveToElement(perform).perform();
        button = perform.findElements(subMenuSelector)
                .stream()
                .filter( elt-> elt.getText().equals(itemNavigation))
                .findFirst()
                .orElseThrow(()->new RuntimeException("Not element Found !"));

        clickOn(button);
        waitForLoadingPage();
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

    public void clickOnPortFolio(){
        clickOnNavBarItem("Site web","Portfolio Sites Web");
    }

    public void clickOnAfricaDomain(){
        clickOnNavBarItem("Nom de domaine","Domaine en .Africa");
    }

    public void clickOnPressBook(){
        clickOnNavBarItem("Contacts & infos", "Press book");
    }

    public void clickOnGoogleWorkspace(){
        clickOnNavBarItem("Messagerie Pro","Google Workspace");
    }

    public void clickOnStandardOffer(){
        clickOnNavBarItem("Certificats SSL","Offres Standard Epistrophe");
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
