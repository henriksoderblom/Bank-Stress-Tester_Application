package View;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import Controller.Controller;

public class MainFrame extends JFrame { //what comes to the application window
			
			private Controller cont;
			
		
	public MainFrame(Controller a){
		
		super("Stress Tester");
		cont=a;
		
		JComboBox chooseBank = new JComboBox();
		
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		
		Panel1 panel1 = new Panel1(cont);
		panel1.setAlignmentX(getContentPane().CENTER_ALIGNMENT);
		add(panel1);
		
		Panel2 panel2 = new Panel2(cont);
		panel2.setAlignmentX(getContentPane().CENTER_ALIGNMENT);
		add(panel2);
		
		Panel3 panel3 = new Panel3(cont);
		panel3.setAlignmentX(getContentPane().CENTER_ALIGNMENT);
		add(panel3);
		
		Panel4 panel4 = new Panel4(cont,chooseBank);
		panel4.setAlignmentX(getContentPane().CENTER_ALIGNMENT);
		add(panel4);
		
		Panel panel5 = new Panel();
		Dimension size = getPreferredSize();
		size.height = 150;
		panel5.setPreferredSize(size);
		panel5.setLayout(new GridBagLayout());
		
		JPanel lp = new JPanel();
		
		Dimension size1 = getPreferredSize();
		size1.width= 600;
		size1.height = 950;
		lp.setPreferredSize(size1);

		lp.setBorder(BorderFactory.createTitledBorder("Charts"));
		lp.setLayout(new GridBagLayout());
		
		JTextArea table=new JTextArea();
		
		JComboBox chooseRun = new JComboBox();
		
		RunWindow rw=new RunWindow(cont, lp, table, chooseRun);
		
		LoadWindow lw = new LoadWindow();
		
		JPanel setPanel = new JPanel();
		Menu menu=new Menu(cont,setPanel, chooseRun, rw, lw  );
		
		setJMenuBar(menu);
		
		JButton go= new JButton("GO");
		Dimension size2 = new Dimension(100,50);
		go.setPreferredSize(size2);
		
		JButton showRuns= new JButton("Open Runs");
		Dimension size3 = new Dimension(100,30);
		showRuns.setPreferredSize(size3);

		go.addActionListener(new ActionListener() { //go button actions

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(chooseBank.getItemCount()>0) {
				
					if(cont.controllTFValues(panel1, panel2, panel3)==true)	{
				
						cont.getBank(chooseBank);
				
						cont.CPandResultandVis(); //step1, create countryparameter object and result object and visualizer object
				
						int entity = panel2.getEntity();

						cont.getTFvalues(panel1,1); //step2 get all values for cp
						cont.getTFvalues(panel2,2);
						cont.getTFvalues(panel3,3);
				
						cont.sendValues(entity);  //step3 send and calculate
				
						cont.createGraphs(0);
						cont.createGraphs(1);
						cont.createGraphs(2);
				
						cont.addRun(chooseRun); //add run

						rw.setVisible(true);
					}
				
					else {
						JOptionPane.showMessageDialog(null,"Please check your input fields.", "Input Fields Error",JOptionPane.ERROR_MESSAGE);
					}
				}
				
				else {
					JOptionPane.showMessageDialog(null, "Please insert a bank before running application.", "No Bank",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		
		showRuns.addActionListener(new ActionListener() { //go button actions

			@Override
			public void actionPerformed(ActionEvent e) {
				
				rw.setVisible(true);
			}
		});
		
		GridBagConstraints c=new GridBagConstraints();
		
		//adding buttons
		
		c.anchor=GridBagConstraints.CENTER;
		c.weightx=0.5;
		c.weighty=0.5;
		
		c.insets=new Insets(0,150,0,0);
	
		panel5.add(go,c);
		
		c.anchor=GridBagConstraints.LINE_END;
		c.insets=new Insets(0,0,0,40);
		
		panel5.add(showRuns, c);
		
		add(panel5);
	}
}