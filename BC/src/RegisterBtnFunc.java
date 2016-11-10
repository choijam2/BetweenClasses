import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class RegisterBtnFunc implements ActionListener{
	Connection con;
	RegisterBtnFunc(Connection con) {
		this.con = con;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		RegisterFrame rFrame = new RegisterFrame(con);
	}
}
