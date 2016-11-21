import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;

public class RandomSelcetedFrame extends JFrame {
	private JPanel contentPane;
	RandomSelcetedFrame(String day,String Time) {
		setResizable(false);
		setSize(320, 250);
		setVisible(true);
		setTitle("Selceted Time");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(200, 400, 320, 250);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		getContentPane().setLayout(null);
		
		JLabel label_Sid = new JLabel(day);
		label_Sid.setHorizontalAlignment(SwingConstants.CENTER);
		label_Sid.setFont(new Font("ZESSTYPE 비가온다 PT02", Font.PLAIN, 45));
		label_Sid.setBounds(114, 24, 80, 80);
		contentPane.add(label_Sid);
		
		JLabel label_Quest = new JLabel(Time);
		label_Quest.setHorizontalAlignment(SwingConstants.CENTER);
		label_Quest.setFont(new Font("ZESSTYPE 비가온다 PT02", Font.PLAIN, 30));
		label_Quest.setBounds(12, 113, 290, 50);
		contentPane.add(label_Quest);
		
	}
}
