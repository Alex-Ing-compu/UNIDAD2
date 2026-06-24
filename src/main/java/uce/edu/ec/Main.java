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

            Cuenta c4 = new Cuenta();
            c4.setNombre("Pedro Cueva");
            c4.setSaldo(new BigDecimal(1200));
            c4.setNumeroCuenta(12345.0);

            this.cuentaService.crearCuenta(c4);
            // this.cuentaService.crearCuenta(c1);
            // this.cuentaService.crearCuenta(c2);
            // this.cuentaService.crearCuenta(c3);
            
            //-----------------------------------
           
            BigDecimal montoATransferir = new BigDecimal("100.00");
            this.transferenciaService.guardarTranferencia(4, 5, montoATransferir);  
            System.out.println("Transferencia realizada con éxito!");
             
             

            return 0;
        }
    }

}
