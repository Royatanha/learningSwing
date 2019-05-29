package swing2;

//Changing the dim in layoutManager
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class FormPanel extends JPanel {
	
	private JLabel nameLable;
	private JTextField nameField;
	private JLabel occupationLable;
	private JTextField occupationField;
	private JButton okBtn;
	private FormListener formListener;
	private JList ageList;

	public FormPanel() {
		Dimension dim= getPreferredSize();
		dim.width=250; //its in pixels
		setPreferredSize(dim );
		//System.out.print(dim);
		
		Border innerBorder= BorderFactory.createTitledBorder("Add Person");
		Border outerBorder= BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder,innerBorder));
	
		
		nameLable= new JLabel("Name:");
		occupationLable= new JLabel("Occupation:");
		nameField= new JTextField(10); //number of characters
		occupationField= new JTextField(10);
		ageList = new JList();
		
		//*************************  List Box *********************
		
		DefaultListModel ageModel= new DefaultListModel();
		
		/*
		 * Before using AgeCategory Class
		 * 
		 * 
		ageModel.addElement("under 18");
		ageModel.addElement("18 to 35");
		ageModel.addElement("over 35");
		*/
		
		ageModel.addElement(new AgeCategory(0, "under 18"));
		ageModel.addElement(new AgeCategory(1, "18 to 35"));
		ageModel.addElement(new AgeCategory(2, "over 35"));
		
		
		
		ageList.setModel(ageModel);
		
		ageList.setSelectedIndex(1); //start from this index
		
		//Styling the List
		
		ageList.setPreferredSize(new Dimension(110,70));
		ageList.setBorder(BorderFactory.createEtchedBorder());

		//*******************************
		
		okBtn= new JButton("Ok");
		
		okBtn.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				String name= nameField.getText();
				String occupation= occupationField.getText();
				//String ageCat = (String)ageList.getSelectedValue(); //(String) because I know all the values inside list are strings
				AgeCategory ageCat= (AgeCategory)ageList.getSelectedValue();
				
				
				System.out.print(ageCat.getId());
				
				FormEvent ev= new FormEvent(this, name, occupation, ageCat.getId());
				if(formListener !=null) {
					formListener.formEventOccured(ev); //use the set
				}
			}
		});
		
		
		
		
		setLayout(new GridBagLayout());
		GridBagConstraints gc= new GridBagConstraints();
		
		 
		gc.fill= GridBagConstraints.NONE; //width= 100%
		
		//////////////// first Row
		gc.weightx= 1 ; //control how much space to relative cells
		gc.weighty= 0.1;
		
		gc.gridx= 0;
		gc.gridy= 0;
		gc.anchor= GridBagConstraints.LINE_END; //Justify
		gc.insets= new Insets(0, 0, 0, 5); // top left buttom right Margin!
		add(nameLable, gc);
		
		gc.gridx=1;
		gc.gridy=0;
		gc.anchor= GridBagConstraints.LINE_START;
		gc.insets= new Insets(0, 0, 0, 0);
		add(nameField, gc);
		
		////////////// Second Row
		gc.weightx= 1 ; //control how much space to relative cells
		gc.weighty= 0.1;
		
		gc.gridx=0;
		gc.gridy=1;
		gc.anchor= GridBagConstraints.LINE_END;
		gc.insets= new Insets(0, 0, 0, 5);
		add(occupationLable, gc);
		
		gc.gridx=1;
		gc.gridy=1;
		gc.anchor= GridBagConstraints.LINE_START;
		gc.insets= new Insets(0, 0, 0, 0);
		add(occupationField, gc);
		
//////////////Third Row
		gc.weightx= 1 ; //control how much space to relative cells
		gc.weighty= 0.2;
		gc.gridy=2;
		gc.gridx=1;
		gc.anchor=GridBagConstraints.FIRST_LINE_START;
		add(ageList,gc);
	
		//////////// Forth Row
		
		gc.weightx= 1 ; //control how much space to relative cells
		gc.weighty= 2.0;
		gc.gridy=3;
		gc.gridx=1;
		gc.anchor=GridBagConstraints.FIRST_LINE_START;
		add(okBtn,gc);
	}
	
	public void setFormListener(FormListener listener) {
		this.formListener= listener;
		
	}
}


//Adding a untility for the Listbox
class AgeCategory {
	private int id;
	private String text; 
	
	public AgeCategory(int id , String text) {
		
		this.id= id;
		this.text= text;	
	}

//adding this to have out text 
	
	public String toString() {
		return text;
	}
	
	public int getId() {
		return id;
	}
}
