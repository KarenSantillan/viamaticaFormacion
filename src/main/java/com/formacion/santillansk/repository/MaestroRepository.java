package com.formacion.santillansk.repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import com.formacion.santillansk.entities.Maestro;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MaestroRepository extends JpaRepository<Maestro, Integer>{
    Logger log = LoggerFactory.getLogger(AlumnoRepository.class);
	//Consulta con nombre
    List<Maestro> findByNombreContaining(String nombre);

    //Consulta de maestro y sus respectivos alumnos
    @Query("from Maestro m where m.idMaestro = :idMaestro")
    Maestro findByIdWithAlumnos(@Param("idMaestro") Integer idMaestro);
    //eliminacion logica
    default void deleteMaestro(Maestro maestro){
        try{
            maestro.setEliminadoMaestro(true);
            save(maestro);
        }catch (Exception e){
            log.error("Se ha generado un error al realizar la eliminación", e);
        }
    }
}
