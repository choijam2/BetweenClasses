import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.JTable;

public class TimeTableSearchClasses implements ActionListener{
	
	Connection con;
	JTable table;
	Student student;
	public TimeTableSearchClasses(Connection con,JTable table, Student student) {
		this.con = con;
		this.table = table;
		this.student = student;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		new TimeTableSearchClassesFrame(con, table, student);
	}
}