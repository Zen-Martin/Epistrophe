package com.epistrophe.steps.test;

//import cucumber.api.java.After
import com.epistrophe.pageObjects.Page;

public class Hooks {

    Hooks(){}

    //@After( value = "@screen")
    public void afterTakeScreenShot(){
        Page.saveScreenShotPNG();
    }

}
