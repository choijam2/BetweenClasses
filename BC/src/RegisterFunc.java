import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class RegisterFunc implements ActionListener{
	Connection con;
	RegisterFrame rFrame;
	RegisterFunc(RegisterFrame rFrame, Connection con){
		this.con = con;
		this.rFrame = rFrame;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String sid = rFrame.getSidField().getText();
		char[] pass = rFrame.getPasswordField().getPassword();
		String password = new String(pass);
		String name = rFrame.getNameField().getText();
		String college = (String)rFrame.getCollegeComboBox().getSelectedItem();
		String dept = (String)rFrame.getDetpComboBox().getSelectedItem();
		String quest = rFrame.getQuestField().getText();

		if (sid.equals("") || password.equals("") || name.equals("") || college.equals("") || dept.equals("") || quest.equals(""))
			JOptionPane.showMessageDialog(null, "��ĭ�� ��� �Է��ϼ���.");
		else if(sid.length() != 8)
			JOptionPane.showMessageDialog(null, "�й��� Ȯ���ϼ���(8�ڸ�)");
		else if(password.length() > 50)
			JOptionPane.showMessageDialog(null, "��й�ȣ�� �ʹ� ��ϴ�.");
		else {
			try {
				PreparedStatement query = con
						.prepareStatement("insert into student values(?,?,?,?,?,?)");
				
				query.setString(1, sid);
				query.setString(2, name);
				query.setString(3, password);
				query.setString(4, college);
				query.setString(5, dept);
				query.setString(6, quest);
				int cnt = query.executeUpdate();
				
				if(cnt==1)
					JOptionPane.showMessageDialog(null, "ȸ������ �Ϸ�!!");
			} catch (SQLException sqex) {
				if(sqex.getSQLState().equals("23000"))
					JOptionPane.showMessageDialog(null, "���̵� �ߺ�!!");
			}
		}
	}
	
}
