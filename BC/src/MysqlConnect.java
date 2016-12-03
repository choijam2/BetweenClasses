import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConnect {
	private Connection con;
	MysqlConnect() throws ClassNotFoundException{
		try{
			String url = "jdbc:mysql://dbs.yu.ac.kr:3306/seproject?useSSL=true&verifyServerCertificate=false&useUnicode=true&characterEncoding=utf8";
			//String url = "jdbc:mysql://localhost:9000/seproject?useSSL=true&verifyServerCertificate=false&useUnicode=true&characterEncoding=utf8";
			
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, "seproject", "rhdrkd1!@");
			
		}catch(SQLException sqex){
			System.out.println(sqex.getMessage());
			System.out.println(sqex.getSQLState());
		}
	}
	public Connection getCon(){
		return con;
	}
}
