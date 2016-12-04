import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;

public class BCAllClearFunc implements ActionListener {
	JTable table1, table2, table3, table4;
	ArrayList<String> CheckIsTable;

	public BCAllClearFunc(JTable table1, JTable table2, JTable table3, JTable table4, ArrayList<String> CheckIsTable) {
		// TODO Auto-generated constructor stub
		this.table1 = table1;
		this.table2 = table2;
		this.table3 = table3;
		this.table4 = table4;
		this.CheckIsTable = CheckIsTable;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub//시간표 4개 모두 클리어
		int i = 1;
		for (; i < 5; i++) {
			if (CheckIsTable.get(i).equals("-1"))
				i++;
		}
		if (i == 5)
			JOptionPane.showMessageDialog(null, "삭제할 시간표가 없습니다");
		else {
			Cleartable(table1, CheckIsTable, 1);
			Cleartable(table2, CheckIsTable, 2);
			Cleartable(table3, CheckIsTable, 3);
			Cleartable(table4, CheckIsTable, 4);
		}
	}

	void Cleartable(JTable table, ArrayList<String> CheckIsTable, int num) {//
		for (int i = 0; i < table.getRowCount(); i++) {
			for (int j = 1; j < table.getColumnCount(); j++) {
				table.setValueAt(null, i, j);
			}
		}
		CheckIsTable.set(num, "-1");
	}
}
