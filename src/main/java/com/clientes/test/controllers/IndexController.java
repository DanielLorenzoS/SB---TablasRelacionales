package com.clientes.test.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/")
public class IndexController {

    @GetMapping(path = "")
    public String login() {
        return "login";
    }
    @GetMapping(path = "/registrar.html")
    public String register() {
        return "registrar";
    }

    @GetMapping(path = "/personas.html")
    public String people() {
        return "personas";
    }

    @GetMapping(path = "/perfil.html")
    public String perfil() {
        return "perfil";
    }

    @GetMapping(path = "/facturas.html")
    public String facturas() {
        return "facturas";
    }
}
