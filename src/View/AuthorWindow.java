package View;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class AuthorWindow extends JFrame {//the author winodw, no actionlisteners

	public AuthorWindow(){ 
		
		super("About the authors");
		
		setSize(400,500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		String text= "Henrik Söderblom is a physics student at Åbo Akademi University with extreme skills in programming as you can see." + "\n"
					+ "\n" +  "Oscar Cavonius is an economy student at Åbo Akademi University that also possess programming skills but is famous for this quote: I hope one day I can be as good at programming as Henrik Söderblom the programming master.";
				
		Font f = new Font("Verdana",Font.PLAIN,15);

		JTextArea textArea=new JTextArea();
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		
		textArea.setText(text);
		textArea.setFont(f);
		add(textArea);
		
		setVisible(false);
	}
}