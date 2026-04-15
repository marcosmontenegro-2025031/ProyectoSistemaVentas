package com.marcosmontenegro.Controller;

import com.marcosmontenegro.Entity.Producto;
import com.marcosmontenegro.Exception.ErrorResponse;
import com.marcosmontenegro.Service.ProductoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductoController {

    @Autowired
    private ProductoService service;

    @GetMapping("/productos")
    public String listarProductos(Model model) {
        List<Producto> lista = service.getAllProductos();
        model.addAttribute("productos", lista);
        return "productos";
    }

    @GetMapping("/productos/agregarproducto")
    public String formularioNuevo(Model model) {
        model.addAttribute("producto", new Producto());
        return "agregarproducto";
    }

    @PostMapping("/productos/guardarproducto")
    public String guardarProducto(@ModelAttribute Producto producto) {
        service.saveProducto(producto);
        return "redirect:/productos";
    }

    @GetMapping("/productos/editarproducto/{id}")
    public String formularioEditar(@PathVariable Integer id, Model model) {
        Producto producto = service.getProductoById(id);
        model.addAttribute("producto", producto);
        return "editarproducto";
    }

    @GetMapping("/productos/eliminar/{id}")
    public String eliminarProducto(@PathVariable Integer id) {
        service.deleteProducto(id);
        return "redirect:/productos";
    }
}
