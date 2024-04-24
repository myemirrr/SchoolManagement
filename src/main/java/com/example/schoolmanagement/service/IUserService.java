package com.example.schoolmanagement.service;
import com.example.schoolmanagement.model.User;
import com.example.schoolmanagement.dto.UserRegistrationDto;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends UserDetailsService {
    User save(UserRegistrationDto registrationDto);
}
