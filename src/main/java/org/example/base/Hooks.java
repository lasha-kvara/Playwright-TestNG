package org.example.base;

import org.example.Drivers.Driver;
//import org.example.Env.EnvironmentType;
import com.microsoft.playwright.*;
import org.example.utils.ConfigReader;
import org.testng.annotations.*;

public class Hooks{
    private Driver _driver = new Driver();
    private Page _page;
    public static String baseUrl = GetEnvUrl("live");


    @BeforeMethod
    public void BeforeTest(){
        _page = _driver.InitializePlaywright();
        MaximizeWindow();
        GoToUrl(baseUrl);
    }
    public Page Page() { return _page; }

    @AfterMethod
    public void AfterTest(){
        _driver.Dispose();
    }

    private void MaximizeWindow() {
        _page.setViewportSize(1920, 900);
    }

    private void GoToUrl(String url){
        _page.navigate(url);
    }

    private static String GetEnvUrl(String env){
        switch (env.toLowerCase()){
            case "dev":
                return ConfigReader.getProperty("devUrl");
            case "staging":
                return ConfigReader.getProperty("stageUrl");
            case "live":
                return ConfigReader.getProperty("liveUrl");
            default: throw new RuntimeException();
        }
    }
}
