package com.epistrophe.steps.test;

import com.epistrophe.context.ScenarioContext;
import com.epistrophe.pageObjects.CertificatPage;
import io.cucumber.java8.En;
import org.testng.Assert;

public class CertificatStep implements En {

    public CertificatStep(
            CertificatPage certificatPage,
            ScenarioContext scenario
    ){

        Then("The SSL Certificates page is displayed", () -> {
            certificatPage.scrollToSslOffers();
        });

        Then("It is noted that the size of the package presentation components is disproportionate", () -> {
            certificatPage.saveScreenShotPNG();
            Assert.assertEquals(certificatPage.verifySslSize(),true);
        });

    }
}
