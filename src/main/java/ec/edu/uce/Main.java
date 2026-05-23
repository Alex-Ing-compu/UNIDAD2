package ec.edu.uce;

import java.time.LocalDate;
import java.util.List;

import ec.edu.uce.aplication.service.EstudianteService;
import ec.edu.uce.aplication.service.ProfesorService;
import ec.edu.uce.damain.model.Estudiante;
import ec.edu.uce.damain.model.Profesor;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;

@QuarkusMain
public class Main {
    public static void main(String[] args) {
        Quarkus.run(App.class, args);
    }

    public static class App implements QuarkusApplication {

        @Inject
        private EstudianteService estudianteService;

        @Inject
        private ProfesorService profesorService;

        @Override
        public int run(String... args) throws Exception {

            System.out.println("Conexion a la base de datos POSTGRESQL!!");

            // CREAR ESTUDIANTE
            Estudiante estudiante = new Estudiante();
            estudiante.setNombre("Jhon");
            estudiante.setApellido("Cordova");
            estudiante.setFechaNacimiento(LocalDate.of(2003, 06, 10));
            estudiante.setGenero("M");

            // CREAR PROFESOR
            Profesor profe = new Profesor();
            profe.setNombre("Andy");
            profe.setApellido("Suquilandy");
            profe.setEspecialidad("Civil");
            profe.setCorreo("andy@uce.edu.ec");

            // Guardar
          //  this.estudianteService.guardar(estudiante);

            // Guardar
          //  this.profesorService.guardar(profe);

            // Bucasr profe por ID
           // System.out.println(this.profesorService.buscarPorId(2).toString());

            // Actualizar
            // Estudiante estudiante2 = this.estudianteService.buscarPorId(4);
            // estudiante2.setNombre("PAULLLLLLLLLL");
            // estudiante2.setApellido("LLUMI");

            // this.estudianteService.actualizar(estudiante2);

            // Eliminar
            // this.estudianteService.eliminar(2);

            // Bucascar porm ID
            // System.out.println(this.estudianteService.buscarPorId(1).toString());
            // this.estudianteService.buscarPorId(1);

            // ---------------------------
            /*
            List<Estudiante> lista = estudianteService.buscarTodos();

            for (Estudiante e : lista) {
                System.out.println(e);
            }
               */

             List<Estudiante> lista = estudianteService.buscarPorNombre("Jhon");

            for (Estudiante e : lista) {
                System.out.println(e);
            }

            String cedula = "1001234564";
            Estudiante estu = this.estudianteService.buscarPorCedula(cedula);
            System.out.println("Econtrado:"+estu);

            return 0;
        }

    }
}