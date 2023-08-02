package com.sistemaprueba.sistemaprueba.services;

import com.sistemaprueba.sistemaprueba.entities.Usuario;
import com.sistemaprueba.sistemaprueba.controllers.repositories.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService implements BaseService<Usuario>{

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Override
    @Transactional
    public List<Usuario> findAll() throws Exception {
        try {
            List<Usuario> usuarios = usuarioRepository.findAll();
            return usuarios;
        }catch (Exception e) {
            throw new Exception();
        }
    }

    @Override
    @Transactional
    public Usuario findById(Long id) throws Exception {
        try {
           Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
            return usuarioOptional.get();
        }catch (Exception e) {
            throw new Exception();
        }
    }

    @Override
    @Transactional
    public Usuario save(Usuario entity) throws Exception {
        try {
            entity = usuarioRepository.save(entity);
            return entity;
        }catch (Exception e) {
            throw new Exception();
        }
    }

    @Override
    @Transactional
    public Usuario update(Long id, Usuario entity) throws Exception {
        try {
            Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
            Usuario usuario  = usuarioOptional.get();
            usuario = usuarioRepository.save(entity);
            return usuario;
        }catch (Exception e) {
            throw new Exception();
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try {
            if(usuarioRepository.existsById(id)){
                usuarioRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }

        }catch (Exception e) {
            throw new Exception();
        }
    }
}
