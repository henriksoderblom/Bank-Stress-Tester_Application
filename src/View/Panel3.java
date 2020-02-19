package View;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.Controller;

public class Panel3 extends JPanel{ //class for the third panel
	
		private Controller cont;
		
		JTextField ruta1=new JTextField(5);
		JTextField ruta2=new JTextField(5);
		JTextField ruta3=new JTextField(5);
		JTextField ruta4=new JTextField(5);

	Panel3(Controller a){
		
		cont=a;
		
		Dimension size = getPreferredSize();
		size.height = 150;
		setPreferredSize(size);
		
		setBorder(BorderFactory.createTitledBorder("Parameters"));
		setLayout(new GridBagLayout());
		
		JLabel label1= new JLabel ("NPL-GPP correlation ");
		JLabel label2= new JLabel ("NPL-NPL_t-1 correlation ");
		JLabel label3= new JLabel ("Entity dummy ");
		JLabel label4= new JLabel ("Constant ");
		
		ruta1.addFocusListener(new FocusListener() {
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void focusLost(FocusEvent e) {
				
				if(ruta1.getText().isEmpty()==false) {
				
					try {
						Double.parseDouble(ruta1.getText());
					}
					
					catch(NumberFormatException a) {
						ruta1.requestFocus();
					}
				}
			}
		});
		
		ruta2.addFocusListener(new FocusListener() {
			
			@Override
			public void focusGained(FocusEvent e) {
				

			}
			
			@Override
			public void focusLost(FocusEvent e) {
				
				if(ruta2.getText().isEmpty()==false) {
				
					try {
						Double.parseDouble(ruta2.getText());
					}
					
					catch(NumberFormatException a) {
						ruta2.requestFocus();
					}
				}
			}
		});
		
		ruta3.addFocusListener(new FocusListener() {
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void focusLost(FocusEvent e) {
			
				if(ruta3.getText().isEmpty()==false) {
					
					try {
						Double.parseDouble(ruta3.getText());
					}
					
					catch(NumberFormatException a) {
						ruta3.requestFocus();
					}
				}
			}
		});
		
		ruta4.addFocusListener(new FocusListener() {
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void focusLost(FocusEvent e) {
				
				if(ruta4.getText().isEmpty()==false) {
					
					try {
						Double.parseDouble(ruta4.getText());
					}
					
					catch(NumberFormatException a) {
						ruta4.requestFocus();
					}
				}
			}
		});
	
		GridBagConstraints c=new GridBagConstraints();
		
		//adding labels
		
		c.anchor=GridBagConstraints.LINE_START;
		c.weightx=0.5;
		c.weighty=0.5;
		
		c.gridx=0;
		c.gridy=0;
		add(label1,c);
		
		c.gridx=0;
		c.gridy=1;
		add(label2,c);
		
		c.gridx=0;
		c.gridy=2;
		add(label3,c);
		
		c.gridx=0;
		c.gridy=3;
		add(label4,c);
		
		//adding textfields
		
		c.anchor=GridBagConstraints.LINE_START;
		c.insets=new Insets(0,0,0,255);
		c.weightx=0.5;
		c.weighty=0.5;
		
		c.gridx=1;
		c.gridy=0;
		add(ruta1,c);
		
		c.gridx=1;
		c.gridy=1;
		add(ruta2,c);
		
		c.gridx=1;
		c.gridy=2;
		add(ruta3,c);
		
		c.gridx=1;
		c.gridy=3;
		add(ruta4,c);
	}
}