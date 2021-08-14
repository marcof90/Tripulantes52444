package view;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import java.awt.GridLayout;

public class PanelListaCursos extends JPanel{
    
    private JList<String> listaCursos;

    private Vista vistaPrincipal;

    public PanelListaCursos(Vista v) {
        super();
        setLayout(new GridLayout());
        setBorder(new TitledBorder("Lista cursos"));
        vistaPrincipal = v;

        listaCursos = new JList<>();

        add(listaCursos);
    }

    public void updateListaCursos(String[] listado) {
        listaCursos.setListData(listado);
    }
}
