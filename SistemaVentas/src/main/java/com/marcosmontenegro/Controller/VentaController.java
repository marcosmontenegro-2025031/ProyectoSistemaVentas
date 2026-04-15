package com.marcosmontenegro.Controller;

import com.marcosmontenegro.Entity.Venta;
import com.marcosmontenegro.Exception.ErrorResponse;
import com.marcosmontenegro.Service.ClienteService;
import com.marcosmontenegro.Service.UsuarioService;
import com.marcosmontenegro.Service.VentaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
public class VentaController {

    @Autowired
    private VentaService service;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private UsuarioService usuarioService;

    //ADMINISTRADOR

    @GetMapping("/ventas")
    public String listarVentas(Model model) {
        List<Venta> lista = service.getAllVentas();
        model.addAttribute("ventas", lista);
        return "ventas";
    }

    @GetMapping("/ventas/agregarventa")
    public String formularioNuevo(Model model) {
        Venta venta = new Venta();
        venta.setFechaVenta(LocalDate.now());
        model.addAttribute("venta", venta);
        model.addAttribute("clientes", clienteService.getAllClientes());
        model.addAttribute("usuarios", usuarioService.getAllUsuarios());
        return "agregarventa";
    }

    @PostMapping("/ventas/guardarventa")
    public String guardarVenta(@ModelAttribute Venta venta) {
        service.saveVenta(venta);
        return "redirect:/ventas";
    }

    @GetMapping("/ventas/editarventa/{id}")
    public String formularioEditar(@PathVariable Integer id, Model model) {
        Venta venta = service.getVentaById(id);
        model.addAttribute("venta", venta);
        model.addAttribute("clientes", clienteService.getAllClientes());
        model.addAttribute("usuarios", usuarioService.getAllUsuarios());
        return "editarventa";
    }

    @GetMapping("/ventas/eliminar/{id}")
    public String eliminarVenta(@PathVariable Integer id) {
        service.deleteVenta(id);
        return "redirect:/ventas";
    }

    //VENDEDOR

    @GetMapping("/ventasvendedor")
    public String listarVentasVendedor(Model model) {
        List<Venta> lista = service.getAllVentas();
        model.addAttribute("ventas", lista);
        return "ventasvendedor";
    }

    @GetMapping("/ventasvendedor/agregarventa")
    public String formularioNuevoVendedor(Model model) {
        Venta venta = new Venta();
        venta.setFechaVenta(LocalDate.now());
        model.addAttribute("venta", venta);
        model.addAttribute("clientes", clienteService.getAllClientes());
        model.addAttribute("usuarios", usuarioService.getAllUsuarios());
        return "agregarventasvendedor";
    }

    @PostMapping("/ventasvendedor/guardarventa")
    public String guardarVentaVendedor(@ModelAttribute Venta venta) {
        service.saveVenta(venta);
        return "redirect:/ventasvendedor";
    }
}
