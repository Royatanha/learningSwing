package gui;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.Person;

public class TablePanel extends JPanel {
	private JTable table;
	private PersonTableModel tableModel; //the AbstractTableModel
	
	public TablePanel () {
		
		tableModel= new PersonTableModel();
		
		table= new JTable(tableModel);
		
		setLayout(new BorderLayout());
		add(new JScrollPane(table), BorderLayout.CENTER);
	}
	
public void setData(List<Person> db) {
	tableModel.setData(db);
}

//Refresh panel everytime the db changes
public void refresh() {
	tableModel.fireTableDataChanged();
}
}
