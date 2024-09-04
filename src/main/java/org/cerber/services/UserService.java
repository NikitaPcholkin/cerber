package org.cerber.services;

import lombok.RequiredArgsConstructor;
import org.cerber.entity.User;
import org.cerber.mapper.UserMapper;
import org.cerber.model.UserResponse;
import org.cerber.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus; 
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserService {
    private final UserMapper userMapper;

    private final UserRepository userRepository;

    public UserService(UserMapper userMapper, UserRepository userRepository) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }

    public UserResponse getUser(Integer id) {
        User user = userRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
        return userMapper.toUserResponse(user);
    }

    public UserResponse addUser(User user) {
        User savedUser = userRepository.save(user);
        return userMapper.toUserResponse(savedUser);
    }
}
