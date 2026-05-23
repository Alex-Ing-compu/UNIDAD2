package ec.edu.uce.damain.repository;

import ec.edu.uce.damain.model.Profesor;

public interface ProfesorRepository {

    void crear(Profesor profesor);

    Profesor seleccionarPorId(Integer id);

    void actualizar(Profesor profesor);

    void eliminar(Integer id);
}
