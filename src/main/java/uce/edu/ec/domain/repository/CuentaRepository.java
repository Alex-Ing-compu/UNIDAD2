package uce.edu.ec.domain.repository;

import uce.edu.ec.domain.model.Cuenta;

public interface CuentaRepository {

    public void crearCuenta(Cuenta cuenta);

    public Cuenta buscarCuenta(Integer cuenta);

}
