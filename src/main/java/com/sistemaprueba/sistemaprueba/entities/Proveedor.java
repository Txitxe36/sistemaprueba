package com.sistemaprueba.sistemaprueba.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "proveedores")
@Getter  @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProveedor;

    @Column(nullable = false,length = 30)
    private String nombre;

    @Column(nullable = false,length = 30)
    private String email;

    @Column(nullable = false,length = 20)
    private int telefono;

    @Column(nullable = false,length = 50)
    private String direccion;


    @OneToMany(mappedBy ="proveedor", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Producto> listaProducto;


}
