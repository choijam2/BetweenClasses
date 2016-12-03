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

public class TimeTableDelFunc implements ActionListener{
	Student student;
	JTable table;
	Connection con;
	JTextField lectureId;
	public TimeTableDelFunc(JTextField lid, JTable table, Connection con, Student student) {
		this.lectureId = lid;
		this.table = table;
		this.con = con;
		this.student = student;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String lecId = lectureId.getText();
		lectureId.setText("");
		
		if (lecId.equals(""))
			JOptionPane.showMessageDialog(null, "������ȣ�� �Է��ϼ���.");
		else {
			try {
				ResultSet rs;
				PreparedStatement query = con.prepareStatement("select ltime from course c, lecture l where sid = ? and l.lid = ?");

				query.setString(1, student.getSid());
				query.setString(2, lecId);
				rs = query.executeQuery();

				if(rs.next()) {
					String ltime = rs.getString("ltime");
					
					boolean ck = stringToken(ltime);
					if(ck == true){
						query = con.prepareStatement("delete from course where sid = ? and lid = ?");
							
						query.setString(1, student.getSid()); 
						query.setString(2, lecId); 
						int c = query.executeUpdate();
						if(c == 1){
							student.delLid(lecId);
							JOptionPane.showMessageDialog(null, lecId + "���� ���� �Ϸ�!");
						}
						else
							JOptionPane.showMessageDialog(null, "������ �������� �ʽ��ϴ�.");
					}
				}else rs.getBoolean(1);
				
				
			} catch (SQLException sqex) {
				JOptionPane.showMessageDialog(null, "������ �������� �ʽ��ϴ�.");
			}
		}
	}
	public boolean stringToken(String lecTime) {
		StringTokenizer tk = new StringTokenizer(lecTime);
		ArrayList<Integer> rowcol = new ArrayList<Integer>();

		while (tk.hasMoreTokens()) {
			String temp = tk.nextToken();
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
			if(fTime > 2100)
				fTime = 2100;
			// �ð� �ش�Ǵ� ��, �� ��ġ
			int t = 900;
			for (int i = 0; i < 25; i++) {
				if (sTime >= t && sTime < t + 30) rowcol.add(i);
				if (fTime >= t && fTime < t + 30) rowcol.add(i);
				if (i % 2 == 0) t += 30;
				else t += 70;
			}
		}
		for (int i = rowcol.get(1); i <= rowcol.get(2); i++) 
			table.setValueAt(null, i, rowcol.get(0));

		if(rowcol.size() > 5){
			for (int i = rowcol.get(4); i <= rowcol.get(5); i++)
				table.setValueAt(null, i, rowcol.get(3));
		}
		return true;
	}
}