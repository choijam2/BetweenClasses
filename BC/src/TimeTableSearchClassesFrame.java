import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
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
import javax.swing.table.TableRowSorter;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class TimeTableSearchClassesFrame extends JFrame {
	private JPanel contentPane;
	private JTextField txt_lname;
	private JTable table;

	TimeTableSearchClassesFrame(Connection con) {
		setResizable(false);
		setVisible(true);
		setTitle("SearchClasses");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1100, 400);
		contentPane = new JPanel();
		contentPane.setOpaque(true);
		contentPane.setBackground(Color.WHITE);
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox<String> gradeComboBox = new JComboBox<String>();
		gradeComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"��ü", "1�г�", "2�г�", "3�г�", "4�г�"}));
		gradeComboBox.setBounds(475, 10, 60, 26);
		gradeComboBox.setFont(new Font("ZESSTYPE �񰡿´� PT02", Font.BOLD, 18 ));
		contentPane.add(gradeComboBox);
		
		JComboBox<String> collegeComboBox = new JComboBox<String>();
		collegeComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"��ü", "�����к�", "����", "��������", "�̰�����", "��������", "��������", "��ġ��������", "������","�濵����","�ǰ�����","���д���","�ڿ��ڿ�����","����������д���","��Ȱ���д���","�������","�����ι̼�����","���Ǵ���","�����м��к�","������к�","�߱���ȭ�к�","�����к�","���ʱ�������","�����к�","��������","�߰����°�����"}));
		collegeComboBox.setBounds(22, 10, 150, 26);
		collegeComboBox.setFont(new Font("ZESSTYPE �񰡿´� PT02", Font.BOLD, 18 ));
		contentPane.add(collegeComboBox);
		
		JComboBox<String> deptComboBox = new JComboBox<String>();
		deptComboBox.setBounds(227, 10, 190, 26);
		deptComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"����"}));
		deptComboBox.setFont(new Font("ZESSTYPE �񰡿´� PT02", Font.BOLD, 18 ));
		collegeComboBox.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				switch(collegeComboBox.getSelectedIndex()){
				case 0:
					deptComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"����"}));
					break;
				case 1:
					deptComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"�ٽɱ���","��������","�ι�����","��ȸ����","�ڿ�����","����ü��","���蹮ȭ�Ϳܱ���"}));
					break;
				case 2:
					deptComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"����"}));
					break;
				case 3:
					deptComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"��������","������а�","�߱���ȭ�а�","�߱���ȭ�к�","�߾��߹���","�Ͼ��Ϲ��а�","�Ͼ��Ϲ���","������к�","������а�","�������","������ȭ�к�","�Ҿ�ҹ��а�","������а�","ö�а�","�����а�","�����а�","���а�","��ȭ�η��а�","�ɸ��а�","��ȸ�а�","��������а�"}));
					break;
				case 4:
					deptComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"�̰�����","���а�","����а�","�����а�","ȭ�л�ȭ�к�","ȭ�а�","������а�","�ڿ����к�"}));
					break;
				case 5:
					deptComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"��������","�Ǽ��ý��۰��а�","ȯ����а�","���ð��а�","�����к�","�ż�����к�","������а�","���ڰ��а�","��ǻ�Ͱ��а�","�����������Ű��а�","������Ű��а�","ȭ�а��к�","���ռ������а�","����޵������������а�"}));
					break;
				case 6:
					deptComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"��������","���к�"}));
					break;
				case 7:
					deptComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"��ġ��������","��ġ�ܱ��а�","�����а�","���������������а�","�����׺��������а�","���������а�","�����а�"}));
					break;
				case 8:
					deptComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"������","���������к�","�濵�к�","�濵�а�(���)","��������к�"}));
					break;
				case 9:
					deptComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"�濵����","�濵�а�","�濵�а�(���)","ȸ�輼���а�"}));
					break;
				case 10:
					deptComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"�ǰ�����","�ǿ���","���а�"}));
					break;
				case 11:
					deptComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"���д���","���к�"}));
					break;
				case 12:
					deptComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"�ڿ��ڿ�����","��ǰ����濵�а�","����������а�","�����а�","�긲�ڿ��а�","��ǰ���а�","�ܽĻ���а�"}));
					break;
				case 13:
					deptComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"����������д���","��ǰ�����ܽ��а�","����������а�","�긲�ڿ��������а�","��ǰ���а�","������а�","�ǻ�����а�","��ǰ�ڿ������а�","�ܽĻ���а�","�����а�","�긲�ڿ��а�"}));
					break;
				case 14:
					deptComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"��Ȱ���д���","�����ְ��а�","��ǰ�����а�","ü���к�","�Ƿ��м��а�"}));
					break;
				case 15:
					deptComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"�������","�����а�","�������","�������","�ѹ�������","���б�����","���Ʊ�����","Ư��ü��������"}));
					break;
				case 16:
					deptComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"�����ι̼�����","�̼��к�","�ð��������а�","����������а�","�ð�Ŀ�´����̼ǵ������а�","������ͷ��ǵ������а�","��Ȱ��ǰ�������а�","����Ͽ���������а�"}));
					break;
				case 17:
					deptComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"���Ǵ���","���ǰ�","���ǰ�","��ǰ�","�����к�"}));
					break;
				case 18:
					deptComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"�����м��к�"}));
					break;
				case 19:
					deptComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"������к�"}));
					break;
				case 20:
					deptComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"�߱���ȭ�к�"}));
					break;
				case 21:
					deptComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"�����к�"}));
					break;
				case 22:
					deptComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"���ʱ�������","õ�������к�","���������к�","�����а�","�ι����������к�","�ڿ����������к�"}));
					break;
				case 23:
					deptComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"�����к�"}));
					break;
				case 24:
					deptComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"����"}));
					break;
				case 25:
					deptComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"�߰����°�����","������а�(��)","������а�(��)","��ġ�ܱ��а�(��)","�����а�(��)","���������������а�(��)","�����׺��������а�(��)","���������к�(��)","�濵�к�(��)","��������к�(��)","�濵�а�(��)"}));
				}
			}	
		});
		contentPane.add(deptComboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 46, 1060, 316);
		contentPane.add(scrollPane);
		scrollPane.getViewport().setBackground(Color.WHITE);
		String title[] = {"������ȣ", "�г�", "�̼�����", "����", "����", "����", "���ǽð�", "�������", "�����а�", "���"};
		DefaultTableModel model = new DefaultTableModel(title, 0);
		table = new JTable(model);
		table.setAutoCreateRowSorter(true);
		TableRowSorter Tsorter = new TableRowSorter(table.getModel());
		table.setRowSorter(Tsorter);
		scrollPane.setViewportView(table);
		table.getTableHeader().setBackground(Color.WHITE);
		table.getTableHeader().setFont(new Font("ZESSTYPE �񰡿´� PT02", Font.BOLD, 18 ));
		table.getColumn("������ȣ").setPreferredWidth(30);
		table.getColumn("�г�").setPreferredWidth(5);
		table.getColumn("�̼�����").setPreferredWidth(30);
		table.getColumn("����").setPreferredWidth(130);
		table.getColumn("����").setPreferredWidth(5);
		table.getColumn("����").setPreferredWidth(50);
		table.getColumn("���ǽð�").setPreferredWidth(130);
		table.getColumn("�������").setPreferredWidth(80);
		table.getColumn("�����а�").setPreferredWidth(50);
		table.getColumn("���").setPreferredWidth(90);
		
		table.setFont(new Font("ZESSTYPE �񰡿´� PT02", Font.PLAIN, 18 ));
		txt_lname = new JTextField();
		txt_lname.setBounds(637, 11, 173, 26);
		contentPane.add(txt_lname);
		txt_lname.setColumns(10);
		
		JLabel label = new JLabel("����� : ");
		label.setBounds(577, 16, 48, 15);
		label.setFont(new Font("ZESSTYPE �񰡿´� PT02", Font.BOLD, 18 ));
		contentPane.add(label);
		
		JButton btn_FindClass = new JButton("�� ȸ");
		btn_FindClass.setFont(new Font("ZESSTYPE �񰡿´� PT02", Font.BOLD, 18 ));
		btn_FindClass.setBounds(847, 10, 135, 26);
		TimeTableSearchClassesFunc find = new TimeTableSearchClassesFunc(gradeComboBox, collegeComboBox, deptComboBox, txt_lname, con, table, model);
		btn_FindClass.addActionListener(find);
		contentPane.add(btn_FindClass);
		
	
	}
}
