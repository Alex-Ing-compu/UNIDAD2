package ec.edu.uce.aplication.service;

import java.math.BigDecimal;
import java.util.List;

import ec.edu.uce.damain.model.Profesor;
import ec.edu.uce.damain.repository.ProfesorRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ProfesorService {

    @Inject
    private ProfesorRepository profesorRepository;

    public void guardar(Profesor profesor) {
        this.profesorRepository.crear(profesor);
    }

    public Profesor buscarPorId(Integer id) {
        return this.profesorRepository.seleccionarPorId(id);
    }

    public void actualizar(Profesor profesor) {
        this.profesorRepository.actualizar(profesor);
    }

    public void eliminar(Integer id) {
        this.profesorRepository.eliminar(id);
    }

    // metodos del profesor

    // 1. Seleccionar todos los profesores
    public List<Profesor> buscarTodos() {
        return this.profesorRepository.seleccionarTodos();
    }

    // 2. Buscar por correo único
    public Profesor buscarPorCorreo(String correo) {
        return this.profesorRepository.seleccionarPorCorreo(correo);
    }

    // 3. Buscar por especialidad (ej: "Civil", "Sistemas")
    public List<Profesor> buscarPorEspecialidad(String especialidad) {
        return this.profesorRepository.seleccionarPorEspecialidad(especialidad);
    }

    // 4. Buscar profesores en un rango de sueldos
    public List<Profesor> buscarPorRangoSalarial(BigDecimal min, BigDecimal max) {
        return this.profesorRepository.seleccionarPorRangoSalarial(min, max);
    }

    // 5. Buscar profesores por país
    public List<Profesor> buscarPorPais(String pais) {
        return this.profesorRepository.seleccionarPorPais(pais);
    }

    // 6. Buscar solo profesores activos (estado = true)
    public List<Profesor> buscarSoloActivos() {
        return this.profesorRepository.seleccionarActivos();
    }

    // 7. Buscar por coincidencia parcial en el apellido (LIKE %texto%)
    public List<Profesor> buscarPorAproximacionApellido(String texto) {
        return this.profesorRepository.seleccionarPorApellidoLike(texto);
    }

    // 8. Buscar por dominio de correo (LIKE %dominio)
    public List<Profesor> buscarPorDominioCorreo(String dominio) {
        return this.profesorRepository.seleccionarPorDominioCorreo(dominio);
    }

    // NamedQuery
    public List<Profesor> seleccionarPorGenero(String genero) {
        return this.profesorRepository.seleccionarPorGenero(genero);
    }

    public List<Profesor> seleccionarPorGeneroTyped(String genero) {
        return this.profesorRepository.seleccionarPorGeneroTyped(genero);
    }

    public List<Profesor> seleccionarPorPaisNamed(String pais) {
        return this.profesorRepository.seleccionarPorPaisNamed(pais);
    }

    public Long contar() {
        return this.profesorRepository.contar();
    }

    // NativeQuery
    public List<Profesor> buscarPorPaisNative(String pais) {
        return this.profesorRepository.seleccionarPorPaisNative(pais);
    }

    public List<Profesor> buscarActivosNative() {
        return this.profesorRepository.seleccionarActivosNative();
    }

    public List<Profesor> buscarPorEspecialidadNative(String especialidad) {
        return this.profesorRepository.seleccionarPorEspecialidadNative(especialidad);
    }

}
