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
import lk.jiat.neolibrary.validation.Validator;
import lk.jiat.neolibrary.connection.MySQL;
import lk.jiat.neolibrary.gui.Home;
import raven.toast.Notifications;

/**
 *
 * @author Yashitha
 */
public class Login extends javax.swing.JDialog {

    /**
     * Creates new form Login
     */
    private java.awt.Frame selecScreen;

    public Login(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        FlatDarkLaf.setup();
        initComponents();
        init();
        this.selecScreen = parent;
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
    }
    
    private void styleFormComponents() {
        // Style text fields
        emailAddressField.setBackground(new Color(55, 65, 81));
        emailAddressField.setForeground(new Color(243, 244, 246));
        emailAddressField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(75, 85, 99), 1),
            BorderFactory.createEmptyBorder(8, 12, 8, 12)
        ));
        emailAddressField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        
        passwordField.setBackground(new Color(55, 65, 81));
        passwordField.setForeground(new Color(243, 244, 246));
        passwordField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(75, 85, 99), 1),
            BorderFactory.createEmptyBorder(8, 12, 8, 12)
        ));
        passwordField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        
        // Style login button
        loginBtn.setBackground(new Color(99, 102, 241));
        loginBtn.setForeground(new Color(255, 255, 255));
        loginBtn.setFont(new Font("Segoe UI", Font.BOLD, 16));
        loginBtn.setBorder(BorderFactory.createEmptyBorder(12, 24, 12, 24));
    }

    private void login() {
        String email = emailAddressField.getText().trim();
        String password = String.valueOf(passwordField.getPassword());

        if (!Validator.isEmailValid(email)) {
            return;
        }
        if (!Validator.isPasswordValid(password)) {
            return;
        }

        try {
            ResultSet userExists = MySQL.executeSearch("SELECT * FROM `user` INNER JOIN `role` ON `user`.`role_id` = `role`.`role_id` WHERE "
                    + "`user`.`email` = '" + email + "' AND `user`.`password` = '" + password + "'");
            if (userExists.next()) {
                if (userExists.getInt("user.status_id") == 1) {
                    String userRole = userExists.getString("role_name");
                    String userName = userExists.getString("fname");
                    Notifications.getInstance().show(Notifications.Type.SUCCESS,
                            Notifications.Location.TOP_CENTER,
                            5000,
                            "Login Successful.");
                    new Home(userName, userRole).setVisible(true);
                    this.dispose();
                    this.selecScreen.dispose();
                }else{
                    Notifications.getInstance().show(Notifications.Type.ERROR,
                            Notifications.Location.TOP_CENTER,
                            5000,
                            "You are Inactive. Please contact Admin.");
                    emailAddressField.setText(null);
                    passwordField.setText(null);
                }

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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        emailAddressField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        loginBtn = new RoundButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("zlibrary | Login");
        setPreferredSize(new java.awt.Dimension(403, 531));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Lucida Fax", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LOGIN");

        logo.setForeground(new java.awt.Color(255, 255, 255));

        jPanel2.setLayout(new java.awt.GridLayout(4, 1, 0, 8));

        jLabel2.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Email Address");
        jPanel2.add(jLabel2);

        emailAddressField.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jPanel2.add(emailAddressField);

        jLabel3.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Password");
        jPanel2.add(jLabel3);

        passwordField.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jPanel2.add(passwordField);

        loginBtn.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        loginBtn.setText("Login");
        loginBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        loginBtn.setPreferredSize(new java.awt.Dimension(70, 50));
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(141, 141, 141))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(loginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(12, 12, 12)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(loginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(141, 141, 141))
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

    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtnActionPerformed
        login();
    }//GEN-LAST:event_loginBtnActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField emailAddressField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton loginBtn;
    private javax.swing.JLabel logo;
    private javax.swing.JPasswordField passwordField;
    // End of variables declaration//GEN-END:variables
}
