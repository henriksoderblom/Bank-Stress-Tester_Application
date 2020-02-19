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
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Controller.Controller;

public class Panel2 extends JPanel { //class for the second panel
	
		private Controller cont;
		
		JTextField div1=new JTextField(5);
		JTextField div2=new JTextField(5);
		JTextField div3=new JTextField(5);
		JTextField div4=new JTextField(5);
		JTextField div5=new JTextField(5);
		
		JRadioButton yes= new JRadioButton();
		
	Panel2(Controller a){
		
		cont=a;
		
		Dimension size = getPreferredSize();
		size.height = 150;
		setPreferredSize(size);
		
		setBorder(BorderFactory.createTitledBorder("Scenario"));
		setLayout(new GridBagLayout());
		
		JLabel label1= new JLabel ("Dividend in period ");
		JLabel label2= new JLabel ("Entity effect ");
		JLabel Elabel = new JLabel ("On");
		
		div1.addFocusListener(new FocusListener() {
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void focusLost(FocusEvent e) {
				
				if(div1.getText().isEmpty()==false) {
				
					try {
					
						if(Double.parseDouble(div1.getText())>1 || Double.parseDouble(div1.getText())<0 ) {
							
							div1.requestFocus();
						}
					
					}
					
					catch(NumberFormatException a) {
						div1.requestFocus();
					}
				}
			}
		});
		
		div2.addFocusListener(new FocusListener() {
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void focusLost(FocusEvent e) {
				
				if(div2.getText().isEmpty()==false) {
				
					try {
					
						if(Double.parseDouble(div2.getText())>1 || Double.parseDouble(div2.getText())<0) {
					
							div2.requestFocus();
						}
					
					}
					
					catch(NumberFormatException a) {
						div2.requestFocus();
					}
				}
			}
			
		});
		
		div3.addFocusListener(new FocusListener() {
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void focusLost(FocusEvent e) {
			
				if(div3.getText().isEmpty()==false) {
					
					try {
					
						if(Double.parseDouble(div3.getText())>1 || Double.parseDouble(div3.getText())<0) {
					
							div3.requestFocus();
						}
					}
					
					catch(NumberFormatException a) {
						div3.requestFocus();
					}
				}
			}
			
		});
		
		div4.addFocusListener(new FocusListener() {
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void focusLost(FocusEvent e) {
				
				if(div4.getText().isEmpty()==false) {
					
					try {
					
						if(Double.parseDouble(div4.getText())>1 || Double.parseDouble(div4.getText())<0) {
					
							div4.requestFocus();
						}
					}
					
					catch(NumberFormatException a) {
						div4.requestFocus();
					}
				}
			}
		});
		
		div5.addFocusListener(new FocusListener() {
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void focusLost(FocusEvent e) {
				
				if(div5.getText().isEmpty()==false) {
					
					try {
					
						if(Double.parseDouble(div5.getText())>1 || Double.parseDouble(div5.getText())<0) {
					
							div5.requestFocus();
						}
					}
					
					catch(NumberFormatException a) {
						div5.requestFocus();
					}
				}
			}
		});
		
		GridBagConstraints c=new GridBagConstraints();
		
		//adding labels
		
		c.anchor=GridBagConstraints.LINE_START;
		c.insets=new Insets(0,0,0,35);
		c.weightx=0.5;
		c.weighty=0.5;
		
		c.gridx=0;
		c.gridy=0;
		
		add(label1,c);
		
		c.gridx=0;
		c.gridy=1;
		
		add(label2,c);
		
		//adding boxes and textfields
		
		c.anchor=GridBagConstraints.LINE_START;
		c.insets=new Insets(0,0,0,0);
		c.gridx=1;
		c.gridy=0;
		
		add(div1,c);
		
		c.gridx=2;
		c.gridy=0;
		
		add(div2,c);
		
		c.gridx=3;
		c.gridy=0;
		
		add(div3,c);
		
		c.gridx=4;
		c.gridy=0;
		
		add(div4,c);
		
		c.gridx=5;
		c.gridy=0;
		
		add(div5,c);
		
		c.gridx=1;
		c.gridy=1;
		
		add(yes,c);
		
		c.gridx=2;
		c.gridy=1;
		
		add(Elabel,c);
	}
	
	public int getEntity() { //returning the entity , smarter to have a getter for only one value
		
		int ent=0;
		
		if(yes.isSelected()==true) {
			ent=1;
			return ent;
		}
		
		else {
			return ent;
		}
	}
}