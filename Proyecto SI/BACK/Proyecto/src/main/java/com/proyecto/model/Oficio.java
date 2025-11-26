package com.proyecto.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "oficios")
public class Oficio {

    @Id
    @Column(name = "num_oficio")
    private String numOficio;

    @Column(name = "id_persona")
    private Integer idPersona;

    @Column(name = "asunto")
    private String asunto;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "hash")
    private String hash;

    // ====== CONSTRUCTOR VACÍO ======
    public Oficio() {
    }

    // ====== GETTERS ======
    public String getNumOficio() {
        return numOficio;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public String getAsunto() {
        return asunto;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getHash() {
        return hash;
    }

    // ====== SETTERS ======
    public void setNumOficio(String numOficio) {
        this.numOficio = numOficio;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }
}
