package uce.edu.ec;

import java.math.BigDecimal;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;
import uce.edu.ec.aplication.service.CuentaService;
import uce.edu.ec.aplication.service.TransferenciaService;
import uce.edu.ec.domain.model.Cuenta;

@QuarkusMain
public class Main {
    public static void main(String[] args) {
        Quarkus.run(App.class, args);
    }

    public static class App implements QuarkusApplication {

        @Inject
        private CuentaService cuentaService;

        @Inject
        private TransferenciaService transferenciaService;

        @Override
        public int run(String... args) throws Exception {

            System.out.println("Conexion a la base de datos!!!");

            Cuenta c1 = new Cuenta();
            c1.setNombre("Jhon Cordova");
            c1.setSaldo(new BigDecimal(200));
            c1.setNumeroCuenta(123.0);

            Cuenta c2 = new Cuenta();
            c2.setNombre("Andy Suquilandi");
            c2.setSaldo(new BigDecimal(400));
            c2.setNumeroCuenta(1234.0);

            // this.cuentaService.crearCuenta(c1);
            // this.cuentaService.crearCuenta(c2);

            // 1. Definir el monto de la transferencia
            BigDecimal montoATransferir = new BigDecimal("100.00");

            // 2. Pasar directamente las llaves primarias de la base de datos (1 y 2)
            this.transferenciaService.guardarTranferencia(1, 2, montoATransferir);

            System.out.println("¡Transferencia realizada con éxito!");

            return 0;
        }
    }

}
