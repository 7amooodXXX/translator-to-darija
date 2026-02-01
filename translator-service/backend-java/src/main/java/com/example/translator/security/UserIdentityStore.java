package com.example.translator.security;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.security.enterprise.credential.Credential;
import jakarta.security.enterprise.credential.UsernamePasswordCredential;
import jakarta.security.enterprise.identitystore.CredentialValidationResult;
import jakarta.security.enterprise.identitystore.IdentityStore;

import java.util.Set;

@ApplicationScoped
public class UserIdentityStore implements IdentityStore {

    @Override
    public CredentialValidationResult validate(Credential credential) {

        if (credential instanceof UsernamePasswordCredential upc) {

            String username = upc.getCaller();
            String password = upc.getPasswordAsString();

            if ("admin".equals(username) && "admin1312".equals(password)) {
                return new CredentialValidationResult(
                        username,
                        Set.of("USER")
                );
            }
        }

        return CredentialValidationResult.INVALID_RESULT;
    }
}
