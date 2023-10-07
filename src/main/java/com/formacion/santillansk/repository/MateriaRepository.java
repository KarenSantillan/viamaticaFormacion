package com.formacion.santillansk.repository;

import com.formacion.santillansk.entities.Maestro;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.formacion.santillansk.entities.Materia;

import java.util.List;

@Repository
public interface MateriaRepository extends JpaRepository<Materia, Integer>{
    static final Logger log = LoggerFactory.getLogger(AlumnoRepository.class);
    //eliminacion logica

    @Query("from  Materia am where am.puntos = :puntos GROUP BY am.materia")
    List<Materia> findMateriasByPuntaje(@Param("puntos") int puntos);
    default void deleteMateria(Materia materia){
        try{
            materia.setEliminadoMateria(true);
            save(materia);
        }catch (Exception e){
            log.error("Se ha generado un error al realizar la eliminación", e);
        }
    }
}
