package com.epistrophe.steps.test;

import com.epistrophe.pageObjects.Page;
import io.cucumber.java.After;

public class Hooks {
        @After()
        public void afterTakeScreenShot(){
            Page.saveScreenShotPNG();
    }

}
