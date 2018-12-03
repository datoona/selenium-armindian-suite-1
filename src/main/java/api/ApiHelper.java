package api;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.Response;

import java.io.IOException;
import java.util.Date;

public class ApiHelper {

    public static JsonObject createProject(JsonObject project) throws IOException {
        Response response;
        response = Client.post("/projects", project);
        String jsonString = response.body().string();
        return  new JsonParser().parse(jsonString).getAsJsonObject();
    }

    public static JsonObject createIssue(JsonObject issue) throws IOException {
        Response response;
        response = Client.post("/issues", issue);
        String jsonString = response.body().string();
        return  new JsonParser().parse(jsonString).getAsJsonObject();
    }

    public static JsonObject createProject() throws IOException {
        JsonObject project = new JsonObject();
        project.addProperty("name", "Test Project " + new Date().toString());
        project.addProperty("description", "Test Project via Api Description");
        project.addProperty("creation_template", 1);
        project.addProperty("is_private", false);
        return createProject(project);
    }

    public static JsonObject createIssue(int projectID) throws IOException {
        JsonObject issue = new JsonObject();
        issue.addProperty("project", projectID);
        issue.addProperty("subject", "Test Issue " + new Date().toString());
        issue.addProperty("description", "Test Issue via Api Description");
        return createIssue(issue);
    }
}
