package com.marcosmontenegro.Controller;

import com.marcosmontenegro.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/login")
    public String mostrarLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String correo,
                        @RequestParam String password,
                        Model model) {

        if (usuarioService.validarLogin(correo, password)) {
            return "redirect:/home";
        } else {
            model.addAttribute("error", true);
            return "login";
        }
    }
}