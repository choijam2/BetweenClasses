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
			JOptionPane.showMessageDialog(null, "�й� �Ǵ� ������ �Է��ϼ���");
		else if(ID.length()!=8)
			JOptionPane.showMessageDialog(null, "�й��� �ٽ� �Է��ϼ���");
		else if(CheckIsTable[3]!=0)
			JOptionPane.showMessageDialog(null, "�ð�ǥ�� �߰��� �� �����ϴ�");
		else {
			try {
				ResultSet rs;
				PreparedStatement query = con.prepareStatement("select lid from course where sid = ?");

				query.setString(1, ID);
				rs = query.executeQuery();
							
				if(rs.next()==false)
					JOptionPane.showMessageDialog(null, "�ð�ǥ�� �������� �ʽ��ϴ�");
			
				for(int i=0;rs.next();i++){					
					lidlist.add(i,lid = rs.getString("lid"));
				}			
				//=================������ȣ ��������
				for(int i=0;i<4;i++)
				{
					if(CheckIsTable[i]==0){
						CheckIsTable[i] = Integer.parseInt(ID);
						switch (i) { // ���� ����
							case 0: AddTable(lidlist,rs,query,table1); break;
							case 1: AddTable(lidlist,rs,query,table2); break;
							case 2: AddTable(lidlist,rs,query,table3); break;
							case 3: AddTable(lidlist,rs,query,table4); break;
						}
						break;
					}
				}
					
			} catch (SQLException sqex) {
				JOptionPane.showMessageDialog(null, "�ð�ǥ�� �������� �ʽ��ϴ�");
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
			JOptionPane.showMessageDialog(null, "�ð�ǥ�� �������� �ʽ��ϴ�");
		}
	}
///////////////////////////////////////////////////////////////////////////////////
	public boolean stringToken(String lecTime, String lecName, String lecPlace,JTable table) {
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
