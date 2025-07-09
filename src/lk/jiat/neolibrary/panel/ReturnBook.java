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
    }
    
    private void init(){
        // Modern glassmorphism styling
        this.setBackground(new Color(15, 23, 42)); // Slate-900
        
        // Enhanced field styling
        memberIdField.putClientProperty("JTextField.placeholderText", "Press Enter After Typing");
        bookIdField.putClientProperty("JTextField.placeholderText", "Press Enter After Typing");
        
        // Modern combo box styling
        bookGenreCombo.putClientProperty(FlatClientProperties.STYLE, "borderWidth:1");
        
        // Enhanced date field styling
        // Date fields don't need special styling - they inherit from FlatLaf
        
        // Enhanced typography
        updateTypography();
        
        // Modern form styling
        styleFormComponents();
        
        // Enhanced button styling
        styleButtons();
        
        // Fix panel sizing to prevent overflow
        fixPanelSizing();
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
        
        jLabel11.setFont(new Font("Inter", Font.BOLD, 20));
        jLabel11.setForeground(new Color(241, 245, 249));
        
        // Form labels
        jLabel12.setFont(new Font("Inter", Font.PLAIN, 14));
        jLabel12.setForeground(new Color(203, 213, 225));
        
        jLabel13.setFont(new Font("Inter", Font.PLAIN, 14));
        jLabel13.setForeground(new Color(203, 213, 225));
        
        jLabel14.setFont(new Font("Inter", Font.PLAIN, 14));
        jLabel14.setForeground(new Color(203, 213, 225));
        
        jLabel3.setFont(new Font("Inter", Font.PLAIN, 14));
        jLabel3.setForeground(new Color(203, 213, 225));
        
        jLabel4.setFont(new Font("Inter", Font.PLAIN, 14));
        jLabel4.setForeground(new Color(203, 213, 225));
        
        jLabel5.setFont(new Font("Inter", Font.PLAIN, 14));
        jLabel5.setForeground(new Color(203, 213, 225));
        
        jLabel10.setFont(new Font("Inter", Font.PLAIN, 14));
        jLabel10.setForeground(new Color(203, 213, 225));
        
        jLabel7.setFont(new Font("Inter", Font.PLAIN, 14));
        jLabel7.setForeground(new Color(203, 213, 225));
        
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
        
        memberNameField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(71, 85, 105), 1),
            BorderFactory.createEmptyBorder(10, 15, 10, 15)
        ));
        memberNameField.setBackground(new Color(30, 41, 59));
        memberNameField.setForeground(new Color(241, 245, 249));
        memberNameField.setFont(new Font("Inter", Font.PLAIN, 14));
        
        mobileField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(71, 85, 105), 1),
            BorderFactory.createEmptyBorder(10, 15, 10, 15)
        ));
        mobileField.setBackground(new Color(30, 41, 59));
        mobileField.setForeground(new Color(241, 245, 249));
        mobileField.setFont(new Font("Inter", Font.PLAIN, 14));
        
        bookIdField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(71, 85, 105), 1),
            BorderFactory.createEmptyBorder(10, 15, 10, 15)
        ));
        bookIdField.setBackground(new Color(30, 41, 59));
        bookIdField.setForeground(new Color(241, 245, 249));
        bookIdField.setFont(new Font("Inter", Font.PLAIN, 14));
        
        bookTitleField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(71, 85, 105), 1),
            BorderFactory.createEmptyBorder(10, 15, 10, 15)
        ));
        bookTitleField.setBackground(new Color(30, 41, 59));
        bookTitleField.setForeground(new Color(241, 245, 249));
        bookTitleField.setFont(new Font("Inter", Font.PLAIN, 14));
        
        bookAuthorField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(71, 85, 105), 1),
            BorderFactory.createEmptyBorder(10, 15, 10, 15)
        ));
        bookAuthorField.setBackground(new Color(30, 41, 59));
        bookAuthorField.setForeground(new Color(241, 245, 249));
        bookAuthorField.setFont(new Font("Inter", Font.PLAIN, 14));
        
        // Enhanced combo box styling
        bookGenreCombo.setFont(new Font("Inter", Font.PLAIN, 14));
        bookGenreCombo.setForeground(new Color(241, 245, 249));
        bookGenreCombo.setBackground(new Color(30, 41, 59));
        
        // Enhanced date field styling
        borrowedDate.setFont(new Font("Inter", Font.PLAIN, 14));
        borrowedDate.setForeground(new Color(241, 245, 249));
        borrowedDate.setBackground(new Color(30, 41, 59));
        
        returnDate.setFont(new Font("Inter", Font.PLAIN, 14));
        returnDate.setForeground(new Color(241, 245, 249));
        returnDate.setBackground(new Color(30, 41, 59));
    }
    
    private void styleButtons() {
        // Enhanced button styling
        returnBookBtn.setFont(new Font("Inter", Font.BOLD, 16));
        returnBookBtn.setPreferredSize(new java.awt.Dimension(180, 45));
    }
    
    private void loadGenres() {
        try {
            ResultSet rs = lk.jiat.neolibrary.connection.MySQL.executeSearch(
                "SELECT genre_id, genre_name FROM genre ORDER BY genre_name"
            );
            
            Vector<String> genres = new Vector<>();
            while (rs.next()) {
                genres.add(rs.getString("genre_name"));
            }
            
            bookGenreCombo.setModel(new DefaultComboBoxModel<>(genres));
            
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading genres.", "Error", JOptionPane.ERROR_MESSAGE);
        }
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
    }
    
    private void loadMember() {
        String memberId = memberIdField.getText().trim();
        try {
            ResultSet memberRS = lk.jiat.neolibrary.connection.MySQL.executeSearch(
                "SELECT * FROM member WHERE member_id = '" + memberId + "'"
            );
            if (memberRS.next()) {
                memberNameField.setText(memberRS.getString("fname") + " " + memberRS.getString("lname"));
                mobileField.setText(memberRS.getString("mobile"));
            } else {
                JOptionPane.showMessageDialog(null,
                    "Enter valid member ID.",
                    "Data Loading Error",
                    JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private void loadBook() {
        String bookId = bookIdField.getText().trim();
        try {
            ResultSet bookRS = lk.jiat.neolibrary.connection.MySQL.executeSearch(
                "SELECT b.*, g.genre_name FROM book b " +
                "INNER JOIN genre g ON b.genre_id = g.genre_id " +
                "WHERE b.book_id = '" + bookId + "'"
            );
            if (bookRS.next()) {
                bookTitleField.setText(bookRS.getString("title"));
                bookAuthorField.setText(bookRS.getString("author"));
                bookGenreCombo.setSelectedItem(bookRS.getString("genre_name"));
            } else {
                JOptionPane.showMessageDialog(null,
                    "Enter valid book ID.",
                    "Data Loading Error",
                    JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
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

        memberIdField.setEditable(false);
        memberIdField.setFont(new java.awt.Font("Dubai Medium", 0, 16)); // NOI18N
        memberIdField.setForeground(new java.awt.Color(255, 255, 255));
        memberIdField.setFocusable(false);
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
