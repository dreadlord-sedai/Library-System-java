/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package lk.jiat.neolibrary.panel;

import com.formdev.flatlaf.FlatClientProperties;
import lk.jiat.neolibrary.component.FormattedTextField;
import lk.jiat.neolibrary.component.RoundButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import java.util.Vector;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Yashitha
 */
public class ReturnBook extends javax.swing.JPanel {

    /**
     * Creates new form ReturnBook
     */
    public ReturnBook() {
        initComponents();
        init();
    }
    
    private void init(){
        // Modern glassmorphism styling
        this.setBackground(new Color(15, 23, 42)); // Slate-900
        
        // Enhanced field styling
        memberIdField.putClientProperty("JTextField.placeholderText", "Enter Member ID and press Enter");
        bookIdField.putClientProperty("JTextField.placeholderText", "Enter Book ID and press Enter");
        
        // Make fields editable
        memberIdField.setEditable(true);
        memberIdField.setFocusable(true);
        
        // Enhanced typography
        updateTypography();
        
        // Modern form styling
        styleFormComponents();
        
        // Enhanced button styling
        styleButtons();
        
        // Fix panel sizing to prevent overflow
        fixPanelSizing();
        
        // Setup action listeners
        setupActionListeners();
    }
    
    private void fixPanelSizing() {
        // Set maximum sizes to prevent overflow
        jPanel1.setMaximumSize(new java.awt.Dimension(800, 200));
        jPanel2.setMaximumSize(new java.awt.Dimension(800, 150));
        jPanel3.setMaximumSize(new java.awt.Dimension(800, 150));
        
        // Ensure panels can shrink
        jPanel1.setMinimumSize(new java.awt.Dimension(600, 120));
        jPanel2.setMinimumSize(new java.awt.Dimension(600, 100));
        jPanel3.setMinimumSize(new java.awt.Dimension(600, 100));
        
        // Set preferred sizes
        jPanel1.setPreferredSize(new java.awt.Dimension(700, 150));
        jPanel2.setPreferredSize(new java.awt.Dimension(700, 100));
        jPanel3.setPreferredSize(new java.awt.Dimension(700, 100));
    }
    
    private void updateTypography() {
        // Header with modern typography
        jLabel1.setFont(new Font("Inter", Font.BOLD, 32));
        jLabel1.setForeground(new Color(248, 250, 252));
        
        // Section headers
        jLabel2.setFont(new Font("Inter", Font.BOLD, 20));
        jLabel2.setForeground(new Color(241, 245, 249));
        
        jLabel6.setFont(new Font("Inter", Font.BOLD, 20));
        jLabel6.setForeground(new Color(241, 245, 249));
        

        
        // Form labels

        
        jLabel13.setFont(new Font("Inter", Font.PLAIN, 14));
        jLabel13.setForeground(new Color(203, 213, 225));
        

        


        jLabel5.setFont(new Font("Inter", Font.PLAIN, 14));
        jLabel5.setForeground(new Color(203, 213, 225));
        


        
        jLabel8.setFont(new Font("Inter", Font.PLAIN, 14));
        jLabel8.setForeground(new Color(203, 213, 225));
    }
    
    private void styleFormComponents() {
        // Enhanced text field styling
        memberIdField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(71, 85, 105), 1),
            BorderFactory.createEmptyBorder(10, 15, 10, 15)
        ));
        memberIdField.setBackground(new Color(30, 41, 59));
        memberIdField.setForeground(new Color(241, 245, 249));
        memberIdField.setFont(new Font("Inter", Font.PLAIN, 14));
        
        bookIdField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(71, 85, 105), 1),
            BorderFactory.createEmptyBorder(10, 15, 10, 15)
        ));
        bookIdField.setBackground(new Color(30, 41, 59));
        bookIdField.setForeground(new Color(241, 245, 249));
        bookIdField.setFont(new Font("Inter", Font.PLAIN, 14));
    }
    
    private void styleButtons() {
        // Enhanced button styling - green for return book button
        returnBookBtn.setFont(new Font("Inter", Font.BOLD, 16));
        returnBookBtn.setPreferredSize(new java.awt.Dimension(180, 45));
        returnBookBtn.setBackground(new Color(34, 197, 94)); // Green color
        returnBookBtn.setForeground(new Color(255, 255, 255));
    }
    
    private void setupActionListeners() {
        // Add action listener for member ID field
        memberIdField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadMember();
            }
        });
        
        // Add action listener for book ID field
        bookIdField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadBook();
            }
        });
        
        // Add action listener for return book button
        returnBookBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnBook();
            }
        });
    }
    
    private void loadMember() {
        String memberId = memberIdField.getText().trim();
        if (memberId.isEmpty()) {
            JOptionPane.showMessageDialog(null,
                "Please enter a Member ID.",
                "Validation Error",
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        try {
            ResultSet memberRS = lk.jiat.neolibrary.connection.MySQL.executeSearch(
                "SELECT * FROM member WHERE member_id = '" + memberId + "'"
            );
            if (memberRS.next()) {
                // Member found - could populate additional fields if needed
                System.out.println("Member found: " + memberRS.getString("name"));
            } else {
                JOptionPane.showMessageDialog(null,
                    "Member ID does not exist.",
                    "Data Loading Error",
                    JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                "Error loading member data.",
                "Database Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void loadBook() {
        String bookId = bookIdField.getText().trim();
        if (bookId.isEmpty()) {
            JOptionPane.showMessageDialog(null,
                "Please enter a Book ID.",
                "Validation Error",
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        try {
            ResultSet bookRS = lk.jiat.neolibrary.connection.MySQL.executeSearch(
                "SELECT b.*, g.genre_name FROM book b " +
                "INNER JOIN genre g ON b.genre_id = g.genre_id " +
                "WHERE b.book_id = '" + bookId + "'"
            );
            if (bookRS.next()) {
                // Book found - could populate additional fields if needed
                System.out.println("Book found: " + bookRS.getString("title") + " by " + bookRS.getString("author"));
            } else {
                JOptionPane.showMessageDialog(null,
                    "Book ID does not exist.",
                    "Data Loading Error",
                    JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                "Error loading book data.",
                "Database Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void returnBook() {
        String memberIdText = memberIdField.getText().trim();
        String bookIdText = bookIdField.getText().trim();
        
        if (memberIdText.isEmpty() || bookIdText.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "Please enter both Member ID and Book ID.", 
                "Validation Error", 
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        try {
            Integer memberId = Integer.valueOf(memberIdText);
            Integer bookId = Integer.valueOf(bookIdText);
            
            // Check if member exists
            ResultSet memberRS = lk.jiat.neolibrary.connection.MySQL.executeSearch(
                "SELECT * FROM member WHERE member_id = '" + memberId + "'"
            );
            if (!memberRS.next()) {
                JOptionPane.showMessageDialog(this, 
                    "Member ID does not exist.", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Check if book exists
            ResultSet bookRS = lk.jiat.neolibrary.connection.MySQL.executeSearch(
                "SELECT * FROM book WHERE book_id = '" + bookId + "'"
            );
            if (!bookRS.next()) {
                JOptionPane.showMessageDialog(this, 
                    "Book ID does not exist.", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Check if book is currently issued to this member
            ResultSet issueRS = lk.jiat.neolibrary.connection.MySQL.executeSearch(
                "SELECT * FROM issue_records WHERE member_id = '" + memberId + 
                "' AND book_id = '" + bookId + "' AND return_data IS NULL"
            );
            if (!issueRS.next()) {
                JOptionPane.showMessageDialog(this, 
                    "This book is not currently issued to this member.", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Update issue_records with return date
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String returnDate = sdf.format(new java.util.Date());
            
            String updateIssueSql = "UPDATE issue_records SET return_data = '" + returnDate + 
                "' WHERE member_id = '" + memberId + "' AND book_id = '" + bookId + 
                "' AND return_data IS NULL";
            lk.jiat.neolibrary.connection.MySQL.executeIUD(updateIssueSql);
            
            // Update book status to AVAILABLE
            String updateBookSql = "UPDATE book SET b_status_id = '" + 
                lk.jiat.neolibrary.entity.BookStatus.OWNED.getId() + 
                "' WHERE book_id = '" + bookId + "'";
            lk.jiat.neolibrary.connection.MySQL.executeIUD(updateBookSql);
            
            JOptionPane.showMessageDialog(this, 
                "Book successfully returned!", 
                "Success", 
                JOptionPane.INFORMATION_MESSAGE);
            
            // Clear fields
            memberIdField.setText("");
            bookIdField.setText("");
            
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, 
                "Failed to return book: " + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, 
                "Please enter valid numeric IDs.", 
                "Validation Error", 
                JOptionPane.WARNING_MESSAGE);
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
        jLabel8 = new javax.swing.JLabel();
        returnBookBtn = new RoundButton();

        setBackground(new java.awt.Color(0, 30, 51));
        setPreferredSize(new java.awt.Dimension(1792, 1010));

        jLabel1.setFont(new java.awt.Font("Lucida Fax", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 214, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Return Book");

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

        memberIdField.setEditable(true);
        memberIdField.setFont(new java.awt.Font("Dubai Medium", 0, 16)); // NOI18N
        memberIdField.setForeground(new java.awt.Color(255, 255, 255));
        memberIdField.setFocusable(true);
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
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 50);
        jPanel1.add(bookIdField, gridBagConstraints);

        jPanel2.setBackground(new java.awt.Color(0, 30, 51));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jLabel8.setFont(new java.awt.Font("Dubai Medium", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        jPanel2.add(jLabel8, gridBagConstraints);

        returnBookBtn.setBackground(new java.awt.Color(0, 153, 255));
        returnBookBtn.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        returnBookBtn.setForeground(new java.awt.Color(255, 255, 255));
        returnBookBtn.setText("Return Book");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 1732, Short.MAX_VALUE)
                    .addComponent(jSeparator2)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(180, 180, 180)))
                .addGap(30, 30, 30))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(160, 160, 160))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(returnBookBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(590, 590, 590))
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
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(30, 30, 30)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                .addGap(70, 70, 70)
                .addComponent(returnBookBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                .addGap(202, 202, 202))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bookIdField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField memberIdField;
    private javax.swing.JButton returnBookBtn;
    // End of variables declaration//GEN-END:variables
}
