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
	private Connection con;
	private JPanel contentPane;
	private JTable mockTable;
	private JTextField txt_ClassNum;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;
	private JTable table_4;
	private JTable table_5;
	private JTable table_6;

	AddClassFrame(Connection con, boolean check) {
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
				{ "21:00 ~", null, null, null, null, null, null }};
		String[] defDays = new String[] { "Time", "��", "ȭ", "��", "��", "��", "��" };
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
			// �ǳڿ� �̹��� �߰�
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

		// ���ǽð�ǥ �߰���ư
		JButton btn_Add = new JButton(new ImageIcon("img/add.png"));
		btn_Add.setBorderPainted(false); // ���� ��ư
		btn_Add.setFocusPainted(false); // ���� ��ư
		btn_Add.setContentAreaFilled(false);
		btn_Add.setBounds(884, 300, 81, 42);
		panel_TimeTable.add(btn_Add);
		TimeTableAddFunc mockAddBtn = new TimeTableAddFunc(txt_ClassNum, con);
		btn_Add.addActionListener(mockAddBtn);
		
		//���ǽð�ǥ ��ȸ��ư
		JButton btn_Search = new JButton(new ImageIcon("img/search.png"));
		//JButton btn_Search = new JButton("gg");
		//System.out.println("Ggfffffffff");
		btn_Search.setBorderPainted(false);
		btn_Search.setFocusPainted(false);
		btn_Search.setContentAreaFilled(false);
		btn_Search.setBounds(884, 477, 81, 42);
		panel_TimeTable.add(btn_Search);
		TimeTableSearchClasses mockSearchBtn = new TimeTableSearchClasses(txt_ClassNum, mockTable, con);
	    btn_Search.addActionListener(mockSearchBtn);

		// ���ǽð�ǥ ������ư
		JButton btn_Del = new JButton(new ImageIcon("img/del.png"));
		btn_Del.setBorderPainted(false); // ���� ��ư
		btn_Del.setFocusPainted(false); // ���� ��ư
		btn_Del.setContentAreaFilled(false);
		btn_Del.setBounds(884, 365, 81, 42);
		panel_TimeTable.add(btn_Del);
		TimeTableDelFunc mockDelBtn = new TimeTableDelFunc(txt_ClassNum, mockTable, con);
		btn_Del.addActionListener(mockDelBtn);

		// ���ǽð�ǥ �����ư
		JButton btn_Save = new JButton(new ImageIcon("img/save.png"));
		btn_Save.setBorderPainted(false); // ���� ��ư
		btn_Save.setFocusPainted(false); // ���� ��ư
		btn_Save.setContentAreaFilled(false);
		btn_Save.setBounds(884, 420, 81, 42);
		panel_TimeTable.add(btn_Save);

		// �� ���� ����
		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);

		mockTable = new JTable();
		mockTable.setEnabled(false);
		mockTable.setRowSelectionAllowed(false);
		
		mockTable.getTableHeader().setFont(new Font("ZESSTYPE �񰡿´� PT02", Font.BOLD, 25));
		mockTable.setFont(new Font("ZESSTYPE �񰡿´� PT02", Font.PLAIN, 25));
		mockTable.setBounds(37, 35, 400, 600);
		mockTable.setRowHeight(28);
		mockTable.setModel(new DefaultTableModel(defTableTime, defDays));
		
		mockTable.setValueAt("�����ͺ��̽�", 2, 2);
		mockTable.setValueAt("IT�� 117ȣ", 3, 2);
		mockTable.setValueAt("��ǻ�ͱ���", 5, 4);
		mockTable.setValueAt("IT�� 115ȣ", 6, 4);
		mockTable.setDefaultRenderer(Object.class,  new MyRenderer());
		mockTable.setIntercellSpacing(new Dimension(1,0));
		
		// ��� ����
		mockTable.getColumn("Time").setCellRenderer(celAlignCenter);
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

		JScrollPane scrollTime5 = new JScrollPane();

		JScrollPane scrollTimr6 = new JScrollPane();
		GroupLayout gl_panel_BCTable = new GroupLayout(panel_BCTable);
		gl_panel_BCTable.setHorizontalGroup(
			gl_panel_BCTable.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_BCTable.createSequentialGroup()
					.addGap(27)
					.addGroup(gl_panel_BCTable.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_BCTable.createSequentialGroup()
							.addComponent(scrollTime4, GroupLayout.PREFERRED_SIZE, 320, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(scrollTime5, GroupLayout.PREFERRED_SIZE, 320, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(scrollTimr6, GroupLayout.PREFERRED_SIZE, 320, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_BCTable.createSequentialGroup()
							.addComponent(scrollTime1, GroupLayout.PREFERRED_SIZE, 320, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(scrollTime2, GroupLayout.PREFERRED_SIZE, 320, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(scrollTime3, GroupLayout.PREFERRED_SIZE, 320, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(234, Short.MAX_VALUE))))
		);
		gl_panel_BCTable.setVerticalGroup(
			gl_panel_BCTable.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_BCTable.createSequentialGroup()
					.addContainerGap(59, Short.MAX_VALUE)
					.addGroup(gl_panel_BCTable.createParallelGroup(Alignment.LEADING, false)
						.addComponent(scrollTime1, 0, 0, Short.MAX_VALUE)
						.addComponent(scrollTime2, GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
						.addComponent(scrollTime3, GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE))
					.addGap(49)
					.addGroup(gl_panel_BCTable.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollTime4, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_BCTable.createParallelGroup(Alignment.BASELINE)
							.addComponent(scrollTime5, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)
							.addComponent(scrollTimr6, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);

		table_6 = new JTable();
		table_6.setEnabled(false);
		table_6.setRowSelectionAllowed(false);
		table_6.getTableHeader().setFont(new Font("ZESSTYPE �񰡿´� PT02", Font.BOLD, 18));
		table_6.setFont(new Font("ZESSTYPE �񰡿´� PT02", Font.PLAIN, 18));
		table_6.setRowHeight(19);
		table_6.setModel(new DefaultTableModel(defTableTime, defDays));
		scrollTimr6.setViewportView(table_6);

		table_5 = new JTable();
		table_5.setRowSelectionAllowed(false);
		table_5.setEnabled(false);
		table_5.getTableHeader().setFont(new Font("ZESSTYPE �񰡿´� PT02", Font.BOLD, 18));
		table_5.setFont(new Font("ZESSTYPE �񰡿´� PT02", Font.PLAIN, 18));
		table_5.setRowHeight(19);
		table_5.setModel(new DefaultTableModel(defTableTime, defDays));
		scrollTime5.setViewportView(table_5);

		table_4 = new JTable();
		table_4.setEnabled(false);
		table_4.setRowSelectionAllowed(false);
		table_4.getTableHeader().setFont(new Font("ZESSTYPE �񰡿´� PT02", Font.BOLD, 18));
		table_4.setFont(new Font("ZESSTYPE �񰡿´� PT02", Font.PLAIN, 18));
		table_4.setRowHeight(19);
		table_4.setModel(new DefaultTableModel(defTableTime, defDays));
		scrollTime4.setViewportView(table_4);

		table_3 = new JTable();
		table_3.setRowSelectionAllowed(false);
		table_3.setEnabled(false);
		table_3.getTableHeader().setFont(new Font("ZESSTYPE �񰡿´� PT02", Font.BOLD, 18));
		table_3.setFont(new Font("ZESSTYPE �񰡿´� PT02", Font.PLAIN, 18));
		table_3.setRowHeight(19);
		table_3.setModel(new DefaultTableModel(defTableTime, defDays));
		scrollTime3.setViewportView(table_3);

		table_2 = new JTable();
		table_2.setRowSelectionAllowed(false);
		table_2.setEnabled(false);
		table_2.getTableHeader().setFont(new Font("ZESSTYPE �񰡿´� PT02", Font.BOLD, 18));
		table_2.setFont(new Font("ZESSTYPE �񰡿´� PT02", Font.PLAIN, 18));
		table_2.setRowHeight(19);
		table_2.setModel(new DefaultTableModel(defTableTime, defDays));
		scrollTime2.setViewportView(table_2);

		table_1 = new JTable();
		table_1.setRowSelectionAllowed(false);
		table_1.setEnabled(false);
		table_1.getTableHeader().setFont(new Font("ZESSTYPE �񰡿´� PT02", Font.BOLD, 18));
		table_1.setFont(new Font("ZESSTYPE �񰡿´� PT02", Font.PLAIN, 18));
		table_1.setRowHeight(19);
		table_1.setModel(new DefaultTableModel(defTableTime, defDays));
		scrollTime1.setViewportView(table_1);
		panel_BCTable.setLayout(gl_panel_BCTable);

		// ------------------------------
		JPanel Pfpanel = new JPanel();
		Pfpanel.setBounds(1055, 59, 182, 180);
		Pfpanel.setBackground(new Color(255, 0, 0, 0));
		TitledBorder pfborder = new TitledBorder("����");
		Pfpanel.setBorder(pfborder);
		panel_BCTable.add(Pfpanel);

		JPanel STpanel = new JPanel();
		STpanel.setBounds(1055, 300, 182, 180);
		STpanel.setBackground(new Color(255, 0, 0, 0));
		TitledBorder STborder = new TitledBorder("�л�");
		STpanel.setBorder(STborder);
		panel_BCTable.add(STpanel);

		JButton PfaddButton = new JButton("�߰�");
		PfaddButton.setBounds(1070, 190, 70, 23);
		panel_BCTable.add(PfaddButton);

		JButton PfdelButton = new JButton("����");
		PfdelButton.setBounds(1155, 190, 70, 23);
		panel_BCTable.add(PfdelButton);

		JButton STaddButton = new JButton("�߰�");
		STaddButton.setBounds(1070, 430, 70, 23);
		panel_BCTable.add(STaddButton);

		JButton STdelButton = new JButton("����");
		STdelButton.setBounds(1155, 430, 70, 23);
		panel_BCTable.add(STdelButton);

		JButton FindButton = new JButton("����ã��");
		FindButton.setBounds(1100, 550, 97, 23);
		panel_BCTable.add(FindButton);

		JLabel INPfNewLabel = new JLabel("����   :");
		INPfNewLabel.setBounds(1075, 94, 57, 15);
		panel_BCTable.add(INPfNewLabel);

		JTextField PftextField = new JTextField();
		PftextField.setBounds(1135, 91, 80, 21);
		panel_BCTable.add(PftextField);
		PftextField.setColumns(10);

		JLabel INSTNewLabel = new JLabel("�й�  :");
		INSTNewLabel.setBounds(1075, 344, 57, 15);
		panel_BCTable.add(INSTNewLabel);

		JTextField STtextField = new JTextField();
		STtextField.setBounds(1135, 340, 80, 21);
		panel_BCTable.add(STtextField);
		STtextField.setColumns(10);
		// ------------------------------
		// ------------------------------

		// ���ǽð�ǥ ��ư
		JButton btnTimeTableTable = new JButton(new ImageIcon("img/timetable.png"));
		btnTimeTableTable.setBorderPainted(false); // ���� ��ư
		btnTimeTableTable.setFocusPainted(false); // ���� ��ư
		btnTimeTableTable.setContentAreaFilled(false); // ���� ��ư
		btnTimeTableTable.setBounds(17, 53, 201, 65);
		contentPane.add(btnTimeTableTable);

		// �����ð�ǥ ��ư
		JButton btnBCTable = new JButton(new ImageIcon("img/between.png"));
		btnBCTable.setBorderPainted(false); // ���� ��ư
		btnBCTable.setFocusPainted(false); // ���� ��ư
		btnBCTable.setContentAreaFilled(false); // ���� ��ư
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
		
		JLabel panel12 = new JLabel();
		panel12.setBounds(100,100,100,100);
		panel12.setBackground(Color.GREEN);
		panel12.setLayout(null);
		
		
	}
	/*class MyRenderer implements TableCellRenderer{
		public Component getTableCellRendererComponent(JTable table, Object value, 
				boolean isSelected, boolean hasFocus, int row, int column){
		JTextField editor = new JTextField();
		editor.setHorizontalAlignment(SwingConstants.CENTER);
		if(value != null)
			editor.setText(value.toString());
		if(row == 2 && column == 2)
			editor.setBackground(Color.GREEN);
		if(row == 3 && column == 2)
			editor.setBackground(Color.GREEN);
		if(row == 5 && column == 4)
			editor.setBackground(Color.CYAN);
		if(row == 6 && column == 4)
			editor.setBackground(Color.CYAN);
		editor.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 1, new Color(183, 183, 183)));
		return editor;
		}
	}*/
	class MyRenderer extends DefaultTableCellRenderer{
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, 
				boolean hasFocus, int row, int column){
			Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
			
			if(table.getValueAt(row, column) != null){
				cellComponent.setBackground(Color.YELLOW);
			}else
				cellComponent.setBackground(Color.WHITE);
			return cellComponent;
		}
	}
}
