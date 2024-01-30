package com.beautyAcademy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

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
    
    @RequestMapping("/AcessoNegado.html")
    public String acessoNegado() {
        // Lógica para lidar com o erro aqui
        return "AcessoNegado.html";
    }

        
    }

