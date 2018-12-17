import api.Client;
import base.DriverHelper;
import com.google.gson.JsonObject;
import io.qameta.allure.Attachment;
import listerners.SuiteListener;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;

import java.io.File;
import java.io.IOException;

@Listeners(SuiteListener.class)
public class SeleniumBase implements IHookable {
    private static final Logger LOGGER = Logger.getLogger("SeleniumBase");
    private WebDriver driver = DriverHelper.get().getDriver();

    @AfterMethod
    public void tearDown() {
        DriverHelper.get().quitDriver(DriverHelper.get().getDriver());
    }

    public void login(String username, String password) throws IOException {
        JsonObject loginJson = Client.login(username, password);
        new TaigaLoginPage();
        ((JavascriptExecutor) driver)
                .executeScript(
                        "window.localStorage.setItem('token','" + loginJson.get("auth_token") + "');");
        ((JavascriptExecutor) driver)
                .executeScript("window.localStorage.setItem('userInfo','" + loginJson + "');");

    }

    @Override
    public void run(IHookCallBack callBack, ITestResult testResult) {
        callBack.runTestMethod(testResult);
        if (testResult.getThrowable() != null) {
            try {
                takeScreenshot(testResult.getMethod().getMethodName());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Attachment(value = "Failure in method {0}", type = "image/png")
    private byte[] takeScreenshot(String methodName) throws IOException {
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("./target/screenshots/" + methodName + ".png"));
        LOGGER.error("****** Taking a screenshot on failure");
        return  ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }
}
