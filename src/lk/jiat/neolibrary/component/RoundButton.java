package lk.jiat.neolibrary.component;

import com.formdev.flatlaf.FlatClientProperties;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class RoundButton extends JButton {

    // Modern color palette with glassmorphism effects
    private static final Color PRIMARY_COLOR = new Color(59, 130, 246); // Blue-500
    private static final Color PRIMARY_HOVER = new Color(37, 99, 235); // Blue-600
    private static final Color SECONDARY_COLOR = new Color(30, 41, 59); // Slate-800
    private static final Color SECONDARY_HOVER = new Color(51, 65, 85); // Slate-700
    private static final Color SUCCESS_COLOR = new Color(16, 185, 129); // Emerald-500
    private static final Color SUCCESS_HOVER = new Color(5, 150, 105); // Emerald-600
    private static final Color DANGER_COLOR = new Color(239, 68, 68); // Red-500
    private static final Color DANGER_HOVER = new Color(220, 38, 38); // Red-600
    private static final Color WARNING_COLOR = new Color(245, 158, 11); // Amber-500
    private static final Color WARNING_HOVER = new Color(217, 119, 6); // Amber-600
    private static final Color VIOLET_COLOR = new Color(139, 92, 246); // Violet-500
    private static final Color VIOLET_HOVER = new Color(124, 58, 237); // Violet-600

    private boolean isDashBoardBtn = false;
    private boolean isHovered = false;
    private Color currentBackground;
    private Color currentForeground = Color.WHITE;

    public RoundButton() {
        this(false);
    }

    public RoundButton(boolean isDadhboardBtn) {
        this.isDashBoardBtn = isDadhboardBtn;
        init();
    }

    private void init() {
        // Modern styling
        this.putClientProperty(FlatClientProperties.STYLE, "arc:12; borderWidth:0; focusWidth:0");
        this.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        this.setForeground(currentForeground);
        this.setBorder(null);
        this.setFocusPainted(false);
        this.setContentAreaFilled(false);
        this.setOpaque(false);
        
        // Set initial background
        updateBackground();
        
        // Add hover effects
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                isHovered = true;
                updateBackground();
                repaint();
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                isHovered = false;
                updateBackground();
                repaint();
            }
        });
        
        UIManager.put("Button.borderWidth", 0);
        UIManager.put("Button.innerFocusWidth", 0);
        SwingUtilities.updateComponentTreeUI(this);
    }

    private void updateBackground() {
        if (isDashBoardBtn) {
            if (isSelected()) {
                currentBackground = isHovered ? PRIMARY_HOVER : PRIMARY_COLOR;
            } else {
                currentBackground = isHovered ? SECONDARY_HOVER : SECONDARY_COLOR;
            }
        } else {
            // Determine button type based on text
            String buttonText = getText().toLowerCase();
            if (buttonText.contains("logout")) {
                currentBackground = isHovered ? DANGER_HOVER : DANGER_COLOR;
            } else if (buttonText.contains("add") || buttonText.contains("issue")) {
                currentBackground = isHovered ? SUCCESS_HOVER : SUCCESS_COLOR;
            } else if (buttonText.contains("return")) {
                currentBackground = isHovered ? WARNING_HOVER : WARNING_COLOR;
            } else if (buttonText.contains("generate") || buttonText.contains("report")) {
                currentBackground = isHovered ? VIOLET_HOVER : VIOLET_COLOR;
            } else if (buttonText.contains("search")) {
                currentBackground = isHovered ? PRIMARY_HOVER : PRIMARY_COLOR;
            } else {
                currentBackground = isHovered ? SECONDARY_HOVER : SECONDARY_COLOR;
            }
        }
    }

    @Override
    public void setSelected(boolean selected) {
        super.setSelected(selected);
        if (isEnabled()) {
            updateBackground();
            repaint();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        
        // Create glassmorphism effect with subtle transparency
        Color glassColor = new Color(
            currentBackground.getRed(),
            currentBackground.getGreen(), 
            currentBackground.getBlue(),
            isHovered ? 220 : 200
        );
        
        // Draw main rounded background
        g2d.setColor(glassColor);
        g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 16, 16);
        
        // Add subtle inner highlight for depth
        if (isHovered) {
            g2d.setColor(new Color(255, 255, 255, 30));
            g2d.fillRoundRect(2, 2, getWidth() - 4, getHeight() - 4, 14, 14);
        }
        
        // Add modern shadow effect
        if (isHovered) {
            g2d.setColor(new Color(0, 0, 0, 40));
            g2d.fillRoundRect(3, 3, getWidth() - 6, getHeight() - 6, 13, 13);
        }
        
        g2d.dispose();
        super.paintComponent(g);
    }
}
