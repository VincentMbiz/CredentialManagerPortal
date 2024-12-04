package com.safetrust.hooks;


import com.safetrust.drivers.DriverFactory;
import com.safetrust.drivers.DriverManager;
import com.safetrust.helpers.PropertiesHelper;
import com.safetrust.pages.CommonPage;
import com.safetrust.pages.LoginPage;
import com.safetrust.utils.LogUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ThreadGuard;

public class TestContext {

    private WebDriver driver;
    private CommonPage commonPage;
    //private LoginCRMPage loginCRMPage;
    private LoginPage loginPage;

    public TestContext() {
        PropertiesHelper.loadAllFiles();
        ThreadGuard.protect(new DriverFactory().createDriver());
        LogUtils.info("Driver in TestContext: " + getDriver());
    }

    public CommonPage getCommonPage() {
        if (commonPage == null) {
            commonPage = new CommonPage();
        }
        return commonPage;
    }

    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    public WebDriver getDriver() {
        return DriverManager.getDriver();
    }
}

