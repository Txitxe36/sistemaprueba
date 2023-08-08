package com.sistemaprueba.sistemaprueba.services;

import com.sistemaprueba.sistemaprueba.entities.Cliente;
import com.sistemaprueba.sistemaprueba.repositories.ClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService implements BaseService<Cliente>{

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    @Transactional
    public List<Cliente> findAll() throws Exception {
        try {
            List<Cliente> list = clienteRepository.findAll();
            return list;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Cliente findById(Long id) throws Exception {
        try {
            Optional<Cliente> clienteOptional= clienteRepository.findById(id);
            return clienteOptional.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Cliente save(Cliente entity) throws Exception {
        try {
           entity = clienteRepository.save(entity);
           return entity;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Cliente update(Long id, Cliente entity) throws Exception {
        try {
            Optional<Cliente> clienteOptional = clienteRepository.findById(id);
            clienteOptional.get().setNombre(entity.getNombre());
            clienteOptional.get().setDni(entity.getDni());
            clienteOptional.get().setTelefono(entity.getTelefono());
            clienteOptional.get().setDireccion(entity.getDireccion());
            Cliente cliente = clienteOptional.get();
            //cliente = clienteRepository.save(entity);
            return cliente;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try {
           if(clienteRepository.existsById(id)){
               clienteRepository.deleteById(id);
               return true;
           }else{
               throw new Exception();
           }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
