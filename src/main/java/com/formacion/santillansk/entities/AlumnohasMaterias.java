package com.formacion.santillansk.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AlumnohasMaterias {
	@Id
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "idAlumno")
	private Alumno alumnoMateria;

	@ManyToOne
	@JoinColumn(name = "idMateria")	
	private Materia materiaAlumno;

	
	
}
