import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;

public class RandomRecommend implements ActionListener{
	JTable table;
	Object obj;
	public RandomRecommend(JTable table, Object obj) {
		// TODO Auto-generated constructor stub
		this.obj = obj;
		this.table = table;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
