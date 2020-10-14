package com.dsr.jschool.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("dog")
@Service
public class DogService implements AnimalService {
    public String say() {
        return "Gaw!";
    }
}
