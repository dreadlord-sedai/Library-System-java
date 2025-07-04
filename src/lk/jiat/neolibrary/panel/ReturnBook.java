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
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        memberNameField = new FormattedTextField();
        memberIdField = new FormattedTextField();
        mobileField = new FormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        bookTitleField = new FormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        bookAuthorField = new FormattedTextField();
        bookIdField = new FormattedTextField();
        bookGenreCombo = new javax.swing.JComboBox<>();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        returnDate = new javax.swing.JFormattedTextField();
        borrowedDate = new javax.swing.JFormattedTextField();
        jLabel11 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
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

        jLabel12.setFont(new java.awt.Font("Dubai Medium", 0, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Lender Name");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 50);
        jPanel3.add(jLabel12, gridBagConstraints);

        jLabel13.setFont(new java.awt.Font("Dubai Medium", 0, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Membership ID");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 50);
        jPanel3.add(jLabel13, gridBagConstraints);

        jLabel14.setFont(new java.awt.Font("Dubai Medium", 0, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Contact Number");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        jPanel3.add(jLabel14, gridBagConstraints);

        memberNameField.setEditable(false);
        memberNameField.setFont(new java.awt.Font("Dubai Medium", 0, 16)); // NOI18N
        memberNameField.setForeground(new java.awt.Color(255, 255, 255));
        memberNameField.setFocusable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 50);
        jPanel3.add(memberNameField, gridBagConstraints);

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

        mobileField.setEditable(false);
        mobileField.setFont(new java.awt.Font("Dubai Medium", 0, 16)); // NOI18N
        mobileField.setForeground(new java.awt.Color(255, 255, 255));
        mobileField.setFocusable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        jPanel3.add(mobileField, gridBagConstraints);

        jLabel6.setFont(new java.awt.Font("Dubai Medium", 1, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Book Infromation");

        jSeparator2.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator2.setFont(new java.awt.Font("Dubai Medium", 1, 18)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(0, 30, 51));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel4.setFont(new java.awt.Font("Dubai Medium", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Author");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 50);
        jPanel1.add(jLabel4, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Dubai Medium", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Title");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 50);
        jPanel1.add(jLabel3, gridBagConstraints);

        bookTitleField.setEditable(false);
        bookTitleField.setFont(new java.awt.Font("Dubai Medium", 0, 16)); // NOI18N
        bookTitleField.setForeground(new java.awt.Color(255, 255, 255));
        bookTitleField.setFocusable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 50);
        jPanel1.add(bookTitleField, gridBagConstraints);

        jLabel5.setFont(new java.awt.Font("Dubai Medium", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Book ID");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 50);
        jPanel1.add(jLabel5, gridBagConstraints);

        jLabel10.setFont(new java.awt.Font("Dubai Medium", 0, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Genre");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        jPanel1.add(jLabel10, gridBagConstraints);

        bookAuthorField.setEditable(false);
        bookAuthorField.setFont(new java.awt.Font("Dubai Medium", 0, 16)); // NOI18N
        bookAuthorField.setForeground(new java.awt.Color(255, 255, 255));
        bookAuthorField.setFocusable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 50);
        jPanel1.add(bookAuthorField, gridBagConstraints);

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

        bookGenreCombo.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        bookGenreCombo.setForeground(new java.awt.Color(255, 255, 255));
        // Remove hardcoded genres - will be loaded from database
        bookGenreCombo.setEnabled(false);
        bookGenreCombo.setFocusable(false);
        bookGenreCombo.setPreferredSize(new java.awt.Dimension(72, 34));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        jPanel1.add(bookGenreCombo, gridBagConstraints);

        jSeparator3.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator3.setFont(new java.awt.Font("Dubai Medium", 1, 18)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(0, 30, 51));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jLabel7.setFont(new java.awt.Font("Dubai Medium", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Borrowed Date");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 50);
        jPanel2.add(jLabel7, gridBagConstraints);

        jLabel8.setFont(new java.awt.Font("Dubai Medium", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Return Date");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        jPanel2.add(jLabel8, gridBagConstraints);

        returnDate.setEditable(false);
        returnDate.setForeground(new java.awt.Color(255, 255, 255));
        returnDate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("MMM d,y | EEEE,h:mm a"))));
        returnDate.setFocusable(false);
        returnDate.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        returnDate.setPreferredSize(new java.awt.Dimension(126, 34));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        jPanel2.add(returnDate, gridBagConstraints);

        borrowedDate.setEditable(false);
        borrowedDate.setForeground(new java.awt.Color(255, 255, 255));
        borrowedDate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("MMM d,y | EEEE,h:mm a"))));
        borrowedDate.setFocusable(false);
        borrowedDate.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        borrowedDate.setPreferredSize(new java.awt.Dimension(126, 34));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 50);
        jPanel2.add(borrowedDate, gridBagConstraints);

        jLabel11.setFont(new java.awt.Font("Dubai Medium", 1, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Lending Details");

        jSeparator4.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator4.setFont(new java.awt.Font("Dubai Medium", 1, 18)); // NOI18N

        returnBookBtn.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        returnBookBtn.setText("Return Book");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(returnBookBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(returnBookBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bookAuthorField;
    private javax.swing.JComboBox<String> bookGenreCombo;
    private javax.swing.JTextField bookIdField;
    private javax.swing.JTextField bookTitleField;
    private javax.swing.JFormattedTextField borrowedDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextField memberIdField;
    private javax.swing.JTextField memberNameField;
    private javax.swing.JTextField mobileField;
    private javax.swing.JButton returnBookBtn;
    private javax.swing.JFormattedTextField returnDate;
    // End of variables declaration//GEN-END:variables
}
