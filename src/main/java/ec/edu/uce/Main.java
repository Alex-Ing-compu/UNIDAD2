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

            /*
             List<Estudiante> lista = estudianteService.buscarPorNombre("Jhon");

            for (Estudiante e : lista) {
                System.out.println(e);
            }

            String cedula = "1001234564";
            Estudiante estu = this.estudianteService.buscarPorCedula(cedula);
            System.out.println("Econtrado:"+estu);
            */


            // CREAR PROFESOR
            Profesor profe = new Profesor();
            profe.setApellido("Escola");
            profe.setCorreo("anthony@uce.edu.ec");
            profe.setEspecialidad("Civil");
            profe.setNombre("Anthony");
            profe.setCiudad("Londres");
            profe.setEstado(true);
            profe.setGenero("M");
            profe.setPais("Inglaterra");

            /*


            this.profesorService.actualizar(profe);

            //CONSULTAS  
            System.out.println("BUSCAR POR ESPECIALIDAD");
            List<Profesor> porEspecialidad = this.profesorService.buscarPorEspecialidad("Derecho");
            for (Profesor p : porEspecialidad) {
                System.out.println(p);
            }

            System.out.println("BUSCAR POR APROXIMACION DE APELLIDO");
            List<Profesor> porApellido = this.profesorService.buscarPorAproximacionApellido("cola");
            for (Profesor p : porApellido) {
                System.out.println(p);
            }

            System.out.println("BUSCAR POR DOMINIO");
            List<Profesor> porDominio = this.profesorService.buscarPorDominioCorreo("@uce.edu.ec");
            for (Profesor p : porDominio) {
                System.out.println(p);
            }

            System.out.println("BUSCAR TODOS LOS QUE ESTAN ACTIVOS");
            List<Profesor> activosEcuador = this.profesorService.buscarSoloActivos();
            for (Profesor p : activosEcuador) {
                System.out.println(p);
            }

            System.out.println("BUSCAR POR PAIS");
            List<Profesor> bucarPorPais = this.profesorService.buscarPorPais("Ecuador");
            for (Profesor p : bucarPorPais) {
                System.out.println(p);
            }

             */

            System.out.println("Normallllllllll");
            List<Estudiante> buscarPorGenero = this.estudianteService.seleccionarPorGenero("M");
            for (Estudiante elem : buscarPorGenero) {
                System.out.println(elem);
            }

            System.out.println("typedddddddddddddddddddd");

            List<Estudiante> buscarPorGeneroTyped = this.estudianteService.seleccionarPorGeneroTyped("M");
            for (Estudiante elem : buscarPorGeneroTyped) {
                System.out.println(elem);
            }


            System.out.println("Fechaaaaaaaa");
            List<Estudiante> selecccionarPorFecha = this.estudianteService.seleccionaPorRangoFechas(LocalDate.of(2002, 01, 1), LocalDate.of(2003, 02, 25));
            for(Estudiante e: selecccionarPorFecha){
                System.out.println(e);

            }
            System.out.println("CONTAR");
            Long contar = estudianteService.contar();
            System.out.println("Total de estudiantes:"+ contar);

            //NATIVE QUERYYY
            System.out.println("NATIVE QUEY");
            List<Estudiante> nativeEstu = this.estudianteService.seleccionarTodosNative();
            for(Estudiante e: nativeEstu){
                System.out.println(e);
            }







            return 0;
        }

    }
}