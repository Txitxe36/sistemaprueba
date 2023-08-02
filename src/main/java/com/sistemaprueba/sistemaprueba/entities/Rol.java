package com.sistemaprueba.sistemaprueba.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "roles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRol;

    @Column(name = "rol",nullable = false)
    private String rol;

    /*
    @OneToMany(mappedBy ="rol",cascade = CascadeType.ALL)
    private List<Usuario> listaUsuario;*/
}
