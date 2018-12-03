import api.ApiHelper;
import api.Client;
import com.google.gson.JsonObject;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;

public class TaigaProjectsTest extends SeleniumBase {

    @Test
    public void projectPage(Method method) throws IOException {
        Client.login("sqa.days@yandex.ru", "Armenia2018");

        JsonObject project = ApiHelper.createProject();
        JsonObject issue = ApiHelper.createIssue(project.get("id").getAsInt());

        login("sqa.days@yandex.ru", "Armenia2018");
        TaigaProjectPage projectPage = new TaigaProjectPage(project);

    }

}
