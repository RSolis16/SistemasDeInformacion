package com.proyecto.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.model.Persona;


@Repository
public interface PersonaRepository extends CrudRepository<Persona, Long> {
    Optional<Persona> findByNombre(String nombre);
}