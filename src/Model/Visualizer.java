package Model;

import java.awt.Dimension;
import java.util.ArrayList;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class Visualizer {//class for the graphs

		public static ArrayList<Visualizer> VisList = new ArrayList<Visualizer>();
	
		private ChartPanel cpBar = new ChartPanel(null);
		private ChartPanel cpRWA = new ChartPanel(null);
		private ChartPanel cpNPL = new ChartPanel(null);
	
	public Visualizer() { //adding the objects to the static list
		
		VisList.add(this);
	}
		
		
	public void createBarChart(ArrayList<Double> a, ArrayList<Double> b) { //creates the bar chart
		
		CategoryDataset dataset = createBarDataset(a,b);
		JFreeChart chart=ChartFactory.createBarChart(
	            "CAR and t1CAR",         // chart title
	            "Periods",               // domain axis label
	            "Value",                  // range axis label
	            dataset,                  // data
	            PlotOrientation.VERTICAL, // orientation
	            true,                     // include legend
	            true,                     // tooltips?
	            false );                  // URLs? 
        cpBar.setChart(chart);
        cpBar.setPreferredSize(new Dimension(500, 270));
    }
	
	public ChartPanel getBarChart() { //getter for the bar chart
		
		return cpBar;
	}
	
	public void createGraph(ArrayList<Double> a, String b, int c) { //Creates the desired graphs
		
		CategoryDataset dataset = createGraphDataset(a,b);
		JFreeChart chart = ChartFactory.createLineChart(
				b,
		        "Periods",
		        "Value",
		         dataset,
		         PlotOrientation.VERTICAL,
		         true,true,false);
		
		if(c==1) {
		
			cpRWA.setChart(chart);
			cpRWA.setPreferredSize(new Dimension(500,270));
		}
		
		if(c==2) {
			
			cpNPL.setChart(chart);
			cpNPL.setPreferredSize(new Dimension(500,270));
		}
	}
	
	//getters for the graphs
	public ChartPanel getCPRWA() {
		
		return cpRWA;
	}
	
	public ChartPanel getCPNPL() {
		
		return cpNPL;
	}
	
	public DefaultCategoryDataset createBarDataset(ArrayList<Double> a, ArrayList<Double> b) {//dataset for the bar chart
        
        String CAR = "CAR";
        String t1CAR = "t1CAR";
        
        ArrayList<String> periods=new ArrayList<String>();
        
        String p1 = "Period 1";
        String p2 = "Period 2";
        String p3 = "Period 3";
        String p4 = "Period 4";
        String p5 = "Period 5";
        
        periods.add(p1);
        periods.add(p2);
        periods.add(p3);
        periods.add(p4);
        periods.add(p5);
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        for(int i=0;i<a.size();i++) {
        	
        	dataset.addValue(a.get(i),CAR,periods.get(i));
        	
        	dataset.addValue(b.get(i), t1CAR, periods.get(i));
        }
       
        return dataset;
    }
	
	public DefaultCategoryDataset createGraphDataset(ArrayList<Double> a, String b) {
		
		ArrayList<String> periods=new ArrayList<String>();
	        
	    String p1 = "Period 1";
	    String p2 = "Period 2";
	    String p3 = "Period 3";
	    String p4 = "Period 4";
	    String p5 = "Period 5";
	        
	    periods.add(p1);
	    periods.add(p2);
	    periods.add(p3);
	    periods.add(p4);
	    periods.add(p5);
	     
	    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        for(int i=0;i<a.size();i++) {
        	
        	dataset.addValue(a.get(i),b,periods.get(i));
		}
        
        return dataset;
    }
}