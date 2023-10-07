package com.formacion.santillansk.service;

import com.formacion.santillansk.entities.AlumnohasMaterias;
import com.formacion.santillansk.entities.Materia;
import com.formacion.santillansk.entities.Alumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.formacion.santillansk.repository.MateriaRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class MateriaService {
	@Autowired
	MateriaRepository materiaRepository;
	//Alumno(s) con el mejor promedio en una materia
	public List<AlumnohasMaterias> mejoresCalificaciones(Integer idMateria, int cant){
		Materia materia = materiaRepository.findById(idMateria).orElse(null); //obtener la materia segun el id
		List<AlumnohasMaterias> alumnosMateria  = new ArrayList<>();
		for(AlumnohasMaterias alumno : materia.getAhmateria()){
			alumnosMateria.add(alumno);
		}
		//alumnosMateria.sort(Comparator.comparingDouble(Alumno::getPromedio).reversed()); //OJO
		return alumnosMateria.subList(0, cant);
	}

	//eliminación logica
	public void deleteMateria(Integer idMateria) {
		Materia materia = materiaRepository.findById(idMateria).orElse(null);
		if (materia != null){
			materiaRepository.deleteMateria(materia);
		}

	}
}
