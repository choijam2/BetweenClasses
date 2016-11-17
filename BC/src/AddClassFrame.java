import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JTextArea;

public class AddClassFrame extends JFrame {
	private Student student;
	private Connection con;
	private JPanel contentPane;
	private JTable mockTable;
	private JTextField txt_ClassNum;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;
	private JTable table_4;

	AddClassFrame(Connection con, boolean check, String sid) {
		student = new Student(sid);
		setResizable(false);
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
		String[] defDays = new String[] { "Time", "월", "화", "수", "목", "금", "토" };
		this.con = con;
		setTitle("BetweenClasses");
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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

		JPanel panel_TimeTable = new JPanel();
		panel_TimeTable.setBorder(new LineBorder(Color.BLACK, 2));
		panel_TimeTable.setBackground(Color.WHITE);
		ParentPanel.add(panel_TimeTable, "name_798298334667093");

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 28, 746, 735);

		JPanel Pnl_ClassNum = new JPanel() {
			// 판넬에 이미지 추가
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

		// 셀 글자 정렬
		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);

		mockTable = new JTable();
		mockTable.setEnabled(false);
		mockTable.setRowSelectionAllowed(false);

		mockTable.getTableHeader().setFont(new Font("ZESSTYPE 비가온다 PT02", Font.BOLD, 25));
		mockTable.setFont(new Font("ZESSTYPE 비가온다 PT02", Font.PLAIN, 25));
		mockTable.setBounds(37, 35, 400, 600);
		mockTable.setRowHeight(28);
		mockTable.setModel(new DefaultTableModel(defTableTime, defDays));

		mockTable.setDefaultRenderer(Object.class, new MyRenderer());
		mockTable.setIntercellSpacing(new Dimension(1, 0));

		// 가운데 정렬
		mockTable.getColumn("Time").setCellRenderer(celAlignCenter);
		mockTable.getColumn("Time").setPreferredWidth(20);
		panel_TimeTable.setLayout(null);

		scrollPane.setViewportView(mockTable);
		panel_TimeTable.add(scrollPane);
		panel_TimeTable.add(txt_ClassNum);
		panel_TimeTable.add(Pnl_ClassNum);

		JPanel panel_BCTable = new JPanel();
		panel_BCTable.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_BCTable.setBackground(Color.WHITE);
		ParentPanel.add(panel_BCTable, "name_798285310498133");

		JScrollPane scrollTime1 = new JScrollPane();

		JScrollPane scrollTime2 = new JScrollPane();

		JScrollPane scrollTime3 = new JScrollPane();

		JScrollPane scrollTime4 = new JScrollPane();

		GroupLayout gl_panel_BCTable = new GroupLayout(panel_BCTable);
		gl_panel_BCTable.setHorizontalGroup(gl_panel_BCTable.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_BCTable.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel_BCTable.createParallelGroup(Alignment.TRAILING)
								.addComponent(scrollTime3, GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE).addComponent(
										scrollTime1, GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE))
						.addGap(18)
						.addGroup(gl_panel_BCTable.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(scrollTime2).addComponent(scrollTime4, GroupLayout.DEFAULT_SIZE, 501,
										Short.MAX_VALUE))
						.addGap(234)));
		gl_panel_BCTable.setVerticalGroup(gl_panel_BCTable.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_BCTable.createSequentialGroup().addGap(30)
						.addGroup(gl_panel_BCTable.createParallelGroup(Alignment.BASELINE)
								.addComponent(scrollTime1, GroupLayout.PREFERRED_SIZE, 348, GroupLayout.PREFERRED_SIZE)
								.addComponent(scrollTime2, GroupLayout.PREFERRED_SIZE, 348, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel_BCTable.createParallelGroup(Alignment.BASELINE)
								.addComponent(scrollTime3, GroupLayout.PREFERRED_SIZE, 351, GroupLayout.PREFERRED_SIZE)
								.addComponent(scrollTime4, GroupLayout.PREFERRED_SIZE, 348, GroupLayout.PREFERRED_SIZE))
						.addGap(20)));
		
		int[] CheckIsTable = new int[4];
		
		table_4 = new JTable();
		scrollTime4.setViewportView(table_4);
		table_4.setEnabled(false);
		table_4.setRowSelectionAllowed(false);
		table_4.getTableHeader().setFont(new Font("ZESSTYPE 비가온다 PT02", Font.BOLD, 18));
		table_4.setFont(new Font("ZESSTYPE 비가온다 PT02", Font.PLAIN, 18));
		table_4.setRowHeight(19);
		table_4.setModel(new DefaultTableModel(defTableTime, defDays));
		table_4.setDefaultRenderer(Object.class, new MyRenderer());
		table_4.getColumn("Time").setCellRenderer(celAlignCenter);
		table_4.getColumn("Time").setPreferredWidth(20);

		table_3 = new JTable();
		table_3.setRowSelectionAllowed(false);
		table_3.setEnabled(false);
		table_3.getTableHeader().setFont(new Font("ZESSTYPE 비가온다 PT02", Font.BOLD, 18));
		table_3.setFont(new Font("ZESSTYPE 비가온다 PT02", Font.PLAIN, 18));
		table_3.setRowHeight(19);
		table_3.setModel(new DefaultTableModel(defTableTime, defDays));
		table_3.setDefaultRenderer(Object.class, new MyRenderer());
		table_3.getColumn("Time").setCellRenderer(celAlignCenter);
		table_3.getColumn("Time").setPreferredWidth(20);
		scrollTime3.setViewportView(table_3);

		table_2 = new JTable();
		table_2.setRowSelectionAllowed(false);
		table_2.setEnabled(false);
		table_2.getTableHeader().setFont(new Font("ZESSTYPE 비가온다 PT02", Font.BOLD, 18));
		table_2.setFont(new Font("ZESSTYPE 비가온다 PT02", Font.PLAIN, 18));
		table_2.setRowHeight(19);
		table_2.setModel(new DefaultTableModel(defTableTime, defDays));
		table_2.setDefaultRenderer(Object.class, new MyRenderer());
		table_2.getColumn("Time").setCellRenderer(celAlignCenter);
		table_2.getColumn("Time").setPreferredWidth(20);
		scrollTime2.setViewportView(table_2);

		table_1 = new JTable();
		table_1.setRowSelectionAllowed(false);
		table_1.setEnabled(false);
		table_1.getTableHeader().setFont(new Font("ZESSTYPE 비가온다 PT02", Font.BOLD, 18));
		table_1.setFont(new Font("ZESSTYPE 비가온다 PT02", Font.PLAIN, 18));
		table_1.setRowHeight(19);
		table_1.setModel(new DefaultTableModel(defTableTime, defDays));
		table_1.setDefaultRenderer(Object.class, new MyRenderer());
		table_1.getColumn("Time").setCellRenderer(celAlignCenter);
		table_1.getColumn("Time").setPreferredWidth(20);
		scrollTime1.setViewportView(table_1);
		panel_BCTable.setLayout(gl_panel_BCTable);
		// 모의시간표 추가버튼
		JButton btn_Add = new JButton(new ImageIcon("img/add.png"));
		btn_Add.setBorderPainted(false); // 투명 버튼
		btn_Add.setFocusPainted(false); // 투명 버튼
		btn_Add.setContentAreaFilled(false);
		btn_Add.setBounds(884, 300, 81, 42);
		panel_TimeTable.add(btn_Add);
		TimeTableAddFunc mockAddBtn = new TimeTableAddFunc(txt_ClassNum, con, mockTable, student);
		btn_Add.addActionListener(mockAddBtn);

		// 모의시간표 조회버튼
		JButton btn_Search = new JButton(new ImageIcon("img/search.png"));
		btn_Search.setBorderPainted(false);
		btn_Search.setFocusPainted(false);
		btn_Search.setContentAreaFilled(false);
		btn_Search.setBounds(884, 477, 81, 42);
		panel_TimeTable.add(btn_Search);
		TimeTableSearchClasses mockSearchBtn = new TimeTableSearchClasses(con);
		btn_Search.addActionListener(mockSearchBtn);

		// 모의시간표 삭제버튼
		JButton btn_Del = new JButton(new ImageIcon("img/del.png"));
		btn_Del.setBorderPainted(false); // 투명 버튼
		btn_Del.setFocusPainted(false); // 투명 버튼
		btn_Del.setContentAreaFilled(false);
		btn_Del.setBounds(884, 365, 81, 42);
		panel_TimeTable.add(btn_Del);
		TimeTableDelFunc mockDelBtn = new TimeTableDelFunc(txt_ClassNum, mockTable, con, student);
		btn_Del.addActionListener(mockDelBtn);

		// 모의시간표 저장버튼
		JButton btn_Save = new JButton(new ImageIcon("img/save.png"));
		btn_Save.setBorderPainted(false); // 투명 버튼
		btn_Save.setFocusPainted(false); // 투명 버튼
		btn_Save.setContentAreaFilled(false);
		btn_Save.setBounds(884, 420, 81, 42);
		panel_TimeTable.add(btn_Save);

		// ------------------------------
		JPanel Pfpanel = new JPanel();
		Pfpanel.setBounds(1055, 59, 182, 180);
		Pfpanel.setBackground(new Color(255, 0, 0, 0));
		TitledBorder pfborder = new TitledBorder("교수");
		Pfpanel.setBorder(pfborder);
		panel_BCTable.add(Pfpanel);

		JPanel STpanel = new JPanel();
		STpanel.setBounds(1055, 300, 182, 180);
		STpanel.setBackground(new Color(255, 0, 0, 0));
		TitledBorder STborder = new TitledBorder("학생");
		STpanel.setBorder(STborder);
		panel_BCTable.add(STpanel);

		JTextField STtextField = new JTextField();
		STtextField.setBounds(1135, 340, 80, 21);
		panel_BCTable.add(STtextField);
		STtextField.setColumns(10);
		
		JButton PfaddButton = new JButton("추가");
		PfaddButton.setBounds(1070, 190, 70, 23);
		panel_BCTable.add(PfaddButton);

		JButton PfdelButton = new JButton("삭제");
		PfdelButton.setBounds(1155, 190, 70, 23);
		panel_BCTable.add(PfdelButton);

		JButton STaddButton = new JButton("추가");
		STaddButton.setBounds(1070, 430, 70, 23);
		panel_BCTable.add(STaddButton);
		BCAddFunc BCSTDelbtn = new BCAddFunc(con,table_1,table_2,table_3,table_4,STtextField,false,CheckIsTable);
		STaddButton.addActionListener(BCSTDelbtn);
		
		JButton STdelButton = new JButton("삭제");
		STdelButton.setBounds(1155, 430, 70, 23);
		panel_BCTable.add(STdelButton);

		JButton FindButton = new JButton("공강찾기");
		FindButton.setBounds(1100, 550, 97, 23);
		panel_BCTable.add(FindButton);

		JLabel INPfNewLabel = new JLabel("성함   :");
		INPfNewLabel.setBounds(1075, 94, 57, 15);
		panel_BCTable.add(INPfNewLabel);

		JTextField PftextField = new JTextField();
		PftextField.setBounds(1135, 91, 80, 21);
		panel_BCTable.add(PftextField);
		PftextField.setColumns(10);

		JLabel INSTNewLabel = new JLabel("학번  :");
		INSTNewLabel.setBounds(1075, 344, 57, 15);
		panel_BCTable.add(INSTNewLabel);

		// ------------------------------
		// ------------------------------

		// 모의시간표 버튼
		JButton btnTimeTableTable = new JButton(new ImageIcon("img/timetable.png"));
		btnTimeTableTable.setBorderPainted(false); // 투명 버튼
		btnTimeTableTable.setFocusPainted(false); // 투명 버튼
		btnTimeTableTable.setContentAreaFilled(false); // 투명 버튼
		btnTimeTableTable.setBounds(17, 53, 201, 65);
		contentPane.add(btnTimeTableTable);

		// 공강시간표 버튼
		JButton btnBCTable = new JButton(new ImageIcon("img/between.png"));
		btnBCTable.setBorderPainted(false); // 투명 버튼
		btnBCTable.setFocusPainted(false); // 투명 버튼
		btnBCTable.setContentAreaFilled(false); // 투명 버튼
		btnBCTable.setBounds(215, 53, 201, 65);
		contentPane.add(btnBCTable);

		JPanel panel = new JPanel();
		panel.setBounds(0, 146, 1055, 765);
		contentPane.add(panel);
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);

		btnBCTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ParentPanel.removeAll();
				ParentPanel.add(panel_BCTable);
				ParentPanel.repaint();
				ParentPanel.revalidate();
			}
		});
		btnTimeTableTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ParentPanel.removeAll();
				ParentPanel.add(panel_TimeTable);
				ParentPanel.repaint();
				ParentPanel.revalidate();
			}
		});

		if (!check) {
			txt_ClassNum.setEnabled(false);
			btn_Add.setEnabled(false);
			btn_Del.setEnabled(false);
			btn_Save.setEnabled(false);
			btnBCTable.setEnabled(false);
		}
	}

	class MyRenderer extends DefaultTableCellRenderer {
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row,
					column);

			if (table.getValueAt(row, column) != null) {
				cellComponent.setBackground(Color.YELLOW);
			} else
				cellComponent.setBackground(Color.WHITE);
			return cellComponent;
		}
	}
}
