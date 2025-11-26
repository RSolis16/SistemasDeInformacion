package com.miapp.api.repository;
import com.miapp.api.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PersonaRepository extends JpaRepository<Persona, Integer> { }