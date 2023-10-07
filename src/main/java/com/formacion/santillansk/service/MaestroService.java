package com.formacion.santillansk.service;

import com.formacion.santillansk.entities.Alumno;
import com.formacion.santillansk.entities.Maestro;
import com.formacion.santillansk.repository.AlumnoRepository;
import com.formacion.santillansk.repository.MaestroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaestroService {
    @Autowired
    MaestroRepository maestroRepository;
    @Autowired
    AlumnoRepository alumnoRepository;

    //Métodos
    public List<Maestro> buscarMaestroNombre(String nombre) {
        return maestroRepository.findByNombreContaining(nombre);
    }

    public Integer countAlumnosByMaestro(Integer idMaestro) {
        Maestro maestro = maestroRepository.findById(idMaestro).orElse(null);
        List<Alumno> alumnosbyMaestro = alumnoRepository.findByMaestro(maestro);
        return alumnosbyMaestro.size();
    }

    //Consulta de maestro y sus respectivos alumnos
    public Maestro findByIdWithAlumnos(Integer idMaestro) {
        return maestroRepository.findByIdWithAlumnos(idMaestro);
    }

    //eliminacion logica
    public void deleteMaestro(Integer idMaestro) {
        Maestro maestro = maestroRepository.findById(idMaestro).orElse(null);
        if (maestro != null) {
            maestroRepository.deleteMaestro(maestro);
        }

    }


}
