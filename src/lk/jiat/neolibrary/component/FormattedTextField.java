package lk.jiat.neolibrary.component;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JTextField;

/**
 *
 * @author Yashitha
 */
public class FormattedTextField extends JTextField {

    private boolean isSearchBar;

    public FormattedTextField() {
        this(false);
    }

    public FormattedTextField(boolean isSearchBar) {
        this.isSearchBar = isSearchBar;
        init();
    }

    private void init() {
        // Modern styling
        this.setBackground(new Color(55, 65, 81)); // Gray-700
        this.setForeground(new Color(243, 244, 246)); // Gray-100
        this.setCaretColor(new Color(99, 102, 241)); // Indigo
        this.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        this.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(75, 85, 99), 1),
            BorderFactory.createEmptyBorder(8, 12, 8, 12)
        ));
        
        if(isSearchBar){
            FlatSVGIcon searchIcon = new FlatSVGIcon("lk/jiat/neolibrary/images/search.svg", 18, 18);
            this.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON, searchIcon);
            this.putClientProperty("JTextField.placeholderText", "Search...");
            this.putClientProperty("JTextField.placeholderForeground", new Color(156, 163, 175)); // Gray-400
        }
        
        // Focus listener for better UX
        this.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent e) {
                setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(new Color(99, 102, 241), 2),
                    BorderFactory.createEmptyBorder(7, 11, 7, 11)
                ));
            }
            
            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(new Color(75, 85, 99), 1),
                    BorderFactory.createEmptyBorder(8, 12, 8, 12)
                ));
            }
        });
    }
}
