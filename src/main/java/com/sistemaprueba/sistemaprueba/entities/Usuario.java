package com.sistemaprueba.sistemaprueba.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "usuarios")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", length =30,nullable = false)
    private String nombre;

    @Column(name = "email", length =30,nullable = false)
    private String email;

    @Column(name = "usuario", length =30,nullable = false)
    private String usuario;

    @Column(name = "clave", length =30,nullable = false)
    private String clave;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_roles", nullable = false)
    private Rol rol;

    //@OneToMany(mappedBy ="usuario")
    //private List<Factura> listaFacturas;

}
