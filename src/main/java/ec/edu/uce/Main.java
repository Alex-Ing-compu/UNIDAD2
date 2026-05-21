package ec.edu.uce;

import java.time.LocalDate;

import ec.edu.uce.aplication.service.EstudianteService;
import ec.edu.uce.damain.model.Estudiante;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;

@QuarkusMain
public class Main {
    public static void main(String[] args) {
        Quarkus.run(App.class, args);
    }
 
    public static class App implements QuarkusApplication   {

        @Inject
            private EstudianteService estudianteService;




        @Override
        public int run(String... args) throws Exception {

    
            System.out.println("Conexion a la base de datos POSTGRESQL!!");

            Estudiante estudiante = new Estudiante();
            estudiante.setNombre("Pedro");
            estudiante.setApellido("Perez");
            estudiante.setFechaNacimiento(LocalDate.of(2005, 01, 10));
            estudiante.setGenero("M");
            
            //Guardar
            this.estudianteService.guardar(estudiante);

            //Actualizar
           // Estudiante estudiante2 = this.estudianteService.buscarPorId(4);
           // estudiante2.setNombre("PAULLLLLLLLLL");
           // estudiante2.setApellido("LLUMI");

           // this.estudianteService.actualizar(estudiante2);

            //Eliminar
            //this.estudianteService.eliminar(2);

            //Bucascar porm ID
            System.out.println(this.estudianteService.buscarPorId(1).toString());
            //this.estudianteService.buscarPorId(1);

            return 0;
        }
   
       
    }
}