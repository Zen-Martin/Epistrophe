package com.epistrophe.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleSuitePage extends Page{

    @FindBy(css = "div.article_video")
    private WebElement spaceUnderHeader;

    public GoogleSuitePage() { }

    // SSL
     public boolean verifyEmptySpace(){
        return !spaceUnderHeader.getText().isEmpty();
     }


}
