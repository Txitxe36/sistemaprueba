package com.sistemaprueba.sistemaprueba.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;


//De este repositorio no se pueden crear instancias
//recibe el tipo de entidad que extiende de Base asi no se puede utilizar ntidades que no extiendan de Base,
//asi se limita los tipos que pueda recibir
//recibe el tipo de ID que tiene la entidad y tiene que extender de serialiable


//public interface BaseRepository <E extends Base, ID extends Serializable> extends JpaRepository<E,ID>


@NoRepositoryBean
public interface BaseRepository <E, ID extends Serializable> extends JpaRepository<E,ID> {
    //aca usamos el BaseRepository sin que extienda de la entidad Base
}
