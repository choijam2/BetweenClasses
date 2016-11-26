import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

class ResultFrame_Renderer extends DefaultTableCellRenderer {
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row,
				column);
		if (table.getValueAt(row, column) != null && column != 0) {
			cellComponent.setBackground(Color.YELLOW);
			// cellComponent.setForeground(Color.YELLOW);
		} else
			cellComponent.setBackground(Color.WHITE);
		return cellComponent;
	}
}
