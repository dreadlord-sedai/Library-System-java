/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package lk.jiat.neolibrary.gui;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import lk.jiat.neolibrary.component.RoundButton;
import lk.jiat.neolibrary.panel.Books;
import lk.jiat.neolibrary.panel.Dashboard;
import lk.jiat.neolibrary.panel.IssueBook;
import lk.jiat.neolibrary.panel.Members;
import lk.jiat.neolibrary.panel.ReturnBook;

/**
 *
 * @author Yashitha
 */
public class Home extends javax.swing.JFrame {

    /**
     * Creates new form Dashboard
     */
    private CardLayout contentPanelLayout;
    private Dashboard dashboardPanel; 
    private Books booksPanel; 
    private Members membersPanel; 
    private IssueBook issueBookPanel; 
    private ReturnBook returnBookPanel; 
    
    private javax.swing.JLabel userNameLabel;
    private javax.swing.JLabel userRoleLabel;
    
    private javax.swing.JPanel profilePanel;
    private javax.swing.JLabel profileNameLabel;
    private javax.swing.JLabel profileRoleLabel;
    
    public Home(String userName,String userRole){
        initComponents();
        init();
        loadPanels();
        setActiveBtn(dashboardBtn);
        userNameLabel.setText(userName);
        userRoleLabel.setText(userRole);
        profileNameLabel.setText(userName);
        profileRoleLabel.setText(userRole);
    }
    
    private void init() {
        // Set modern background color
        jPanel1.setBackground(new Color(17, 24, 39)); // Dark blue-gray
        
        // Logo setup
        FlatSVGIcon icon = new FlatSVGIcon("lk/jiat/neolibrary/images/logo.svg",
                logo.getWidth(),
                logo.getHeight());
        logo.setIcon(icon);
        this.setIconImage(icon.getImage());
        
        // Navigation icons with modern sizing
        dashboardBtn.setIcon(new FlatSVGIcon("lk/jiat/neolibrary/images/dashboard.svg",
                18,
                18));
        bookBtn.setIcon(new FlatSVGIcon("lk/jiat/neolibrary/images/books.svg",
                18,
                18));
        memberBtn.setIcon(new FlatSVGIcon("lk/jiat/neolibrary/images/members.svg",
                18,
                18));
        issueBookBtn.setIcon(new FlatSVGIcon("lk/jiat/neolibrary/images/issue_book.svg",
                18,
                18));
        returnBookBtn.setIcon(new FlatSVGIcon("lk/jiat/neolibrary/images/return_book.svg",
                18,
                18));
        
        // Modern typography
        jLabel1.setFont(new Font("Segoe UI", Font.BOLD, 32));
        jLabel1.setForeground(new Color(255, 255, 255));
        
        userNameLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        userNameLabel.setForeground(new Color(243, 244, 246)); // Gray-100
        
        userRoleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        userRoleLabel.setForeground(new Color(156, 163, 175)); // Gray-400
        
        // Content panel styling
        contentPanel.setBackground(new Color(31, 41, 55)); // Gray-800
        contentPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // Fix content panel sizing to prevent overflow
        contentPanel.setPreferredSize(null);
        contentPanel.setMinimumSize(new java.awt.Dimension(800, 600));
        
        // Also fix the main panel sizing
        jPanel1.setPreferredSize(null);
    }
    
    private void loadPanels(){
        if (contentPanelLayout == null && contentPanel.getLayout() instanceof CardLayout) {
            this.contentPanelLayout = (CardLayout) contentPanel.getLayout();
        }
        
        this.dashboardPanel = new Dashboard(this);
        this.booksPanel = new Books(this);
        this.membersPanel = new Members(this);
        this.issueBookPanel = new IssueBook();
        this.returnBookPanel = new ReturnBook();
        
        // Removed FlatLaf arc style property from panels (not supported)
        // dashboardPanel.putClientProperty(FlatClientProperties.STYLE, "arc:40"); 
        // booksPanel.putClientProperty(FlatClientProperties.STYLE, "arc:40");
        // membersPanel.putClientProperty(FlatClientProperties.STYLE, "arc:40");
        // issueBookPanel.putClientProperty(FlatClientProperties.STYLE, "arc:40");
        // returnBookPanel.putClientProperty(FlatClientProperties.STYLE, "arc:40");
        
        this.contentPanel.add(dashboardPanel, "dashboard_panel");
        this.contentPanel.add(booksPanel, "books_panel");
        this.contentPanel.add(membersPanel, "members_panel");
        this.contentPanel.add(issueBookPanel, "issue_book_panel");
        this.contentPanel.add(returnBookPanel, "return_book_panel");
        SwingUtilities.updateComponentTreeUI(contentPanel);
    }
    
    public void setActiveBtn(JButton activeBtn){
        JButton[] navBtns = {dashboardBtn,bookBtn,memberBtn,issueBookBtn,returnBookBtn};
        for (JButton btn : navBtns) {
            btn.setSelected(false);
        }
        activeBtn.setSelected(true);
    }

    public void setUser(String name, String role) {
        userNameLabel.setText(name);
        userRoleLabel.setText(role);
        if (profileNameLabel != null) profileNameLabel.setText(name);
        if (profileRoleLabel != null) profileRoleLabel.setText(role);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        contentPanel = new javax.swing.JPanel();
        dashboardBtn = new RoundButton(true);
        bookBtn = new RoundButton(true);
        memberBtn = new RoundButton(true);
        jLabel1 = new javax.swing.JLabel();
        issueBookBtn = new RoundButton(true);
        returnBookBtn = new RoundButton(true);
        logo = new javax.swing.JLabel();

        userNameLabel = new javax.swing.JLabel();
        userRoleLabel = new javax.swing.JLabel();

        profilePanel = new javax.swing.JPanel();
        profilePanel.setBackground(new java.awt.Color(31, 41, 55));
        profilePanel.setLayout(new java.awt.BorderLayout());
        javax.swing.JLabel profileIcon = new javax.swing.JLabel();
        profileIcon.setIcon(new FlatSVGIcon("lk/jiat/neolibrary/images/user.svg", 28, 28));
        profileIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        javax.swing.JPanel textPanel = new javax.swing.JPanel();
        textPanel.setOpaque(false);
        textPanel.setLayout(new java.awt.GridLayout(2, 1));
        profileNameLabel = new javax.swing.JLabel();
        profileRoleLabel = new javax.swing.JLabel();
        profileNameLabel.setText(userNameLabel.getText());
        profileNameLabel.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14));
        profileNameLabel.setForeground(new java.awt.Color(243, 244, 246));
        profileRoleLabel.setText(userRoleLabel.getText());
        profileRoleLabel.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 12));
        profileRoleLabel.setForeground(new java.awt.Color(156, 163, 175));
        textPanel.add(profileNameLabel);
        textPanel.add(profileRoleLabel);
        profilePanel.add(profileIcon, java.awt.BorderLayout.WEST);
        profilePanel.add(textPanel, java.awt.BorderLayout.CENTER);
        profilePanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10));
        profilePanel.setPreferredSize(new java.awt.Dimension(144, 48));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("zlibrary || Home");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setPreferredSize(new java.awt.Dimension(0, 0));

        contentPanel.setPreferredSize(new java.awt.Dimension(1792, 0));
        contentPanel.setLayout(new java.awt.CardLayout());

        dashboardBtn.setBackground(new java.awt.Color(60, 63, 65));
        dashboardBtn.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        dashboardBtn.setText("Dashboard");
        dashboardBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dashboardBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        dashboardBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dashboardBtnActionPerformed(evt);
            }
        });

        bookBtn.setBackground(new java.awt.Color(60, 63, 65));
        bookBtn.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        bookBtn.setText("Books");
        bookBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bookBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        bookBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookBtnActionPerformed(evt);
            }
        });

        memberBtn.setBackground(new java.awt.Color(60, 63, 65));
        memberBtn.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        memberBtn.setText("Members");
        memberBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        memberBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        memberBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                memberBtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lucida Fax", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("zlibrary");
        jLabel1.setPreferredSize(new java.awt.Dimension(0, 16));

        issueBookBtn.setBackground(new java.awt.Color(60, 63, 65));
        issueBookBtn.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        issueBookBtn.setText("Issue Book");
        issueBookBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        issueBookBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        issueBookBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                issueBookBtnActionPerformed(evt);
            }
        });

        returnBookBtn.setBackground(new java.awt.Color(60, 63, 65));
        returnBookBtn.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        returnBookBtn.setText("Return Book");
        returnBookBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        returnBookBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        returnBookBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnBookBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bookBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(memberBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(issueBookBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(returnBookBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(profilePanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(dashboardBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 841, Short.MAX_VALUE)
                        .addGap(158, 158, 158))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 777, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(dashboardBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bookBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(memberBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(issueBookBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(returnBookBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(profilePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1163, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 847, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // Set proper window size and ensure content is visible
        this.setSize(1400, 900);
        this.setLocationRelativeTo(null);
        this.revalidate();
        this.repaint();
        
        // Force layout update after a short delay to ensure proper sizing
        javax.swing.Timer timer = new javax.swing.Timer(100, new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                contentPanel.revalidate();
                contentPanel.repaint();
            }
        });
        timer.setRepeats(false);
        timer.start();
    }//GEN-LAST:event_formWindowOpened

    private void memberBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memberBtnActionPerformed
        this.contentPanelLayout.show(contentPanel, "members_panel");
        setActiveBtn(memberBtn);
    }//GEN-LAST:event_memberBtnActionPerformed

    private void issueBookBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_issueBookBtnActionPerformed
        this.contentPanelLayout.show(contentPanel, "issue_book_panel");
        setActiveBtn(issueBookBtn);
    }//GEN-LAST:event_issueBookBtnActionPerformed

    private void returnBookBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnBookBtnActionPerformed
        this.contentPanelLayout.show(contentPanel, "return_book_panel");
        setActiveBtn(returnBookBtn);
    }//GEN-LAST:event_returnBookBtnActionPerformed

    private void dashboardBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashboardBtnActionPerformed
        this.contentPanelLayout.show(contentPanel, "dashboard_panel");
        setActiveBtn(dashboardBtn);
        // Refresh the dashboard data to show latest statistics
        if (dashboardPanel != null) {
            dashboardPanel.refreshData();
        }
    }//GEN-LAST:event_dashboardBtnActionPerformed

    private void bookBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookBtnActionPerformed
        this.contentPanelLayout.show(contentPanel, "books_panel");
        setActiveBtn(bookBtn);
        // Refresh the books data to show latest status changes
        if (booksPanel != null) {
            booksPanel.refreshData();
        }
    }//GEN-LAST:event_bookBtnActionPerformed

    public JPanel getContentPanel() {
        return contentPanel;
    }

    public CardLayout getContentPanelLayout() {
        return contentPanelLayout;
    }

    public JButton getBookBtn() {
        return bookBtn;
    }

    public JButton getMemberBtn() {
        return memberBtn;
    }    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        FlatDarkLaf.setup();
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home("Dehemi","Admin").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bookBtn;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JButton dashboardBtn;
    private javax.swing.JButton issueBookBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel logo;
    private javax.swing.JButton returnBookBtn;
    private javax.swing.JButton memberBtn;
    // End of variables declaration//GEN-END:variables
}
