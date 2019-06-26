package model;

import java.io.FileOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class Database {
	
	//private ArrayList<Person> people;
	private List<Person> people; // Linkedlist is optimized to add and remove the list objects
	
	public Database() {
		//people= new ArrayList<Person>();
		people= new LinkedList<Person>();
	}
	
	public void addPerson(Person person) {
		people.add(person);
	}
	
	public void removePerson(int index) {
		people.remove(index); //remove people based on their index
	}
	
	public List<Person> getPeople() {
		return Collections.unmodifiableList(people); //prevent other Classes to modify the List -> for forcing to have a clear Data Row
	}
	
	// Saving the array List of People to a File 
	
	public void saveToFile(File file) throws IOException {

		FileOutputStream fos= new FileOutputStream(file);
		ObjectOutputStream oos= new ObjectOutputStream(fos);
		
		//writing an arrayList for the File
		Person[] persons= people.toArray(new Person[people.size()]);
		oos.writeObject(persons);
		
		oos.close();
	}
	
	public void loadFromFile(File file) throws IOException {
		FileInputStream fis= new FileInputStream(file);
		ObjectInputStream ois= new ObjectInputStream(fis);
		
		//store Array from a file
		try {
			Person[] persons= (Person[])ois.readObject();
			
			people.clear();
			
			people.addAll(Arrays.asList(persons));
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ois.close();
		
	}

}
