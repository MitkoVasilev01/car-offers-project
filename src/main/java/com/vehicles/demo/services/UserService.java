package com.vehicles.demo.services;

import com.vehicles.demo.dtos.UserRegisterDto;
import com.vehicles.demo.entities.User;
import com.vehicles.demo.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;


    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
    }

    public void registerUser (UserRegisterDto userRegisterDto) {

        if (userRepository.existsByEmail(userRegisterDto.getEmail())) {
            throw new RuntimeException("Имейлът вече е зает!");
        }
        if (userRepository.existsByUsername(userRegisterDto.getUsername())) {
            throw new RuntimeException("Потребителското име вече е заето!");
        }

        User user = modelMapper.map(userRegisterDto, User.class);
        user.setPassword(passwordEncoder.encode(userRegisterDto.getPassword()));
        userRepository.save(user);
    }
}
