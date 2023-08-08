package com.sistemaprueba.sistemaprueba.controllers;

import com.sistemaprueba.sistemaprueba.entities.Rol;
import com.sistemaprueba.sistemaprueba.entities.Usuario;
import com.sistemaprueba.sistemaprueba.repositories.RolRepository;
import com.sistemaprueba.sistemaprueba.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private RolRepository rolRepository;

    @GetMapping
    public ResponseEntity<?> getAll(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(usuarioService.findAll());
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Intente de nuevo más tarde.\"}");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(usuarioService.findById(id));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Intente de nuevo más tarde.\"}");
        }
    }

    @PostMapping
    public ResponseEntity<?>save(@RequestBody Usuario usuario) throws Exception {
        Optional<Rol> rolOptional = this.rolRepository.findById(usuario.getRol().getIdRol());
        if (!rolOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ERROR : El ID del ROL que ingresaste no exite");
        }
        usuario.setRol(rolOptional.get());
        Usuario usu = this.usuarioService.save(usuario);
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.save(usu));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,@RequestBody Usuario usuario) throws Exception {
        Optional<Rol> rolOptional = this.rolRepository.findById(usuario.getRol().getIdRol());
        if (!rolOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ERROR : El ID del ROL que ingresaste no exite");
        }
        usuario.setRol(rolOptional.get());
        Usuario usu = this.usuarioService.update(id,usuario);
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.save(usu));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?>delete(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(usuarioService.delete(id));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Intente de nuevo más tarde.\"}");
        }
    }







}
