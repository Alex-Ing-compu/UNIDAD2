package ec.edu.uce.infrastructure.repository;

import java.time.LocalDate;
import java.util.List;

import ec.edu.uce.damain.model.Estudiante;
import ec.edu.uce.damain.repository.EstudianteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
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


    //1.1 TypeQuery
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

    //1.2 Name Query    

    @Override
    public List<Estudiante> seleccionarPorGenero(String genero) {
       Query myQuery = this.em.createNamedQuery("Estudiante.buscarPorGenero");
       myQuery.setParameter("genero", genero);
       return myQuery.getResultList();
    }

    @Override
    public List<Estudiante> seleccionarPorGeneroTyped(String genero) {
       TypedQuery<Estudiante> myQuery = this.em.createNamedQuery("Estudiante.buscarPorGenero", Estudiante.class);
       myQuery.setParameter("genero", genero);
       return myQuery.getResultList();
    }


    @Override
    public List<Estudiante> seleccionaPorRangoFechas(LocalDate fechaInicio, LocalDate fechaFin) {
        TypedQuery<Estudiante> myQuery = this.em.createNamedQuery("Estudiante.buscarRangoFecha", Estudiante.class);
        myQuery.setParameter("inicio", fechaInicio);
        myQuery.setParameter("fin", fechaFin);
        return myQuery.getResultList();
    }

    @Override
    public Long contar() {
        TypedQuery<Long> myQuery = this.em.createNamedQuery("Estudiante.contar", Long.class);
        return myQuery.getSingleResult();
    }


    


    




    
}
