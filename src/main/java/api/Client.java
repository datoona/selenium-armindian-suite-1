package api;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.*;
import org.openqa.selenium.json.Json;

import java.io.IOException;

public class Client {
    private static String ACCESS_TOKEN = null;

    public static JsonObject login(String email, String password) throws IOException {
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType,
                "{\"username\":\""+ email +"\",\"password\":\""+ password +"\",\"type\":\"normal\"}");
        Request request = new Request.Builder()
                .url("https://api.taiga.io/api/v1/auth")
                .post(body)
                .addHeader("Content-Type", "application/json")
                .addHeader("cache-control", "no-cache")
                .build();

        Response response = client.newCall(request).execute();
        String jsonString = response.body().string();
        JsonObject object = new JsonParser().parse(jsonString).getAsJsonObject();
        ACCESS_TOKEN = object.get("auth_token").getAsString();
        return  object;
    }

    public static JsonObject createProject(JsonObject project) throws IOException {
        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, project.toString());
        Request request = new Request.Builder()
                .url("https://api.taiga.io/api/v1/projects")
                .post(body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer " + ACCESS_TOKEN)
                .build();

        Response response = client.newCall(request).execute();
        String jsonString = response.body().string();
        return  new JsonParser().parse(jsonString).getAsJsonObject();
    }
}
