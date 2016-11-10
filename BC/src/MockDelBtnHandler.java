import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class MockDelBtnHandler implements ActionListener{
	JTextField lid;
	public MockDelBtnHandler(JTextField lid) {
		this.lid = lid;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Action");
	}
	
}
