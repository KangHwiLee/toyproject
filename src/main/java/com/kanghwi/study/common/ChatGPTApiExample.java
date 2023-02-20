package com.kanghwi.study.common;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class ChatGPTApiExample {
    public static void main(String[] args) throws Exception {
        String apiKey = "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";
        String apiUrl = "https://api.openai.com/v1/engines/davinci-codex/completions";

        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Authorization", "Bearer " + apiKey);
        connection.setDoOutput(true);

        String input = "{\"prompt\": \"As I told you, the api request works well. I received a request in Chinese, but I want to return it in English.\", \"max_tokens\": 50, \"temperature\": 0.5}";

        DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream());
        outputStream.writeBytes(input);
        outputStream.flush();
        outputStream.close();

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            System.out.println(response.toString());
            JSONObject json = new JSONObject(response.toString());
            System.out.println(json.get("choices"));
            JSONObject data = (JSONObject)((JSONArray) json.get("choices")).get(0);
            System.out.println(" test : " + data.get("text"));
        } else {
            System.out.println("Error: " + responseCode);
        }
    }
}

