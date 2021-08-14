package view;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.GridLayout;

public class PanelListaCursos extends JPanel implements ListSelectionListener{
    
    private int activeCurso;

    private JList<String> listaCursos;

    private Vista vistaPrincipal;

    public PanelListaCursos(Vista v) {
        super();
        setLayout(new GridLayout());
        setBorder(new TitledBorder("Lista cursos"));
        vistaPrincipal = v;
        activeCurso = -1;
        listaCursos = new JList<>();
        listaCursos.addListSelectionListener(this);

        add(listaCursos);
    }

    public int getActiveCurso() {
        return activeCurso;
    }

    public void setActiveCurso(int activeCurso) {
        this.activeCurso = activeCurso;
    }

    public void updateListaCursos(String[] listado) {
        listaCursos.setListData(listado);
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            activeCurso = listaCursos.getSelectedIndex();
            vistaPrincipal.updateInformationCurso();
        }
    }
}
