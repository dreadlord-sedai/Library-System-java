package lk.jiat.neolibrary.component;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
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
        this.putClientProperty(FlatClientProperties.STYLE, "arc:15;");
        init();
    }

    private void init() {
        if(isSearchBar){
            FlatSVGIcon searchIcon = new FlatSVGIcon("lk/jiat/neolibrary/images/search.svg", 20, 20);
            this.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON, searchIcon);
            this.putClientProperty("JTextField.placeholderText", "Search...");
        }
    }

}
