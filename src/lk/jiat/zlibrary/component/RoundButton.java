package lk.jiat.zlibrary.component;

import com.formdev.flatlaf.FlatClientProperties;
import javax.swing.JButton;

public class RoundButton extends JButton {

    public RoundButton() {
        this.putClientProperty(FlatClientProperties.STYLE, "arc:30");
    }
}