import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ReadExelFile {
	private static Connection con = null;

	public static void main(String[] args) {
		try {
			FunMysqlConnect();
		} catch (ClassNotFoundException e1) {
			System.out.println(e1.getMessage());
		}
		File file = new File("excel/lecture.xls");

		try {

			// 엑셀파일 워크북 객체 생성
			Workbook workbook = Workbook.getWorkbook(file);

			// 시트 지정
			Sheet sheet = workbook.getSheet(0);

			// 행 길이
			int endIdx = sheet.getColumn(0).length - 1;
			
			String number, grade, division, subject, credit, prof, time, place, dept, note;
			for (int i = 0; i <= endIdx; i++) {
				// 첫번째 열(A)
				number = sheet.getCell(0, i).getContents();
				grade = sheet.getCell(1, i).getContents();
				division = sheet.getCell(2, i).getContents();
				subject = sheet.getCell(3, i).getContents();
				credit = sheet.getCell(4, i).getContents();
				prof = sheet.getCell(5, i).getContents();
				time = sheet.getCell(6, i).getContents();
				place = sheet.getCell(7, i).getContents();
				dept = sheet.getCell(8, i).getContents();
				note = sheet.getCell(9, i).getContents();
				
				PreparedStatement query = con
						.prepareStatement("insert into lecture values(?,?,?,?,?,?,?,?,?,?)");
				
				query.setString(1, number);
				query.setString(2, grade);
				query.setString(3, division);
				query.setString(4, subject);
				query.setString(5, credit);
				query.setString(6, prof);
				query.setString(7, time);
				query.setString(8, place);
				query.setString(9, dept);
				query.setString(10, note);
				
				int cnt = query.executeUpdate();
				if(cnt == 1)
					System.out.println("수강번호 = " + number + " 등록 완료");
			}

		} catch (BiffException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch(SQLException eqex){
			System.out.println(eqex.getMessage());
		}
	}

	public static void FunMysqlConnect() throws ClassNotFoundException {
		try {
			String url = "jdbc:mysql://dbs.yu.ac.kr:3306/seproject?useSSL=true&verifyServerCertificate=false&useUnicode=true&characterEncoding=utf8";

			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, "seproject", "rhdrkd1!@");
			System.out.println("Mysql Connect!");
		} catch (SQLException sqex) {
			System.out.println(sqex.getMessage());
			System.out.println(sqex.getSQLState());
		}
	}
}