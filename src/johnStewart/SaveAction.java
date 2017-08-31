package johnStewart;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SaveAction implements ActionListener {

	
	GUI temp = new GUI();
	
	int row;
	int col;
	Boolean check;
	Boolean gridCheck;
	String editedName = new String();
	ArrayList<Integer> shortened = new ArrayList<Integer>();
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//row could be the wrong number
		row = temp.getRow();
		col = temp.getCol();
		check = temp.getCheck();
		editedName = temp.getEditedName();
		
		System.out.println(editedName + " row: " + row + " col: "+ col);
		if (!check) {
			return;
		}
		if (editedName == null) {
			return;
		}
		//in case its the specific view
		shortened = temp.getRecordingCopy();
		gridCheck = temp.getCurrGrid();
		
		//checks if its the shortened Grid
		if (gridCheck) {
			int newRow = shortened.get(row);
			row = newRow;
			System.out.println("SaveAction Row: " + row);
		}
		
		int num = temp.obj.list.size();
		String[][] updatedArray = new String[num][13]; //changed
		//System.out.println("first: " + temp.obj.list.get(0).getName());
		for (int i = 0; i < num; i++) {
			
			for (int k = 0; k < 13; k++) {
				if (i == row && k == col) {
					updatedArray[i][k] = editedName;
				}
				else if (k == 0) {
					updatedArray[i][k] = temp.obj.list.get(i).getName();
				}
				else if (k == 1) {
					updatedArray[i][k] = temp.obj.list.get(i).getAccountant();
				}
				else if (k == 2) {
					updatedArray[i][k] = temp.obj.list.get(i).getAp();
				}
				else if (k == 3) {
					updatedArray[i][k] = temp.obj.list.get(i).getRm();
				}
				else if (k == 4) {
					updatedArray[i][k] = temp.obj.list.get(i).getOwner();
				}
				else if (k == 5) {
					updatedArray[i][k] = temp.obj.list.get(i).getReviewer();
				}
				else if (k == 6) {
					updatedArray[i][k] = temp.obj.list.get(i).getDueDate();
				}
				else if (k == 7) {
					updatedArray[i][k] = temp.obj.list.get(i).getNotes();
				}
				else if (k == 8) {
					updatedArray[i][k] = temp.obj.list.get(i).getAddress();
				}
				else if (k == 9) {
					updatedArray[i][k] = temp.obj.list.get(i).getBack();
				}
				else if (k == 10) {
					updatedArray[i][k] = temp.obj.list.get(i).getPhone();
				}
				else if (k == 11) {
					updatedArray[i][k] = temp.obj.list.get(i).getPm();
				}
				else if (k == 12) {
					updatedArray[i][k] = temp.obj.list.get(i).getUnits();
				}
			}
		}
		
		if (col == 0){
			temp.obj.list.get(row).name = editedName;
		}
		else if (col == 1){
			temp.obj.list.get(row).accountant = editedName;
		}
		else if (col == 2){
			temp.obj.list.get(row).ap = editedName;
		}
		else if (col == 3){
			temp.obj.list.get(row).rm = editedName;
		}
		else if (col == 4){
			temp.obj.list.get(row).owner = editedName;
		}
		else if (col == 5){
			temp.obj.list.get(row).reviewer = editedName;
		}
		else if (col == 6){
			temp.obj.list.get(row).dueDate = editedName;
		}
		else if (col == 7){
			temp.obj.list.get(row).notes = editedName;
		}
		else if (col == 8){
			temp.obj.list.get(row).address = editedName;
		}
		else if (col == 9){
			temp.obj.list.get(row).back = editedName;
		}
		else if (col == 10){
			temp.obj.list.get(row).phone = editedName;
		}
		else if (col == 11){
			temp.obj.list.get(row).pm = editedName;
		}
		else if (col == 12) {
			temp.obj.list.get(row).units = editedName;
		}
	
		check = false;
		temp.updateTable(updatedArray);
	}

}
