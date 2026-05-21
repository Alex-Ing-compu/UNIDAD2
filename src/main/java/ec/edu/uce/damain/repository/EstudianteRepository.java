package ec.edu.uce.damain.repository;

import ec.edu.uce.damain.model.Estudiante;

public interface EstudianteRepository {

    //implemento los metodos que se va a necesitad 
    public void crear(Estudiante estudiante);
    public Estudiante seleccionarPorId(Integer id);

    public void actualizar (Estudiante estudiante);
    public void eliminar(Integer id);


}
