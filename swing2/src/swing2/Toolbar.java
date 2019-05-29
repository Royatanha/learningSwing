package swing2;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Toolbar extends JPanel implements ActionListener {
		
	private JButton helloBtn;
	private JButton byeBtn;
	//private TextPanel textPanel;
	private StringListener textListener; //adding our interface
	
	public Toolbar() {
		
		helloBtn= new JButton("Hi");
		byeBtn= new JButton("Bye");
		helloBtn.addActionListener(this);
		byeBtn.addActionListener(this);
		
		
		setBorder(BorderFactory.createTitledBorder(""));
		
		//textPanel= new TextPanel();
		
		//setLayout(new FlowLayout());#
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		add(helloBtn);
		add(byeBtn);
		
		}
	
	/*public void setTextPanel(TextPanel textPanel) {
		this.textPanel=textPanel; 
		
	}	//////////////// it is not healthy to have this
	*/
	
	//Reminder to use the StringListener Interface
	public void setStringListener(StringListener listener) {
		this.textListener=listener;
	} 
	

	public void actionPerformed(ActionEvent e) {
			JButton clicked= (JButton)e.getSource();
		
			if (clicked== helloBtn) {
			if(textListener !=null) {
				textListener.textEmmited("This is Hello from Interface\n");
			}
	}
	
		
		else if (clicked==byeBtn) {
		if(textListener !=null) {
			textListener.textEmmited("Sayunara\n");
		}

	}
	
	}
	
	
}
