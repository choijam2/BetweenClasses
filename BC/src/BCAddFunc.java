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

			PFadd(PftextField);// ���� �߰��Լ�

		} else {
			if (CheckIsTable.get(0).equals(STtextField.getText())) {
				JOptionPane.showMessageDialog(null, "�ڽ��� �ð�ǥ�� �߰��� �� �����ϴ�");
			} else {
				STadd(STtextField);// �л� �߰� �Լ�
			}
		}
		// TODO Auto-generated method stub
	}

	void PFadd(JTextField field) {
		String ID = field.getText();
		ArrayList<String> lidlist = new ArrayList<String>();
		if (ID.equals(""))
			JOptionPane.showMessageDialog(null, "������ �Է��ϼ���");
		else if (CheckFull(CheckIsTable))
			JOptionPane.showMessageDialog(null, "�ð�ǥ�� �߰��� �� �����ϴ�");
		else if (CheckSame(CheckIsTable, ID))
			JOptionPane.showMessageDialog(null, "������ �ð�ǥ�� �ֽ��ϴ�");
		else {
			try {
				PreparedStatement query = con.prepareStatement("select lid from lecture where pname = ?");

				query.setString(1, ID);
				ResultSet rs = query.executeQuery();
				if (CheckGetEmptyResult(rs, lidlist)) {					
					JOptionPane.showMessageDialog(null, "�ð�ǥ�� �������� �ʽ��ϴ�");
				} else {
					Getlib(rs, lidlist, query, ID);// �Է¹��� ���� ���� ������ȣ�� �������� �ð�ǥ��
													// �ѷ��ִ� �Լ�
				}
			} catch (SQLException sqex) {
				JOptionPane.showMessageDialog(null, "�ð�ǥ�� �������� �ʽ��ϴ�");
			}
		}
	}

	/////////////////////////////////////////////
	void STadd(JTextField field) {// �л��߰��Լ�
		String ID = field.getText();
		ArrayList<String> lidlist = new ArrayList<String>();
		if (ID.equals(""))
			JOptionPane.showMessageDialog(null, "�й��� �Է��ϼ���");
		else if (ID.length() != 8)
			JOptionPane.showMessageDialog(null, "�й��� �ٽ� �Է��ϼ���");
		else if (CheckFull(CheckIsTable))
			JOptionPane.showMessageDialog(null, "�ð�ǥ�� �߰��� �� �����ϴ�");
		else if (CheckSame(CheckIsTable, ID))
			JOptionPane.showMessageDialog(null, "������ �ð�ǥ�� �ֽ��ϴ�");
		else {
			try {
				PreparedStatement query = con.prepareStatement("select lid from course where sid = ?");

				query.setString(1, ID);
				ResultSet rs = query.executeQuery();

				if (CheckGetEmptyResult(rs, lidlist)) {
					JOptionPane.showMessageDialog(null, "�ð�ǥ�� �������� �ʽ��ϴ�");
				} else {
					Getlib(rs, lidlist, query, ID);// �Է¹��� ���� ���� ������ȣ�� �������� �ð�ǥ��
													// �ѷ��ִ� �Լ�
				}
			} catch (SQLException sqex) {
				JOptionPane.showMessageDialog(null, "�ð�ǥ�� �������� �ʽ��ϴ�");
			}
		}
	}

	///////////////////////
	boolean CheckFull(ArrayList<String> CheckIsTable) {// ����Ʈ�� Ǯ���� üũ �ʱⰪ�� ��� -1
		for (int i = 1; i < 5; i++) {
			if (CheckIsTable.contains("-1"))
				return false;
		}
		return true;
	}

	boolean CheckSame(ArrayList<String> CheckIsTable, String ID) {// �Է¹��� ���� ����
																	// �ð�ǥ�� �ִ���
																	// Ȯ��
		if (CheckIsTable.contains(ID)) {
			return true;
		}
		return false;
	}

	boolean CheckGetEmptyResult(ResultSet rs, ArrayList<String> lidlist) {// ����������
																			// ����������
																			// �۵�������
																			// �������
																			// �������
																			// üũ�ϴ�
																			// �Լ�
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
			for (int i = 0; rs.next(); i++) {// �޾ƿ� ������ȣ�� �迭����Ʈ�� �Է�!
				lidlist.add(rs.getString("lid"));
			}
			for (int i = 1; i < 5; i++) {
				if (CheckIsTable.get(i).equals("-1")) {// �� �ð�ǥ�� ã�Ƽ�
					CheckIsTable.set(i, ID);// �ش� ������ �迭�� �ش� ���̵� �Է�
					switch (i) {// �ش� ������ �ð�ǥ�� �ð�ǥ ���
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
	void AddTable(ArrayList<String> lidlist, ResultSet rs, PreparedStatement query, JTable table) {// ������ȣ��
																									// �ð�ǥ��
																									// �ѷ��ִ°���
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
			JOptionPane.showMessageDialog(null, "�ð�ǥ�� �������� �ʽ��ϴ�");
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

			switch (day) { // ���� ����
			case '��':
				rowcol.add(1);
				break;
			case 'ȭ':
				rowcol.add(2);
				break;
			case '��':
				rowcol.add(3);
				break;
			case '��':
				rowcol.add(4);
				break;
			case '��':
				rowcol.add(5);
				break;
			case '��':
				rowcol.add(6);
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
		if(rowcol.size()==2){///����
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
