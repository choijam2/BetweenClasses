import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

//공강 찾기 버튼을 클릭시

public class BCSearchFunc implements ActionListener{
	Connection con;
	ArrayList<String> CheckIsTable;
	StudentMaster st;
	public BCSearchFunc(Connection con,	ArrayList<String> CheckIsTable,StudentMaster st) {
		this.con=con;
		this.CheckIsTable = CheckIsTable;
		this.st = st;
	}
	
	


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			int ck = 1;
			for(int i =0;i<CheckIsTable.size();i++)
			{
				if(CheckIsTable.get(i).length()!=8&&CheckIsTable.get(i)!="-1"){
					ck = 0;
					break;
				}
			}
			if(ck==1){
				
				new SelcetMaster(con,CheckIsTable,st);
			}
			else
				new ResultFrame(con,st,CheckIsTable);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}

