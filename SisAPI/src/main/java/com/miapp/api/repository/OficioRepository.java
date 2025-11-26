package com.miapp.api.repository;
import com.miapp.api.model.Oficio;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OficioRepository extends JpaRepository<Oficio, String> {
    boolean existsByHash(String hash);
}