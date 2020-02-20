
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFileChooser;



public class Server implements Serializable{

 
  
  
	 public static void serverReceiveObject() throws IOException, ClassNotFoundException {
		 		
		 	
	  
  
		 ServerSocket serverSocket = null;

		 try {
    	  
			 serverSocket = new ServerSocket(4444,10);
			 
		 } 
		 
		 catch (IOException ex) {
			 
			 System.out.println("Can't setup server on this port number. ");
		 }
      
		 Socket socket = null;
		 InputStream in = null;
		 ObjectInputStream objIn = null;

		 try {
			 
			 socket = serverSocket.accept();
         }
		 
		 catch (IOException ex) {
			 
			 System.out.println("Can't accept client connection. ");
		 }

		 try {
			 
			 in = socket.getInputStream();
		 } 
		 
		 catch (IOException ex) {
			 
			 System.out.println("Can't get socket input stream. ");
		 }

		 try {
			 
			 objIn = new ObjectInputStream(in);
		 } 
		 
		 catch (FileNotFoundException ex) {
			 
			 System.out.println("File not found. ");
		 }
      
		 JFileChooser fc = new JFileChooser(); 
		 fc.setSelectedFile(new File("SparatObject"));
		 int r=fc.showSaveDialog(null);
		
		 if (r == JFileChooser.APPROVE_OPTION) { 
		      
			 try(ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream(fc.getSelectedFile()))) {
				
				 objOutput.writeObject(objIn.readObject());
			 }
			 
			 catch(NotSerializableException e) {
				
				 e.printStackTrace();
			 }
			
			 catch (IOException e) {
				
				e.printStackTrace();
			 }
			
		 }
     
	  serverSocket.close();
	  socket.close();
		
  }
	 
   public static void serverSendObject() throws IOException, ClassNotFoundException {
	   
	   ServerSocket serverSocket = null;

		 try {
  	  
			 serverSocket = new ServerSocket(4444,10);
			 
		 } 
		 
		 catch (IOException ex) {
			 
			 System.out.println("Can't setup server on this port number. ");
		 }
    
		 Socket socket = null;
		 OutputStream out = null;
		 ObjectOutputStream objOut = null;
		
		 try {
			 
			 socket = serverSocket.accept();
         }
		 
		 catch (IOException ex) {
			 
			 System.out.println("Can't accept client connection. ");
		 }
		 
		 try {
			 
			 out = socket.getOutputStream();
		 } 
		 
		 catch (IOException ex) {
			 
			 System.out.println("Can't get socket input stream. ");
		 }

		 try {
			 
			 objOut = new ObjectOutputStream(out);
		 } 
		 
		 catch (FileNotFoundException ex) {
			 
			 System.out.println("File not found. ");
		 }
		 
		 JFileChooser fc = new JFileChooser();
			
		 int reValue=fc.showOpenDialog(null);
			
		 if(reValue == JFileChooser.APPROVE_OPTION) {
			
				
			
			 try(ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(fc.getSelectedFile()))) {
				 
					objOut.writeObject(objInput.readObject());
					
					
			 }
			 
			catch(IOException e) {
					
			}
			catch(ClassNotFoundException e) {
				
			}
			
		 }
		 
		 serverSocket.close();
		 socket.close();
		 
   }	
}