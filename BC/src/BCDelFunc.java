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
	JButton button;

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

		button = (JButton) e.getSource();//어떤 버튼이 눌렸는지에 따라 학생 또는 교수 선택
		if (button.getText().equals("교수삭제")) {

			Del(PftextField.getText());//삭제함수

		} else {

			Del(STtextField.getText());

		}

		// TODO Auto-generated method stub
		// if(field.equals(){
		// table.setModel(new BasicTableModel());
		// }
	}

	void Del(String ID) {//삭제함수
		if (ID.equals(""))
			JOptionPane.showMessageDialog(null, "다시 입력하세요");
		else if (!CheckSame(CheckIsTable, ID))
			JOptionPane.showMessageDialog(null, "삭제할  시간표가 없습니다");
		else {
			for (int i = 0; i < 4; i++) {
				if (CheckIsTable.get(i).equals(ID)) {//입력받은 텍스트와 같은 아이디가 배열리스트에 있는지 확인
					switch (i) {//있다면 해당 테이블 클리어
					case 0:
						Cleartable(table1, CheckIsTable, 0);
						break;
					case 1:
						Cleartable(table2, CheckIsTable, 1);
						break;
					case 2:
						Cleartable(table3, CheckIsTable, 2);
						break;
					case 3:
						Cleartable(table4, CheckIsTable, 3);
						break;
					}
					break;
				}
			}
		}
	}

	void Cleartable(JTable table, ArrayList<String> CheckIsTable, int num) {//테이블 초기화 함수
		for (int i = 0; i < table.getRowCount(); i++) {
			for (int j = 1; j < table.getColumnCount(); j++) {
				table.setValueAt(null, i, j);//해당 테이블의 값을 모두 NULL로 바꿈
			}
		}
		CheckIsTable.set(num, "-1");//해당 배열리스트의 값을 -1로 초기화
	}

	boolean CheckSame(ArrayList<String> CheckIsTable, String ID) {//해당 시간표가 있는지 확인
		for (int i = 0; i < 4; i++) {
			if (CheckIsTable.contains(ID))
				return true;
		}
		return false;
	}
}