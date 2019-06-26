package gui;

import javax.swing.JDialog;
import javax.swing.JFrame;

//model dialog: you can work
public class PrefsDialog extends JDialog {
		public  PrefsDialog(JFrame parent) {
			super(parent, "Prefrences", false);
			setSize(400,300);
		}
}
