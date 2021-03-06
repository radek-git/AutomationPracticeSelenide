package org.example;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit.ScreenShooter;
import org.junit.Rule;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public abstract class BaseTest {

    @Rule
    public ScreenShooter makeScreenshotOnFailure = ScreenShooter.failedTests();

    @BeforeTest
    public void setUp() {
        Configuration.startMaximized = true;
        Configuration.holdBrowserOpen = true;
        Configuration.screenshots = true;
        Configuration.reportsFolder = "test-results/reports";
    }

}
