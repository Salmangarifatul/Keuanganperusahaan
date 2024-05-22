package GUI;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import koneksi.koneksi;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import static GUI.LaporanKeuangan.maximixed;
import static com.sun.corba.se.impl.presentation.rmi.StubConnectImpl.connect;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.connect;
import static com.sun.jmx.remote.internal.IIOPHelper.connect;
import static javax.management.remote.JMXConnectorFactory.connect;
import static javax.rmi.PortableRemoteObject.connect;

public class LaporanKeuangan extends javax.swing.JDialog {
    
    public final Connection conn = new koneksi().connect();
    
    private DefaultTableModel laptab;
    
    JasperReport JasRep;
    JasperPrint JasPri;
    Map param = new HashMap(2);
    JasperDesign JasDes;
    
    // frame maks dan geser panel
    static boolean maximixed = true;
    int xMouse;
    int yMouse;
        
    public void noTable(){
        int Baris = laptab.getRowCount();
        for (int a=0; a<Baris; a++)
        {
            String nomor = String.valueOf(a+1);
            laptab.setValueAt(nomor +".",a,0);
        }
    }

    public void tanggal(){
        Date tgl = new Date();
        tglAwal.setDate(tgl);
        tglAkhir.setDate(tgl);
    }
    
    
    public void dataTable(){
        Object[] Baris = {"No","Tanggal","Total Pendapatan","Total Pengeluaran","Laba Bersih"};
        laptab = new DefaultTableModel(null, Baris);
        TabelKeuangan.setModel(laptab);   
    }
    
    public void lebarKolom(){
        TableColumn column;
        TabelKeuangan.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        column = TabelKeuangan.getColumnModel().getColumn(0);
        column.setPreferredWidth(40);
        column = TabelKeuangan.getColumnModel().getColumn(1);
        column.setPreferredWidth(300);
        column = TabelKeuangan.getColumnModel().getColumn(2);
        column.setPreferredWidth(300);
        column = TabelKeuangan.getColumnModel().getColumn(3);
        column.setPreferredWidth(250);
        column = TabelKeuangan.getColumnModel().getColumn(4);
        column.setPreferredWidth(250);
    }
    

    public void pencarian(String sql){
        Object[] Baris = {"No","Tanggal","Total Pendapatan","Total Pengeluaran","Laba Bersih"};
        laptab = new DefaultTableModel(null, Baris);
        TabelKeuangan.setModel(laptab);
        int brs = TabelKeuangan.getRowCount();
        for (int i = 0; 1 < brs; i++){
            laptab.removeRow(1);
        }
        try{
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()){
                String tanggal = hasil.getString("tanggal");
                String total_pendapatan = hasil.getString("total_pendapatan");
                String total_pengeluaran = hasil.getString("total_pengeluaran");
                String laba_bersih = hasil.getString("laba_bersih");
                String[] data = {"",tanggal,total_pendapatan,total_pengeluaran,laba_bersih};
                laptab.addRow(data);
                noTable();
            }
        } catch(Exception e){
            
        }
    }
    
    /**
     * Creates new form dataBarang
     */
    public LaporanKeuangan(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        tanggal();
        dataTable();
        lebarKolom();
        Locale local = new Locale("id","ID");
        Locale.setDefault(local);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane4 = new javax.swing.JScrollPane();
        TabelPengeluaran = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        TabelPendapatan = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtCariPend = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        panelHeader = new javax.swing.JPanel();
        btnClose = new javax.swing.JButton();
        labelNama = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelKeuangan = new javax.swing.JTable();
        btnCari = new javax.swing.JButton();
        txtCari = new javax.swing.JTextField();
        tglAwal = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tglAkhir = new com.toedter.calendar.JDateChooser();
        btnTampil = new javax.swing.JButton();
        btnCetak = new javax.swing.JButton();

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

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Pendapatan");
        jLabel3.setOpaque(true);

        txtCariPend.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtCariPend.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCariPendKeyTyped(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setType(java.awt.Window.Type.POPUP);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        panelHeader.setBackground(new java.awt.Color(255, 153, 51));
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
        labelNama.setText("LAPORAN KEUANGAN");

        javax.swing.GroupLayout panelHeaderLayout = new javax.swing.GroupLayout(panelHeader);
        panelHeader.setLayout(panelHeaderLayout);
        panelHeaderLayout.setHorizontalGroup(
            panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelHeaderLayout.createSequentialGroup()
                .addGap(444, 444, 444)
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

        TabelKeuangan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TabelKeuangan.setModel(new javax.swing.table.DefaultTableModel(
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
        TabelKeuangan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TabelKeuangan.setRowHeight(30);
        TabelKeuangan.setRowMargin(2);
        TabelKeuangan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelKeuanganMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabelKeuangan);

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
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        txtCari.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCariKeyTyped(evt);
            }
        });

        tglAwal.setBackground(new java.awt.Color(255, 255, 255));
        tglAwal.setDateFormatString("dd-MM-yyyy");
        tglAwal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Dari :");
        jLabel1.setOpaque(true);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Sampai :");
        jLabel2.setOpaque(true);

        tglAkhir.setBackground(new java.awt.Color(255, 255, 255));
        tglAkhir.setDateFormatString("dd-MM-yyyy");
        tglAkhir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnTampil.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnTampil.setText("Tampilkan");
        btnTampil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTampilActionPerformed(evt);
            }
        });

        btnCetak.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCetak.setText("Cetak");
        btnCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelHeader, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1186, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 214, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(tglAwal, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(tglAkhir, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTampil, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCetak, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(panelHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tglAwal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnTampil, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCetak, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tglAkhir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 685, Short.MAX_VALUE))
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

    private void TabelKeuanganMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelKeuanganMouseClicked
        int bar = TabelKeuangan.getSelectedRow();
        String a = laptab.getValueAt(bar, 0).toString();
        String b = laptab.getValueAt(bar, 1).toString();
        String c = laptab.getValueAt(bar, 2).toString();
        String d = laptab.getValueAt(bar, 3).toString();
        String e = laptab.getValueAt(bar, 4).toString();

        SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
        Date dateValue = null;
        try{
            dateValue = date.parse((String)TabelKeuangan.getValueAt(bar, 1));
        } catch (ParseException ex){
            Logger.getLogger(LaporanKeuangan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_TabelKeuanganMouseClicked

    private void btnCariMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCariMouseEntered
        btnCari.setBackground(new Color(0,0,204));
        btnCari.setForeground(Color.white);
    }//GEN-LAST:event_btnCariMouseEntered

    private void btnCariMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCariMouseExited
        btnCari.setBackground(new Color(204,204,204));
        btnCari.setForeground(Color.black);
    }//GEN-LAST:event_btnCariMouseExited

    private void txtCariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyTyped
        String sqlPencarian = "select * from detail_keuangan where laba_bersih like '%"+txtCari.getText()+"%'";
        pencarian(sqlPencarian);
        lebarKolom();
    }//GEN-LAST:event_txtCariKeyTyped

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCariActionPerformed

    private void btnTampilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTampilActionPerformed
        dataTable();
        String tampilan = "dd-MM-yyyy";
        SimpleDateFormat fm = new SimpleDateFormat(tampilan);
        String tanggalAwal = String.valueOf(fm.format(tglAwal.getDate()));
        String tanggalAkhir = String.valueOf(fm.format(tglAkhir.getDate()));
        String sql = "select * from detail_keuangan where tanggal between '"+tanggalAwal+"' and '"+tanggalAkhir+"'";
        try{
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()){
                String tanggal = hasil.getString("tanggal");
                String total_pendapatan = hasil.getString("total_pendapatan");
                String total_pengeluaran = hasil.getString("total_pengeluaran");
                String laba_bersih = hasil.getString("laba_bersih");
                String[] data = {"",tanggal,total_pendapatan,total_pengeluaran,laba_bersih};
                laptab.addRow(data);
                noTable();
                lebarKolom();
            }
        } catch (Exception e){
        }
        lebarKolom();
        JOptionPane.showMessageDialog(null, "Done");
    }//GEN-LAST:event_btnTampilActionPerformed

    private void btnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakActionPerformed
    try {
            String jdbcDriver = "com.mysql.jdbc.Driver";
            Class.forName(jdbcDriver);
            
            String url = "jdbc:mysql//localhost:3306/db_perusahaan";
            String user = "root";
            String pass = "";
            
            try {
                
                String report = ("D:\\AMIKOM 23\\pbo\\PROJECT AKHIr\\"
                        + "KeuanganPerusahaan2\\src\\"
                        + "GUI\\reportldk.jrxml");
                HashMap hash = new HashMap();
                JasperReport JRpt = JasperCompileManager.compileReport(report);
                JasperPrint JPrint = JasperFillManager.fillReport(JRpt, hash, conn);
                JasperViewer.viewReport(JPrint, false);
        }   catch (Exception rptexcpt) {
                System.out.println("Report tidak bisa dicetak karena: "+rptexcpt);
        }
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_btnCetakActionPerformed

    private void TabelPengeluaranMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelPengeluaranMouseClicked

    }//GEN-LAST:event_TabelPengeluaranMouseClicked

    private void TabelPendapatanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelPendapatanMouseClicked

    }//GEN-LAST:event_TabelPendapatanMouseClicked

    private void txtCariPendKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariPendKeyTyped
 
    }//GEN-LAST:event_txtCariPendKeyTyped

   
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LaporanKeuangan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LaporanKeuangan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LaporanKeuangan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LaporanKeuangan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                LaporanKeuangan dialog = new LaporanKeuangan(new javax.swing.JFrame(), true);
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
    private javax.swing.JTable TabelKeuangan;
    private javax.swing.JTable TabelPendapatan;
    private javax.swing.JTable TabelPengeluaran;
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnCetak;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnTampil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel labelNama;
    private javax.swing.JPanel panelHeader;
    private com.toedter.calendar.JDateChooser tglAkhir;
    private com.toedter.calendar.JDateChooser tglAwal;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtCariPend;
    // End of variables declaration//GEN-END:variables
}
