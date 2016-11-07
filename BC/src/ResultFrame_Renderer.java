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

class ResultFrame_Renderer extends DefaultTableCellRenderer {// 배열 색 채우기
	
	ResultFrame_Renderer() {
		this.setHorizontalAlignment(SwingConstants.CENTER);
	};

	int[][] array;
	int row_ = 0;
	int col = 0;
	int check = 0, first1 = 0, first2 = 0, end1 = 0, end2 = 0;
	private static final long serialVersionUID = 1L;// 느낌표 표시 없애기 위해 작성 신경쓸 필요
													// 없음

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
						if ((array[i][j] == 1) && (check == 0)) {// 시간표 시작하는 부분
																	// 저장
							check = 1;
							first1 = i / 12;// i에 대한 몫
							first2 = (i - 1) % 12; // i에 대한 나머지
						}

						else if ((array[i][j] == 0) && (check == 1)) {// 시간표 끝나는
																		// 부분 저장
							check = 0;
							end1 = (i - 1) / 12;// i에 대한 몫
							end2 = (i - 1) % 12;// i에 대한 나머지
							for (int k = first1; k <= end1; k++) {
								if (k == first1) {
									if ((row_ == k) && (col == j)) {
										g.fillRect(r.x, r.y + (r.height / 12 * first2), r.width, r.height);// 시작할때는
																											// 출발하는
																											// 부분의
																											// 높이를
																											// 조절
										System.out.println("First2 : " + first2 + "\n");
									}
								} else if (k == end1) {
									if ((row_ == k) && (col == j)) {
										g.fillRect(r.x, r.y, r.width, r.height / 12 * end2);// 끝날때는
																							// 끝나는
																							// 부분의
																							// 높이를
																							// 조절
										System.out.println("End2 : " + end2 + "\n");
									}
								} else {
									if ((row_ == k) && (col == j)) { // 시간이 길 경우
																		// 중간 공백
																		// 채우는
																		// 부분
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

	void getinfo(int a[][]) {// 배열 얻어오는부분
		this.array = a;
	}
}