package com.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.proyecto.model.Oficio;
import com.proyecto.service.OficioService;

@Controller
@RequestMapping("/oficios")
public class OficioController {

    @Autowired
    private OficioService oficioService;

    // LISTAR
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("listaOficios", oficioService.listar());
        return "lista";
    }

    // FORMULARIO NUEVO
    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        return "agregar";
    }

    // GUARDAR NUEVO
    @PostMapping("/guardar")
    public String guardar(
            @RequestParam String numOficio,
            @RequestParam String nombrePersona,
            @RequestParam String asunto,
            @RequestParam String fecha) {

        oficioService.guardarNuevo(numOficio, nombrePersona, asunto, fecha);
        return "redirect:/oficios";
    }

    // EDITAR
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id") String id, Model model) {

        Oficio oficio = oficioService.buscar(id)
                .orElseThrow(() -> new RuntimeException("Oficio no encontrado: " + id));

        model.addAttribute("oficio", oficio);
        return "editar";
    }

    // ACTUALIZAR
    @PostMapping("/actualizar")
    public String actualizar(
            @RequestParam String numOficio,
            @RequestParam String nombrePersona,
            @RequestParam String asunto,
            @RequestParam String fecha) {

        oficioService.actualizar(numOficio, nombrePersona, asunto, fecha);
        return "redirect:/oficios";
    }

    // ELIMINAR
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") String id) {
        oficioService.eliminar(id);
        return "redirect:/oficios";
    }
}
