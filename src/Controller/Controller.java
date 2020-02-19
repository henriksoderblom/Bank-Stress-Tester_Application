package Controller;

import Dataconnection.*;
import java.awt.Component;
import java.awt.Container;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.jfree.chart.ChartPanel;
import com.opencsv.CSVWriter;
import Model.Bank;
import Model.Visualizer;
import Model.CountryParameters;
import Model.Result;
import View.LoadWindow;

public class Controller {
		
		Bank currentBank;
		CountryParameters currentCountry;
		Result currentRes;
		Visualizer currentVis;
		
	public void CPandResultandVis() { //creates needed objects
		
		CountryParameters cp=new CountryParameters();
		currentCountry=cp;
		
		Result res=new Result();
		currentRes=res;
		
		Visualizer vis=new Visualizer();
		currentVis=vis;
	}
	
	public boolean addBankfkt() { //adding a bank values as a csv or txt and returning true only if right is added
		
		boolean bankAdded=false;
		String newBank=null;
		newBank=JOptionPane.showInputDialog( "Enter the name of the bank.");
		
		if (newBank != null && newBank.length()>0) {
			
			JFileChooser chooser = new JFileChooser();
			File file = null;
			int reValue=chooser.showOpenDialog(null);
			
			if(reValue == JFileChooser.APPROVE_OPTION) {

				Bank bank = new Bank(newBank);
				currentBank=bank;
				
				file=chooser.getSelectedFile();
				bankAdded=currentBank.setFileValue(file);
				
				if(bankAdded == false) {
					
					currentBank.BankList.remove(currentBank.BankList.size()-1);
					return bankAdded;
				}
				
				else {
					return bankAdded;
				}
			}
			
			else {
				return bankAdded;
			}
		}
		
		else {
			return bankAdded;
		}
		
	}
	
	public boolean createBank(String[] a) throws IOException { //creates a csv file for bank values, returning true only if it is added
		
		boolean bankAdded=false;
		
		JFileChooser fc = new JFileChooser(); 
		fc.setSelectedFile(new File(""));
		int r=fc.showSaveDialog(null);
		
		File bankFile = null;
		
		if (r == JFileChooser.APPROVE_OPTION) { 
			
			try {
				
				bankFile = fc.getSelectedFile();
			
				FileWriter fw= new FileWriter(bankFile);
				CSVWriter writer = new CSVWriter(fw, ' ', 
                         CSVWriter.NO_QUOTE_CHARACTER, 
                         CSVWriter.DEFAULT_ESCAPE_CHARACTER, 
                         CSVWriter.DEFAULT_LINE_END); 

				 
				 ArrayList<String[]> data = new ArrayList<String[]>(); 

				 for (int i = 0; i < 8; i++) { 
					 
					 	String row = JOptionPane.showInputDialog("Enter: " + a[i]);
					 	String[] rowdata = row.split(" "); 
					 	data.add(rowdata); 
				 } 

				 writer.writeAll(data); 
				 writer.close(); 
				 
				 String newBank=null;
				 newBank=JOptionPane.showInputDialog( "Enter the name of the bank.");
					
					if (newBank != null && newBank.length()>0) {
						
						Bank bank = new Bank(newBank);
						currentBank=bank;
						
						bankAdded=currentBank.setFileValue(bankFile);
						return bankAdded;
					}
					
					else {
						return bankAdded;
					}
			}		
			
			catch(IOException e) {
				JOptionPane.showMessageDialog(null, "Please check your Bank-File.", "Bank-File Error", JOptionPane.ERROR_MESSAGE);
				return bankAdded;
			}
			catch(NullPointerException e) {
				return bankAdded;
			}
		
		}
		else {
			
			return bankAdded;
		}
	}
	
	public String getName() {//get the bank name that was inserted
		
		return currentBank.getBankName();
	}
	
	public void saveBank(String a,JComboBox b) { //adding the name of the bank to the list
		
		b.addItem(a);
	}
	
	public void getBank(JComboBox a) { //makes the currentbank the chosen bank
		
		currentBank=Bank.BankList.get(a.getSelectedIndex());
	}
	

	public boolean controllTFValues(Container a, Container b, Container c) {//controls the values in the textfields
		
		boolean pass = true;
		
		for(Component component : a.getComponents()) {
			
			if(component instanceof JTextField) {
				
				try {
					
					Double.parseDouble(((JTextField) component).getText());
				}
				
				catch(NumberFormatException e) {
					pass=false;
				}
			}
		}
		
		for(Component component : b.getComponents()) {
			
			if(component instanceof JTextField) {
				
					try {
						
						Double.parseDouble(((JTextField) component).getText());
					}
					
					catch(NumberFormatException e) {
						pass=false;
					}
			}
		}
		
		for(Component component : c.getComponents()) {
			
			if(component instanceof JTextField) {
				
					try {
						
						Double.parseDouble(((JTextField) component).getText());
					}
					
					catch(NumberFormatException e) {
						pass=false;
					}
			}
		}
		
		return pass;
	}

	public void getTFvalues(Container c, int a) { //getting the textfield values from a container
		
		if(a==1) {

			ArrayList<Double> GDPperiods = new ArrayList<Double>();
		
			for(Component component : c.getComponents()) {
			
				if(component instanceof JTextField) {
				
					GDPperiods.add(Double.parseDouble(((JTextField) component).getText()));
				}
			
			}
			
			GDPperiods.add(0, GDPperiods.get(0));
			currentCountry.setGDPperiods(GDPperiods);
		
		}
		
		if(a==2) {
			
			ArrayList<Double> dividends = new ArrayList<Double>();
		
			for(Component component : c.getComponents()) {
			
				if(component instanceof JTextField) {
				
					dividends.add(Double.parseDouble(((JTextField) component).getText()));
				}
			}
			
			currentCountry.setDividends(dividends);
		}
		
		if(a==3){
			
			ArrayList<Double> correlation = new ArrayList<Double>();
		
			for(Component component : c.getComponents()) {
			
				if(component instanceof JTextField) {
				
					correlation.add(Double.parseDouble(((JTextField) component).getText()));
				}
			}
			
			currentCountry.setCorrelation(correlation);
		}
	}
	
	public void removeContentPanes(Container a) { //removing components
		
		for (Component c: a.getComponents()) {
			
			if(c instanceof ChartPanel) {
				
				a.removeAll();
			}
		}
		
		a.revalidate();
		a.repaint();
	}
	
	public void sendValues(int a) { //sending all values for calculation
		
		currentRes.NPLRfkt(currentBank.getLoans(), currentBank.getNPL() );
		
		currentRes.NPLestimator(currentCountry.getCorrelationValue(3),currentCountry.getCorrelationValue(2) , currentCountry.getCorrelationValue(1),
				currentCountry.getCorrelationValue(0), currentCountry.getGDPperiods(), a, currentBank.getLoans(),currentBank.getNPL());
		
		currentRes.provestimator(currentBank.getCR());
		
		currentRes.RWAestimator(currentBank.getLoans(), currentBank.getRW());
		
		currentRes.equityestimator(currentBank.getEquity(), currentBank.getProfit(), currentBank.getDividend(), currentCountry.getDividends());
		
		currentRes.totalcapitalestimator(currentBank.getT2capital());
	}
	
	public void createGraphs(int a) { //creating desired graphs
		
		if(a==0) {
			
			currentVis.createBarChart(currentRes.getCAR(), currentRes.gett1CAR());
		}
		
		if(a==1) {
			
			currentVis.createGraph(currentRes.getRWA(), "RWA",a);
		}
		
		if(a==2) {
			
			currentVis.createGraph(currentRes.getNPL(), "NPL",a);
		}
	}
	
	public ChartPanel getBarChart() { //get the barchart
		
		return currentVis.getBarChart();
	}
	
	public ChartPanel getGraphRWA() { //get the RWA chart
		
		return currentVis.getCPRWA();
	}
	
	public ChartPanel getGraphNPL() { //get the NPL chart
		
		return currentVis.getCPNPL();
	}
		
	public String getValues() { //get the string for the textfield
		
		return currentRes.sendAllValues();
	}
	
	
	public void addRun(JComboBox a) { //adding the latest run to the "Run" JComboBox
		
		a.addItem("Run" + " " + (a.getItemCount()+1));
		
		a.setSelectedIndex(a.getItemCount()-1); //making the latest the shown
	}
	
	public void getRun(JComboBox a) { //makes the current result the chosen result and the same for the created graphs
		
		if(a.getItemCount()>0) {
		
			currentRes=currentRes.ResultList.get(a.getSelectedIndex());
			currentVis=currentVis.VisList.get(a.getSelectedIndex());
		}
	}
	
	public void saveLocal() { //saving an object on the computer
		
		JFileChooser fc = new JFileChooser(); 
		fc.setSelectedFile(new File(""));
		int r=fc.showSaveDialog(null);
		
		if (r == JFileChooser.APPROVE_OPTION) { 
		      
			try(ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream(fc.getSelectedFile()))) {
				
				objOutput.writeObject(currentRes);
			}
			
			catch(NotSerializableException e) {
				e.printStackTrace();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void saveExternal() throws IOException { //saving an object externally 
		
		try {
				
			Requester.clientSendObject(currentRes);
		} 
		
		catch(IOException a) {
			JOptionPane.showMessageDialog(null,"Please check your inserted values in the settings window.", "Settings Error",JOptionPane.ERROR_MESSAGE);
		}
	}
		
	public boolean loadLocal() { //loading an object from the computer
		
		boolean loaded=false;
		
		JFileChooser fc = new JFileChooser();
		int reValue=fc.showOpenDialog(null);
		
		if(reValue == JFileChooser.APPROVE_OPTION) {
			
			try(ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(fc.getSelectedFile()))) {
				
				Visualizer vis = new Visualizer();
				currentVis=vis;
				
				Result obj = (Result) objInput.readObject();
				currentRes=obj;
				currentRes.ResultList.add(currentRes);
				loaded=true;
			}
			
			catch(IOException e) {
				JOptionPane.showMessageDialog(null, "Un-readable file for the application.", "Loaded File Error", JOptionPane.ERROR_MESSAGE);
			}
			catch(ClassNotFoundException e) {
				JOptionPane.showMessageDialog(null, "Un-readable file for the application.", "Loaded File Error", JOptionPane.ERROR_MESSAGE);
			}
			
			return loaded;

		}
		
		else {
			
			return loaded;
		}
	}
	
	public void loadExternal(LoadWindow a, JComboBox b, JFrame c) throws IOException, ClassNotFoundException { //loading an object externally
		
		Socket socket = null;
		
		Requester.clientReceiveObject(socket, a, b, c);
	}	
		
	public void setFileNames(JComboBox a, ArrayList<String> b) { //setting the filenames to the JComboBox that shows which files that can be loaded externally
		
		if(a.getItemCount()>0) {
			
			a.removeAllItems();
		}
		
		for(String s:b) {
			
			a.addItem(s);
		}
	}
	
	public void setCurrentRes(Result a, JComboBox b, JFrame c) { //setting the new result-object as the currentRes object
		
		Visualizer vis = new Visualizer();
		currentVis=vis;
		
		currentRes=a;
		currentRes.ResultList.add(currentRes);
		
		createGraphs(0);
		createGraphs(1);
		createGraphs(2);
	
		addRun(b); //add run
	
		c.setVisible(true);
	}	
}	