package uce.edu.ec.domain.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="cuenta")
public class Cuenta {

    @Id
    @SequenceGenerator(name = "seq_cuenta_generador", sequenceName = "seq_cuenta", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cuenta_generador")

    @Column(name="cuen_id")
    private Integer id;
    @Column(name="cuen_nombre")
    private String nombre;
    @Column(name="cuen_numero_cuenta")
    private Double numeroCuenta;
    @Column(name="cuen_saldo")
    private BigDecimal saldo;

    
    //@OneToMany(mappedBy = "cuentaOrigen")
     //private List<Transferencia> transferenciasEnviadas;

    //@OneToMany(mappedBy = "cuentaDestino")
    //private List<Transferencia> transferenciasRecibidas;
        

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(Double numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /*
    public List<Transferencia> getTransferenciasEnviadas() {
        return transferenciasEnviadas;
    }

    public void setTransferenciasEnviadas(List<Transferencia> transferenciasEnviadas) {
        this.transferenciasEnviadas = transferenciasEnviadas;
    }

    public List<Transferencia> getTransferenciasRecibidas() {
        return transferenciasRecibidas;
    }

    public void setTransferenciasRecibidas(List<Transferencia> transferenciasRecibidas) {
        this.transferenciasRecibidas = transferenciasRecibidas;
    }
        */

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cuenta{");
        sb.append("id=").append(id);
        sb.append(", nombre=").append(nombre);
        sb.append(", numeroCuenta=").append(numeroCuenta);
        sb.append(", saldo=").append(saldo);
        sb.append('}');
        return sb.toString();
    }




}
