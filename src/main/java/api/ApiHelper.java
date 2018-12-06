package api;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    public static void deleteProject(JsonObject project) {
        Client.delete("/projects", project);
    }

    public static void deleteIssue(JsonObject issue) {
        Client.delete("/issues", issue);
    }

    public static JsonObject getCurrentUser() throws IOException {
        Response response;
        response = Client.get("/users/me");
        String jsonString = response.body().string();
        return  new JsonParser().parse(jsonString).getAsJsonObject();
    }

    public static ArrayList<JsonObject> getAllProjects() throws IOException {
        Response response = Client.get("/projects?member=" + getCurrentUser().get("id").getAsString());
        String jsonString = response.body().string();
        JsonArray jsonArray = new JsonParser().parse(jsonString).getAsJsonArray();
        Gson googleJson = new Gson();
        return googleJson.fromJson(jsonArray, ArrayList.class);
    }


    public JsonObject getProject(String projectId) throws IOException {
        Response response = Client.get("/projects/" + projectId);
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
