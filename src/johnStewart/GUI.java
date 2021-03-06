package johnStewart;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

public class GUI extends JFrame {
	
	JFrame frame;
	static JPanel panel;
	static JPanel middle;
	static JComboBox<String> options;
	static JTextField text;
	JButton button;
	JButton reset;
	JButton edit;
	JButton saving;
	JButton insert;
	JButton delete;
	JButton export;
	JButton importB;
	static String type = new String();
	static String input = new String();
	static String editedName = new String();
	static String newName = new String();
	static String newAccountant = new String();
	static String newAp = new String();
	static String newRm = new String();
	static String newOwner = new String();
	static String newReviewer = new String();
	static String newDueDate = new String();
	static String newNotes = new String();
	static String newAddress = new String();
	static String newBack = new String();
	static String newPhone = new String();
	static String newPm = new String();
	static String newUnits = new String (); //changed
	static String deleteName = new String();
	static String deleteDesc = new String();
	static String userInput = new String();
	static String root = new String();
	static String location = new String();
	static int row;
	static int col;
	static int deleteRow;
	static int deleteRowCopy;
	static ArrayList<Integer> recordingCopy;
	static Boolean check = false;
	static Boolean currGrid = false;
	static propertyOrganizer obj;
	static Property newProperty;
	static JScrollPane scrollPane;
	static JTable grid;
	static Boolean colCheck = true;
	String[][] array;
	static String[] columnNames = {"Property", "Accountant", "AP", "RM", "Owner", "Reviewer", "Due Date", 
			"Notes", "Address", "Back-Up", "Phone Number", "Property Manager", "Units"};
	
	public GUI() {
		//buffer for the button actions
	}
	
	public GUI(String fileName) {
		panel = new JPanel();
		middle = new JPanel();
		obj = new propertyOrganizer();
		//obj.populateData(fileName);
	}
	
	public void update() {
		type = (String) options.getSelectedItem();
		input = text.getText();
	}
	
	public String getCategory() {
		return type;
	}
	
	public String getInput(){
		return input;
	}
	
	public String getEditedName() {
		return editedName;
	}
	
	public int getRow() {
		return row;
	}
	
	public int getCol() {
		return col;
	}
	//gets desired row for deletion
	public int deleteRow() {
		return deleteRow;
	}
	
	//checks that the edit is valid
	public Boolean getCheck() {
		return check;
	}
	
	public Boolean getCurrGrid() {
		return currGrid;
	}
	
	public Property getNewProperty() {
		return newProperty;
	}
	
	//confirms the deletion
	public String getUserInput() {
		return userInput;
	}
	
	public String getRoot() {
		return root;
	}
	
	public String getFileLocation() {
		return location;
	}
	//get
	public void shortenGrid(Integer[] temp) {
		recordingCopy = new ArrayList<Integer>();
		for (int i = 0; i < temp.length; i++) {
			recordingCopy.add(temp[i]);
		}
		currGrid = true;
	}
	
	public ArrayList<Integer> getRecordingCopy() {
		return recordingCopy;
	}
	
	public void addCombo() {
		options = new JComboBox<String>();
		options.addItem("Accountant");
		options.addItem("AP");
		options.addItem("RM");
		options.addItem("Owner");
		options.addItem("Reviewer");
		options.addItem("Property");
		options.setVisible(true);
		type = (String) options.getSelectedItem();
		panel.add(options);
	}
	
	public void addTextField() {
		text = new JTextField(20);
		text.setMaximumSize(new Dimension(200, 50));
		text.setVisible(true);
		input = text.getText();
		panel.add(text);
	}
	
	public void addButton() {
		button = new JButton("Enter");
		button.setMaximumSize(new Dimension(200, 50));
		button.setVisible(true);
		
		button.addActionListener(new MyAction());
		panel.add(button);
	}
	
	public void addTable() {
		array = new String[obj.list.size()][13]; //changed
		
		for (int i = 0; i < obj.list.size(); i++) {
			for (int k = 0; k < 13; k++) { //changed
				if (k == 0) {
					array[i][k] = obj.list.get(i).getName();
				}
				else if (k == 1) {
					array[i][k] = obj.list.get(i).getAccountant();
				}
				else if (k == 2) {
					array[i][k] = obj.list.get(i).getAp();
				}
				else if (k == 3) {
					array[i][k] = obj.list.get(i).getRm();
				}
				else if (k == 4) {
					array[i][k] = obj.list.get(i).getOwner();
				}
				else if (k == 5) {
					array[i][k] = obj.list.get(i).getReviewer();
				}
				else if (k == 6) {
					array[i][k] = obj.list.get(i).getDueDate();
				}
				else if (k == 7) {
					array[i][k] = obj.list.get(i).getNotes();
				}
				else if (k == 8) {
					array[i][k] = obj.list.get(i).getAddress();
				}
				else if (k == 9) {
					array[i][k] = obj.list.get(i).getBack();
				}
				else if (k == 10) {
					array[i][k] = obj.list.get(i).getPhone();
				}
				else if (k == 11) {
					array[i][k] = obj.list.get(i).getPm();
				}
				else if (k == 12) {
					array[i][k] = obj.list.get(i).getUnits(); //changed
				}
				
			}
		}
		setLayout(new BorderLayout());
		
		grid = new JTable(array, columnNames);
		grid.setRowHeight(30);
		//adds the headers to the columns
		if (colCheck) {
			middle.add(grid.getTableHeader(), BorderLayout.NORTH); //North
			colCheck = false;
		}
		grid.setPreferredScrollableViewportSize(new Dimension(1000, 300));
		grid.setFillsViewportHeight(true);
		scrollPane = new JScrollPane(grid);
		//added the scrollPane instead of the grid
		middle.add(scrollPane);
	}
	
	public void updateTable(String[][] temp) {
		//removes the grid from panel
		//middle.remove(grid);
		grid = new JTable(temp, columnNames);
		//back to normal size
		//currGrid = false;
		middle.removeAll();
		colCheck = true;
		
		if (colCheck) {
			middle.add(grid.getTableHeader(), BorderLayout.NORTH); //North
			colCheck = false; 
		}
		grid.setPreferredScrollableViewportSize(new Dimension(1000, 300));
		grid.setFillsViewportHeight(true);
		grid.setRowHeight(30);
		scrollPane = new JScrollPane(grid);
		//adds a selective table
		middle.add(scrollPane);
		insertButton();
		deleteButton();
		editButton();
		saveButton();
		
		
		//adds the grid to panel
		//middle.add(grid);
		//updates the table
		middle.repaint();
		//lets the program know that changes were made
		middle.revalidate();
		
	}
	
	public void resetButton() {
		reset = new JButton("Reset");
		reset.setMaximumSize(new Dimension(200, 50));
		reset.setVisible(true);
		
		reset.addActionListener(new ResetAction());
		panel.add(reset);
	}
	
	public void resetGrid() {
		//middle.remove(grid);
		//middle.invalidate();
		middle.removeAll();
		colCheck = true;
		//back to normal size
		currGrid = false;
		addTable();
		insertButton();
		deleteButton();
		editButton();
		saveButton();
		middle.repaint();
		middle.revalidate();
	}
	
	public void editButton() {
		edit = new JButton("Edit");
		edit.setMaximumSize(new Dimension(200, 50));
		edit.setVisible(true);
		edit.addActionListener(new EditAction());
		middle.add(edit, BorderLayout.SOUTH); //changed to panel
	}
	
	public void editGrid() {
		col = grid.getSelectedColumn();
		row = grid.getSelectedRow();
		editedName = JOptionPane.showInputDialog("Input Change");
		check = true;
		System.out.println(editedName + " row: " + row + " col: "+ col);
	}
	
	public void saveButton() {
		saving = new JButton("Save");
		saving.setMaximumSize(new Dimension(200, 50));
		saving.setVisible(true);
		saving.addActionListener(new SaveAction());
		middle.add(saving, BorderLayout.SOUTH); //changed to panel
	}
	public void insertButton() {
		insert = new JButton("Add Row");
		insert.setMaximumSize(new Dimension(200, 50));
		insert.setVisible(true);
		insert.addActionListener(new InsertAction());
		middle.add(insert, BorderLayout.SOUTH); //changed to panel
	}
	
	public void insertProperty() {
		
		newName = JOptionPane.showInputDialog("Input Property Name");
		newAccountant = JOptionPane.showInputDialog("Input Accountnant Name");
		newAp = JOptionPane.showInputDialog("Input AP Name");
		newRm = JOptionPane.showInputDialog("Input RM Name");
		newOwner = JOptionPane.showInputDialog("Input Owner Name");
		newReviewer = JOptionPane.showInputDialog("Input Reviewer Name");
		newDueDate = JOptionPane.showInputDialog("Input Due Date");
		newNotes = JOptionPane.showInputDialog("Input Notes Name");
		newAddress = JOptionPane.showInputDialog("Input Address Name");
		newBack = JOptionPane.showInputDialog("Input AP Back-UP Name");
		newPhone = JOptionPane.showInputDialog("Input Phone Name");
		newPm = JOptionPane.showInputDialog("Input PM Name");
		newUnits = JOptionPane.showInputDialog("Input Number of Units");
		newProperty = new Property(newName, newAccountant, newAp, newRm, newOwner, newReviewer,
				newDueDate, newNotes, newAddress, newBack, newPhone, newPm, newUnits);
		obj.insert(newProperty);
		
	}
	
	public void deleteButton() {
		delete = new JButton("Delete Row");
		delete.setMaximumSize(new Dimension(200, 50));
		delete.setVisible(true);
		delete.addActionListener(new DeleteAction());
		middle.add(delete, BorderLayout.SOUTH); //changed to panel
	}
	
	public void deleteProperty() {
		//will be the wrong row selected
		
		//get the property so its easy to delete
		deleteRow = grid.getSelectedRow();
		
		//make delete return a boolean
		userInput = JOptionPane.showInputDialog("Are you sure? ( y / n )");
		System.out.println("old Size: " + obj.list.size());
		//had to make a static reference
		//need to make a check for which grid is seen
		
		if (currGrid) {
			deleteRowCopy = recordingCopy.get(deleteRow);
			System.out.println("selectedRow: " + recordingCopy.get(deleteRow));
			System.out.println(obj.list.get(recordingCopy.get(deleteRow)).getName());
			obj.list.remove(deleteRowCopy);
		}
		else {
			obj.list.remove(deleteRow);
		}
		
		
		resetGrid();
	}
	public void exportButton() {
		export = new JButton("Export to excel file");
		export.setMaximumSize(new Dimension(200, 50));
		export.setVisible(true);
		//write the action to export
		export.addActionListener(new ExportAction());
		panel.add(export);
	}
	
	public void exportFile() throws IOException {
		location = JOptionPane.showInputDialog("Enter the destination");
		obj.writeXLSXFile(location);
	}
	
	public void importButton() {
		importB = new JButton("Import an excel file");
		importB.setMaximumSize(new Dimension(200, 50));
		importB.setVisible(true);
		//write the action to export
		importB.addActionListener(new importAction());
		panel.add(importB);
	}
	
	public void importData() throws IOException {
		root = JOptionPane.showInputDialog("Enter the file path");
		obj.readXLSXFile(root);
		resetGrid();
		
	}
	
	public static void main(String[] args ) {
		
		GUI gui = new GUI("example"); //filename
		JSplitPane split = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		gui.setSize(1000, 400);
		gui.setVisible(true);
		
		gui.importButton();
		gui.addCombo();
		gui.addTextField();
		gui.addButton();
		gui.resetButton();
		gui.exportButton();
		gui.addTable();
		gui.insertButton();
		gui.deleteButton();
		gui.editButton();
		gui.saveButton();
		split.setTopComponent(panel);
		split.setBottomComponent(middle);
		split.setDividerLocation(0.7);
		
		gui.add(split);
		gui.validate();
		System.out.println("Progress");
	}
	
}
