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

public class BCAddFunc implements ActionListener{
	Connection con;
	JTextField field;
	JTable table1,table2,table3,table4;
	int[] CheckIsTable; 
	boolean who;
	String lid;
	public BCAddFunc(Connection con,JTable table1,JTable table2,JTable table3,JTable table4, JTextField field, boolean who, int[] CheckIsTable) {
		// TODO Auto-generated constructor stub
		this.con = con;
		this.field = field;
		this.who = who;
		this.table1 = table1;
		this.table2 = table2;
		this.table3 = table3;
		this.table4 = table4;
		this.CheckIsTable = CheckIsTable;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String ID = field.getText();
		ArrayList<String> lidlist = new ArrayList<String>(); 
		if (ID.equals(""))
			JOptionPane.showMessageDialog(null, "학번 또는 성함을 입력하세요");
		else if(ID.length()!=8)
			JOptionPane.showMessageDialog(null, "학번을 다시 입력하세요");
		else if(CheckIsTable[3]!=0)
			JOptionPane.showMessageDialog(null, "시간표를 추가할 수 없습니다");
		else {
			try {
				ResultSet rs;
				PreparedStatement query = con.prepareStatement("select lid from course where sid = ?");

				query.setString(1, ID);
				rs = query.executeQuery();
							
				if(rs.next()==false)
					JOptionPane.showMessageDialog(null, "시간표가 존재하지 않습니다");
			
				for(int i=0;rs.next();i++){					
					lidlist.add(i,lid = rs.getString("lid"));
				}			
				//=================수강번호 가져오기
				for(int i=0;i<4;i++)
				{
					if(CheckIsTable[i]==0){
						CheckIsTable[i] = Integer.parseInt(ID);
						switch (i) { // 요일 지정
							case 0: AddTable(lidlist,rs,query,table1); break;
							case 1: AddTable(lidlist,rs,query,table2); break;
							case 2: AddTable(lidlist,rs,query,table3); break;
							case 3: AddTable(lidlist,rs,query,table4); break;
						}
						break;
					}
				}
					
			} catch (SQLException sqex) {
				JOptionPane.showMessageDialog(null, "시간표가 존재하지 않습니다");
			}
		}
	}
	///////////////////////////////////////////////////////////////////////////////////
	void AddTable(ArrayList<String> lidlist,ResultSet rs,PreparedStatement query,JTable table){
		try{
		for(int i=0; i < lidlist.size();i++){
			query = con.prepareStatement("select lname, ltime, place from lecture where lid = ?");
			query.setString(1, lidlist.get(i));
			rs = query.executeQuery();
			if(rs.next()){
				String lecTime = rs.getString("ltime");
				String lecName = rs.getString("lname");
				String lecPlace = rs.getString("place");
				boolean ck = stringToken(lecTime,lecName,lecPlace,table);
			}
		}
		} catch (SQLException sqex) {
			JOptionPane.showMessageDialog(null, "시간표가 존재하지 않습니다");
		}
	}
///////////////////////////////////////////////////////////////////////////////////
	public boolean stringToken(String lecTime, String lecName, String lecPlace,JTable table) {
		StringTokenizer tk = new StringTokenizer(lecTime);
		ArrayList<Integer> rowcol = new ArrayList<Integer>();

		while (tk.hasMoreTokens()) {
			String temp = tk.nextToken();
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
			// 시간 해당되는 행, 열 위치
			int t = 900;
			for (int i = 0; i < 26; i++) {
				if (sTime >= t && sTime < t + 30) rowcol.add(i);
				if (fTime >= t && fTime < t + 30) rowcol.add(i);
				if (i % 2 == 0) t += 30;
				else t += 70;
			}
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
				table.setValueAt(lecPlace, i, rowcol.get(0));
			else
				table.setValueAt("", i, rowcol.get(0));
		}
		if (rowcol.size() > 5) {
			for (int i = rowcol.get(4); i <= rowcol.get(5); i++) {
				if (i == rowcol.get(4))
					table.setValueAt(lecName, i, rowcol.get(3));
				else if (i == rowcol.get(4) + 1)
					table.setValueAt(lecPlace, i, rowcol.get(3));
				else
					table.setValueAt("", i, rowcol.get(3));
			}
		}
	return true;
	}
	
}
