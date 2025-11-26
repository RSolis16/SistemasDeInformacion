package com.proyecto.repository;

import org.springframework.data.repository.CrudRepository;

import com.proyecto.model.Oficio;
import org.springframework.stereotype.Repository;

@Repository
public interface OficioRepository extends CrudRepository<Oficio, String> {

}

