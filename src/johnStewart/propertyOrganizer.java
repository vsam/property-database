package johnStewart;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
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


import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

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
	
	public static void readXLSXFile(String root) throws IOException
	{
		ArrayList<Property> temp = new ArrayList<Property>();
		root = "/home/sam/Projects/data/masterUpdated.xlsx";
		InputStream ExcelFileToRead = new FileInputStream(root);
		XSSFWorkbook  wb = new XSSFWorkbook(ExcelFileToRead);
		int num = 0;
		XSSFWorkbook test = new XSSFWorkbook(); 
		
		XSSFSheet sheet = wb.getSheetAt(0);
		XSSFRow row; 
		XSSFCell cell;

		Iterator rows = sheet.rowIterator();
		
		String name = new String();
		String accountant = new String();
		String ap = new String();
		String rm = new String();
		String owner = new String();
		String reviewer = new String();
		String dueDate = new String();
		String notes = new String();
		String address = new String();
		String back = new String();
		String phone = new String();
		String pm = new String();
		String units = new String();
		String part1 = new String();
		double part2; // = new String();
		int number = 0;
		
		while (rows.hasNext())
		{
			int count = 0;
			row=(XSSFRow) rows.next();
			Iterator cells = row.cellIterator();
			
			while (cells.hasNext())
			{
				
				cell = (XSSFCell) cells.next();
				//System.out.println("cell: " + cell);
				if (cell == null) {
					//standby
				}
				else if (count == 0){
					name = cell.getStringCellValue();
				}
				else if (count == 1) {
					accountant = cell.getStringCellValue();
				}
				else if (count == 2) {
					ap = cell.getStringCellValue();
				}
				else if (count == 3) {
					rm = cell.getStringCellValue();
				}
				else if (count == 4) {
					owner = cell.getStringCellValue();
				}
				else if (count == 5) {
					reviewer = cell.getStringCellValue();
				}
				else if (count == 6) {
					dueDate = cell.getStringCellValue();
				}
				else if (count == 7) {
					notes = cell.getStringCellValue();
				}
				else if (count == 8) {
					
					address = cell.getStringCellValue();
				}
				else if (count == 9) {
					part1 = cell.getStringCellValue();
					address = address + part1;
				}
				else if (count == 10) {
					
					part2 = cell.getNumericCellValue(); //Cannot get a STRING value from a NUMERIC cell
					// double to string
					address = address + Double.toString(part2);
				}
				else if (count == 11) {
					back = cell.getStringCellValue();
				}
				else if (count == 12) {
					phone = cell.getStringCellValue();
				}
				else if (count == 13) {
					pm = cell.getStringCellValue();
				}
				else if (count == 14) {
					double unitN = cell.getNumericCellValue();
					units =  Double.toString(unitN);//not being used
				}
				count++;
			}
			Property curr = new Property(name, accountant, ap, rm, owner, reviewer, 
					dueDate, notes, address, back, phone, pm);
			temp.add(curr);
		}
		list = temp;
	
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