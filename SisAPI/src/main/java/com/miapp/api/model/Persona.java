package com.miapp.api.model;
import jakarta.persistence.*;


@Entity
@Table(name = "personas")
public class Persona {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "personas_id_persona_seq")
    @SequenceGenerator(name = "personas_id_persona_seq", sequenceName = "public.personas_id_persona_seq", allocationSize = 1)
    @Column(name = "id_persona")
    private Integer idPersona;


    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;


    @Column(name = "area", length = 50, nullable = false)
    private String area;


    public Persona() {}


    // getters y setters
    public Integer getIdPersona() { return idPersona; }
    public void setIdPersona(Integer idPersona) { this.idPersona = idPersona; }


    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }


    public String getArea() { return area; }
    public void setArea(String area) { this.area = area; }
}