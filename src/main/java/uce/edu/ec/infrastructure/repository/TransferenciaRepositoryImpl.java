package uce.edu.ec.infrastructure.repository;

import java.math.BigDecimal;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import uce.edu.ec.domain.model.Cuenta;
import uce.edu.ec.domain.model.Transferencia;
import uce.edu.ec.domain.repository.TransferenciaRepository;

@ApplicationScoped
@Transactional
public class TransferenciaRepositoryImpl implements TransferenciaRepository {

    @Inject
    private EntityManager em;

    @Override
    public void hacerTranferencia(Integer idCuentaOrigen, Integer idCuentaDestino, BigDecimal monto) {

        Cuenta origen = em.find(Cuenta.class, idCuentaOrigen);
        Cuenta destino = em.find(Cuenta.class, idCuentaDestino);

        if (origen == null || destino == null) {
            throw new RuntimeException("Cuenta no encontrada");
        }

        if (origen.getSaldo().compareTo(monto) < 0) {
            throw new RuntimeException("Saldo insuficiente");
        }

        origen.setSaldo(
                origen.getSaldo().subtract(monto));

        destino.setSaldo(
                destino.getSaldo().add(monto));

        Transferencia transferencia = new Transferencia();
        transferencia.setCuentaOrigen(origen);
        transferencia.setCuentaDestino(destino);
        transferencia.setMonto(monto);
        transferencia.setNombre("Transferencia Regular");

        em.persist(transferencia);
    }

}
