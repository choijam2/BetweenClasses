import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JTable;
import javax.swing.JTextField;

public class MockDelFunc implements ActionListener{
	JTable table;
	Connection con;
	JTextField lid;
	public MockDelFunc(JTextField lid, JTable table, Connection con) {
		this.lid = lid;
		this.table = table;
		this.con = con;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Action");
	}
	
}
