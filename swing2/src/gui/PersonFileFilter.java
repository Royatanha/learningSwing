package gui;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class PersonFileFilter extends FileFilter {

	
	public boolean accept(File file) {
		
		if( file.isDirectory()) {
			return true;
			//always show a Folder Content
		}
		String name= file.getName();
		
		String extention= Utils.getFileExtention(name);
		if(extention== null) {
			return false;
		}
		if (extention.equals("per")){
			return true;
		}
		return false;
	}

	@Override
	public String getDescription() {
		return "Person Database Files (*.per)";
	}

}
