import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.CardLayout;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private Font f1=new Font("ZESSTYPE 비가온다 PT02",Font.BOLD,35);
	private Font f2=new Font("ZESSTYPE 비가온다 PT02",Font.PLAIN,30);
	Color myColor = Color.decode("#383838");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					frame.setSize(600,930);
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
	public LoginFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 592, 858);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel(){
		ImageIcon mainicon=new ImageIcon("main.png");
		
		 public void paintComponent(Graphics g) {
			    g.drawImage(mainicon.getImage(), 0, 0, null);
			    setOpaque(false);
			    super.paintComponent(g);
			   }
		};
		
		panel.setBounds(68, 71, 472, 387);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("학번");

		lblNewLabel.setBounds(87, 473, 78, 43);
		lblNewLabel.setFont(f1);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("비밀번호");
		lblNewLabel_1.setFont(f1);
		lblNewLabel_1.setBounds(87, 534, 78, 37);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(203, 473, 188, 46);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(203, 528, 188, 43);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panel_1 = new JPanel(){
			ImageIcon mainicon=new ImageIcon("loginnext.png");
			 public void paintComponent(Graphics g) {
				    g.drawImage(mainicon.getImage(), 0, 0, null);
				    setOpaque(false);
				    super.paintComponent(g);
				   }
			};
		panel_1.setBounds(408, 473, 139, 86);
		contentPane.add(panel_1);
		panel_1.setLayout(new CardLayout(0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("회원가입");
		lblNewLabel_2.setFont(f1);
		lblNewLabel_2.setBounds(417, 606, 123, 29);
		lblNewLabel_2.setForeground(Color.decode("#ED3E75"));
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("비밀번호 찾기");
		lblNewLabel_3.setFont(f1);
		lblNewLabel_3.setBounds(268, 602, 132, 37);
		lblNewLabel_3.setForeground(Color.decode("#ED3E75"));
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("비회원으로 이용하기 GoGo");
		lblNewLabel_4.setFont(f2);
		lblNewLabel_4.setBounds(87, 678, 392, 51);
		contentPane.add(lblNewLabel_4);
	}
}
