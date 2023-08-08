package com.sistemaprueba.sistemaprueba.services;

import com.sistemaprueba.sistemaprueba.entities.Cliente;
import com.sistemaprueba.sistemaprueba.entities.Rol;
import com.sistemaprueba.sistemaprueba.repositories.RolRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolService implements BaseService<Rol>{

    @Autowired
    private RolRepository rolRepository;

    @Override
    @Transactional
    public List<Rol> findAll() throws Exception {
        try {
            List<Rol> entity = rolRepository.findAll();
            return entity;
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Rol findById(Long id) throws Exception {
        try {
            Optional<Rol> entity = rolRepository.findById(id);
            return entity.get();
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Rol save(Rol entity) throws Exception {
        try {
            entity = rolRepository.save(entity);
            return entity;
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Rol update(Long id, Rol entity) throws Exception {
        try {
           Optional<Rol> entityOptional = this.rolRepository.findById(id);
           entityOptional.get().setRol(entity.getRol());
           Rol rol = entityOptional.get();
           return rol;
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try {
            if(rolRepository.existsById(id)){
                rolRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
