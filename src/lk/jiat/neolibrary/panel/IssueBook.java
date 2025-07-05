/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package lk.jiat.neolibrary.panel;

import com.formdev.flatlaf.FlatClientProperties;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.JOptionPane;
import lk.jiat.neolibrary.component.FormattedTextField;
import lk.jiat.neolibrary.component.RoundButton;
import lk.jiat.neolibrary.connection.MySQL;
import lk.jiat.neolibrary.entity.BookStatus;
import lk.jiat.neolibrary.validation.Validator;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;

/**
 *
 * @author Yashitha
 */
public class IssueBook extends javax.swing.JPanel {

    /**
     * Creates new form IssueBook
     */
    public IssueBook() {
        initComponents();
        init();
        loadGenre();
    }
    
    private void init() {
        // Modern glassmorphism styling
        this.setBackground(new Color(15, 23, 42)); // Slate-900
        
        // Enhanced field styling
        memberIdField.putClientProperty("JTextField.placeholderText", "Enter Member ID and press Enter");
        bookIdField.putClientProperty("JTextField.placeholderText", "Enter Book ID and press Enter");
        
        // Enhanced typography
        updateTypography();
        
        // Modern form styling
        styleFormComponents();
        
        // Enhanced button styling
        styleButtons();
        
        // Style panels
        stylePanels();
    }
    
    private void updateTypography() {
        // Header with modern typography
        jLabel1.setFont(new Font("Inter", Font.BOLD, 36));
        jLabel1.setForeground(new Color(248, 250, 252));
        
        // Section headers with enhanced styling
        jLabel2.setFont(new Font("Inter", Font.BOLD, 22));
        jLabel2.setForeground(new Color(241, 245, 249));
        
        jLabel6.setFont(new Font("Inter", Font.BOLD, 22));
        jLabel6.setForeground(new Color(241, 245, 249));
        
        // Form labels with better contrast
        jLabel13.setFont(new Font("Inter", Font.BOLD, 15));
        jLabel13.setForeground(new Color(226, 232, 240));
        
        jLabel5.setFont(new Font("Inter", Font.BOLD, 15));
        jLabel5.setForeground(new Color(226, 232, 240));
    }
    
    private void styleFormComponents() {
        // Enhanced text field styling with focus effects
        memberIdField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(71, 85, 105), 2),
            BorderFactory.createEmptyBorder(12, 16, 12, 16)
        ));
        memberIdField.setBackground(new Color(51, 65, 85)); // Slate-700
        memberIdField.setForeground(new Color(241, 245, 249));
        memberIdField.setFont(new Font("Inter", Font.PLAIN, 16));
        memberIdField.setCaretColor(new Color(241, 245, 249));
        
        // Add focus listener for memberIdField
        memberIdField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                memberIdField.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(new Color(59, 130, 246), 2), // Blue-500
                    BorderFactory.createEmptyBorder(12, 16, 12, 16)
                ));
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                memberIdField.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(new Color(71, 85, 105), 2),
                    BorderFactory.createEmptyBorder(12, 16, 12, 16)
                ));
            }
        });
        
        bookIdField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(71, 85, 105), 2),
            BorderFactory.createEmptyBorder(12, 16, 12, 16)
        ));
        bookIdField.setBackground(new Color(51, 65, 85)); // Slate-700
        bookIdField.setForeground(new Color(241, 245, 249));
        bookIdField.setFont(new Font("Inter", Font.PLAIN, 16));
        bookIdField.setCaretColor(new Color(241, 245, 249));
        
        // Add focus listener for bookIdField
        bookIdField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                bookIdField.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(new Color(59, 130, 246), 2), // Blue-500
                    BorderFactory.createEmptyBorder(12, 16, 12, 16)
                ));
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                bookIdField.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(new Color(71, 85, 105), 2),
                    BorderFactory.createEmptyBorder(12, 16, 12, 16)
                ));
            }
        });
    }
    
    private void styleButtons() {
        // Enhanced button styling with green color (as per user preference)
        lendBookBtn.setFont(new Font("Inter", Font.BOLD, 18));
        lendBookBtn.setPreferredSize(new java.awt.Dimension(220, 55));
        lendBookBtn.setBackground(new Color(34, 197, 94)); // Green-500
        lendBookBtn.setForeground(new Color(255, 255, 255));
        lendBookBtn.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(22, 163, 74), 2),
            BorderFactory.createEmptyBorder(15, 30, 15, 30)
        ));
        lendBookBtn.setFocusPainted(false);
        lendBookBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        
        // Add hover effect with shadow
        lendBookBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lendBookBtn.setBackground(new Color(22, 163, 74)); // Green-600
                lendBookBtn.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(new Color(21, 128, 61), 2),
                    BorderFactory.createEmptyBorder(15, 30, 15, 30)
                ));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lendBookBtn.setBackground(new Color(34, 197, 94)); // Green-500
                lendBookBtn.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(new Color(22, 163, 74), 2),
                    BorderFactory.createEmptyBorder(15, 30, 15, 30)
                ));
            }
        });
    }
    
    private void stylePanels() {
        // Style the main panels with subtle borders and backgrounds
        jPanel1.setBackground(new Color(30, 41, 59)); // Slate-800
        jPanel1.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(71, 85, 105), 1),
            BorderFactory.createEmptyBorder(25, 25, 25, 25)
        ));
        
        jPanel3.setBackground(new Color(30, 41, 59)); // Slate-800
        jPanel3.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(71, 85, 105), 1),
            BorderFactory.createEmptyBorder(25, 25, 25, 25)
        ));
        
        jPanel2.setBackground(new Color(15, 23, 42)); // Slate-900
        jPanel2.setBorder(BorderFactory.createEmptyBorder(30, 0, 30, 0));
        
        // Style separators with gradient effect
        jSeparator1.setForeground(new Color(71, 85, 105));
        jSeparator1.setPreferredSize(new java.awt.Dimension(0, 3));
        
        jSeparator2.setForeground(new Color(71, 85, 105));
        jSeparator2.setPreferredSize(new java.awt.Dimension(0, 3));
        
        // Add rounded corners to panels (if supported)
        try {
            jPanel1.putClientProperty("JPanel.arc", 15);
            jPanel3.putClientProperty("JPanel.arc", 15);
        } catch (Exception e) {
            // Fallback if rounded corners not supported
        }
    }
    
    private void loadMember() {
        String memberId = memberIdField.getText().trim();
        try {
            ResultSet memberRS = MySQL.executeSearch("SELECT * FROM `member` WHERE `member_id` = '" + memberId + "';");
            if (memberRS.next()) {
                // Member found - we could add validation here if needed
                System.out.println("Member found: " + memberRS.getString("fname") + " " + memberRS.getString("lname"));
            } else {
                JOptionPane.showMessageDialog(null,
                        "Enter valid ID.",
                        "Data Loading Error Message",
                        JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private void loadGenre() {
        // Genre loading removed as combo box no longer exists
    }
    
    private Date issueDate;
    private Date due;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    private void loadBookAndDate() {
        String bookId = bookIdField.getText().trim();
        try {
            ResultSet bookRS = MySQL.executeSearch("SELECT * FROM `book` WHERE `book_id` = '" + bookId + "';");
            if (bookRS.next()) {
                String duration = MySQL.getAppProperties().getProperty("lend.duration");
                
                LocalDateTime lendDate = LocalDateTime.now();
                LocalDateTime dueDate = lendDate.plusDays(Long.parseLong(duration));
                
                issueDate = Date.from(lendDate.atZone(ZoneId.systemDefault()).toInstant());
                System.out.println(issueDate);
                due = Date.from(dueDate.atZone(ZoneId.systemDefault()).toInstant());
                
                System.out.println("Book found: " + bookRS.getString("title") + " by " + bookRS.getString("Author"));
                
            } else {
                JOptionPane.showMessageDialog(null,
                        "Enter valid ID.",
                        "Data Loading Error Message",
                        JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private void lendBook() {
        String memberIdText = memberIdField.getText().trim();
        String bookIdText = bookIdField.getText().trim();
        System.out.println("[DEBUG] lendBook called with memberId=" + memberIdText + ", bookId=" + bookIdText);
        if (!Validator.isInputFieldValid(memberIdText) || !Validator.isInputFieldValid(bookIdText)) {
            JOptionPane.showMessageDialog(this, "Please enter valid Member ID and Book ID.", "Validation Error", JOptionPane.WARNING_MESSAGE);
            System.out.println("[DEBUG] Validation failed: empty member or book ID");
            return;
        }
        Integer memberId = Integer.valueOf(memberIdText);
        Integer bookId = Integer.valueOf(bookIdText);
        try {
            // Check if member exists
            ResultSet memberRS = MySQL.executeSearch("SELECT * FROM `member` WHERE `member_id` = '" + memberId + "';");
            if (!memberRS.next()) {
                JOptionPane.showMessageDialog(this, "Member ID does not exist.", "Error", JOptionPane.ERROR_MESSAGE);
                System.out.println("[DEBUG] Member not found: " + memberId);
                return;
            }
            // Check if book exists and is available
            ResultSet bookRS = MySQL.executeSearch("SELECT * FROM `book` WHERE `book_id` = '" + bookId + "';");
            if (!bookRS.next()) {
                JOptionPane.showMessageDialog(this, "Book ID does not exist.", "Error", JOptionPane.ERROR_MESSAGE);
                System.out.println("[DEBUG] Book not found: " + bookId);
                return;
            }
            int statusId = bookRS.getInt("b_status_id");
            System.out.println("[DEBUG] Book status: " + statusId);
            if (statusId != 1) { // 1 = Available
                JOptionPane.showMessageDialog(this, "Book is not available for lending.", "Error", JOptionPane.ERROR_MESSAGE);
                System.out.println("[DEBUG] Book not available: statusId=" + statusId);
                return;
            }
            // Set issueDate and due if not already set
            if (issueDate == null) {
                issueDate = new Date();
            }
            if (due == null) {
                // Default to 14 days from now
                java.util.Calendar cal = java.util.Calendar.getInstance();
                cal.setTime(issueDate);
                cal.add(java.util.Calendar.DAY_OF_MONTH, 14);
                due = cal.getTime();
            }
            // Insert into issue_records
            String issueSql = "INSERT INTO `issue_records` (`issue_date`,`due_date`,`return_data`,`member_id`,`book_id`) VALUES ('" + sdf.format(issueDate) + "','" + sdf.format(due) + "',NULL,'" + memberId + "','" + bookId + "');";
            System.out.println("[DEBUG] Executing: " + issueSql);
            MySQL.executeIUD(issueSql);
            // Update book status to Issued
            String updateSql = "UPDATE `book` SET `b_status_id` = '" + BookStatus.ISSUED.getId() + "' WHERE `book_id` = '" + bookId + "'";
            System.out.println("[DEBUG] Executing: " + updateSql);
            MySQL.executeIUD(updateSql);
            JOptionPane.showMessageDialog(this, "Book successfully lent!", "Success", JOptionPane.INFORMATION_MESSAGE);
            // Clear fields
            memberIdField.setText("");
            bookIdField.setText("");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to lend book: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("[DEBUG] SQLException: " + e.getMessage());
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
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        memberIdField = new FormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        bookIdField = new FormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        lendBookBtn = new RoundButton();

        setBackground(new java.awt.Color(0, 30, 51));
        setPreferredSize(new java.awt.Dimension(1792, 1010));

        jLabel1.setBackground(new java.awt.Color(0, 30, 51));
        jLabel1.setFont(new java.awt.Font("Lucida Fax", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 214, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Issue Books");

        jLabel2.setFont(new java.awt.Font("Dubai Medium", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Member Infromation");

        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator1.setFont(new java.awt.Font("Dubai Medium", 1, 18)); // NOI18N

        jPanel3.setBackground(new java.awt.Color(0, 30, 51));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        jLabel13.setFont(new java.awt.Font("Dubai Medium", 0, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Membership ID");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 50);
        jPanel3.add(jLabel13, gridBagConstraints);

        memberIdField.setFont(new java.awt.Font("Dubai Medium", 0, 16)); // NOI18N
        memberIdField.setForeground(new java.awt.Color(255, 255, 255));
        memberIdField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                memberIdFieldActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 50);
        jPanel3.add(memberIdField, gridBagConstraints);

        jLabel6.setFont(new java.awt.Font("Dubai Medium", 1, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Book Infromation");

        jSeparator2.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator2.setFont(new java.awt.Font("Dubai Medium", 1, 18)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(0, 30, 51));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel5.setFont(new java.awt.Font("Dubai Medium", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Book ID");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 50);
        jPanel1.add(jLabel5, gridBagConstraints);

        bookIdField.setFont(new java.awt.Font("Dubai Medium", 0, 16)); // NOI18N
        bookIdField.setForeground(new java.awt.Color(255, 255, 255));
        bookIdField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookIdFieldActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 50);
        jPanel1.add(bookIdField, gridBagConstraints);

        jPanel2.setBackground(new java.awt.Color(0, 30, 51));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        lendBookBtn.setBackground(new java.awt.Color(0, 153, 255));
        lendBookBtn.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        lendBookBtn.setForeground(new java.awt.Color(255, 255, 255));
        lendBookBtn.setText("Lend a Book");
        lendBookBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lendBookBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lendBookBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator2)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 1083, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 1732, Short.MAX_VALUE))))
                .addGap(30, 30, 30))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(160, 160, 160))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(50, 50, 50)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                .addGap(30, 30, 30)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                .addGap(117, 117, 117)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                .addGap(90, 90, 90)
                .addComponent(lendBookBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lendBookBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lendBookBtnActionPerformed
        lendBook();
    }//GEN-LAST:event_lendBookBtnActionPerformed

    private void bookIdFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookIdFieldActionPerformed
        loadBookAndDate();
        bookIdField.setFocusable(false);
        bookIdField.setFocusable(true);
    }//GEN-LAST:event_bookIdFieldActionPerformed

    private void memberIdFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memberIdFieldActionPerformed
        loadMember();
        memberIdField.setFocusable(false);
        memberIdField.setFocusable(true);
    }//GEN-LAST:event_memberIdFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bookIdField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton lendBookBtn;
    private javax.swing.JTextField memberIdField;
    // End of variables declaration//GEN-END:variables
}
