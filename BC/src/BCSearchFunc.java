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

import javax.swing.JTable;

//공강 찾기 버튼을 클릭시

public class BCSearchFunc implements ActionListener{
	Connection con;
	public BCSearchFunc(Connection con, String s1, String s2, String s3, String s4, String s5) {
		this.con=con;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			new ResultFrame(con,"21111811","21111827","-1","-1","-1");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
