/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package lk.jiat.neolibrary.panel;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import lk.jiat.neolibrary.component.FormattedTable;
import lk.jiat.neolibrary.component.RoundButton;
import lk.jiat.neolibrary.connection.MySQL;
import lk.jiat.neolibrary.dialog.AddBook;
import lk.jiat.neolibrary.dialog.AddMember;
import lk.jiat.neolibrary.gui.Home;

/**
 *
 * @author Yashitha
 */
public class Dashboard extends javax.swing.JPanel {

    /**
     * Creates new form Dashboard
     */
    private Home homeScreen;

    public Dashboard(Home parent) {
        initComponents();
        init();
        updateDateTime();
        loadBookDetails();
        loadMemberDetails();
        this.homeScreen = parent;
    }

    private void init() {
        totalBookPanel.putClientProperty(FlatClientProperties.STYLE, "arc:40");
        borrowedBookPanel.putClientProperty(FlatClientProperties.STYLE, "arc:40");
        overdueBookPanel.putClientProperty(FlatClientProperties.STYLE, "arc:40");
        totalMemberPanel.putClientProperty(FlatClientProperties.STYLE, "arc:40");
        memberListPanel.putClientProperty(FlatClientProperties.STYLE, "arc:40");
        bookListPanel.putClientProperty(FlatClientProperties.STYLE, "arc:40");

        totalBookIcon.putClientProperty(FlatClientProperties.STYLE, "arc:999");
        borrowedBookIcon.putClientProperty(FlatClientProperties.STYLE, "arc:999");
        overdueBookIcon.putClientProperty(FlatClientProperties.STYLE, "arc:999");
        totalMemberIcon.putClientProperty(FlatClientProperties.STYLE, "arc:999");

        totalBookIcon.setIcon(new FlatSVGIcon("lk/jiat/neolibrary/images/total_book_label.svg",
                40,
                40));
        borrowedBookIcon.setIcon(new FlatSVGIcon("lk/jiat/neolibrary/images/borrowed_book_label.svg",
                40,
                40));
        overdueBookIcon.setIcon(new FlatSVGIcon("lk/jiat/neolibrary/images/hourglass_label.svg",
                40,
                40));
        totalMemberIcon.setIcon(new FlatSVGIcon("lk/jiat/neolibrary/images/members.svg",
                40,
                40));

        jScrollPane1.putClientProperty(FlatClientProperties.STYLE, "arc:40;");
        jScrollPane3.putClientProperty(FlatClientProperties.STYLE, "arc:40;");
        dateTimeFormattedFeild.setBorder(BorderFactory.createEmptyBorder());
    }

    private void updateDateTime() {
        dateTimeFormattedFeild.setValue(new Date());

        Timer timer = new Timer(60000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dateTimeFormattedFeild.setValue(new Date());
            }
        });
        timer.start();
    }

    private void loadBookDetails() {
        String countQuery = "SELECT COUNT(*) FROM `book`";
        try {
            ResultSet bookSet = MySQL.executeSearch("SELECT * FROM `book` INNER JOIN `genre` ON `book`.`genre_id` = `genre`.`genre_id` "
                    + "INNER JOIN `book_status` ON `book`.`b_status_id` = `book_status`.`b_status_id`;");
            ResultSet totalBookSet = MySQL.executeSearch(countQuery + ";");
            ResultSet borrowedBookSet = MySQL.executeSearch(countQuery + " WHERE `b_status_id` = '2' OR `b_status_id` = '5';");
            ResultSet overdueBookSet = MySQL.executeSearch(countQuery + " WHERE `b_status_id` = '4' OR `b_status_id` = '5';");

            totalBookSet.next();
            borrowedBookSet.next();
            overdueBookSet.next();

            String totalBookCount = totalBookSet.getString(1);
            String borrowedBookCount = borrowedBookSet.getString(1);
            String overdueBookCount = overdueBookSet.getString(1);

            tBCLabel.setText(totalBookCount);
            bBCLabel.setText(borrowedBookCount);
            oBCLabel.setText(overdueBookCount);

            DefaultTableModel dtm = (DefaultTableModel) bookTable.getModel();
            for (int i = 0; i < 10; i++) {
                if (bookSet.next()) {
                    String dateStr = bookSet.getString("added_date");
                    SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    SimpleDateFormat outputFormat = new SimpleDateFormat("dd MMMM, yyyy");

                    Date date = inputFormat.parse(dateStr);

                    Vector<String> v = new Vector();
                    v.add(bookSet.getString("book_id"));
                    v.add(bookSet.getString("title"));
                    v.add(bookSet.getString("Author"));
                    v.add(bookSet.getString("genre_name"));
                    v.add(outputFormat.format(date));
                    v.add(bookSet.getString("b_status_name"));
                    dtm.addRow(v);
                }
            }

        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        }
    }
    
    private void loadMemberDetails(){
        try {
            ResultSet totalMemberSet = MySQL.executeSearch("SELECT COUNT(*) FROM `member`;");
            ResultSet memberSet = MySQL.executeSearch("SELECT * FROM `member`;");
            totalMemberSet.next();
            String totalMemberCount = totalMemberSet.getString(1);
            tMCLabel.setText(totalMemberCount);
            
            DefaultTableModel dtm = (DefaultTableModel) memberTable.getModel();
            for (int i = 0; i < 10; i++) {
                if (memberSet.next()) {
                    Vector<String> v = new Vector();
                    v.add(memberSet.getString("member_id"));
                    v.add(memberSet.getString("fname")+" "+memberSet.getString("lname"));
                    v.add(memberSet.getString("nic"));
                    v.add(memberSet.getString("mobile"));
                    v.add(memberSet.getString("email"));
                    dtm.addRow(v);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        dateTimeFormattedFeild = new javax.swing.JFormattedTextField();
        totalBookPanel = new javax.swing.JPanel();
        tBCLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        totalBookIcon = new javax.swing.JLabel();
        borrowedBookPanel = new javax.swing.JPanel();
        bBCLabel = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        borrowedBookIcon = new javax.swing.JLabel();
        overdueBookPanel = new javax.swing.JPanel();
        oBCLabel = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        overdueBookIcon = new javax.swing.JLabel();
        totalMemberPanel = new javax.swing.JPanel();
        tMCLabel = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        totalMemberIcon = new javax.swing.JLabel();
        memberListPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        memberTable = new FormattedTable();
        jLabel15 = new javax.swing.JLabel();
        addNewMemberBtn = new RoundButton();
        memberSeeAllBtn = new RoundButton();
        bookListPanel = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        addNewBookBtn = new RoundButton();
        bookSeeAllBtn = new RoundButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        bookTable = new FormattedTable();

        setBackground(new java.awt.Color(0, 30, 51));
        setPreferredSize(new java.awt.Dimension(1792, 1010));

        jLabel1.setFont(new java.awt.Font("Dubai Medium", 1, 40)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Hello,");

        jLabel2.setFont(new java.awt.Font("Dubai Medium", 0, 40)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 214, 255));
        jLabel2.setText("Yashitha!");

        dateTimeFormattedFeild.setEditable(false);
        dateTimeFormattedFeild.setBackground(new java.awt.Color(0, 30, 51));
        dateTimeFormattedFeild.setForeground(new java.awt.Color(255, 255, 255));
        dateTimeFormattedFeild.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("MMM d,y | EEEE,h:mm a"))));
        dateTimeFormattedFeild.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        dateTimeFormattedFeild.setSelectionColor(new java.awt.Color(0, 0, 0));

        totalBookPanel.setPreferredSize(new java.awt.Dimension(428, 200));

        tBCLabel.setFont(new java.awt.Font("Dubai Medium", 0, 60)); // NOI18N
        tBCLabel.setForeground(new java.awt.Color(255, 255, 255));
        tBCLabel.setText("487");

        jLabel4.setFont(new java.awt.Font("Dubai Medium", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Total Books");

        totalBookIcon.setBackground(new java.awt.Color(0, 153, 255));
        totalBookIcon.setFont(new java.awt.Font("Dubai Medium", 0, 12)); // NOI18N
        totalBookIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalBookIcon.setOpaque(true);
        totalBookIcon.setPreferredSize(new java.awt.Dimension(80, 80));

        javax.swing.GroupLayout totalBookPanelLayout = new javax.swing.GroupLayout(totalBookPanel);
        totalBookPanel.setLayout(totalBookPanelLayout);
        totalBookPanelLayout.setHorizontalGroup(
            totalBookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(totalBookPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(totalBookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(totalBookPanelLayout.createSequentialGroup()
                        .addComponent(tBCLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(totalBookIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        totalBookPanelLayout.setVerticalGroup(
            totalBookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(totalBookPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(totalBookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tBCLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalBookIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(jLabel4)
                .addGap(20, 20, 20))
        );

        borrowedBookPanel.setPreferredSize(new java.awt.Dimension(428, 200));

        bBCLabel.setFont(new java.awt.Font("Dubai Medium", 0, 60)); // NOI18N
        bBCLabel.setForeground(new java.awt.Color(255, 255, 255));
        bBCLabel.setText("103");

        jLabel7.setFont(new java.awt.Font("Dubai Medium", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Borrowed Books");

        borrowedBookIcon.setBackground(new java.awt.Color(0, 153, 255));
        borrowedBookIcon.setFont(new java.awt.Font("Dubai Medium", 0, 12)); // NOI18N
        borrowedBookIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        borrowedBookIcon.setOpaque(true);
        borrowedBookIcon.setPreferredSize(new java.awt.Dimension(80, 80));

        javax.swing.GroupLayout borrowedBookPanelLayout = new javax.swing.GroupLayout(borrowedBookPanel);
        borrowedBookPanel.setLayout(borrowedBookPanelLayout);
        borrowedBookPanelLayout.setHorizontalGroup(
            borrowedBookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(borrowedBookPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(borrowedBookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(borrowedBookPanelLayout.createSequentialGroup()
                        .addComponent(bBCLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(borrowedBookIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        borrowedBookPanelLayout.setVerticalGroup(
            borrowedBookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(borrowedBookPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(borrowedBookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bBCLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(borrowedBookIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(jLabel7)
                .addGap(20, 20, 20))
        );

        overdueBookPanel.setPreferredSize(new java.awt.Dimension(428, 200));

        oBCLabel.setFont(new java.awt.Font("Dubai Medium", 0, 60)); // NOI18N
        oBCLabel.setForeground(new java.awt.Color(255, 255, 255));
        oBCLabel.setText("20");

        jLabel10.setFont(new java.awt.Font("Dubai Medium", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Overdue Books");

        overdueBookIcon.setBackground(new java.awt.Color(0, 153, 255));
        overdueBookIcon.setFont(new java.awt.Font("Dubai Medium", 0, 12)); // NOI18N
        overdueBookIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        overdueBookIcon.setOpaque(true);
        overdueBookIcon.setPreferredSize(new java.awt.Dimension(80, 80));

        javax.swing.GroupLayout overdueBookPanelLayout = new javax.swing.GroupLayout(overdueBookPanel);
        overdueBookPanel.setLayout(overdueBookPanelLayout);
        overdueBookPanelLayout.setHorizontalGroup(
            overdueBookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(overdueBookPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(overdueBookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(overdueBookPanelLayout.createSequentialGroup()
                        .addComponent(oBCLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(overdueBookIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        overdueBookPanelLayout.setVerticalGroup(
            overdueBookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(overdueBookPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(overdueBookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(oBCLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(overdueBookIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(jLabel10)
                .addGap(20, 20, 20))
        );

        totalMemberPanel.setPreferredSize(new java.awt.Dimension(428, 200));

        tMCLabel.setFont(new java.awt.Font("Dubai Medium", 0, 60)); // NOI18N
        tMCLabel.setForeground(new java.awt.Color(255, 255, 255));
        tMCLabel.setText("289");

        jLabel13.setFont(new java.awt.Font("Dubai Medium", 0, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Total Members");

        totalMemberIcon.setBackground(new java.awt.Color(0, 153, 255));
        totalMemberIcon.setFont(new java.awt.Font("Dubai Medium", 0, 12)); // NOI18N
        totalMemberIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalMemberIcon.setOpaque(true);
        totalMemberIcon.setPreferredSize(new java.awt.Dimension(80, 80));

        javax.swing.GroupLayout totalMemberPanelLayout = new javax.swing.GroupLayout(totalMemberPanel);
        totalMemberPanel.setLayout(totalMemberPanelLayout);
        totalMemberPanelLayout.setHorizontalGroup(
            totalMemberPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(totalMemberPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(totalMemberPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(totalMemberPanelLayout.createSequentialGroup()
                        .addComponent(tMCLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(totalMemberIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        totalMemberPanelLayout.setVerticalGroup(
            totalMemberPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(totalMemberPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(totalMemberPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tMCLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalMemberIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(jLabel13)
                .addGap(20, 20, 20))
        );

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        memberTable.setBackground(new java.awt.Color(60, 63, 65));
        memberTable.setFont(new java.awt.Font("Dubai Medium", 0, 16)); // NOI18N
        memberTable.setForeground(new java.awt.Color(255, 255, 255));
        memberTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "NIC", "Mobile", "Email Address"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        memberTable.setRowHeight(40);
        memberTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        memberTable.setShowGrid(false);
        memberTable.setShowHorizontalLines(true);
        memberTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(memberTable);
        if (memberTable.getColumnModel().getColumnCount() > 0) {
            memberTable.getColumnModel().getColumn(0).setMinWidth(60);
            memberTable.getColumnModel().getColumn(0).setPreferredWidth(60);
            memberTable.getColumnModel().getColumn(0).setMaxWidth(60);
            memberTable.getColumnModel().getColumn(1).setMinWidth(200);
            memberTable.getColumnModel().getColumn(1).setPreferredWidth(200);
            memberTable.getColumnModel().getColumn(1).setMaxWidth(200);
        }

        jLabel15.setFont(new java.awt.Font("Dubai Medium", 0, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Member List");
        jLabel15.setPreferredSize(new java.awt.Dimension(150, 48));

        addNewMemberBtn.setBackground(new java.awt.Color(255, 255, 255));
        addNewMemberBtn.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        addNewMemberBtn.setForeground(new java.awt.Color(0, 0, 0));
        addNewMemberBtn.setText("Add New Member");
        addNewMemberBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addNewMemberBtn.setPreferredSize(new java.awt.Dimension(200, 35));
        addNewMemberBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewMemberBtnActionPerformed(evt);
            }
        });

        memberSeeAllBtn.setBackground(new java.awt.Color(60, 63, 65));
        memberSeeAllBtn.setForeground(new java.awt.Color(0, 153, 255));
        memberSeeAllBtn.setText("See All");
        memberSeeAllBtn.setBorder(null);
        memberSeeAllBtn.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        memberSeeAllBtn.setPreferredSize(new java.awt.Dimension(105, 20));
        memberSeeAllBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                memberSeeAllBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout memberListPanelLayout = new javax.swing.GroupLayout(memberListPanel);
        memberListPanel.setLayout(memberListPanelLayout);
        memberListPanelLayout.setHorizontalGroup(
            memberListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, memberListPanelLayout.createSequentialGroup()
                .addGroup(memberListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(memberListPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(memberSeeAllBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, memberListPanelLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(memberListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(memberListPanelLayout.createSequentialGroup()
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(472, 472, 472)
                                .addComponent(addNewMemberBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)))))
                .addGap(27, 27, 27))
        );
        memberListPanelLayout.setVerticalGroup(
            memberListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(memberListPanelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(memberListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addNewMemberBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(memberSeeAllBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        jLabel16.setFont(new java.awt.Font("Dubai Medium", 0, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Book List");
        jLabel16.setPreferredSize(new java.awt.Dimension(150, 48));

        addNewBookBtn.setBackground(new java.awt.Color(255, 255, 255));
        addNewBookBtn.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        addNewBookBtn.setForeground(new java.awt.Color(0, 0, 0));
        addNewBookBtn.setText("Add New Book");
        addNewBookBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addNewBookBtn.setPreferredSize(new java.awt.Dimension(200, 35));
        addNewBookBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewBookBtnActionPerformed(evt);
            }
        });

        bookSeeAllBtn.setBackground(new java.awt.Color(60, 63, 65));
        bookSeeAllBtn.setForeground(new java.awt.Color(0, 153, 255));
        bookSeeAllBtn.setText("See All");
        bookSeeAllBtn.setBorder(null);
        bookSeeAllBtn.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        bookSeeAllBtn.setPreferredSize(new java.awt.Dimension(105, 20));
        bookSeeAllBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookSeeAllBtnActionPerformed(evt);
            }
        });

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        bookTable.setBackground(new java.awt.Color(60, 63, 65));
        bookTable.setFont(new java.awt.Font("Dubai Medium", 0, 16)); // NOI18N
        bookTable.setForeground(new java.awt.Color(255, 255, 255));
        bookTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Title", "Author", "Genre", "Added Date", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        bookTable.setRowHeight(40);
        bookTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        bookTable.setShowGrid(false);
        bookTable.setShowHorizontalLines(true);
        bookTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(bookTable);
        if (bookTable.getColumnModel().getColumnCount() > 0) {
            bookTable.getColumnModel().getColumn(0).setMinWidth(60);
            bookTable.getColumnModel().getColumn(0).setPreferredWidth(60);
            bookTable.getColumnModel().getColumn(0).setMaxWidth(60);
            bookTable.getColumnModel().getColumn(1).setMinWidth(200);
            bookTable.getColumnModel().getColumn(1).setPreferredWidth(200);
            bookTable.getColumnModel().getColumn(1).setMaxWidth(200);
            bookTable.getColumnModel().getColumn(5).setMinWidth(100);
            bookTable.getColumnModel().getColumn(5).setPreferredWidth(100);
            bookTable.getColumnModel().getColumn(5).setMaxWidth(100);
            bookTable.getColumnModel().getColumn(5).setHeaderValue("Registered Date");
        }

        javax.swing.GroupLayout bookListPanelLayout = new javax.swing.GroupLayout(bookListPanel);
        bookListPanel.setLayout(bookListPanelLayout);
        bookListPanelLayout.setHorizontalGroup(
            bookListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bookListPanelLayout.createSequentialGroup()
                .addGroup(bookListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(bookListPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bookSeeAllBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, bookListPanelLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(bookListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3)
                            .addGroup(bookListPanelLayout.createSequentialGroup()
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(472, 472, 472)
                                .addComponent(addNewBookBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)))))
                .addGap(27, 27, 27))
        );
        bookListPanelLayout.setVerticalGroup(
            bookListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bookListPanelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(bookListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addNewBookBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bookSeeAllBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dateTimeFormattedFeild)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(memberListPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(totalBookPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
                                .addGap(20, 20, 20)
                                .addComponent(borrowedBookPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(overdueBookPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
                                .addGap(20, 20, 20)
                                .addComponent(totalMemberPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE))
                            .addComponent(bookListPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateTimeFormattedFeild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(borrowedBookPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                    .addComponent(overdueBookPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                    .addComponent(totalBookPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                    .addComponent(totalMemberPanel, 201, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(memberListPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bookListPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(22, 22, 22))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addNewMemberBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewMemberBtnActionPerformed
        AddMember addMemberDialog = new AddMember(homeScreen, true);
        addMemberDialog.setLocationRelativeTo(homeScreen);
        addMemberDialog.setVisible(true);
    }//GEN-LAST:event_addNewMemberBtnActionPerformed

    private void addNewBookBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewBookBtnActionPerformed
        AddBook addBookDialog = new AddBook(homeScreen, true);
        addBookDialog.setLocationRelativeTo(homeScreen);
        addBookDialog.setVisible(true);
    }//GEN-LAST:event_addNewBookBtnActionPerformed

    private void memberSeeAllBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memberSeeAllBtnActionPerformed
        homeScreen.getContentPanelLayout().show(homeScreen.getContentPanel(), "members_panel");
        homeScreen.setActiveBtn(homeScreen.getMemberBtn());
    }//GEN-LAST:event_memberSeeAllBtnActionPerformed

    private void bookSeeAllBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookSeeAllBtnActionPerformed
        homeScreen.getContentPanelLayout().show(homeScreen.getContentPanel(), "books_panel");
        homeScreen.setActiveBtn(homeScreen.getBookBtn());
    }//GEN-LAST:event_bookSeeAllBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addNewBookBtn;
    private javax.swing.JButton addNewMemberBtn;
    private javax.swing.JLabel bBCLabel;
    private javax.swing.JPanel bookListPanel;
    private javax.swing.JButton bookSeeAllBtn;
    private javax.swing.JTable bookTable;
    private javax.swing.JLabel borrowedBookIcon;
    private javax.swing.JPanel borrowedBookPanel;
    private javax.swing.JFormattedTextField dateTimeFormattedFeild;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel memberListPanel;
    private javax.swing.JButton memberSeeAllBtn;
    private javax.swing.JTable memberTable;
    private javax.swing.JLabel oBCLabel;
    private javax.swing.JLabel overdueBookIcon;
    private javax.swing.JPanel overdueBookPanel;
    private javax.swing.JLabel tBCLabel;
    private javax.swing.JLabel tMCLabel;
    private javax.swing.JLabel totalBookIcon;
    private javax.swing.JPanel totalBookPanel;
    private javax.swing.JLabel totalMemberIcon;
    private javax.swing.JPanel totalMemberPanel;
    // End of variables declaration//GEN-END:variables
}
