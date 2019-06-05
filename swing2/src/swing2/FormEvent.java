package swing2;

import java.util.EventObject;

//every action events from Form are coming here !!!

public class FormEvent extends EventObject {

	private String name;
	private String occupation;
	
	//the list
	private int ageCategory;
	
	//the comboBox
	private String empCat;
	
	//add cunnstructor - form event Object
	public FormEvent(Object source) {
		super(source);
		
	}
	
	
	////////// Having my own cunstructor ---> have a direct relationship with Okbtn.Onclick
	
	public FormEvent(Object source, String name,String occupation, int ageCat, String empCat) {
		super(source);
		this.name=name;
		this.occupation=occupation;
		this.ageCategory = ageCat; 
		this.empCat= empCat;
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
	
	
		
}
