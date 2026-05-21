package ec.edu.uce.aplication.service;

import ec.edu.uce.damain.model.Estudiante;
import ec.edu.uce.damain.repository.EstudianteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class EstudianteService {

    @Inject
    private EstudianteRepository estudianteRepository;

    //GUARDAR
    public void guardar(Estudiante estudiante){
        this.estudianteRepository.crear(estudiante);

    }

    // BUSCAR POR ID
    public Estudiante buscarPorId(Integer id){
        return this.estudianteRepository.seleccionarPorId(id);
    }

    // ACTUALIZAR
    @Transactional
    public void actualizar(Estudiante estudiante){
        this.estudianteRepository.actualizar(estudiante);
    }

    // ELIMINAR
    public void eliminar(Integer id){
        this.estudianteRepository.eliminar(id);
    }

    

}
