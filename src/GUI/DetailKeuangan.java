package GUI;

import java.util.Locale;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import koneksi.koneksi;
import views.background;
import static GUI.menuUtama1.maximixed;


public class DetailKeuangan extends javax.swing.JDialog {
    
    public final Connection conn = new koneksi().connect();
    
    private DefaultTableModel kastab;
    private DefaultTableModel pendtab;
    private DefaultTableModel pengtab;
    
    
    // frame maks dan geser panel
    static boolean maximixed = true;
    int xMouse;
    int yMouse;
    
    private void aktif(){
        txtId.setEnabled(true);
        txtTotalPend.setEnabled(true);
        txtTotalPeng.setEnabled(true);
        txtLaba.setEnabled(true);
    }
    
    protected void kosong(){
        txtId.setText(null);
        txtTotalPend.setText(null);
        txtTotalPeng.setText(null);
        txtLaba.setText(null);
    }
    
 
    
    public void noTable(){
        int Baris = kastab.getRowCount();
        for (int a=0; a<Baris; a++)
        {
            String nomor = String.valueOf(a+1);
            kastab.setValueAt(nomor +".",a,0);
        }
    }
    
    public void tanggal(){
        Date tgl = new Date();
        txtTanggal.setDate(tgl);
    }
    
    
    public void dataTable(){
        Object[] Baris = {"No","ID Detail Keuangan","Tanggal","Total Pendapatan","Total Pengeluaran","Laba Bersih"};
        kastab = new DefaultTableModel(null, Baris);
        TabelKas.setModel(kastab);
        try {
        String sql = "select * from detail_keuangan order by id_dk asc";
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()){
                String id_dk = hasil.getString("id_dk");
                String tanggal = hasil.getString("tanggal");
                String total_pendapatan = String.valueOf(hasil.getInt("total_pendapatan"));
                String total_pengeluaran = String.valueOf(hasil.getInt("total_pengeluaran"));
                String laba_bersih = String.valueOf(hasil.getInt("laba_bersih"));
                String[] data = {"",id_dk,tanggal,total_pendapatan,total_pengeluaran,laba_bersih};
                kastab.addRow(data);
                noTable();
            }
        } catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, "Terjadi Kesalahan");
        }
    }
    
    public void dataTable2(){
        Object[] Baris = {"tanggal", "total pendapatan"};
        pendtab = new DefaultTableModel(null, Baris);
        TabelPendapatan.setModel(pendtab);
        String sql = "select * from pendapatan order by tanggal asc";
        try{
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()){
                String tanggal = hasil.getString("tanggal");
                String total_pendapatan = String.valueOf(hasil.getInt("total_pendapatan"));
                String[] data = {tanggal,total_pendapatan};
                pendtab.addRow(data);
            }
        } catch (Exception e){
        }
    }
    public void dataTable3(){
        Object[] Baris = {"Tanggal Pengeluaran","Total Pengeluaran"};
        pengtab = new DefaultTableModel(null, Baris);
        TabelPengeluaran.setModel(pengtab);
        String sql = "select * from pengeluaran order by tanggal_pengeluaran asc";
        try{
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()){
                String tanggal_pengeluaran = hasil.getString("tanggal_pengeluaran");
                String total_pengeluaran = String.valueOf(hasil.getInt("total_pengeluaran"));
                String[] data = {tanggal_pengeluaran,total_pengeluaran};
                pengtab.addRow(data);
            }
        } catch (Exception e){
        }
    }
    
    public void lebarKolom(){
        TableColumn column;
        TabelKas.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        column = TabelKas.getColumnModel().getColumn(0);
        column.setPreferredWidth(40);
        column = TabelKas.getColumnModel().getColumn(1);
        column.setPreferredWidth(150);
        column = TabelKas.getColumnModel().getColumn(2);
        column.setPreferredWidth(200);
        column = TabelKas.getColumnModel().getColumn(3);
        column.setPreferredWidth(300);
        column = TabelKas.getColumnModel().getColumn(4);
        column.setPreferredWidth(300);
        column = TabelKas.getColumnModel().getColumn(5);
        column.setPreferredWidth(300);
 

    }
    
    public void lebarKolom2(){
        TableColumn column2;
        TabelPendapatan.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        column2 = TabelPendapatan.getColumnModel().getColumn(0);
        column2.setPreferredWidth(80);
        column2 = TabelPendapatan.getColumnModel().getColumn(1);
        column2.setPreferredWidth(215);
    }
    
     public void lebarKolom3(){
        TableColumn column3;
        TabelPengeluaran.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        column3 = TabelPengeluaran.getColumnModel().getColumn(0);
        column3.setPreferredWidth(90);
        column3 = TabelPengeluaran.getColumnModel().getColumn(1);
        column3.setPreferredWidth(205);
    }
    
    public void pencarian(String sql){
        Object[] Baris = {"No","ID Detail Keuangan","Tanggal","Total Pendapatan","Total Pengeluaran","Laba Bersih"};
        kastab = new DefaultTableModel(null, Baris);
        TabelKas.setModel(kastab);
        int brs = TabelKas.getRowCount();
        for (int i = 0; 1 < brs; i++){
            kastab.removeRow(1);
        }
        try{
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()){
                String id_dk = hasil.getString("id_dk");
                String tanggal = hasil.getString("tanggal");
                String total_pendapatan = String.valueOf(hasil.getInt("total_pendapatan"));
                String total_pengeluaran = String.valueOf(hasil.getInt("total_pengeluaran"));
                String laba_bersih = String.valueOf(hasil.getInt("laba_bersih"));
                String[] data = {"",id_dk,tanggal,total_pendapatan,total_pengeluaran,laba_bersih};
                kastab.addRow(data);
                noTable();
            }
        } catch(Exception e){
            
        }
    }
    
    public void pencarian2(String sql){
        Object[] Baris2 = {"tanggal", "total pendapatan"};
        pendtab = new DefaultTableModel(null, Baris2);
        TabelPendapatan.setModel(pendtab);
        int brs = TabelPendapatan.getRowCount();
        for (int i = 0; 1 < brs; i++){
            pendtab.removeRow(1);
        }
        try{
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()){
                String tanggal = hasil.getString("tanggal");
                String total_pendapatan = String.valueOf(hasil.getInt("total_pendapatan"));
                String[] data = {tanggal,total_pendapatan};
                pendtab.addRow(data);
            }
        } catch(Exception e){
            
        }
    }
    
    public void pencarian3(String sql){
        Object[] Baris = {"Tanggal Pengeluaran","Total Pengeluaran"};
        pengtab = new DefaultTableModel(null, Baris);
        TabelPengeluaran.setModel(pengtab);
        int brs = TabelPengeluaran.getRowCount();
        for (int i = 0; 1 < brs; i++){
            pengtab.removeRow(1);
        }
        try{
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()){
                String tanggal_pengeluaran = hasil.getString("tanggal_pengeluaran");
                String total_pengeluaran = String.valueOf(hasil.getInt("total_pengeluaran"));
                String[] data = {tanggal_pengeluaran,total_pengeluaran};
                pengtab.addRow(data);
            }
        } catch(Exception e){
            
        }
    }
    

    public DetailKeuangan(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        aktif();
        dataTable();
        dataTable2();
        dataTable3();
        tanggal();
        lebarKolom();
        lebarKolom2();
        lebarKolom3();
        txtId.requestFocus();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelHeader = new javax.swing.JPanel();
        btnClose = new javax.swing.JButton();
        labelNama = new javax.swing.JLabel();
        lbTanggal = new javax.swing.JLabel();
        labelIDKeuangan = new javax.swing.JLabel();
        lbTotalPeng = new javax.swing.JLabel();
        lbLabaBersih = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtTanggal = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelKas = new javax.swing.JTable();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnBersih = new javax.swing.JButton();
        btnCari = new javax.swing.JButton();
        txtCari = new javax.swing.JTextField();
        txtTotalPeng = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        TabelPengeluaran = new javax.swing.JTable();
        txtCariPeng = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        lbTotalPend = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtTotalPend = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        TabelPendapatan = new javax.swing.JTable();
        txtCariPend = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnTambah = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        txtLaba = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setType(java.awt.Window.Type.POPUP);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        panelHeader.setBackground(new java.awt.Color(255, 153, 0));
        panelHeader.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                panelHeaderMouseDragged(evt);
            }
        });
        panelHeader.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelHeaderMousePressed(evt);
            }
        });

        btnClose.setBackground(new java.awt.Color(255, 153, 0));
        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Delete_30px_4.png"))); // NOI18N
        btnClose.setContentAreaFilled(false);
        btnClose.setOpaque(true);
        btnClose.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Delete_30px_5.png"))); // NOI18N
        btnClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCloseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCloseMouseExited(evt);
            }
        });
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        labelNama.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelNama.setForeground(new java.awt.Color(255, 255, 255));
        labelNama.setText("Detail Keuangan");

        javax.swing.GroupLayout panelHeaderLayout = new javax.swing.GroupLayout(panelHeader);
        panelHeader.setLayout(panelHeaderLayout);
        panelHeaderLayout.setHorizontalGroup(
            panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelNama, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelHeaderLayout.setVerticalGroup(
            panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnClose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelNama, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addContainerGap())
        );

        lbTanggal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbTanggal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbTanggal.setText("Tanggal");
        lbTanggal.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        labelIDKeuangan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelIDKeuangan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelIDKeuangan.setText("ID Keuangan");
        labelIDKeuangan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lbTotalPeng.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbTotalPeng.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbTotalPeng.setText("Total Pengeluaran");
        lbTotalPeng.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lbLabaBersih.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbLabaBersih.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbLabaBersih.setText("Laba Bersih");
        lbLabaBersih.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        txtId.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIdKeyPressed(evt);
            }
        });

        txtTanggal.setDateFormatString("dd-MM-yyyy");
        txtTanggal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTanggal.setMaximumSize(new java.awt.Dimension(2147400000, 2147400000));
        txtTanggal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTanggalMouseClicked(evt);
            }
        });
        txtTanggal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTanggalKeyPressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText(":");
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText(":");
        jLabel9.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText(":");
        jLabel10.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        TabelKas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TabelKas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        TabelKas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TabelKas.setRowHeight(30);
        TabelKas.setRowMargin(2);
        TabelKas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelKasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabelKas);

        btnUbah.setBackground(new java.awt.Color(204, 204, 204));
        btnUbah.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnUbah.setText("Ubah");
        btnUbah.setContentAreaFilled(false);
        btnUbah.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUbah.setOpaque(true);
        btnUbah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnUbahMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnUbahMouseExited(evt);
            }
        });
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });

        btnHapus.setBackground(new java.awt.Color(204, 204, 204));
        btnHapus.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnHapus.setText("Hapus");
        btnHapus.setContentAreaFilled(false);
        btnHapus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHapus.setOpaque(true);
        btnHapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHapusMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHapusMouseExited(evt);
            }
        });
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnBersih.setBackground(new java.awt.Color(204, 204, 204));
        btnBersih.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnBersih.setText("Bersih");
        btnBersih.setContentAreaFilled(false);
        btnBersih.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBersih.setOpaque(true);
        btnBersih.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBersihMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBersihMouseExited(evt);
            }
        });
        btnBersih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBersihActionPerformed(evt);
            }
        });

        btnCari.setBackground(new java.awt.Color(204, 204, 204));
        btnCari.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCari.setText("Pencarian");
        btnCari.setContentAreaFilled(false);
        btnCari.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCari.setOpaque(true);
        btnCari.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCariMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCariMouseExited(evt);
            }
        });

        txtCari.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCariKeyTyped(evt);
            }
        });

        txtTotalPeng.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTotalPeng.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTotalPengKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTotalPengKeyTyped(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText(":");
        jLabel11.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        TabelPengeluaran.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TabelPengeluaran.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        TabelPengeluaran.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TabelPengeluaran.setRowHeight(30);
        TabelPengeluaran.setRowMargin(2);
        TabelPengeluaran.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelPengeluaranMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(TabelPengeluaran);

        txtCariPeng.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtCariPeng.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCariPengKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Pengeluaran");
        jLabel2.setOpaque(true);

        lbTotalPend.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbTotalPend.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbTotalPend.setText("Total Pendapatan");
        lbTotalPend.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText(":");
        jLabel13.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        txtTotalPend.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTotalPend.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTotalPendKeyPressed(evt);
            }
        });

        TabelPendapatan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TabelPendapatan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        TabelPendapatan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TabelPendapatan.setRowHeight(30);
        TabelPendapatan.setRowMargin(2);
        TabelPendapatan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelPendapatanMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(TabelPendapatan);

        txtCariPend.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtCariPend.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCariPendKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Pendapatan");
        jLabel3.setOpaque(true);

        btnTambah.setBackground(new java.awt.Color(204, 204, 204));
        btnTambah.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnTambah.setText("Tambah");
        btnTambah.setContentAreaFilled(false);
        btnTambah.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTambah.setOpaque(true);
        btnTambah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnTambahMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTambahMouseExited(evt);
            }
        });
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 0, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Info_30px_6.png"))); // NOI18N
        jLabel1.setText("   Information");
        jLabel1.setOpaque(true);

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setText("\n   * Form ini digunakan untuk menyimpan detail keuangan\n   * Tekan TAMBAH untuk menyimpan data\n   * Tekan UBAH untuk mengedit data\n   * Tekan BERSIH untuk membersihkan field\n   * Tekan HAPUS untuk menghapus data");
        jScrollPane3.setViewportView(jTextArea1);

        txtLaba.setText("Tampilkan");
        txtLaba.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLabaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelHeader, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lbTotalPeng, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbLabaBersih, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbTotalPend, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTotalPeng)
                                    .addComponent(txtTotalPend)
                                    .addComponent(txtLaba, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lbTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(labelIDKeuangan, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtId, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                    .addComponent(txtTanggal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                                        .addComponent(txtCariPend, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(59, 59, 59))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtCariPeng, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(4, 4, 4))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(43, 43, 43)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnHapus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnBersih, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(58, 58, 58)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(panelHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtCariPend, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtCariPeng, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnBersih, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelIDKeuangan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbTotalPend, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTotalPend, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbTotalPeng, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTotalPeng, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtLaba, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbLabaBersih, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(101, 101, 101)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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

    private void btnCloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseEntered
        btnClose.setBackground(Color.red);
    }//GEN-LAST:event_btnCloseMouseEntered

    private void btnCloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseExited
        btnClose.setBackground(new Color(204,102,255));
    }//GEN-LAST:event_btnCloseMouseExited

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void panelHeaderMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelHeaderMouseDragged
        if(maximixed){
            int x = evt.getXOnScreen();
            int y = evt.getYOnScreen();
            this.setLocation(x - xMouse, y - yMouse);
        }
    }//GEN-LAST:event_panelHeaderMouseDragged

    private void panelHeaderMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelHeaderMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_panelHeaderMousePressed

    private void txtTanggalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTanggalMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTanggalMouseClicked

    private void txtTanggalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTanggalKeyPressed
            if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            txtTotalPend.requestFocus();
    }//GEN-LAST:event_txtTanggalKeyPressed
    } 
    
    private void TabelKasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelKasMouseClicked
        int bar = TabelKas.getSelectedRow();
        String a = kastab.getValueAt(bar, 0).toString();
        String b = kastab.getValueAt(bar, 1).toString();
        String c = kastab.getValueAt(bar, 2).toString();
        String d = kastab.getValueAt(bar, 3).toString();
        String e = kastab.getValueAt(bar, 4).toString();
        String f = kastab.getValueAt(bar, 5).toString();



        SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
        Date dateValue = null;
        try{
            dateValue = date.parse((String)TabelKas.getValueAt(bar, 2 ));
        } catch (ParseException ex){
            Logger.getLogger(DetailKeuangan.class.getName()).log(Level.SEVERE, null, ex);
        }
        txtId.setText(b);
        txtTanggal.setDate(dateValue);
        txtTotalPend.setText(d);
        txtTotalPeng.setText(e);
        txtLaba.setText(f);
    }//GEN-LAST:event_TabelKasMouseClicked

    private void btnUbahMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUbahMouseEntered
        btnUbah.setBackground(new Color(0,0,204));
        btnUbah.setForeground(Color.white);
    }//GEN-LAST:event_btnUbahMouseEntered

    private void btnUbahMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUbahMouseExited
        btnUbah.setBackground(new Color(204,204,204));
        btnUbah.setForeground(Color.black);
    }//GEN-LAST:event_btnUbahMouseExited

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        String sql = "update detail_keuangan set id_dk=?,tanggal=?,total_pendapatan=?,"
                + "total_pengeluaran=?,laba_bersih=? where id_dk='"+txtId.getText()+"'";
        String tampilan = "dd-MM-yyyy";
        SimpleDateFormat fm = new SimpleDateFormat(tampilan);
        String tanggal = String.valueOf(fm.format(txtTanggal.getDate()));
        try {
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, txtId.getText());
            stat.setString(2, tanggal.toString());
            stat.setString(3, txtTotalPend.getText());
            stat.setString(4, txtTotalPeng.getText());
            stat.setString(5, txtLaba.getText());
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");

            kosong();
            dataTable();
            lebarKolom();
            txtId.requestFocus();
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Data Gagal Diubah"+e);
        }
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnHapusMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHapusMouseEntered
        btnHapus.setBackground(Color.red);
        btnHapus.setForeground(Color.white);
    }//GEN-LAST:event_btnHapusMouseEntered

    private void btnHapusMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHapusMouseExited
        btnHapus.setBackground(new Color(204,204,204));
        btnHapus.setForeground(Color.black);
    }//GEN-LAST:event_btnHapusMouseExited

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        int ok = JOptionPane.showConfirmDialog (null," Apakah Anda Yakin Ingin "
            + "Menghapus Data","Konfirmasi Dialog", JOptionPane.YES_NO_OPTION);
        if (ok==0){
            String sql="delete from detail_keuangan where id_dk='"+txtId.getText()+"'";
            try {
                PreparedStatement stat=conn.prepareStatement(sql);
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null,"Data Berhasil Dihapus");
                kosong();
                dataTable();
                lebarKolom();
                txtId.requestFocus();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Data Gagal Dihapus"+e);
            }
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnBersihMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBersihMouseEntered
        btnBersih.setBackground(new Color(0,0,204));
        btnBersih.setForeground(Color.white);
    }//GEN-LAST:event_btnBersihMouseEntered

    private void btnBersihMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBersihMouseExited
        btnBersih.setBackground(new Color(204,204,204));
        btnBersih.setForeground(Color.black);
    }//GEN-LAST:event_btnBersihMouseExited

    private void btnBersihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBersihActionPerformed

        txtId.requestFocus();
        txtId.setText(null);
        tanggal();
        txtTotalPend.setText(null);
        txtTotalPeng.setText(null);
        txtLaba.setText(null);
    }//GEN-LAST:event_btnBersihActionPerformed

    private void btnCariMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCariMouseEntered
        btnCari.setBackground(new Color(0,0,204));
        btnCari.setForeground(Color.white);
    }//GEN-LAST:event_btnCariMouseEntered

    private void btnCariMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCariMouseExited
        btnCari.setBackground(new Color(204,204,204));
        btnCari.setForeground(Color.black);
    }//GEN-LAST:event_btnCariMouseExited

    private void txtIdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txtTanggal.requestFocus();
        }
    }//GEN-LAST:event_txtIdKeyPressed

    private void txtTotalPengKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTotalPengKeyPressed
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            txtLaba.requestFocus();
        }
    }//GEN-LAST:event_txtTotalPengKeyPressed

    private void TabelPengeluaranMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelPengeluaranMouseClicked
        int bar = TabelPengeluaran.getSelectedRow();
        String a = pengtab.getValueAt(bar, 0).toString();
        String b = pengtab.getValueAt(bar, 1).toString();
        txtTotalPeng.setText(b);
        txtLaba.requestFocus();
    }//GEN-LAST:event_TabelPengeluaranMouseClicked

    private void txtCariPengKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariPengKeyTyped
        String sqlPencarian2 = "select * from pengeluaran where tanggal_pengeluaran like '%"+txtCariPeng.getText()+"%' or total_pengeluaran like '%"+txtCariPeng.getText()+"%'";
        pencarian2(sqlPencarian2);
        lebarKolom2();
    }//GEN-LAST:event_txtCariPengKeyTyped

    private void txtCariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyTyped
        String sqlPencarian = "select * from detail_keuangan where id_dk '%"+txtCari.getText()+"%'"
                + "or tanggal '%"+txtCari.getText()+"%'"
                + "or laba_bersih '%"+txtCari.getText()+"%'";
        pencarian(sqlPencarian);
        lebarKolom();
    }//GEN-LAST:event_txtCariKeyTyped

    private void txtTotalPendKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTotalPendKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txtTotalPeng.requestFocus();
        }
    }//GEN-LAST:event_txtTotalPendKeyPressed

    private void TabelPendapatanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelPendapatanMouseClicked
        int bar = TabelPendapatan.getSelectedRow();
        String a = pendtab.getValueAt(bar, 0).toString();
        String b = pendtab.getValueAt(bar, 1).toString();
        txtTotalPend.setText(b);
        txtTotalPeng.requestFocus();
    }//GEN-LAST:event_TabelPendapatanMouseClicked

    private void txtCariPendKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariPendKeyTyped
        String sqlPencarian3 = "select * from pendapatan where tanggal like '%"+txtCariPend.getText()+"%' or total_pendapatan like '%"+txtCariPend.getText()+"%'";
        pencarian3(sqlPencarian3);
        lebarKolom3();
    }//GEN-LAST:event_txtCariPendKeyTyped

    private void btnTambahMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTambahMouseEntered
        btnTambah.setBackground(new Color(0,0,204));
        btnTambah.setForeground(Color.white);
    }//GEN-LAST:event_btnTambahMouseEntered

    private void btnTambahMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTambahMouseExited
        btnTambah.setBackground(new Color(204,204,204));
        btnTambah.setForeground(Color.black);
    }//GEN-LAST:event_btnTambahMouseExited

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        if(txtId.getText().equals("")){
            JOptionPane.showMessageDialog(null, "ID kas tidak boleh kosong");
            txtId.requestFocus();
        } else if (txtTotalPend.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Total Pendapatan tidak boleh kosong");
            txtTotalPend.requestFocus();
        } else if (txtTotalPeng.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Total pengeluaran tidak boleh kosong");
            txtTotalPeng.requestFocus();
        } else if (txtLaba.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Laba Bersih tidak boleh kosong");
            txtLaba.requestFocus();
        } else {
        String sql = "insert into detail_keuangan values (?,?,?,?,?)";
        String tampilan = "dd-MM-yyyy";
        SimpleDateFormat fm = new SimpleDateFormat(tampilan);
        String tanggal = String.valueOf(fm.format(txtTanggal.getDate()));
        try {
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, txtId.getText());
            stat.setString(2, tanggal.toString());
            stat.setString(3, txtTotalPend.getText());
            stat.setString(4, txtTotalPeng.getText());
            stat.setString(5, txtLaba.getText());
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");

            kosong();
            dataTable();
            lebarKolom();
            txtId.requestFocus();
            stat.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Ditambah"+e);
        }
        }
    }//GEN-LAST:event_btnTambahActionPerformed

    private void txtTotalPengKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTotalPengKeyTyped

    }//GEN-LAST:event_txtTotalPengKeyTyped

    private void txtLabaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLabaActionPerformed
            String a = txtTotalPend.getText();
            String b = txtTotalPeng.getText();
            int c = Integer.parseInt(a);
            int d = Integer.parseInt(b);
            int e = c-d;
            txtLaba.setText(""+e);
    }//GEN-LAST:event_txtLabaActionPerformed
    

    public static void main(String args[]) {
 
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DetailKeuangan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DetailKeuangan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DetailKeuangan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DetailKeuangan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DetailKeuangan dialog = new DetailKeuangan(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabelKas;
    private javax.swing.JTable TabelPendapatan;
    private javax.swing.JTable TabelPengeluaran;
    private javax.swing.JButton btnBersih;
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnUbah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel labelIDKeuangan;
    private javax.swing.JLabel labelNama;
    private javax.swing.JLabel lbLabaBersih;
    private javax.swing.JLabel lbTanggal;
    private javax.swing.JLabel lbTotalPend;
    private javax.swing.JLabel lbTotalPeng;
    private javax.swing.JPanel panelHeader;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtCariPend;
    private javax.swing.JTextField txtCariPeng;
    private javax.swing.JTextField txtId;
    private javax.swing.JButton txtLaba;
    private com.toedter.calendar.JDateChooser txtTanggal;
    private javax.swing.JTextField txtTotalPend;
    private javax.swing.JTextField txtTotalPeng;
    // End of variables declaration//GEN-END:variables
}
