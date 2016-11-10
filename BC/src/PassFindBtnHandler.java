import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class PassFindBtnHandler implements ActionListener{
	Connection con;
	PassFindBtnHandler(Connection con){
		this.con = con;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		PassFindFrame pFrame = new PassFindFrame(con);
	}
	
}
