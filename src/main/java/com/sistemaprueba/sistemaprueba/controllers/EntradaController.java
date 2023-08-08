package com.sistemaprueba.sistemaprueba.controllers;

import com.sistemaprueba.sistemaprueba.entities.Cliente;
import com.sistemaprueba.sistemaprueba.entities.Entrada;
import com.sistemaprueba.sistemaprueba.entities.Producto;
import com.sistemaprueba.sistemaprueba.repositories.ProductoRepository;
import com.sistemaprueba.sistemaprueba.services.EntradaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/entradas")
public class EntradaController {

    @Autowired
    private EntradaService entradaService;

    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping("")
    public ResponseEntity<?> getAll(){
        try{
            return  ResponseEntity.status(HttpStatus.OK).body(entradaService.findAll());
        }catch(Exception e){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Intente de nuevo más tarde.\"}");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        try{
            return  ResponseEntity.status(HttpStatus.OK).body(entradaService.findById(id));
        }catch(Exception e){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Intente de nuevo más tarde.\"}");
        }
    }

    @PostMapping("")
    public ResponseEntity<?>save(@RequestBody Entrada entrada) throws Exception {
        Optional<Producto> optionalProducto = this.productoRepository.findById(entrada.getProducto().getIdProducto());
        if (!optionalProducto.isPresent()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("no existe el ide de producto");
        }
        entrada.setProducto(optionalProducto.get());
        Entrada entrada1 = this.entradaService.save(entrada);
        return  ResponseEntity.status(HttpStatus.OK).body(entradaService.save(entrada1));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?>update(@PathVariable Long id,@RequestBody Entrada entrada){
        Optional<Producto> optionalProducto = this.productoRepository.findById(id);
        try{
            return  ResponseEntity.status(HttpStatus.OK).body(entradaService.update(id,entrada));
        }catch(Exception e){
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Intente de nuevo más tarde.\"}");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try{
            return  ResponseEntity.status(HttpStatus.NO_CONTENT).body(entradaService.delete(id));
        }catch(Exception e){
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Intente de nuevo más tarde.\"}");
        }
    }

}
