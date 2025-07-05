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
import lk.jiat.neolibrary.entity.Genre;
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
        
        // Main content panel styling
        mainContentPanel.setBackground(new Color(15, 23, 42)); // Slate-900
        
        // Enhanced scroll pane styling
        mainScrollPane.putClientProperty(FlatClientProperties.STYLE, "arc:0; borderWidth:0");
        
        // Modern combo box styling
        bookGenreCombo.putClientProperty(FlatClientProperties.STYLE, "arc:12; borderWidth:1");
        
        // Enhanced field styling
        memberIdField.putClientProperty("JTextField.placeholderText", "Press Enter After Typing");
        bookIdField.putClientProperty("JTextField.placeholderText", "Press Enter After Typing");
        
        // Enhanced date field styling
        lendDateField.putClientProperty(FlatClientProperties.STYLE, "arc:12; borderWidth:1");
        dueDateField.putClientProperty(FlatClientProperties.STYLE, "arc:12; borderWidth:1");
        
        // Enhanced typography
        updateTypography();
        
        // Modern form styling
        styleFormComponents();
        
        // Modern button styling
        styleButtons();
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
        
        moblieField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(71, 85, 105), 1),
            BorderFactory.createEmptyBorder(10, 15, 10, 15)
        ));
        moblieField.setBackground(new Color(30, 41, 59));
        moblieField.setForeground(new Color(241, 245, 249));
        moblieField.setFont(new Font("Inter", Font.PLAIN, 14));
        
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
        lendDateField.setFont(new Font("Inter", Font.PLAIN, 14));
        lendDateField.setForeground(new Color(241, 245, 249));
        lendDateField.setBackground(new Color(30, 41, 59));
        
        dueDateField.setFont(new Font("Inter", Font.PLAIN, 14));
        dueDateField.setForeground(new Color(241, 245, 249));
        dueDateField.setBackground(new Color(30, 41, 59));
    }
    
    private void styleButtons() {
        // Enhanced button styling
        lendBookBtn.setFont(new Font("Inter", Font.BOLD, 16));
        lendBookBtn.setPreferredSize(new java.awt.Dimension(180, 45));
    }
    
    private void loadMember() {
        String memberId = memberIdField.getText().trim();
        try {
            ResultSet memberRS = MySQL.executeSearch("SELECT * FROM `member` WHERE `member_id` = '" + memberId + "';");
            if (memberRS.next()) {
                memberNameField.setText(memberRS.getString("fname") + memberRS.getString("lname"));
                moblieField.setText(memberRS.getString("mobile"));
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
        Genre[] genreArray = Genre.values();
        bookGenreCombo.addItem("Type Book ID");
        for (Genre genre : genreArray) {
            bookGenreCombo.addItem(genre.toString());
        }
    }
    
    private Date issueDate;
    private Date due;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    private void loadBookAndDate() {
        String bookId = bookIdField.getText().trim();
        try {
            ResultSet bookRS = MySQL.executeSearch("SELECT * FROM `book` WHERE `book_id` = '" + bookId + "';");
            if (bookRS.next()) {
                bookTitleField.setText(bookRS.getString("title"));
                bookGenreCombo.setSelectedIndex(bookRS.getInt("genre_id"));
                bookAuthorField.setText(bookRS.getString("Author"));
                
                String duration = MySQL.getAppProperties().getProperty("lend.duration");
                
                LocalDateTime lendDate = LocalDateTime.now();
                LocalDateTime dueDate = lendDate.plusDays(Long.parseLong(duration));
                
                issueDate = Date.from(lendDate.atZone(ZoneId.systemDefault()).toInstant());
                System.out.println(issueDate);
                due = Date.from(dueDate.atZone(ZoneId.systemDefault()).toInstant());
                
                lendDateField.setValue(issueDate);
                dueDateField.setValue(due);
                
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
        if (!Validator.isInputFieldValid(memberIdField.getText())) {
            return;
        }
        if (!Validator.isInputFieldValid(bookIdField.getText())) {
            return;
        }
        
        Integer memberId = Integer.valueOf(memberIdField.getText());
        Integer bookId = Integer.valueOf(bookIdField.getText());
        try {
            MySQL.executeIUD("INSERT INTO `issue_records` (`issue_date`,`due_date`,`member_id`,`book_id`) VALUES ('" + sdf.format(issueDate) + "','" + sdf.format(due) + "','" + memberId + "','" + bookId + "');");
            MySQL.executeIUD("UPDATE `book` SET `b_status_id` = '" + BookStatus.ISSUED.getId() + "' WHERE `book_id` = '" + bookId + "'");
            // Refresh the books table by triggering a reload
            // The Books panel will handle its own table refresh
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
        moblieField = new FormattedTextField();
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
        jLabel11 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lendDateField = new javax.swing.JFormattedTextField();
        dueDateField = new javax.swing.JFormattedTextField();
        jSeparator4 = new javax.swing.JSeparator();
        lendBookBtn = new RoundButton();
        
        // Main content panel for scrolling
        mainContentPanel = new javax.swing.JPanel();
        mainScrollPane = new javax.swing.JScrollPane();

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

        moblieField.setEditable(false);
        moblieField.setFont(new java.awt.Font("Dubai Medium", 0, 16)); // NOI18N
        moblieField.setForeground(new java.awt.Color(255, 255, 255));
        moblieField.setFocusable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        jPanel3.add(moblieField, gridBagConstraints);

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
        jLabel3.setText("Book Title");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
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
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 50);
        jPanel1.add(bookTitleField, gridBagConstraints);

        jLabel5.setFont(new java.awt.Font("Dubai Medium", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Book ID");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
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

        bookGenreCombo.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        bookGenreCombo.setForeground(new java.awt.Color(255, 255, 255));
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

        jLabel11.setFont(new java.awt.Font("Dubai Medium", 1, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Lending Details");

        jSeparator3.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator3.setFont(new java.awt.Font("Dubai Medium", 1, 18)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(0, 30, 51));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jLabel7.setFont(new java.awt.Font("Dubai Medium", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Lending Date");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 50);
        jPanel2.add(jLabel7, gridBagConstraints);

        jLabel8.setFont(new java.awt.Font("Dubai Medium", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Due Date");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        jPanel2.add(jLabel8, gridBagConstraints);

        lendDateField.setEditable(false);
        lendDateField.setForeground(new java.awt.Color(255, 255, 255));
        lendDateField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("MMM d,y | EEEE,h:mm a"))));
        lendDateField.setFocusable(false);
        lendDateField.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        lendDateField.setPreferredSize(new java.awt.Dimension(126, 34));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 50);
        jPanel2.add(lendDateField, gridBagConstraints);

        dueDateField.setEditable(false);
        dueDateField.setForeground(new java.awt.Color(255, 255, 255));
        dueDateField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("MMM d,y | EEEE,h:mm a"))));
        dueDateField.setFocusable(false);
        dueDateField.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        dueDateField.setPreferredSize(new java.awt.Dimension(126, 34));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        jPanel2.add(dueDateField, gridBagConstraints);

        jSeparator4.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator4.setFont(new java.awt.Font("Dubai Medium", 1, 18)); // NOI18N

        lendBookBtn.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        lendBookBtn.setText("Lend a Book");
        lendBookBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lendBookBtnActionPerformed(evt);
            }
        });

        // Main content panel layout
        javax.swing.GroupLayout mainContentPanelLayout = new javax.swing.GroupLayout(mainContentPanel);
        mainContentPanel.setLayout(mainContentPanelLayout);
        mainContentPanelLayout.setHorizontalGroup(
            mainContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainContentPanelLayout.createSequentialGroup()
                .addGroup(mainContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(mainContentPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lendBookBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainContentPanelLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(mainContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator2)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 1083, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator3)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 1732, Short.MAX_VALUE)
                            .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.LEADING))))
                .addGap(30, 30, 30))
            .addGroup(mainContentPanelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(160, 160, 160))
        );
        mainContentPanelLayout.setVerticalGroup(
            mainContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainContentPanelLayout.createSequentialGroup()
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
                .addGap(30, 30, 30)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                .addGap(30, 30, 30)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(lendBookBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        // Set the main content panel as the viewport of the scroll pane
        mainScrollPane.setViewportView(mainContentPanel);
        mainScrollPane.setHorizontalScrollBarPolicy(javax.swing.JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        mainScrollPane.setVerticalScrollBarPolicy(javax.swing.JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        // Main panel layout (just the scroll pane)
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1792, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1010, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void memberIdFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memberIdFieldActionPerformed
        loadMember();
        memberIdField.setFocusable(false);
        memberIdField.setFocusable(true);
    }//GEN-LAST:event_memberIdFieldActionPerformed

    private void bookIdFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookIdFieldActionPerformed
        loadBookAndDate();
        bookIdField.setFocusable(false);
        bookIdField.setFocusable(true);
    }//GEN-LAST:event_bookIdFieldActionPerformed

    private void lendBookBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lendBookBtnActionPerformed
        lendBook();
    }//GEN-LAST:event_lendBookBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bookAuthorField;
    private javax.swing.JComboBox<String> bookGenreCombo;
    private javax.swing.JTextField bookIdField;
    private javax.swing.JTextField bookTitleField;
    private javax.swing.JFormattedTextField dueDateField;
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
    private javax.swing.JButton lendBookBtn;
    private javax.swing.JFormattedTextField lendDateField;
    private javax.swing.JTextField memberIdField;
    private javax.swing.JTextField memberNameField;
    private javax.swing.JTextField moblieField;
    private javax.swing.JPanel mainContentPanel;
    private javax.swing.JScrollPane mainScrollPane;
    // End of variables declaration//GEN-END:variables
}
