import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JTable;
import javax.swing.JTextField;

public class BetweenDelFunc implements ActionListener{
	JTable table; 
	JTextField field;
	boolean who;
	public BetweenDelFunc(JTextField field, boolean who, JTable table) {
		// TODO Auto-generated constructor stub
		this.table = table;
		this.field = field;
		this.who = who;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
