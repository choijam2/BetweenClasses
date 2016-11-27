import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.util.jar.Attributes;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.JPasswordField;

public class LoginFrame extends JFrame {

	private Connection con;
	private JPanel contentPane;
	private JTextField sidField;
	private JPasswordField passwordField;
	private Font f1 = new Font("ZESSTYPE 비가온다 PT02", Font.BOLD, 35);
	private Font f2 = new Font("ZESSTYPE 비가온다 PT02", Font.PLAIN, 30);
	Color myColor = Color.decode("#383838");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					frame.setSize(600, 930);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LoginFrame() {
		setVisible(true);
		setResizable(false);
		con = startMysql();
		User user = new User("");
		setTitle("Between Classes");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 592, 858);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel() {
			ImageIcon mainicon = new ImageIcon("img/main.png");

			public void paintComponent(Graphics g) {
				g.drawImage(mainicon.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};

		panel.setBounds(68, 71, 472, 387);
		contentPane.add(panel);

		JLabel lbl_sid = new JLabel("학번");
		lbl_sid.setBounds(87, 473, 80, 40);
		lbl_sid.setFont(f1);
		contentPane.add(lbl_sid);

		JLabel lbl_pw = new JLabel("비밀번호");
		lbl_pw.setFont(f1);
		lbl_pw.setBounds(87, 534, 80, 40);
		contentPane.add(lbl_pw);

		sidField = new JTextField(8);
		sidField.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		sidField.setBounds(203, 473, 188, 40);
		sidField.setDocument(new TextLimit(8));
		sidField.setColumns(10);
		contentPane.add(sidField);

		passwordField = new JPasswordField(15);
		passwordField.setFont(new Font("굴림", Font.PLAIN, 14));
		passwordField.setBounds(203, 534, 188, 40);
		contentPane.add(passwordField);
		// 아이디칸에서 탭키 누르면 바로 비밀번호칸으로 감
		sidField.setFocusTraversalKeysEnabled(false);
		sidField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_TAB) {
					passwordField.requestFocus();
				}
			}
		});

		JButton btn_Login = new JButton(new ImageIcon("img/loginnext.png"));
		btn_Login.setBounds(408, 473, 106, 95);
		btn_Login.setBorderPainted(false);
		btn_Login.setFocusPainted(false);
		btn_Login.setContentAreaFilled(false);
		btn_Login.setActionCommand("Login");// 버튼에 대한 액션이름 추가
		contentPane.add(btn_Login);

		LoginBtnFunc loginBtnHandler = new LoginBtnFunc(this, con, user);
		btn_Login.addActionListener(loginBtnHandler);
		passwordField.registerKeyboardAction(loginBtnHandler, "Login", KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0),
				JComponent.WHEN_FOCUSED);
		// 비밀번호 텍스트에서 엔터치면 로그인버튼으로 이어줌

		// 회원가입
		JButton btn_Register = new JButton("회원가입");
		btn_Register.setFont(f1);
		btn_Register.setBounds(417, 602, 106, 40);
		btn_Register.setForeground(Color.decode("#ED3E75"));
		btn_Register.setBorderPainted(false);
		btn_Register.setFocusPainted(false);
		btn_Register.setContentAreaFilled(false);
		contentPane.add(btn_Register);

		RegisterFrameFunc registerbtnhandler = new RegisterFrameFunc(con);
		btn_Register.addActionListener(registerbtnhandler);

		// 비밀번호찾기
		JButton btn_PassFind = new JButton("비밀번호 찾기");
		btn_PassFind.setFont(f1);
		btn_PassFind.setBounds(253, 602, 150, 40);
		btn_PassFind.setForeground(Color.decode("#ED3E75"));
		btn_PassFind.setBorderPainted(false);
		btn_PassFind.setFocusPainted(false);

		btn_PassFind.setContentAreaFilled(false);
		contentPane.add(btn_PassFind);

		PassFindFrameFunc passFindBtnHandler = new PassFindFrameFunc(con);
		btn_PassFind.addActionListener(passFindBtnHandler);

		JButton btn_Nonmember = new JButton("비회원으로 이용하기 GoGo");
		btn_Nonmember.setBackground(Color.WHITE);
		btn_Nonmember.setFont(f2);
		btn_Nonmember.setBounds(87, 678, 209, 51);
		btn_Nonmember.setBorderPainted(false);
		btn_Nonmember.setFocusPainted(false);
		btn_Nonmember.setContentAreaFilled(false);
		contentPane.add(btn_Nonmember);

		NonmemberFunc nonmemberBtnHandler = new NonmemberFunc(con, user, this);
		btn_Nonmember.addActionListener(nonmemberBtnHandler);
	}

	public JTextField getSidField() {
		return sidField;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public Connection startMysql() {
		MysqlConnect mysql = null;
		try {
			mysql = new MysqlConnect();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return mysql.getCon();
	}

	public class TextLimit extends PlainDocument {
		private int limit;

		public TextLimit(int limit) {
			super();
			this.limit = limit;
		}

		public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
			if (str == null)
				return;
			if (getLength() + str.length() <= limit)
				super.insertString(offset, str, attr);
		}
	}
}
