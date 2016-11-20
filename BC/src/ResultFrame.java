//import java.awt.AWTException;
//import java.awt.Color;
//import java.awt.Component;
//import java.awt.Dimension;
//import java.awt.EventQueue;
//import java.awt.Graphics;
//import java.awt.Rectangle;
//import java.awt.Robot;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.border.EmptyBorder;
//import javax.swing.plaf.LabelUI;
//import javax.swing.plaf.basic.BasicLabelUI;
//import javax.swing.table.DefaultTableCellRenderer;
//import javax.swing.table.DefaultTableModel;
//
//import javax.swing.JTable;
//import javax.swing.SwingConstants;
//import javax.imageio.ImageIO;
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
//import javax.swing.JComponent;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;
//import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;
//import java.awt.Font;
//import javax.swing.JTabbedPane;
//import javax.swing.JTextArea;
//
//public class ResultFrame extends JFrame {
//
//	private static final long serialVersionUID = 1L;
//	private JPanel contentPane;
//	
//	private static JTable BCTimeTable;
//
//	public ResultFrame(JTable BCtable) throws ClassNotFoundException {
//		setResizable(false);
//		setVisible(true);
//		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		setBounds(100, 100, 1283, 976);
//		setTitle("\uBAA8\uB450\uC758 \uACF5\uAC15");
//		setBounds(100, 100, 1099, 934);
//		contentPane = new JPanel();
//		contentPane.setBackground(Color.WHITE);
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
//		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
//		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
//		
//		
//		contentPane.setLayout(null);
//		BCTimeTable = BCtable;
//		BCTimeTable.setEnabled(false);
//		BCTimeTable.setRowSelectionAllowed(false);
//		BCTimeTable.setFont(new Font("ZESSTYPE 비가온다 PT02", Font.PLAIN, 24));
//		BCTimeTable.getTableHeader().setFont(new Font("ZESSTYPE 비가온다 PT02", Font.PLAIN, 24));
//		BCTimeTable.setBounds(37, 35, 402, 600);
//		BCTimeTable.setRowHeight(53);
//		BCTimeTable.setIntercellSpacing(new Dimension(1, 0));// ???? 선여백처리??
//		BCTimeTable.setDefaultRenderer(Object.class, new MyRenderer());
//		BCTimeTable.setDefaultRenderer(Object.class, new MyRenderer());
//		BCTimeTable.getColumn("Time").setCellRenderer(celAlignCenter);
//		BCTimeTable.getColumn("Time").setPreferredWidth(20);
//
//		
//		JScrollPane scrollPane = new JScrollPane(BCTimeTable);
//		scrollPane.setBounds(52, 124, 680, 723);
//		contentPane.add(scrollPane);
//		JButton btn_Save = new JButton(new ImageIcon("result_save.png"));
//		btn_Save.setBorderPainted(false); // 투명 버튼
//		btn_Save.setFocusPainted(false); // 투명 버튼
//		btn_Save.setContentAreaFilled(false); // 투명 버튼
//		btn_Save.setBounds(789, 713, 124, 52);
//		contentPane.add(btn_Save);
////		JPanel panel = new JPanel() {
////			ImageIcon mainicon = new ImageIcon("result.png");
////
////			public void paintComponent(Graphics g) {
////				g.drawImage(mainicon.getImage(), 0, 0, null);
////				setOpaque(false);
////				super.paintComponent(g);
////			}
////		};
////		panel.setBounds(52, 28, 368, 94);
////		contentPane.add(panel);
//		
//		JButton btn_Random = new JButton(new ImageIcon("img/ramdom_img.png"));
//		btn_Random.setBounds(789, 781, 176, 46);
//		btn_Random.setBorderPainted(false);
//		btn_Random.setFocusPainted(false);
//		btn_Random.setContentAreaFilled(false);
//		contentPane.add(btn_Random);
//		
//		JPanel panel_1 = new JPanel();
//		panel_1.setBounds(749, 124, 311, 559);
//		contentPane.add(panel_1);
//		
//		JTextArea textArea = new JTextArea();
//		panel_1.add(textArea);
//
//	}
//}
//
//class MyRenderer extends DefaultTableCellRenderer {
//	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
//			int row, int column) {
//		Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row,
//				column);
//
//		if ((int)table.getValueAt(row, column) == 0) {
//			cellComponent.setBackground(Color.YELLOW);
//		} else
//			cellComponent.setBackground(Color.WHITE);
//		return cellComponent;
//	}
//}

//import java.awt.AWTException;
//import java.awt.Color;
//import java.awt.Component;
//import java.awt.Dimension;
//import java.awt.EventQueue;
//import java.awt.Graphics;
//import java.awt.Rectangle;
//import java.awt.Robot;
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.border.EmptyBorder;
//import javax.swing.plaf.LabelUI;
//import javax.swing.plaf.basic.BasicLabelUI;
//import javax.swing.table.DefaultTableCellRenderer;
//import javax.swing.table.DefaultTableModel;
//import javax.swing.JTable;
//import javax.swing.SwingConstants;
//import javax.imageio.ImageIO;
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
//import javax.swing.JComponent;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;
//import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;
//import java.awt.Font;
//import javax.swing.JTabbedPane;
//import javax.swing.JTextArea;
//
//public class ResultFrame extends JFrame {
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//	private JPanel contentPane;
//	int[][] ex;
//	private static JTable BCTimeTable;
//
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					int[][] a = new int[145][7];
//					for (int i = 1; i < 145; i++) {// 배열 입력 부분
//						if ((i >= 1) && (i <= 15))
//							a[i][1] = 1;
//						else if ((i >= 17) && (i <= 53))
//							a[i][1] = 1;
//						else if ((i >= 55) && (i <= 69))
//							a[i][1] = 1;
//						else if ((i >= 85) && (i <= 105))
//							a[i][1] = 1;
//						if ((i >= 10) && (i <= 100))
//							a[i][3] = 1;
//					}
//
//					ResultFrame frame = new ResultFrame();// 프레임 생성
//					frame.setVisible(true);
//
//					TableCellRenderer renderer = new TableCellRenderer();
//					renderer.getinfo(a);// 배열을 render의 배열안에 입력
//					BCTimeTable.setDefaultRenderer(Class.forName("java.lang.Object"), renderer);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the frame.
//	 * 
//	 * @throws ClassNotFoundException
//	 */
//	public ResultFrame() throws ClassNotFoundException {
//		setTitle("\uBAA8\uB450\uC758 \uACF5\uAC15");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 1099, 934);
//		contentPane = new JPanel();
//		contentPane.setBackground(Color.WHITE);
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
//
//		Object Rowdata[][] = { { "09:00" }, { "10:00" }, { "11:00" }, { "12:00" }, { "13:00" }, { "14:00" },
//				{ "15:00" }, { "16:00" }, { "17:00" }, { "18:00" }, { "19:00" }, { "20:00" }, { "21:00" } };
//
//		Object columnNames[] = { "", "월", "화", "수", "목", "금", "토" };
//		DefaultTableModel defaultTableModel1 = new DefaultTableModel(Rowdata, columnNames) {
//			private static final long serialVersionUID = 1L;// 느낌표 표시 없애기 위해 작성
//															// 신경쓸 필요 없음
//
//			public boolean isCellEditable(int row, int column) {// cell 수정 불가 설정
//				return false;
//			}
//		};
//
//		contentPane.setLayout(null);
//		BCTimeTable = new JTable(defaultTableModel1);
//		BCTimeTable.setEnabled(false);
//		BCTimeTable.setRowSelectionAllowed(false);
//		BCTimeTable.setFont(new Font("ZESSTYPE 비가온다 PT02", Font.PLAIN, 24));
//		BCTimeTable.getTableHeader().setFont(new Font("ZESSTYPE 비가온다 PT02", Font.PLAIN, 24));
//		BCTimeTable.setBounds(37, 35, 402, 600);
//		BCTimeTable.setRowHeight(53);
//		BCTimeTable.setIntercellSpacing(new Dimension(1, 0));// ???? 선여백처리??
//		
//		JScrollPane scrollPane = new JScrollPane(BCTimeTable);
//		scrollPane.setBounds(52, 124, 680, 723);
//		contentPane.add(scrollPane);
//		JButton btn_Save = new JButton(new ImageIcon("result_save.png"));
//		btn_Save.setBorderPainted(false); // 투명 버튼
//		btn_Save.setFocusPainted(false); // 투명 버튼
//		btn_Save.setContentAreaFilled(false); // 투명 버튼
//		btn_Save.setBounds(789, 713, 124, 52);
//		contentPane.add(btn_Save);
////		JPanel panel = new JPanel() {
////			ImageIcon mainicon = new ImageIcon("result.png");
////
////			public void paintComponent(Graphics g) {
////				g.drawImage(mainicon.getImage(), 0, 0, null);
////				setOpaque(false);
////				super.paintComponent(g);
////			}
////		};
////		panel.setBounds(52, 28, 368, 94);
////		contentPane.add(panel);
//		
//		JButton btn_Random = new JButton(new ImageIcon("img/ramdom_img.png"));
//		btn_Random.setBounds(789, 781, 176, 46);
//		btn_Random.setBorderPainted(false);
//		btn_Random.setFocusPainted(false);
//		btn_Random.setContentAreaFilled(false);
//		contentPane.add(btn_Random);
//		
//		JPanel panel_1 = new JPanel();
//		panel_1.setBounds(749, 124, 311, 559);
//		contentPane.add(panel_1);
//		
//		JTextArea textArea = new JTextArea();
//		panel_1.add(textArea);
//
//	}
//}
//
//class TableCellRenderer extends DefaultTableCellRenderer {// 배열 색 채우기
//	/**
//	 * 
//	 */
//	TableCellRenderer() {
//		this.setHorizontalAlignment(SwingConstants.CENTER);
//	};
//
//	int[][] array;
//	int row_ = 0;
//	int col = 0;
//	
//	int check = 0, first1 = 0, first2 = 0, end1 = 0, end2 = 0;
//	private static final long serialVersionUID = 1L;// 느낌표 표시 없애기 위해 작성 신경쓸 필요
//													// 없음
//
//	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
//			int row, int column) {
//		Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
//		row_ = row;
//		col = column;
//		if (!isSelected) {
//			////////////////////////////////
//		}
//		return cell;
//	}
//
//	public void setUI(LabelUI ui) {
//		super.setUI(new BasicLabelUI() {
//			public void paint(Graphics g, JComponent c) {
//				Rectangle r = g.getClipBounds();
//				super.paint(g, c);
//				g.setColor(Color.green);
//				for (int j = 1; j < 7; j++) {
//					for (int i = 1; i < 145; i++) {
//						if ((array[i][j] == 1) && (check == 0)) {// 시간표 시작하는 부분
//																	// 저장
//							check = 1;
//							first1 = i / 12;// i에 대한 몫
//							first2 = (i - 1) % 12; // i에 대한 나머지
//						}
//
//						else if ((array[i][j] == 0) && (check == 1)) {// 시간표 끝나는
//																		// 부분 저장
//							check = 0;
//							end1 = (i - 1) / 12;// i에 대한 몫
//							end2 = (i - 1) % 12;// i에 대한 나머지
//							for (int k = first1; k <= end1; k++) {
//								if (k == first1) {
//									if ((row_ == k) && (col == j)) {
//										g.fillRect(r.x, r.y + (r.height / 12 * first2), r.width, r.height);// 시작할때는
//																											// 출발하는
//																											// 부분의
//																											// 높이를
//																											// 조절
//										System.out.println("First2 : " + first2 + "\n");
//									}
//								} else if (k == end1) {
//									if ((row_ == k) && (col == j)) {
//										g.fillRect(r.x, r.y, r.width, r.height / 12 * end2);// 끝날때는
//																							// 끝나는
//																							// 부분의
//																							// 높이를
//																							// 조절
//										System.out.println("End2 : " + end2 + "\n");
//									}
//								} else {
//									if ((row_ == k) && (col == j)) { // 시간이 길 경우
//																		// 중간 공백
//																		// 채우는
//																		// 부분
//										g.fillRect(r.x, r.y, r.width, r.height);
//									}
//								}
//							}
//						}
//					}
//				}
//			}
//		});
//	}
//
//	void getinfo(int a[][]) {// 배열 얻어오는부분
//		this.array = a;
//	}
//}


import java.awt.Color;
import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
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
import javax.swing.table.TableColumnModel;

import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JButton;

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

	public ResultFrame(Connection con, String s1, String s2, String s3, String s4, String s5) throws SQLException {

		this.s1 = s1;
		this.s2 = s2;
		this.s3 = s3;
		this.s4 = s4;
		this.s5 = s5;

		this.con = con;
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
		
		table.setModel(new DefaultTableModel(
				new Object[][] { { "9:00 ~ 9:30", null, null, null, null, null, null },
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
						{ "21:00 ~", null, null, null, null, null, null } },
				new String[] { "Time", "월", "화", "수", "목", "금", "토" }));

		scrollPane.setViewportView(table);
		contentPane.add(scrollPane);
		
		//셀 내용 가운데 정렬하기
		DefaultTableCellRenderer dtcr=new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcm=table.getColumnModel();
		for(int i=0;i<tcm.getColumnCount();i++){
			tcm.getColumn(i).setCellRenderer(dtcr);
		}
		
		JPanel pnl_title = new JPanel(){
				ImageIcon mainicon = new ImageIcon("result.png");
							public void paintComponent(Graphics g) {
								g.drawImage(mainicon.getImage(), 0, 0, null);
								setOpaque(false);
								super.paintComponent(g);
							}
						};		
		pnl_title.setBounds(29, 15, 580, 74);
		contentPane.add(pnl_title);
		
		JButton btn_save = new JButton(new ImageIcon("result_save.png"));
		btn_save.setBorderPainted(false); // 투명 버튼
		btn_save.setFocusPainted(false); // 투명 버튼
		btn_save.setContentAreaFilled(false); // 투명 버튼
		btn_save.setBounds(685, 777, 139, 49);
		contentPane.add(btn_save);


		FindBC();
	}

	

	void token(String ltime) {
		StringTokenizer tk = new StringTokenizer(ltime);
		String temp;
		char day = '\0';
		int between, sHour, sMin, sTime, fHour, fMin, fTime, startIndex = 0, lastIndex = 0, col = 0;

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

			//해당되는 시간의 index를 찾는다.
			startIndex = (sHour - 9) * 2;
			if (sMin > 0) {
				startIndex++;
			}

			lastIndex = (fHour - 9) * 2;
			if (fMin > 30) {
				lastIndex++;
			}
			
			for (int i = startIndex; i <= lastIndex; i++) {
				BetweenClasses[i][col-1]++;
			}
			
			System.out.println((col-1)+" "+sTime+" "+fTime+" "+startIndex+" "+
			lastIndex);
		}


	}

	void FindBC() throws SQLException {

		// 학생의 아이디를 저장한다.
		String[] student = new String[5];
		student[0] = s1;
		student[1] = s2;
		student[2] = "-1";
		student[3] = "-1";
		student[4] = "-1";

		// 공강 찾기 버튼에서 몇명의 학생 시간표를 비교하기 원하는지 찾는다.
		for (int i = 0; student[i] != "-1"; studentNumber++, i++);
		
		if (studentNumber == 0)
			JOptionPane.showMessageDialog(null, "학생 또는 교수 이름을 입력해주세요.");

		ResultSet rs;
		PreparedStatement query;

		for (int i = 0; i < studentNumber; i++) {
			query = con.prepareStatement("select l.ltime from lecture l, course c where l.lid=c.lid AND sid = ?");

			query.setString(1, student[i]);
			rs = query.executeQuery();

			while (rs.next()) {
				System.out.println(student[i] + " " + rs.getString("l.ltime"));
				token(rs.getString("l.ltime"));
			}
		}
		
		CustomTableCellRenderer renderer =new CustomTableCellRenderer();
		
		for (int i = 0; i < 25; i++) {
			for (int j = 0; j < 6; j++) {
				System.out.print(BetweenClasses[i][j]);
				if (BetweenClasses[i][j] == studentNumber){
					renderer.setRowColor(i, Color.PINK);
					table.getColumnModel().getColumn(j+1).setCellRenderer(renderer);
				}
			}
			System.out.println();
		}
		
//		BetweenClasses={ { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 },
//				{ 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 },
//				{ 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 },
//				{ 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 },
//				{ 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 },
//				{ 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 },
//				{ 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 } };
	}
}

class CustomTableCellRenderer extends DefaultTableCellRenderer {

	private Map<Integer, Color> mapColors;

	public CustomTableCellRenderer() {
		mapColors = new HashMap<Integer, Color>();
	}

	public void setRowColor(int row, Color color) {
		mapColors.put(row, color);
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object obj, boolean isSelected, boolean hasFocus,
			int row, int column) {

		Component cell = super.getTableCellRendererComponent(table, obj, isSelected, hasFocus, row, 1);
		Color color = mapColors.get(row);
		if (color != null) {
			cell.setBackground(color);
		} else {
			cell.setBackground(isSelected ? table.getSelectionBackground() : table.getBackground());
		}
		return cell;
	}
}




