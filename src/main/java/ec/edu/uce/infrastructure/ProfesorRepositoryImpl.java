package ec.edu.uce.infrastructure;

import java.math.BigDecimal;
import java.util.List;

import ec.edu.uce.damain.model.Profesor;
import ec.edu.uce.damain.repository.ProfesorRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class ProfesorRepositoryImpl implements ProfesorRepository {

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

    @Override
    public List<Profesor> seleccionarTodos() {
        TypedQuery<Profesor> miQuery = this.em.createQuery("SELECT p FROM Profesor p", Profesor.class);
        return miQuery.getResultList();
    }

    @Override
    public Profesor seleccionarPorCorreo(String correo) {
        TypedQuery<Profesor> miQuery = this.em.createQuery("SELECT p FROM Profesor p WHERE p.correo = :correo",
                Profesor.class);
        miQuery.setParameter("correo", correo);
        return miQuery.getResultList().getFirst();
    }

    @Override
    public List<Profesor> seleccionarPorEspecialidad(String especialidad) {
        TypedQuery<Profesor> miQuery = this.em.createQuery("SELECT p FROM Profesor p WHERE p.especialidad = :esp",
                Profesor.class);
        miQuery.setParameter("esp", especialidad);
        return miQuery.getResultList();
    }

    @Override
    public List<Profesor> seleccionarPorRangoSalarial(BigDecimal min, BigDecimal max) {
        TypedQuery<Profesor> miQuery = this.em
                .createQuery("SELECT p FROM Profesor p WHERE p.salario BETWEEN :min AND :max", Profesor.class);
        miQuery.setParameter("min", min);
        miQuery.setParameter("max", max);
        return miQuery.getResultList();
    }

    @Override
    public List<Profesor> seleccionarPorPais(String pais) {
        TypedQuery<Profesor> miQuery = this.em.createQuery("SELECT p FROM Profesor p WHERE p.pais = :pais",
                Profesor.class);
        miQuery.setParameter("pais", pais);
        return miQuery.getResultList();
    }

    @Override
    public List<Profesor> seleccionarActivos() {
        // Filtra donde p.estado sea igual a true
        TypedQuery<Profesor> miQuery = this.em.createQuery("SELECT p FROM Profesor p WHERE p.estado = true",
                Profesor.class);
        return miQuery.getResultList();
    }

    @Override
    public List<Profesor> seleccionarPorApellidoLike(String texto) {
        // Busca cualquier apellido que CONTENGA el texto ingresado
        TypedQuery<Profesor> miQuery = this.em.createQuery(
                "SELECT p FROM Profesor p WHERE p.apellido LIKE :texto", Profesor.class);
        // Concatenamos % al principio y al final para buscar coincidencias en cualquier
        // parte del texto
        miQuery.setParameter("texto", "%" + texto + "%");
        return miQuery.getResultList();
    }

    @Override
    public List<Profesor> seleccionarPorDominioCorreo(String dominio) {
        // Busca correos que TERMINEN con un dominio específico (ej: "@uce.edu.ec")
        TypedQuery<Profesor> miQuery = this.em.createQuery(
                "SELECT p FROM Profesor p WHERE p.correo LIKE :dominio", Profesor.class);
        // Concatenamos % solo al principio
        miQuery.setParameter("dominio", "%" + dominio);
        return miQuery.getResultList();
    }

    // NamedQuery

    @Override
    public List<Profesor> seleccionarPorGenero(String genero) {
        Query myQuery = this.em.createNamedQuery("Profesor.buscarPorGenero");
        myQuery.setParameter("genero", genero);
        return myQuery.getResultList();
    }

    public List<Profesor> seleccionarPorGeneroTyped(String genero) {
        TypedQuery<Profesor> myQuery = this.em.createNamedQuery("Profesor.buscarPorGenero", Profesor.class);
        myQuery.setParameter("genero", genero);
        return myQuery.getResultList();
    }

    @Override
    public List<Profesor> seleccionarPorPaisNamed(String pais) {
        TypedQuery<Profesor> myQuery = this.em.createNamedQuery("Profesor.buscarPorPais", Profesor.class);
        myQuery.setParameter("pais", pais);
        return myQuery.getResultList();
    }

    @Override
    public Long contar() {
        TypedQuery<Long> myQuery = this.em.createNamedQuery("Profesor.contar", Long.class);

        return myQuery.getSingleResult();
    }

    // NativeQuery
    @Override
    @SuppressWarnings("unchecked")
    public List<Profesor> seleccionarPorPaisNative(String pais) {
        Query myQuery = this.em.createNativeQuery("SELECT * FROM profesor WHERE prof_pais = ?", Profesor.class);
        myQuery.setParameter(1, pais);
        return myQuery.getResultList();

    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Profesor> seleccionarActivosNative() {
        Query myQuery = this.em.createNativeQuery("SELECT * FROM profesor WHERE prof_estado = true", Profesor.class);
        return myQuery.getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Profesor> seleccionarPorEspecialidadNative(String especialidad) {
        Query myQuery = this.em.createNativeQuery("SELECT * FROM profesor WHERE prof_especialidad = ?", Profesor.class);
        myQuery.setParameter(1, especialidad);
        return myQuery.getResultList();
    }

}
