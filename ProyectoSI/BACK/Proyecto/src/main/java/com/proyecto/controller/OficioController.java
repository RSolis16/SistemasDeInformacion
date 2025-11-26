package com.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyecto.model.Oficio;
import com.proyecto.service.OficioService;

@Controller
@RequestMapping("/oficios")
public class OficioController {

    @Autowired
    private OficioService servicio;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("listaOficios", servicio.listar());
        return "lista";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable String id, Model model) {
        Oficio oficio = servicio.buscar(id).orElse(null);
        model.addAttribute("oficio", oficio);
        return "editar";
    }

    @PostMapping("/actualizar")
    public String actualizar(@ModelAttribute Oficio oficio) {
        servicio.guardar(oficio);
        return "redirect:/oficios";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable String id) {
        servicio.eliminar(id);
        return "redirect:/oficios";
    }
}
