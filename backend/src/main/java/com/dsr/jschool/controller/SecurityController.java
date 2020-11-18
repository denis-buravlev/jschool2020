package com.dsr.jschool.controller;

import com.dsr.jschool.data.dto.security.RegisterUserDto;
import com.dsr.jschool.data.entity.User;
import com.dsr.jschool.data.repository.RoleRepository;
import com.dsr.jschool.data.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/security")
public class SecurityController {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public SecurityController(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
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
    public void register() {

    }
}
