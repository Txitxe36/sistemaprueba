package com.sistemaprueba.sistemaprueba.services;

import com.sistemaprueba.sistemaprueba.entities.Factura;
import com.sistemaprueba.sistemaprueba.entities.Producto;
import com.sistemaprueba.sistemaprueba.repositories.DetalleFacturaRepoitory;
import com.sistemaprueba.sistemaprueba.entities.DetalleFactura;
import com.sistemaprueba.sistemaprueba.repositories.FacturaRepository;
import com.sistemaprueba.sistemaprueba.repositories.ProductoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleFacturaService implements BaseService<DetalleFactura>{

    @Autowired
    private DetalleFacturaRepoitory detalleFacturaRepoitory;

    @Autowired
    private FacturaRepository facturaRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    @Transactional
    public List<DetalleFactura> findAll() throws Exception {
        try {
            List<DetalleFactura> list = detalleFacturaRepoitory.findAll();
            return list;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public DetalleFactura findById(Long id) throws Exception {
        try {
            Optional<DetalleFactura> facturaOptional= detalleFacturaRepoitory.findById(id);
            return facturaOptional.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public DetalleFactura save(DetalleFactura entity) throws Exception {
        try {
            entity = detalleFacturaRepoitory.save(entity);
            return entity;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public DetalleFactura update(Long id, DetalleFactura entity) throws Exception {
        try {
            Optional<DetalleFactura> detalleFacturaOptional = detalleFacturaRepoitory.findById(id);
            Optional<Factura> optionalFactura = this.facturaRepository.findById(detalleFacturaOptional.get().getFactura().getIdFactura());
            Optional<Producto> optionalProducto = this.productoRepository.findById(detalleFacturaOptional.get().getProducto().getIdProducto());

            detalleFacturaOptional.get().setCantidad(entity.getCantidad());
            detalleFacturaOptional.get().setPrecioTotal(entity.getPrecioTotal());
            detalleFacturaOptional.get().setFactura(optionalFactura.get());
            detalleFacturaOptional.get().setProducto(optionalProducto.get());

            DetalleFactura detalleFactura = detalleFacturaOptional.get();
            //detalleFactura = detalleFacturaRepoitory.save(entity);
            return detalleFactura;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try {
            if(detalleFacturaRepoitory.existsById(id)){
                detalleFacturaRepoitory.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
