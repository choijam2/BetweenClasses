////import java.awt.event.ActionEvent;
////import java.awt.event.ActionListener;
////
////import javax.swing.JTable;
////
////public class BCSearchFunc implements ActionListener{
////	Object[][] o1, o2, o3, o4, o5;
////	public BCSearchFunc(Object[][] o1, Object[][] o2, Object[][] o3, Object[][] o4, Object[][] o5) {
////		// TODO Auto-generated constructor stub
////		this.o1 = o1;
////		this.o2 = o2;
////		this.o3 = o3;
////		this.o4 = o4;
////		this.o5 = o5;
////	}
////	@Override
////	public void actionPerformed(ActionEvent e) {
////		// TODO Auto-generated method stub
////	}
////}
//
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import javax.swing.JTable;
//import javax.swing.table.DefaultTableModel;
//
////공강 찾기 버튼을 클릭시
//
//public class BCSearchFunc implements ActionListener{
//	JTable BCTable;
//	JTable Mytable;
//	JTable table1;
//	JTable table2;
//	JTable table3;
//	JTable table4;
//	
//	public BCSearchFunc(JTable Mytable,JTable table1,JTable table2,JTable table3,JTable table4) {
//		this.Mytable = Mytable;
//		this.table1 = table1;
//		this.table2 = table2;
//		this.table3 = table3;
//		this.table4 = table4;
//	}
//	
//	
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		Object[][] defTableTime = new Object[][] { 
//			{ "9:00 ~ 9:30", 0, 0, 0, 0, 0, 0 },
//			{ "9:30 ~ 10:00", 0, 0, 0, 0, 0, 0 },
//			{ "10:00 ~ 10:30", 0, 0, 0, 0, 0, 0 },
//			{ "10:30 ~ 11:00", 0, 0, 0, 0, 0, 0 },
//			{ "11:00 ~ 11:30", 0, 0, 0, 0, 0, 0 },
//			{ "11:30 ~ 12:00", 0, 0, 0, 0, 0, 0 },
//			{ "12:00 ~ 12:30", 0, 0, 0, 0, 0, 0 },
//			{ "12:30 ~ 13:00", 0, 0, 0, 0, 0, 0 },
//			{ "13:00 ~ 13:30", 0, 0, 0, 0, 0, 0 },
//			{ "13:30 ~ 14:00", 0, 0, 0, 0, 0, 0 },
//			{ "14:00 ~ 14:30", 0, 0, 0, 0, 0, 0 },
//			{ "14:30 ~ 15:00", 0, 0, 0, 0, 0, 0 },
//			{ "15:00 ~ 15:30", 0, 0, 0, 0, 0, 0 },
//			{ "15:30 ~ 16:00", 0, 0, 0, 0, 0, 0 },
//			{ "16:00 ~ 16:30", 0, 0, 0, 0, 0, 0 },
//			{ "16:30 ~ 17:00", 0, 0, 0, 0, 0, 0 },
//			{ "17:00 ~ 17:30", 0, 0, 0, 0, 0, 0 },
//			{ "17:30 ~ 18:00", 0, 0, 0, 0, 0, 0 },
//			{ "18:00 ~ 18:30", 0, 0, 0, 0, 0, 0 },
//			{ "18:30 ~ 19:00", 0, 0, 0, 0, 0, 0 },
//			{ "19:00 ~ 19:30", 0, 0, 0, 0, 0, 0 },
//			{ "19:30 ~ 20:00", 0, 0, 0, 0, 0, 0 },
//			{ "20:00 ~ 20:30", 0, 0, 0, 0, 0, 0 },
//			{ "20:30 ~ 21:00", 0, 0, 0, 0, 0, 0 },
//			{ "21:00 ~", 0, 0, 0, 0, 0, 0 } };
//		String[] defDays = new String[] { "Time", "월", "화", "수", "목", "금", "토" };
//		BCTable = new JTable();
//		BCTable.setModel(new DefaultTableModel(defTableTime, defDays));
//		for(int i=0;i<BCTable.getRowCount();i++){
//			for(int j=1;j<BCTable.getColumnCount();j++){
//				if(table1.getValueAt(i, j)!=null){
//					BCTable.setValueAt((int)BCTable.getValueAt(i, j)+1,i, j);
//				}
//				if(table2.getValueAt(i, j)!=null){
//					BCTable.setValueAt((int)BCTable.getValueAt(i, j)+1,i, j);
//				}
//				if(table3.getValueAt(i, j)!=null){
//					BCTable.setValueAt((int)BCTable.getValueAt(i, j)+1,i, j);
//				}
//				if(table4.getValueAt(i, j)!=null){
//					BCTable.setValueAt((int)BCTable.getValueAt(i, j)+1,i, j);
//				}
//				if(Mytable.getValueAt(i, j)!=null){
//					BCTable.setValueAt((int)BCTable.getValueAt(i, j)+1,i, j);				
//				}		
//			}
//		}
//		try {
//			ResultFrame Rf= new ResultFrame(BCTable);
//		} 
//		catch (ClassNotFoundException e1) {
//			e1.printStackTrace();
//		} 
//	}
//}
//	

//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.JTable;
//
//public class BCSearchFunc implements ActionListener{
//	Object[][] o1, o2, o3, o4, o5;
//	public BCSearchFunc(Object[][] o1, Object[][] o2, Object[][] o3, Object[][] o4, Object[][] o5) {
//		// TODO Auto-generated constructor stub
//		this.o1 = o1;
//		this.o2 = o2;
//		this.o3 = o3;
//		this.o4 = o4;
//		this.o5 = o5;
//	}
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		// TODO Auto-generated method stub
//	}
//}

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTable;

//공강 찾기 버튼을 클릭시

public class BCSearchFunc implements ActionListener{
	Connection con;
	ArrayList<String> CheckIsTable;
	public BCSearchFunc(Connection con,	ArrayList<String> CheckIsTable) {
		this.con=con;
		this.CheckIsTable = CheckIsTable;
	}
	
	


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			new ResultFrame(con,CheckIsTable.get(0),CheckIsTable.get(1),CheckIsTable.get(2),CheckIsTable.get(3),CheckIsTable.get(4));
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}

