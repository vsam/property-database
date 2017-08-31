package johnStewart;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InsertAction implements ActionListener {

	GUI temp = new GUI();
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		temp.insertProperty();
		
		Property curr = temp.getNewProperty();
		
		int num = temp.obj.list.size();
		String[][] updatedArray = new String[num][13];  //changed
		//System.out.println("first: " + temp.obj.list.get(0).getName());
		for (int i = 0; i < num; i++) {
			
			for (int k = 0; k < 13; k++) { //changed
				if (k == 0) {
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
		temp.updateTable(updatedArray);
		
	}

}
