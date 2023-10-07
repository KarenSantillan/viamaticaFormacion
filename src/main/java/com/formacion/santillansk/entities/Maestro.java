package com.formacion.santillansk.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Maestro {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idMaestro")
	private Integer idMaestro;
	private String nombre;
	private String apellido;
	private String titulo;
	private boolean eliminadoMaestro; //eliminacion logica

	@OneToMany(mappedBy = "maestro")
	private List<Alumno> alumnos;






}
