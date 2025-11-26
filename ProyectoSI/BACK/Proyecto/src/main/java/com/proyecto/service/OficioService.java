package com.proyecto.service;

import com.proyecto.model.Oficio;
import com.proyecto.model.Persona;
import com.proyecto.repository.OficioRepository;
import com.proyecto.repository.PersonaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class OficioService {

    @Autowired
    private OficioRepository oficioRepo;

    @Autowired
    private PersonaRepository personaRepo;

    // LISTAR
    public Iterable<Oficio> listar() {
        return oficioRepo.findAll();
    }

    // BUSCAR POR ID
    public Optional<Oficio> buscar(String id) {
        return oficioRepo.findById(id);
    }

    // GUARDAR NUEVO
    public Oficio guardarNuevo(String numOficio, String nombrePersona, String asunto, String fecha) {

        // Buscar persona por el NOMBRE
        Persona p = personaRepo.findByNombre(nombrePersona)
                .orElseThrow(() -> new RuntimeException("Persona no encontrada: " + nombrePersona));

        Oficio oficio = new Oficio();
        oficio.setNumOficio(numOficio);
        oficio.setIdPersona(p.getIdPersona());
        oficio.setAsunto(asunto);
        oficio.setFecha(LocalDate.parse(fecha));
        oficio.setHash(generarHash()); // Hash automático

        return oficioRepo.save(oficio);
    }

    // ACTUALIZAR
    public Oficio actualizar(String numOficio, String nombrePersona, String asunto, String fecha) {

        Oficio oficio = oficioRepo.findById(numOficio)
                .orElseThrow(() -> new RuntimeException("Oficio no encontrado: " + numOficio));

        Persona p = personaRepo.findByNombre(nombrePersona)
                .orElseThrow(() -> new RuntimeException("Persona no encontrada: " + nombrePersona));

        oficio.setIdPersona(p.getIdPersona());
        oficio.setAsunto(asunto);
        oficio.setFecha(LocalDate.parse(fecha));

        return oficioRepo.save(oficio);
    }

    // ELIMINAR
    public void eliminar(String id) {
        oficioRepo.deleteById(id);
    }

    // GENERADOR DE HASH (formato letra-numero repetido hasta 64 chars)
    private String generarHash() {

        String letras = "abcdefghijklmnopqrstuvwxyz";
        String numeros = "0123456789";
        StringBuilder hash = new StringBuilder();

        for (int i = 0; i < 32; i++) { // 32 pares = 64 chars
            char letra = letras.charAt((int) (Math.random() * letras.length()));
            char numero = numeros.charAt((int) (Math.random() * numeros.length()));
            hash.append(letra).append(numero);
        }

        return hash.toString();
    }
}

