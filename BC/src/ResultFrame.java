
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.Icon;

public class ResultFrame extends JFrame {

	private static int[][] BetweenClasses = { { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 } };

	private JPanel contentPane;
	private Connection con;
	private JTable table;
	private String s1, s2, s3, s4, s5;
	private int studentNumber;
	private JButton btn_save;

	public ResultFrame(Connection con, String s1, String s2, String s3, String s4, String s5) throws SQLException {
		for (int i = 0; i < 25; i++) {
			for (int j = 0; j < 6; j++) {
				BetweenClasses[i][j] = 0;
			}
		}
		this.s1 = s1;
		this.s2 = s2;
		this.s3 = s3;
		this.s4 = s4;
		this.s5 = s5;
		this.con = con;
		
		FindBC();
		
		Object[][] defTableTime = new Object[][] { { "9:00 ~ 9:30", null, null, null, null, null, null },
			{ "9:30 ~ 10:00", null, null, null, null, null, null },
			{ "10:00 ~ 10:30", null, null, null, null, null, null },
			{ "10:30 ~ 11:00", null, null, null, null, null, null },
			{ "11:00 ~ 11:30", null, null, null, null, null, null },
			{ "11:30 ~ 12:00", null, null, null, null, null, null },
			{ "12:00 ~ 12:30", null, null, null, null, null, null },
			{ "12:30 ~ 13:00", null, null, null, null, null, null },
			{ "13:00 ~ 13:30", null, null, null, null, null, null },
			{ "13:30 ~ 14:00", null, null, null, null, null, null },
			{ "14:00 ~ 14:30", null, null, null, null, null, null },
			{ "14:30 ~ 15:00", null, null, null, null, null, null },
			{ "15:00 ~ 15:30", null, null, null, null, null, null },
			{ "15:30 ~ 16:00", null, null, null, null, null, null },
			{ "16:00 ~ 16:30", null, null, null, null, null, null },
			{ "16:30 ~ 17:00", null, null, null, null, null, null },
			{ "17:00 ~ 17:30", null, null, null, null, null, null },
			{ "17:30 ~ 18:00", null, null, null, null, null, null },
			{ "18:00 ~ 18:30", null, null, null, null, null, null },
			{ "18:30 ~ 19:00", null, null, null, null, null, null },
			{ "19:00 ~ 19:30", null, null, null, null, null, null },
			{ "19:30 ~ 20:00", null, null, null, null, null, null },
			{ "20:00 ~ 20:30", null, null, null, null, null, null },
			{ "20:30 ~ 21:00", null, null, null, null, null, null },
			{ "21:00 ~", null, null, null, null, null, null } };
			
			//defTableTime[2][3] ="OK";
	
			for (int i = 0; i < 25; i++) {
				for (int j = 0; j < 6; j++) {
					if (BetweenClasses[i][j] ==0){
						defTableTime[i][j+1] =" ";
					}
					else{
						defTableTime[i][j+1]=null;
					}
				}
			}
			
	   String[] defDays = new String[] { "Time", "월", "화", "수", "목", "금", "토" };

		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 911, 973);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 104, 569, 788);

		table = new JTable();
		table.setFont(new Font("ZESSTYPE 비가온다 PT02", Font.PLAIN, 18));
		table.getTableHeader().setFont(new Font("ZESSTYPE 비가온다 PT02", Font.PLAIN, 24));
		table.setRowHeight(30);



		table.setModel(new DefaultTableModel(defTableTime, defDays));
		
		table.setDefaultRenderer(Object.class, new MyRenderer());
		table.setIntercellSpacing(new Dimension(1, 0));
		scrollPane.setViewportView(table);
		contentPane.add(scrollPane);

//		// 셀 내용 가운데 정렬하기
//		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
//		dtcr.setHorizontalAlignment(SwingConstants.CENTER);
//		TableColumnModel tcm = table.getColumnModel();
//		for (int i = 0; i < tcm.getColumnCount(); i++) {
//			tcm.getColumn(i).setCellRenderer(dtcr);
//		}

		JPanel pnl_title = new JPanel() {
			ImageIcon mainicon = new ImageIcon("result.png");

			public void paintComponent(Graphics g) {
				g.drawImage(mainicon.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		pnl_title.setBounds(29, 15, 580, 74);
		contentPane.add(pnl_title);

		btn_save = new JButton(new ImageIcon("result_save.png"));
		btn_save.setBorderPainted(false); // 투명 버튼
		btn_save.setFocusPainted(false); // 투명 버튼
		btn_save.setContentAreaFilled(false); // 투명 버튼
		btn_save.setBounds(685, 777, 139, 49);
		contentPane.add(btn_save);
		
		JButton btn_Random = new JButton(new ImageIcon("ramdom_img.png"));
		btn_Random.setFocusPainted(false);
		btn_Random.setContentAreaFilled(false);
		btn_Random.setBorderPainted(false);
		btn_Random.setBounds(685, 699, 174, 49);
		contentPane.add(btn_Random);
		RandomRecommend random = new RandomRecommend(BetweenClasses);
		btn_Random.addActionListener(random);

	}

void token(Vector<String> time) {
		
		StringTokenizer tk;
		String temp;
		char day = '\0';
		int sHour, sMin, sTime, fHour, fMin, fTime, startIndex = 0, lastIndex = 0, col = 0;
		int capa=time.capacity();
		System.out.println("capacity "+capa);
		
		for(int i=0;i<time.size();i++){
			//String time2=
			tk = new StringTokenizer(time.get(i));
		
			while (tk.hasMoreTokens()) {
				temp = tk.nextToken();
				day = temp.charAt(0);
	
				switch (day) {
				case '월':
					col = 1;
					break;
				case '화':
					col = 2;
					break;
				case '수':
					col = 3;
					break;
				case '목':
					col = 4;
					break;
				case '금':
					col = 5;
					break;
				case '토':
					col = 6;
					break;
				default:
					break;
				}
	
				sHour = Integer.parseInt(temp.substring(1, 3));
				sMin = Integer.parseInt(temp.substring(4, 6));
				sTime = sHour * 100 + sMin; // 1630이 저장됨
	
				fHour = Integer.parseInt(temp.substring(7, 9));
				fMin = Integer.parseInt(temp.substring(10));
				fTime = fHour * 100 + fMin; // 1745가 저장됨.
	
				// 해당되는 시간의 index를 찾는다.
				startIndex = (sHour - 9) * 2;
				if (sMin > 0) {
					startIndex++;
				}
	
				lastIndex = (fHour - 9) * 2;
				if (fMin > 30) {
					lastIndex++;
				}
	
				for (int j = startIndex; j <= lastIndex; j++) {
					BetweenClasses[j][col - 1]++;
				}
	
				System.out.println((col - 1) + " " + sTime + " " + fTime + " " + startIndex + " " + lastIndex);
			}
		}

	}

void FindBC() throws SQLException {

	// 학생의 아이디를 저장한다.
	String[] People = new String[5];
	String[] time= new String[5];
	Vector<String> mytime = new Vector<String>();
	People[0] = s1;
	People[1] = s2;
	People[2] = s3;
	People[3] = s4;
	People[4] = s5;
	

	// 공강 찾기 버튼에서 몇명의 학생 시간표를 비교하기 원하는지 찾는다.
	for (int i = 0; People[i] != "-1"; studentNumber++, i++)
		;

	if (studentNumber == 0)
		JOptionPane.showMessageDialog(null, "학생 또는 교수 이름을 입력해주세요.");



	for (int i = 0; i < studentNumber; i++) {
		if( (int)People[i].charAt(0)>=48&& (int)People[i].charAt(0)<=57){
			ResultSet rs;
			PreparedStatement query;
			query = con.prepareStatement("select l.ltime from lecture l, course c where l.lid=c.lid AND sid = ?");
			
			query.setString(1, People[i]);
			rs = query.executeQuery();
				while(rs.next()){
					//time[i]=rs.getString("l.ltime");
					mytime.add(rs.getString("l.ltime"));
				}
				System.out.println("ResultFrame내 학생 이름 : "+People[i]+"강의시간 : "+time[i]);
			continue;
		}
		
		else{
			ResultSet rs;
			PreparedStatement query;
			query = con.prepareStatement("select ltime from lecture where pname = ?");
			System.out.println("ResultFrame내 교수님 성함 : "+People[i]);
			query.setString(1, People[i]);
			rs = query.executeQuery();
				while(rs.next()){
					//time[i]=rs.getString("ltime");
					mytime.add(rs.getString("ltime"));
				}
			continue;
		}
//		while (rs.next()) {
//			//System.out.println(student[i] + " " + rs.getString("l.ltime"));
//			token(rs.getString("l.ltime"));
//		}

	}
	
	//token(time);
	token(mytime);
}

	class MyRenderer extends DefaultTableCellRenderer {
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row,
					column);
			if (table.getValueAt(row, column) != null &&column!=0) {
				cellComponent.setBackground(Color.YELLOW);
				//cellComponent.setForeground(Color.YELLOW);
			} else
				cellComponent.setBackground(Color.WHITE);
			return cellComponent;
		}
	}
}


