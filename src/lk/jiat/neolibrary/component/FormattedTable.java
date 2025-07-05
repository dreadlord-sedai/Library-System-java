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
        // Modern table styling
        this.setBackground(new Color(55, 65, 81)); // Gray-700
        this.setForeground(new Color(243, 244, 246)); // Gray-100
        this.setGridColor(new Color(75, 85, 99)); // Gray-600
        this.setSelectionBackground(new Color(99, 102, 241)); // Indigo
        this.setSelectionForeground(new Color(255, 255, 255));
        this.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        this.setRowHeight(40);
        this.setShowGrid(true);
        this.setIntercellSpacing(new Dimension(1, 1));
        
        // Header styling
        JTableHeader header = this.getTableHeader();
        header.setFont(new Font("Segoe UI", Font.BOLD, 14));
        header.setBackground(new Color(31, 41, 55)); // Gray-800
        header.setForeground(new Color(255, 255, 255));
        header.setPreferredSize(new Dimension(header.getWidth(), 45));
        
        // Modern border styling
        UIManager.put("TableHeader.cellBorder", BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(99, 102, 241)));
        SwingUtilities.updateComponentTreeUI(header);
        
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) header.getDefaultRenderer();
        renderer.setHorizontalAlignment(SwingConstants.LEADING);
        
        // Cell renderer for better text alignment
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setHorizontalAlignment(SwingConstants.LEADING);
        cellRenderer.setBorder(BorderFactory.createEmptyBorder(8, 12, 8, 12));
        
        // Apply cell renderer to all columns
        for (int i = 0; i < this.getColumnCount(); i++) {
            this.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
        }
    }
    
}

