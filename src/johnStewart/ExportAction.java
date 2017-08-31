package johnStewart;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ExportAction implements ActionListener   {

	GUI temp = new GUI();
	@Override	
	public void actionPerformed(ActionEvent e) {
		try {
			temp.exportFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
