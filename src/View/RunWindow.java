package View;

import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import Controller.Controller;

public class RunWindow extends JFrame { //creating the run window where the calculated data will be shown
	
		Controller cont;
		
	RunWindow(Controller a, JPanel b, JTextArea c, JComboBox d ){ 
		
		cont=a;
		
		setSize(1000,950);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		setLayout(new BorderLayout());
		
		RightPanel rp = new RightPanel(c,cont, d, b); 
		
		add(b, BorderLayout.LINE_START);
		add(rp, BorderLayout.LINE_END);
		
		pack();
		
		setVisible(false);
	}		
}