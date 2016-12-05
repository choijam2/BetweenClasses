
import java.awt.Color;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import javax.swing.JButton;

public class ResultFrame extends JFrame {

	private static int[][] BetweenClasses = { { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 } };
	private static int[][] master = { { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 } };

	private JPanel contentPane;
	private Connection con;
	private JTable table;
	private String[] s = new String[5];
	private int studentNumber;
	private JButton btn_save;

	public ResultFrame(Connection con,StudentMaster st,ArrayList<String> ck) throws SQLException {
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/logo.PNG"));
		setTitle("공강 찾기 결과");
		for (int i = 0; i < 25; i++) {
			for (int j = 0; j < 6; j++) {
				BetweenClasses[i][j] = 0;
				master[i][j] = 0;
			}
		}
		for(int i = 0;i<5;i++){
			s[i] = "-1";
		}
		int k = 0;
		for(int i=0;i<ck.size();i++){
			if(ck.get(i)!="-1"){
				s[k]=ck.get(i);
				k++;
			}
		}
		this.con = con;
		FindBC(st);
		
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

		for (int i = 0; i < 25; i++) {
			for (int j = 0; j < 6; j++) {
				if (BetweenClasses[i][j] == 0) {
					defTableTime[i][j + 1] = " ";
				} else {
					defTableTime[i][j + 1] = null;
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
		table.setEnabled(false);
		table.getTableHeader().setReorderingAllowed(false); // 이동 불가 
		table.getTableHeader().setResizingAllowed(false); // 크기 조절 불가
		table.setFont(new Font("ZESSTYPE 비가온다 PT02", Font.PLAIN, 18));
		table.getTableHeader().setFont(new Font("ZESSTYPE 비가온다 PT02", Font.PLAIN, 24));
		table.setRowHeight(30);

		table.setModel(new DefaultTableModel(defTableTime, defDays));

		table.setDefaultRenderer(Object.class, new ResultFrame_Renderer());
		table.setIntercellSpacing(new Dimension(1, 0));
		scrollPane.setViewportView(table);
		contentPane.add(scrollPane);

		JPanel pnl_title = new JPanel() {
			ImageIcon mainicon = new ImageIcon("img/result.png");

			public void paintComponent(Graphics g) {
				g.drawImage(mainicon.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		pnl_title.setBounds(29, 15, 580, 74);
		contentPane.add(pnl_title);

		btn_save = new JButton(new ImageIcon("img/result_save.png"));
		btn_save.setBorderPainted(false); // 투명 버튼
		btn_save.setFocusPainted(false); // 투명 버튼
		btn_save.setContentAreaFilled(false); // 투명 버튼
		btn_save.setBounds(685, 777, 139, 49);
		contentPane.add(btn_save);
		try {
			btn_save.addActionListener(new BtnSaveFunc(table));
		} catch (Exception e1) {			
			e1.printStackTrace();
		}

		JButton btn_Random = new JButton(new ImageIcon("img/ramdom_img.png"));
		btn_Random.setFocusPainted(false);
		btn_Random.setContentAreaFilled(false);
		btn_Random.setBorderPainted(false);
		btn_Random.setBounds(685, 699, 174, 49);
		contentPane.add(btn_Random);
		RandomRecommend random = new RandomRecommend(BetweenClasses,master);
		btn_Random.addActionListener(random);

	}

	void token(Vector<String> time) {

		StringTokenizer tk;
		String temp;
		char day = '\0';
		int sHour, sMin, sTime, fHour, fMin, fTime, startIndex = 0, lastIndex = 0, col = 0;
		int capa = time.capacity();		

		for (int i = 0; i < time.size(); i++) {			
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
				sTime = sHour * 100 + sMin;

				fHour = Integer.parseInt(temp.substring(7, 9));
				fMin = Integer.parseInt(temp.substring(10));
				fTime = fHour * 100 + fMin;

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
					if(j==25)
						break;
					BetweenClasses[j][col - 1]++;
				}			
			}
		}

	}
	void token(Vector<String> time,Boolean s) {
		if(s==false)
			return;		
		StringTokenizer tk;
		String temp;
		char day = '\0';
		int sHour, sMin, sTime, fHour, fMin, fTime, startIndex = 0, lastIndex = 0, col = 0;
		int capa = time.capacity();		

		for (int i = 0; i < time.size(); i++) {			
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
				sTime = sHour * 100 + sMin; 

				fHour = Integer.parseInt(temp.substring(7, 9));
				fMin = Integer.parseInt(temp.substring(10));
				fTime = fHour * 100 + fMin;

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
					if(j==25)
						break;
					master[j][col - 1]++;
				}			
			}
		}

	}
	void FindBC(StudentMaster st) throws SQLException {

		// 학생의 아이디를 저장한다.
		String[] People = new String[6];
		String[] time = new String[5];
		Vector<String> mytime = new Vector<String>();
		Vector<String> mstime = new Vector<String>();
		People[0] = s[0];
		People[1] = s[1];
		People[2] = s[2];
		People[3] = s[3];
		People[4] = s[4];
		People[5]="-1";

		// 공강 찾기 버튼에서 몇명의 학생 시간표를 비교하기 원하는지 찾는다.
		for (int i = 0; People[i] != "-1";studentNumber++, i++)
			;

		if (studentNumber == 0)
			JOptionPane.showMessageDialog(null, "학생 또는 교수 이름을 입력해주세요.");

		for (int i = 0; i < studentNumber; i++) {
			if ((int) People[i].charAt(0) >= 48 && (int) People[i].charAt(0) <= 57) {
				ResultSet rs;
				PreparedStatement query;
				query = con.prepareStatement("select l.ltime from lecture l, course c where l.lid=c.lid AND sid = ?");

				query.setString(1, People[i]);
				rs = query.executeQuery();
				while (rs.next()) {					
					mytime.add(rs.getString("l.ltime"));
					if(People[i]==st.getSid()){
						mstime.add(rs.getString("l.ltime"));
					}
				}				
				continue;
			}

			else {
				ResultSet rs;
				PreparedStatement query;
				query = con.prepareStatement("select ltime from lecture where pname = ?");				
				query.setString(1, People[i]);
				rs = query.executeQuery();
				while (rs.next()) {				
					mytime.add(rs.getString("ltime"));					
				}
				continue;
			}
		}
		
		token(mytime);
		token(mstime,st.isMaster());
	}	
}
