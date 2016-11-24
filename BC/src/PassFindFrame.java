import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PassFindFrame extends JFrame {
	private JPanel contentPane;
	private JTextField sidField;
	private JTextField questField;
	private JTextField nameField;

	PassFindFrame(Connection con) {
		setResizable(false);
		setSize(320, 250);
		setVisible(true);
		setTitle("Password Finder");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(200, 400, 320, 250);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		getContentPane().setLayout(null);
		
		JLabel label_Sid = new JLabel("학 번");
		label_Sid.setFont(new Font("ZESSTYPE 비가온다 PT02", Font.PLAIN, 22));
		label_Sid.setBounds(40, 20, 64, 25);
		contentPane.add(label_Sid);
		
		JLabel label_Name = new JLabel("이름");
		label_Name.setFont(new Font("ZESSTYPE 비가온다 PT02", Font.PLAIN, 22));
		label_Name.setBounds(40, 65, 64, 29);
		contentPane.add(label_Name);
		
		JLabel label_Quest = new JLabel("보물 1호는?");
		label_Quest.setFont(new Font("ZESSTYPE 비가온다 PT02", Font.PLAIN, 22));
		label_Quest.setBounds(40, 113, 64, 29);
		contentPane.add(label_Quest);
		
		sidField = new JTextField();
		sidField.setBounds(123, 17, 140, 30);
		contentPane.add(sidField);
		sidField.setColumns(10);
		
		questField = new JTextField();
		questField.setBounds(123, 113, 140, 30);
		contentPane.add(questField);
		questField.setColumns(10);
		
		nameField = new JTextField();
		nameField.setBounds(123, 65, 140, 30);
		contentPane.add(nameField);
		nameField.setColumns(10);
		
		JButton btnFind = new JButton("비밀번호 찾기");
		btnFind.setFont(new Font("ZESSTYPE 비가온다 PT02", Font.BOLD, 30));
		btnFind.setBounds(80, 163, 159, 49);
		btnFind.setBorderPainted(false);
		btnFind.setFocusPainted(false);
		btnFind.setContentAreaFilled(false);
		contentPane.add(btnFind);
		
		
		PassFindFunc passFindActionHandler = new PassFindFunc(this, con);
		btnFind.addActionListener(passFindActionHandler);
	}

	public JTextField getSidField() {
		return sidField;
	}

	public JTextField getQuestField() {
		return questField;
	}

	public JTextField getNameField() {
		return nameField;
	}
}
