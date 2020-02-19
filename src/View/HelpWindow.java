package View;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class HelpWindow extends JFrame { //help windwow, no functions

	public HelpWindow(){ 
		super("Help");
		
		setSize(800,1000);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		String text="Welcome to Stress tester 1.0.0.\r\n\n" + 
				"This is an application designed for stress testing banks. The structure of the test is based on the guidelines provided by Martin Cihak in IMF’s book “A guide to IMF stress testing”. The basic principle is quite simply but can be very complex based on the amount of data and variables one likes to use. In this software the test is somewhat simplified but still gives quite a good approximation of the robustness of the bank the tester wants to test. The software is designed for users with an intermediate understanding of econometrics and finance.  \r\n\n" + 
				"1. What is a stress test?\r\n\n" + 
				"A stress test is a test designed to test the robustness of a bank. In other words, it is a test designed to find out how well (in theory) a bank is prepared for unexpected losses, usually in the form of loan losses. Loan losses are losses caused by people who have taken loans from a bank and no longer are able to repay their loans. \r\n\n" + 
				"2. The design of this test\r\n\n" + 
				"This test simulates a scenario where the macroeconomic conditions in the form of a change in the GDP (gross-domestic product) in a country affects the amount of so called non-performing loans or NPLs. NPLs are loans that can no longer be repaid by the borrowers and will therefore cause losses for the lender (the bank). In short the change in GDP causes a change in the amount of NPLs, which then affects the bank’s capital adequacy ratio, or CAR. The CAR is the measure in which the banks robustness is measured. A good CAR is in most EU-countries seen to be no less than 8 percent. These means that a bank that goes below this threshold in theory is insolvent. \r\n" + 
				"\r\n" + 
				"3. The variables\r\n\n" + 
				"The variables used in this software are the following. \r\n" + 
				"Coverage ratio: This ratio represents how much assets are “set aside” by the bank to prepare for future losses.\r\n" + 
				"Risk weight: The risk weight of a certain loan. Is used to calculate the risk weighted assets of a bank. \r\n" + 
				"GDP growth: The gross domestic product of the country in which the bank exists. \r\n" + 
				"Total loans: The total amount of loans the bank has given to the public\r\n" + 
				"NPL: Non-performing loans. Loans that no longer are generating an income for the bank.\r\n" + 
				"Assets: The total assets according to the banks’ balance sheet in the starting period\r\n" + 
				"Equity: The equity of the bank in the starting period\r\n" + 
				"Profit: The profit of the bank in the starting period\r\n" + 
				"Provisions: Provisions are assets that are put to side to prepare for future unexpected losses\r\n" + 
				"CET1: The capital adequacy ratio of tier 1 capital\r\n" + 
				"CET2: The capital adequacy ratio of tier 2 capital\r\n" + 
				"CAR: The capital adequacy ratio of total capital. The capital adequacy ratio is calculated by dividing the banks total capital with its risk weighted assets. \r\n" + 
				"GDP corr: The correlation coefficient between GDP growth and NPLR in the country where the tested bank is located. \r\n" + 
				"NPL corr: Correlation between NPLs in period t and period t-1. \r\n" + 
				"CON: the constant in the econometric equation that is the foundation for the estimation process. \r\n" + 
				"\r\n" + 
				"\r\n" + 
				"There are some less important variables that are used in the background of this software but are not mentioned in this list.\r\n" + 
				"\r\n" + 
				"4. User guide\r\n\n" + 
				"This section tells the user how to use stress tester. \r\n" + 
				"Getting started: There are quite a lot of fields that needs to be filled by the user for the test to work. This guide will step by step go through the different steps that needs to be taken. \r\n" + 
				"Step 1, filling the estimated GDP growth: In the first section of the interface there are 5 fields in the row named Growth estimate in period. In these fields the user will fill in the estimated GDP growth values for the country in which the bank that will be tested is located. For example, the values for Finland might be 1,9 percent in year 2019 (period 1). These values can either be predicted by the tester using econometrics or they can be the values estimated by the central bank in Finland or some other reliable source. This row is also where the tester can test different scenarios. For example, one might want to test a scenario where the GDP in period 3 is negative by 2 percent or some other scenario.\r\n" + 
				"Step 2, dividend in period: In this section the tester will put int the number of dividends that the bank will pay in each period. This value needs to be between 0 and 1 since it is a ratio of the profit. A bank cannot of course pay more dividends than it has profit. The dividend policy might also change when times get rougher and therefore the tester can take this into account by manipulating the dividend payment factor in each period. \r\n" + 
				"Step 3, the entity effect: Some countries has something called an entity effect that either dampens of strengthens the effect of an economic scenario. This effect is provided as a parameter in the next step into this software and the tester can only choose between using it or not to test for different scenarios. \r\n" + 
				"Step 4, the parameters: To simulate the change in NPLs in the bank the software demands four critical parameters. NPL-GDP correlation, NPL-NPLt-1 correlation, entity dummy and constant. All of these parameters need to be separately estimated statistically by the user with the help of a bigger set of data. These values are crucial for the reliability of the entire test.\r\n" + 
				"Step 5 add bank: to get the bank specific data the user can simply choose a csv file with the data and upload it into the software or create it via the application. However, it is important that the csv file is constructed properly before it is uploaded (See section 5, the csv file). The user can also upload multiple banks into the software and then switch between these to test for different banks with the same initial calibration. \r\n" + 
				"Step 5, press go: In this step all the calculations are run based on the inputs the tester has done. The software starts with estimating the change in NPLs for the selected bank. After that it calculates the new CAR values which then are presented graphically. \r\n\n" + 
				"5. The CSV file\r\n\n" +  "The CSV file needs to include the following data in the following order (top to bottom). Coverage ratio (as a percentage, for 0.45 or 1.10), practically no restrictions. Risk weight (as a fraction between 0 and 1.5). Total loans (in millions). Non-performing loans (in millions). Equity (in millions). Profit (in millions), dividends (in millions) and tier2 capital (also in millions). It is very important that these variables are in this particular order from top to bottom.\r\n" + 
				"\r\n" + 
				"6. Settings\r\n\n" +
				"In Settings the user can add values to establish a connection to an external server. It is important that all of this values are correctly inserted or the connection won't work. Remember that the server that receives these values has to understand the object that is being sent, in other words, the server must have the Result-class as an external jar.\r\n\n"
				+ "7. Errors\r\n\n" + "Error messages will appear when the application is run wrongly. There is a short explanation of what is wrong and the application should be able to continue working normally after an error message.";
		
		Font f = new Font("Verdana",Font.PLAIN,15);

		JTextArea textArea=new JTextArea();
		
		JScrollPane scroll = new JScrollPane(textArea);
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		
		textArea.setText(text);
		textArea.setFont(f);
		add(scroll);
		
		setVisible(false);
	}
}