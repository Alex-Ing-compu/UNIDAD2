package ec.edu.uce.infrastructure;

import ec.edu.uce.damain.model.Profesor;
import ec.edu.uce.damain.repository.ProfesorRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class ProfesorRepositoryImpl implements ProfesorRepository{

    @Inject
    private EntityManager em;
    
    @Override
    public void crear(Profesor profesor) {
        this.em.persist(profesor);
    }

    @Override
    public Profesor seleccionarPorId(Integer id) {
        return this.em.find(Profesor.class, id);
    }

    @Override
    public void actualizar(Profesor profesor) {
        this.em.merge(profesor);
    }

    @Override
    public void eliminar(Integer id) {
        // Buscamos primero para asegurarnos de que esté en el
        // contexto de persistencia antes de borrar
        this.em.remove(this.seleccionarPorId(id));
    }

}
