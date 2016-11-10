import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class MockDelFunc implements ActionListener{
	JTextField lid;
	public MockDelFunc(JTextField lid) {
		this.lid = lid;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Action");
	}
	
}
