package com.sistemaprueba.sistemaprueba.services;

import com.sistemaprueba.sistemaprueba.controllers.repositories.ProductoRepository;
import com.sistemaprueba.sistemaprueba.controllers.repositories.ProveedorRepository;
import com.sistemaprueba.sistemaprueba.entities.Cliente;
import com.sistemaprueba.sistemaprueba.entities.Proveedor;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedorService implements  BaseService<Proveedor>{

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Override
    @Transactional
    public List<Proveedor> findAll() throws Exception {
        try {
            List<Proveedor> list = proveedorRepository.findAll();
            return list;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Proveedor findById(Long id) throws Exception {
        try {
            Optional<Proveedor> proveedorOptional= proveedorRepository.findById(id);
            return proveedorOptional.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Proveedor save(Proveedor entity) throws Exception {
        try {
            entity = proveedorRepository.save(entity);
            return entity;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Proveedor update(Long id, Proveedor entity) throws Exception {
        try {
            Optional<Proveedor> proveedorOptional = proveedorRepository.findById(id);
            Proveedor proveedor = proveedorOptional.get();
            proveedor = proveedorRepository.save(entity);
            return proveedor;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try {
            if(proveedorRepository.existsById(id)){
                proveedorRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
