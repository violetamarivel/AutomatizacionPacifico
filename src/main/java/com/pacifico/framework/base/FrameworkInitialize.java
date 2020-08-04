package com.pacifico.framework.base;

import com.pacifico.framework.config.Settings;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

import java.util.HashMap;
import java.util.Map;

public class FrameworkInitialize extends Base {

    public static void InitializeBrowser(BrowserType browserType, DeviceType deviceType) {

        WebDriver driver = null;
        DesiredCapabilities capabilities = null;
        Map<String, Object> chromeOptions = new HashMap<>();
        String pathDriver = Settings.DriversPath;
        String extension = "";

        String osFound = System.getProperty("os.name").toLowerCase();
        if (osFound.contains("windows")) {
            pathDriver += "win";
            extension = ".exe";
        } else if (osFound.contains("linux")) {
            pathDriver += "linux";
        } else {
            pathDriver += "mac";
        }

        Settings.Logs.Write("Configuration properties :: Browser [" + Settings.BrowserType + "] - Device [" + Settings.DeviceType + "] - Operative System [" + osFound + "]");
        Settings.Logs.Write("Environment " + Settings.EmailEnv);
        System.out.println("==============================================");
        System.out.println(" Environment " + Settings.EmailEnv + " - Browser [" + Settings.BrowserType + "]");
        System.out.println("==============================================");

        switch (deviceType) {

            case PC: {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--disable-extensions");
                options.addArguments("--start-maximized");
                if (Settings.BrowserLess.equals("true")) {
                    options.addArguments("--headless", "window-size=1024,768", "--no-sandbox");
                }
                capabilities = DesiredCapabilities.chrome();
                capabilities.setCapability(ChromeOptions.CAPABILITY, options);
                break;
            }
            case PCMobile: {

                Map<String, Object> deviceMetrics = new HashMap<String, Object>();
                deviceMetrics.put("width", Settings.PCMWidth);
                deviceMetrics.put("height", Settings.PCMHeight);
                deviceMetrics.put("pixelRatio", Settings.PCMPixel);
                Map<String, Map<String, Object>> mobileEmulation = new HashMap<>();

                mobileEmulation.put("deviceMetrics", deviceMetrics);

                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--disable-extensions");
                options.addArguments("--use-fake-ui-for-media-stream=1");
                options.addArguments("--window-size=" + Settings.PCMWidth + "," + Settings.PCMHeight);

                chromeOptions.put("mobileEmulation", mobileEmulation);
                capabilities = DesiredCapabilities.chrome();
                capabilities.setCapability(ChromeOptions.CAPABILITY, options);
                break;
            }
            case Mobile: {
                break;
            }
            default: {

            }
        }

        switch (browserType) {
            case Chrome: {
                System.setProperty("webdriver.chrome.driver", pathDriver + "/chromedriver" + extension);
                driver = new ChromeDriver(capabilities);
                break;
            }
            case Firefox: {
                System.setProperty("webdriver.gecko.driver", pathDriver + "/geckodriver" + extension);
                driver = new FirefoxDriver();
                break;
            }
            case Safari: {
                driver = new SafariDriver();
                break;
            }
        }

        DriverContext.setDriver(driver);
        DriverContext.Browser = new Browser(driver);

    }

}
