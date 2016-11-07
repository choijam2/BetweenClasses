import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

public class AddClassFrame2 extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txt_ClassNum;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;
	private JTable table_4;
	private JTable table_5;
	private JTable table_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddClassFrame2 frame = new AddClassFrame2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddClassFrame2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1283, 976);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		JPanel ParentPanel = new JPanel();
		ParentPanel.setBounds(0, 115, 1261, 796);
		contentPane.add(ParentPanel);
		ParentPanel.setLayout(new CardLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.BLACK, 2));
		panel_1.setBackground(Color.WHITE);
		ParentPanel.add(panel_1, "name_798298334667093");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 28, 746, 727);
		
		JPanel Pnl_ClassNum = new JPanel(){
			//판넬에 이미지 추가
			ImageIcon mainicon = new ImageIcon("img/AddClass.png");

			public void paintComponent(Graphics g) {
				g.drawImage(mainicon.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		Pnl_ClassNum.setBounds(860, 123, 164, 80);
		
		txt_ClassNum = new JTextField();
		txt_ClassNum.setBounds(860, 206, 164, 40);
		txt_ClassNum.setColumns(10);
		
		JPanel pnl_add = new JPanel(){
			//판넬에 이미지 추가
			ImageIcon mainicon = new ImageIcon("img/add.png");

			public void paintComponent(Graphics g) {
				g.drawImage(mainicon.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		pnl_add.setBounds(884, 306, 102, 47);
		
		JPanel pnl_save = new JPanel(){
			//판넬에 이미지 추가
			ImageIcon mainicon = new ImageIcon("img/save.png");

			public void paintComponent(Graphics g) {
				g.drawImage(mainicon.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		pnl_save.setBounds(884, 427, 105, 47);
		
		JPanel pnl_del = new JPanel(){
			//판넬에 이미지 추가
			ImageIcon mainicon = new ImageIcon("img/del.png");

			public void paintComponent(Graphics g) {
				g.drawImage(mainicon.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		pnl_del.setBounds(884, 368, 105, 55);
		
				JButton btn_Del = new JButton();
				pnl_del.add(btn_Del);
				btn_Del.setBorderPainted(false);    //투명 버튼
				btn_Del.setFocusPainted(false);      //투명 버튼
				btn_Del.setContentAreaFilled(false);
		
		JButton btn_Save = new JButton();
		pnl_save.add(btn_Save);
		btn_Save.setBorderPainted(false);    //투명 버튼
		btn_Save.setFocusPainted(false);      //투명 버튼
		btn_Save.setContentAreaFilled(false);
		
		JButton btn_Add = new JButton();
		pnl_add.add(btn_Add);
		btn_Add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_Add.setBorderPainted(false);    //투명 버튼
		btn_Add.setFocusPainted(false);      //투명 버튼
		btn_Add.setContentAreaFilled(false);
		
		
		//셀 글자 정렬
		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
		
		table = new JTable();
		
		table.getTableHeader().setFont(new Font("ZESSTYPE 비가온다 PT02", Font.BOLD, 24));
		table.setFont(new Font("ZESSTYPE 비가온다 PT02", Font.PLAIN, 24));
		table.setBounds(37, 35, 402, 600);
		table.setRowHeight(53);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"9:00", null, null, null, null, null, null},
				{"10:00", null, null, null, null, null, null},
				{"11:00", null, null, null, null, null, null},
				{"12:00", null, null, null, null, null, null},
				{"13:00", null, null, null, null, null, null},
				{"14:00", null, null, null, null, null, null},
				{"15:00", null, null, null, null, null, null},
				{"16:00", null, null, null, null, null, null},
				{"17:00", null, null, null, null, null, null},
				{"18:00", null, null, null, null, null, null},
				{"19:00", null, null, null, null, null, null},
				{"20:00", null, null, null, null, null, null},
				{"21:00", null, null, null, null, null, null},
			},
			new String[] {
				"Time", "월", "화", "수", "목", "금", "토"
			}
		));
		
		//가운데 정렬
		table.getColumn("Time").setCellRenderer(celAlignCenter);
		panel_1.setLayout(null);
		
	
		scrollPane.setViewportView(table);
		panel_1.add(scrollPane);
		panel_1.add(txt_ClassNum);
		panel_1.add(Pnl_ClassNum);
		panel_1.add(pnl_add);
		panel_1.add(pnl_del);
		panel_1.add(pnl_save);
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_2.setBackground(Color.WHITE);
		ParentPanel.add(panel_2, "name_798285310498133");
		
		JScrollPane scrolltime1 = new JScrollPane();
		
		JScrollPane scrollPane_2 = new JScrollPane();
		
		JScrollPane scrollPane_3 = new JScrollPane();
		
		JScrollPane scrollPane_4 = new JScrollPane();
		
		JScrollPane scrollPane_5 = new JScrollPane();
		
		JScrollPane scrollPane_6 = new JScrollPane();
		
		JScrollPane scrollPane_7 = new JScrollPane();
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(27)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(scrolltime1, GroupLayout.PREFERRED_SIZE, 310, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 310, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(scrollPane_3, GroupLayout.PREFERRED_SIZE, 310, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scrollPane_4, GroupLayout.PREFERRED_SIZE, 310, GroupLayout.PREFERRED_SIZE)
							.addGap(17)
							.addComponent(scrollPane_6, GroupLayout.PREFERRED_SIZE, 310, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(scrollPane_7, GroupLayout.PREFERRED_SIZE, 310, GroupLayout.PREFERRED_SIZE)
							.addGap(2)
							.addComponent(scrollPane_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(264, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(59)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
							.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE)
							.addComponent(scrollPane_3, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrolltime1, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
							.addComponent(scrollPane_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(364))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(49)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane_4, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
									.addComponent(scrollPane_6, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE)
									.addComponent(scrollPane_7, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE)))
							.addContainerGap())))
		);
		
		table_6 = new JTable();
		table_6.getTableHeader().setFont(new Font("ZESSTYPE 비가온다 PT02", Font.BOLD, 18));
		table_6.setFont(new Font("ZESSTYPE 비가온다 PT02", Font.PLAIN, 18));
		table_6.setRowHeight(19);
		table_6.setModel(new DefaultTableModel(
				new Object[][] {
					{"9:00", null, null, null, null, null, null},
					{"10:00", null, null, null, null, null, null},
					{"11:00", null, null, null, null, null, null},
					{"12:00", null, null, null, null, null, null},
					{"13:00", null, null, null, null, null, null},
					{"14:00", null, null, null, null, null, null},
					{"15:00", null, null, null, null, null, null},
					{"16:00", null, null, null, null, null, null},
					{"17:00", null, null, null, null, null, null},
					{"18:00", null, null, null, null, null, null},
					{"19:00", null, null, null, null, null, null},
					{"20:00", null, null, null, null, null, null},
					{"21:00", null, null, null, null, null, null},
				},
				new String[] {
					"Time", "월", "화", "수", "목", "금", "토"
				}
		));
		scrollPane_7.setViewportView(table_6);
		
		table_5 = new JTable();
		table_5.setModel(new DefaultTableModel(
				new Object[][] {
					{"9:00", null, null, null, null, null, null},
					{"10:00", null, null, null, null, null, null},
					{"11:00", null, null, null, null, null, null},
					{"12:00", null, null, null, null, null, null},
					{"13:00", null, null, null, null, null, null},
					{"14:00", null, null, null, null, null, null},
					{"15:00", null, null, null, null, null, null},
					{"16:00", null, null, null, null, null, null},
					{"17:00", null, null, null, null, null, null},
					{"18:00", null, null, null, null, null, null},
					{"19:00", null, null, null, null, null, null},
					{"20:00", null, null, null, null, null, null},
					{"21:00", null, null, null, null, null, null},
				},
				new String[] {
					"Time", "월", "화", "수", "목", "금", "토"
				}
		));
		scrollPane_6.setViewportView(table_5);
		
		table_4 = new JTable();
		table_4.setModel(new DefaultTableModel(
				new Object[][] {
					{"9:00", null, null, null, null, null, null},
					{"10:00", null, null, null, null, null, null},
					{"11:00", null, null, null, null, null, null},
					{"12:00", null, null, null, null, null, null},
					{"13:00", null, null, null, null, null, null},
					{"14:00", null, null, null, null, null, null},
					{"15:00", null, null, null, null, null, null},
					{"16:00", null, null, null, null, null, null},
					{"17:00", null, null, null, null, null, null},
					{"18:00", null, null, null, null, null, null},
					{"19:00", null, null, null, null, null, null},
					{"20:00", null, null, null, null, null, null},
					{"21:00", null, null, null, null, null, null},
				},
				new String[] {
					"Time", "월", "화", "수", "목", "금", "토"
				}
		));
		scrollPane_4.setViewportView(table_4);
		
		table_3 = new JTable();
		table_3.setModel(new DefaultTableModel(
				new Object[][] {
					{"9:00", null, null, null, null, null, null},
					{"10:00", null, null, null, null, null, null},
					{"11:00", null, null, null, null, null, null},
					{"12:00", null, null, null, null, null, null},
					{"13:00", null, null, null, null, null, null},
					{"14:00", null, null, null, null, null, null},
					{"15:00", null, null, null, null, null, null},
					{"16:00", null, null, null, null, null, null},
					{"17:00", null, null, null, null, null, null},
					{"18:00", null, null, null, null, null, null},
					{"19:00", null, null, null, null, null, null},
					{"20:00", null, null, null, null, null, null},
					{"21:00", null, null, null, null, null, null},
				},
				new String[] {
					"Time", "월", "화", "수", "목", "금", "토"
				}
		));
		scrollPane_3.setViewportView(table_3);
		
		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(
				new Object[][] {
					{"9:00", null, null, null, null, null, null},
					{"10:00", null, null, null, null, null, null},
					{"11:00", null, null, null, null, null, null},
					{"12:00", null, null, null, null, null, null},
					{"13:00", null, null, null, null, null, null},
					{"14:00", null, null, null, null, null, null},
					{"15:00", null, null, null, null, null, null},
					{"16:00", null, null, null, null, null, null},
					{"17:00", null, null, null, null, null, null},
					{"18:00", null, null, null, null, null, null},
					{"19:00", null, null, null, null, null, null},
					{"20:00", null, null, null, null, null, null},
					{"21:00", null, null, null, null, null, null},
				},
				new String[] {
					"Time", "월", "화", "수", "목", "금", "토"
				}
		));
		scrollPane_2.setViewportView(table_2);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
				new Object[][] {
					{"9:00", null, null, null, null, null, null},
					{"10:00", null, null, null, null, null, null},
					{"11:00", null, null, null, null, null, null},
					{"12:00", null, null, null, null, null, null},
					{"13:00", null, null, null, null, null, null},
					{"14:00", null, null, null, null, null, null},
					{"15:00", null, null, null, null, null, null},
					{"16:00", null, null, null, null, null, null},
					{"17:00", null, null, null, null, null, null},
					{"18:00", null, null, null, null, null, null},
					{"19:00", null, null, null, null, null, null},
					{"20:00", null, null, null, null, null, null},
					{"21:00", null, null, null, null, null, null},
				},
				new String[] {
					"Time", "월", "화", "수", "목", "금", "토"
				}
		));
		scrolltime1.setViewportView(table_1);
		//scrollPane_1.setSize(40, 410);
		panel_2.setLayout(gl_panel_2);
		
		
		
		JButton btnNewButton = new JButton();
		btnNewButton.setBorderPainted(false);    //투명 버튼
		btnNewButton.setFocusPainted(false);      //투명 버튼
		btnNewButton.setContentAreaFilled(false); //투명 버튼
		btnNewButton.setBounds(17, 53, 209, 61);
		contentPane.add(btnNewButton);
		

		JButton btnNewButton_1 = new JButton();
		btnNewButton_1.setBorderPainted(false);    //투명 버튼
		btnNewButton_1.setFocusPainted(false);      //투명 버튼
		btnNewButton_1.setContentAreaFilled(false); //투명 버
		btnNewButton_1.setBounds(215, 53, 201, 61);
		contentPane.add(btnNewButton_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 146, 1055, 765);
		contentPane.add(panel);
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		
		//모의 시간표 버튼
		JPanel pnl_TimeTableTemp = new JPanel(){
			//판넬에 이미지 추가
			ImageIcon mainicon = new ImageIcon("img/timetable.png");

			public void paintComponent(Graphics g) {
				g.drawImage(mainicon.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		pnl_TimeTableTemp.setBounds(17, 53, 209, 61);
		contentPane.add(pnl_TimeTableTemp);
		
		JPanel pnl_BetweenTemp = new JPanel(){
			//판넬에 이미지 추가
			ImageIcon mainicon = new ImageIcon("img/between.png");

			public void paintComponent(Graphics g) {
				g.drawImage(mainicon.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		pnl_BetweenTemp.setBounds(215, 53, 201, 61);
		contentPane.add(pnl_BetweenTemp);
		
		
		
		
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ParentPanel.removeAll();
				ParentPanel.add(panel_2);
				ParentPanel.repaint();
				ParentPanel.revalidate();
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ParentPanel.removeAll();
				ParentPanel.add(panel_1);
				ParentPanel.repaint();
				ParentPanel.revalidate();
			}
		});
		
	}
}
