package com.wadud.graphql.controller;


import com.wadud.graphql.service.DogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DogController {
    private DogServiceImpl dogService;

    @Autowired
    public DogController(DogServiceImpl dogService) {
        this.dogService = dogService;
    }

}
