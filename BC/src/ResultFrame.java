import java.awt.AWTException;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Robot;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.LabelUI;
import javax.swing.plaf.basic.BasicLabelUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComponent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ResultFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	int[][] ex;
	private static JTable table_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					int[][] a= new int[145][7];
					for(int i=1;i<145;i++){//�迭 �Է� �κ�
						if((i>=1)&&(i<=15))
							a[i][1]=1;
						else if((i>=17)&&(i<=53))
							a[i][1]=1;
						else if((i>=55)&&(i<=69))
							a[i][1]=1;
						else if((i>=85)&&(i<= 105))
							a[i][1]=1;
						if((i>=10)&&(i<=100))
							a[i][3]=1;					}
					
					ResultFrame frame = new ResultFrame();//������ ����					
					frame.setVisible(true);				
					
					TableCellRenderer renderer = new TableCellRenderer();
					renderer.getinfo(a);//�迭�� render�� �迭�ȿ� �Է�					
					table_1.setDefaultRenderer(Class.forName("java.lang.Object"), renderer);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ClassNotFoundException 
	 */
	public ResultFrame() throws ClassNotFoundException {
		setTitle("\uBAA8\uB450\uC758 \uACF5\uAC15");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 746, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		Object Rowdata[][]={{"09:00"},{"10:00"},{"11:00"},{"12:00"},{"13:00"},{"14:00"},{"15:00"},{"16:00"},{"17:00"},
		{"18:00"},{"19:00"},{"20:00"},{"21:00"}};		
		
		Object columnNames[] = {"","��","ȭ","��","��","��","��"};
		DefaultTableModel defaultTableModel1 = new DefaultTableModel(Rowdata,columnNames){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;//����ǥ ǥ�� ���ֱ� ���� �ۼ� �Ű澵 �ʿ� ����

			public boolean isCellEditable(int row, int column){//cell ���� �Ұ� ����
				return false;
			}	
		};
		
		contentPane.setLayout(null);			
		table_1 = new JTable(defaultTableModel1);
		table_1.setBounds(37, 35, 402, 628);
		table_1.setRowHeight(50);
		table_1.setIntercellSpacing(new Dimension(1,0));//???? ������ó��??
		contentPane.add(table_1);
		
		JScrollPane scrollPane = new JScrollPane(table_1);
		scrollPane.setBounds(37, 39, 504, 675);
		contentPane.add(scrollPane);
		JButton button = new JButton("\uC800\uC7A5");
		button.setBounds(595, 186, 97, 23);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
				    Dimension d = new Dimension(504, 675);//������ �Ʒ� ��ǥ ������� ���� ���
				    Rectangle area = new Rectangle(scrollPane.getLocationOnScreen(), d.getSize());//getlocationonscreen�� �ǽð� ���ø����̼� scrollPane ��ġ�� ���� �� ������ ����Ʈ�� ����||
				    
				    Robot robot = new Robot();
				    BufferedImage bufferedImage = robot.createScreenCapture(area);
				    // ��ü ��ũ�� �� ��������
				    // Capture the whole screen
				   // area = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
				   // bufferedImage = robot.createScreenCapture(area);
				    ImageIO.write(bufferedImage,"jpg",new File("C:/Users/HBC/Desktop/screenshot.jpg"));
				    
			}catch (AWTException e){
			}catch (IOException e){
			}
			}
		});
		contentPane.add(button);
	}
}
class TableCellRenderer extends DefaultTableCellRenderer{//�迭 �� ä���
	/**
	 * 
	 */
	TableCellRenderer(){
		this.setHorizontalAlignment(SwingConstants.CENTER);
	};
	int[][] array; 
	int row_=0;
	int col =0;
	int check=0,first1=0,first2=0,end1=0,end2=0;
	private static final long serialVersionUID = 1L;//����ǥ ǥ�� ���ֱ� ���� �ۼ� �Ű澵 �ʿ� ����
	public Component getTableCellRendererComponent(JTable table,Object value,boolean isSelected,boolean hasFocus,int row, int column){
		Component cell = super.getTableCellRendererComponent(table,value,isSelected,hasFocus,row,column);
		row_=row;
		col=column;
		if(!isSelected){			
			////////////////////////////////			
		}
		return cell;	
	}
    public void setUI(LabelUI ui)
    {
        super.setUI(new BasicLabelUI()
        {
            public void paint(Graphics g, JComponent c)
            {
            	Rectangle r = g.getClipBounds();    
                super.paint(g, c);
                g.setColor(Color.green);
               for(int j=1;j<7;j++){
                 	for(int i=1;i<145;i++){
                 		if((array[i][j]==1)&&(check==0)){//�ð�ǥ �����ϴ� �κ� ����
                 			check=1;
                 			first1=i/12;// i�� ���� ��
                 			first2=(i-1)%12;  //i�� ���� ������                			
                 		}
                 		
                 		else if((array[i][j]==0)&&(check==1)){//�ð�ǥ ������ �κ� ����
                 			check=0;
                 			end1=(i-1)/12;//i�� ���� ��
                 			end2=(i-1)%12;//i�� ���� ������                 			
                 			for(int k=first1;k<=end1;k++){
                 				if(k==first1){
                 					if((row_==k)&&(col==j)){                 						
                           				g.fillRect(r.x, r.y+(r.height/12*first2), r.width, r.height);//�����Ҷ��� ����ϴ� �κ��� ���̸� ����
                           				System.out.println("First2 : "+first2+"\n");
                 					}                 					
                 				}
                 				else if(k==end1){
                 					if((row_==k)&&(col==j)){                 						
                           				g.fillRect(r.x, r.y, r.width, r.height/12*end2);//�������� ������ �κ��� ���̸� ����
                           				System.out.println("End2 : "+end2+"\n");
                 					}      
                 				}
                 				else{
                 					if((row_==k)&&(col==j)){   //�ð��� �� ��� �߰� ���� ä��� �κ�              						
                           				g.fillRect(r.x, r.y, r.width, r.height);
                 					}      
                 				}
                 			}
                 		}                 	
                 	}
                }              
            }
        });
    }
	void getinfo(int a[][]){//�迭 �����ºκ�
		this.array= a;
	}
}
