package com.sistemaprueba.sistemaprueba.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "detallesTemporales")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class DetalleTemporal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetalleTemporal;

    @Column(nullable = false)
    private int cantidad;

    @Column(nullable = false)
    private Double precioTotal;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_factura", nullable = false)
    private Factura factura;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_producto", nullable = false)
    private Producto producto;



}
