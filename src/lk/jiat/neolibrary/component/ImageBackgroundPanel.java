package lk.jiat.neolibrary.component;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImageBackgroundPanel {

    public static class BackgroundPanel extends JPanel {

        private Image bg;

        public BackgroundPanel(String imagePath) {
            try {
                bg = new ImageIcon(getClass().getResource(imagePath)).getImage();
            } catch (Exception e) {
                System.out.println("Image not found");
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (bg != null) {
                g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
            }
        }
    }
}
