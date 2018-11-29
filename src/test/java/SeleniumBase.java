import api.Client;
import base.DriverHelper;
import com.google.gson.JsonObject;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

import java.io.IOException;


public class SeleniumBase {
    private WebDriver driver = DriverHelper.get().getDriver();

    @AfterMethod
    public void tearDown() {
        DriverHelper.get().quitDriver(DriverHelper.get().getDriver());
    }

    public void login(String username, String password) throws IOException {
        JsonObject loginJson = Client.login(username, password);
        ((JavascriptExecutor) driver)
                .executeScript(
                        "window.localStorage.setItem('token','" + loginJson.get("auth_token") + "');");
        ((JavascriptExecutor) driver)
                .executeScript("window.localStorage.setItem('userInfo','" + loginJson + "');");

    }

}
