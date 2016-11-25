import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelcetMaster extends JFrame {
	private JPanel contentPane;
	private final ButtonGroup set = new ButtonGroup();
	public SelcetMaster(Connection con, ArrayList<String> ck) {
		String[] sid = new String[ck.size()];
		int k =0;
		for(int i=0;i<ck.size();i++)
		{
			if(ck.get(i)=="-1")
				continue;
			else{
				sid[k] = ck.get(i);
				k++;
			}
		}
		setResizable(false);
		setSize(363, 275);
		setVisible(true);
		setTitle("Selcet Master");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(200, 400, 320, 250);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		getContentPane().setLayout(null);
		
		JLabel label_Quest = new JLabel("\uC870\uC7A5\uC744 \uC120\uD0DD\uD558\uC138\uC694");
		label_Quest.setHorizontalAlignment(SwingConstants.CENTER);
		label_Quest.setFont(new Font("ZESSTYPE 비가온다 PT02", Font.PLAIN, 30));
		label_Quest.setBounds(0, 10, 314, 50);
		contentPane.add(label_Quest);
		
		JCheckBox non = new JCheckBox("( 없 음 )");
		set.add(non);
		non.setBackground(Color.WHITE);
		non.setBounds(25, 70, 115, 23);
		non.setFont(new Font("ZESSTYPE 비가온다 PT02", Font.PLAIN, 20));
		contentPane.add(non);
		
		JCheckBox user = new JCheckBox(sid[0]);
		set.add(user);
		user.setBackground(Color.WHITE);
		user.setBounds(163, 70, 115, 23);
		user.setFont(new Font("ZESSTYPE 비가온다 PT02", Font.PLAIN, 20));
		contentPane.add(user);
		if(sid[1]!=null){
			JCheckBox std1 = new JCheckBox(sid[1]);
			set.add(std1);
			std1.setBackground(Color.WHITE);
			std1.setBounds(25, 110, 115, 23);
			std1.setFont(new Font("ZESSTYPE 비가온다 PT02", Font.PLAIN, 20));
			contentPane.add(std1);
		}
		if(sid[2]!=null){
			JCheckBox std2 = new JCheckBox(sid[2]);
			set.add(std2);
			std2.setBackground(Color.WHITE);
			std2.setBounds(163, 110, 115, 23);
			std2.setFont(new Font("ZESSTYPE 비가온다 PT02", Font.PLAIN, 20));
			contentPane.add(std2);
		
		}
		if(sid[3]!=null){
			JCheckBox std3 = new JCheckBox(sid[3]);
			set.add(std3);
			std3.setBackground(Color.WHITE);
			std3.setBounds(25, 150, 115, 23);
			std3.setFont(new Font("ZESSTYPE 비가온다 PT02", Font.PLAIN, 20));
			contentPane.add(std3);
		}
		if(sid[4]!=null){
			JCheckBox std4 = new JCheckBox(sid[4]);
			set.add(std4);
			std4.setBackground(Color.WHITE);
			std4.setFont(new Font("ZESSTYPE 비가온다 PT02", Font.PLAIN, 20));
			std4.setBounds(163, 150, 115, 23);
			contentPane.add(std4);
		}
		
		JButton btn = new JButton("\uD655\uC778");
		btn.setFont(new Font("Gulim", Font.PLAIN, 12));
		btn.setBackground(Color.WHITE);
		btn.setFont(new Font("ZESSTYPE 비가온다 PT02", Font.PLAIN, 20));
		btn.setBounds(110, 188, 97, 23);
		contentPane.add(btn);
		btn.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e){
				 String sd = null;
				 Enumeration<AbstractButton> enums = set.getElements();
				 while(enums.hasMoreElements()) {  
				     AbstractButton ab = enums.nextElement();   
				     JCheckBox jb = (JCheckBox)ab;        
				     if(jb.isSelected()){                        
				          sd = jb.getText();
				          if(sd =="( 없 음 )"){
				        	  sd = "0";
				          }
				     }
				 }
				 try {
					 if(sd==null){
						 JOptionPane.showMessageDialog(null, "조장을선택해주세요");
					 }
					 else if(sd=="0"){
						 new ResultFrame(con,ck.get(0),ck.get(1),ck.get(2),ck.get(3),ck.get(4));
					 } 
					 else{
						 StudentMaster st = new StudentMaster(sd);
						 new ResultFrame(con,ck.get(0),ck.get(1),ck.get(2),ck.get(3),ck.get(4));
					 }
				 }
				 catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
				}
				
				 
			 }
		});
		
		
		
		
	}
	
}
