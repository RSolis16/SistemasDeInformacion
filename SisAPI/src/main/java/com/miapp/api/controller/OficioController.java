package com.miapp.api.controller;
import com.miapp.api.model.Oficio;
import com.miapp.api.service.OficioService;
import com.miapp.api.service.ResourceNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/oficios")
@CrossOrigin(origins = "*")
public class OficioController {


    private final OficioService oficioService;


    public OficioController(OficioService oficioService) {
        this.oficioService = oficioService;
    }


    @GetMapping
    public List<Oficio> listAll() { return oficioService.findAll(); }


    @GetMapping("/{numOficio}")
    public ResponseEntity<?> getOne(@PathVariable String numOficio) {
        return oficioService.findById(numOficio)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body((Oficio) Map.of("error","No encontrado")));
    }


    @PostMapping
    public ResponseEntity<?> create(@RequestBody Oficio oficio) {
        try {
            Oficio created = oficioService.create(oficio);
            return ResponseEntity.status(HttpStatus.CREATED).body(created);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of("error","Violación de integridad", "msg", e.getRootCause() != null ? e.getRootCause().getMessage() : e.getMessage()));
        }
    }


    @PutMapping("/{numOficio}")
    public ResponseEntity<?> update(@PathVariable String numOficio, @RequestBody Oficio oficio) {
        try {
            Oficio updated = oficioService.update(numOficio, oficio);
            return ResponseEntity.ok(updated);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", e.getMessage()));
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of("error","Violación de integridad"));
        }
    }


    @DeleteMapping("/{numOficio}")
    public ResponseEntity<?> delete(@PathVariable String numOficio) {
        oficioService.delete(numOficio);
        return ResponseEntity.noContent().build();
    }


    @PostMapping("/generate-hash")
    public ResponseEntity<?> generateHash(@RequestBody Oficio oficio) {
        String hash = oficioService.generateHashFromOficio(oficio);
        boolean exists = oficioService.hashExists(hash);
        return ResponseEntity.ok(Map.of("hash", hash, "exists", exists));
    }
}