import java.awt.FileDialog;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.JTableHeader;

//
public class BtnSaveFunc implements ActionListener { 
		JFileChooser ExFilechooser ; // JFileChooser ��ü ����
		JTable var_table=null;
		BufferedImage img=null;
		BtnSaveFunc(JTable savetable) throws Exception{
			var_table=savetable; // ���� ���̺��� ����
			ExFilechooser =  new JFileChooser(); // JFileChooser ��ü ����
		}
		
		// Table -> BufferedImage
		
		public static BufferedImage getSaveSnapShot(JTable table, JTableHeader header) throws Exception {
    	int w = Math.max(table.getWidth(),header.getWidth());
    	int h = table.getHeight()+header.getHeight(); // header ����
    	// ���� ���̺��� BufferedImage�� �׸���
        BufferedImage img = new BufferedImage(w, h,BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = img.createGraphics();
        header.paint(g2);
        g2.translate(0, header.getHeight());
        table.paint(g2);
        g2.dispose();
        return img;
        
    }

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		try {
				File saveFile;
				String savePath;
				FileNameExtensionFilter exfilter = new FileNameExtensionFilter("JPEG&PNG","jpg","png");
				// JfileChooser�� ���� ���� ����
				ExFilechooser.setFileFilter(exfilter);
				int intRet = ExFilechooser.showSaveDialog(null);
				if( intRet == JFileChooser.APPROVE_OPTION)
					{
					   saveFile = ExFilechooser.getSelectedFile();
					   savePath=saveFile.getPath(); // File path
					}
				else
					{
					   JOptionPane.showMessageDialog(null, "������ �������� �ʾҽ��ϴ�.", "���", JOptionPane.WARNING_MESSAGE);
					     return;
					}
					    String filePath = ExFilechooser.getSelectedFile().getPath()+".jpg";
					    try
					    {
					    	img=getSaveSnapShot(var_table,var_table.getTableHeader());
					        ImageIO.write(img, "jpg", new File(filePath));
					    }
					    
					    catch(Exception ex){
					    	ex.printStackTrace();
					    }
					 
					 
					 
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				}
			
		}


