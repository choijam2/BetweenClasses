import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JFrame;

public class NonmemberFunc implements ActionListener{
	Connection con;
	JFrame frame;
	User user;
	public NonmemberFunc(Connection con,User user, JFrame frame) {
		this.con = con;
		this.frame = frame;
		this.user = user;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		new AddClassFrame(con,user, frame);
	}
	
}
