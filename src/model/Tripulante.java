package model;

import java.util.ArrayList;

/**
 * Tripulante
 */
public class Tripulante {

    public final static double NOTA_MAXIMA = 5.0;

    /**
     * Atributos
     */
    private String nombre;
    private int id;
    private double nota1;
    private double nota2;
    private double nota3;
    private float numeroIdentificacion;
    private String email;

    private ArrayList<Curso> cursos;

    public Tripulante() {
        super();
    }

    public Tripulante(String pnombre, int pid, double pnota1, double pnota2, double pnota3, float pnumeroIdentificacion, String pemail) {
        super();
        this.nombre =  pnombre;
        this.id = pid;
        this.nota1 = pnota1;
        this.nota2 = pnota2;
        this.nota3 = pnota3;
        this.numeroIdentificacion = pnumeroIdentificacion;
        this.email = pemail;
        cursos = new ArrayList<>();
    }
    /** Getters */

    public ArrayList<Curso> getCursos() {
        return cursos;
    }

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    public double getNota1() {
        return nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public double getNota3() {
        return nota3;
    }

    public String getEmail() {
        return email;
    }

    public float getNumeroIdentificacion() {
        return numeroIdentificacion;
    }
    /** Setters */

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    public void setNota3(double nota3) {
        this.nota3 = nota3;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNumeroIdentificacion(float numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    
    public double getAverage() {
        return (nota1 + nota2 + nota3) / 3;
    }

    public double getHighNote() {
        double respuesta;

        if(nota1 >= nota2){
            if (nota1 >= nota3) {
                respuesta = nota1;
            }else{
                respuesta = nota3;
            }
        }else{
            if (nota2 >= nota3) {
                respuesta = nota2;
            }else{
                respuesta = nota3;
            }
        }
        return respuesta;

        // if (nota1 >= nota2 && nota1 >= nota3) {
        //     respuesta = nota1;
        // } else if(nota2 >= nota3){
        //     respuesta = nota2;
        // }else{
        //     respuesta = nota3;
        // }
        // return respuesta;

        // if (nota1 >= nota2 && nota1 >= nota3) {
        //     return nota1;
        // }

        // if (nota2 >= nota3) {
        //     return nota2;
        // }

        // return nota3;

        // if (nota1 >= nota2 && nota1 >= nota3) {
        //     return nota1;
        // } else if(nota2 >= nota3){
        //     return nota2;
        // }else{
        //     return nota3;
        // }
    }
    
    public double getLowNote(){
        if (nota1 <= nota2 && nota1 <= nota3) {
            return nota1;
        } else if(nota2 <= nota3){
            return nota2;
        }else{
            return nota3;
        }
    }

    public boolean checkIfPass(){
        if(getAverage() <= 3){
            return true;
        }
        return false;
    }
}