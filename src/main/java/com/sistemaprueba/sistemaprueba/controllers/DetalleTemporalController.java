package com.sistemaprueba.sistemaprueba.controllers;

import com.sistemaprueba.sistemaprueba.entities.Cliente;
import com.sistemaprueba.sistemaprueba.entities.DetalleTemporal;
import com.sistemaprueba.sistemaprueba.entities.Factura;
import com.sistemaprueba.sistemaprueba.entities.Producto;
import com.sistemaprueba.sistemaprueba.repositories.FacturaRepository;
import com.sistemaprueba.sistemaprueba.repositories.ProductoRepository;
import com.sistemaprueba.sistemaprueba.services.DetalleTempService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/detallesTemporales")
public class DetalleTemporalController {

    @Autowired
    private DetalleTempService detalleTemporalService;


    @GetMapping("")
    public ResponseEntity<?> getAll(){
        try{
            return  ResponseEntity.status(HttpStatus.OK).body(detalleTemporalService.findAll());
        }catch(Exception e){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Intente de nuevo más tarde.\"}");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        try{
            return  ResponseEntity.status(HttpStatus.OK).body(detalleTemporalService.findById(id));
        }catch(Exception e){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Intente de nuevo más tarde.\"}");
        }
    }

    @PostMapping("")
    public ResponseEntity<?>save(@RequestBody DetalleTemporal detalleTemporal){
        try{
            return  ResponseEntity.status(HttpStatus.OK).body(detalleTemporalService.save(detalleTemporal));
        }catch(Exception e){
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Intente de nuevo más tarde.\"}");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?>update(@PathVariable Long id,@RequestBody DetalleTemporal detalleTemporal){
        try{
            return  ResponseEntity.status(HttpStatus.OK).body(detalleTemporalService.update(id,detalleTemporal));
        }catch(Exception e){
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Intente de nuevo más tarde.\"}");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try{
            return  ResponseEntity.status(HttpStatus.NO_CONTENT).body(detalleTemporalService.delete(id));
        }catch(Exception e){
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Intente de nuevo más tarde.\"}");
        }
    }

}
