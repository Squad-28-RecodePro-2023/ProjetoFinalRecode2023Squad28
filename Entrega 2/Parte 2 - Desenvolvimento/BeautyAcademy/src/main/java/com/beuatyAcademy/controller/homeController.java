package com.beuatyAcademy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class homeController {

    @GetMapping(value = {"/", "/Home.html"})
    public String home() {
        return "Home.html";
    }
    
    @GetMapping("/Contato.html")
    public String contato() {
        return "Contato.html";
    }
    
    @GetMapping("/QuemSomos.html")
    public String quemSomos() {
        return "QuemSomos.html";
    }
    
    @GetMapping("/Manifesto.html")
    public String manifesto() {
        return "Manifesto.html";}

    }

