//import java.awt.BorderLayout;
//import java.awt.EventQueue;
//
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
//import java.awt.Color;
//import javax.swing.JButton;
//import java.awt.CardLayout;
//import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;
//import javax.swing.JTable;
//import javax.swing.table.DefaultTableCellRenderer;
//import javax.swing.table.DefaultTableModel;
//import javax.swing.GroupLayout;
//import javax.swing.ImageIcon;
//import javax.swing.GroupLayout.Alignment;
//import javax.swing.JScrollPane;
//import java.awt.Font;
//import java.awt.Graphics;
//
//import javax.swing.LayoutStyle.ComponentPlacement;
//import javax.swing.JTextField;
//import javax.swing.border.BevelBorder;
//import javax.swing.border.CompoundBorder;
//import javax.swing.border.LineBorder;
//
//public class AddClassFrame extends JFrame {
//
//   private JPanel contentPane;
//   private JTable table;
//   private JTextField txt_ClassNum;
//
//   /**
//    * Launch the application.
//    */
//   public static void main(String[] args) {
//      EventQueue.invokeLater(new Runnable() {
//         public void run() {
//            try {
//               AddClassFrame frame = new AddClassFrame();
//               frame.setVisible(true);
//            } catch (Exception e) {
//               e.printStackTrace();
//            }
//         }
//      });
//   }
//
//   /**
//    * Create the frame.
//    */
//   public AddClassFrame() {
//      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//      setBounds(100, 100, 1077, 967);
//      contentPane = new JPanel();
//      contentPane.setBackground(Color.WHITE);
//      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//      setContentPane(contentPane);
//      contentPane.setLayout(null);
//
//      
//      JPanel ParentPanel = new JPanel();
//      ParentPanel.setBounds(0, 115, 1055, 796);
//      contentPane.add(ParentPanel);
//      ParentPanel.setLayout(new CardLayout(0, 0));
//      
//      JPanel panel_1 = new JPanel();
//      panel_1.setBorder(new LineBorder(Color.BLACK, 2));
//      panel_1.setBackground(Color.WHITE);
//      ParentPanel.add(panel_1, "name_798298334667093");
//      
//      JScrollPane scrollPane = new JScrollPane();
//      scrollPane.setBounds(40, 28, 746, 727);
//      
//      JPanel Pnl_ClassNum = new JPanel(){
//         //판넬에 이미지 추가
//         ImageIcon mainicon = new ImageIcon("img/AddClass.png");
//
//         public void paintComponent(Graphics g) {
//            g.drawImage(mainicon.getImage(), 0, 0, null);
//            setOpaque(false);
//            super.paintComponent(g);
//         }
//      };
//      Pnl_ClassNum.setBounds(860, 123, 164, 80);
//      
//      txt_ClassNum = new JTextField();
//      txt_ClassNum.setBounds(860, 206, 164, 40);
//      txt_ClassNum.setColumns(10);
//      
//      JPanel pnl_add = new JPanel(){
//         //판넬에 이미지 추가
//         ImageIcon mainicon = new ImageIcon("img/add.png");
//
//         public void paintComponent(Graphics g) {
//            g.drawImage(mainicon.getImage(), 0, 0, null);
//            setOpaque(false);
//            super.paintComponent(g);
//         }
//      };
//      pnl_add.setBounds(884, 306, 102, 47);
//      
//      JPanel pnl_save = new JPanel(){
//         //판넬에 이미지 추가
//         ImageIcon mainicon = new ImageIcon("img/save.png");
//
//         public void paintComponent(Graphics g) {
//            g.drawImage(mainicon.getImage(), 0, 0, null);
//            setOpaque(false);
//            super.paintComponent(g);
//         }
//      };
//      pnl_save.setBounds(884, 368, 105, 47);
//      
//      JPanel pnl_del = new JPanel(){
//         //판넬에 이미지 추가
//         ImageIcon mainicon = new ImageIcon("img/del.png");
//
//         public void paintComponent(Graphics g) {
//            g.drawImage(mainicon.getImage(), 0, 0, null);
//            setOpaque(false);
//            super.paintComponent(g);
//         }
//      };
//      pnl_del.setBounds(884, 430, 105, 55);
//      
//            JButton btn_Del = new JButton();
//            pnl_del.add(btn_Del);
//            btn_Del.setBorderPainted(false);    //투명 버튼
//            btn_Del.setFocusPainted(false);      //투명 버튼
//            btn_Del.setContentAreaFilled(false);
//      
//      JButton btn_Save = new JButton();
//      pnl_save.add(btn_Save);
//      btn_Save.setBorderPainted(false);    //투명 버튼
//      btn_Save.setFocusPainted(false);      //투명 버튼
//      btn_Save.setContentAreaFilled(false);
//      
//      JButton btn_Add = new JButton();
//      pnl_add.add(btn_Add);
//      btn_Add.addActionListener(new ActionListener() {
//         public void actionPerformed(ActionEvent e) {
//         }
//      });
//      btn_Add.setBorderPainted(false);    //투명 버튼
//      btn_Add.setFocusPainted(false);      //투명 버튼
//      btn_Add.setContentAreaFilled(false);
//      
//      
//      //셀 글자 정렬
//      DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
//      celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
//      
//      table = new JTable();
//      
//      table.getTableHeader().setFont(new Font("ZESSTYPE 비가온다 PT02", Font.BOLD, 24));
//      table.setFont(new Font("ZESSTYPE 비가온다 PT02", Font.PLAIN, 24));
//      table.setBounds(37, 35, 402, 600);
//      table.setRowHeight(53);
//      table.getTableHeader().setReorderingAllowed(false);//column 헤더수정불가
//      table.getTableHeader().setResizingAllowed(false);//column 헤더길이조절불가
//      table.setModel(new DefaultTableModel(
//         new Object[][] {
//            {"9:00", null, null, null, null, null, null},
//            {"10:00", null, null, null, null, null, null},
//            {"11:00", null, null, null, null, null, null},
//            {"12:00", null, null, null, null, null, null},
//            {"13:00", null, null, null, null, null, null},
//            {"14:00", null, null, null, null, null, null},
//            {"15:00", null, null, null, null, null, null},
//            {"16:00", null, null, null, null, null, null},
//            {"17:00", null, null, null, null, null, null},
//            {"18:00", null, null, null, null, null, null},
//            {"19:00", null, null, null, null, null, null},
//            {"20:00", null, null, null, null, null, null},
//            {"21:00", null, null, null, null, null, null},
//         },
//         new String[] {
//            "Time", "월", "화", "수", "목", "금", "토"
//         }
//      ){            
//         private static final long serialVersionUID = 1L;
//
//            public boolean isCellEditable(int row, int column) {// cell 수정 불가 설정
//               return false;
//            }
//         
//      });
//      
//      //가운데 정렬
//      table.getColumn("Time").setCellRenderer(celAlignCenter);
//      panel_1.setLayout(null);
//      
//   
//      scrollPane.setViewportView(table);
//      panel_1.add(scrollPane);
//      panel_1.add(txt_ClassNum);
//      panel_1.add(Pnl_ClassNum);
//      panel_1.add(pnl_add);
//      panel_1.add(pnl_del);
//      panel_1.add(pnl_save);
//      
//      
//      JPanel panel_2 = new JPanel();
//      panel_2.setBackground(Color.orange);
//      ParentPanel.add(panel_2, "name_798285310498133");
//      
//      
//      
//      JButton btnNewButton = new JButton();
//      btnNewButton.setBorderPainted(false);    //투명 버튼
//      btnNewButton.setFocusPainted(false);      //투명 버튼
//      btnNewButton.setContentAreaFilled(false); //투명 버튼
//      btnNewButton.setBounds(17, 53, 209, 61);
//      contentPane.add(btnNewButton);
//      
//
//      JButton btnNewButton_1 = new JButton();
//      btnNewButton_1.setBorderPainted(false);    //투명 버튼
//      btnNewButton_1.setFocusPainted(false);      //투명 버튼
//      btnNewButton_1.setContentAreaFilled(false); //투명 버
//      btnNewButton_1.setBounds(215, 53, 201, 61);
//      contentPane.add(btnNewButton_1);
//      
//      JPanel panel = new JPanel();
//      panel.setBounds(0, 146, 1055, 765);
//      contentPane.add(panel);
//      panel.setBackground(Color.WHITE);
//      panel.setLayout(null);
//      
//      //모의 시간표 버튼
//      JPanel pnl_TimeTableTemp = new JPanel(){
//         //판넬에 이미지 추가
//         ImageIcon mainicon = new ImageIcon("img/timetable.png");
//
//         public void paintComponent(Graphics g) {
//            g.drawImage(mainicon.getImage(), 0, 0, null);
//            setOpaque(false);
//            super.paintComponent(g);
//         }
//      };
//      pnl_TimeTableTemp.setBounds(17, 53, 209, 61);
//      contentPane.add(pnl_TimeTableTemp);
//      
//      JPanel pnl_BetweenTemp = new JPanel(){
//         //판넬에 이미지 추가
//         ImageIcon mainicon = new ImageIcon("img/between.png");
//
//         public void paintComponent(Graphics g) {
//            g.drawImage(mainicon.getImage(), 0, 0, null);
//            setOpaque(false);
//            super.paintComponent(g);
//         }
//      };
//      pnl_BetweenTemp.setBounds(215, 53, 201, 61);
//      contentPane.add(pnl_BetweenTemp);
//      
//      
//      
//      
//      
//      btnNewButton_1.addActionListener(new ActionListener() {
//         public void actionPerformed(ActionEvent e) {
//            ParentPanel.removeAll();
//            ParentPanel.add(panel_2);
//            ParentPanel.repaint();
//            ParentPanel.revalidate();
//         }
//      });
//      btnNewButton.addActionListener(new ActionListener() {
//         public void actionPerformed(ActionEvent e) {
//            ParentPanel.removeAll();
//            ParentPanel.add(panel_1);
//            ParentPanel.repaint();
//            ParentPanel.revalidate();
//         }
//      });
//      
//   }
//}
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class AddClassFrame extends JFrame {

   private JPanel contentPane;
   private JTable table;
   private JTextField txt_ClassNum;
   private JTable table_1;
   private JTable table_2;
   private JTable table_3;
   private JTable table_4;
   private JTable table_5;
   private JTable table_6;

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               AddClassFrame frame = new AddClassFrame();
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
   public AddClassFrame() {
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 1448, 976);
      contentPane = new JPanel();
      contentPane.setBackground(Color.WHITE);
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);

      
      JPanel ParentPanel = new JPanel();
      ParentPanel.setBounds(0, 115, 1426, 796);
      contentPane.add(ParentPanel);
      ParentPanel.setLayout(new CardLayout(0, 0));
      
      JPanel panel_1 = new JPanel();
      panel_1.setBorder(new LineBorder(Color.BLACK, 2));
      panel_1.setBackground(Color.WHITE);
      ParentPanel.add(panel_1, "name_798298334667093");
      
      JScrollPane scrollPane = new JScrollPane();
      scrollPane.setBounds(40, 28, 746, 727);
      
      JPanel Pnl_ClassNum = new JPanel(){
         //판넬에 이미지 추가
         ImageIcon mainicon = new ImageIcon("img/AddClass.png");

         public void paintComponent(Graphics g) {
            g.drawImage(mainicon.getImage(), 0, 0, null);
            setOpaque(false);
            super.paintComponent(g);
         }
      };
      Pnl_ClassNum.setBounds(860, 123, 164, 80);
      
      txt_ClassNum = new JTextField();
      txt_ClassNum.setBounds(860, 206, 164, 40);
      txt_ClassNum.setColumns(10);
      
      JPanel pnl_add = new JPanel(){
         //판넬에 이미지 추가
         ImageIcon mainicon = new ImageIcon("img/add.png");

         public void paintComponent(Graphics g) {
            g.drawImage(mainicon.getImage(), 0, 0, null);
            setOpaque(false);
            super.paintComponent(g);
         }
      };
      pnl_add.setBounds(884, 306, 102, 47);
      
      JPanel pnl_save = new JPanel(){
         //판넬에 이미지 추가
         ImageIcon mainicon = new ImageIcon("img/save.png");

         public void paintComponent(Graphics g) {
            g.drawImage(mainicon.getImage(), 0, 0, null);
            setOpaque(false);
            super.paintComponent(g);
         }
      };
      pnl_save.setBounds(884, 427, 105, 47);
      
      JPanel pnl_del = new JPanel(){
         //판넬에 이미지 추가
         ImageIcon mainicon = new ImageIcon("img/del.png");

         public void paintComponent(Graphics g) {
            g.drawImage(mainicon.getImage(), 0, 0, null);
            setOpaque(false);
            super.paintComponent(g);
         }
      };
      pnl_del.setBounds(884, 368, 105, 55);
      
      JButton btn_Del = new JButton();
      pnl_del.add(btn_Del);
      btn_Del.setBorderPainted(false);    //투명 버튼
      btn_Del.setFocusPainted(false);      //투명 버튼
      btn_Del.setContentAreaFilled(false);
      
      JButton btn_Save = new JButton();
      pnl_save.add(btn_Save);
      btn_Save.setBorderPainted(false);    //투명 버튼
      btn_Save.setFocusPainted(false);      //투명 버튼
      btn_Save.setContentAreaFilled(false);
      
      JButton btn_Add = new JButton();
      pnl_add.add(btn_Add);
      btn_Add.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
         }
      });
      btn_Add.setBorderPainted(false);    //투명 버튼
      btn_Add.setFocusPainted(false);      //투명 버튼
      btn_Add.setContentAreaFilled(false);
      
      
      //셀 글자 정렬
      DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
      celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
      
      table = new JTable();
      
      table.getTableHeader().setFont(new Font("ZESSTYPE 비가온다 PT02", Font.BOLD, 24));
      table.setFont(new Font("ZESSTYPE 비가온다 PT02", Font.PLAIN, 24));
      table.setBounds(37, 35, 402, 600);
      table.setRowHeight(53);
      table.setModel(new DefaultTableModel(
         new Object[][] {
            {"9:00", null, null, null, null, null, null},
            {"10:00", null, null, null, null, null, null},
            {"11:00", null, null, null, null, null, null},
            {"12:00", null, null, null, null, null, null},
            {"13:00", null, null, null, null, null, null},
            {"14:00", null, null, null, null, null, null},
            {"15:00", null, null, null, null, null, null},
            {"16:00", null, null, null, null, null, null},
            {"17:00", null, null, null, null, null, null},
            {"18:00", null, null, null, null, null, null},
            {"19:00", null, null, null, null, null, null},
            {"20:00", null, null, null, null, null, null},
            {"21:00", null, null, null, null, null, null},
         },
         new String[] {
            "Time", "월", "화", "수", "목", "금", "토"
         }
      ));
      
      //가운데 정렬
      table.getColumn("Time").setCellRenderer(celAlignCenter);
      panel_1.setLayout(null);
      
   
      scrollPane.setViewportView(table);
      panel_1.add(scrollPane);
      panel_1.add(txt_ClassNum);
      panel_1.add(Pnl_ClassNum);
      panel_1.add(pnl_add);
      panel_1.add(pnl_del);
      panel_1.add(pnl_save);
      
      
      JPanel panel_2 = new JPanel();
      panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
      panel_2.setBackground(Color.WHITE);
      ParentPanel.add(panel_2, "name_798285310498133");
      
      JScrollPane scrolltime1 = new JScrollPane();
      scrolltime1.setBounds(29, 61, 320, 280);
      
      JScrollPane scrollPane_2 = new JScrollPane();
      scrollPane_2.setBounds(367, 61, 320, 280);
      
      JScrollPane scrollPane_3 = new JScrollPane();
      scrollPane_3.setBounds(705, 61, 320, 280);
      
      JScrollPane scrollPane_4 = new JScrollPane();
      scrollPane_4.setBounds(29, 499, 320, 280);
      
      JScrollPane scrollPane_5 = new JScrollPane();
      scrollPane_5.setBounds(1026, 428, 2, 2);
      
      JScrollPane scrollPane_6 = new JScrollPane();
      scrollPane_6.setBounds(366, 499, 320, 280);
      
      JScrollPane scrollPane_7 = new JScrollPane();
      scrollPane_7.setBounds(704, 499, 320, 280);
      
      JPanel pnl_TempFindBC = new JPanel(){
         //판넬에 이미지 추가
         ImageIcon mainicon = new ImageIcon("img/find.png");

         public void paintComponent(Graphics g) {
            g.drawImage(mainicon.getImage(), 0, 0, null);
            setOpaque(false);
            super.paintComponent(g);
         }
      };
      pnl_TempFindBC.setBounds(1140, 622, 151, 47);
      pnl_TempFindBC.setLayout(null);
      
      
      //공강찾기용 버튼
      JButton btn_FindBetweenClass = new JButton();
      btn_FindBetweenClass.setBounds(0, 15, 125, 29);
      btn_FindBetweenClass.setBorderPainted(false);    //투명 버튼
      btn_FindBetweenClass.setFocusPainted(false);      //투명 버튼
      btn_FindBetweenClass.setContentAreaFilled(false);
      pnl_TempFindBC.add(btn_FindBetweenClass);
      
      table_6 = new JTable();
      table_6.getTableHeader().setFont(new Font("ZESSTYPE 비가온다 PT02", Font.BOLD, 18));
      table_6.setFont(new Font("ZESSTYPE 비가온다 PT02", Font.PLAIN, 18));
      table_6.setRowHeight(19);
      table_6.setModel(new DefaultTableModel(
            new Object[][] {
               {"9:00", null, null, null, null, null, null},
               {"10:00", null, null, null, null, null, null},
               {"11:00", null, null, null, null, null, null},
               {"12:00", null, null, null, null, null, null},
               {"13:00", null, null, null, null, null, null},
               {"14:00", null, null, null, null, null, null},
               {"15:00", null, null, null, null, null, null},
               {"16:00", null, null, null, null, null, null},
               {"17:00", null, null, null, null, null, null},
               {"18:00", null, null, null, null, null, null},
               {"19:00", null, null, null, null, null, null},
               {"20:00", null, null, null, null, null, null},
               {"21:00", null, null, null, null, null, null},
            },
            new String[] {
               "Time", "월", "화", "수", "목", "금", "토"
            }
      ));
      scrollPane_7.setViewportView(table_6);
      
      table_5 = new JTable();
      table_5.setModel(new DefaultTableModel(
            new Object[][] {
               {"9:00", null, null, null, null, null, null},
               {"10:00", null, null, null, null, null, null},
               {"11:00", null, null, null, null, null, null},
               {"12:00", null, null, null, null, null, null},
               {"13:00", null, null, null, null, null, null},
               {"14:00", null, null, null, null, null, null},
               {"15:00", null, null, null, null, null, null},
               {"16:00", null, null, null, null, null, null},
               {"17:00", null, null, null, null, null, null},
               {"18:00", null, null, null, null, null, null},
               {"19:00", null, null, null, null, null, null},
               {"20:00", null, null, null, null, null, null},
               {"21:00", null, null, null, null, null, null},
            },
            new String[] {
               "Time", "월", "화", "수", "목", "금", "토"
            }
      ));
      scrollPane_6.setViewportView(table_5);
      
      table_4 = new JTable();
      table_4.setModel(new DefaultTableModel(
            new Object[][] {
               {"9:00", null, null, null, null, null, null},
               {"10:00", null, null, null, null, null, null},
               {"11:00", null, null, null, null, null, null},
               {"12:00", null, null, null, null, null, null},
               {"13:00", null, null, null, null, null, null},
               {"14:00", null, null, null, null, null, null},
               {"15:00", null, null, null, null, null, null},
               {"16:00", null, null, null, null, null, null},
               {"17:00", null, null, null, null, null, null},
               {"18:00", null, null, null, null, null, null},
               {"19:00", null, null, null, null, null, null},
               {"20:00", null, null, null, null, null, null},
               {"21:00", null, null, null, null, null, null},
            },
            new String[] {
               "Time", "월", "화", "수", "목", "금", "토"
            }
      ));
      scrollPane_4.setViewportView(table_4);
      
      table_3 = new JTable();
      table_3.setModel(new DefaultTableModel(
            new Object[][] {
               {"9:00", null, null, null, null, null, null},
               {"10:00", null, null, null, null, null, null},
               {"11:00", null, null, null, null, null, null},
               {"12:00", null, null, null, null, null, null},
               {"13:00", null, null, null, null, null, null},
               {"14:00", null, null, null, null, null, null},
               {"15:00", null, null, null, null, null, null},
               {"16:00", null, null, null, null, null, null},
               {"17:00", null, null, null, null, null, null},
               {"18:00", null, null, null, null, null, null},
               {"19:00", null, null, null, null, null, null},
               {"20:00", null, null, null, null, null, null},
               {"21:00", null, null, null, null, null, null},
            },
            new String[] {
               "Time", "월", "화", "수", "목", "금", "토"
            }
      ));
      scrollPane_3.setViewportView(table_3);
      
      table_2 = new JTable();
      table_2.setModel(new DefaultTableModel(
            new Object[][] {
               {"9:00", null, null, null, null, null, null},
               {"10:00", null, null, null, null, null, null},
               {"11:00", null, null, null, null, null, null},
               {"12:00", null, null, null, null, null, null},
               {"13:00", null, null, null, null, null, null},
               {"14:00", null, null, null, null, null, null},
               {"15:00", null, null, null, null, null, null},
               {"16:00", null, null, null, null, null, null},
               {"17:00", null, null, null, null, null, null},
               {"18:00", null, null, null, null, null, null},
               {"19:00", null, null, null, null, null, null},
               {"20:00", null, null, null, null, null, null},
               {"21:00", null, null, null, null, null, null},
            },
            new String[] {
               "Time", "월", "화", "수", "목", "금", "토"
            }
      ));
      scrollPane_2.setViewportView(table_2);
      
      table_1 = new JTable();
      table_1.setModel(new DefaultTableModel(
            new Object[][] {
               {"9:00", null, null, null, null, null, null},
               {"10:00", null, null, null, null, null, null},
               {"11:00", null, null, null, null, null, null},
               {"12:00", null, null, null, null, null, null},
               {"13:00", null, null, null, null, null, null},
               {"14:00", null, null, null, null, null, null},
               {"15:00", null, null, null, null, null, null},
               {"16:00", null, null, null, null, null, null},
               {"17:00", null, null, null, null, null, null},
               {"18:00", null, null, null, null, null, null},
               {"19:00", null, null, null, null, null, null},
               {"20:00", null, null, null, null, null, null},
               {"21:00", null, null, null, null, null, null},
            },
            new String[] {
               "Time", "월", "화", "수", "목", "금", "토"
            }
      ));
      scrolltime1.setViewportView(table_1);
      
      //------------------------------
      //교수 부분 판넬
      JPanel Pfpanel = new JPanel();
      Pfpanel.setBounds(1055, 59, 300, 180);
      Pfpanel.setBackground(new Color(255, 0, 0, 0));
      TitledBorder pfborder = new TitledBorder("교수");
      pfborder.setTitleFont(new Font("ZESSTYPE 비가온다 PT02", Font.BOLD, 30));
      Pfpanel.setBorder(pfborder);
      panel_2.add(Pfpanel);
      Pfpanel.setLayout(null);
      
      JButton btn_StudentAdd = new JButton();
      btn_StudentAdd.setBorderPainted(false);    //투명 버튼
      btn_StudentAdd.setFocusPainted(false);      //투명 버튼
      btn_StudentAdd.setContentAreaFilled(false);
      btn_StudentAdd.setBounds(65, 120, 77, 29);
      Pfpanel.add(btn_StudentAdd);
      
      JButton btn_StudentDel = new JButton();
      btn_StudentDel.setBorderPainted(false);    //투명 버튼
      btn_StudentDel.setFocusPainted(false);      //투명 버튼
      btn_StudentDel.setContentAreaFilled(false);
      btn_StudentDel.setBounds(187, 120, 96, 29);
      Pfpanel.add(btn_StudentDel);
      
      //학생 부분 판넬
      JPanel STpanel = new JPanel();
      STpanel.setBounds(1055, 350, 300, 180);
      STpanel.setBackground(new Color(255, 0, 0, 0));
      TitledBorder STborder = new TitledBorder("학생");
      STborder.setTitleFont(new Font("ZESSTYPE 비가온다 PT02", Font.BOLD, 30));
      STpanel.setBorder(STborder);
      panel_2.add(STpanel);
      
//      JPanel FindBetween = new JPanel(){
//         //판넬에 이미지 추가
//         ImageIcon mainicon = new ImageIcon("img/find.png");
//
//         public void paintComponent(Graphics g) {
//            g.drawImage(mainicon.getImage(), 0, 0, null);
//            setOpaque(false);
//            super.paintComponent(g);
//         }
//      };
//      FindBetween.setBounds(1100, 700, 700, 23);
         


//      FindButton.add(FindBetween);
//      FindButton.setBorderPainted(false);    //투명 버튼
//      FindButton.setFocusPainted(false);      //투명 버튼
//      FindButton.setContentAreaFilled(false);
//      FindButton.setBounds(1100, 600, 100, 23);
//      panel_2.add(FindButton);
      
      
      JLabel INPfNewLabel = new JLabel("성함   :");
      INPfNewLabel.setFont(new Font("ZESSTYPE 비가온다 PT02", Font.PLAIN, 25));
      //INPfNewLabel.setSize(200,200);
      //INPfNewLabel.setSize(100,100);
      INPfNewLabel.setBounds(1075, 120, 57, 30);
      panel_2.add(INPfNewLabel);
            
      JTextField PftextField = new JTextField();
      PftextField.setBounds(1135, 120, 160, 30);
      PftextField.setSize(160, 30);
      panel_2.add(PftextField);
      PftextField.setColumns(10);
      
      
      JLabel INSTNewLabel = new JLabel("학번  :");
      INSTNewLabel.setFont(new Font("ZESSTYPE 비가온다 PT02", Font.PLAIN, 25));
      INSTNewLabel.setBounds(1075, 400, 57, 30);
      panel_2.add(INSTNewLabel);
      
      JTextField STtextField = new JTextField();
      STtextField.setBounds(1135, 400, 160, 30);
      STtextField.setSize(160, 30);
      panel_2.add(STtextField);
      STtextField.setColumns(10);
      panel_2.setLayout(null);
      panel_2.add(Pfpanel);
      
      JPanel pnl_TempStAdd = new JPanel(){
         //판넬에 이미지 추가
         ImageIcon mainicon = new ImageIcon("img/small_add.png");

         public void paintComponent(Graphics g) {
            g.drawImage(mainicon.getImage(), 0, 0, null);
            setOpaque(false);
            super.paintComponent(g);
         }
      };
      pnl_TempStAdd.setBounds(53, 107, 96, 58);
      Pfpanel.add(pnl_TempStAdd);
      
      JPanel pnl_TempStDel = new JPanel(){
         //판넬에 이미지 추가
         ImageIcon mainicon = new ImageIcon("img/small_del.png");

         public void paintComponent(Graphics g) {
            g.drawImage(mainicon.getImage(), 0, 0, null);
            setOpaque(false);
            super.paintComponent(g);
         }
      };
      pnl_TempStDel.setBounds(187, 107, 96, 58);
      Pfpanel.add(pnl_TempStDel);
      panel_2.add(STpanel);
      STpanel.setLayout(null);
      
      JButton btn_ProfAdd = new JButton();
      btn_ProfAdd.setBorderPainted(false);    //투명 버튼
      btn_ProfAdd.setFocusPainted(false);      //투명 버튼
      btn_ProfAdd.setContentAreaFilled(false);
      btn_ProfAdd.setBounds(54, 124, 88, 29);
      STpanel.add(btn_ProfAdd);
      
      JButton btn_ProfDel = new JButton();
      btn_ProfDel.setBorderPainted(false);    //투명 버튼
      btn_ProfDel.setFocusPainted(false);      //투명 버튼
      btn_ProfDel.setContentAreaFilled(false);
      btn_ProfDel.setBounds(203, 124, 80, 29);
      STpanel.add(btn_ProfDel);
      
      JPanel pnl_TempProfAdd = new JPanel(){
         //판넬에 이미지 추가
         ImageIcon mainicon = new ImageIcon("img/small_add.png");

         public void paintComponent(Graphics g) {
            g.drawImage(mainicon.getImage(), 0, 0, null);
            setOpaque(false);
            super.paintComponent(g);
         }
      };
      pnl_TempProfAdd.setBounds(54, 110, 88, 55);
      STpanel.add(pnl_TempProfAdd);
      
      JPanel pnl_TempProfDel = new JPanel(){
         //판넬에 이미지 추가
         ImageIcon mainicon = new ImageIcon("img/small_del.png");

         public void paintComponent(Graphics g) {
            g.drawImage(mainicon.getImage(), 0, 0, null);
            setOpaque(false);
            super.paintComponent(g);
         }
      };
      pnl_TempProfDel.setBounds(203, 110, 80, 55);
      STpanel.add(pnl_TempProfDel);
      panel_2.add(INPfNewLabel);
      panel_2.add(PftextField);
      panel_2.add(INSTNewLabel);
      panel_2.add(STtextField);
      panel_2.add(scrolltime1);
      panel_2.add(scrollPane_2);
      panel_2.add(scrollPane_3);
      panel_2.add(scrollPane_4);
      panel_2.add(scrollPane_6);
      panel_2.add(scrollPane_7);
      panel_2.add(scrollPane_5);
      panel_2.add(pnl_TempFindBC);
      //------------------------------
      //------------------------------
      
      JButton btnNewButton = new JButton();
      btnNewButton.setBorderPainted(false);    //투명 버튼
      btnNewButton.setFocusPainted(false);      //투명 버튼
      btnNewButton.setContentAreaFilled(false); //투명 버튼
      btnNewButton.setBounds(17, 53, 209, 61);
      contentPane.add(btnNewButton);
      

      JButton btnNewButton_1 = new JButton();
      btnNewButton_1.setBorderPainted(false);    //투명 버튼
      btnNewButton_1.setFocusPainted(false);      //투명 버튼
      btnNewButton_1.setContentAreaFilled(false); //투명 버
      btnNewButton_1.setBounds(215, 53, 201, 61);
      contentPane.add(btnNewButton_1);
      
      JPanel panel = new JPanel();
      panel.setBounds(0, 146, 1055, 765);
      contentPane.add(panel);
      panel.setBackground(Color.WHITE);
      panel.setLayout(null);
      
      //모의 시간표 버튼
      JPanel pnl_TimeTableTemp = new JPanel(){
         //판넬에 이미지 추가
         ImageIcon mainicon = new ImageIcon("img/timetable.png");

         public void paintComponent(Graphics g) {
            g.drawImage(mainicon.getImage(), 0, 0, null);
            setOpaque(false);
            super.paintComponent(g);
         }
      };
      pnl_TimeTableTemp.setBounds(17, 53, 209, 61);
      contentPane.add(pnl_TimeTableTemp);
      
      JPanel pnl_BetweenTemp = new JPanel(){
         //판넬에 이미지 추가
         ImageIcon mainicon = new ImageIcon("img/between.png");

         public void paintComponent(Graphics g) {
            g.drawImage(mainicon.getImage(), 0, 0, null);
            setOpaque(false);
            super.paintComponent(g);
         }
      };
      pnl_BetweenTemp.setBounds(215, 53, 201, 61);
      contentPane.add(pnl_BetweenTemp);
      
      
      
      
      
      btnNewButton_1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            ParentPanel.removeAll();
            ParentPanel.add(panel_2);
            ParentPanel.repaint();
            ParentPanel.revalidate();
         }
      });
      btnNewButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            ParentPanel.removeAll();
            ParentPanel.add(panel_1);
            ParentPanel.repaint();
            ParentPanel.revalidate();
         }
      });
      
   }
}
