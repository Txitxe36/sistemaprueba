package com.sistemaprueba.sistemaprueba.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "facturas")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFactura;

    @Temporal(TemporalType.DATE)
    private Date fecha;

    @Column(name = "totalFactura")
    private Double totalFactura;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_cliente",nullable = false)
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_usuario",nullable = false)
    private Usuario usuario;

    //@OneToMany(mappedBy = "factura")
    //private List<DetalleFactura> listaDetalleFactura;

    //OneToMany(mappedBy= "factura")
    //private List<DetalleTemporal> listaDetalleTemporal;



}
