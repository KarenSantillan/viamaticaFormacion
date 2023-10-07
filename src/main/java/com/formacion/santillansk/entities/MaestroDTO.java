package com.formacion.santillansk.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.List;
@Data
public class MaestroDTO {
    private String nombre;
    private List<Alumno> alumnos;
    public MaestroDTO(Maestro maestro){
        this.nombre = maestro.getNombre();
        this.alumnos = maestro.getAlumnos();
    }
}
