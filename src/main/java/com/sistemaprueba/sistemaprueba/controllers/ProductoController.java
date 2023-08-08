package com.sistemaprueba.sistemaprueba.controllers;

import com.sistemaprueba.sistemaprueba.entities.*;
import com.sistemaprueba.sistemaprueba.repositories.ProveedorRepository;
import com.sistemaprueba.sistemaprueba.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private ProveedorRepository proveedorRepository;


    @GetMapping("")
    public ResponseEntity<?> getAll(){
        try{
            return  ResponseEntity.status(HttpStatus.OK).body(productoService.findAll());
        }catch(Exception e){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Intente de nuevo más tarde.\"}");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        try{
            return  ResponseEntity.status(HttpStatus.OK).body(productoService.findById(id));
        }catch(Exception e){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Intente de nuevo más tarde.\"}");
        }
    }

    @PostMapping
   public ResponseEntity<?>save(@RequestBody Producto producto) throws Exception {
        Optional<Proveedor> optionalProveedor = this.proveedorRepository.findById(producto.getProveedor().getIdProveedor());
        if (!optionalProveedor.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ERROR : El ID del Proveedor no existe");
        }
        producto.setProveedor(optionalProveedor.get());
        Producto prod = this.productoService.save(producto);
        return  ResponseEntity.status(HttpStatus.OK).body(productoService.save(producto));

}

    @PutMapping("/{id}")
    public ResponseEntity<?>update(@PathVariable Long id,@RequestBody Producto producto) throws Exception {
        Optional<Proveedor> optionalProveedor = this.proveedorRepository.findById(id);
            if (!optionalProveedor.isPresent()){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Intente de nuevo más tarde.\"}");
            }
        //producto.setProveedor(optionalProveedor.get());
        Producto prod = this.productoService.update(id, producto);
        return  ResponseEntity.status(HttpStatus.OK).body(productoService.update(id,prod));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try{
            return  ResponseEntity.status(HttpStatus.NO_CONTENT).body(productoService.delete(id));
        }catch(Exception e){
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Intente de nuevo más tarde.\"}");
        }
    }

}
