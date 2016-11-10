import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class RegisterBtnHandler implements ActionListener{
	Connection con;
	RegisterBtnHandler(Connection con) {
		this.con = con;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		RegisterFrame rFrame = new RegisterFrame(con);
	}
}
