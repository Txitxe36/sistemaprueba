package com.sistemaprueba.sistemaprueba.services;

import java.io.Serializable;
import java.util.List;
/*Declaramos las 5 operaciones principales del CRUD
* esta interface la vamos a poder implementar en todos los servicios que necesitemos
* sin la necesidad de declarar uno por uno los metddos
*
*
* si seguimos el metodo mas generico
* public interface BaseService <E extends Base, Id extends Serializable>
* */
public interface BaseService <E>{

    public List<E> findAll() throws Exception;

    public E findById(Long id) throws Exception;

    public E save(E entity) throws Exception;

    public E update(Long id, E entity) throws Exception;

    public boolean delete(Long id) throws Exception;
}
