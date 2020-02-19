package View;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LoadWindow extends JFrame { //the small window where the user loads the external objects

		private JComboBox files = new JComboBox();
		private JButton load = new JButton("Load");
	
	public LoadWindow() {
		
		super("Load Window");
		
		setSize(250,150);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel jp = new JPanel();
		add(jp);
		
		jp.setLayout(new GridBagLayout());

		load.setSize(new Dimension(40,20));
		
		GridBagConstraints c = new GridBagConstraints();
		
		c.anchor=GridBagConstraints.PAGE_START;
		c.insets=new Insets(20,0,0,0);
		c.weightx=0.5;
		c.weighty=0.5;
		
		c.gridx=0;
		c.gridy=0;
		
		jp.add(files, c);
		
		c.anchor=GridBagConstraints.PAGE_END;
		c.insets=new Insets(0,0,20,0);
		
		c.gridx=0;
		c.gridy=1;
		
		jp.add(load,c);
		
		setVisible(false);
	}

	public JComboBox getBox() {
		
		return files;
	}
	
	public JButton getButton() {
		
		return load;
	}
}