package api;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.*;

import java.io.IOException;

public class Client {

    public static void main(String[] args) throws IOException {
        String accessToken = getAccessToken();
        System.out.println(accessToken);
        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\"is_private\":false,\"creation_template\":1,\"name\":\"Special one\",\"description\":\"asas\"}\n");
        Request request = new Request.Builder()
                .url("https://api.taiga.io/api/v1/projects")
                .post(body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer " + accessToken)
                .addHeader("cache-control", "no-cache")
                .build();

        Response response = client.newCall(request).execute();
        String jsonString = response.body().string();
        System.out.println(jsonString);
        JsonObject jsonObject = new JsonParser().parse(jsonString).getAsJsonObject();

    }

    public static String getAccessToken() throws IOException {
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\"username\":\"sqa.days@yandex.ru\",\"password\":\"Armenia2018\",\"type\":\"normal\"}");
        Request request = new Request.Builder()
                .url("https://api.taiga.io/api/v1/auth")
                .post(body)
                .addHeader("Content-Type", "application/json")
                .addHeader("cache-control", "no-cache")
                .build();

        Response response = client.newCall(request).execute();
        String jsonString = response.body().string();
        JsonObject jsonObject = new JsonParser().parse(jsonString).getAsJsonObject();
        return jsonObject.get("auth_token").getAsString();
    }
}
