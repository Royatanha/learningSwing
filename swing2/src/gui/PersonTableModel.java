package gui;

import java.util.List;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import model.Person;

public class PersonTableModel extends AbstractTableModel {
	
	//************Create a cunstructor
	private List<Person> db;

	public PersonTableModel( ) {
		//this.db= db;
	}
	 
	public void setData(List<Person> db) {
		this.db= db;
	}
	
	
	//*****************************************
	
	//--- Rclick / overright implemented method to make a Header for the Table
	
	private String[] colNames= {"ID","Name", "Occupation" , "Age Category" , "Employment Status", "Us Citizen?", "Tax ID", "Gender"};
	
	 @Override
		public String getColumnName(int column) {
			// TODO Auto-generated method stub
			return colNames[column];
		}
	 

	
	// its a wrapper for my Data to show the Data
	public int getColumnCount() {

		return 8; //size of the person fields
	}


	public int getRowCount() {
	
		return db.size();
	}

//Use this to show the Table values:
	
	public Object getValueAt(int row, int col) {
		Person person= db.get(row);
		
		switch (col) {
		case 0:
			return person.getId();
		case 1:
			return person.getName();
		case 2:
			return person.getOccupation();
		case 3:
			return person.getAgeCategory();
		case 4:
			return person.getEmpCat();
		case 5:
			return person.isUsCitizen();
		case 6:
			return person.getTaxId();
		case 7:
			return person.getGender();
		}
		return null;
	}
	
}
