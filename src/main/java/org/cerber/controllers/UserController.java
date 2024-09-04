package org.cerber.controllers;

import lombok.RequiredArgsConstructor;
import org.cerber.entity.User;
import org.cerber.model.UserResponse;
import org.cerber.payload.UserPayload;
import org.cerber.services.UserService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final TokenController tokenController;

    private static final String REQUIRED_HEADER = "Cerber-Security-Token";

    @PostMapping("/get")
    public UserResponse getUser(@RequestBody UserPayload payload,
                                @RequestHeader(REQUIRED_HEADER) String headerValue) {
        validateHeader(headerValue);
        return userService.getUser(payload.getId());
    }

    @PostMapping("/add")
    public UserResponse addUser(@RequestBody UserPayload payload,
                                @RequestHeader(REQUIRED_HEADER) String headerValue) {
        validateHeader(headerValue);

        User newUser = new User()
                .setUuid(payload.getUuid())
                .setSubscribed(false);

        return userService.addUser(newUser);
    }

    private void validateHeader(String headerValue) {
        if (!tokenController.validateToken(headerValue)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Security detected fake or reused token");
        }
    }
}
