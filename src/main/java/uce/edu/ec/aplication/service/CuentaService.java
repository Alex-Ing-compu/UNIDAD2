package uce.edu.ec.aplication.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import uce.edu.ec.domain.model.Cuenta;
import uce.edu.ec.domain.repository.CuentaRepository;

@ApplicationScoped
public class CuentaService {

    @Inject
    private CuentaRepository cuentaRepository;

    public Cuenta buscarCuenta(Integer cuenta){
        return this.cuentaRepository.buscarCuenta(cuenta);
    }

    public void crearCuenta(Cuenta cuenta){
        this.cuentaRepository.crearCuenta(cuenta);
    }

}
