package Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Bank { //class for the bank values

		private ArrayList<String> ListValues = new ArrayList<String>();
		private ArrayList<String> BoxValues = new ArrayList<String>();
		public static  ArrayList<Bank> BankList = new ArrayList<Bank>();
		private String name;
		
		//step 1
		private double cr;
		private double rw;
		private double loans;
		private double npl;
		private double assets;
		private double equity;
		private double profit;
		private double dividend;
		private double t2capital;
		private double t1fix;
		private double t2fix;
		private double capital;
		private double t1capital;
		
		
	public Bank(String a){ //adding bank to the static list
		BankList.add(this);
		name=a;
	}
	
	public boolean setFileValue(File a) { //reads and saves the file values to a list
		
		boolean controll=true;
		
		try {
			
			FileReader fr = new FileReader(a);
			BufferedReader in = new BufferedReader(fr);
			String inputLine;
			
			while ((inputLine = in.readLine()) != null) 
				ListValues.add(inputLine);
			in.close();
		}
		
		catch(FileNotFoundException ex) {
			JOptionPane.showMessageDialog(null, "Please check your Bank-File.", "Bank-File Error", JOptionPane.ERROR_MESSAGE);
			controll=false;
		}  
        catch(IOException ex) {
			JOptionPane.showMessageDialog(null, "Please check your Bank-File.", "Bank-File Error", JOptionPane.ERROR_MESSAGE);
			controll=false;
        }                  
		catch(NullPointerException ex) {
			JOptionPane.showMessageDialog(null, "Please check your Bank-File.", "Bank-File Error", JOptionPane.ERROR_MESSAGE);
			controll=false;
		}
		
		try {
			cr=Double.parseDouble(ListValues.get(0));
			
			if(Double.parseDouble(ListValues.get(1))<0 || Double.parseDouble(ListValues.get(1))>1.5) {
				
				controll=false;
			}
			
			rw=Double.parseDouble(ListValues.get(1));
			loans=Double.parseDouble(ListValues.get(2));
			npl=Double.parseDouble(ListValues.get(3));
			equity=Double.parseDouble(ListValues.get(4));
			profit=Double.parseDouble(ListValues.get(5));
			dividend=Double.parseDouble(ListValues.get(6));
			t2capital=Double.parseDouble(ListValues.get(7));
		}
		
		catch(IndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(null, "Please check your Bank-File.", "Bank-File Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Please check your Bank-File.", "Bank-File Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return controll;
		
	} //getters
	
	public double getLoans() {
		
		return loans;
	}
	
	public double getNPL() {
		
		return npl;
	}
	
	public String getBankName() {
		return name;
	}
	
	public double getCR() {
		return cr;
	}
	
	public double getRW() {
		return rw;
	}
	
	public double getEquity() {
		return equity;
	}
	
	public double getProfit() {
		return profit;
	}
	
	public double getDividend() {
		return dividend;
	}
	
	public double getT2capital() {
		return t2capital;
	}
}