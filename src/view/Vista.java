package view;

import javax.swing.JFrame;
import java.awt.BorderLayout;

public class Vista extends JFrame{


    private PanelOpciones panelOpc;
    
    public Vista() {
        super();
        setSize(600, 400);
        setTitle("Tripulantes");
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setLayout(new BorderLayout());

        panelOpc = new PanelOpciones();

        add(panelOpc, BorderLayout.SOUTH);

    }
        
}



