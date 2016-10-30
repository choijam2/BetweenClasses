import java.io.File;
import java.io.IOException;
 
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
 
 
public class bc {
 
    public static void main(String[] args) {
 
         
        // ���� ��ü ���� - �������� ���
        File file = new File("test.xls");
         
        try {
             
            // �������� ��ũ�� ��ü ����
            Workbook workbook = Workbook.getWorkbook(file) ;
             
            // ��Ʈ ����
            Sheet sheet = workbook.getSheet(0);
             
            // �� ����
            int endIdx = sheet.getColumn(1).length-1;
             
             
            for(int i=0; i <= endIdx; i++){
                 
                // ù��° ��(A)
                String number = sheet.getCell(0, i).getContents() ;
                // �ι�° ��(B)
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