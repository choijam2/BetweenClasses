import java.awt.AWTException;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Robot;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

public class ResultFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private static JTable BCTimeTable;

	public ResultFrame(JTable BCtable) throws ClassNotFoundException {
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1283, 976);
		setTitle("\uBAA8\uB450\uC758 \uACF5\uAC15");
		setBounds(100, 100, 1099, 934);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
		
		
		contentPane.setLayout(null);
		BCTimeTable = BCtable;
		BCTimeTable.setEnabled(false);
		BCTimeTable.setRowSelectionAllowed(false);
		BCTimeTable.setFont(new Font("ZESSTYPE 비가온다 PT02", Font.PLAIN, 24));
		BCTimeTable.getTableHeader().setFont(new Font("ZESSTYPE 비가온다 PT02", Font.PLAIN, 24));
		BCTimeTable.setBounds(37, 35, 402, 600);
		BCTimeTable.setRowHeight(53);
		BCTimeTable.setIntercellSpacing(new Dimension(1, 0));// ???? 선여백처리??
		BCTimeTable.setDefaultRenderer(Object.class, new MyRenderer());
		BCTimeTable.setDefaultRenderer(Object.class, new MyRenderer());
		BCTimeTable.getColumn("Time").setCellRenderer(celAlignCenter);
		BCTimeTable.getColumn("Time").setPreferredWidth(20);

		
		JScrollPane scrollPane = new JScrollPane(BCTimeTable);
		scrollPane.setBounds(52, 124, 680, 723);
		contentPane.add(scrollPane);
		JButton btn_Save = new JButton(new ImageIcon("result_save.png"));
		btn_Save.setBorderPainted(false); // 투명 버튼
		btn_Save.setFocusPainted(false); // 투명 버튼
		btn_Save.setContentAreaFilled(false); // 투명 버튼
		btn_Save.setBounds(789, 713, 124, 52);
		contentPane.add(btn_Save);
//		JPanel panel = new JPanel() {
//			ImageIcon mainicon = new ImageIcon("result.png");
//
//			public void paintComponent(Graphics g) {
//				g.drawImage(mainicon.getImage(), 0, 0, null);
//				setOpaque(false);
//				super.paintComponent(g);
//			}
//		};
//		panel.setBounds(52, 28, 368, 94);
//		contentPane.add(panel);
		
		JButton btn_Random = new JButton(new ImageIcon("img/ramdom_img.png"));
		btn_Random.setBounds(789, 781, 176, 46);
		btn_Random.setBorderPainted(false);
		btn_Random.setFocusPainted(false);
		btn_Random.setContentAreaFilled(false);
		contentPane.add(btn_Random);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(749, 124, 311, 559);
		contentPane.add(panel_1);
		
		JTextArea textArea = new JTextArea();
		panel_1.add(textArea);

	}
}

class MyRenderer extends DefaultTableCellRenderer {
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row,
				column);

		if ((int)table.getValueAt(row, column) == 0) {
			cellComponent.setBackground(Color.YELLOW);
		} else
			cellComponent.setBackground(Color.WHITE);
		return cellComponent;
	}
}