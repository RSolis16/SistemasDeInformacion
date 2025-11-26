package com.proyecto.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.model.Persona;
import com.proyecto.repository.PersonaRepository;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    // Listar todas las personas
    public Iterable<Persona> listar() {
        return personaRepository.findAll();
    }

    // Buscar por ID
    public Optional<Persona> buscarPorId(Long id) {
        return personaRepository.findById(id);
    }

    // Buscar por nombre
    public Optional<Persona> buscarPorNombre(String nombre) {
        return personaRepository.findByNombre(nombre);
    }
}
