package com.marcosmontenegro.Controller;

import com.marcosmontenegro.Entity.Usuario;
import com.marcosmontenegro.Exception.ErrorResponse;
import com.marcosmontenegro.Service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class UsuarioController {
    @Autowired
    private UsuarioService service;

    // LOGIN
    @GetMapping("/index")
    public String index() {
        return "index";
    }


    // LOGIN
    @GetMapping("/login")
    public String login() {
        return "login";
    }


    @PostMapping("/login")
    public String validar(@RequestParam String username,
                          @RequestParam String password,
                          Model model) {
        Usuario u = service.login(username, password);
        if (u != null) {
            return "redirect:/home";
        } else {
            model.addAttribute("error", "Credenciales incorrectas");
            return "login";
        }
    }

    // REGISTRO
    @GetMapping("/registro")
    public String registro() {
        return "registro";
    }
    @PostMapping("/registro")
    public String guardar(@RequestParam String username,
                          @RequestParam String password,
                          Model model) {
        Usuario u = service.registrar(username, password);
        if (u == null) {
            model.addAttribute("error", "Usuario ya existe");
            return "registro";
        }
        return "redirect:/login";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }



    @GetMapping("/usuarios")
    public String listarUsuarios(Model model) {
        List<Usuario> lista = service.getAllUsuarios();
        model.addAttribute("usuarios", lista);
        return "usuarios";
    }

    @GetMapping("/usuarios/agregarusuario")
    public String formularioNuevo(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "agregarusuario";
    }

    @GetMapping("/usuarios/eliminar/{id}")
    public String eliminarUsuario(@PathVariable Integer id) {
        service.deleteUsuario(id);
        return "redirect:/usuarios";
    }
}
