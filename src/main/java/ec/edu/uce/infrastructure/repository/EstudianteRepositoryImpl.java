package ec.edu.uce.infrastructure.repository;

import java.util.List;

import ec.edu.uce.damain.model.Estudiante;
import ec.edu.uce.damain.repository.EstudianteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class EstudianteRepositoryImpl implements EstudianteRepository{

    //esta clase nos prpporciona el framework
    //no tenemos que crearla nosotros, solo inyectarla
    @Inject
    private EntityManager em;

    @Override
    public void crear(Estudiante estudiante) {
        this.em.persist(estudiante);
    }

    @Override
    public Estudiante seleccionarPorId(Integer id) {
       return this.em.find(Estudiante.class, id);
    }

    @Override
    public void actualizar(Estudiante estudiante) {
        //cuando hago un merge si o si debe tener un dato primario un id
        //a patir de ese id hace la actulizacion 
        this.em.merge(estudiante);
    }

    @Override
    public void eliminar(Integer id) {
        this.em.remove(this.seleccionarPorId(id));
    }

    @Override
    public List<Estudiante> seleccionarTodos() {
        TypedQuery<Estudiante> miQuery = this.em.createQuery("SELECT e FROM Estudiante e",Estudiante.class);
        return miQuery.getResultList();
    }

    @Override
    public List<Estudiante> seleccionarPorNombre(String nombre) {
        TypedQuery<Estudiante> miQuery = this.em.createQuery("SELECT e FROM Estudiante e WHERE e.nombre = :nombre1 ", Estudiante.class);
        miQuery.setParameter("nombre1", nombre);
        return miQuery.getResultList();
    }

    @Override
    public Estudiante seleccionarPorCedula(String cedula) {
        TypedQuery<Estudiante> miQuery = this.em.createQuery("SELECT e FROM Estudiante  e WHERE e.cedula = :cedula",Estudiante.class);
        miQuery.setParameter("cedula", cedula);

        //solo retornara un solo registro unico
        //return miQuery.getSingleResult();
        //return miQuery.getResultList().get(0);
        
         return miQuery.getResultList().getFirst();
    }

 

    


    
}
