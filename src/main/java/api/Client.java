package api;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.*;

import java.io.IOException;

public class Client {

    public static void main(String[] args) throws IOException {
        JsonObject jsonObject = login("sqa.days@yandex.ru", "Armenia2018");
        System.out.println(jsonObject);
        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\"is_private\":false,\"creation_template\":1,\"name\":\"Special one\",\"description\":\"asas\"}\n");
        Request request = new Request.Builder()
                .url("https://api.taiga.io/api/v1/projects")
                .post(body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer " + jsonObject.get("auth_token").getAsString())
                .addHeader("cache-control", "no-cache")
                .build();

        Response response = client.newCall(request).execute();
        String jsonString = response.body().string();
        System.out.println(jsonString);
        new JsonParser().parse(jsonString).getAsJsonObject();

    }

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
        return  new JsonParser().parse(jsonString).getAsJsonObject();
    }
}
