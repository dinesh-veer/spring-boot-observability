package com.dinesh.observability.service;

import com.dinesh.observability.entity.User;
import com.dinesh.observability.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository userRepository;

    public List<User> getAllUsers() {
      log.info("Inside UserService getting all user information");
      return userRepository.findAll();
    }
}
