package com.sistemaprueba.sistemaprueba.controllers;

import com.sistemaprueba.sistemaprueba.entities.DetalleFactura;
import com.sistemaprueba.sistemaprueba.entities.Factura;
import com.sistemaprueba.sistemaprueba.entities.Producto;
import com.sistemaprueba.sistemaprueba.repositories.FacturaRepository;
import com.sistemaprueba.sistemaprueba.repositories.ProductoRepository;
import com.sistemaprueba.sistemaprueba.services.DetalleFacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/detallefacturas")
public class DetalleFacturaController {

    @Autowired
    private DetalleFacturaService detalleFacturaService;

    @Autowired
    private FacturaRepository facturaRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping("")
    public ResponseEntity<?> getAll(){
        try{
            return  ResponseEntity.status(HttpStatus.OK).body(detalleFacturaService.findAll());
        }catch(Exception e){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Intente de nuevo más tarde.\"}");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        try{
            return  ResponseEntity.status(HttpStatus.OK).body(detalleFacturaService.findById(id));
        }catch(Exception e){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Intente de nuevo más tarde.\"}");
        }
    }

    @PostMapping("")
    public ResponseEntity<?>save(@RequestBody DetalleFactura detalleFactura){
        Optional<Factura> optionalFactura = this.facturaRepository.findById(detalleFactura.getFactura().getIdFactura());
        Optional<Producto> optionalProducto = this.productoRepository.findById(detalleFactura.getProducto().getIdProducto());

        if (!optionalFactura.isPresent()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("La factura solicidada no existe");
        }
        if (!optionalProducto.isPresent()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El producto solicitado no existe");
        }
        try{
            detalleFactura.setFactura(optionalFactura.get());
            detalleFactura.setProducto(optionalProducto.get());
            return  ResponseEntity.status(HttpStatus.OK).body(detalleFacturaService.save(detalleFactura));
        }catch(Exception e){
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Intente de nuevo más tarde.\"}");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?>update(@PathVariable Long id,@RequestBody DetalleFactura detalleFactura){
        try{
            return  ResponseEntity.status(HttpStatus.OK).body(detalleFacturaService.update(id,detalleFactura));
        }catch(Exception e){
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Intente de nuevo más tarde.\"}");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try{
            return  ResponseEntity.status(HttpStatus.NO_CONTENT).body(detalleFacturaService.delete(id));
        }catch(Exception e){
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Intente de nuevo más tarde.\"}");
        }
    }


}
