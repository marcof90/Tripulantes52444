package view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelCurso extends JPanel implements ActionListener {

    private JTextField txtNombre;
    private JTextField txtCodigo;
    private JTextField txtJornada;

    private JButton btnCrear;

    private Vista vistaPrincipal;

    public PanelCurso(Vista v) {
        super();
        setLayout(new GridLayout(7, 1));
        setBorder(new TitledBorder("Crear Curso"));

        vistaPrincipal = v;

        txtCodigo = new JTextField();
        txtNombre = new JTextField();
        txtJornada = new JTextField();

        btnCrear = new JButton("Crear");
        btnCrear.addActionListener(this);

        add(new JLabel("Nombre Curso"));
        add(txtNombre);
        add(new JLabel("Codigo Curso"));
        add(txtCodigo);
        add(new JLabel("Jornada"));
        add(txtJornada);
        add(btnCrear);
    }

    public void addCurso() {
        if (!txtNombre.getText().equals(null) && !txtNombre.getText().trim().equals("")) {
            if (!txtCodigo.getText().equals(null) && !txtCodigo.getText().trim().equals("")) {
                if (!txtJornada.getText().equals(null) && !txtJornada.getText().trim().equals("")) {
                    vistaPrincipal.addCurso(Integer.parseInt(txtCodigo.getText()), txtNombre.getText(),
                            txtJornada.getText().trim().charAt(0));
                            txtNombre.setText("");
                            txtCodigo.setText("");
                            txtJornada.setText("");                            
                } else {
                    JOptionPane.showMessageDialog(vistaPrincipal, "Llena el campo Jornada");
                }
            }else {
                JOptionPane.showMessageDialog(vistaPrincipal, "Llena el campo Codigo");
            }
        }else {
            JOptionPane.showMessageDialog(vistaPrincipal, "Llena el campo Nombre");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(btnCrear.getActionCommand())) {
            addCurso();
        }
    }

}
