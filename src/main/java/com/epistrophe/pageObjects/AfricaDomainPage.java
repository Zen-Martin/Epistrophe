package com.epistrophe.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AfricaDomainPage extends Page{

    @FindBy(css = ".sgpb-popup-close-button-1")
    private WebElement adsFrame;

    public AfricaDomainPage() {
    }

    public boolean verifyHeaderSecurity(){
        return driver.getCurrentUrl().contains("https");
    }


}
