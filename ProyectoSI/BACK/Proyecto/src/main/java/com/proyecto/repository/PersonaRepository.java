package com.proyecto.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.proyecto.model.Persona;

public interface PersonaRepository extends CrudRepository<Persona, Long> {

    // Necesario para buscar por nombre desde el OficioService
    Optional<Persona> findByNombre(String nombre);
}
