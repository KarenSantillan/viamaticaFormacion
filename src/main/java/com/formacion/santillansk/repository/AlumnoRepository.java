package com.formacion.santillansk.repository;

import java.util.List;

import com.formacion.santillansk.CustomException;
import com.formacion.santillansk.entities.Maestro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.formacion.santillansk.entities.Alumno;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {
    Logger log = LoggerFactory.getLogger(AlumnoRepository.class);

    //Búsqueda por nombre
    @Query("from Alumno v where v.nombre like %?1%")
    List<Alumno> findByNombreContaining(String nombre);

    //Encontrar alumnos segun el maestro
    List<Alumno> findByMaestro(Maestro maestro);


    //eliminacion logica
    default void deleteAlumno(Alumno alumno) {
        try {
            alumno.setEliminadoAlumno(true);
            save(alumno);
            throw new CustomException("Ha ocurrido un error en la eliminacion del alumno");
        } catch (CustomException ce) {
            log.error("Se ha generado la siguiente excepcion: " + ce.getMessage());
        }
    }
}
