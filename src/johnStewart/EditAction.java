package johnStewart;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class EditAction implements ActionListener {

	GUI temp = new GUI();
	

	@Override
	public void actionPerformed(ActionEvent e) {
		temp.editGrid();
		
	}

}
