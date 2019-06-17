package controller;

import java.util.List;

import gui.FormEvent;
import model.AgeCategory;
import model.Database;
import model.EmploymentCategory;
import model.Gender;
import model.Person;

public class Controller {

	Database db= new Database();
	
	public List<Person> getPeople() {
		return db.getPeople(); //to get people and show them on the Table
	}
	
	public void addPerson(FormEvent e) {
		String name= e.getName();
		String occupation= e.getOccupation();
		int ageCat = e.getAgeCategory();
		String empCat= e.getEmploymentCategory();
		String taxId= e.getTaxId();
		boolean usCitizen= e.isUsCitizen();
		String gender= e.getGender();
		
		AgeCategory ageCategory = null;
		switch (ageCat) {
		case 0:
			ageCategory= AgeCategory.child; //return the child with this Int
			break;
		case 1:
			ageCategory= AgeCategory.adult; //return the child with this Int
			break;
		case 2:
			ageCategory= AgeCategory.senior; //return the child with this Int
			break;
		}
		
		// *********** Age Category ---> can't use Case because its a String
		
		EmploymentCategory empCategory;
		
		if(empCat.equals("Emplyoed")) {
		
			empCategory= EmploymentCategory.employed;
		}
		
		else if(empCat.equals("Self-Emplyoed")) {
			empCategory= EmploymentCategory.selfEmployed;
		}
		
		else if(empCat.equals("UnEmplyoed")) {
			empCategory= EmploymentCategory.unEmployed;
		}
		else  {
			empCategory= EmploymentCategory.other;
			System.err.println("Error on employee"  + empCat);
		}
		
		
		
		Gender genderCat;
		if(gender.equals("male")) {
			genderCat= Gender.male;
		}
		else if(gender.equals("female")){
			genderCat= Gender.female;
		}
		else {
			genderCat= Gender.other;
		}
	
		Person person= new Person(name,occupation, ageCategory,empCategory, taxId, usCitizen, genderCat);
		db.addPerson(person);
		System.out.println("successfully added to DB");
		
		//textPanel.appendText( "\n" +"name: "+ name + "\n" + "occupation:" + occupation + "\n" + "AgeCategory" + ageCat +  "\n" + "Employment: " + empCat +  "\n" + "Tax ID: " + taxId +  "\n" + "Gender: " + gender );
		
	}
}
