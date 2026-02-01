package com.example.translator.controller;

import com.example.translator.dto.*;
import com.example.translator.service.TranslationService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.annotation.security.RolesAllowed;


@Path("/translate")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RolesAllowed("USER")
public class TranslationResource {

    private final TranslationService service = new TranslationService();

    @POST
    public TranslationResponse translate(TranslationRequest request) {
        String translated = service.translateEnglishToDarija(request.getText());
        return new TranslationResponse(request.getText(), translated);
    }
}
