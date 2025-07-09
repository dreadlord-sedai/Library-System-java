/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package lk.jiat.neolibrary.panel;

import com.formdev.flatlaf.FlatClientProperties;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.table.DefaultTableModel;
import lk.jiat.neolibrary.component.FormattedTable;
import lk.jiat.neolibrary.component.FormattedTextField;
import lk.jiat.neolibrary.component.RoundButton;
import lk.jiat.neolibrary.connection.MySQL;
import lk.jiat.neolibrary.dialog.AddMember;
import lk.jiat.neolibrary.entity.UserStatus;
import lk.jiat.neolibrary.gui.Home;
import lk.jiat.neolibrary.validation.Validator;
import java.awt.Color;
import java.awt.Font;

/**
 *
 * @author Yashitha
 */
public class Members extends javax.swing.JPanel {

    /**
     * Creates new form Members
     */
    private final Home homeScreen;
    private final HashMap<String, String> searchByMap;
    private final String BASE_QUERY = "SELECT * FROM `member` INNER JOIN `gender` ON `member`.`gender_id` = `gender`.`gender_id` "
            + "INNER JOIN `status` ON `member`.`status_id` = `status`.`status_id`";
    private String query;

    public Members(Home parent) {
        initComponents();
        this.homeScreen = parent;
        this.searchByMap = new HashMap();
        this.query = BASE_QUERY + " ORDER BY `member_id` ASC";
        init();
        loadStatus();
        loadSearchBy();
        loadData();
    }

    private void init() {
        // Modern glassmorphism styling
        this.setBackground(new Color(15, 23, 42)); // Slate-900
        
        // Enhanced scroll pane styling
        // jScrollPane2.putClientProperty(FlatClientProperties.STYLE, "arc:20");
        
        // Modern combo box styling
        searchByCombo.putClientProperty(FlatClientProperties.STYLE, "borderWidth:1");
        memberStatusCombo.putClientProperty(FlatClientProperties.STYLE, "borderWidth:1");
        
        // Enhanced search field styling
        memberSearchField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(71, 85, 105), 1),
            BorderFactory.createEmptyBorder(10, 15, 10, 15)
        ));
        memberSearchField.setBackground(new Color(30, 41, 59));
        memberSearchField.setForeground(new Color(241, 245, 249));
        memberSearchField.setFont(new Font("Inter", Font.PLAIN, 14));
        
        // Modern table styling
        memberListTable.setRowHeight(45);
        memberListTable.setFont(new Font("Inter", Font.PLAIN, 14));
        memberListTable.setForeground(new Color(241, 245, 249));
        memberListTable.setBackground(new Color(30, 41, 59));
        memberListTable.setGridColor(new Color(71, 85, 105));
        
        // Enhanced typography
        updateTypography();
        
        // Modern button styling
        styleButtons();
    }
    
    private void updateTypography() {
        // Header with modern typography
        jLabel1.setFont(new Font("Inter", Font.BOLD, 32));
        jLabel1.setForeground(new Color(248, 250, 252));
        
        // Combo box styling
        searchByCombo.setFont(new Font("Inter", Font.PLAIN, 14));
        searchByCombo.setForeground(new Color(241, 245, 249));
        searchByCombo.setBackground(new Color(30, 41, 59));
        
        memberStatusCombo.setFont(new Font("Inter", Font.PLAIN, 14));
        memberStatusCombo.setForeground(new Color(241, 245, 249));
        memberStatusCombo.setBackground(new Color(30, 41, 59));
    }
    
    private void styleButtons() {
        // Add Member button - green
        addMemberBtn.setUI(null);
        addMemberBtn.putClientProperty("JButton.background", new Color(34, 197, 94));
        addMemberBtn.setBackground(new Color(34, 197, 94));
        addMemberBtn.setOpaque(true);
        addMemberBtn.setContentAreaFilled(true);
        addMemberBtn.repaint();
        // Search button - blue (if exists)
        memberSearchBtn.setUI(null);
        memberSearchBtn.putClientProperty("JButton.background", new Color(59, 130, 246));
        memberSearchBtn.setBackground(new Color(59, 130, 246));
        memberSearchBtn.setOpaque(true);
        memberSearchBtn.setContentAreaFilled(true);
        memberSearchBtn.repaint();
        
        generateReportBtn.setFont(new Font("Inter", Font.BOLD, 14));
        generateReportBtn.setPreferredSize(new java.awt.Dimension(180, 40));
    }

    private void loadStatus() {
        UserStatus[] stats = UserStatus.values();
        memberStatusCombo.removeAllItems();
        memberStatusCombo.addItem("All");
        for (UserStatus status : stats) {
            memberStatusCombo.addItem(String.valueOf(status));
        }
    }

    private void loadSearchBy() {
        searchByCombo.removeAllItems();
        searchByCombo.addItem("Search By");
        for (int i = 0; i < memberListTable.getColumnCount(); i++) {
            searchByCombo.addItem(memberListTable.getColumnName(i));
        }

        searchByMap.put("ID", "`member`.`member_id`");
        searchByMap.put("Name", "USER_NAME");
        searchByMap.put("NIC", "`member`.`nic`");
        searchByMap.put("Email Address", "`member`.`email`");
        searchByMap.put("Mobile Number", "`member`.`mobile`");
        searchByMap.put("Gender", "`gender`.`gender_name`");
        searchByMap.put("Registered Date", "`member`.`Author`");
        searchByMap.put("Status", "`member`.`status_id`");
    }

    private void loadData() {
        ResultSet tableData;
        DefaultTableModel dtm = (DefaultTableModel) memberListTable.getModel();
        try {
            tableData = MySQL.executeSearch(query);
            while (tableData.next()) {
                String dateStr = tableData.getString("registered_date");
                SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                SimpleDateFormat outputFormat = new SimpleDateFormat("dd MMMM, yyyy");

                Date date = inputFormat.parse(dateStr);

                Vector<String> v = new Vector();
                v.add(tableData.getString("member_id"));
                v.add(tableData.getString("fname") + " " + tableData.getString("lname"));
                v.add(tableData.getString("nic"));
                v.add(tableData.getString("email"));
                v.add(tableData.getString("mobile"));
                v.add(tableData.getString("gender_name"));
                v.add(outputFormat.format(date));
                v.add(tableData.getString("status_name"));
                dtm.addRow(v);
            }
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        }

    }
    
    private void searchData() {
        String searchBySelected = searchByCombo.getSelectedItem().toString();
        int statusSelected = memberStatusCombo.getSelectedIndex();
        String column = searchByMap.get(searchBySelected);
        String searchText = memberSearchField.getText();
        if (searchBySelected.equalsIgnoreCase("user_name")) {
            query = BASE_QUERY + "WHERE fname LIKE '%" + searchText + "%' OR lname LIKE '%" + searchText + "%' ORDER BY `member_id` ASC";
        } else if (searchBySelected.equals("Status")) {
            if (statusSelected != 0) {
                query = BASE_QUERY + " WHERE " + column + " = '" + statusSelected + "' ORDER BY `member_id` ASC;";
            } else {
                query = BASE_QUERY + " ORDER BY `member_id` ASC";
            }
        } else {
            query = BASE_QUERY + " WHERE " + column + " LIKE '" + searchText + "%' ORDER BY `member_id` ASC;";
        }
        
        
        DefaultTableModel dtm = (DefaultTableModel) memberListTable.getModel();
        dtm.setRowCount(0);

        loadData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        memberSearchField = new FormattedTextField(true);
        memberSearchBtn = new RoundButton();
        addMemberBtn = new RoundButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        memberListTable = new FormattedTable();
        generateReportBtn = new RoundButton();
        jLabel1 = new javax.swing.JLabel();
        memberStatusCombo = new javax.swing.JComboBox<>();
        searchByCombo = new javax.swing.JComboBox<>();
        resetBtn = new RoundButton();

        setBackground(new java.awt.Color(0, 30, 51));
        setPreferredSize(new java.awt.Dimension(1792, 1010));

        memberSearchField.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N

        memberSearchBtn.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        memberSearchBtn.setText("Search");
        memberSearchBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        memberSearchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                memberSearchBtnActionPerformed(evt);
            }
        });

        addMemberBtn.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        addMemberBtn.setText("Add New Member");
        addMemberBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMemberBtnActionPerformed(evt);
            }
        });

        memberListTable.setBackground(new java.awt.Color(60, 63, 65));
        memberListTable.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        memberListTable.setForeground(new java.awt.Color(255, 255, 255));
        memberListTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "NIC", "Email Address", "Mobile Number", "Gender", "Registered Date", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        memberListTable.setRowHeight(40);
        memberListTable.setRowSelectionAllowed(false);
        memberListTable.setShowHorizontalLines(true);
        memberListTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(memberListTable);
        if (memberListTable.getColumnModel().getColumnCount() > 0) {
            memberListTable.getColumnModel().getColumn(0).setMinWidth(100);
            memberListTable.getColumnModel().getColumn(0).setPreferredWidth(100);
            memberListTable.getColumnModel().getColumn(0).setMaxWidth(100);
        }

        generateReportBtn.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        generateReportBtn.setText("Generate Report");

        jLabel1.setFont(new java.awt.Font("Lucida Fax", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 214, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Members");

        memberStatusCombo.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        memberStatusCombo.setForeground(new java.awt.Color(255, 255, 255));
        memberStatusCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active", "Inactive" }));

        searchByCombo.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        searchByCombo.setForeground(new java.awt.Color(255, 255, 255));
        searchByCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active", "Inactive" }));
        searchByCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchByComboActionPerformed(evt);
            }
        });

        resetBtn.setText("Reset");
        resetBtn.setFont(new java.awt.Font("Dubai Medium", 0, 14));
        resetBtn.setBackground(new java.awt.Color(59, 130, 246));
        resetBtn.setForeground(new java.awt.Color(255, 255, 255));
        resetBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        resetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(searchByCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(memberSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(memberStatusCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(memberSearchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(resetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(addMemberBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(generateReportBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane2))
                    .addGap(10, 10, 10))
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(160, 160, 160))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(34, 34, 34)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(memberSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(memberSearchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(resetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(addMemberBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(memberStatusCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(searchByCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(50, 50, 50)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 763, Short.MAX_VALUE)
                    .addGap(18, 18, 18)
                    .addComponent(generateReportBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(38, 38, 38))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addMemberBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMemberBtnActionPerformed
        AddMember addMemberDialog = new AddMember(homeScreen, true);
        addMemberDialog.setLocationRelativeTo(homeScreen);
        addMemberDialog.setVisible(true);
        DefaultTableModel dtm = (DefaultTableModel) memberListTable.getModel();
        dtm.setRowCount(0);
        loadData();
    }//GEN-LAST:event_addMemberBtnActionPerformed

    private void searchByComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchByComboActionPerformed
        if (String.valueOf(searchByCombo.getSelectedItem()).equals("Status")) {
            memberSearchField.setText("");
            memberSearchField.setEnabled(false);
            memberStatusCombo.setEnabled(true);
        } else {
            if (String.valueOf(searchByCombo.getSelectedItem()).equals("Added Date")){
                memberSearchField.putClientProperty("JTextField.placeholderText", "YYYY-MM-DD");
            }
            memberSearchField.setText("");
            memberSearchField.setEnabled(true);
            memberStatusCombo.setEnabled(false);
        }
    }//GEN-LAST:event_searchByComboActionPerformed

    private void memberSearchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memberSearchBtnActionPerformed
        if (!Validator.isIndexValid(searchByCombo.getSelectedIndex())) {
            return;
        }
        if (memberSearchField.isEnabled()) {
            if (!Validator.isInputFieldValid(memberSearchField.getText())) {
                return;
            }
        }
        searchData();
    }//GEN-LAST:event_memberSearchBtnActionPerformed

    private void resetBtnActionPerformed(java.awt.event.ActionEvent evt) {
        memberSearchField.setText("");
        searchByCombo.setSelectedIndex(0);
        memberStatusCombo.setSelectedIndex(0);
        DefaultTableModel dtm = (DefaultTableModel) memberListTable.getModel();
        dtm.setRowCount(0);
        query = BASE_QUERY + " ORDER BY `member_id` ASC";
        loadData();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addMemberBtn;
    private javax.swing.JButton generateReportBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable memberListTable;
    private javax.swing.JButton memberSearchBtn;
    private javax.swing.JTextField memberSearchField;
    private javax.swing.JComboBox<String> memberStatusCombo;
    private javax.swing.JComboBox<String> searchByCombo;
    private javax.swing.JButton resetBtn;
    // End of variables declaration//GEN-END:variables
}
