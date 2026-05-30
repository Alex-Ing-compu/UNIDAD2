package ec.edu.uce.damain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="profesor")
public class Profesor {

    @Id
    @SequenceGenerator(name="seq_profesor_generador",sequenceName="seq_profesor",allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_profesor_generador")

    @Column(name="prof_id")
    private Integer id;

    @Column(name="prof_nombre")
    private String nombre;

    @Column(name="prof_apellido")
    private String apellido;

    @Column(name="prof_especialidad")
    private String especialidad;

    @Column(name="prof_correo")
    private String correo;


    @Column(name="prof_cuidad")
    private String ciudad;
    @Column(name="prof_pais")
    private String pais;
    @Column(name="prof_genero")
    private String genero;
    @Column(name="prof_estado")
    private boolean estado;    


    //getter and setters
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
    public String getEspecialidad() {
        return especialidad;
    }
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }



    public String getCiudad() {
        return ciudad;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    public String getPais() {
        return pais;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public boolean isEstado() {
        return estado;
    }
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Profesor [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", especialidad=" + especialidad
                + ", correo=" + correo + ", ciudad=" + ciudad + ", pais=" + pais + ", genero=" + genero + ", estado="
                + estado + "]";
    }


}
