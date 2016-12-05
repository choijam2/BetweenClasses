import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class LogoutFunc implements ActionListener{
	JFrame frame;
	public LogoutFunc(JFrame frame) {	
		
		this.frame = frame;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	
		frame.dispose();
		new LoginFrame();
	}
	
}
