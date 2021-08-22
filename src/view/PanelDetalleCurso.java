package view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import model.Curso;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelDetalleCurso extends JPanel implements ActionListener{
    
    private JLabel lblNombre;
    private JLabel lblCodigo;
    private JLabel lblJornada;
    private JLabel lblTripulantes;
    private JButton btnEditar;
    
    private String nombre;
    private int codigo;
    private char jornada;

    private VistaEdicionCurso vistaEdicionCurso;
    private Vista vistaPrincipal;

    public PanelDetalleCurso(Vista v) {
        super();
        setLayout(new GridLayout(5, 1 ));
        setBorder(new TitledBorder("Detalle Curso"));
        vistaPrincipal = v;
        vistaEdicionCurso = new VistaEdicionCurso(this);

        nombre = null;
        codigo = 0;
        jornada = '0';

        lblNombre = new JLabel("Nombre:");
        lblCodigo = new JLabel("Código:");
        lblJornada = new JLabel("Jornada:");
        lblTripulantes = new JLabel("Tripulantes:");
        btnEditar = new JButton("Editar");
        btnEditar.addActionListener(this);

        add(lblNombre);
        add(lblCodigo);
        add(lblJornada);
        add(lblTripulantes);
        add(btnEditar);
    }

    public void updateInformationCurso(String nombre, int codigo, char jornada, int tripulantes) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.jornada = jornada;
        lblNombre.setText("Nombre: "+nombre);
        lblCodigo.setText("Código: "+codigo);
        lblJornada.setText("Jornada: "+jornada);
        lblTripulantes.setText("Tripulantes: "+tripulantes);
    }

    public void openCursoEditor() {        
        if (!vistaEdicionCurso.isVisible() && codigo != 0) {   
            vistaEdicionCurso.updateDataCurso(nombre, codigo, jornada);       
            vistaEdicionCurso.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(vistaPrincipal, 
                "Debes seleccionar un elemento de la lista");
        }
    }

    public void storeCurso(Curso c) {
        vistaPrincipal.updateCurso(c.getCodigo(), c.getNombre(), c.getJornada());
    }

    @Override
    public void actionPerformed(ActionEvent eventazo) {
        if (eventazo.getActionCommand().equals(btnEditar.getActionCommand())) {
            openCursoEditor();
        }
    }

}
