import api.Client;
import base.DriverHelper;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;

import static java.sql.DriverManager.getDriver;
import static org.testng.Assert.assertTrue;

public class TaigaProjectsTest extends SeleniumBase {

    @Test
    public void projectPage(Method method) throws IOException {
        Client.login("sqa.days@yandex.ru", "Armenia2018");
        String projectName = method.getName() + new Date().getTime();
        JsonObject project = new JsonObject();
        project.addProperty("name", projectName);
        project.addProperty("description", "Test Project via Api Description");
        project.addProperty("creation_template", 1);
        project.addProperty("is_private", false);
        Client.createProject(project);

    }

}
