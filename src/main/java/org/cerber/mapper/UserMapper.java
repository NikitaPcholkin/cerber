package org.cerber.mapper;

import org.cerber.entity.User;
import org.cerber.model.UserResponse;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserResponse toUserResponse(User user) { // Исправил опечатку в названии метода
        return new UserResponse()
                .setId(user.getId())
                .setUuid(user.getUuid())
                .setSubscribed(user.getSubscribed());
    }
}
