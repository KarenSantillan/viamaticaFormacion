package com.formacion.santillansk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.formacion.santillansk.entities.AlumnohasMaterias;
import com.formacion.santillansk.entities.Materia;
import com.formacion.santillansk.repository.AlumnohasMateriaRepository;

@Service
public class AlumnohasMateriaService {
	@Autowired
	AlumnohasMateriaRepository alumnohasMateriaRepository;
	//metodos
    public List<AlumnohasMaterias> findTopNByMateriaOrderByPromedioDesc(@Param("materia") Materia materia, Pageable pageable){
    	return alumnohasMateriaRepository.findTopNByMateriaOrderByPromedioDesc(materia.getIdMateria(), pageable);
    }
//
//    public List<Materia> findMateriasByPuntaje(@Param("puntos") int puntos){
//    	return alumnohasMateriaRepository.findMateriasByPuntaje(puntos);
//    }

    

}
