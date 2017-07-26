package johnStewart;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResetAction  implements ActionListener {

	GUI temp = new GUI();
	@Override
	public void actionPerformed(ActionEvent e) {
		temp.resetGrid();
		
		
		
	}

}
