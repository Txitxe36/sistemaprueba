package com.sistemaprueba.sistemaprueba.controllers;


import com.sistemaprueba.sistemaprueba.entities.Rol;
import com.sistemaprueba.sistemaprueba.services.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")  //con esto permitimos que etremos a nuestra api desde distinros origines/clientes
@RequestMapping(path = "/api/v1/roles")
public class RolController {


    @Autowired
    private RolService rolService;

    public RolController(RolService rolService) {
        this.rolService = rolService;
    }

    //el ResponseEntity nos va devolver la resùesta/status en for,ato JSON para nuesta app web
    //adentro tiene elstatus HTTPStatus y el bodu/cuerpo en el que se envia lo datos
    @GetMapping("")
    public ResponseEntity<?> getAll(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(rolService.findAll());
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente más tarda.\"}");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(rolService.findById(id));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente más tarda.\"}");
        }
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody Rol entity){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(rolService.save(entity));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarda.\"}");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?>update(@PathVariable Long id,@RequestBody Rol entity){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(rolService.update(id, entity));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarda.\"}");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(rolService.delete(id));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarda.\"}");
        }
    }




}
