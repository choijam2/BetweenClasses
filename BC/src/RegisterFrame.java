import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class RegisterFrame extends JFrame {
	private Connection con;
	private JPanel contentPane;
	private JTextField nameField;
	private JTextField sidField;
	private JTextField collegeField;
	private JTextField deptField;
	private JPasswordField passwordField;
	private JTextField questField;

	RegisterFrame(Connection con) {
		this.con = con;
		setResizable(false);
		setSize(320, 400);
		setVisible(true);
		setTitle("Member Register");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 320, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		getContentPane().setLayout(null);

		JLabel label_Name = new JLabel("이름");
		label_Name.setBounds(29, 30, 84, 15);
		contentPane.add(label_Name);

		JLabel label_Sid = new JLabel("학번");
		label_Sid.setBounds(29, 70, 87, 21);
		contentPane.add(label_Sid);

		JLabel label_college = new JLabel("대학");
		label_college.setBounds(29, 150, 87, 21);
		contentPane.add(label_college);

		JLabel label_dept = new JLabel("학과");
		label_dept.setBounds(29, 190, 87, 21);
		contentPane.add(label_dept);

		JLabel label_pass = new JLabel("비밀번호");
		label_pass.setBounds(29, 110, 87, 21);
		contentPane.add(label_pass);

		JLabel label_Quest = new JLabel("보물 1호는?");
		label_Quest.setBounds(29, 230, 84, 15);
		contentPane.add(label_Quest);
		
		JLabel lblNewLabel = new JLabel("(비밀번호 찾을 때 사용)");
		lblNewLabel.setBounds(125, 261, 138, 15);
		contentPane.add(lblNewLabel);
		
		nameField = new JTextField();
		nameField.setBounds(125, 30, 116, 21);
		contentPane.add(nameField);
		nameField.setColumns(10);

		sidField = new JTextField();
		sidField.setBounds(125, 70, 116, 21);
		contentPane.add(sidField);
		sidField.setColumns(10);

		collegeField = new JTextField();
		collegeField.setBounds(125, 150, 116, 21);
		contentPane.add(collegeField);
		collegeField.setColumns(10);

		deptField = new JTextField();
		deptField.setBounds(125, 190, 116, 21);
		contentPane.add(deptField);
		deptField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(125, 110, 116, 21);
		contentPane.add(passwordField);

		questField = new JTextField();
		questField.setBounds(125, 230, 116, 21);
		contentPane.add(questField);
		questField.setColumns(10);
		
		JButton btn_Register = new JButton("Register");
		btn_Register.setFont(new Font("ZESSTYPE 비가온다 PT02", Font.BOLD, 30));
		btn_Register.setBounds(81, 285, 149, 67);
		btn_Register.setBorderPainted(false);
		btn_Register.setFocusPainted(false);
		btn_Register.setContentAreaFilled(false);
		contentPane.add(btn_Register);
		
		RegisterBtnActionHandler registerBtnHandler = new RegisterBtnActionHandler(this, con);
		btn_Register.addActionListener(registerBtnHandler);
		
	}

	public JTextField getSidField() {
		return sidField;
	}
	public JTextField getNameField(){
		return nameField;
	}
	public JTextField getCollegeField() {
		return collegeField;
	}

	public JTextField getDetpField() {
		return deptField;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}
	public JTextField getQuestField() {
		return questField;
	}
}
