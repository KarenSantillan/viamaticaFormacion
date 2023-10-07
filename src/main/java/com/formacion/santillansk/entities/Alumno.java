package com.formacion.santillansk.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data // encapsulamiento
@Builder //función para crear una variable de la clase
@AllArgsConstructor //constructor con todas las variables
@NoArgsConstructor //constructor vacío
public class Alumno {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idAlumno")
	private Integer idAlumno;
	private String nombre;
	private String apellido;
	private Integer promedio;
	private boolean eliminadoAlumno; //variable de control para eliminacion logica
	@ManyToOne
	@JoinColumn(name = "idMaestro")
	private Maestro maestro;

	@OneToMany(mappedBy = "alumnoMateria")
	private List<AlumnohasMaterias> ahm = new ArrayList<>();

	private Materia materias;

	
	
	
	
	
	
	


	
	
}
