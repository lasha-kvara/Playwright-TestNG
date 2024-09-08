package org.example.Drivers;

import com.microsoft.playwright.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Driver {

    public static Browser browser;

    public static BrowserContext browserContext;

    public static Page page;
    public static Playwright playwright;


    public Page InitializePlaywright() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        // Create a new browser context and set the viewport size
        BrowserContext context = browser.newContext(new Browser.NewContextOptions()
                .setViewportSize(1920, 1080)); // Set desired width and height

        browserContext = browser.newContext();
        page = browserContext.newPage();
        return page;
    }




    public void Dispose(){
        browser.close();
    }
}
