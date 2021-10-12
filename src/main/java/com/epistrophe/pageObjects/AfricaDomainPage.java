package com.epistrophe.pageObjects;

import com.epistrophe.config.Configuration;
import com.epistrophe.config.Properties;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AfricaDomainPage extends Page{

    @FindBy(css = ".sgpb-popup-close-button-1")
    private WebElement adsFrame;

    private final static Configuration PROP  = Properties.Config;

    public AfricaDomainPage() {

    }

    public boolean verifyHeaderSecurity(){
        return driver.getCurrentUrl().contains("https");
    }



}
