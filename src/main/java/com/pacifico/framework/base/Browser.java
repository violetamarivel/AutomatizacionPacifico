package com.pacifico.framework.base;

import org.openqa.selenium.WebDriver;

public class Browser extends Base {


    public BrowserType Type;
    private WebDriver _driver;

    public Browser(WebDriver driver) {
        _driver = driver;
    }

    public void GoToUrl(String url) {
        System.out.println("[" + url + "]");
        _driver.get(url);
    }

}
