package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import Controller.Controller;

public class RightPanel extends JPanel { //the right panel of the RunWindow
	
		Controller cont;
		
		JComboBox chooseRun = new JComboBox();
		
	RightPanel(JTextArea a, Controller b, JComboBox d, JPanel lp){ 
	
		cont=b;
		chooseRun=d;
		
		Dimension size = getPreferredSize();
		size.width = 400;
		setPreferredSize(size);
	
		setBorder(BorderFactory.createTitledBorder("Values"));
		setLayout(new BorderLayout());
		
		JPanel up=new JPanel();
		up.setLayout(new BorderLayout());
		
		JPanel dp=new JPanel();
		
		dp.setLayout(new GridBagLayout());
		
		add(up,BorderLayout.CENTER);
		add(dp,BorderLayout.PAGE_END);
		
		JScrollPane scroll = new JScrollPane(a);
		
		a.setLineWrap(true);
		a.setEditable(false);
		
		JButton saveInt = new JButton("Save internal");
		JButton saveExt = new JButton("Save external");
		
		chooseRun.addActionListener(new ActionListener() { //adding the actions for the chooseRun 

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(chooseRun.getItemCount()>0) { //only works if there is one run, wont run before added the first one
					
					cont.removeContentPanes(lp); //removing old ones if there are
					cont.getRun(chooseRun);  //get the selected run
				
					a.setText(cont.getValues()); //sets the right text in the textarea

					//adding the charts
					GridBagConstraints c=new GridBagConstraints();
			       
					c.weightx=0.5;
					c.weighty=0.5;
		        	
					c.gridx=0;
					c.gridy=0;
					lp.add(cont.getBarChart(),c); //step 4, get values
				
					c.gridx=0;
					c.gridy=1;
					lp.add(cont.getGraphRWA(),c);
				
				
					c.gridx=0;
					c.gridy=2;
					lp.add(cont.getGraphNPL(),c);	
				}
			}
		});
		
		saveInt.addActionListener(new ActionListener() { //adding the actions for the saveInt button

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(chooseRun.getItemCount()>0) {
					
					cont.saveLocal();
				}
				
				else {
					JOptionPane.showMessageDialog(null, "No existing runs to save.", "No Runs Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		saveExt.addActionListener(new ActionListener() { //adding the actions for the saveExt button

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(chooseRun.getItemCount()>0) {
					
					try {
						
						cont.saveExternal();
					}
					
					catch(IOException a) {
						JOptionPane.showMessageDialog(null,"Please check your inserted values in the settings window.", "Settings Error",JOptionPane.ERROR_MESSAGE);
					}	
				}
				
				else {
					JOptionPane.showMessageDialog(null, "No existing runs to save.", "No Runs Error", JOptionPane.ERROR_MESSAGE);
				}
			}	
		});
					
		//adding the panels
		
		GridBagConstraints c=new GridBagConstraints();
		
		c.anchor=GridBagConstraints.PAGE_END;
		c.insets=new Insets(20,0,20,0);
		c.weightx=0.5;
		c.weighty=0.5;
				
		c.gridx=0;
		c.gridy=0;
		dp.add(saveInt,c);
		
		c.gridx=1;
		c.gridy=0;
		dp.add(saveExt,c);
		
		c.gridx=2;
		c.gridy=0;
		dp.add(chooseRun);
		
		up.add(scroll);
	}
}