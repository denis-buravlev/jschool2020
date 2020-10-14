package com.dsr.jschool.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("cat")
@Service
public class CatService implements AnimalService {

    private final String name;

    public CatService(@Value("${animal.name}") String name) {
        this.name = name;
    }

    public String say() {
        return "Meow! I'm " + name;
    }
}
