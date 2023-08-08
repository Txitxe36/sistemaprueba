package com.sistemaprueba.sistemaprueba.services;

import com.sistemaprueba.sistemaprueba.entities.Factura;
import com.sistemaprueba.sistemaprueba.entities.Producto;
import com.sistemaprueba.sistemaprueba.repositories.DetalleTemporalRepository;
import com.sistemaprueba.sistemaprueba.entities.DetalleTemporal;
import com.sistemaprueba.sistemaprueba.repositories.FacturaRepository;
import com.sistemaprueba.sistemaprueba.repositories.ProductoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleTempService implements BaseService<DetalleTemporal> {

    @Autowired
    private DetalleTemporalRepository detalleTemporalRepository;

    @Autowired
    private FacturaRepository facturaRepository;

    @Autowired
    private ProductoRepository productoRepository;


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
        Optional<Factura> optionalFactura = this.facturaRepository.findById(entity.getFactura().getIdFactura());
        Optional<Producto> optionalProducto = this.productoRepository.findById(entity.getProducto().getIdProducto());
        try {
            entity.setFactura(optionalFactura.get());
            entity.setProducto(optionalProducto.get());
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
            Optional<Factura> optionalFactura = this.facturaRepository.findById(entity.getFactura().getIdFactura());
            Optional<Producto> optionalProducto = this.productoRepository.findById(entity.getProducto().getIdProducto());

            detalleOptional.get().setCantidad(entity.getCantidad());
            detalleOptional.get().setPrecioTotal(entity.getPrecioTotal());
            detalleOptional.get().setFactura(optionalFactura.get());
            detalleOptional.get().setProducto(optionalProducto.get());

            DetalleTemporal detalleFactura = detalleOptional.get();
            //detalleFactura = detalleTemporalRepository.save(entity);
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
