import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class LogoutFunc implements ActionListener{
	JFrame frame;
	public LogoutFunc(JFrame frame) {
		// TODO Auto-generated constructor stub
		this.frame = frame;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		frame.dispose();
		new LoginFrame();
	}
	
}
