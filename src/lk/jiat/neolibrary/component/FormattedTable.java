package lk.jiat.neolibrary.component;

/**
 *
 * @author Yashitha
 */

import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;

public class FormattedTable extends JTable {

    public FormattedTable () {
        super();
        applyStyle();
    }

    private void applyStyle() {
        // Header styling
        JTableHeader header = this.getTableHeader();
        header.setFont(new Font("Dubai Medium", Font.BOLD, 16));
        header.setBackground(new Color(60,63,65));
        header.setForeground(new Color(187,187,187));
        header.setPreferredSize(new Dimension(header.getWidth(),40));
        
        UIManager.put("TableHeader.cellBorder" , BorderFactory.createMatteBorder(0, 0, 1, 0, this.getGridColor()));
        SwingUtilities.updateComponentTreeUI(header);
        
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) header.getDefaultRenderer();
        renderer.setHorizontalAlignment(SwingConstants.LEADING);
        
    }
    
}

