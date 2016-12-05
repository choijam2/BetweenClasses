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
	String lectureId;
	public TimeTableAddFunc(JTextField lid, Connection con, JTable table, Student student) {
		this.lid = lid;
		this.con = con;
		this.table = table;
		this.student = student;
	}

	@Override
	public void actionPerformed(ActionEvent a) {
		lectureId = lid.getText();
		lid.setText("");
		
		if (lectureId.equals(""))
			JOptionPane.showMessageDialog(null, "수강번호를 입력하세요.");
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
						query.executeUpdate();

						student.addLid(lectureId);
					}
				} else
					rs.getBoolean(1);

			} catch (SQLException sqex) {
				JOptionPane.showMessageDialog(null, "과목이 존재하지 않습니다.");
			}
		}
	}

	public boolean stringToken(String lecTime, String lecName, String lecPlace) {
		if(lecTime.equals(""))
			return false;
		StringTokenizer tk = new StringTokenizer(lecTime);
		StringTokenizer tk2 = new StringTokenizer(lecPlace);
		ArrayList<Integer> rowcol = new ArrayList<Integer>();
		String ptemp = null;
		while (tk.hasMoreTokens() && tk2.hasMoreTokens()) {
			String temp = tk.nextToken();
			ptemp = tk2.nextToken();
			char day = temp.charAt(0);

			switch (day) { // 요일 지정
			case '월': rowcol.add(1); break;
			case '화': rowcol.add(2); break;
			case '수': rowcol.add(3); break;
			case '목': rowcol.add(4); break;
			case '금': rowcol.add(5); break;
			case '토': rowcol.add(6);
			}

			// 시작 시간
			int sHour = Integer.parseInt(temp.substring(1, 3));
			int sMin = Integer.parseInt(temp.substring(4, 6));
			int sTime = sHour * 100 + sMin;

			int fHour = Integer.parseInt(temp.substring(7, 9));
			int fMin = Integer.parseInt(temp.substring(10));
			int fTime = fHour * 100 + fMin;
			if(fTime > 2100)
				fTime = 2100;
			// 시간 해당되는 행, 열 위치
			int t = 900;
			for (int i = 0; i < 25; i++) {
				if (sTime >= t && sTime < t + 30) rowcol.add(i);
				if (fTime >= t && fTime < t + 30) rowcol.add(i);
				if (i % 2 == 0) t += 30;
				else t += 70;
			}
		}
		if(rowcol.size()==2){
			if (table.getValueAt(rowcol.get(1), rowcol.get(0)) != null) {
				JOptionPane.showMessageDialog(null, lecName + " 시간이 중복됩니다.");
				return false;
			}
			table.setValueAt(lecName, rowcol.get(1), rowcol.get(0));
			table.setValueAt(ptemp, rowcol.get(1)+1, rowcol.get(0));
			for(int i=rowcol.get(1)+2;i<25;i++){
				table.setValueAt("", i, rowcol.get(0));
			}
			return true;
		}
		
		// 시간 겹치는지 확인
		for (int i = rowcol.get(1); i <= rowcol.get(2); i++) {
			if (table.getValueAt(i, rowcol.get(0)) != null) {
				JOptionPane.showMessageDialog(null, lecName + " 시간이 중복됩니다.");
				return false;
			}
		}
		if (rowcol.size() > 5) {
			for (int i = rowcol.get(4); i <= rowcol.get(5); i++) {
				if (table.getValueAt(i, rowcol.get(3)) != null) {
					JOptionPane.showMessageDialog(null, lecName + " 시간이 중복됩니다.");
					return false;
				}
			}
		}
		for (int i = rowcol.get(1); i <= rowcol.get(2); i++) {
			if (i == rowcol.get(1))
				table.setValueAt(lecName, i, rowcol.get(0));
			else if (i == rowcol.get(1) + 1)
				table.setValueAt(ptemp + " (" + lectureId + ")", i, rowcol.get(0));
			else
				table.setValueAt("", i, rowcol.get(0));
		}
		if (rowcol.size() > 5) {
			for (int i = rowcol.get(4); i <= rowcol.get(5); i++) {
				if (i == rowcol.get(4))
					table.setValueAt(lecName, i, rowcol.get(3));
				else if (i == rowcol.get(4) + 1)
					table.setValueAt(ptemp + " (" + lectureId + ")", i, rowcol.get(3));
				else
					table.setValueAt("", i, rowcol.get(3));
			}
		}
		return true;
	}
}
