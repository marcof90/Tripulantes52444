package model;

import java.util.ArrayList;

public class Curso {

    public static final int MAXIMO_TRIPULANTES = 5;

    private int codigo;
    private String nombre;
    private char jornada;

    private Formador formador;

    private ArrayList<Tripulante> tripulantes;

    public Curso(int pCodigo, String pNombre, char pJornada, int fCodigo, String fNombre) {
        super();
        this.codigo = pCodigo;
        this.nombre = pNombre;
        this.jornada = pJornada;
        formador = new Formador(fNombre, fCodigo);
        tripulantes = new ArrayList<>();
    }

    public Curso(int pCodigo, String pNombre, char pJornada) {
        super();
        this.codigo = pCodigo;
        this.nombre = pNombre;
        this.jornada = pJornada;
        formador = null;
        tripulantes = new ArrayList<>();
    }
    
    public ArrayList<Tripulante> getTripulantes() {
        return tripulantes;
    }
    
    public int getCodigo() {
        return codigo;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public char getJornada() {
        return jornada;
    }
    
    public Formador getFormador() {
        return formador;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String agregarTripulante(Tripulante t){
        if(tripulantes.size() == MAXIMO_TRIPULANTES){
            return "No se puede agregar más de " + MAXIMO_TRIPULANTES + " Tripulantes";            
        }
        tripulantes.add(t);
        return "Tripulante agregado al curso " + nombre;
    }

    public double calcularPromedioCurso() throws Exception {
        if(tripulantes.size()==0){
            throw new Exception("No hay tripulantes registados en el curso");
        }
        double total = 0.0;
        for (Tripulante tripulante : tripulantes) {
            total += tripulante.getAverage();
        }
        // for (int i = 0; i < tripulantes.size(); i++) {
        //     total += tripulantes.get(i).getAverage();
        // }
        return total/tripulantes.size();
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Nombre: "+ nombre + ", Codigo: "+ codigo;
    }

}
