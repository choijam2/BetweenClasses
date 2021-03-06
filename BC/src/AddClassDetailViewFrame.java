import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;

public class AddClassDetailViewFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	public AddClassDetailViewFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/logo.PNG"));
		setBounds(100, 100, 1118, 820);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.table = new JTable();
		this.table.setBounds(26, 24, 1033, 735);
		this.table.setEnabled(false);
		this.table.getTableHeader().setReorderingAllowed(false); // 이동 불가 
		this.table.getTableHeader().setResizingAllowed(false); // 크기 조절 불가
		this.table.setRowSelectionAllowed(false);
		this.table.getTableHeader().setFont(new Font("ZESSTYPE 비가온다 PT02", Font.BOLD, 18));
		this.table.setFont(new Font("ZESSTYPE 비가온다 PT02", Font.PLAIN, 25));		
		this.table.setDefaultRenderer(Object.class, new ResultFrame_Renderer());	
		this.table.setIntercellSpacing(new Dimension(1, 0));
		this.table.setRowHeight(28);		
		contentPane.add(this.table);

		JScrollPane scrollPane = new JScrollPane(this.table);
		scrollPane.setBounds(40, 28, 1033, 727);		
		contentPane.add(scrollPane);
		scrollPane.setViewportView(this.table);;
		this.table.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				if((e.getClickCount()==2)&&(e.getModifiers()==MouseEvent.BUTTON1_MASK)){
					dispose();
				}
			}
		});
		
	}
	void setTableModel(TableModel tableM){
		this.table.setModel(tableM);
	}
}
