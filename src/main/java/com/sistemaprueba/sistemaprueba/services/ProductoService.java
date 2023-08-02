package com.sistemaprueba.sistemaprueba.services;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.sistemaprueba.sistemaprueba.controllers.repositories.ProductoRepository;
import com.sistemaprueba.sistemaprueba.entities.Factura;
import com.sistemaprueba.sistemaprueba.entities.Producto;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService implements BaseService<Producto> {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    @Transactional
    public List<Producto> findAll() throws Exception {
        try {
            List<Producto> list = productoRepository.findAll();
            return list;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Producto findById(Long id) throws Exception {
        try {
            Optional<Producto> productoOptional= productoRepository.findById(id);
            return productoOptional.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Producto save(Producto entity) throws Exception {
        try {
            entity = productoRepository.save(entity);
            return entity;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Producto update(Long id, Producto entity) throws Exception {
        try {
            Optional<Producto> productoOptional = productoRepository.findById(id);
            Producto producto = productoOptional.get();
            producto = productoRepository.save(entity);
            return producto;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try {
            if(productoRepository.existsById(id)){
                productoRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
