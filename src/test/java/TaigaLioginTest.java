import api.Client;
import base.DriverHelper;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class TaigaLioginTest extends SeleniumBase {

    @Test
    public void loginViaApi() throws IOException {
        TaigaLoginPage taigaLoginPage = new TaigaLoginPage();
        login("sqa.days@yandex.ru", "Armenia2018");
         taigaLoginPage = new TaigaLoginPage();

    }

}
