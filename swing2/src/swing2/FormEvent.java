package swing2;

import java.util.EventObject;

//every action events are coming here !!!
public class FormEvent extends EventObject {

	private String name;
	private String occupation;
	
	//the list
	private int ageCategory;
	
	//add cunnstructor - form event Object
	public FormEvent(Object source) {
		super(source);
		
	}
	
	
	////////// Having my own cunstructor
	
	public FormEvent(Object source, String name,String occupation, int ageCat) {
		super(source);
		this.name=name;
		this.occupation=occupation;
		this.ageCategory = ageCat; 
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
	
	
		
}
