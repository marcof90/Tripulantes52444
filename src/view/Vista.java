package view;

import javax.swing.JFrame;

import controller.CursoController;

import java.awt.BorderLayout;

public class Vista extends JFrame{

    private PanelOpciones panelOpc;
    
    private CursoController cursoController;

    public Vista() {
        super();
        setSize(600, 400);
        setTitle("Tripulantes");
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setLayout(new BorderLayout());

        cursoController = new CursoController();

        panelOpc = new PanelOpciones(this);

        add(panelOpc, BorderLayout.SOUTH);
    }
        
    public void addCurso(int pCodigo, String pNombre, char pJornada) {
        cursoController.addCurso(pCodigo, pNombre, pJornada);
    }

    public String listCursos() {
        return cursoController.listCursos();
    }
}
