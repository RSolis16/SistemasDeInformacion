package com.proyecto.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.model.Oficio;
import com.proyecto.repository.OficioRepository;

@Service
public class OficioService {

    @Autowired
    private OficioRepository repo;

    public Iterable<Oficio> listar() {
        return repo.findAll();
    }

    public Optional<Oficio> buscar(String id) {
        return repo.findById(id);
    }

    public void guardar(Oficio oficio) {
        repo.save(oficio);
    }

    public void eliminar(String id) {
        repo.deleteById(id);
    }
}
