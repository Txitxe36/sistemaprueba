package com.sistemaprueba.sistemaprueba.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "clientes")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private int dni;

    private String telefono;

    private String direccion;

    //@OneToMany(mappedBy = "cliente",cascade = CascadeType.ALL)
    //private List<Factura> listaFactura;



}
