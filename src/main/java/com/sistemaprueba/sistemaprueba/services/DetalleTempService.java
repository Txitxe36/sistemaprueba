package com.sistemaprueba.sistemaprueba.services;

import com.sistemaprueba.sistemaprueba.controllers.repositories.DetalleTemporalRepository;
import com.sistemaprueba.sistemaprueba.entities.DetalleFactura;
import com.sistemaprueba.sistemaprueba.entities.DetalleTemporal;
import com.sistemaprueba.sistemaprueba.entities.Factura;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleTempService implements BaseService<DetalleTemporal> {

    @Autowired
    private DetalleTemporalRepository detalleTemporalRepository;

    @Override
    @Transactional
    public List<DetalleTemporal> findAll() throws Exception {
        try {
            List<DetalleTemporal> list = detalleTemporalRepository.findAll();
            return list;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public DetalleTemporal findById(Long id) throws Exception {
        try {
            Optional<DetalleTemporal> detalleOptional= detalleTemporalRepository.findById(id);
            return detalleOptional.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public DetalleTemporal save(DetalleTemporal entity) throws Exception {
        try {
            entity = detalleTemporalRepository.save(entity);
            return entity;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public DetalleTemporal update(Long id, DetalleTemporal entity) throws Exception {
        try {
            Optional<DetalleTemporal> detalleOptional = detalleTemporalRepository.findById(id);
            DetalleTemporal detalleFactura = detalleOptional.get();
            detalleFactura = detalleTemporalRepository.save(entity);
            return detalleFactura;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try {
            if(detalleTemporalRepository.existsById(id)){
                detalleTemporalRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
