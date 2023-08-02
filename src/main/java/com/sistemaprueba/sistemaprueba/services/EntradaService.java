package com.sistemaprueba.sistemaprueba.services;

import com.sistemaprueba.sistemaprueba.controllers.repositories.EntradaRepository;
import com.sistemaprueba.sistemaprueba.entities.Cliente;
import com.sistemaprueba.sistemaprueba.entities.Entrada;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntradaService implements BaseService<Entrada>{

    @Autowired
    private EntradaRepository entradaRepository;

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
            Entrada entrada = entradaOptional.get();
            entrada = entradaRepository.save(entity);
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
