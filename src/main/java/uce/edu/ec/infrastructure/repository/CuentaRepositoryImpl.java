package uce.edu.ec.infrastructure.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import uce.edu.ec.domain.model.Cuenta;
import uce.edu.ec.domain.repository.CuentaRepository;

@ApplicationScoped
@Transactional
public class CuentaRepositoryImpl implements CuentaRepository{

    @Inject
    private EntityManager em;

    @Override
    public Cuenta buscarCuenta(Integer cuenta) {
        return this.em.find(Cuenta.class, cuenta);
    }

    @Override
    public void crearCuenta(Cuenta cuenta) {
        this.em.persist(cuenta);
        this.em.flush();
    }
    

}
