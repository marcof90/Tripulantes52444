package controller;

import java.util.ArrayList;

import model.Curso;

public class CursoController {
    
    private ArrayList<Curso> cursos;
    
    public CursoController() {
        super();
        cursos = new ArrayList<>();
    }    

    public ArrayList<Curso> getCursos() {
        return cursos;
    }

    public void addCurso(int pCodigo, String pNombre, char pJornada) {
        Curso c = new Curso(pCodigo, pNombre, pJornada);
        cursos.add(c);
    }

}
