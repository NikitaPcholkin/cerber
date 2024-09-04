package org.cerber.controllers;

import org.cerber.payload.TokenPayload;
import org.springframework.web.bind.annotation.*;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/token")
public class TokenController {

    private final Set<String> usedTokens = new HashSet<>();
    private final SecureRandom secureRandom = new SecureRandom();

 //   @RateLimiter(name = "getUserRateLimiter")

    @GetMapping("/get")
    public String getToken() {
        String token = generateRandomToken();
        usedTokens.add(token);
        return token;
    }

    private String generateRandomToken() {
        byte[] randomBytes = new byte[24];
        secureRandom.nextBytes(randomBytes);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(randomBytes);
    }

    public boolean validateToken(String token) {
        return usedTokens.remove(token);  // Удаляет токен и возвращает true, если он существовал
    }
}
