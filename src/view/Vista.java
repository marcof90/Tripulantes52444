package view;

import model.Curso;
import model.Formador;

public class Vista {
    

    public static void main(String[] args) {
        Curso cursoFrances = new Curso(52441, "Frances 101", 'N', 7400, "Guillaume");
        Curso cursoItaliano = new Curso(52442, "Italiano 102", 'T', 7401, "Vladimir Putin");
        
        Formador profesor = new Formador("Carlitos", 321654);
        System.out.println(profesor.getCodigo());

        System.out.println(cursoFrances.getFormador().getNombre());
        System.out.println(cursoFrances.getFormador().getCodigo());
        System.out.println(cursoItaliano.getFormador().getNombre());
        System.out.println(cursoItaliano.getFormador().getCodigo());
        
        
        // System.out.println(cursoFrances.getCodigo());
        // System.out.println(cursoFrances.getJornada());
        // System.out.println(cursoFrances.getNombre());

        // System.out.println(cursoFrances.getFormador());
    }
    
}



