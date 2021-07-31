package view;

import javax.swing.JButton;
import javax.swing.JOptionPane;
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

    private void addCurso() {
        String[] options = new String[3];
        options[0] = "Mañana";
        options[1] = "Tarde";
        options[2] = "Noche";
        char[] optionsShort = new char[3];
        optionsShort[0] = 'M';
        optionsShort[1] = 'T';
        optionsShort[2] = 'N';
        String nombre = JOptionPane.showInputDialog(vistaPrincipal, "Digita el nombre del curso");        
        String codigo = JOptionPane.showInputDialog(vistaPrincipal, "Digita el codigo del curso");
        int option = JOptionPane.showOptionDialog(vistaPrincipal, "Escoge una opción", "Jornada del curso", 
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, null);
        if(nombre!=null && !nombre.equals("") && option != -1 && codigo != ""){            
            vistaPrincipal.addCurso(Integer.parseInt(codigo), nombre, optionsShort[option]);
        }
        else{
            JOptionPane.showMessageDialog(vistaPrincipal, "Ups! Revisa los datos", 
                                "Error en los datos", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void listCursos(){
        JOptionPane.showMessageDialog(vistaPrincipal, vistaPrincipal.listCursos(), "Lista de cursos", JOptionPane.PLAIN_MESSAGE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getActionCommand().equals(OPCION_1)){
            listCursos();
            // System.out.println("hola");
        }else if(e.getActionCommand().equals(BTN_ADD_CURSO)){
            addCurso();
            // System.out.println("Agregar un curso");
        }
    }

}
