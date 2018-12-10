import api.ApiHelper;
import api.Client;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;

public class TaigaProjectsTest extends SeleniumBase {
    private JsonObject project;
    private JsonObject issue;
    private JsonArray allProjects;

    @BeforeMethod
    public void setUpMethod() throws IOException {
        Client.login("sqa.days@yandex.ru", "Armenia2018");
        allProjects = ApiHelper.getAllProjects();
        project = ApiHelper.createProject();

    }

    @AfterMethod
    public void tearDownMethod() {
        if (issue != null) {
            ApiHelper.deleteIssue(issue);
        }
        if (project != null) {
            ApiHelper.deleteProject(project);
        }

        if (allProjects.size() > 1) {
            for (int i = 0; i < allProjects.size(); i++) {
                ApiHelper.deleteProject((JsonObject) allProjects.get(i));
            }
        }
    }

    @Test
    public void projectPage(Method method) throws IOException {
        issue = ApiHelper.createIssue(project.get("id").getAsInt());
        new TaigaLoginPage();
        login("sqa.days@yandex.ru", "Armenia2018");
        TaigaProjectPage projectPage = new TaigaProjectPage(project);
    }

}
