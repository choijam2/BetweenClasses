import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

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

public class TimeTableSearchClassesFrame extends JFrame {

	private JPanel contentPane;
	private JTextField lectureTextField;
	private JTable table;

	TimeTableSearchClassesFrame(Connection con) {
		setResizable(false);
		setVisible(true);
		setTitle("SearchClasses");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 863, 301);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox gradeComboBox = new JComboBox();
		gradeComboBox.setModel(new DefaultComboBoxModel(new String[] {"1�г�", "2�г�", "3�г�", "4�г�"}));
		gradeComboBox.setBounds(389, 10, 60, 26);
		contentPane.add(gradeComboBox);
		
		JComboBox collegeComboBox = new JComboBox();
		collegeComboBox.setModel(new DefaultComboBoxModel(new String[] {"�����к�", "����", "�ð�����", "�̰�����", "��������", "��������", "��ġ��������", "������","�濵����","�ǰ�����","���д���","�ڿ��ڿ�����","����������д���","��Ȱ���д���","�������","�����ι̼�����","���Ǵ���","�����м��к�","������к�","�߱���ȭ�к�","�����к�","���ʱ�������","�����к�","��������","�߰����°�����"}));
		collegeComboBox.setBounds(22, 10, 150, 26);
		contentPane.add(collegeComboBox);
		
		JComboBox deptComboBox = new JComboBox();
		deptComboBox.setBounds(183, 10, 190, 26);
		collegeComboBox.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				switch(collegeComboBox.getSelectedIndex()){
				case 0:
					deptComboBox.setModel(new DefaultComboBoxModel(new String[] {"�ٽɱ���","��������","�ι�����","��ȸ����","�ڿ�����","����ü��","���蹮ȭ�Ϳܱ���"}));
					break;
				case 1:
					deptComboBox.setModel(new DefaultComboBoxModel(new String[] {"����"}));
					break;
				case 2:
					deptComboBox.setModel(new DefaultComboBoxModel(new String[] {"��������","������а�","�߱���ȭ�а�","�߱���ȭ�к�","�߾��߹���","�Ͼ��Ϲ��а�","�Ͼ��Ϲ���","������к�","������а�","�������","������ȭ�к�","�Ҿ�ҹ��а�","������а�","ö�а�","�����а�","�����а�","���а�","��ȭ�η��а�","�ɸ��а�","��ȸ�а�","��������а�"}));
					break;
				case 3:
					deptComboBox.setModel(new DefaultComboBoxModel(new String[] {"�̰�����","���а�","����а�","�����а�","ȭ�л�ȭ�к�","ȭ�а�","������а�","�ڿ����к�"}));
					break;
				case 4:
					deptComboBox.setModel(new DefaultComboBoxModel(new String[] {"��������","�Ǽ��ý��۰��а�","ȯ����а�","���ð��а�","�����к�","�ż�����к�","������а�","���ڰ��а�","��ǻ�Ͱ��а�","�����������Ű��а�","������Ű��а�","ȭ�а��к�","���ռ������а�","����޵������������а�"}));
					break;
				case 5:
					deptComboBox.setModel(new DefaultComboBoxModel(new String[] {"��������","���к�"}));
					break;
				case 6:
					deptComboBox.setModel(new DefaultComboBoxModel(new String[] {"��ġ��������","��ġ�ܱ��а�","�����а�","���������������а�","�����׺��������а�","���������а�","�����а�"}));
					break;
				case 7:
					deptComboBox.setModel(new DefaultComboBoxModel(new String[] {"������","���������к�","�濵�к�","�濵�а�(���)","��������к�"}));
					break;
				case 8:
					deptComboBox.setModel(new DefaultComboBoxModel(new String[] {"�濵����","�濵�а�","�濵�а�(���)","ȸ�輼���а�"}));
					break;
				case 9:
					deptComboBox.setModel(new DefaultComboBoxModel(new String[] {"�ǰ�����","�ǿ���","���а�"}));
					break;
				case 10:
					deptComboBox.setModel(new DefaultComboBoxModel(new String[] {"���д���","���к�"}));
					break;
				case 11:
					deptComboBox.setModel(new DefaultComboBoxModel(new String[] {"�ڿ��ڿ�����","��ǰ����濵�а�","����������а�","�����а�","�긲�ڿ��а�","��ǰ���а�","�ܽĻ���а�"}));
					break;
				case 12:
					deptComboBox.setModel(new DefaultComboBoxModel(new String[] {"����������д���","��ǰ�����ܽ��а�","����������а�","�긲�ڿ��������а�","��ǰ���а�","������а�","�ǻ�����а�","��ǰ�ڿ������а�","�ܽĻ���а�","�����а�","�긲�ڿ��а�"}));
					break;
				case 13:
					deptComboBox.setModel(new DefaultComboBoxModel(new String[] {"��Ȱ���д���","�����ְ��а�","��ǰ�����а�","ü���к�","�Ƿ��м��а�"}));
					break;
				case 14:
					deptComboBox.setModel(new DefaultComboBoxModel(new String[] {"�������","�����а�","�������","�������","�ѹ�������","���б�����","���Ʊ�����","Ư��ü��������"}));
					break;
				case 15:
					deptComboBox.setModel(new DefaultComboBoxModel(new String[] {"�����ι̼�����","�̼��к�","�ð��������а�","����������а�","�ð�Ŀ�´����̼ǵ������а�","������ͷ��ǵ������а�","��Ȱ��ǰ�������а�","����Ͽ���������а�"}));
					break;
				case 16:
					deptComboBox.setModel(new DefaultComboBoxModel(new String[] {"���Ǵ���","���ǰ�","���ǰ�","��ǰ�","�����к�"}));
					break;
				case 17:
					deptComboBox.setModel(new DefaultComboBoxModel(new String[] {"�����м��к�"}));
					break;
				case 18:
					deptComboBox.setModel(new DefaultComboBoxModel(new String[] {"������к�"}));
					break;
				case 19:
					deptComboBox.setModel(new DefaultComboBoxModel(new String[] {"�߱���ȭ�к�"}));
					break;
				case 20:
					deptComboBox.setModel(new DefaultComboBoxModel(new String[] {"�����к�"}));
					break;
				case 21:
					deptComboBox.setModel(new DefaultComboBoxModel(new String[] {"���ʱ�������","õ�������к�","���������к�","�����а�","�ι����������к�","�ڿ����������к�"}));
					break;
				case 22:
					deptComboBox.setModel(new DefaultComboBoxModel(new String[] {"�����к�"}));
					break;
				case 23:
					deptComboBox.setModel(new DefaultComboBoxModel(new String[] {"����"}));
					break;
				case 24:
					deptComboBox.setModel(new DefaultComboBoxModel(new String[] {"�߰����°�����","������а�(��)","������а�(��)","��ġ�ܱ��а�(��)","�����а�(��)","���������������а�(��)","�����׺��������а�(��)","���������к�(��)","�濵�к�(��)","��������к�(��)","�濵�а�(��)"}));
					break;

				}
			}	
		});
		contentPane.add(deptComboBox);
		
		lectureTextField = new JTextField();
		lectureTextField.setBounds(515, 11, 173, 26);
		contentPane.add(lectureTextField);
		lectureTextField.setColumns(10);
		
		JLabel label = new JLabel("\uACFC\uBAA9\uBA85 : ");
		label.setBounds(461, 16, 48, 15);
		contentPane.add(label);
		
		JButton btn_FindClass = new JButton("\uC218\uAC15\uACFC\uBAA9 \uCC3E\uAE30");
		btn_FindClass.setBounds(700, 10, 135, 26);
		contentPane.add(btn_FindClass);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 46, 813, 206);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setColumnHeaderView(table);
		
		
	}
}
