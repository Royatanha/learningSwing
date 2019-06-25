package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.Person;

public class TablePanel extends JPanel {
	private JTable table;
	private PersonTableModel tableModel; //the AbstractTableModel
	private JPopupMenu popup;
	
	public TablePanel () {
		
		tableModel= new PersonTableModel();
		
		table= new JTable(tableModel);
		
		popup= new JPopupMenu();
		JMenuItem removeItem= new JMenuItem("Delete Row");
		popup.add(removeItem);
		
		//show popup on right Click
		table.addMouseListener(new MouseAdapter() {

			//rclick - source -> overrride, implement Method
			@Override
			public void mousePressed(MouseEvent e) {
				
				int row=table.rowAtPoint(e.getPoint());
				table.getSelectionModel().setSelectionInterval(row, row); //To select that Row on MouseClick
				
				if(e.getButton() == MouseEvent.BUTTON3) {
					popup.show(table, e.getX(), e.getY());
					
					
				}
			}
			
		});
		
		removeItem.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				int row= table.getSelectedRow();
				System.out.println(row);
				
			}
		});
		
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
