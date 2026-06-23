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

    


}
