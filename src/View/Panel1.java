package View;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.Controller;

public class Panel1 extends JPanel{ //clas for the first panel
	
		private Controller cont;
		
		JTextField ruta11=new JTextField(5);
		JTextField ruta12=new JTextField(5);
		JTextField ruta13=new JTextField(5);
		JTextField ruta14=new JTextField(5);
		JTextField ruta15=new JTextField(5);
	
	Panel1(Controller a){
		
		cont=a;
		
		Dimension size = getPreferredSize();
		size.height = 150;
		setPreferredSize(size);
		
		setBorder(BorderFactory.createTitledBorder("Country Specific"));
		setLayout(new GridBagLayout());
		
		JLabel label1 = new JLabel ("Growth Estimate Period");
		JLabel label4 = new JLabel ("Period");
		JLabel label12= new JLabel("0");
		JLabel label13= new JLabel("1");
		JLabel label14= new JLabel("2");
		JLabel label15= new JLabel("3");
		JLabel label16= new JLabel("4");
					
		
		ruta11.addFocusListener(new FocusListener() {
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void focusLost(FocusEvent e) {
				
				if(ruta11.getText().isEmpty()==false) {
				
					try {
						Double.parseDouble(ruta11.getText());
					}
					catch(NumberFormatException a) {
						ruta11.requestFocus();
					}
				}
			}
		});
		
		ruta12.addFocusListener(new FocusListener() {
			
			@Override
			public void focusGained(FocusEvent e) {
				

			}
			
			@Override
			public void focusLost(FocusEvent e) {
				
				if(ruta12.getText().isEmpty()==false) {
				
					try {
						Double.parseDouble(ruta12.getText());
					}
					catch(NumberFormatException a) {
						ruta12.requestFocus();
					}
				}
			}
			
		});
		
		ruta13.addFocusListener(new FocusListener() {
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void focusLost(FocusEvent e) {
			
				if(ruta13.getText().isEmpty()==false) {
				
					try {
						Double.parseDouble(ruta13.getText());
					}
					catch(NumberFormatException a) {
						ruta13.requestFocus();
					}
				}	
			}
		});
		
		ruta14.addFocusListener(new FocusListener() {
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void focusLost(FocusEvent e) {
				
				if(ruta14.getText().isEmpty()==false) {
					
					try {
						Double.parseDouble(ruta14.getText());
					}
					catch(NumberFormatException a) {
						ruta14.requestFocus();
					}
				}
			}	
		});
		
		ruta15.addFocusListener(new FocusListener() {
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void focusLost(FocusEvent e) {
				
				if(ruta15.getText().isEmpty()==false) {
					
					try {
						Double.parseDouble(ruta11.getText());
					}
					catch(NumberFormatException a) {
						ruta11.requestFocus();
					}
				}
			}	
		});
		

		GridBagConstraints c=new GridBagConstraints();
		
		//adding labels
		
		c.anchor=GridBagConstraints.LINE_END;
		c.weightx=0.5;
		c.weighty=0.5;
		
		c.gridx=0;
		c.gridy=0;
		
		add(label4,c);
		
		c.anchor=GridBagConstraints.LINE_START;
		c.gridx=0;
		c.gridy=1;
		
		add(label1,c);
		
		//textfields and periods
		
		c.anchor=GridBagConstraints.CENTER;
		c.gridx=1;
		c.gridy=0;
		
		add(label12,c);
		
		c.gridx=2;
		c.gridy=0;
		
		add(label13,c);
		
		c.gridx=3;
		c.gridy=0;
		
		add(label14,c);
		
		c.gridx=4;
		c.gridy=0;
		
		add(label15,c);
		
		c.gridx=5;
		c.gridy=0;
		
		add(label16,c);
		
		c.anchor=GridBagConstraints.LINE_END;
		
		c.gridx=1;
		c.gridy=1;
		
		add(ruta11,c);
		
		c.gridx=2;
		c.gridy=1;
		
		add(ruta12,c);

		c.gridx=3;
		c.gridy=1;
		
		add(ruta13,c);
		
		c.gridx=4;
		c.gridy=1;
		
		add(ruta14,c);
		
		c.gridx=5;
		c.gridy=1;
		
		add(ruta15,c);
	}
}