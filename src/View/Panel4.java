package View;

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
import javax.swing.JLabel;
import javax.swing.JPanel;
import Controller.Controller;

public class Panel4 extends JPanel {//class for the fourth panel
	
		private Controller cont;
		
		JComboBox chooseBank;
		
	Panel4(Controller a, JComboBox b){
		
		cont=a;
		chooseBank=b;
		
		Dimension size = getPreferredSize();
		size.height = 150;
		setPreferredSize(size);
	
		setBorder(BorderFactory.createTitledBorder("Bank Specific"));
		setLayout(new GridBagLayout());
	
		JButton uploadBank = new JButton("UPLOAD BANK");
		Dimension size1 = new Dimension(150,25);
		uploadBank.setPreferredSize(size1);
		
		JButton createBank = new JButton("CREATE BANK");
		createBank.setPreferredSize(size1);
		
		JLabel banks = new JLabel("Banks");
		
		uploadBank.addActionListener(new ActionListener() {//adding actions to the upload bank button

			@Override
			public void actionPerformed(ActionEvent e) {
				
				boolean bankAdded = cont.addBankfkt(); //returns true if everything went accordingly
				
				if(bankAdded ==true) {
					
					String newBank = cont.getName();
					cont.saveBank(newBank, chooseBank); //adding the name of the bank to the box
				}
			}
		});
		
		
		createBank.addActionListener(new ActionListener() {//adding actions to the create bank button

			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					String[] inputtext = {"Coverage ratio", "Risk weight", "Total loans", "Non performing loans", "Equity", "Profit", "Dividends","Tier 2 captial"};
					
					boolean bankAdded = cont.createBank(inputtext);
					
					if(bankAdded == true) {
						
						String newBank = cont.getName();
						cont.saveBank(newBank, chooseBank);
						
					}
					
				} 
				
				catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		GridBagConstraints c=new GridBagConstraints();
	
		//adding addbank, labels and the jcombobox
	
		c.anchor=GridBagConstraints.LINE_START;
		c.insets=new Insets(10,40,0,0);
		c.weightx=0.5;
		c.weighty=0.5;
		
		c.gridx=0;
		c.gridy=0;
	
		add(uploadBank,c);
		
		c.gridx=0;
		c.gridy=1;
		c.insets=new Insets(0,40,10,0);
		
		add(createBank,c);
		
		c.anchor=GridBagConstraints.CENTER;
		c.insets=new Insets(50,0,0,0);

		c.gridx=1;
		c.gridy=0;
		add(banks,c);
		
		c.fill=GridBagConstraints.HORIZONTAL;
		c.insets=new Insets(50,0,0,40);
		c.gridx=2;
		c.gridy=0;
		add(chooseBank,c);
	}
}