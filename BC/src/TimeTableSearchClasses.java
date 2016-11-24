import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JTable;
import javax.swing.JTextField;

public class TimeTableSearchClasses implements ActionListener{
	
	Connection con;
	
	public TimeTableSearchClasses(Connection con) {
		this.con = con;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		TimeTableSearchClassesFrame SFrame = new TimeTableSearchClassesFrame(con);
	}
}