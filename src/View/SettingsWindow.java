package View;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import Controller.Controller;

public class SettingsWindow extends JFrame{ //class the setting window where the user put in the needed data for dataconnection
	
	
	
		Controller cont;
		//the following parts are needed for successful external saving and loading
		static JTextField ip = new JTextField(10);
		static JTextField pathsend = new JTextField(10);
		static JTextField pathreceive= new JTextField(10);
		static JTextField portsend = new JTextField(10);
		static JTextField portreceive = new JTextField(10);
		
	public SettingsWindow(Controller a, JPanel b){ 
		
		super("Settings");
		
		cont=a;
		
		setSize(400,500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		add(b);
		Dimension size = getPreferredSize();
		size.height = 150;
		b.setPreferredSize(size);
			
		b.setLayout(new GridBagLayout());
		
		JLabel ipaddress = new JLabel("IP address for the server:");
		JLabel pathdir = new JLabel("File path for sent results:");
		JLabel pathrec = new JLabel("File path for loaded results:");
		JLabel useportsend = new JLabel("Port used for sending objects:");
		JLabel useportreceive = new JLabel("Port used for receiving objects:");
		
		GridBagConstraints c = new GridBagConstraints();
		
		c.anchor=GridBagConstraints.CENTER;
		c.weightx=0.5;
		c.weighty=0.5;
		
		c.gridx=0;
		c.gridy=0;
		
		b.add(ipaddress, c);
		
		c.gridx=0;
		c.gridy=1;
		
		b.add(pathdir, c);
		
		c.gridx=0;
		c.gridy=2;
		
		b.add(pathrec, c);
		
		c.gridx=0;
		c.gridy=3;
		
		b.add(useportsend, c);
		
		c.gridx=0;
		c.gridy=4;
		
		b.add(useportreceive, c);
		
		c.gridx=1;
		c.gridy=0;
		
		b.add(ip, c);
		
		c.gridx=1;
		c.gridy=1;
		
		b.add(pathsend, c);
		
		c.gridx=1;
		c.gridy=2;
		
		b.add(pathreceive, c);
		
		c.gridx=1;
		c.gridy=3;
		
		b.add(portsend, c);
		
		c.gridx=1;
		c.gridy=4;
		
		b.add(portreceive, c);

		setVisible(false);
	}
	
	public static String getIP() {
		
		return ip.getText();
	}
	
	public static String getPathSend() {
		
		return pathsend.getText();
	}
	
	public static String getPathReceive() {
		
		return pathreceive.getText();
	}
	
	
	public static int getPortReceive() {
		
		return Integer.parseInt(portreceive.getText());
	}
	
	public static int getPortSend() {
		
		return Integer.parseInt(portsend.getText());
	}
}