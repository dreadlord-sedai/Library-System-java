package lk.jiat.neolibrary.component;

import com.formdev.flatlaf.FlatClientProperties;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class RoundButton extends JButton {

    private static final Color DEFAULT_COLOR = new Color(60, 63, 65);
    private static final Color ACTIVE_COLOR = new Color(0, 153, 255);

    private boolean isDashBoardBtn = false;

    public RoundButton() {
        this(false);
    }

    public RoundButton(boolean isDadhboardBtn) {
        this.isDashBoardBtn = isDadhboardBtn;
        init();
    }

    private void init() {
        this.putClientProperty(FlatClientProperties.STYLE, "arc:30");
        UIManager.put("Button.borderWidth", 0);
        UIManager.put("Button.innerFocusWidth", 0);
        SwingUtilities.updateComponentTreeUI(this);
        
    }

    @Override
    public void setSelected(boolean selected
    ) {
        super.setSelected(selected);
        if (isEnabled()) {
            if (isDashBoardBtn) {
                setBackground(isSelected() ? ACTIVE_COLOR : DEFAULT_COLOR);
            }
        }
    }

}
