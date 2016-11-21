import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class RandomRecommend implements ActionListener{
	int[][] BCtable = { { 0, 0, 0, 0, 0}, 
			{ 0, 0, 0, 0, 0},{ 0, 0, 0, 0, 0},{ 0, 0, 0, 0, 0},{ 0, 0, 0, 0, 0},{ 0, 0, 0, 0, 0},
			{ 0, 0, 0, 0, 0},{ 0, 0, 0, 0, 0},{ 0, 0, 0, 0, 0},{ 0, 0, 0, 0, 0},{ 0, 0, 0, 0, 0},
			{ 0, 0, 0, 0, 0},{ 0, 0, 0, 0, 0},{ 0, 0, 0, 0, 0},{ 0, 0, 0, 0, 0},{ 0, 0, 0, 0, 0},
			{ 0, 0, 0, 0, 0},{ 0, 0, 0, 0, 0},{ 0, 0, 0, 0, 0},{ 0, 0, 0, 0, 0},{ 0, 0, 0, 0, 0},
			{ 0, 0, 0, 0, 0},{ 0, 0, 0, 0, 0},{ 0, 0, 0, 0, 0},{ 0, 0, 0, 0, 0} };
	public RandomRecommend(int[][] BC6table) {
	
		for(int i = 0;i<25;i++)
		{
			for(int j=0;j<5;j++)
				BCtable[i][j] = BC6table[i][j];
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String [] day = {"��","ȭ","��","��","��"};
		String [] time = {"9:00", "9:30","10:00" ,"10:30", "11:00", 
				"11:30", "12:00", "12:30", "13:00", "13:30",
				"14:00", "14:30", "15:00", "15:30", "16:00", 
				"16:30", "17:00", "17:30", "18:00", "18:30", 
				"19:00", "19:30", "20:00", "20:30", "21:00","  "}; 
		BCTime bct = new BCTime();
		ArrayList <BCTime> bclist = new ArrayList<BCTime>();
		int ck = 0;
		while(ck !=-1||ck<5){			//�����������ϴ� ����� ���
			for(int i=0;i<5;i++){		// ����
				for(int j=0;j<25;j++){	// �ð�
					if(BCtable[j][i] == ck){	
						if(bct.notmem==-1){		//��� ���۽ð� ���� ����
							bct.Setnot(ck);
							bct.Setstart(j);
							bct.Setday(i);
						}
						else if(bct.findex!=-1&&j==24){
							bct.Setfinsh(j);
							bclist.add(bct);
							bct = new BCTime();
						}
						else
							bct.Setfinsh(j);	//������ �ð� ����
						}
					else if(bct.notmem!=-1){	//���۽ð��� �ִµ� ����� ���� �������
						if(bct.findex!=-1){		//1�ð� �̻��ϰ�� ����
							bclist.add(bct);
							bct = new BCTime();
						}
						bct.Reset();			//1�ð� �̸��ϰ�� �ʱ�ȭ
					}
				}
			}
			if(bclist.size()!=0)				//����� ���� ������� Ż��
				break;
			ck++;								//��� ����
		}
		if(ck==5){
			JOptionPane.showMessageDialog(null, "�����ð��� �������� �ʽ��ϴ�.");		
		}
		else{
			int rand = (int)(Math.random()*(bclist.size()-1));
			BCTime slectbc;
			slectbc = bclist.get(rand);
			String mgtime = time[slectbc.sindex]+" ~ "+time[slectbc.findex+1];
			RandomSelcetedFrame rsf = new RandomSelcetedFrame(day[slectbc.day],mgtime);
		}
	}
	
}
class BCTime{
	int notmem;
	int sindex;
	int findex;
	int day;
	BCTime(){
		notmem = -1;
		sindex = -1;
		findex = -1;
		day = -1;
	}
	void Setnot(int notmem){
		this.notmem = notmem;
	}
	void Setstart(int sindex){
		this.sindex = sindex;
	}
	void Setfinsh(int findex){
		this.findex = findex;
	}
	void Setday(int day){
		this.day = day;
	}
	void Reset(){
		notmem = -1;
		sindex = -1;
		findex = -1;
		day = -1;
	}
}
