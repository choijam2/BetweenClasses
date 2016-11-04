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
					for(int i=1;i<145;i++){//배열 입력 부분
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
					
					ResultFrame frame = new ResultFrame();//프레임 생성					
					frame.setVisible(true);				
					
					TableCellRenderer renderer = new TableCellRenderer();
					renderer.getinfo(a);//배열을 render의 배열안에 입력					
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
		
		Object columnNames[] = {"","월","화","수","목","금","토"};
		DefaultTableModel defaultTableModel1 = new DefaultTableModel(Rowdata,columnNames){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;//느낌표 표시 없애기 위해 작성 신경쓸 필요 없음

			public boolean isCellEditable(int row, int column){//cell 수정 불가 설정
				return false;
			}	
		};
		
		contentPane.setLayout(null);			
		table_1 = new JTable(defaultTableModel1);
		table_1.setBounds(37, 35, 402, 628);
		table_1.setRowHeight(50);
		table_1.setIntercellSpacing(new Dimension(1,0));//???? 선여백처리??
		contentPane.add(table_1);
		
		JScrollPane scrollPane = new JScrollPane(table_1);
		scrollPane.setBounds(37, 39, 504, 675);
		contentPane.add(scrollPane);
		JButton button = new JButton("\uC800\uC7A5");
		button.setBounds(595, 186, 97, 23);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
				    Dimension d = new Dimension(504, 675);//오른쪽 아래 좌표 얻기위해 디멘션 사용
				    Rectangle area = new Rectangle(scrollPane.getLocationOnScreen(), d.getSize());//getlocationonscreen은 실시간 어플리케이션 scrollPane 위치의 왼쪽 위 지점을 포인트로 얻어옴||
				    
				    Robot robot = new Robot();
				    BufferedImage bufferedImage = robot.createScreenCapture(area);
				    // 전체 스크린 샷 가져오기
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
class TableCellRenderer extends DefaultTableCellRenderer{//배열 색 채우기
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
	private static final long serialVersionUID = 1L;//느낌표 표시 없애기 위해 작성 신경쓸 필요 없음
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
                 		if((array[i][j]==1)&&(check==0)){//시간표 시작하는 부분 저장
                 			check=1;
                 			first1=i/12;// i에 대한 몫
                 			first2=(i-1)%12;  //i에 대한 나머지                			
                 		}
                 		
                 		else if((array[i][j]==0)&&(check==1)){//시간표 끝나는 부분 저장
                 			check=0;
                 			end1=(i-1)/12;//i에 대한 몫
                 			end2=(i-1)%12;//i에 대한 나머지                 			
                 			for(int k=first1;k<=end1;k++){
                 				if(k==first1){
                 					if((row_==k)&&(col==j)){                 						
                           				g.fillRect(r.x, r.y+(r.height/12*first2), r.width, r.height);//시작할때는 출발하는 부분의 높이를 조절
                           				System.out.println("First2 : "+first2+"\n");
                 					}                 					
                 				}
                 				else if(k==end1){
                 					if((row_==k)&&(col==j)){                 						
                           				g.fillRect(r.x, r.y, r.width, r.height/12*end2);//끝날때는 끝나는 부분의 높이를 조절
                           				System.out.println("End2 : "+end2+"\n");
                 					}      
                 				}
                 				else{
                 					if((row_==k)&&(col==j)){   //시간이 길 경우 중간 공백 채우는 부분              						
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
	void getinfo(int a[][]){//배열 얻어오는부분
		this.array= a;
	}
}
