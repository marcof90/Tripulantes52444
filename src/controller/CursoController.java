package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Curso;
import services.JavaMySQL;

public class CursoController {
    
    private JavaMySQL serviceDB;
    private ArrayList<Curso> cursos;
    
    public CursoController() {
        super();
        cursos = new ArrayList<>();
        serviceDB = new JavaMySQL();        
        fillCursosData();
    }    

    public ArrayList<Curso> getCursos() {
        return cursos;
    }

    public void addCurso(int pCodigo, String pNombre, char pJornada) {
        serviceDB.insertCurso(pNombre, pCodigo, pJornada);
        Curso c = new Curso(pCodigo, pNombre, pJornada);
        cursos.add(c);
    }

    public String listCursos() {
        String lista = "";
        for (Curso curso : cursos) {
            lista += curso + "\n"; // \n es un enter
        }
        return lista;
    }

    public String[] listCursosData() {
        String[] listData = new String[cursos.size()];
        for (int i = 0; i < listData.length; i++) {
           listData[i] = cursos.get(i).toString();
        }
        return listData;
    }

    public void fillCursosData() {
        cursos.clear();
        ResultSet rs = serviceDB.getCursosDB();
        try {
            while (rs.next()) {
                Curso curso = new Curso(rs.getInt("codigo"), rs.getString("nombre"), 
                rs.getString("jornada").charAt(0));
                cursos.add(curso);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
