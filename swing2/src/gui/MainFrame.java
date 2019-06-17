package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import com.sun.glass.events.KeyEvent;

import controller.Controller;

public class MainFrame extends JFrame {
	private JButton btn;
	private Toolbar toolbar;
	private TextPanel textPanel;
	private FormPanel formPanel;
	private JFileChooser fileChooser;
	private Controller controller; //interface between Model and Gui
	private TablePanel tablePanel;
	
	
	public MainFrame() {
		super("Hello World");
		setLayout(new BorderLayout());
		
		//******************************* Adding Components to MainFrame
		
		textPanel= new TextPanel();
		toolbar= new Toolbar();
		formPanel = new FormPanel();
		setJMenuBar(createMenuBar());
		tablePanel= new TablePanel();
		
		 
		
		//open Dialog File
		fileChooser= new JFileChooser();
		fileChooser.addChoosableFileFilter( new PersonFileFilter());
		
		//Call the Controller
		 controller= new Controller();
		//Set Data for the tablePanel
		tablePanel.setData(controller.getPeople());
		
		//toolbar.setTextPanel(textPanel); it is not healrh
		
		toolbar.setStringListener(new StringListener() {	
			public void textEmmited(String text) {
				textPanel.appendText(text);
			}
		});
	
		formPanel.setFormListener(new FormListener() {
			public void formEventOccured(FormEvent e) {			
				controller.addPerson(e);
				tablePanel.refresh(); //Refresh Table everytime a new Row added
				
			}
			
		});
			
		//add(textPanel,BorderLayout.CENTER);
		add(tablePanel,BorderLayout.CENTER);
		add(toolbar,BorderLayout.NORTH);
		add(formPanel,BorderLayout.WEST);
	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//close window
		//setSize(500, 600); because the form goes Mental
		setMinimumSize(new Dimension(500,400));
		setVisible(true);
		
	}
	
	// Create a Menu
	private JMenuBar createMenuBar() {
		JMenuBar menuBar= new JMenuBar();
		
		JMenu fileMenu= new JMenu("File"); // our Menus
		JMenu windowMenu= new JMenu("Window");
		
		
		JMenuItem exportDataItem= new JMenuItem("Export Data...");
		JMenuItem importDataItem= new JMenuItem("Import Data...");
		JMenuItem exitItem= new JMenuItem("Exit");
		
		fileMenu.add(exportDataItem);
		fileMenu.add(importDataItem);
		fileMenu.addSeparator();
		fileMenu.add(exitItem);
		
	
		//sub menu under Window
		JMenu showMenu= new JMenu("Show");
		//JMenuItem showFormItem= new JMenuItem("Person Form");
		JCheckBoxMenuItem showFormItem= new JCheckBoxMenuItem("Person Form");
		showFormItem.setSelected(true);
		showMenu.add(showFormItem);
		
		windowMenu.add(showMenu);
		
		menuBar.add(fileMenu);
		menuBar.add(windowMenu);
		
		showFormItem.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent ev) {
				JCheckBoxMenuItem menuItem= (JCheckBoxMenuItem) ev.getSource(); //check if the menu Item is Selected
				formPanel.setVisible(menuItem.isSelected()); 
				
			}
		});
		
		
		//Import Data "Using file chooser"
		importDataItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (fileChooser.showOpenDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION) {
					System.out.println("the ChosenFile is :" + fileChooser.getSelectedFile());
				}
			}
		});
		
		exportDataItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (fileChooser.showSaveDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION) {
					System.out.println("the Exported File is :" + fileChooser.getSelectedFile());
				}
			}
		});
		
		//adding Mnemonic
		fileMenu.setMnemonic(KeyEvent.VK_F); //the Mnemonic is ALT + F
		windowMenu.setMnemonic(KeyEvent.VK_W);
		//exitItem.setMnemonic(KeyEvent.VK_X);
		
		//Adding Accelator --> without opening the menu you can Close the form 
		exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
		
		//closing Window on Exit
		exitItem.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				//show input Dialog
				
				String text= JOptionPane.showInputDialog(MainFrame.this, "Enter UserName","Enter Your UserName ", JOptionPane.OK_OPTION|JOptionPane.INFORMATION_MESSAGE);
				
				System.out.println(text);
				//showing Confirm Dialog on Exit
				int action = JOptionPane.showConfirmDialog(MainFrame.this, "Are you Sure you want to Exit this Application", "Oh nein!", JOptionPane.OK_CANCEL_OPTION);
				if (action == JOptionPane.OK_OPTION) {
					System.exit(0);
				}

			}
		});
		
		
		return menuBar;
	}
}
