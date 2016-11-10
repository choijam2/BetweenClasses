import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class PassFindBtnFunc implements ActionListener{
	Connection con;
	PassFindBtnFunc(Connection con){
		this.con = con;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		PassFindFrame pFrame = new PassFindFrame(con);
	}
	
}
