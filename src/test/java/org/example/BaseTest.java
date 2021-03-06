package org.example;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {


    @BeforeMethod
    public void setUp() {
        Configuration.startMaximized = true;
        Configuration.holdBrowserOpen = true;
    }

}
