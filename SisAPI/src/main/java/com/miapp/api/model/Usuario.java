package com.miapp.api.model;
import jakarta.persistence.*;


@Entity
@Table(name = "usuarios", uniqueConstraints = @UniqueConstraint(columnNames = "nombre_usuario"))
public class Usuario {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuarios_id_usuario_seq")
    @SequenceGenerator(name = "usuarios_id_usuario_seq", sequenceName = "public.usuarios_id_usuario_seq", allocationSize = 1)
    @Column(name = "id_usuario")
    private Integer idUsuario;


    @Column(name = "nombre_usuario", length = 50, nullable = false, unique = true)
    private String nombreUsuario;


    @Column(name = "password", columnDefinition = "text", nullable = false)
    private String password; // almacenado en bcrypt


    public Usuario() {}


    // getters y setters
    public Integer getIdUsuario() { return idUsuario; }
    public void setIdUsuario(Integer idUsuario) { this.idUsuario = idUsuario; }


    public String getNombreUsuario() { return nombreUsuario; }
    public void setNombreUsuario(String nombreUsuario) { this.nombreUsuario = nombreUsuario; }


    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}