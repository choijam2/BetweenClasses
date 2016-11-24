import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class TimeTableAddFunc implements ActionListener {
	Student student;
	JTextField lid;
	Connection con;
	JTable table;

	public TimeTableAddFunc(JTextField lid, Connection con, JTable table, Student student) {
		this.lid = lid;
		this.con = con;
		this.table = table;
		this.student = student;
	}

	@Override
	public void actionPerformed(ActionEvent a) {
		String lectureId = lid.getText();

		if (lectureId.equals(""))
			JOptionPane.showMessageDialog(null, "������ȣ�� �Է��ϼ���.");
		else {
			try {
				ResultSet rs;
				PreparedStatement query = con.prepareStatement("select lname, ltime, place from lecture where lid = ?");

				query.setString(1, lectureId);
				rs = query.executeQuery();

				if (rs.next()) {
					String lecTime = rs.getString("ltime");
					String lecName = rs.getString("lname");
					String lecPlace = rs.getString("place");

					boolean ck = stringToken(lecTime, lecName, lecPlace);
					if (ck == true) {
						query = con.prepareStatement("insert into course values(?,?)");

						query.setString(1, student.getSid());
						query.setString(2, lectureId);
						int cnt = query.executeUpdate();

						student.addLid(lectureId);
					}
				} else
					rs.getBoolean(1);

			} catch (SQLException sqex) {
				JOptionPane.showMessageDialog(null, "������ �������� �ʽ��ϴ�.");
			}
		}
	}

	public boolean stringToken(String lecTime, String lecName, String lecPlace) {
		StringTokenizer tk = new StringTokenizer(lecTime);
		StringTokenizer tk2 = new StringTokenizer(lecPlace);
		ArrayList<Integer> rowcol = new ArrayList<Integer>();
		String ptemp = null;
		while (tk.hasMoreTokens() && tk2.hasMoreTokens()) {
			String temp = tk.nextToken();
			ptemp = tk2.nextToken();
			char day = temp.charAt(0);

			switch (day) { // ���� ����
			case '��': rowcol.add(1); break;
			case 'ȭ': rowcol.add(2); break;
			case '��': rowcol.add(3); break;
			case '��': rowcol.add(4); break;
			case '��': rowcol.add(5); break;
			case '��': rowcol.add(6);
			}

			// ���� �ð�
			int sHour = Integer.parseInt(temp.substring(1, 3));
			int sMin = Integer.parseInt(temp.substring(4, 6));
			int sTime = sHour * 100 + sMin;

			int fHour = Integer.parseInt(temp.substring(7, 9));
			int fMin = Integer.parseInt(temp.substring(10));
			int fTime = fHour * 100 + fMin;
			// �ð� �ش�Ǵ� ��, �� ��ġ
			int t = 900;
			for (int i = 0; i < 26; i++) {
				if (sTime >= t && sTime < t + 30) rowcol.add(i);
				if (fTime >= t && fTime < t + 30) rowcol.add(i);
				if (i % 2 == 0) t += 30;
				else t += 70;
			}
		}
		// �ð� ��ġ���� Ȯ��
		for (int i = rowcol.get(1); i <= rowcol.get(2); i++) {
			if (table.getValueAt(i, rowcol.get(0)) != null) {
				JOptionPane.showMessageDialog(null, lecName + " �ð��� �ߺ��˴ϴ�.");
				return false;
			}
		}
		if (rowcol.size() > 5) {
			for (int i = rowcol.get(4); i <= rowcol.get(5); i++) {
				if (table.getValueAt(i, rowcol.get(3)) != null) {
					JOptionPane.showMessageDialog(null, lecName + " �ð��� �ߺ��˴ϴ�.");
					return false;
				}
			}
		}
		for (int i = rowcol.get(1); i <= rowcol.get(2); i++) {
			if (i == rowcol.get(1))
				table.setValueAt(lecName + " " + lid.getText(), i, rowcol.get(0));
			else if (i == rowcol.get(1) + 1)
				table.setValueAt(ptemp, i, rowcol.get(0));
			else
				table.setValueAt("", i, rowcol.get(0));
		}
		if (rowcol.size() > 5) {
			for (int i = rowcol.get(4); i <= rowcol.get(5); i++) {
				if (i == rowcol.get(4))
					table.setValueAt(lecName + " " + lid.getText(), i, rowcol.get(3));
				else if (i == rowcol.get(4) + 1)
					table.setValueAt(ptemp, i, rowcol.get(3));
				else
					table.setValueAt("", i, rowcol.get(3));
			}
		}
		return true;
	}
}
