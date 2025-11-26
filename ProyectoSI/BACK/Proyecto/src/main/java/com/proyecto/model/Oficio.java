package com.proyecto.model;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "oficios")
public class Oficio {

    @Id
    @Column(name = "num_oficio")
    private String numOficio;

    @Column(name = "id_persona")
    private Long idPersona;

    @Column(name = "asunto")
    private String asunto;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "hash")
    private String hash;

    @ManyToOne
    @JoinColumn(name = "id_persona", insertable = false, updatable = false)
    private Persona persona;

    // ====== CONSTRUCTOR VACÍO ======
    public Oficio() {
    }

    // ====== GETTERS ======
    public String getNumOficio() {
        return numOficio;
    }

    public Long getIdPersona() { return idPersona;}

    public String getAsunto() {
        return asunto;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getHash() {
        return hash;
    }

    public Persona getPersona() {return persona;}

    // ====== SETTERS ======
    public void setNumOficio(String numOficio) {
        this.numOficio = numOficio;
    }

    public void setIdPersona(Long idPersona) { this.idPersona = idPersona;}

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
