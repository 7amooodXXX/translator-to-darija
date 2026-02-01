package com.example.translator.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TranslationService {

    private static final String API_KEY = System.getenv("GEMINI_API_KEY");

    public String translateEnglishToDarija(String text) {
        if (API_KEY == null || API_KEY.isEmpty()) {
            return "API key not configured";
         }
        try {

           
            String body = """
            {
              "contents": [
                {
                  "role": "user",
                  "parts": [
                    {
                      "text": "Translate the following English text into Moroccan Darija. Return ONLY the translated text. Text: %s"
                    }
                  ]
                }
              ]
            }
            """.formatted(text);

            // 2️⃣ Requête HTTP
            HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(
                    "https://generativelanguage.googleapis.com/v1/models/gemini-2.5-flash:generateContent?key=" 
                    + API_KEY))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();

            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

            
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(response.body());

            String translated =
                root.path("candidates")
                    .get(0)
                    .path("content")
                    .path("parts")
                    .get(0)
                    .path("text")
                    .asText();

            return translated;

        } catch (Exception e) {
            e.printStackTrace();
            return "Erreur lors de la traduction IA";
        }
    }
}
