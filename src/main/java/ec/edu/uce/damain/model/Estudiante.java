package ec.edu.uce.damain.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

//reconoce la clase Estidiante como una entidad en la BD
@Entity
// mapea el nombre en la base de datos
@Table(name = "estudiante")

@NamedQueries({
    @NamedQuery(name="Estudiante.buscarPorGenero", query="SELECT e FROM Estudiante e WHERE e.genero = :genero"),
    @NamedQuery(name="Estudiante.buscarPorApellido", query="SELECT e FROM Estudiante e WHERE e.apellido = :apellido"),
    @NamedQuery(name="Estudiante.buscarRangoFecha", query="SELECT e FROM Estudiante e WHERE e.fechaNacimiento BETWEEN  :inicio AND : fin"),

    @NamedQuery(name="Estudiante.contar", query="SELECT COUNT(e) FROM Estudiante e")
})


public class Estudiante {

    @Id
    @SequenceGenerator(name = "seq_estudiante_generador", sequenceName = "seq_estudiante", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_estudiante_generador")

    // tener prefijo que identifique a la tabla :nomenclatura para idetificar en la
    // BD " @Column(name="estu_id")"
    @Column(name = "estu_id")
    private Integer id;

    @Column(name = "estu_nombre")
    private String nombre;

    @Column(name = "estu_apellido")
    private String apellido;

    @Column(name = "estu_fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @Column(name = "estu_genero")
    private String genero;

    @Column(name="estu_cedula")
    private String cedula;

    // GET Y SET
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

     public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    @Override
    public String toString() {
        return "Estudiante [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", fechaNacimiento="
                + fechaNacimiento + ", genero=" + genero + ", cedula=" + cedula + "]";
    }

    
}
