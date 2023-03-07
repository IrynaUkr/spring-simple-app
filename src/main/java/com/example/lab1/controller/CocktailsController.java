package com.example.lab1.controller;

import com.example.lab1.model.Cocktail;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CocktailsController {
    long id =1;
    @GetMapping("/cocktail")
    public Cocktail getCocktail(@RequestParam String name){
        return new Cocktail(id++, name);
    }
}

