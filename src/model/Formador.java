package model;

public class Formador {
    private String nombre;
    private int codigo;

    public Formador(String nombre, int codigo) {
        super();
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public Formador() {
        super();
        this.codigo = 0;
        this.nombre = "Jon Doe";
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
