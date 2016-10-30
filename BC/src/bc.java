import java.io.File;
import java.io.IOException;
 
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
 
 
public class bc {
 
    public static void main(String[] args) {
 
         
        // 파일 객체 생성 - 엑셀파일 경로
        File file = new File("test.xls");
         
        try {
             
            // 엑셀파일 워크북 객체 생성
            Workbook workbook = Workbook.getWorkbook(file) ;
             
            // 시트 지정
            Sheet sheet = workbook.getSheet(0);
             
            // 행 길이
            int endIdx = sheet.getColumn(1).length-1;
             
             
            for(int i=0; i <= endIdx; i++){
                 
                // 첫번째 열(A)
                String number = sheet.getCell(0, i).getContents() ;
                // 두번째 열(B)
                String grade = sheet.getCell(1, i).getContents() ;
                String division = sheet.getCell(2, i).getContents() ;
                String subject = sheet.getCell(3, i).getContents() ;
                String credit = sheet.getCell(4, i).getContents() ;
                String prof = sheet.getCell(5, i).getContents() ;
                String time = sheet.getCell(6, i).getContents() ;
                String place = sheet.getCell(7, i).getContents() ;
                String dept = sheet.getCell(8, i).getContents() ;
                String note = sheet.getCell(9, i).getContents() ;

                System.out.println(number + " : " +grade + " : " +division + " : " +subject
                		 + " : " +credit + " : " +prof + " : " +time + " : " +place + " : " +dept
                		 + " : " +note) ;
                 
                 
            }
             
             
             
             
        } catch (BiffException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
 
    }
 
}