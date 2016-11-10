import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MockAddBtnHandler implements ActionListener{
	JTextField lid;
	Connection con;
	public MockAddBtnHandler(JTextField lid, Connection con) {
		this.lid = lid;
		this.con = con;
	}
	@Override
	public void actionPerformed(ActionEvent a) {
		String lectureId = lid.getText();
		
		if(lectureId.equals(""))
			JOptionPane.showMessageDialog(null, "수강번호를 입력하세요.");
		else{
			try{
				ResultSet rs;
				PreparedStatement query = con.prepareStatement("select ltime from lecture where lid = ?");
				
				query.setString(1, lectureId);
				rs = query.executeQuery();
				
				if(rs.next()){
					String lecTime = rs.getString("ltime");
					
					System.out.println(lecTime);
				}
				
			}catch(SQLException sqex){
				System.out.println(sqex.getMessage());
				System.out.println(sqex.getSQLState());
			}
		}
	}
}