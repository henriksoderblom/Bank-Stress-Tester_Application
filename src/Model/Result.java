package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Result implements Serializable { //class for the calculated results
	
		public static ArrayList<Result> ResultList = new ArrayList<Result>();
	
		private double NPLR1;
	
		private ArrayList<Double> NPLR = new ArrayList<Double>();
		private ArrayList<Double> NPL = new ArrayList<Double>();
		private ArrayList<Double> prov = new ArrayList<Double>();
		private ArrayList<Double> RWA  =new ArrayList<Double>();
		private ArrayList<Double> equity = new ArrayList<Double>();
		private ArrayList<Double> t1capital = new ArrayList<Double>();
		private ArrayList<Double> totalcapital = new ArrayList<Double>();
		private ArrayList<Double> CAR = new ArrayList<Double>();
		private ArrayList<Double> t1CAR = new ArrayList<Double>();

	public Result() { //adding the results to the static list
		
		ResultList.add(this);
	}
	
	public void NPLRfkt(double a,double b) {
		
		NPLR1=(b/a)*100;
	}
	
	public void NPLestimator(double a, double b, double c, double d, ArrayList<Double> e, int f, double g,double h) {
		
		Double NPLRvalue=NPLR1;
		
		for(int i=1; i<e.size();i++) {
			
			NPLRvalue=a + (c*NPLRvalue) + (d*e.get(i))+(b*f);
			NPLRvalue=Math.exp(NPLRvalue);
		
			NPLR.add(NPLRvalue);
		}
		
		NPL.add(h);
		
		for(int i=0;i<NPLR.size();i++) {
			
			NPL.add((g*NPLR.get(i))/100);
		}
	}
	
	public void provestimator(double a) {
		
		for(int i=0;i<NPL.size();i++) {
			
			prov.add(a*NPL.get(i));
		}
	}
	
	public void RWAestimator(double a, double b) {
		
		double RWAvalue=(a*b);
		
		for(int i=1;i<NPL.size();i++) {
			
			RWAvalue=RWAvalue-b*(NPL.get(i)-NPL.get(i-1));
		
			RWA.add(RWAvalue);
		}
	}
	
	public void equityestimator(double a, double b,double d, ArrayList<Double> c) {
		
		double equityvalue = a-d + b;
		equity.add(equityvalue);
		
		for(int i=0;i<c.size();i++) {
			
			equityvalue=equityvalue-(c.get(i)*b) + b;
			
			equity.add(equityvalue);
		}
		
		
		double t1capitalvalue1=equity.get(0)-d-prov.get(0);
		t1capital.add(t1capitalvalue1);
		
		for(int i=1;i<equity.size();i++) {
			
			double t1capitalvalue = equity.get(i)-c.get(i-1)*b-prov.get(i);
			
			t1capital.add(t1capitalvalue);
		}
	}
	
	public void totalcapitalestimator(double a) {
		
		for(double s:t1capital) {
			
			totalcapital.add(a+s);
		}
		
		for(int i=0;i<RWA.size();i++) {
			
			CAR.add(totalcapital.get(i+1)/RWA.get(i));
		}
		
		for(int i=0;i<RWA.size();i++) {
			
			t1CAR.add(t1capital.get(i+1)/RWA.get(i));
		}
		
		NPL.remove(0);
		
	}
	
	
	
	//getters
	public ArrayList<Double> getCAR() {
		
		return CAR;
	}
	
	public ArrayList<Double> gett1CAR() {
		
		return t1CAR;
	}
	
	public ArrayList<Double> getRWA() {
		
		return RWA;
	}
	
	public ArrayList<Double> getNPL() {
		
		
		return NPL;
	}
	
	public ArrayList<Double> getNPLR() {
		
		return NPLR;
	}

	public ArrayList<Double> getProv() {
	
		return prov;
	}

	public ArrayList<Double> getEquity() {
	
		return equity;
	}
	
	public ArrayList<Double> gett1Capital() {
		
		return t1capital;
	}
	
	public ArrayList<Double> getTotalCapital() {
		
		return totalcapital;
	}
	
	public String sendAllValues() {
		
		String values="NPLR" + "\n" + "\n";
		
		for(double s:NPLR) {
			
			values += s + "\n";
		}
		
		values+= "\n" + "NPL" + "\n" + "\n";
		
		for(double s:NPL) {
			
			values += s + "\n";
		}
		
		values += "\n" + "Provision" + "\n" + "\n";
		
		for (double s:prov) {
			
			values += s + "\n";
		}
		
		values += "\n" + "RWA" + "\n" + "\n";
		
		for (double s:RWA) {
			
			values += s + "\n";
		}
		
		values += "\n" + "Equity" + "\n" + "\n";
		
		for (double s:equity) {
			
			values += s + "\n";
		}
		
		values += "\n" + "T1 Capital" + "\n" + "\n";
		
		for (double s:t1capital) {
			
			values += s + "\n";
		}
		
		values += "\n" + "Total Capital" + "\n" + "\n";
		
		for (double s:totalcapital) {
			
			values += s + "\n";
		}
		
		values += "\n" + "CAR" + "\n" + "\n";
		
		for (double s:CAR) {
			
			values += s + "\n";
		}
		
		values += "\n" + "T1 CAR" + "\n" + "\n";
		
		for (double s:t1CAR) {
			
			values += s + "\n";
		}
		
		return values;
	} 
}