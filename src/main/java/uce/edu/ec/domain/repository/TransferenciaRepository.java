package uce.edu.ec.domain.repository;

import java.math.BigDecimal;

public interface TransferenciaRepository {

    public void hacerTranferencia(Integer idCuentaOrigen, Integer idCuentaDestino, BigDecimal monto);
}
