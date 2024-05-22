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


public class SaldoKas extends javax.swing.JDialog {
    
    public final Connection conn = new koneksi().connect();
    
    private DefaultTableModel kastab;
    private DefaultTableModel pendtab;
    private DefaultTableModel pengtab;
    
    

    static boolean maximixed = true;
    int xMouse;
    int yMouse;
    
    private void aktif(){
        txtId.setEnabled(true);
        txtKategori.setEnabled(true);
        txtJumlahPend.setEnabled(true);
        txtJumlahPeng.setEnabled(true);
        txtKeterangan.setEnabled(true);
        txtTransaksi.setEnabled(true);
    }
    
    protected void kosong(){
        txtId.setText(null);
        txtKategori.setSelectedItem(null);
        txtJumlahPend.setText(null);
        txtJumlahPeng.setText(null);
        txtKeterangan.setText(null);
        txtTransaksi.setText(null);
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
        Object[] Baris = {"No","ID Kas","Kategori","Tanggal","Jumlah Pendapatan","Jumlah Pengeluaran","Keterangan","Total Transaksi"};
        kastab = new DefaultTableModel(null, Baris);
        TabelKas.setModel(kastab);
        try {
        String sql = "select * from kasperusahaan order by id_kas asc";
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()){
                String id_kas = hasil.getString("id_kas");
                String kategori_kas = hasil.getString("kategori_kas");
                String tanggal_transaksi = hasil.getString("tanggal_transaksi");
                String jumlah_pendapatan = String.valueOf(hasil.getInt("jumlah_pendapatan"));
                String jumlah_pengeluaran = String.valueOf(hasil.getInt("jumlah_pengeluaran"));
                String keterangan = hasil.getString("keterangan");
                String total_transaksi = String.valueOf(hasil.getInt("total_transaksi"));
                String[] data = {"",id_kas,kategori_kas,tanggal_transaksi,jumlah_pendapatan,jumlah_pengeluaran,keterangan,total_transaksi};
                kastab.addRow(data);
                noTable();
            }
        } catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, "Terjadi Kesalahan");
        }
    }
    
    public void dataTable2(){
        Object[] Baris = {"Id Pendapatan", "Jumlah "};
        pendtab = new DefaultTableModel(null, Baris);
        TabelPendapatan.setModel(pendtab);
        String sql = "select * from pendapatan order by id_pendapatan asc";
        try{
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()){
                String id_pendapatan = hasil.getString("id_pendapatan");
                String jumlah_pendapatan = String.valueOf(hasil.getInt("jumlah_pendapatan"));
                String[] data = {id_pendapatan,jumlah_pendapatan};
                pendtab.addRow(data);
            }
        } catch (Exception e){
        }
    }
    public void dataTable3(){
        Object[] Baris = {"Id Pengeluaran","Jumlah Pengeluaran"};
        pengtab = new DefaultTableModel(null, Baris);
        TabelPengeluaran.setModel(pengtab);
        String sql = "select * from pengeluaran order by id_pengeluaran asc";
        try{
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()){
                String id_pengeluaran = hasil.getString("id_pengeluaran");
                String jumlah_pengeluaran = String.valueOf(hasil.getInt("jumlah_pengeluaran"));
                String[] data = {id_pengeluaran,jumlah_pengeluaran};
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
        column.setPreferredWidth(100);
        column = TabelKas.getColumnModel().getColumn(2);
        column.setPreferredWidth(250);
        column = TabelKas.getColumnModel().getColumn(3);
        column.setPreferredWidth(100);
        column = TabelKas.getColumnModel().getColumn(4);
        column.setPreferredWidth(250);
        column = TabelKas.getColumnModel().getColumn(5);
        column.setPreferredWidth(250);
        column = TabelKas.getColumnModel().getColumn(6);
        column.setPreferredWidth(300); 
        column = TabelKas.getColumnModel().getColumn(7);
        column.setPreferredWidth(200);

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
        Object[] Baris = {"No","ID Kas","Kategori","Tanggal","Jumlah Pendapatan","Jumlah Pengeluran","Keterangan","Total Transaksi"};
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
                String id_kas = hasil.getString("id_kas");
                String kategori_kas = hasil.getString("kategori_kas");
                String tanggal_transaksi = hasil.getString("tanggal_transaksi");
                String jumlah_pendapatan = String.valueOf(hasil.getInt("jumlah_pendapatan"));
                String jumlah_pengeluaran = String.valueOf(hasil.getInt("jumlah_pengeluaran"));
                String keterangan = hasil.getString("keterangan");
                String total_transaksi = String.valueOf(hasil.getInt("total_transaksi"));
                String[] data = {"",id_kas,kategori_kas,tanggal_transaksi,jumlah_pendapatan,jumlah_pengeluaran,keterangan,total_transaksi};
                kastab.addRow(data);
                noTable();
            }
        } catch(Exception e){
            
        }
    }
    
    public void pencarian2(String sql){
        Object[] Baris2 = {"Id Pendapatan", "Jumlah "};
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
                String id_pendapatan = hasil.getString("id_pendapatan");
                String jumlah_pendapatan = String.valueOf(hasil.getInt("jumlah_pendapatan"));
                String[] data = {id_pendapatan,jumlah_pendapatan};
                pendtab.addRow(data);
            }
        } catch(Exception e){
            
        }
    }
    
    public void pencarian3(String sql){
        Object[] Baris = {"Id Pengeluaran","Jumlah Pengeluaran"};
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
                String id_pengeluaran = hasil.getString("id_pengeluaran");
                String jumlah_pengeluaran = String.valueOf(hasil.getInt("jumlah_pengeluaran"));
                String[] data = {id_pengeluaran,jumlah_pengeluaran};
                pengtab.addRow(data);
            }
        } catch(Exception e){
            
        }
    }
    

    public SaldoKas(java.awt.Frame parent, boolean modal) {
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
        labelKodeBarang = new javax.swing.JLabel();
        labelKategori = new javax.swing.JLabel();
        labelKeterangan = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtTanggal = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelKas = new javax.swing.JTable();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnBersih = new javax.swing.JButton();
        btnCari = new javax.swing.JButton();
        txtCari = new javax.swing.JTextField();
        txtJumlahPeng = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtKeterangan = new javax.swing.JTextArea();
        labelGudang = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        TabelPengeluaran = new javax.swing.JTable();
        txtCariPeng = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        labelNamaBarang2 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtJumlahPend = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        TabelPendapatan = new javax.swing.JTable();
        txtCariPend = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnTambah = new javax.swing.JButton();
        labelKodeBarang1 = new javax.swing.JLabel();
        txtKategori = new javax.swing.JComboBox<>();
        txtTransaksi = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

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
        labelNama.setText("Transaksi Saldo Kas");

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

        labelKodeBarang.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelKodeBarang.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelKodeBarang.setText("ID Kas");
        labelKodeBarang.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        labelKategori.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelKategori.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelKategori.setText("Jumlah Pengeluaran");
        labelKategori.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        labelKeterangan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelKeterangan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelKeterangan.setText("Keterangan");
        labelKeterangan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

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

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText(":");
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText(":");
        jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

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

        txtJumlahPeng.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtJumlahPeng.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtJumlahPengKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtJumlahPengKeyTyped(evt);
            }
        });

        txtKeterangan.setColumns(20);
        txtKeterangan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtKeterangan.setRows(5);
        txtKeterangan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtKeteranganKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(txtKeterangan);

        labelGudang.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelGudang.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelGudang.setText("Kategori");
        labelGudang.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

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

        labelNamaBarang2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelNamaBarang2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelNamaBarang2.setText("Jumlah Pendapatan");
        labelNamaBarang2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText(":");
        jLabel13.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        txtJumlahPend.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtJumlahPend.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtJumlahPendKeyPressed(evt);
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

        labelKodeBarang1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelKodeBarang1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelKodeBarang1.setText("Jumlah Transaksi");
        labelKodeBarang1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        txtKategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Investasi", "Pendanaan", "Operasional" }));
        txtKategori.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtKategoriKeyPressed(evt);
            }
        });

        txtTransaksi.setText("Tampilkan");
        txtTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTransaksiActionPerformed(evt);
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
        jTextArea1.setText("\n   * Form ini digunakan untuk menyimpan data\n      Saldo Kas\n   * Tekan TAMBAH untuk menyimpan data\n   * Tekan UBAH untuk mengedit data\n   * Tekan BERSIH untuk membersihkan field\n   * Tekan HAPUS untuk menghapus data");
        jScrollPane3.setViewportView(jTextArea1);

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
                                    .addComponent(labelKodeBarang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labelGudang, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtId)
                                    .addComponent(txtKategori, javax.swing.GroupLayout.Alignment.TRAILING, 0, 250, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(labelKategori, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(labelKeterangan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(labelNamaBarang2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(lbTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtJumlahPeng)
                                    .addComponent(jScrollPane2)
                                    .addComponent(txtJumlahPend)
                                    .addComponent(txtTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(91, 91, 91)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnBersih, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(labelKodeBarang1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtTransaksi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(40, 40, 40)
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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(70, 70, 70)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(btnUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnBersih, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(32, 32, 32))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)))
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
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelKodeBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelKodeBarang1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelGudang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(labelNamaBarang2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtJumlahPend, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtJumlahPeng, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(labelKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelKeterangan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(54, 54, 54)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(txtTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
            txtJumlahPend.requestFocus();
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
        String g = kastab.getValueAt(bar, 6).toString();
        String h = kastab.getValueAt(bar, 7).toString();


        SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
        Date dateValue = null;
        try{
            dateValue = date.parse((String)TabelKas.getValueAt(bar, 3 ));
        } catch (ParseException ex){
            Logger.getLogger(SaldoKas.class.getName()).log(Level.SEVERE, null, ex);
        }
        txtId.setText(b);
        txtKategori.setSelectedItem(c);
        txtTanggal.setDate(dateValue);
        txtJumlahPend.setText(e);
        txtJumlahPeng.setText(f);
        txtKeterangan.setText(g);
        txtTransaksi.setText(h);
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
        String sql = "update kasperusahaan set id_kas=?,kategori_kas=?,tanggal_transaksi=?,"
                + "jumlah_pendapatan=?,jumlah_pengeluaran=?,keterangan=?,total_transaksi=?   where id_kas='"+txtId.getText()+"'";
        String tampilan = "dd-MM-yyyy";
        SimpleDateFormat fm = new SimpleDateFormat(tampilan);
        String tanggal = String.valueOf(fm.format(txtTanggal.getDate()));
        try {
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, txtId.getText());
            stat.setString(2, (String) txtKategori.getSelectedItem());
            stat.setString(3, tanggal.toString());
            stat.setString(4, txtJumlahPend.getText());
            stat.setString(5, txtJumlahPeng.getText());
            stat.setString(6, txtKeterangan.getText());
            stat.setString(7, txtTransaksi.getText());
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
            String sql="delete from kasperusahaan where id_kas='"+txtId.getText()+"'";
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
        txtKategori.setSelectedItem(null);
        tanggal();
        txtJumlahPend.setText(null);
        txtJumlahPeng.setText(null);
        txtKeterangan.setText(null);
        txtTransaksi.setText(null);
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
            txtKategori.requestFocus();
        }
    }//GEN-LAST:event_txtIdKeyPressed

    private void txtJumlahPengKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtJumlahPengKeyPressed
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            txtKeterangan.requestFocus();
        }
    }//GEN-LAST:event_txtJumlahPengKeyPressed

    private void TabelPengeluaranMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelPengeluaranMouseClicked
        int bar = TabelPengeluaran.getSelectedRow();
        String a = pengtab.getValueAt(bar, 0).toString();
        String b = pengtab.getValueAt(bar, 1).toString();
        txtJumlahPeng.setText(b);
        txtKeterangan.requestFocus();
    }//GEN-LAST:event_TabelPengeluaranMouseClicked

    private void txtCariPengKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariPengKeyTyped
        String sqlPencarian2 = "select * from pengeluaran where id_pengeluaran like '%"+txtCariPeng.getText()+"%' or jumlah_pengeluaran like '%"+txtCariPeng.getText()+"%'";
        pencarian2(sqlPencarian2);
        lebarKolom2();
    }//GEN-LAST:event_txtCariPengKeyTyped

    private void txtCariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyTyped
        String sqlPencarian = "select * from kasperusahaan where id_kas '%"+txtCari.getText()+"%'"
                + "or kategori_kas like '%"+txtCari.getText()+"%'"
                + "or total_transaksi '%"+txtCari.getText()+"%'";
        pencarian(sqlPencarian);
        lebarKolom();
    }//GEN-LAST:event_txtCariKeyTyped

    private void txtJumlahPendKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtJumlahPendKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txtJumlahPeng.requestFocus();
        }
    }//GEN-LAST:event_txtJumlahPendKeyPressed

    private void TabelPendapatanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelPendapatanMouseClicked
        int bar = TabelPendapatan.getSelectedRow();
        String a = pendtab.getValueAt(bar, 0).toString();
        String b = pendtab.getValueAt(bar, 1).toString();
        txtJumlahPend.setText(b);
        txtJumlahPeng.requestFocus();
    }//GEN-LAST:event_TabelPendapatanMouseClicked

    private void txtCariPendKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariPendKeyTyped
        String sqlPencarian3 = "select * from pendapatan where id_pendapatan like '%"+txtCariPend.getText()+"%' or jumlah_pendapatan like '%"+txtCariPend.getText()+"%'";
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
        } else if(txtKategori.getSelectedItem().equals("")){
            JOptionPane.showMessageDialog(null, "Kategori tidak boleh kosong");
            txtKategori.requestFocus();
        } else if (txtJumlahPend.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Jumlah Pendapatan tidak boleh kosong");
            txtJumlahPend.requestFocus();
        } else if (txtJumlahPeng.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Jumlah pengeluaran tidak boleh kosong");
            txtJumlahPeng.requestFocus();
        } else if (txtTransaksi.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Total Transaksi tidak boleh kosong");
            txtTransaksi.requestFocus();
        } else {
        String sql = "insert into kasperusahaan values (?,?,?,?,?,?,?)";
        String tampilan = "dd-MM-yyyy";
        SimpleDateFormat fm = new SimpleDateFormat(tampilan);
        String tanggal = String.valueOf(fm.format(txtTanggal.getDate()));
        try {
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, txtId.getText());
            stat.setString(2, (String) txtKategori.getSelectedItem());
            stat.setString(3, tanggal.toString());
            stat.setString(4, txtJumlahPend.getText());
            stat.setString(5, txtJumlahPeng.getText());
            stat.setString(6, txtKeterangan.getText());
            stat.setString(7, txtTransaksi.getText());
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

    private void txtJumlahPengKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtJumlahPengKeyTyped

    }//GEN-LAST:event_txtJumlahPengKeyTyped

    private void txtKategoriKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKategoriKeyPressed
            if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txtTanggal.requestFocus();
        }
    }//GEN-LAST:event_txtKategoriKeyPressed

    private void txtKeteranganKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKeteranganKeyPressed
            if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            txtTransaksi.requestFocus();
            }
    }//GEN-LAST:event_txtKeteranganKeyPressed

    private void txtTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTransaksiActionPerformed
            String a = txtJumlahPend.getText();
            String b = txtJumlahPeng.getText();
            int c = Integer.parseInt(a);
            int d = Integer.parseInt(b);
            int e = c-d;
            txtTransaksi.setText(""+e);
    }//GEN-LAST:event_txtTransaksiActionPerformed
    
  
    public static void main(String args[]) {
  
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SaldoKas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SaldoKas dialog = new SaldoKas(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel labelGudang;
    private javax.swing.JLabel labelKategori;
    private javax.swing.JLabel labelKeterangan;
    private javax.swing.JLabel labelKodeBarang;
    private javax.swing.JLabel labelKodeBarang1;
    private javax.swing.JLabel labelNama;
    private javax.swing.JLabel labelNamaBarang2;
    private javax.swing.JLabel lbTanggal;
    private javax.swing.JPanel panelHeader;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtCariPend;
    private javax.swing.JTextField txtCariPeng;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtJumlahPend;
    private javax.swing.JTextField txtJumlahPeng;
    private javax.swing.JComboBox<String> txtKategori;
    private javax.swing.JTextArea txtKeterangan;
    private com.toedter.calendar.JDateChooser txtTanggal;
    private javax.swing.JButton txtTransaksi;
    // End of variables declaration//GEN-END:variables
}
