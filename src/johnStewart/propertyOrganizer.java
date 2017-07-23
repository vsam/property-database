package johnStewart;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.*;
import java.awt.*;
import java.awt.event.*;

public class propertyOrganizer {
	
	int counter;
	static ArrayList<Property> list;
	String type;
	
	public propertyOrganizer() {
		counter = 0;
		list = new ArrayList<Property>();
	}
	
	public static boolean populateData(String fileName) {
		File file = new File(fileName);
		ArrayList<Property> temp = new ArrayList<Property>();
		try {
			
			Scanner scanner = new Scanner(file);
			while(scanner.hasNextLine()) {
				
				String name = scanner.next();
				String accountant = scanner.next();
				String ap = scanner.next();
				String rm = scanner.next();
				String owner = scanner.next();
				String reviewer = scanner.next();  //added
				String dueDate = scanner.next();
				String notes = scanner.next();
				String address = scanner.next();
				String back = scanner.next();
				String phone = scanner.next();
				String pm = scanner.next();
			
				Property curr = new Property(name, accountant, ap, rm, owner, reviewer, 
						dueDate, notes, address, back, phone, pm);
				temp.add(curr);
			}
			list = temp;
			
			scanner.close();
		}
		//returns an error if something goes wrong
		catch(FileNotFoundException e) {
			System.out.println("\nFile not found!!");
			return false;
		}
		return true;
		//Property temp = new property();
	}
	
	public void insert(Property temp) {
		list.add(temp);
		counter++;
	}
	
	public void delete(String temp, String group) {
		if (search(temp, group)) {
			String curr = temp.toLowerCase();
			for(int i = 0; i < counter; i++) {
				String dummy = list.get(i).getName().toLowerCase();
				if (curr.equals(dummy)) {
					list.remove(i);
					counter--;
					break;
				}
			}
		}
	}
	
	public int getSize() {
		return counter;
	}
	
	public Property get(int count) {
		return list.get(count);
	}
	public ArrayList<Property> getArray() {
		return list;
	}
	
	public ArrayList<Integer> getUpdatedSize(String group, String temp) {
		ArrayList<Integer> recording = new ArrayList<Integer>();
		String curr = temp.toLowerCase();
		group = group.toLowerCase();
		for (int i = 0; i < list.size(); i++) {
			//gets the correct category
			String dummy = getGroup(group, i).toLowerCase();
			if (dummy == null) {
				return null;
			}
			if (curr.equals(dummy)) {
				recording.add(i);
				//get that entire row
			}
		}
		return recording;
	}
	
	public boolean search(String group, String temp) {
		String curr = temp.toLowerCase();
		group = group.toLowerCase();
		for (int i = 0; i < list.size(); i++) {
			//gets the correct category
			String dummy = getGroup(group, i).toLowerCase();
			if (dummy == null) {
				return false;
			}
			if (curr.equals(dummy)) {
				return true;
			}
		}
		return false;
	}
	
	public String getGroup(String group, int i) {
		String temp = new String();
		if (group.equals("accountant")) {
			return list.get(i).getAccountant();
		}
		else if (group.equals("ap")) {
			return list.get(i).getAp();
		}
		else if (group.equals("rm")) {
			return list.get(i).getRm();
		}
		else if (group.equals("owner")) {
			return list.get(i).getOwner();
		}
		else if (group.equals("reviewer")) {
			return list.get(i).getReviewer();
		}
		else if (group.equals("property")) {
			return list.get(i).getName();
		}
		return null;
	}
	
	public void sortAccountant(ArrayList<Property> temp) {
		ArrayList<Property> sorted = new ArrayList<Property>();
		
		int count = 0; //gets the index of the next smallest element
		while (temp.size() > 0) {
			String first = temp.get(0).getAccountant().toLowerCase(); 
			for (int i = 0; i < temp.size(); i++) {
				String second = temp.get(i).getAccountant().toLowerCase();
				if (first.compareTo(second) >= 0) {
					first = second;
					count = i;
				}
			}
			sorted.add(temp.get(count));
			temp.remove(count);
		}
		list = sorted;
	}
	public void sortAp(ArrayList<Property> temp) {
		ArrayList<Property> sorted = new ArrayList<Property>();
		
		int count = 0; //gets the index of the next smallest element
		while (temp.size() > 0) {
			String first = temp.get(0).getAp().toLowerCase(); 
			for (int i = 0; i < temp.size(); i++) {
				String second = temp.get(i).getAp().toLowerCase();
				if (first.compareTo(second) >= 0) {
					first = second;
					count = i;
				}
			}
			sorted.add(temp.get(count));
			temp.remove(count);
		}
		list = sorted;
	}
	
	public void sortRm(ArrayList<Property> temp) {
		ArrayList<Property> sorted = new ArrayList<Property>();
		
		int count = 0; //gets the index of the next smallest element
		while (temp.size() > 0) {
			String first = temp.get(0).getRm().toLowerCase(); 
			for (int i = 0; i < temp.size(); i++) {
				String second = temp.get(i).getRm().toLowerCase();
				if (first.compareTo(second) >= 0) {
					first = second;
					count = i;
				}
			}
			sorted.add(temp.get(count));
			temp.remove(count);
		}
		list = sorted;
	}
	
	public void sortOwner(ArrayList<Property> temp) {
		ArrayList<Property> sorted = new ArrayList<Property>();
		
		int count = 0; //gets the index of the next smallest element
		while (temp.size() > 0) {
			String first = temp.get(0).getOwner().toLowerCase(); 
			for (int i = 0; i < temp.size(); i++) {
				String second = temp.get(i).getOwner().toLowerCase();
				if (first.compareTo(second) >= 0) {
					first = second;
					count = i;
				}
			}
			sorted.add(temp.get(count));
			temp.remove(count);
		}
		list = sorted;
	}
	
	public void sortReviewer(ArrayList<Property> temp) {
		ArrayList<Property> sorted = new ArrayList<Property>();
		
		int count = 0; //gets the index of the next smallest element
		while (temp.size() > 0) {
			String first = temp.get(0).getReviewer().toLowerCase(); 
			for (int i = 0; i < temp.size(); i++) {
				String second = temp.get(i).getReviewer().toLowerCase();
				if (first.compareTo(second) >= 0) {
					first = second;
					count = i;
				}
			}
			sorted.add(temp.get(count));
			temp.remove(count);
		}
		list = sorted;
	}
	
	public static String[][] toArray() {
		String[][] temp = new String[12][list.size()];
		System.out.println("Notes: "+list.get(0).getNotes());
		for (int i = 0; i < list.size(); i++) {
			for (int k = 0; k < 12; k++) {
				if (k == 0) {
					temp[i][k] = list.get(i).getName();
				}
				else if (k == 1) {
					temp[i][k] = list.get(i).getAccountant();
				}
				else if (k == 2) {
					temp[i][k] = list.get(i).getAp();
				}
				else if (k == 3) {
					temp[i][k] = list.get(i).getRm();
				}
				else if (k == 4) {
					temp[i][k] = list.get(i).getOwner();
				}
				else if (k == 5) {
					temp[i][k] = list.get(i).getReviewer();
				}
				else if (k == 6) {
					temp[i][k] = list.get(i).getDueDate();
				}
				else if (k == 7) {
					temp[i][k] = list.get(i).getNotes();
				}
				else if (k == 8) {
					temp[i][k] = list.get(i).getAddress();
				}
				else if (k == 9) {
					temp[i][k] = list.get(i).getBack();
				}
				else if (k == 10) {
					temp[i][k] = list.get(i).getPhone();
				}
				else if (k == 11) {
					temp[i][k] = list.get(i).getPm();
				}
			}
		}
		return temp;
	}
}
	/*public static void main(String[] args){
		
		JFrame frame = new JFrame("Organizer");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1200, 800);
		//create a panel to be the button
		JPanel middle = new JPanel();
		middle.add(Box.createVerticalGlue());
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
		
		options.setMaximumSize(new Dimension(200, 50));
		panel.add(options);
		
		text.setMaximumSize(new Dimension(200, 50));
		panel.add(text);
		//type= text.getText();
		
		button.setMaximumSize(new Dimension(200, 50));
		panel.add(button);
		/*if (type != null) {
			button.addActionListener(new Action());
		}
		//panel.add(grid);
		middle.add(grid);
		middle.add(scrollPane);
		System.out.println("here");
		//added to frame
		frame.add(panel);
		frame.add(middle);
	}*/
