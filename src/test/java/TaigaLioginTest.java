import api.Client;
import base.DriverHelper;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class TaigaLioginTest extends SeleniumBase {
    private WebDriver driver = DriverHelper.get().getDriver();

    @Test
    public void loginViaApi() throws IOException {
        TaigaLoginPage taigaLoginPage = new TaigaLoginPage();
        JsonObject loginJson = Client.login("sqa.days@yandex.ru", "Armenia2018");

        ((JavascriptExecutor) driver)
                .executeScript(
                        "window.localStorage.setItem('token','" + loginJson.get("auth_token") + "');");
        ((JavascriptExecutor) driver)
                .executeScript("window.localStorage.setItem('userInfo','" + loginJson + "');");

        taigaLoginPage = new TaigaLoginPage();

    }

}
