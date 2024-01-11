package com.example.demo;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HomeController {
    @GetMapping("/")
    public String index(Model model) {
        String message = "Olá, mundo!";
        model.addAttribute("message", message);
        return "index";
    }

    @PostMapping("/enviar")
    public String enviar(@RequestParam String nome, @RequestParam int idade, @RequestParam String sexo, Model model) {
        model.addAttribute("nome", nome);
        model.addAttribute("idade", idade);
        model.addAttribute("sexo", sexo);
        return "resultado";
    }
}