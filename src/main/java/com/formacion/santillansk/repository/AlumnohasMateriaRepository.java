package com.formacion.santillansk.repository;


import java.util.List;

import com.formacion.santillansk.entities.AlumnohasMaterias;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnohasMateriaRepository extends JpaRepository<AlumnohasMaterias, Integer> {
    //Mejores promedios
    @Query("from AlumnohasMaterias am where am.materiaAlumno = :materia order by am.materiaAlumno.puntos DESC")
    List<AlumnohasMaterias> findTopNByMateriaOrderByPromedioDesc(@Param("materia") Integer materia, Pageable pageable);

}
