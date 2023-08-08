package com.sistemaprueba.sistemaprueba.controllers;

import com.sistemaprueba.sistemaprueba.entities.Cliente;
import com.sistemaprueba.sistemaprueba.entities.Factura;
import com.sistemaprueba.sistemaprueba.entities.Usuario;
import com.sistemaprueba.sistemaprueba.repositories.ClienteRepository;
import com.sistemaprueba.sistemaprueba.repositories.UsuarioRepository;
import com.sistemaprueba.sistemaprueba.services.FacturaService;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/facturas")
public class FacturaController {

    @Autowired
    private FacturaService facturaService;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("")
    public ResponseEntity<?> getAll(){
        try{
            return  ResponseEntity.status(HttpStatus.OK).body(facturaService.findAll());
        }catch(Exception e){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Intente de nuevo más tarde.\"}");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        try{
            return  ResponseEntity.status(HttpStatus.OK).body(facturaService.findById(id));
        }catch(Exception e){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Intente de nuevo más tarde.\"}");
        }
    }

    @PostMapping("")
    public ResponseEntity<?>save(@RequestBody Factura factura){
        Optional<Cliente> optionalCliente = this.clienteRepository.findById(factura.getCliente().getId());
        if (!optionalCliente.isPresent()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El cliente solicitado no existe");
        }
        Optional<Usuario> optionalUsuario = this.usuarioRepository.findById(factura.getUsuario().getId());
        if(!optionalUsuario.isPresent()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El usuario solicitado no existe");
        }

        try{
            factura.setCliente(optionalCliente.get());
            factura.setUsuario(optionalUsuario.get());
            return  ResponseEntity.status(HttpStatus.OK).body(facturaService.save(factura));
        }catch(Exception e){
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Intente de nuevo más tarde.\"}");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?>update(@PathVariable Long id,@RequestBody Factura factura){

        try{
            return  ResponseEntity.status(HttpStatus.OK).body(facturaService.update(id,factura));
        }catch(Exception e){
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Intente de nuevo más tarde.\"}");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try{
            return  ResponseEntity.status(HttpStatus.NO_CONTENT).body(facturaService.delete(id));
        }catch(Exception e){
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Intente de nuevo más tarde.\"}");
        }
    }

}
