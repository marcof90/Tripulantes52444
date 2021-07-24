import model.Curso;
import model.Tripulante;

public class App {
    public static void main(String[] args) {
        
        Curso programacion1 = new Curso(1234, "Fundamentos de programación", 'M', 7400, "Dev 1"); 
        System.out.println(programacion1.getNombre());

        try {
            System.out.println(programacion1.calcularPromedioCurso());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Tripulante t = new Tripulante();
        t.setNombre("primer tripulante");
        t.setNota1(4.4);
        t.setNota2(4.1);
        t.setNota3(4.5);
        Tripulante t2 = new Tripulante();
        t2.setNombre("2o tripulante");
        t2.setNota1(3.4);
        t2.setNota2(4.2);
        t2.setNota3(3.5);
        Tripulante t3 = new Tripulante();
        t3.setNombre("3o tripulante");
        t3.setNota1(4.2);
        t3.setNota2(4.2);
        t3.setNota3(5);
        Tripulante t5 = new Tripulante();
        t5.setNombre("5o tripulante");
        t5.setNota1(4.7);
        t5.setNota2(4.5);
        t5.setNota3(5);
        Tripulante t4 = new Tripulante();
        t4.setNombre("4o tripulante");
        t4.setNota1(4.9);
        t4.setNota2(4);
        t4.setNota3(4.5);
        System.out.println(programacion1.agregarTripulante(t));
        System.out.println(programacion1.agregarTripulante(t2));
        System.out.println(programacion1.agregarTripulante(t3));
        System.out.println(programacion1.agregarTripulante(t4));
        System.out.println(programacion1.agregarTripulante(t5));
        for (Tripulante desarrollador : programacion1.getTripulantes()) {
            System.out.println(desarrollador.getHighNote());
            System.out.println(desarrollador.getNombre());
        }
        // System.out.println(programacion1.calcularPromedioCurso());
    }
}
