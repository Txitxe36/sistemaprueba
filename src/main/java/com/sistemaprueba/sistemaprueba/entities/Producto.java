package com.sistemaprueba.sistemaprueba.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "productos")
@Getter  @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducto;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private Double precio;

    @Column(nullable = false)
    private int stock;

    //private String foto;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_proveedor", nullable = false)
    private Proveedor proveedor;

    @OneToMany(mappedBy = "producto")
    private List<DetalleFactura> listaDetalleFactura;

    //@OneToMany(mappedBy = "producto")
    //private List<Entrada> listaEntrada;

    @OneToMany(mappedBy="producto")
    private List<DetalleTemporal> listaDetalleTemporal;
}
