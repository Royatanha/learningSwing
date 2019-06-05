package swing2;

//Changing the dim in layoutManager
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
	private JComboBox empCombo;

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
		empCombo= new JComboBox();
		
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
		
		// ********** Setup ComboBox
		DefaultComboBoxModel empModel = new DefaultComboBoxModel();
		empModel.addElement("Emplyoed");
		empModel.addElement("Self-Emplyoed");
		empModel.addElement("unEmplyoed");
		empCombo.setModel(empModel);
		empCombo.setSelectedIndex(0);
		empCombo.setEditable(true);
		
		okBtn= new JButton("Ok");
		
		okBtn.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				String name= nameField.getText();
				String occupation= occupationField.getText();
				//String ageCat = (String)ageList.getSelectedValue(); //(String) because I know all the values inside list are strings
				AgeCategory ageCat= (AgeCategory)ageList.getSelectedValue();
				//event for Combobox
				String empCat= (String)empCombo.getSelectedItem();
				
				
				
				System.out.print("ageCart" + ageCat.getId());
				System.out.println("comboCat"+ empCat);
				
				FormEvent ev= new FormEvent(this, name, occupation, ageCat.getId(), empCat);
				if(formListener !=null) {
					formListener.formEventOccured(ev); //use the set
				}
			}
		});
		
		
		layoutComponents();
		
	
	}
	
	public void layoutComponents() {
		setLayout(new GridBagLayout());
		GridBagConstraints gc= new GridBagConstraints();
		
		 
		gc.fill= GridBagConstraints.NONE; //width= 100%
		
		//////////////// first Row
		gc.gridy= 0;
		
		gc.weightx= 1 ; //control how much space to relative cells
		gc.weighty= 0.1;
		
		gc.gridx= 0;
		
		gc.anchor= GridBagConstraints.LINE_END; //Justify
		gc.insets= new Insets(0, 0, 0, 5); // top left buttom right Margin!
		add(nameLable, gc);
		
		gc.gridx=1;
		gc.anchor= GridBagConstraints.LINE_START;
		gc.insets= new Insets(0, 0, 0, 0);
		add(nameField, gc);
		
		////////////// Second Row
		gc.gridy++;
		gc.weightx= 1 ; //control how much space to relative cells
		gc.weighty= 0.1;
		
		gc.gridx=0;

		gc.anchor= GridBagConstraints.LINE_END;
		gc.insets= new Insets(0, 0, 0, 5);
		add(occupationLable, gc);
		
		gc.gridx=1;
		gc.anchor= GridBagConstraints.LINE_START;
		gc.insets= new Insets(0, 0, 0, 0);
		add(occupationField, gc);
		
////////////// nexRow - list
		gc.gridy++;
		
		gc.weightx= 1 ; //control how much space to relative cells
		gc.weighty= 0.2;
		
		gc.gridx=0;
		gc.anchor=GridBagConstraints.FIRST_LINE_END;
		gc.insets= new Insets(0, 0, 0, 5);
		add(new JLabel("Age:"),gc); //produce Lable on the fly !
		
		gc.gridx=1;
		gc.anchor=GridBagConstraints.FIRST_LINE_START;
		add(ageList,gc);
		
		
//////////////nexRow - combo
	gc.gridy++;
	
	gc.weightx= 1 ; //control how much space to relative cells
	gc.weighty= 0.2;
	
	gc.gridx=0;
	gc.anchor=GridBagConstraints.FIRST_LINE_END;
	gc.insets= new Insets(0, 0, 0, 5);
	add(new JLabel("Employment:"),gc); //produce Lable on the fly !
	
	
	gc.gridx=1;
	gc.anchor=GridBagConstraints.FIRST_LINE_START;
	add(empCombo,gc);
	
		//////////// next Row
		gc.gridy++;
		
		gc.weightx= 1 ; //control how much space to relative cells
		gc.weighty= 1;
		

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
