package com.epistrophe.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleSuitePage extends Page{

    @FindBy(xpath = "//body/div[@id='Wrapper']/div[@id='Content']/div[1]/div[2]/div[1]")
    private WebElement spaceUnderHeader;

    public GoogleSuitePage() {

     }

     public boolean verifyEmptySpace(){
        return !spaceUnderHeader.getText().isEmpty();
     }


}
