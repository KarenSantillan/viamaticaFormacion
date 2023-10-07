package com.formacion.santillansk.repository;


import java.util.List;
import com.formacion.santillansk.entities.Alumno;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.formacion.santillansk.entities.AlumnohasMaterias;
import com.formacion.santillansk.entities.Materia;

@Repository
public interface AlumnohasMateriaRepository extends JpaRepository<AlumnohasMaterias, Integer>{
	//Mejores promedios
  //  @Query("from AlumnohasMaterias am where am.materia = :materia order by am.materia.puntos DESC")
   // List<AlumnohasMaterias> findTopNByMateriaOrderByPromedioDesc(@Param("materia") Materia materia, Pageable pageable);

}
