/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package lk.jiat.neolibrary.gui;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import lk.jiat.neolibrary.gui.SelectScreen;

/**
 *
 * @author Yashitha
 */
public class SplashScreen extends javax.swing.JFrame {

    /**
     * Creates new form SplashScreen
     */
    private static SplashScreen splashScreen;
    private Timer fadeTimer;
    private float fadeAlpha = 0.0f;
    private boolean fadeIn = true;
    
    // UI Components
    private GlassmorphismPanel mainPanel;
    private JLabel logo;
    private JLabel titleLabel;
    private JLabel subtitleLabel;
    private JProgressBar progressBar;
    private JLabel statusLabel;

    public SplashScreen() {
        // Set up FlatLaf before initializing components
        FlatDarkLaf.setup();
        initComponents();
        init();
        loadAnimation();
    }

    private void init() {
        // Set up modern styling
        setupModernStyling();
        
        // Start fade-in animation
        startFadeAnimation();
    }
    
    private void setupModernStyling() {
        // Create components
        mainPanel = new GlassmorphismPanel();
        logo = new JLabel();
        titleLabel = new JLabel();
        subtitleLabel = new JLabel();
        progressBar = new JProgressBar();
        statusLabel = new JLabel();
        
        // Update logo
        FlatSVGIcon icon = new FlatSVGIcon("lk/jiat/neolibrary/images/logo.svg", 120, 120);
        logo.setIcon(icon);
        logo.setHorizontalAlignment(JLabel.CENTER);
        
        // Modern typography
        titleLabel.setFont(new Font("Inter", Font.BOLD, 56));
        titleLabel.setForeground(new Color(255, 255, 255));
        titleLabel.setText("Z Library");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        
        subtitleLabel.setFont(new Font("Inter", Font.PLAIN, 18));
        subtitleLabel.setForeground(new Color(156, 163, 175));
        subtitleLabel.setText("Modern Library Management System");
        subtitleLabel.setHorizontalAlignment(JLabel.CENTER);
        
        // Modern progress bar
        progressBar.setBackground(new Color(30, 41, 59, 100));
        progressBar.setForeground(new Color(99, 102, 241));
        progressBar.setBorder(BorderFactory.createEmptyBorder());
        progressBar.setPreferredSize(new java.awt.Dimension(400, 8));
        
        // Status label
        statusLabel.setFont(new Font("Inter", Font.PLAIN, 14));
        statusLabel.setForeground(new Color(148, 163, 184));
        statusLabel.setText("Initializing...");
        statusLabel.setHorizontalAlignment(JLabel.CENTER);
        
        // Set up layout
        setupLayout();
    }
    
    private void setupLayout() {
        // Set up main panel layout with proper centering
        mainPanel.setLayout(new java.awt.BorderLayout());
        mainPanel.setBorder(new EmptyBorder(60, 40, 60, 40));

        // Center all components horizontally using a Box for vertical stacking
        javax.swing.Box box = javax.swing.Box.createVerticalBox();
        logo.setAlignmentX(javax.swing.JComponent.CENTER_ALIGNMENT);
        titleLabel.setAlignmentX(javax.swing.JComponent.CENTER_ALIGNMENT);
        subtitleLabel.setAlignmentX(javax.swing.JComponent.CENTER_ALIGNMENT);
        progressBar.setAlignmentX(javax.swing.JComponent.CENTER_ALIGNMENT);
        statusLabel.setAlignmentX(javax.swing.JComponent.CENTER_ALIGNMENT);

        box.add(logo);
        box.add(javax.swing.Box.createVerticalStrut(30));
        box.add(titleLabel);
        box.add(javax.swing.Box.createVerticalStrut(10));
        box.add(subtitleLabel);
        box.add(javax.swing.Box.createVerticalStrut(80));
        box.add(progressBar);
        box.add(javax.swing.Box.createVerticalStrut(20));
        box.add(statusLabel);

        mainPanel.removeAll();
        mainPanel.add(box, java.awt.BorderLayout.CENTER);

        // Set the glassmorphism panel as the content pane
        setContentPane(mainPanel);

        // Set frame properties
        setSize(800, 500);
        setLocationRelativeTo(null);
    }
    
    private void startFadeAnimation() {
        fadeTimer = new Timer(16, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (fadeIn) {
                    fadeAlpha += 0.05f;
                    if (fadeAlpha >= 1.0f) {
                        fadeAlpha = 1.0f;
                        fadeIn = false;
                    }
                }
                mainPanel.setFadeAlpha(fadeAlpha);
                mainPanel.repaint();
            }
        });
        fadeTimer.start();
    }

    private void loadAnimation() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                String[] statuses = {
                    "Loading modules...",
                    "Connecting to database...",
                    "Initializing UI components...",
                    "Preparing interface...",
                    "Almost ready..."
                };
                
                for (int i = 0; i < 100; i++) {
                    final int progress = i;
                    final String status = statuses[Math.min(i / 20, statuses.length - 1)];
                    
                    // Update UI on EDT
                    java.awt.EventQueue.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setValue(progress);
                            statusLabel.setText(status);
                        }
                    });
                    
                    try {
                        Thread.sleep(30);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                
                // Fade out animation
                fadeIn = false;
                Timer fadeOutTimer = new Timer(16, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        fadeAlpha -= 0.05f;
                        if (fadeAlpha <= 0.0f) {
                            fadeAlpha = 0.0f;
                            ((Timer)e.getSource()).stop();
                            
                            // Open main screen
                            new SelectScreen().setVisible(true);
                            splashScreen.dispose();
                        }
                        mainPanel.setFadeAlpha(fadeAlpha);
                        mainPanel.repaint();
                    }
                });
                fadeOutTimer.start();
            }
        });

        t.start();
    }

    // Custom glassmorphism panel
    private class GlassmorphismPanel extends JPanel {
        private float fadeAlpha = 1.0f;
        
        public GlassmorphismPanel() {
            setOpaque(false);
        }
        
        public void setFadeAlpha(float alpha) {
            this.fadeAlpha = alpha;
        }
        
        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            
            // First fill with a solid color to ensure visibility
            g2d.setColor(new Color(59, 130, 246));  // Bright blue
            g2d.fillRect(0, 0, getWidth(), getHeight());
            
            // Then add gradient overlay
            GradientPaint gradient = new GradientPaint(
                0, 0, new Color(59, 130, 246, 200),  // Bright blue with transparency
                getWidth(), getHeight(), new Color(147, 51, 234, 200)  // Purple with transparency
            );
            g2d.setPaint(gradient);
            g2d.fillRect(0, 0, getWidth(), getHeight());
            
            // Add subtle pattern overlay
            g2d.setColor(new Color(255, 255, 255, 5));
            for (int i = 0; i < getWidth(); i += 40) {
                for (int j = 0; j < getHeight(); j += 40) {
                    g2d.fillOval(i, j, 2, 2);
                }
            }
            
            // Apply fade effect
            if (fadeAlpha < 1.0f) {
                g2d.setColor(new Color(0, 0, 0, (int)((1.0f - fadeAlpha) * 255)));
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
            
            g2d.dispose();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                splashScreen = new SplashScreen();
                splashScreen.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
