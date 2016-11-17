import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JFrame;

public class NonmemberFunc implements ActionListener{
	Connection con;
	boolean memCheck;
	JFrame frame;
	public NonmemberFunc(Connection con, boolean memCheck, JFrame frame) {
		this.con = con;
		this.memCheck = memCheck;
		this.frame = frame;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		AddClassFrame ACFrame = new AddClassFrame(con, memCheck, null, frame);
	}
	
}
