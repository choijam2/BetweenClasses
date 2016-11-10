import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class NonmemberBtnHandler implements ActionListener{
	Connection con;
	public NonmemberBtnHandler(Connection con) {
		this.con = con;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		AddClassFrame ACFrame = new AddClassFrame(con, true);
	}
	
}
