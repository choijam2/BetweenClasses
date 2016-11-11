import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTable;

public class TimeTableSearchClassesFunc implements ActionListener{
   String grade,college,dept,lname;
   Connection con;
   JTable table;
   @Override
   public void actionPerformed(ActionEvent e) {
      // TODO Auto-generated method stub
      ResultSet rs;
      PreparedStatement st;
   }
      
}