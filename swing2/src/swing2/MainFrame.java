package swing2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MainFrame extends JFrame {
	private JButton btn;
	private Toolbar toolbar;
	private TextPanel textPanel;
	private FormPanel formPanel;
	
	
	
	public MainFrame() {
		super("Hello World");
		setLayout(new BorderLayout());
		
		//******************************* Adding Components to MainFrame
		
		textPanel= new TextPanel();
		toolbar= new Toolbar();
		formPanel = new FormPanel();
		
		//toolbar.setTextPanel(textPanel); it is not healrh
		
		toolbar.setStringListener(new StringListener() {	
			public void textEmmited(String text) {
				textPanel.appendText(text);
			}
		});
	
		formPanel.setFormListener(new FormListener() {
			public void formEventOccured(FormEvent e) {
				String name= e.getName();
				String occupation= e.getOccupation();
				int ageCat = e.getAgeCategory();
				
				textPanel.appendText("name: "+ name + "\n" + "occupation:" + occupation + "\n" + ageCat);
			}
			
		});
			
		add(textPanel,BorderLayout.CENTER);
		add(toolbar,BorderLayout.NORTH);
		add(formPanel,BorderLayout.WEST);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//close window
		setSize(500, 600);
		setVisible(true);
		
	}
}
