package uce.edu.ec.domain.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="transferencia")
public class Transferencia {

    @Id
    @SequenceGenerator(name = "seq_transferencia_generador", sequenceName = "seq_transferencia", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_transferencia_generador")

    @Column(name="tran_id")
    private Integer id;
    @Column(name="tran_nombre")
    private String nombre;
    @Column(name="tran_saldo")
    private BigDecimal monto;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    @ManyToOne
    @JoinColumn(name = "tran_cuenta_origen")
    private Cuenta cuentaOrigen;
 
    @ManyToOne
    @JoinColumn(name = "tran_cuenta_destino")
    private Cuenta cuentaDestino;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    
    public Cuenta getCuentaOrigen() {
        return cuentaOrigen;
    }

    public void setCuentaOrigen(Cuenta cuentaOrigen) {
        this.cuentaOrigen = cuentaOrigen;
    }

    public Cuenta getCuentaDestino() {
        return cuentaDestino;
    }

    public void setCuentaDestino(Cuenta cuentaDestino) {
        this.cuentaDestino = cuentaDestino;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Transferencia{");
        sb.append("id=").append(id);
        sb.append(", nombre=").append(nombre);
        sb.append(", monto=").append(monto);
        sb.append(", cuentaOrigen=").append(cuentaOrigen);
        sb.append(", cuentaDestino=").append(cuentaDestino);
        sb.append('}');
        return sb.toString();
    }



}
