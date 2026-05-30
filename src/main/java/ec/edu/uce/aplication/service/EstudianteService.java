package ec.edu.uce.aplication.service;

import java.time.LocalDate;
import java.util.List;

import ec.edu.uce.damain.model.Estudiante;
import ec.edu.uce.damain.repository.EstudianteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class EstudianteService {

    @Inject
    private EstudianteRepository estudianteRepository;

    // GUARDAR
    public void guardar(Estudiante estudiante) {
        this.estudianteRepository.crear(estudiante);

    }

    // BUSCAR POR ID
    public Estudiante buscarPorId(Integer id) {
        return this.estudianteRepository.seleccionarPorId(id);
    }

    // ACTUALIZAR
    @Transactional
    public void actualizar(Estudiante estudiante) {
        this.estudianteRepository.actualizar(estudiante);
    }

    // ELIMINAR
    public void eliminar(Integer id) {
        this.estudianteRepository.eliminar(id);
    }

    // Selccionar
    public List<Estudiante> buscarTodos() {
        return this.estudianteRepository.seleccionarTodos();

    }

    //buscar por nombre
    public List<Estudiante> buscarPorNombre(String nombre) {
        return this.estudianteRepository.seleccionarPorNombre(nombre);
    }

    public Estudiante buscarPorCedula(String cedula){
        return this.estudianteRepository.seleccionarPorCedula(cedula);
    }

    //1.2 name query
    public List<Estudiante> seleccionarPorGenero(String genero){
        return this.estudianteRepository.seleccionarPorGenero(genero);
    }

    public List<Estudiante> seleccionarPorGeneroTyped(String genero){
        return this.estudianteRepository.seleccionarPorGeneroTyped(genero);
    }

    public List<Estudiante> seleccionaPorRangoFechas(LocalDate fechaInicion, LocalDate fehcaFin){
        return this.estudianteRepository.seleccionaPorRangoFechas(fechaInicion, fehcaFin);
    }

    public Long contar(){
        return this.estudianteRepository.contar();
    }
}
