package com.hospital.assignment.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: Mohammed Kharma
 */
@RestController
public class HomeController {

    @GetMapping(value = "/")
    public String home() {
        return "Hello, I'm Adam Saleem, My University Id is: 1190656, And this is my Spring boot Assignment";
    }
}