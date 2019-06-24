package model;

import java.io.Serializable;

public class Person implements Serializable {

	private int id;
	private static int count = 0;
	//all variables comes from FormEvent
	private String name;
	private String occupation;
	private AgeCategory ageCategory; //instead of int, we reference to AgeCategory
	private EmploymentCategory empCat; //instead String
	//the Checkbox
	private String taxId;
	private boolean usCitizen;
	//Radio Button
	private Gender gender;
	
	
	public Person(String name, String occupation, AgeCategory ageCategory, EmploymentCategory employmentCategory, String taxId,
			boolean usCitizen, Gender gender) {
		this.name=name;
		this.occupation= occupation;
		this.ageCategory= ageCategory;
		this.empCat= employmentCategory;
		this.taxId= taxId;
		this.usCitizen= usCitizen;
		this.gender= gender;
		this.id= count;
		count++;
	}
	
	//getters and setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public AgeCategory getAgeCategory() {
		return ageCategory;
	}
	public void setAgeCategory(AgeCategory ageCategory) {
		this.ageCategory = ageCategory;
	}
	public EmploymentCategory getEmpCat() {
		return empCat;
	}
	public void setEmpCat(EmploymentCategory empCat) {
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
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	
}
