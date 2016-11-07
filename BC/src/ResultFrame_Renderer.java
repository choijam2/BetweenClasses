import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.plaf.LabelUI;
import javax.swing.plaf.basic.BasicLabelUI;
import javax.swing.table.DefaultTableCellRenderer;

class ResultFrame_Renderer extends DefaultTableCellRenderer {// �迭 �� ä���
	
	ResultFrame_Renderer() {
		this.setHorizontalAlignment(SwingConstants.CENTER);
	};

	int[][] array;
	int row_ = 0;
	int col = 0;
	int check = 0, first1 = 0, first2 = 0, end1 = 0, end2 = 0;
	private static final long serialVersionUID = 1L;// ����ǥ ǥ�� ���ֱ� ���� �ۼ� �Ű澵 �ʿ�
													// ����

	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		row_ = row;
		col = column;
		if (!isSelected) {
			////////////////////////////////
		}
		return cell;
	}

	public void setUI(LabelUI ui) {
		super.setUI(new BasicLabelUI() {
			public void paint(Graphics g, JComponent c) {
				Rectangle r = g.getClipBounds();
				super.paint(g, c);
				g.setColor(Color.green);
				for (int j = 1; j < 7; j++) {
					for (int i = 1; i < 145; i++) {
						if ((array[i][j] == 1) && (check == 0)) {// �ð�ǥ �����ϴ� �κ�
																	// ����
							check = 1;
							first1 = i / 12;// i�� ���� ��
							first2 = (i - 1) % 12; // i�� ���� ������
						}

						else if ((array[i][j] == 0) && (check == 1)) {// �ð�ǥ ������
																		// �κ� ����
							check = 0;
							end1 = (i - 1) / 12;// i�� ���� ��
							end2 = (i - 1) % 12;// i�� ���� ������
							for (int k = first1; k <= end1; k++) {
								if (k == first1) {
									if ((row_ == k) && (col == j)) {
										g.fillRect(r.x, r.y + (r.height / 12 * first2), r.width, r.height);// �����Ҷ���
																											// ����ϴ�
																											// �κ���
																											// ���̸�
																											// ����
										System.out.println("First2 : " + first2 + "\n");
									}
								} else if (k == end1) {
									if ((row_ == k) && (col == j)) {
										g.fillRect(r.x, r.y, r.width, r.height / 12 * end2);// ��������
																							// ������
																							// �κ���
																							// ���̸�
																							// ����
										System.out.println("End2 : " + end2 + "\n");
									}
								} else {
									if ((row_ == k) && (col == j)) { // �ð��� �� ���
																		// �߰� ����
																		// ä���
																		// �κ�
										g.fillRect(r.x, r.y, r.width, r.height);
									}
								}
							}
						}
					}
				}
			}
		});
	}

	void getinfo(int a[][]) {// �迭 �����ºκ�
		this.array = a;
	}
}