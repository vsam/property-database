package johnStewart;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MyAction implements ActionListener {
	String category = new String();
	//get the input name
	String input = new String();
	GUI temp = new GUI();
	public void actionPerformed(ActionEvent e) {
		temp.update();
		//get the input and category
		category = temp.getCategory();
		input = temp.getInput();
		//checks if the input is in the table
		if (temp.obj.search(category, input)) {
			//different size using different arraylist
			ArrayList<Integer> recording = temp.obj.getUpdatedSize(category, input);
			Integer[] copyList = new Integer[recording.size()];
			
			//update the array in gui class
			for (int i = 0; i < recording.size(); i++) {
				copyList[i] = recording.get(i);
			}
			temp.shortenGrid(copyList);
			String[][] updatedArray = new String[recording.size()][13]; //changed
			int count = recording.size();
			
			for (int i = 0; i < count; i++) {
				for (int k = 0; k < 13; k++) { //changed
					if (k == 0) {
						updatedArray[i][k] = temp.obj.list.get(recording.get(0)).getName();
					}
					else if (k == 1) {
						updatedArray[i][k] = temp.obj.list.get(recording.get(0)).getAccountant();
					}
					else if (k == 2) {
						updatedArray[i][k] = temp.obj.list.get(recording.get(0)).getAp();
					}
					else if (k == 3) {
						updatedArray[i][k] = temp.obj.list.get(recording.get(0)).getRm();
					}
					else if (k == 4) {
						updatedArray[i][k] = temp.obj.list.get(recording.get(0)).getOwner();
					}
					else if (k == 5) {
						updatedArray[i][k] = temp.obj.list.get(recording.get(0)).getReviewer();
					}
					else if (k == 6) {
						updatedArray[i][k] = temp.obj.list.get(recording.get(0)).getDueDate();
					}
					else if (k == 7) {
						updatedArray[i][k] = temp.obj.list.get(recording.get(0)).getNotes();
					}
					else if (k == 8) {
						updatedArray[i][k] = temp.obj.list.get(recording.get(0)).getAddress();
					}
					else if (k == 9) {
						updatedArray[i][k] = temp.obj.list.get(recording.get(0)).getBack();
					}
					else if (k == 10) {
						updatedArray[i][k] = temp.obj.list.get(recording.get(0)).getPhone();
					}
					else if (k == 11) {
						updatedArray[i][k] = temp.obj.list.get(recording.get(0)).getPm();
					}
					else if (k == 12) {
						updatedArray[i][k] = temp.obj.list.get(recording.get(0)).getUnits();
					}
				}
				recording.remove(0);
			}
			temp.updateTable(updatedArray);
		}
		
		//check if the name is in the category
		System.out.println(temp.obj.search(category, input));
	}
}
