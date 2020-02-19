package Dataconnection;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import Controller.Controller;
import Model.Result;
import View.LoadWindow;
import View.SettingsWindow;

public class Requester { //code for the computer that wants to send objects externally
	
		static Controller cont;
		static Result receivedRes;
	
	public Requester(Controller a){
		
		cont =a ;
	}
	
	public static void clientSendObject(Result a) throws IOException {
		 	
		Socket socket = null;
	    String host = SettingsWindow.getIP();

	    socket = new Socket(host, SettingsWindow.getPortSend());
	        
	    java.io.OutputStream os = socket.getOutputStream();
	    DataOutputStream dos = new DataOutputStream(os);
			
		try {
				
			String filename = JOptionPane.showInputDialog("Please enter object file name");
				
			if(filename!=null ) {
					
				dos.writeUTF(SettingsWindow.getPathSend() + "\\" + filename);
				dos.flush();
					
				java.io.OutputStream out = socket.getOutputStream();
				ObjectOutputStream objout= new ObjectOutputStream(out);
		        
				objout.writeObject(a);
		        
		        dos.close();
				objout.close();
				socket.close();
			}
		}
			
		catch(IOException e) {
		}
	}
	 
	public static void clientReceiveObject(Socket a,LoadWindow b, JComboBox c, JFrame d) throws UnknownHostException, IOException, ClassNotFoundException {

		String host= SettingsWindow.getIP();
		
		a= new Socket(host, SettingsWindow.getPortReceive());
		
		OutputStream os = a.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);
		
		dos.writeUTF(SettingsWindow.getPathReceive());
		dos.flush();
		 
		InputStream in = a.getInputStream();
		ObjectInputStream objIn = new ObjectInputStream(in);
		
		ArrayList<String> filenames = (ArrayList<String>) objIn.readObject();
		
		cont.setFileNames(b.getBox(), filenames);
		
		b.getButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String filename =(String) b.getBox().getSelectedItem();
				
				try {
					
					dos.writeUTF(SettingsWindow.getPathReceive() + "\\" +filename);
					receivedRes = (Result) objIn.readObject();
					
					cont.setCurrentRes(receivedRes, c ,d);
					
					b.setVisible(false);
					objIn.close();
				} 
				
				catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
				catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		b.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		       
		    	try {
					dos.writeUTF("Close");
					b.setVisible(false);
					
				} 
		    	catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
		});
		
		b.setVisible(true);
	}
	
	public static Result getResult() {
		
		return receivedRes;
	}
}