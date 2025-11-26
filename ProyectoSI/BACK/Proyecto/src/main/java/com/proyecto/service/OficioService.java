package com.proyecto.service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.model.Oficio;
import com.proyecto.model.Persona;
import com.proyecto.repository.OficioRepository;
import com.proyecto.repository.PersonaRepository;

@Service
public class OficioService {

    @Autowired
    private OficioRepository repo;

    @Autowired
    private PersonaRepository personaRepo;

    public Iterable<Oficio> listar() {
        return repo.findAll();
    }

    public Optional<Oficio> buscar(String id) {
        return repo.findById(id);
    }

    public void eliminar(String id) {
        repo.deleteById(id);
    }

    // ============================
    // AGREGAR NUEVO OFICIO
    // ============================
    public void guardarNuevo(String nombrePersona, String asunto, String fecha) {

        Persona persona = personaRepo.findByNombre(nombrePersona)
                .orElseThrow(() -> new RuntimeException("Persona no encontrada"));

        Oficio oficio = new Oficio();
        oficio.setNumOficio(UUID.randomUUID().toString());
        oficio.setIdPersona(persona.getIdPersona());
        oficio.setAsunto(asunto);
        oficio.setFecha(LocalDate.parse(fecha));

        // Hash simple
        oficio.setHash(Integer.toHexString(oficio.hashCode()));

        repo.save(oficio);
    }

    // ============================
    // EDITAR OFICIO EXISTENTE
    // ============================
    public void actualizar(Oficio oficio, String personaNombre) {

        Persona persona = personaRepo.findByNombre(personaNombre)
                .orElseThrow(() -> new RuntimeException("Persona no encontrada"));

        // Reasignar persona
        oficio.setIdPersona(persona.getIdPersona());

        // Regenerar hash
        oficio.setHash(Integer.toHexString(oficio.hashCode()));

        repo.save(oficio);
    }
}

