package com.sistemaprueba.sistemaprueba.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "detallesDeFacturas")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class DetalleFactura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetalleFactura;

    @Column(name = "cantidad", nullable = false)
    private int cantidad;

    @Column(name = "precioTotal", nullable = false)
    private Double precioTotal;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_factura", nullable = false)
    private Factura factura;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_producto", nullable = false)
    private Producto producto;




}
