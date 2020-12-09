package com.dsr.jschool.controller;

import com.dsr.jschool.data.dto.security.AuthResDto;
import com.dsr.jschool.data.dto.security.RegisterUserDto;
import com.dsr.jschool.data.entity.User;
import com.dsr.jschool.data.repository.RoleRepository;
import com.dsr.jschool.data.repository.UserRepository;
import com.dsr.jschool.security.JwtProvider;
import com.dsr.jschool.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/api/v1/security")
public class SecurityController {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;
    private final JwtProvider jwtProvider;

    public SecurityController(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder, UserService userService, JwtProvider jwtProvider) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
        this.jwtProvider = jwtProvider;
    }

    @RequestMapping(method = POST, path = "/register")
    @ResponseStatus(CREATED)
    public void register(@RequestBody RegisterUserDto dto) {
        var userRole = roleRepository.findByName("ROLE_USER");
        var user = new User();
        user.setName(dto.getLogin());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setRoles(Collections.singletonList(userRole));
        userRepository.save(user);
    }

    @RequestMapping(method = POST, path = "/login")
    public AuthResDto login(@RequestBody RegisterUserDto dto) {
        var user = userService.findByLoginAndPassword(dto.getLogin(), dto.getPassword());
        if (user == null) {
            throw new RuntimeException("Invalid username or password.");
        }
        var token = jwtProvider.generateToken(user.getName(), user.getRoles());
        return new AuthResDto(token);
    }
}
