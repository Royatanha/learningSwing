package swing2;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

// Java.Lang.Object with public Main

public class App {

	public static void main(String[] args) {
		//////// Hello World Project 
		/*
		JFrame fram= new JFrame("Hello world");
		fram.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//close window
		fram.setSize(500, 600);
		fram.setVisible(true);
		*/
		
		SwingUtilities.invokeLater(new Runnable() {
			
			public void run() {
				new MainFrame();
				
			}
		});
	}

}
