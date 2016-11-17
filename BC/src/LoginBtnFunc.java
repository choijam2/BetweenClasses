import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

public class LoginBtnFunc implements ActionListener {
	AddClassFrame ACFrame;
	LoginFrame frame;
	Connection con;
	
	LoginBtnFunc(LoginFrame frame, Connection con) {
		this.frame = frame;
		this.con = con;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String sid = frame.getSidField().getText();
		char[] pass = frame.getPasswordField().getPassword();
		String password = new String(pass);
		ResultSet rs = null;
		if (sid.equals("") || password.equals(""))
			JOptionPane.showMessageDialog(null, "빈칸을 모두 입력하세요.");
		else {
			try {
				PreparedStatement query = con.prepareStatement("select sid, password from student where sid = ?");

				query.setString(1, sid);
				rs = query.executeQuery();

				if (rs.next()) {
					String str = rs.getString("sid");
					String str2 = rs.getString("password");
					if (str.equals(sid) && str2.equals(password)){
						ACFrame = new AddClassFrame(con, true, sid, frame);
					}
					else
						JOptionPane.showMessageDialog(null, "비밀번호가 틀렸습니다!!");
				} else
					JOptionPane.showMessageDialog(null, "아이디가 없습니다!!");

			} catch (SQLException sqex) {
				System.out.println(sqex.getMessage());
				System.out.println(sqex.getSQLState());
			}finally{
				try {
					if(rs!=null)
						rs.close();
				} catch (SQLException e1) {
					System.out.println(e.getActionCommand());
				}
			}
		}
	}
}