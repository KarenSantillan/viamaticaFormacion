package com.formacion.santillansk.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Materia {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idMateria;
	private String descripcion;
	private String puntos;
	private boolean eliminadoMateria; //eliminacion logica
	@OneToMany(mappedBy = "materiaAlumno")
	private List<AlumnohasMaterias> ahmateria = new ArrayList<>();

	
}
