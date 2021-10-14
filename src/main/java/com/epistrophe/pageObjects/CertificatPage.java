package com.epistrophe.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CertificatPage extends Page{

    @FindBy(xpath = "//div[@id='Content']/div[1]/div[4]")
    private WebElement sslDv;

    @FindBy(xpath = "//div[@id='Content']/div[1]/div[5]")
    private WebElement sslOv;

    @FindBy(xpath = "//div[@id='Content']/div[1]/div[6]")
    private WebElement sslEv;

    public CertificatPage() { }

    public void scrollToSslOffers(){
        scroll(sslDv.getLocation().getY()+30);
    }

    public boolean isSslSameHeight(){
        return (sslDv.getSize().getHeight() == sslOv.getSize().getHeight()) &&(sslDv.getSize().getHeight() == sslEv.getSize().getHeight());
    }

    public boolean isSslSameWidth(){
        return (sslDv.getSize().getWidth() == sslOv.getSize().getWidth()) &&(sslDv.getSize().getWidth() == sslEv.getSize().getWidth());
    }

    public boolean verifySslSize(){
        return (isSslSameHeight() && isSslSameWidth());
    }

}
