/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package lk.jiat.neolibrary.dialog;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import lk.jiat.neolibrary.component.RoundButton;
import lk.jiat.neolibrary.entity.Gender;
import lk.jiat.neolibrary.entity.UserRole;
import lk.jiat.neolibrary.validation.Validator;
import lk.jiat.neolibrary.connection.MySQL;
import lk.jiat.neolibrary.entity.UserStatus;
import raven.toast.Notifications;

/**
 *
 * @author Yashitha
 */
public class Register extends javax.swing.JDialog {

    /**
     * Creates new form Register
     */
    
    private java.awt.Frame selectScreen;
    
    public Register(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        FlatDarkLaf.setup();
        initComponents();
        init();
        this.selectScreen = parent;
        loadUserRole();

    }

    private void init() {
        // Set modern background
        this.getContentPane().setBackground(new Color(17, 24, 39)); // Dark blue-gray
        jPanel1.setBackground(new Color(17, 24, 39));
        jPanel2.setBackground(new Color(17, 24, 39));
        
        FlatSVGIcon icon = new FlatSVGIcon("lk/jiat/neolibrary/images/logo.svg",
                logo.getWidth(),
                logo.getHeight());
        logo.setIcon(icon);
        this.setIconImage(icon.getImage());
        
        // Update typography and styling
        updateTypography();
        styleFormComponents();
    }
    
    private void updateTypography() {
        // Title
        jLabel1.setFont(new Font("Segoe UI", Font.BOLD, 32));
        jLabel1.setForeground(new Color(255, 255, 255));
        
        // Form labels
        jLabel2.setFont(new Font("Segoe UI", Font.BOLD, 14));
        jLabel2.setForeground(new Color(243, 244, 246));
        
        jLabel3.setFont(new Font("Segoe UI", Font.BOLD, 14));
        jLabel3.setForeground(new Color(243, 244, 246));
        
        jLabel4.setFont(new Font("Segoe UI", Font.BOLD, 14));
        jLabel4.setForeground(new Color(243, 244, 246));
        
        jLabel5.setFont(new Font("Segoe UI", Font.BOLD, 14));
        jLabel5.setForeground(new Color(243, 244, 246));
        
        jLabel6.setFont(new Font("Segoe UI", Font.BOLD, 14));
        jLabel6.setForeground(new Color(243, 244, 246));
        
        jLabel7.setFont(new Font("Segoe UI", Font.BOLD, 14));
        jLabel7.setForeground(new Color(243, 244, 246));
    }
    
    private void styleFormComponents() {
        // Style text fields
        styleTextField(firstNameField);
        styleTextField(lastNameField);
        styleTextField(emailAddressField);
        stylePasswordField(passwordField);
        
        // Style radio buttons
        maleRadio.setBackground(new Color(17, 24, 39));
        maleRadio.setForeground(new Color(243, 244, 246));
        maleRadio.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        
        femaleRadio.setBackground(new Color(17, 24, 39));
        femaleRadio.setForeground(new Color(243, 244, 246));
        femaleRadio.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        
        // Style combo box
        userRoleCombo.setBackground(new Color(55, 65, 81));
        userRoleCombo.setForeground(new Color(243, 244, 246));
        userRoleCombo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        userRoleCombo.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(75, 85, 99), 1),
            BorderFactory.createEmptyBorder(8, 12, 8, 12)
        ));
        
        // Style register button - removed direct color setting
        registerBtn.setFont(new Font("Segoe UI", Font.BOLD, 16));
        registerBtn.setBorder(BorderFactory.createEmptyBorder(12, 24, 12, 24));
    }
    
    private void styleTextField(javax.swing.JTextField textField) {
        textField.setBackground(new Color(55, 65, 81));
        textField.setForeground(new Color(243, 244, 246));
        textField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(75, 85, 99), 1),
            BorderFactory.createEmptyBorder(8, 12, 8, 12)
        ));
        textField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
    }
    
    private void stylePasswordField(javax.swing.JPasswordField passwordField) {
        passwordField.setBackground(new Color(55, 65, 81));
        passwordField.setForeground(new Color(243, 244, 246));
        passwordField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(75, 85, 99), 1),
            BorderFactory.createEmptyBorder(8, 12, 8, 12)
        ));
        passwordField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
    }

    private void loadUserRole() {
        UserRole[] role = UserRole.values();
        userRoleCombo.removeAllItems();
        userRoleCombo.addItem("Select User Role");
        for (UserRole ur : role) {
            userRoleCombo.addItem(String.valueOf(ur));
        }
    }

    private int getGender() {
        int genderId = 0;
        if (maleRadio.isSelected()) {
            genderId = Gender.MALE.getId();
        } else if (femaleRadio.isSelected()) {
            genderId = Gender.FEMALE.getId();
        }
        return genderId;
    }

    private void insertUserData() {
        String firstName = firstNameField.getText().trim();
        String lastName = lastNameField.getText().trim();
        String email = emailAddressField.getText().trim();
        String password = String.valueOf(passwordField.getPassword());
        int gender = getGender();
        int userRole = userRoleCombo.getSelectedIndex();

        if (!Validator.isInputFieldValid(firstName)) {
            return;
        }
        if (!Validator.isInputFieldValid(lastName)) {
            return;
        }
        if (!Validator.isEmailValid(email)) {
            return;
        }
        if (!Validator.isPasswordValid(password)) {
            return;
        }
        if (!Validator.isIndexValid(gender)) {
            return;
        }
        if (!Validator.isIndexValid(userRole)) {
            return;
        }

        try {
            ResultSet emailExists = MySQL.executeSearch("SELECT `email` FROM `user` WHERE `user`.`email` = '" + email + "'");
            if (emailExists.next()) {
                Notifications.getInstance().show(Notifications.Type.ERROR,
                        Notifications.Location.TOP_CENTER,
                        5000,
                        "OOPS!...Email Address already exists.");
            } else {
                MySQL.executeIUD("INSERT INTO `user` (`fname`,`lname`,`email`,`password`,`gender_id`,`role_id`,`status_id`) "
                        + "VALUES ('" + firstName + "','" + lastName + "','" + email + "','" + password + "','" + gender + "','" + userRole + "','"+UserStatus.ACTIVE.getId()+"')");

                Notifications.getInstance().show(Notifications.Type.SUCCESS,
                        Notifications.Location.TOP_CENTER,
                        5000,
                        "User Registration Successful.");
                this.dispose();
                new Login(selectScreen, true).setVisible(true);

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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        firstNameField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        lastNameField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        emailAddressField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        maleRadio = new javax.swing.JRadioButton();
        femaleRadio = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        userRoleCombo = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        registerBtn = new RoundButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("zlibrary | Register");
        setIconImage(null);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Lucida Fax", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("REGISTER");

        logo.setForeground(new java.awt.Color(255, 255, 255));

        java.awt.GridBagLayout jPanel2Layout = new java.awt.GridBagLayout();
        jPanel2Layout.columnWidths = new int[] {214, 214};
        jPanel2.setLayout(jPanel2Layout);

        jLabel2.setFont(new java.awt.Font("Dubai Medium", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("First Name");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 30, 5, 10);
        jPanel2.add(jLabel2, gridBagConstraints);

        firstNameField.setFont(new java.awt.Font("Dubai Medium", 0, 16)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 30, 5, 10);
        jPanel2.add(firstNameField, gridBagConstraints);

        jLabel5.setFont(new java.awt.Font("Dubai Medium", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Last Name");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 5, 30);
        jPanel2.add(jLabel5, gridBagConstraints);

        lastNameField.setFont(new java.awt.Font("Dubai Medium", 0, 16)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 5, 30);
        jPanel2.add(lastNameField, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Dubai Medium", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Email Address");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 30, 5, 30);
        jPanel2.add(jLabel4, gridBagConstraints);

        emailAddressField.setFont(new java.awt.Font("Dubai Medium", 0, 16)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 30, 5, 30);
        jPanel2.add(emailAddressField, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Dubai Medium", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Password");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 30, 5, 30);
        jPanel2.add(jLabel3, gridBagConstraints);

        passwordField.setFont(new java.awt.Font("Dubai Medium", 0, 16)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 30, 5, 30);
        jPanel2.add(passwordField, gridBagConstraints);

        buttonGroup1.add(maleRadio);
        maleRadio.setFont(new java.awt.Font("Dubai Medium", 0, 16)); // NOI18N
        maleRadio.setForeground(new java.awt.Color(255, 255, 255));
        maleRadio.setText("Male");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 30, 5, 10);
        jPanel2.add(maleRadio, gridBagConstraints);

        buttonGroup1.add(femaleRadio);
        femaleRadio.setFont(new java.awt.Font("Dubai Medium", 0, 16)); // NOI18N
        femaleRadio.setForeground(new java.awt.Color(255, 255, 255));
        femaleRadio.setText("Female");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 5, 30);
        jPanel2.add(femaleRadio, gridBagConstraints);

        jLabel6.setFont(new java.awt.Font("Dubai Medium", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Gender");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 30, 5, 30);
        jPanel2.add(jLabel6, gridBagConstraints);

        userRoleCombo.setFont(new java.awt.Font("Dubai Medium", 0, 16)); // NOI18N
        userRoleCombo.setForeground(new java.awt.Color(255, 255, 255));
        userRoleCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Librarian" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 5, 30);
        jPanel2.add(userRoleCombo, gridBagConstraints);

        jLabel7.setFont(new java.awt.Font("Dubai Medium", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Role");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 30, 5, 10);
        jPanel2.add(jLabel7, gridBagConstraints);

        registerBtn.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        registerBtn.setText("Register");
        registerBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        registerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 6;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(30, 30, 5, 30);
        jPanel2.add(registerBtn, gridBagConstraints);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void registerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerBtnActionPerformed
        insertUserData();
    }//GEN-LAST:event_registerBtnActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField emailAddressField;
    private javax.swing.JRadioButton femaleRadio;
    private javax.swing.JTextField firstNameField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField lastNameField;
    private javax.swing.JLabel logo;
    private javax.swing.JRadioButton maleRadio;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JButton registerBtn;
    private javax.swing.JComboBox<String> userRoleCombo;
    // End of variables declaration//GEN-END:variables
}
