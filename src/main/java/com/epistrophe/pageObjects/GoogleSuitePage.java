package com.epistrophe.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleSuitePage extends Page{

    @FindBy(css = "#Content > div > div:nth-child(2) > div > iframe")
    private WebElement spaceFrame;

    public GoogleSuitePage() {
     }

     public boolean verifyEmptySpace(){
        return spaceFrame.getAttribute("src").contains("https");
     }

}
