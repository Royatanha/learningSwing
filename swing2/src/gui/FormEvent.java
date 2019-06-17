package gui;

import java.util.EventObject;

//every action events from Form are coming here !!!

public class FormEvent extends EventObject {

	private String name;
	private String occupation;
	
	//the list
	private int ageCategory;
	
	//the comboBox
	private String empCat;
	
	//the Checkbox
	private String taxId;
	private boolean usCitizen;
	
	//Radio Button
	private String gender;
	
	//add cunnstructor - form event Object
	public FormEvent(Object source) {
		super(source);
		
	}
	
	
	////////// Having my own cunstructor ---> have a direct relationship with Okbtn.Onclick
	
	public FormEvent(Object source, String name,String occupation, int ageCat, String empCat, boolean usCitizen, String taxId, String gender) {
		super(source);
		this.name=name;
		this.occupation=occupation;
		this.ageCategory = ageCat; 
		this.empCat= empCat;
		this.usCitizen= usCitizen;
		this.taxId= taxId;
		this.gender= gender;
	}

	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	
	public int getAgeCategory() {
		return ageCategory;
	}
	public String getEmploymentCategory() {
		return empCat;
	}


	public String getEmpCat() {
		return empCat;
	}


	public void setEmpCat(String empCat) {
		this.empCat = empCat;
	}


	public String getTaxId() {
		return taxId;
	}


	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}


	public boolean isUsCitizen() {
		return usCitizen;
	}


	public void setUsCitizen(boolean usCitizen) {
		this.usCitizen = usCitizen;
	}


	public void setAgeCategory(int ageCategory) {
		this.ageCategory = ageCategory;
	}
	
	
		
}
