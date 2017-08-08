package johnStewart;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class importAction implements ActionListener  {
	GUI temp = new GUI();
	String root = new String();
	@Override
	public void actionPerformed(ActionEvent e) {
		//root = temp.getRoot();
		
		try {
			temp.importData();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

}
