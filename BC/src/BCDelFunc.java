import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class BCDelFunc implements ActionListener {
	JTable table;
	JTextField PftextField, STtextField;
	JTable table1, table2, table3, table4;
	ArrayList<String> CheckIsTable;

	public BCDelFunc(JTable table1, JTable table2, JTable table3, JTable table4, JTextField PftextField,
			JTextField STtextField, ArrayList<String> CheckIsTable) {
		// TODO Auto-generated constructor stub
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
		
		if (e.getActionCommand().equals("Pfdel")) {
			
			Del(PftextField.getText());// �����Լ�
			
		} else {
			if (CheckIsTable.get(0).equals(STtextField.getText())) {
				JOptionPane.showMessageDialog(null, "�ڽ��� �ð�ǥ�� ������ �� �����ϴ�");
			} else {
				Del(STtextField.getText());
			}
		}

		// TODO Auto-generated method stub
		// if(field.equals(){
		// table.setModel(new BasicTableModel());
		// }
	}

	void Del(String ID) {// �����Լ�
		System.out.println("====="+ID+"=====\n");
		if (ID.equals(""))
			JOptionPane.showMessageDialog(null, "�ٽ� �Է��ϼ���");
		else if (!CheckSame(CheckIsTable, ID))
			JOptionPane.showMessageDialog(null, "������  �ð�ǥ�� �����ϴ�");
		else {
			for (int i = 1; i < 5; i++) {
				if (CheckIsTable.get(i).equals(ID)) {// �Է¹��� �ؽ�Ʈ�� ���� ���̵� �迭����Ʈ��
														// �ִ��� Ȯ��
					switch (i) {// �ִٸ� �ش� ���̺� Ŭ����
					case 1:
						Cleartable(table1, CheckIsTable, 1);
						break;
					case 2:
						Cleartable(table2, CheckIsTable, 2);
						break;
					case 3:
						Cleartable(table3, CheckIsTable, 3);
						break;
					case 4:
						Cleartable(table4, CheckIsTable, 4);
						break;
					}
					break;
				}
			}
		}
	}

	void Cleartable(JTable table, ArrayList<String> CheckIsTable, int num) {// ���̺�
																			// �ʱ�ȭ
																			// �Լ�
		for (int i = 0; i < table.getRowCount(); i++) {
			for (int j = 1; j < table.getColumnCount(); j++) {
				table.setValueAt(null, i, j);// �ش� ���̺��� ���� ��� NULL�� �ٲ�
			}
		}
		CheckIsTable.set(num, "-1");// �ش� �迭����Ʈ�� ���� -1�� �ʱ�ȭ
	}

	boolean CheckSame(ArrayList<String> CheckIsTable, String ID) {// �ش� �ð�ǥ�� �ִ���
																	// Ȯ��

		if (CheckIsTable.contains(ID)) {
			return true;
		}
		return false;
	}
}