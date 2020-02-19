package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import Controller.Controller;

public class Menu extends JMenuBar { //class for the menu
			
			Controller cont;
			
	Menu(Controller a, JPanel b, JComboBox c, JFrame d, LoadWindow f){
		
		cont=a;
		
		JMenu m=new JMenu("Menu");
		JMenu load= new JMenu("Load Data");
		
		JMenuItem set=new JMenuItem("Settings");
		JMenuItem help = new JMenuItem("Help");
		JMenuItem author= new JMenuItem("Authors");
		JMenuItem surprise=new JMenuItem("Wonderful Surprise");

		JMenuItem loadint=new JMenuItem("Load Internal");
		JMenuItem loadext=new JMenuItem("Load External");

		load.add(loadint);
		load.add(loadext);
		
		m.add(load);
		
		SettingsWindow sw=new SettingsWindow(cont,b);
		HelpWindow hp=new HelpWindow();
		AuthorWindow aw=new AuthorWindow();
		
		m.add(set);
		m.add(help);
		m.add(author);
		m.add(surprise);
		
		add(m);
		
		//actions for clicking the menu items
		help.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				hp.setVisible(true);
			}
		});
		
		author.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				aw.setVisible(true);
			}
		});
		
		set.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				sw.setVisible(true);
			}
		});
		
		loadint.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				boolean loaded= cont.loadLocal();
				
				if(loaded==true) {
	
					cont.createGraphs(0);
					cont.createGraphs(1);
					cont.createGraphs(2);
				
					cont.addRun(c); //add run
			
					d.setVisible(true);
				}
			}
		});
		
		loadext.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					cont.loadExternal(f, c ,d);
				}
				
				catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,"Please check your inserted values in the settings window.", "Settings Error",JOptionPane.ERROR_MESSAGE);;
				}
			}
		});
		

		//not the most important
		surprise.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				JFrame frame = new JFrame();
				frame.setLocationRelativeTo(null);
				
				ImageIcon icon = new ImageIcon("horror.png");
				JLabel label = new JLabel(icon);
				
				frame.add(label);
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				}
		});
	}
}