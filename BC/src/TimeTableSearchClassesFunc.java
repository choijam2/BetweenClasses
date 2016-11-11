import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JTable;

public class TimeTableSearchClassesFunc implements ActionListener{
    String grade,college,dept,lname;
	Connection con;
   JTable table;
   
   TimeTableSearchClassesFunc(String grade,String college,String dept,String lname,Connection con,JTable table,JFrame frame){
	   this.con = con;
	   this.table = table;
	   this.college = college;
	   this.dept = dept;
	   this.lname = lname;
	   this.grade = grade;
   }
   @Override
   public void actionPerformed(ActionEvent e) {
      // TODO Auto-generated method stub
      ResultSet rs;
      PreparedStatement st;
   }
      
}