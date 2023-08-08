package com.sistemaprueba.sistemaprueba.services;

import com.sistemaprueba.sistemaprueba.entities.Cliente;
import com.sistemaprueba.sistemaprueba.entities.Usuario;
import com.sistemaprueba.sistemaprueba.repositories.ClienteRepository;
import com.sistemaprueba.sistemaprueba.repositories.FacturaRepository;
import com.sistemaprueba.sistemaprueba.entities.Factura;
import com.sistemaprueba.sistemaprueba.repositories.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacturaService implements BaseService<Factura>{

    @Autowired
    private FacturaRepository facturaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    @Transactional
    public List<Factura> findAll() throws Exception {
        try {
            List<Factura> list = facturaRepository.findAll();
            return list;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Factura findById(Long id) throws Exception {
        try {
            Optional<Factura> facturaOptional= facturaRepository.findById(id);
            return facturaOptional.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Factura save(Factura entity) throws Exception {
        try {
            entity = facturaRepository.save(entity);
            return entity;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Factura update(Long id, Factura entity) throws Exception {
        try {
            Optional<Factura> facturaOptional = facturaRepository.findById(id);
            facturaOptional.get().setFecha(entity.getFecha());
            facturaOptional.get().setTotalFactura(entity.getTotalFactura());

            Optional<Cliente> clienteOptional = this.clienteRepository.findById(entity.getCliente().getId());
            Optional<Usuario> usuarioOptional = this.usuarioRepository.findById(entity.getUsuario().getId());

            facturaOptional.get().setCliente(clienteOptional.get());
            facturaOptional.get().setUsuario(usuarioOptional.get());

            Factura factura = facturaOptional.get();
            //factura = facturaRepository.save(entity);
            return factura;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try {
            if(facturaRepository.existsById(id)){
                facturaRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
