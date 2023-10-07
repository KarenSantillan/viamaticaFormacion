package com.formacion.santillansk.controller;

import java.util.List;

import com.formacion.santillansk.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.formacion.santillansk.service.*;

@Controller
@RequestMapping("/api")
public class ListadoController {
	@Autowired
	AlumnoService alumnoService;
	@Autowired
	MaestroService maestroService;
	@Autowired
	MateriaService materiaService;

	@GetMapping("/alumno")
	public List<Alumno> buscarAlumnoNombre(@RequestParam String alumno){
		return alumnoService.buscarAlumnoNombre(alumno);
	}
	@GetMapping("/maestro")
	public List<Maestro> buscarMaestroNombre(@RequestParam String maestro){
		return maestroService.buscarMaestroNombre(maestro);
	}

	@GetMapping("/alumnosbymaestro")
	public Integer countAlumnosByMaestro(@RequestParam Integer idmaestro){
		return maestroService.countAlumnosByMaestro(idmaestro);
	}

	@GetMapping("/mejoresCalificaciones")
	public List<AlumnohasMaterias> mejoresCalificaciones(Integer idMateria, int cant){
		return materiaService.mejoresCalificaciones(idMateria, cant);
	}

	@GetMapping("/materiaAlta")
	public Materia materiaPuntajeAlto(String puntaje, Integer idAlumno){
		return alumnoService.materiaPuntajeAlto(puntaje, idAlumno);
	}

	@GetMapping("/idMaestro")
	public MaestroDTO consultaMaestroAlumnos(@PathVariable Integer idMaestro){
		Maestro maestro = maestroService.findByIdWithAlumnos(idMaestro);
		return new MaestroDTO(maestro);
	}

}
