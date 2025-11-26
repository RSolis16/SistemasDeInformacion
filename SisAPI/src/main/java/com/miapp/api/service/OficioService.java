package com.miapp.api.service;
import com.miapp.api.model.Oficio;
import com.miapp.api.repository.OficioRepository;
import com.miapp.api.util.HashUtil;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;


@Service
public class OficioService {


    private final OficioRepository oficioRepository;


    public OficioService(OficioRepository oficioRepository) {
        this.oficioRepository = oficioRepository;
    }


    public List<Oficio> findAll() { return oficioRepository.findAll(); }


    public Optional<Oficio> findById(String numOficio) { return oficioRepository.findById(numOficio); }


    @Transactional
    public Oficio create(Oficio oficio) {
        if (oficio.getHash() == null || oficio.getHash().isBlank()) {
            oficio.setHash(generateHashFromOficio(oficio));
        }
        try {
            return oficioRepository.save(oficio);
        } catch (DataIntegrityViolationException e) {
            throw e;
        }
    }


    @Transactional
    public Oficio update(String numOficio, Oficio updated) {
        Oficio current = oficioRepository.findById(numOficio)
                .orElseThrow(() -> new ResourceNotFoundException("Oficio no encontrado: " + numOficio));


        current.setIdPersona(updated.getIdPersona());
        current.setAsunto(updated.getAsunto());
        current.setFecha(updated.getFecha());


        if (updated.getHash() == null || updated.getHash().isBlank()) {
            current.setHash(generateHashFromOficio(current));
        } else {
            current.setHash(updated.getHash());
        }


        return oficioRepository.save(current);
    }


    public void delete(String numOficio) { oficioRepository.deleteById(numOficio); }


    public String generateHashFromOficio(Oficio oficio) {
        String base = String.format("%s|%d|%s|%s",
                oficio.getNumOficio(),
                oficio.getIdPersona(),
                oficio.getAsunto() == null ? "" : oficio.getAsunto().trim(),
                oficio.getFecha() == null ? "" : oficio.getFecha().toString());
        return HashUtil.sha256Hex(base);
    }


    public boolean hashExists(String hash) { return oficioRepository.existsByHash(hash); }
}