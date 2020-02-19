import javax.swing.JFrame;
import Controller.Controller;
import Dataconnection.Requester;
import View.MainFrame;

public class Main {

	public static void main(String[] args) {
		
		//launching the app and creating necessary objects
		
		Controller controll = new Controller(); //controller for the code
		Requester req= new Requester(controll); //the code for client in dataconnection
		
		MainFrame frame = new MainFrame(controll); //creates the application window
		frame.setSize(500,700);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
