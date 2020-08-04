package com.pacifico.test.steps;

import com.pacifico.framework.base.DriverContext;
import com.pacifico.framework.base.FrameworkInitialize;
import com.pacifico.framework.config.ConfigReader;
import com.pacifico.framework.config.Settings;
import com.pacifico.framework.utilities.CommonUtil;
import com.pacifico.framework.utilities.LogUtil;
import com.pacifico.framework.utilities.ScreenRecordUtil;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;

public class TestInitialize extends FrameworkInitialize {

    @Before
    public void Initialize(Scenario scenario) throws Exception {

        //Initialize Config
        ConfigReader.PopulateSettings();

        //Logging
        Settings.Logs = new LogUtil();
        Settings.Logs.CreateLogFile();
        Settings.Logs.Write("Framework Initialize");

        InitializeBrowser(Settings.BrowserType, Settings.DeviceType);

        Capabilities cap = ((RemoteWebDriver) DriverContext.Driver).getCapabilities();
        Settings.Logs.Write("Device - Browser initialized :: Platform [" + cap.getPlatform() + "] - Browser [" + cap.getBrowserName() + "] - Version [" + cap.getVersion() + "]");
        DriverContext.Driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        if (Settings.RecordVideo.equals("true")) {
            ScreenRecordUtil.startRecording();
        }
    }

    @After
    public void TearDown(Scenario scenario) {

//        Settings.Logs.Write("Feature : " + CommonUtil.getFeatureName(scenario.getId()));
//        Settings.Logs.Write("Tags : " + CommonUtil.getTagsName(scenario.getSourceTagNames()));
//        Settings.Logs.Write("Scenario : " + scenario.getName());
//        Settings.Logs.Write("Status : " + scenario.getStatus());

        if (scenario.isFailed()) {
            if (!CommonUtil.getFeatureName(scenario.getId()).contains("services")) {
                CommonUtil.embedScreenshot(DriverContext.Driver, scenario);
                CommonUtil.takeScreenshot(DriverContext.Driver, scenario);
            }

        }

        System.out.println("#####################################################################");
        System.out.println("Scenario [" + scenario.getName() + "] - Status [" + scenario.getStatus() + "]");
        System.out.println("#####################################################################");

        if (Settings.RecordVideo.equals("true")) {
            ScreenRecordUtil.stopRecording(scenario.getName());
        }

        CommonUtil.deleteAllCookies();
        if (Settings.BrowserClose.equals("true")) {
            DriverContext.Driver.quit();
        }
    }
}