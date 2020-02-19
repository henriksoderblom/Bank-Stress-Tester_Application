package View;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class LeftPanel extends JPanel{ //the left panel for the RunWindow

	LeftPanel(){

		Dimension size = getPreferredSize();
		size.width= 600;
		size.height = 950;
		setPreferredSize(size);

	
		setBorder(BorderFactory.createTitledBorder("Charts"));
		setLayout(new GridBagLayout());
   }	
}
