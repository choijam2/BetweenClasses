import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class NonmemberFunc implements ActionListener{
	Connection con;
	boolean memCheck;
	public NonmemberFunc(Connection con, boolean memCheck) {
		this.con = con;
		this.memCheck = memCheck;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		AddClassFrame ACFrame = new AddClassFrame(con, memCheck, null);
	}
	
}
