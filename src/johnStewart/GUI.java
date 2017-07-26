package johnStewart;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableModel;

public class GUI extends JFrame {
	
	JFrame frame;
	static JPanel panel;
	static JComboBox<String> options;
	static JTextField text;
	JButton button;
	JButton reset;
	static String type = new String();
	static String input = new String();
	JPanel middle;
	static propertyOrganizer obj;
	static JScrollPane scrollPane;
	static JTable grid;
	String[][] array;
	String[] columnNames = {"Property", "Accountant", "AP", "RM", "Owner", "Reviewer", "Due Date", 
			"Notes", "Address", "Back-Up", "Phone Number", "Property Manager"};
	
	public GUI() {
		type = getCategory();
		input = getInput();
		
	}
	
	public GUI(String fileName) {
		panel = new JPanel();
		obj = new propertyOrganizer();
		obj.populateData(fileName);
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
		array = new String[obj.list.size()][12];
		
		for (int i = 0; i < obj.list.size(); i++) {
			for (int k = 0; k < 12; k++) {
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
				
			}
		}
		grid = new JTable(array, columnNames);
		//grid.setPreferredScrollableViewportSize(new Dimension(1200, 200));
		//grid.setFillsViewportHeight(true);
		//grid.setAutoResizeMode(4);
		JScrollPane scrollPane = new JScrollPane(grid);
		grid.setVisible(true);
		add(scrollPane); 
		panel.add(grid);
		
	}
	
	public void updateTable(String[][] temp) {
		//removes the grid from panel
		panel.remove(grid);
		grid = new JTable(temp, columnNames);
		//adds the grid to panel
		panel.add(grid);
		//updates the table
		panel.repaint();
		//lets the program know that changes were made
		panel.revalidate();
		
	}
	
	public void resetButton() {
		reset = new JButton("Reset");
		reset.setMaximumSize(new Dimension(200, 50));
		reset.setVisible(true);
		
		reset.addActionListener(new ResetAction());
		panel.add(reset);
	}
	
	public void resetGrid() {
		panel.remove(grid);
		addTable();
		panel.repaint();
		panel.revalidate();
	}
	
	public static void main(String[] args ) {
		if(args.length < 1) {
			System.err.println("Invalid number of arguments passed");
			return;
		}
		String fileName = args[0];
		
		GUI gui = new GUI(fileName);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		gui.setSize(1000, 400);
		gui.setVisible(true);
		
		gui.addCombo();
		gui.addTextField();
		gui.addButton();
		gui.addTable();
		gui.resetButton();
		gui.add(panel);
		System.out.println("Progress");
	}
	
}
