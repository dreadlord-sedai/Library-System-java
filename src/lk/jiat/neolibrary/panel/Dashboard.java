/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package lk.jiat.neolibrary.panel;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Color;
import java.awt.Font;
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
        // --- BEGIN ROBUST CARD LAYOUT FIX ---
        // MEMBER LIST PANEL
        memberListPanel.removeAll();
        memberListPanel.setLayout(new javax.swing.BoxLayout(memberListPanel, javax.swing.BoxLayout.Y_AXIS));
        jLabel15.setAlignmentX(LEFT_ALIGNMENT);
        memberListPanel.add(jLabel15);
        memberListPanel.add(javax.swing.Box.createRigidArea(new java.awt.Dimension(0, 10)));
        jScrollPane1.setMaximumSize(new java.awt.Dimension(Integer.MAX_VALUE, 180));
        jScrollPane1.setAlignmentX(LEFT_ALIGNMENT);
        memberListPanel.add(jScrollPane1);
        memberListPanel.add(javax.swing.Box.createRigidArea(new java.awt.Dimension(0, 10)));
        javax.swing.JPanel memberBtnPanel = new javax.swing.JPanel();
        memberBtnPanel.setLayout(new javax.swing.BoxLayout(memberBtnPanel, javax.swing.BoxLayout.X_AXIS));
        memberBtnPanel.setOpaque(false);
        memberBtnPanel.setAlignmentX(LEFT_ALIGNMENT);
        memberBtnPanel.add(javax.swing.Box.createHorizontalGlue());
        memberBtnPanel.add(addNewMemberBtn);
        memberBtnPanel.add(javax.swing.Box.createRigidArea(new java.awt.Dimension(10, 0)));
        memberBtnPanel.add(memberSeeAllBtn);
        memberListPanel.add(memberBtnPanel);
        // BOOK LIST PANEL
        bookListPanel.removeAll();
        bookListPanel.setLayout(new javax.swing.BoxLayout(bookListPanel, javax.swing.BoxLayout.Y_AXIS));
        jLabel16.setAlignmentX(LEFT_ALIGNMENT);
        bookListPanel.add(jLabel16);
        bookListPanel.add(javax.swing.Box.createRigidArea(new java.awt.Dimension(0, 10)));
        jScrollPane3.setMaximumSize(new java.awt.Dimension(Integer.MAX_VALUE, 180));
        jScrollPane3.setAlignmentX(LEFT_ALIGNMENT);
        bookListPanel.add(jScrollPane3);
        bookListPanel.add(javax.swing.Box.createRigidArea(new java.awt.Dimension(0, 10)));
        javax.swing.JPanel bookBtnPanel = new javax.swing.JPanel();
        bookBtnPanel.setLayout(new javax.swing.BoxLayout(bookBtnPanel, javax.swing.BoxLayout.X_AXIS));
        bookBtnPanel.setOpaque(false);
        bookBtnPanel.setAlignmentX(LEFT_ALIGNMENT);
        bookBtnPanel.add(javax.swing.Box.createHorizontalGlue());
        bookBtnPanel.add(addNewBookBtn);
        bookBtnPanel.add(javax.swing.Box.createRigidArea(new java.awt.Dimension(10, 0)));
        bookBtnPanel.add(bookSeeAllBtn);
        bookListPanel.add(bookBtnPanel);
        // --- END ROBUST CARD LAYOUT FIX ---
        init();
        loadBookDetails();
        loadMemberDetails();
        this.homeScreen = parent;
        // Ensure proper sizing after initialization
        this.revalidate();
        this.repaint();
    }

    private void init() {
        // Set modern gradient background
        this.setBackground(new Color(15, 23, 42)); // Slate-900
        
        // Fix sizing issues - remove fixed preferred size
        this.setPreferredSize(null);
        
        // Modern glassmorphism card styling
        totalBookPanel.putClientProperty(FlatClientProperties.STYLE, "arc:20");
        borrowedBookPanel.putClientProperty(FlatClientProperties.STYLE, "arc:20");
        overdueBookPanel.putClientProperty(FlatClientProperties.STYLE, "arc:20");
        totalMemberPanel.putClientProperty(FlatClientProperties.STYLE, "arc:20");
        memberListPanel.putClientProperty(FlatClientProperties.STYLE, "arc:20");
        bookListPanel.putClientProperty(FlatClientProperties.STYLE, "arc:20");

        // New modern color scheme with gradients
        totalBookPanel.setBackground(new Color(59, 130, 246)); // Blue-500
        borrowedBookPanel.setBackground(new Color(16, 185, 129)); // Emerald-500
        overdueBookPanel.setBackground(new Color(245, 158, 11)); // Amber-500
        totalMemberPanel.setBackground(new Color(139, 92, 246)); // Violet-500
        memberListPanel.setBackground(new Color(30, 41, 59, 180)); // Slate-800 with transparency
        bookListPanel.setBackground(new Color(30, 41, 59, 180)); // Slate-800 with transparency

        // Enhanced card panel sizing
        totalBookPanel.setPreferredSize(new java.awt.Dimension(280, 140));
        borrowedBookPanel.setPreferredSize(new java.awt.Dimension(280, 140));
        overdueBookPanel.setPreferredSize(new java.awt.Dimension(280, 140));
        totalMemberPanel.setPreferredSize(new java.awt.Dimension(280, 140));

        // Modern icon styling with larger icons
        totalBookIcon.putClientProperty(FlatClientProperties.STYLE, "arc:999");
        borrowedBookIcon.putClientProperty(FlatClientProperties.STYLE, "arc:999");
        overdueBookIcon.putClientProperty(FlatClientProperties.STYLE, "arc:999");
        totalMemberIcon.putClientProperty(FlatClientProperties.STYLE, "arc:999");

        totalBookIcon.setIcon(new FlatSVGIcon("lk/jiat/neolibrary/images/total_book_label.svg",
                32,
                32));
        borrowedBookIcon.setIcon(new FlatSVGIcon("lk/jiat/neolibrary/images/borrowed_book_label.svg",
                32,
                32));
        overdueBookIcon.setIcon(new FlatSVGIcon("lk/jiat/neolibrary/images/hourglass_label.svg",
                32,
                32));
        totalMemberIcon.setIcon(new FlatSVGIcon("lk/jiat/neolibrary/images/members.svg",
                32,
                32));

        // Enhanced scroll pane styling
        jScrollPane1.putClientProperty(FlatClientProperties.STYLE, "arc:16");
        jScrollPane3.putClientProperty(FlatClientProperties.STYLE, "arc:16");
        
        // Improved scroll pane sizing
        jScrollPane1.setPreferredSize(new java.awt.Dimension(320, 200));
        jScrollPane3.setPreferredSize(new java.awt.Dimension(320, 200));
        
        // Update typography for labels
        updateTypography();
        
        // Enhanced layout fixes
        fixLayoutConstraints();
        
        // Improved table and button sizing
        fixCardContentSizing();
    }
    
    private void updateTypography() {
        // Header labels with modern typography
        jLabel1.setFont(new Font("Inter", Font.BOLD, 28));
        jLabel1.setForeground(new Color(248, 250, 252));
        
        jLabel2.setFont(new Font("Inter", Font.PLAIN, 16));
        jLabel2.setForeground(new Color(148, 163, 184));
        
        // Card title labels with enhanced styling
        jLabel4.setFont(new Font("Inter", Font.BOLD, 16));
        jLabel4.setForeground(new Color(255, 255, 255));
        
        jLabel7.setFont(new Font("Inter", Font.BOLD, 16));
        jLabel7.setForeground(new Color(255, 255, 255));
        
        jLabel10.setFont(new Font("Inter", Font.BOLD, 16));
        jLabel10.setForeground(new Color(255, 255, 255));
        
        jLabel13.setFont(new Font("Inter", Font.BOLD, 16));
        jLabel13.setForeground(new Color(255, 255, 255));
        
        // Count labels with larger, bolder fonts
        tBCLabel.setFont(new Font("Inter", Font.BOLD, 24));
        tBCLabel.setForeground(new Color(255, 255, 255));
        
        bBCLabel.setFont(new Font("Inter", Font.BOLD, 24));
        bBCLabel.setForeground(new Color(255, 255, 255));
        
        oBCLabel.setFont(new Font("Inter", Font.BOLD, 24));
        oBCLabel.setForeground(new Color(255, 255, 255));
        
        tMCLabel.setFont(new Font("Inter", Font.BOLD, 24));
        tMCLabel.setForeground(new Color(255, 255, 255));
        
        // Panel title labels with modern styling
        jLabel15.setFont(new Font("Inter", Font.BOLD, 18));
        jLabel15.setForeground(new Color(248, 250, 252));
        
        jLabel16.setFont(new Font("Inter", Font.BOLD, 18));
        jLabel16.setForeground(new Color(248, 250, 252));
    }

    private void fixLayoutConstraints() {
        // Enhanced maximum sizes
        totalBookPanel.setMaximumSize(new java.awt.Dimension(300, 160));
        borrowedBookPanel.setMaximumSize(new java.awt.Dimension(300, 160));
        overdueBookPanel.setMaximumSize(new java.awt.Dimension(300, 160));
        totalMemberPanel.setMaximumSize(new java.awt.Dimension(300, 160));
        
        memberListPanel.setMaximumSize(new java.awt.Dimension(380, 280));
        bookListPanel.setMaximumSize(new java.awt.Dimension(380, 280));
        
        // Improved minimum sizes
        totalBookPanel.setMinimumSize(new java.awt.Dimension(250, 120));
        borrowedBookPanel.setMinimumSize(new java.awt.Dimension(250, 120));
        overdueBookPanel.setMinimumSize(new java.awt.Dimension(250, 120));
        totalMemberPanel.setMinimumSize(new java.awt.Dimension(250, 120));
        
        memberListPanel.setMinimumSize(new java.awt.Dimension(320, 220));
        bookListPanel.setMinimumSize(new java.awt.Dimension(320, 220));
    }
    
    private void fixCardContentSizing() {
        // Enhanced table column widths
        if (memberTable.getColumnModel().getColumnCount() > 0) {
            memberTable.getColumnModel().getColumn(0).setPreferredWidth(50);  // ID
            memberTable.getColumnModel().getColumn(1).setPreferredWidth(130); // Name
            memberTable.getColumnModel().getColumn(2).setPreferredWidth(90);  // NIC
            memberTable.getColumnModel().getColumn(3).setPreferredWidth(90);  // Mobile
            memberTable.getColumnModel().getColumn(4).setPreferredWidth(130); // Email
        }
        
        if (bookTable.getColumnModel().getColumnCount() > 0) {
            bookTable.getColumnModel().getColumn(0).setPreferredWidth(50);   // ID
            bookTable.getColumnModel().getColumn(1).setPreferredWidth(110);  // Title
            bookTable.getColumnModel().getColumn(2).setPreferredWidth(90);   // Author
            bookTable.getColumnModel().getColumn(3).setPreferredWidth(70);   // Genre
            bookTable.getColumnModel().getColumn(4).setPreferredWidth(90);   // Added Date
            bookTable.getColumnModel().getColumn(5).setPreferredWidth(70);   // Status
        }
        
        // Enhanced button sizes
        addNewMemberBtn.setPreferredSize(new java.awt.Dimension(130, 35));
        memberSeeAllBtn.setPreferredSize(new java.awt.Dimension(90, 30));
        addNewBookBtn.setPreferredSize(new java.awt.Dimension(130, 35));
        bookSeeAllBtn.setPreferredSize(new java.awt.Dimension(90, 30));
        
        // Improved row height for tables
        memberTable.setRowHeight(28);
        bookTable.setRowHeight(28);
        
        // Enhanced table viewport sizes
        memberTable.setPreferredScrollableViewportSize(new java.awt.Dimension(300, 160));
        bookTable.setPreferredScrollableViewportSize(new java.awt.Dimension(300, 160));
        
        // Style the buttons within cards
        styleCardButtons();
    }
    
    private void styleCardButtons() {
        // Enhanced member list buttons
        addNewMemberBtn.setFont(new Font("Inter", Font.BOLD, 13));
        
        memberSeeAllBtn.setFont(new Font("Inter", Font.PLAIN, 12));
        
        // Enhanced book list buttons
        addNewBookBtn.setFont(new Font("Inter", Font.BOLD, 13));
        
        bookSeeAllBtn.setFont(new Font("Inter", Font.PLAIN, 12));
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

        addNewMemberBtn.setBackground(new java.awt.Color(34, 197, 94));
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

        memberSeeAllBtn.setBackground(new java.awt.Color(34, 197, 94));
        memberSeeAllBtn.setForeground(new java.awt.Color(0, 0, 0));
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

        addNewBookBtn.setBackground(new java.awt.Color(34, 197, 94));
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

        bookSeeAllBtn.setBackground(new java.awt.Color(34, 197, 94));
        bookSeeAllBtn.setForeground(new java.awt.Color(0, 0, 0));
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
                        .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel1)
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
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void styleButtons() {
        // Add Book and Add Member buttons - green
        if (addNewBookBtn != null) {
            addNewBookBtn.setUI(null);
            addNewBookBtn.putClientProperty("JButton.background", new java.awt.Color(34, 197, 94));
            addNewBookBtn.setBackground(new java.awt.Color(34, 197, 94));
            addNewBookBtn.setOpaque(true);
            addNewBookBtn.setContentAreaFilled(true);
            addNewBookBtn.repaint();
        }
        if (addNewMemberBtn != null) {
            addNewMemberBtn.setUI(null);
            addNewMemberBtn.putClientProperty("JButton.background", new java.awt.Color(34, 197, 94));
            addNewMemberBtn.setBackground(new java.awt.Color(34, 197, 94));
            addNewMemberBtn.setOpaque(true);
            addNewMemberBtn.setContentAreaFilled(true);
            addNewMemberBtn.repaint();
        }
        if (bookSeeAllBtn != null) {
            bookSeeAllBtn.setUI(null);
            bookSeeAllBtn.putClientProperty("JButton.background", new java.awt.Color(34, 197, 94));
            bookSeeAllBtn.setBackground(new java.awt.Color(34, 197, 94));
            bookSeeAllBtn.setOpaque(true);
            bookSeeAllBtn.setContentAreaFilled(true);
            bookSeeAllBtn.repaint();
        }
        if (memberSeeAllBtn != null) {
            memberSeeAllBtn.setUI(null);
            memberSeeAllBtn.putClientProperty("JButton.background", new java.awt.Color(34, 197, 94));
            memberSeeAllBtn.setBackground(new java.awt.Color(34, 197, 94));
            memberSeeAllBtn.setOpaque(true);
            memberSeeAllBtn.setContentAreaFilled(true);
            memberSeeAllBtn.repaint();
        }
    }

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
