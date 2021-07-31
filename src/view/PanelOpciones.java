package view;

import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;

public class PanelOpciones extends JPanel implements ActionListener{
    
    public final static String OPCION_1 = "Ver mejor promedio";
    public static final String BTN_ADD_CURSO = "Agregar Curso";
    //creamos la relacion
    private JButton opcion1;
    private JButton btnAddCurso;

    private Vista vistaPrincipal;

    public PanelOpciones(Vista v) {
        super();
        setLayout(new GridLayout(1, 3));

        vistaPrincipal = v;

        //inicializar el boton
        opcion1 = new JButton(OPCION_1);
        btnAddCurso = new JButton(BTN_ADD_CURSO);
        //modificar las propiedades
        opcion1.setActionCommand(OPCION_1);
        btnAddCurso.setActionCommand(BTN_ADD_CURSO);

        opcion1.addActionListener(this);
        btnAddCurso.addActionListener(this);
        //agregar
        add(opcion1);
        add(btnAddCurso);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getActionCommand().equals(OPCION_1)){
            System.out.println("hola");
        }else if(e.getActionCommand().equals(BTN_ADD_CURSO)){
            System.out.println("Agregar un curso");
        }
    }

}
