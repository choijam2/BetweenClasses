import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class BCAddFunc implements ActionListener {
	Connection con;
	JTextField PftextField, STtextField;
	JTable table1, table2, table3, table4;
	ArrayList<String> CheckIsTable;
	String lid;

	public BCAddFunc(Connection con, JTable table1, JTable table2, JTable table3, JTable table4, JTextField PftextField,
			JTextField STtextField, ArrayList<String> CheckIsTable) {
		// TODO Auto-generated constructor stub
		this.con = con;
		this.PftextField = PftextField;
		this.STtextField = STtextField;
		this.table1 = table1;
		this.table2 = table2;
		this.table3 = table3;
		this.table4 = table4;
		this.CheckIsTable = CheckIsTable;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("Pfadd")) {

			PFadd(PftextField);// 교수 추가함수

		} else {
			if (CheckIsTable.get(0).equals(STtextField.getText())) {
				JOptionPane.showMessageDialog(null, "자신의 시간표는 추가할 수 없습니다");
			} else {
				STadd(STtextField);// 학생 추가 함수
			}
		}
		// TODO Auto-generated method stub
	}

	void PFadd(JTextField field) {
		String ID = field.getText();
		ArrayList<String> lidlist = new ArrayList<String>();
		if (ID.equals(""))
			JOptionPane.showMessageDialog(null, "성함을 입력하세요");
		else if (CheckFull(CheckIsTable))
			JOptionPane.showMessageDialog(null, "시간표를 추가할 수 없습니다");
		else if (CheckSame(CheckIsTable, ID))
			JOptionPane.showMessageDialog(null, "동일한 시간표가 있습니다");
		else {
			try {
				PreparedStatement query = con.prepareStatement("select lid from lecture where pname = ?");

				query.setString(1, ID);
				ResultSet rs = query.executeQuery();
				if (CheckGetEmptyResult(rs, lidlist)) {					
					JOptionPane.showMessageDialog(null, "시간표가 존재하지 않습니다");
				} else {
					Getlib(rs, lidlist, query, ID);// 입력받은 값에 대한 수강번호를 가져오고 시간표를
													// 뿌려주는 함수
				}
			} catch (SQLException sqex) {
				JOptionPane.showMessageDialog(null, "시간표가 존재하지 않습니다");
			}
		}
	}

	/////////////////////////////////////////////
	void STadd(JTextField field) {// 학생추가함수
		String ID = field.getText();
		ArrayList<String> lidlist = new ArrayList<String>();
		if (ID.equals(""))
			JOptionPane.showMessageDialog(null, "학번을 입력하세요");
		else if (ID.length() != 8)
			JOptionPane.showMessageDialog(null, "학번을 다시 입력하세요");
		else if (CheckFull(CheckIsTable))
			JOptionPane.showMessageDialog(null, "시간표를 추가할 수 없습니다");
		else if (CheckSame(CheckIsTable, ID))
			JOptionPane.showMessageDialog(null, "동일한 시간표가 있습니다");
		else {
			try {
				PreparedStatement query = con.prepareStatement("select lid from course where sid = ?");

				query.setString(1, ID);
				ResultSet rs = query.executeQuery();

				if (CheckGetEmptyResult(rs, lidlist)) {
					JOptionPane.showMessageDialog(null, "시간표가 존재하지 않습니다");
				} else {
					Getlib(rs, lidlist, query, ID);// 입력받은 값에 대한 수강번호를 가져오고 시간표를
													// 뿌려주는 함수
				}
			} catch (SQLException sqex) {
				JOptionPane.showMessageDialog(null, "시간표가 존재하지 않습니다");
			}
		}
	}

	///////////////////////
	boolean CheckFull(ArrayList<String> CheckIsTable) {// 리스트가 풀인지 체크 초기값은 모두 -1
		for (int i = 1; i < 5; i++) {
			if (CheckIsTable.contains("-1"))
				return false;
		}
		return true;
	}

	boolean CheckSame(ArrayList<String> CheckIsTable, String ID) {// 입력받은 값과 같은
																	// 시간표가 있는지
																	// 확인
		if (CheckIsTable.contains(ID)) {
			return true;
		}
		return false;
	}

	boolean CheckGetEmptyResult(ResultSet rs, ArrayList<String> lidlist) {// 쿼리실행은
																			// 정상적으로
																			// 작동했지만
																			// 결과값이
																			// 비었을때
																			// 체크하는
																			// 함수
		try {
			if (rs.next() == false) {
				rs.previous();
				return true;
			}	
			rs.previous();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	////////////////////////////////////////////////////////////////////////////////////
	void Getlib(ResultSet rs, ArrayList<String> lidlist, PreparedStatement query, String ID) {//
		try {
			for (int i = 0; rs.next(); i++) {// 받아온 수강번호를 배열리스트에 입력!
				lidlist.add(rs.getString("lid"));
			}
			for (int i = 1; i < 5; i++) {
				if (CheckIsTable.get(i).equals("-1")) {// 빈 시간표를 찾아서
					CheckIsTable.set(i, ID);// 해당 번지의 배열에 해당 아이디를 입력
					switch (i) {// 해당 번지의 시간표에 시간표 출력
					case 1:
						AddTable(lidlist, rs, query, table1);
						break;
					case 2:
						AddTable(lidlist, rs, query, table2);
						break;
					case 3:
						AddTable(lidlist, rs, query, table3);
						break;
					case 4:
						AddTable(lidlist, rs, query, table4);
						break;
					}
					break;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	///////////////////////////////////////////////////////////////////////////////////
	void AddTable(ArrayList<String> lidlist, ResultSet rs, PreparedStatement query, JTable table) {// 수강번호를
																									// 시간표에
																									// 뿌려주는과정
		try {
			for (int i = 0; i < lidlist.size(); i++) {
				query = con.prepareStatement("select lname, ltime, place from lecture where lid = ?");
				query.setString(1, lidlist.get(i));
				rs = query.executeQuery();
				if (rs.next()) {
					String lecTime = rs.getString("ltime");
					String lecName = rs.getString("lname");
					String lecPlace = rs.getString("place");
					stringToken(lecTime, lecName, lecPlace, table);
				}
			}
		} catch (SQLException sqex) {
			JOptionPane.showMessageDialog(null, "시간표가 존재하지 않습니다");
		}
	}

	///////////////////////////////////////////////////////////////////////////////////
	public boolean stringToken(String lecTime, String lecName, String lecPlace, JTable table) {
		StringTokenizer tk = new StringTokenizer(lecTime);
		StringTokenizer tk2 =new StringTokenizer(lecPlace);
		ArrayList<Integer> rowcol = new ArrayList<Integer>();
		String ptemp = null;
		
		while (tk.hasMoreTokens() && tk2.hasMoreTokens()) {
			String temp = tk.nextToken();
			ptemp = tk2.nextToken();
			char day = temp.charAt(0);

			switch (day) { // 요일 지정
			case '월':
				rowcol.add(1);
				break;
			case '화':
				rowcol.add(2);
				break;
			case '수':
				rowcol.add(3);
				break;
			case '목':
				rowcol.add(4);
				break;
			case '금':
				rowcol.add(5);
				break;
			case '토':
				rowcol.add(6);
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
			for (int i = 0; i < 25; i++) {
				if (sTime >= t && sTime < t + 30)
					rowcol.add(i);
				if (fTime >= t && fTime < t + 30)
					rowcol.add(i);
				if (i % 2 == 0)
					t += 30;
				else
					t += 70;
			}
		}
		if(rowcol.size()==2){///수정
			table.setValueAt(lecName, rowcol.get(1), rowcol.get(0));
			table.setValueAt(ptemp, rowcol.get(1)+1, rowcol.get(0));
			for(int i=rowcol.get(1)+2;i<25;i++){
				table.setValueAt("", i, rowcol.get(0));
			}
			return true;
		}
		
		for (int i = rowcol.get(1); i <= rowcol.get(2); i++) {
			if (i == rowcol.get(1))
				table.setValueAt(lecName, i, rowcol.get(0));
			else if (i == rowcol.get(1) + 1)
				table.setValueAt(ptemp, i, rowcol.get(0));
			else
				table.setValueAt("", i, rowcol.get(0));
		}
		if (rowcol.size() > 5) {
			for (int i = rowcol.get(4); i <= rowcol.get(5); i++) {
				if (i == rowcol.get(4))
					table.setValueAt(lecName, i, rowcol.get(3));
				else if (i == rowcol.get(4) + 1)
					table.setValueAt(ptemp, i, rowcol.get(3));
				else
					table.setValueAt("", i, rowcol.get(3));
			}
		}
		return true;
	}

}
