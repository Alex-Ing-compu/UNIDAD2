package uce.edu.ec.aplication.service;

import java.math.BigDecimal;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import uce.edu.ec.domain.repository.TransferenciaRepository;

@ApplicationScoped
public class TransferenciaService {

    @Inject
    private TransferenciaRepository transferenciaRepository;

    public void guardarTranferencia(Integer c1, Integer c2, BigDecimal monto){
        this.transferenciaRepository.hacerTranferencia(c1, c2, monto);
    }

}
