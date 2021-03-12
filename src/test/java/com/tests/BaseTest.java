package com.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    protected WebDriver driver;

    @BeforeTest
    public void setupDriver(ITestContext ctx) throws MalformedURLException {
        // BROWSER => chrome / firefox
        // HUB_HOST => localhost / 10.0.1.3 / hostname

        String host = "localhost";
        DesiredCapabilities dc;

        if(System.getProperty("BROWSER") != null &&
                System.getProperty("BROWSER").equalsIgnoreCase("firefox")){
            dc = DesiredCapabilities.firefox();
        } else dc = DesiredCapabilities.chrome();

        if(System.getProperty("HUB_HOST") != null) host = System.getProperty("HUB_HOST");

        String testName = ctx.getCurrentXmlTest().getName();
        dc.setCapability("name", testName);
        this.driver = new RemoteWebDriver(new URL("http://" + host + ":4444/wd/hub"),dc);
    }

    @AfterTest
    public void quitDriver(){
        this.driver.quit();
    }


    private void waiting(int mSecond) {
        try {
            Thread.sleep(mSecond);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
