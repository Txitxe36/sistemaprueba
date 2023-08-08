package com.sistemaprueba.sistemaprueba.services;

import com.sistemaprueba.sistemaprueba.entities.Producto;
import com.sistemaprueba.sistemaprueba.repositories.EntradaRepository;
import com.sistemaprueba.sistemaprueba.entities.Entrada;
import com.sistemaprueba.sistemaprueba.repositories.ProductoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntradaService implements BaseService<Entrada>{

    @Autowired
    private EntradaRepository entradaRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    @Transactional
    public List<Entrada> findAll() throws Exception {
        try {
            List<Entrada> list = entradaRepository.findAll();
            return list;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Entrada findById(Long id) throws Exception {
        try {
            Optional<Entrada> entradaOptional= entradaRepository.findById(id);
            return entradaOptional.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Entrada save(Entrada entity) throws Exception {
        try {
            entity = entradaRepository.save(entity);
            return entity;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Entrada update(Long id, Entrada entity) throws Exception {
        try {
            Optional<Entrada> entradaOptional = entradaRepository.findById(id);
            entradaOptional.get().setFecha(entity.getFecha());
            entradaOptional.get().setCantidad(entity.getCantidad());
            entradaOptional.get().setPrecio(entity.getPrecio());
            entradaOptional.get().setProducto(entity.getProducto());

            Optional<Producto> optionalProducto = this.productoRepository.findById(entity.getProducto().getIdProducto());

            entradaOptional.get().setProducto(optionalProducto.get());
            Entrada entrada = entradaOptional.get();
            //entrada = entradaRepository.save(entity);
            return entrada;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try {
            if(entradaRepository.existsById(id)){
                entradaRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
