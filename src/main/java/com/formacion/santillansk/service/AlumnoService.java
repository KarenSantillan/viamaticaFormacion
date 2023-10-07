package com.formacion.santillansk.service;

import java.util.*;
import java.util.stream.Collectors;

import com.formacion.santillansk.entities.Materia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.formacion.santillansk.entities.Alumno;
import com.formacion.santillansk.repository.AlumnoRepository;

@Service
public class AlumnoService {
	@Autowired
	AlumnoRepository alumnoRepository;
	//métodos
    public List<Alumno> buscarAlumnoNombre(String nombre){

		return alumnoRepository.findByNombreContaining(nombre);
    }
	//materia con puntaje mas alto del alumno
	public Materia materiaPuntajeAlto(String puntaje, Integer idAlumno){
		Alumno alumno = alumnoRepository.findById(idAlumno).orElse(null); //obtiene el alumno
		List<Materia> materiasAlumno = new ArrayList<>();
		//materias relacionadas al alumno ingresado
		for(Materia materia : alumno.getMaterias()){
			materiasAlumno.add(materia);
		}
		//filto de materias segun puntaje
		List<Materia> materiasSegunPuntaje = materiasAlumno.stream().filter(materia -> materia.getPuntos()  == puntaje).collect(Collectors.toList());
		Materia materiaAlta = Collections.max(materiasSegunPuntaje, Comparator.comparing(Materia::getPuntos));
		return materiaAlta;
	}


    
    public void deleteAlumno(Integer idAlumno) {
    	//Optional<Alumno> alumno = alumnoRepository.findById(idAlumno);
		Alumno alumno = alumnoRepository.findById(idAlumno).orElse(null);
		if (alumno != null){
			alumnoRepository.deleteAlumno(alumno);
		}
    	
    }

	

}
