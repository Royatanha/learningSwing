package swing2;

import java.awt.BorderLayout;

// a JPanel for the Text Area in the Center of the middle

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TextPanel extends JPanel {
	
	private JTextArea textArea;
	
	public TextPanel() {
	
		textArea= new JTextArea();
		setLayout(new BorderLayout());
		add(new JScrollPane(textArea),BorderLayout.CENTER); //Adding scrollbar to the Textarea  --- in Textpanel JPanel
		
	}
	
	//definind a function to aapend text to this textArea on buttonClick
	
	public void appendText(String text) {
		textArea.append(text);
	}
	
	
}
