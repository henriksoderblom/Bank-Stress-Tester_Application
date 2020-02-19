package Model;

import java.util.ArrayList;

public class CountryParameters { //class for the country values
		
		private ArrayList<Double> GDPperiods=new ArrayList<Double>();
		private ArrayList<Double> dividends=new ArrayList<Double>();
		private ArrayList<Double> correlation=new ArrayList<Double>();
	
	//doesn't need to be saved, always "new"	
	
		
	//setters for the input values	
	public void setGDPperiods(ArrayList<Double> a) {
		
		GDPperiods=a;
	}
	
	public void setDividends(ArrayList<Double> a) {
		
		dividends=a;
	}
	
	public void setCorrelation(ArrayList<Double> a) {
		
		correlation=a;
	}
	
	public double getCorrelationValue(int i) {
		
		return correlation.get(i);
	}
	
	public ArrayList<Double> getGDPperiods(){
		
		return GDPperiods;
	}
	
	public ArrayList<Double> getDividends(){
		return dividends;
	}
}