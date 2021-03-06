package org.example;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {
    public static void capture(WebDriver webdriver, String tag) {
        try {
            Thread.sleep(500);
            Shutterbug.shootPage(webdriver).save();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
