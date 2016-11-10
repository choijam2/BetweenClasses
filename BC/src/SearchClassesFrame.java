import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class SearchClassesFrame extends JFrame {

	private JPanel contentPane;
	private JTextField lectureTextField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchClassesFrame frame = new SearchClassesFrame();
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
	public SearchClassesFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 863, 301);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox gradeComboBox = new JComboBox();
		gradeComboBox.setModel(new DefaultComboBoxModel(new String[] {"1\uD559\uB144", "2\uD559\uB144", "3\uD559\uB144", "4\uD559\uB144"}));
		gradeComboBox.setBounds(271, 10, 112, 26);
		contentPane.add(gradeComboBox);
		
		JComboBox collegeComboBox = new JComboBox();
		collegeComboBox.setModel(new DefaultComboBoxModel(new String[] {"\uC804\uCCB4", "\uAD50\uC591\uD559\uBD80", "\uB300\uD559", "\uBB38\uACFC\uB300\uD559", "\uC774\uACFC\uB300\uD559", "\uACF5\uACFC\uB300\uD559", "\uBC95\uACFC\uB300\uD559", "\uC815\uCE58\uD589\uC815\uB300\uD559", "\uC0C1\uACBD\uB300\uD559", "\uACBD\uC601\uB300\uD559", "\uC758\uACFC\uB300\uD559", "\uC57D\uD559\uB300\uD559", "\uC790\uC5F0\uC790\uC6D0\uB300\uD559", "\uC0DD\uBA85\uC751\uC6A9\uACFC\uD559\uB300\uD559", "\uC0DD\uD65C\uACFC\uD559\uB300\uD559", "\uC0AC\uBC94\uB300\uD559", "\uB514\uC790\uC778\uBBF8\uC220\uB300\uD559", "\uC74C\uC545\uB300\uD559", "\uC12C\uC720\uD328\uC158\uD559\uBD80", "\uC0DD\uBA85\uACF5\uD559\uBD80", "\uC911\uAD6D\uC5B8\uC5B4\uBB38\uD654\uD559\uBD80", "\uAC74\uCD95\uD559\uBD80", "\uAE30\uCD08\uAD50\uC721\uB300\uD559", "\uAD6D\uC81C\uD559\uBD80", "\uC5F0\uACC4\uC804\uACF5", "\uC57C\uAC04\uAC15\uC88C\uAC1C\uC124\uBD80"}));
		collegeComboBox.setBounds(12, 10, 118, 26);
		contentPane.add(collegeComboBox);
		
		JComboBox deptComboBox = new JComboBox();
		deptComboBox.setBounds(142, 10, 117, 26);
		contentPane.add(deptComboBox);
		
		lectureTextField = new JTextField();
		lectureTextField.setBounds(452, 11, 173, 26);
		contentPane.add(lectureTextField);
		lectureTextField.setColumns(10);
		
		JLabel label = new JLabel("\uACFC\uBAA9\uBA85 : ");
		label.setBounds(395, 16, 57, 15);
		contentPane.add(label);
		
		JButton btnNewButton = new JButton("\uC218\uAC15\uACFC\uBAA9 \uCC3E\uAE30");
		btnNewButton.setBounds(637, 10, 135, 26);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 46, 813, 206);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setColumnHeaderView(table);
		
		
	}
}
