import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class RegisterBtnActionHandler implements ActionListener{
	Connection con;
	RegisterFrame rFrame;
	RegisterBtnActionHandler(RegisterFrame rFrame, Connection con){
		this.con = con;
		this.rFrame = rFrame;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String sid = rFrame.getSidField().getText();
		char[] pass = rFrame.getPasswordField().getPassword();
		String password = new String(pass);
		String name = rFrame.getNameField().getText();
		String college = rFrame.getCollegeField().getText();
		String dept = rFrame.getDetpField().getText();
		String quest = rFrame.getQuestField().getText();

		if (sid.equals("") || password.equals("") || name.equals("") || college.equals("") || dept.equals("") || quest.equals(""))
			JOptionPane.showMessageDialog(null, "빈칸을 모두 입력하세요.");
		else if(sid.length() < 8)
			JOptionPane.showMessageDialog(null, "학번을 확인하세요(8자리)");
		else {
			try {
				PreparedStatement query = con
						.prepareStatement("insert into student values(?,?,?,?,?,?)");
				
				query.setString(1, sid);
				query.setString(2, password);
				query.setString(3, name);
				query.setString(4, college);
				query.setString(5, dept);
				query.setString(6, quest);
				int cnt = query.executeUpdate();
				
				if(cnt==1)
					JOptionPane.showMessageDialog(null, "회원가입 완료!!");
			} catch (SQLException sqex) {
				if(sqex.getSQLState().equals("23000"))
					JOptionPane.showMessageDialog(null, "아이디 중복!!");
			}
		}
	}
	
}
