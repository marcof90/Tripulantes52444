package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.Curso;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaEdicionCurso extends JFrame implements ActionListener{
    
    private JTextField txtNombre;
    private JTextField txtCodigo;
    private JTextField txtJornada;

    private JButton btnEditar;

    private PanelDetalleCurso panelDetalleCurso;

    public VistaEdicionCurso(PanelDetalleCurso panelDetalleCurso) {
        super();
        setSize(250, 350);
        setLayout(new GridLayout(7, 1));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        this.panelDetalleCurso = panelDetalleCurso;

        txtCodigo = new JTextField();
        txtNombre = new JTextField();
        txtJornada = new JTextField();

        txtCodigo.setEditable(false);

        btnEditar = new JButton("Editar");
        btnEditar.addActionListener(this);

        add(new JLabel("Nombre Curso"));
        add(txtNombre);
        add(new JLabel("Codigo Curso"));
        add(txtCodigo);
        add(new JLabel("Jornada"));
        add(txtJornada);
        add(btnEditar);
    }

    public void updateDataCurso(String nombre, int codigo, char jornada) {
        txtCodigo.setText(codigo+"");
        txtNombre.setText(nombre);
        txtJornada.setText(jornada+"");
    }

    public Curso getActualCurso() {
        return new Curso(Integer.parseInt(txtCodigo.getText()), 
            txtNombre.getText(), txtJornada.getText().charAt(0));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(btnEditar.getActionCommand())) {
            panelDetalleCurso.storeCurso(getActualCurso());
        }
    }
}
