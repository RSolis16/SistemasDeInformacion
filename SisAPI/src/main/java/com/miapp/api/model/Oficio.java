package com.miapp.api.model;


import jakarta.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "oficios", uniqueConstraints = @UniqueConstraint(columnNames = "hash"))
public class Oficio {


    @Id
    @Column(name = "num_oficio", length = 20)
    private String numOficio;


    @Column(name = "id_persona", nullable = false)
    private Integer idPersona;


    @Column(name = "asunto", columnDefinition = "text", nullable = false)
    private String asunto;


    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;


    @Column(name = "hash", length = 64, nullable = false, unique = true)
    private String hash;


    public Oficio() {}


    // getters y setters
    public String getNumOficio() { return numOficio; }
    public void setNumOficio(String numOficio) { this.numOficio = numOficio; }


    public Integer getIdPersona() { return idPersona; }
    public void setIdPersona(Integer idPersona) { this.idPersona = idPersona; }


    public String getAsunto() { return asunto; }
    public void setAsunto(String asunto) { this.asunto = asunto; }


    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }


    public String getHash() { return hash; }
    public void setHash(String hash) { this.hash = hash; }
}