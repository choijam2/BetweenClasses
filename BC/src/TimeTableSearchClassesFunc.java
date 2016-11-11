import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JTable;

public class TimeTableSearchClassesFunc implements ActionListener{
    JFrame frame;
	Connection con;
   JTable table;
   
   TimeTableSearchClassesFunc(Connection con,JTable table,JFrame frame){
	   this.con = con;
	   this.table = table;
	   this.frame = frame;
   }
   @Override
   public void actionPerformed(ActionEvent e) {
      // TODO Auto-generated method stub
      ResultSet rs;
      PreparedStatement st;
   }
      
}