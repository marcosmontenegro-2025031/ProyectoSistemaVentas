package com.marcosmontenegro.Controller;

import com.marcosmontenegro.Entity.Usuario;
import com.marcosmontenegro.Service.UsuarioService;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
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
                        HttpSession session, // Añadido
                        Model model) {
        Usuario u = service.login(username, password);
        if (u != null) {
            session.setAttribute("usuarioLogueado", u);

            if (u.getRol().equals("ADMIN")) {
                return "redirect:/home";
            } else if (u.getRol().equals("VENDEDOR")) {
                return "redirect:/homevendedor";
            }
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
                        @RequestParam String email,
                        Model model) {
        Usuario u = service.registrar(username, password, email);
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

    @GetMapping("/homevendedor")
    public String homevendedor() {
        return "homevendedor";
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

    @PostMapping("/usuarios/guardar")
    public String guardarUsuario(@ModelAttribute Usuario usuario) {
        service.saveUsuario(usuario);
        return "redirect:/usuarios";
    }
    

    @GetMapping("/usuarios/editarusuario/{id}")
    public String formularioEditar(@PathVariable Integer id, Model model) {
        Usuario usuario = service.getUsuarioById(id);
        model.addAttribute("usuario", usuario);
        return "editarusuario"; 
    }

    @GetMapping("/usuarios/eliminar/{id}")
    public String eliminarUsuario(@PathVariable Integer id) {
        service.deleteUsuario(id);
        return "redirect:/usuarios";
    }



    @GetMapping("/perfiladmin")
    public String mostrarPerfilAdmin(HttpSession session, Model model) {
        Usuario u = (Usuario) session.getAttribute("usuarioLogueado");
        if (u == null) {
            return "redirect:/login";
        }
        model.addAttribute("usuario", u);
        return "perfiladmin";
    }

    @PostMapping("/perfiladmin/guardar")
    public String guardarUsuarioAdmin(@ModelAttribute Usuario usuario, HttpSession session) {
        service.saveUsuario(usuario);
        session.setAttribute("usuarioLogueado", usuario);
        return "redirect:/home";
    }

    //Vendedor

    @GetMapping("/perfil")
    public String mostrarPerfil(HttpSession session, Model model) {
        Usuario u = (Usuario) session.getAttribute("usuarioLogueado");
        if (u == null) {
            return "redirect:/login";
        }
        model.addAttribute("usuario", u);
        return "perfil";
    }

    @PostMapping("/perfil/guardar")
    public String guardarUsuarioVendedor(@ModelAttribute Usuario usuario, HttpSession session) {
        service.saveUsuario(usuario);
        session.setAttribute("usuarioLogueado", usuario);
        return "redirect:/homevendedor";
    }


    @GetMapping("/logout")
public String logout(HttpSession session) {
    session.invalidate();
    return "redirect:/login";
}
}
