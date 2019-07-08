package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

//model dialog: you can work
public class PrefsDialog extends JDialog {
	private JButton okButton;
	private JButton cancelButton;
	private JSpinner portSpinner;
	private SpinnerNumberModel spinnerModel;
	private JPasswordField passField;
	private JTextField userField;
	
		public  PrefsDialog(JFrame parent) {
			super(parent, "Prefrences", false);
			
			okButton= new JButton("Ok");
			cancelButton= new JButton("Cancel");
			
			spinnerModel= new SpinnerNumberModel(3306,0,9999,1); //Spinner min and max value
			//the number is...
			portSpinner= new JSpinner(spinnerModel);
			
			passField= new JPasswordField(10);
			userField= new JTextField(10);
			passField.setEchoChar('*');
		
			
			okButton.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					Integer value= (Integer)portSpinner.getValue();
					String user= userField.getText();
					char[] password= passField.getPassword();
					
					System.out.print("user" + user + " " + new String (password)); 
					//new String (password) -> to show the unhashed value
				} 
			});
			
			
			cancelButton.addActionListener(new ActionListener() {		
			
				public void actionPerformed(ActionEvent e) {
				setVisible(false);
					
				}
			});
			
			
			
			//adding to layout
			setLayout(new GridBagLayout());
			
			GridBagConstraints gc= new GridBagConstraints();
			
		gc.gridx=0;
		gc.gridy=0;
		gc.weightx=1;
		gc.weighty=1;
		gc.fill= GridBagConstraints.NONE;
		
		gc.gridx=0;
		add(new JLabel("port: "), gc);
		
		gc.gridx++;
		add(portSpinner, gc);
		
		
		
		//next Row
		gc.gridy++;
		gc.gridx= 0;
		add(new JLabel("User: "),gc);
		
		gc.gridx++;
		add(userField,gc);
		
		//next Row
		gc.gridy++;
		gc.gridx= 0;
		add(new JLabel("Password: "),gc);
		
		gc.gridx++;
		add(passField,gc);
		
		
		//next Row
		gc.gridy++;
		gc.gridx= 0;
		
		add(okButton, gc);
		
		gc.gridx++;
		add(cancelButton,gc);
		
		 
			
			setSize(400,300);
		}
}
