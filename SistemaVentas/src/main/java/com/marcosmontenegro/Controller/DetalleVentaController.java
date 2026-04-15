package com.marcosmontenegro.Controller;

import com.marcosmontenegro.Entity.DetalleVenta;
import com.marcosmontenegro.Service.DetalleVentaService;
import com.marcosmontenegro.Service.ProductoService;
import com.marcosmontenegro.Service.VentaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class DetalleVentaController {

    @Autowired
    private DetalleVentaService service;

    @Autowired
    private ProductoService productoService;

    @Autowired
    private VentaService ventaService;

    @GetMapping("/detalleventa")
    public String listarDetalles(Model model) {
        List<DetalleVenta> lista = service.getAllDetalleVentas();
        model.addAttribute("detalles", lista);
        return "detalleventa";
    }

    @GetMapping("/detalleventa/agregardetalleventa")
    public String formularioNuevo(Model model) {
        model.addAttribute("detalleVenta", new DetalleVenta());
        model.addAttribute("productos", productoService.getAllProductos());
        model.addAttribute("ventas", ventaService.getAllVentas());
        return "agregardetalleventa";
    }

    @PostMapping("/detalleventa/guardardetalle")
    public String guardarDetalle(@ModelAttribute DetalleVenta detalleVenta) {
        service.saveDetalleVenta(detalleVenta);
        return "redirect:/detalleventa";
    }

    @GetMapping("/detalleventa/editardetalleventa/{id}")
    public String formularioEditar(@PathVariable Integer id, Model model) {
        DetalleVenta detalleVenta = service.getDetalleVentaById(id);
        model.addAttribute("detalleVenta", detalleVenta);
        model.addAttribute("productos", productoService.getAllProductos());
        model.addAttribute("ventas", ventaService.getAllVentas());
        return "editardetalleventa"; 
    }

    @GetMapping("/detalleventa/eliminar/{id}")
    public String eliminarDetalle(@PathVariable Integer id) {
        service.deleteDetalleVenta(id);
        return "redirect:/detalleventa";
    }
}
