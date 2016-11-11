import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JTextField;

public class BCAddFunc implements ActionListener{
	Connection con;
	JTextField field;
	boolean who;
	public BCAddFunc(Connection con, JTextField field, boolean who) {
		// TODO Auto-generated constructor stub
		this.con = con;
		this.field = field;
		this.who = who;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
