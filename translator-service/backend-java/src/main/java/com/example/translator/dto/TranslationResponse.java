package com.example.translator.dto;

public class TranslationResponse {
    private String original;
    private String translated;

    public TranslationResponse(String original, String translated) {
        this.original = original;
        this.translated = translated;
    }

    public String getOriginal() {
        return original;
    }

    public String getTranslated() {
        return translated;
    }
}
