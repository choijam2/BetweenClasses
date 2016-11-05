import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class PassFindActionHandler implements ActionListener {
	Connection con;
	PassFindFrame pframe;

	PassFindActionHandler(PassFindFrame pframe, Connection con) {
		this.pframe = pframe;
		this.con = con;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String sid = pframe.getSidField().getText();
		String name = pframe.getNameField().getText();
		String quest = pframe.getQuestField().getText();

		if (sid.equals("") || name.equals("") || quest.equals(""))
			JOptionPane.showMessageDialog(null, "��ĭ�� ��� �Է��ϼ���.");
		else {
			try {
				ResultSet rs;
				PreparedStatement query = con
						.prepareStatement("select sname, password, question from student where sid = ?");

				query.setString(1, sid);
				rs = query.executeQuery();

				if (rs.next()) {
					String nameCheck = rs.getString("sname");
					String password = rs.getString("password");
					String questCheck = rs.getString("question");

					if (name.equals(nameCheck) && quest.equals(questCheck))
						JOptionPane.showMessageDialog(null, "��й�ȣ : " + password);
					else
						JOptionPane.showMessageDialog(null, "������ ��ġ���� �ʽ��ϴ�.");
				} else {
					JOptionPane.showMessageDialog(null, "���̵� �����ϴ�.");
				}
			} catch (SQLException sqex) {
				System.out.println(sqex.getMessage());
				System.out.println(sqex.getSQLState());
			}
		}
	}
}
