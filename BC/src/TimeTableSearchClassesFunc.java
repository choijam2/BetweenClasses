import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class TimeTableSearchClassesFunc implements ActionListener {
	JComboBox<String> level, college, dept;
	JTextField lname;
	Connection con;
	JTable table;
	DefaultTableModel model;
	TimeTableSearchClassesFunc(JComboBox<String> level, JComboBox<String> college, JComboBox<String> dept, JTextField lname, Connection con, JTable table, DefaultTableModel model) {
		this.con = con;
		this.table = table;
		this.college = college;
		this.dept = dept;
		this.lname = lname;
		this.level = level;
		this.model = model;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		model.setRowCount(0);
		String college = (String)this.college.getSelectedItem();
		String dept = (String)this.dept.getSelectedItem();
		int level = this.level.getSelectedIndex();
		String lname = this.lname.getText();
		String arr[] = {"수강번호", "학년", "이수구분", "과목", "학점", "교수", "강의시간", "강의장소", "개설학과", "비고"};
		
		if (college.equals("전체") && dept.equals("선택") && lname.equals(""))
			JOptionPane.showMessageDialog(null, "대학/학과를 선택해주세요.");
		else {
			try {
				ResultSet rs;
				PreparedStatement query = null;
				if(college.equals("전체") && dept.equals("선택") && !lname.equals("")){
					switch(level){
					case 0: query = con.prepareStatement("select * from lecture where lname = ?"); break;
					case 1: query = con.prepareStatement("select * from lecture where lname = ? and level = 1"); break;
					case 2: query = con.prepareStatement("select * from lecture where lname = ? and level = 2"); break;
					case 3: query = con.prepareStatement("select * from lecture where lname = ? and level = 3"); break;
					case 4: query = con.prepareStatement("select * from lecture where lname = ? and level = 4"); 
					}
					query.setString(1, lname);
				} else if(!college.equals("전체") && !dept.equals("선택") && !lname.equals("")){
					switch(level){
					case 0: query = con.prepareStatement("select * from lecture where opendept = ? and lname = ?"); break;
					case 1: query = con.prepareStatement("select * from lecture where opendept = ? and lname = ? and level = 1"); break;
					case 2: query = con.prepareStatement("select * from lecture where opendept = ? and lname = ? and level = 2"); break;
					case 3: query = con.prepareStatement("select * from lecture where opendept = ? and lname = ? and level = 3"); break;
					case 4: query = con.prepareStatement("select * from lecture where opendept = ? and lname = ? and level = 4"); break;
					}
					query.setString(1, dept);
					query.setString(2, lname);
				} else{
					switch(level){
					case 0: query = con.prepareStatement("select * from lecture where opendept = ?"); break;
					case 1: query = con.prepareStatement("select * from lecture where opendept = ? and level = 1"); break;
					case 2: query = con.prepareStatement("select * from lecture where opendept = ? and level = 2"); break;
					case 3: query = con.prepareStatement("select * from lecture where opendept = ? and level = 3"); break;
					case 4: query = con.prepareStatement("select * from lecture where opendept = ? and level = 4"); break;
					}
					query.setString(1, dept);
				}
				rs = query.executeQuery();
				String str;
				
				while(rs.next()){
					for(int i=1; i<=model.getColumnCount(); i++){
						str = rs.getString(i);
						arr[i-1] = str;
					}
					model.addRow(arr);
				}
				
			} catch (SQLException sqex) {
				JOptionPane.showMessageDialog(null, "실패!");
			}
		}
	}

}