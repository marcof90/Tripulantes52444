package model;

public class Curso {
    private int codigo;
    private String nombre;
    private char jornada;

    private Formador formador;

    public Curso(int pCodigo, String pNombre, char pJornada, int fCodigo, String fNombre) {
        super();
        this.codigo = pCodigo;
        this.nombre = pNombre;
        this.jornada = pJornada;
        formador = new Formador(fNombre, fCodigo);
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

}
