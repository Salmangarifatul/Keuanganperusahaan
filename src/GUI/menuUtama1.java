package GUI;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.plaf.RootPaneUI;
import GUI.about1;
import java.awt.Desktop;
import java.io.File;

public class menuUtama1 extends javax.swing.JFrame {
        

     private void setJam(){
        ActionListener listener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                jam.setText(new WaktuSekarang().getWkt());
            }
        };
        new Timer(1000, listener).start();
    }

    static boolean maximixed = true;
    int xMouse;
    int yMouse;

    

    
    public menuUtama1() {
        initComponents();
        setJam();
        panelMasterData.setVisible(false);
        panelTransaksi.setVisible(false);
        panelLaporan.setVisible(false);
    }
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelUtama = new javax.swing.JPanel();
        panelHeader = new javax.swing.JPanel();
        btnClose = new javax.swing.JButton();
        labelNama = new javax.swing.JLabel();
        btnMaximize = new javax.swing.JButton();
        btnMinimize = new javax.swing.JButton();
        panelMenu = new javax.swing.JPanel();
        btnMasterData = new javax.swing.JButton();
        btnTransaksi = new javax.swing.JButton();
        btnLaporan = new javax.swing.JButton();
        btnAbout = new javax.swing.JButton();
        btnmbook = new javax.swing.JButton();
        panelJam = new javax.swing.JPanel();
        jPanel1 = new views.background();
        tgl = new javax.swing.JLabel();
        jam = new javax.swing.JLabel();
        panelMasterData = new javax.swing.JPanel();
        btnDataPendapatan = new javax.swing.JButton();
        btnDataPengeluaran = new javax.swing.JButton();
        panelTransaksi = new javax.swing.JPanel();
        btnSaldoKas = new javax.swing.JButton();
        btnBiayaOperasional = new javax.swing.JButton();
        btnDetailKeuangan = new javax.swing.JButton();
        panelLaporan = new javax.swing.JPanel();
        btnLapKeuangan = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        panelUtama.setBackground(new java.awt.Color(204, 204, 204));
        panelUtama.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelUtamaMouseClicked(evt);
            }
        });

        panelHeader.setBackground(new java.awt.Color(102, 0, 153));

        btnClose.setBackground(new java.awt.Color(102, 0, 153));
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

        labelNama.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        labelNama.setForeground(new java.awt.Color(255, 255, 255));
        labelNama.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNama.setText("Aplikasi Managemen Keuangan Safety Insurance");
        labelNama.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                labelNamaMouseDragged(evt);
            }
        });
        labelNama.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                labelNamaMousePressed(evt);
            }
        });

        btnMaximize.setBackground(new java.awt.Color(102, 102, 102));
        btnMaximize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Maximize_Window_30px.png"))); // NOI18N
        btnMaximize.setContentAreaFilled(false);
        btnMaximize.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Maximize_Window_30px_1.png"))); // NOI18N
        btnMaximize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMaximizeMouseClicked(evt);
            }
        });

        btnMinimize.setBackground(new java.awt.Color(204, 204, 204));
        btnMinimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Minimize_Window_30px.png"))); // NOI18N
        btnMinimize.setContentAreaFilled(false);
        btnMinimize.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Minimize_Window_30px_1.png"))); // NOI18N
        btnMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMinimizeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMinimizeMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout panelHeaderLayout = new javax.swing.GroupLayout(panelHeader);
        panelHeader.setLayout(panelHeaderLayout);
        panelHeaderLayout.setHorizontalGroup(
            panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelHeaderLayout.createSequentialGroup()
                .addComponent(labelNama, javax.swing.GroupLayout.DEFAULT_SIZE, 1742, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(btnMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnMaximize, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelHeaderLayout.setVerticalGroup(
            panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnClose, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
            .addComponent(btnMaximize, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnMinimize, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(labelNama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panelMenu.setBackground(new java.awt.Color(153, 153, 153));

        btnMasterData.setBackground(new java.awt.Color(0, 0, 204));
        btnMasterData.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnMasterData.setForeground(new java.awt.Color(255, 255, 255));
        btnMasterData.setText("  Master Data");
        btnMasterData.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnMasterData.setContentAreaFilled(false);
        btnMasterData.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMasterData.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnMasterData.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnMasterData.setOpaque(true);
        btnMasterData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMasterDataMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMasterDataMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMasterDataMouseExited(evt);
            }
        });

        btnTransaksi.setBackground(new java.awt.Color(0, 0, 204));
        btnTransaksi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnTransaksi.setForeground(new java.awt.Color(255, 255, 255));
        btnTransaksi.setText("  Transaksi");
        btnTransaksi.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnTransaksi.setContentAreaFilled(false);
        btnTransaksi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTransaksi.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnTransaksi.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTransaksi.setOpaque(true);
        btnTransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTransaksiMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnTransaksiMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTransaksiMouseExited(evt);
            }
        });

        btnLaporan.setBackground(new java.awt.Color(0, 0, 204));
        btnLaporan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnLaporan.setForeground(new java.awt.Color(255, 255, 255));
        btnLaporan.setText("  Laporan");
        btnLaporan.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnLaporan.setContentAreaFilled(false);
        btnLaporan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLaporan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnLaporan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLaporan.setOpaque(true);
        btnLaporan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLaporanMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLaporanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLaporanMouseExited(evt);
            }
        });

        btnAbout.setBackground(new java.awt.Color(0, 0, 204));
        btnAbout.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAbout.setForeground(new java.awt.Color(255, 255, 255));
        btnAbout.setText("  About");
        btnAbout.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnAbout.setContentAreaFilled(false);
        btnAbout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAbout.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAbout.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAbout.setOpaque(true);
        btnAbout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAboutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAboutMouseExited(evt);
            }
        });
        btnAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAboutActionPerformed(evt);
            }
        });

        btnmbook.setBackground(new java.awt.Color(0, 0, 204));
        btnmbook.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnmbook.setForeground(new java.awt.Color(255, 255, 255));
        btnmbook.setText(" Manual Book");
        btnmbook.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnmbook.setContentAreaFilled(false);
        btnmbook.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnmbook.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnmbook.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnmbook.setOpaque(true);
        btnmbook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnmbookMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnmbookMouseExited(evt);
            }
        });
        btnmbook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmbookActionPerformed(evt);
            }
        });

        panelJam.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout panelJamLayout = new javax.swing.GroupLayout(panelJam);
        panelJam.setLayout(panelJamLayout);
        panelJamLayout.setHorizontalGroup(
            panelJamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelJamLayout.setVerticalGroup(
            panelJamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 93, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 126, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );

        tgl.setBackground(new java.awt.Color(153, 153, 153));
        tgl.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        tgl.setForeground(new java.awt.Color(255, 255, 255));
        tgl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tgl.setOpaque(true);

        jam.setBackground(new java.awt.Color(153, 153, 153));
        jam.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jam.setForeground(new java.awt.Color(255, 255, 255));
        jam.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jam.setOpaque(true);

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tgl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jam, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelJam, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMenuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnMasterData, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                        .addComponent(btnTransaksi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLaporan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAbout, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnmbook, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMenuLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))))
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(btnMasterData, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnLaporan, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnAbout, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnmbook, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(196, 196, 196)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tgl, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jam, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(panelJam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(362, Short.MAX_VALUE))
        );

        tgl.setText(new WaktuSekarang().getTgl());
        tgl.setPreferredSize(new java.awt.Dimension(120,22));
        jam.setText(new WaktuSekarang().getWkt());
        jam.setPreferredSize(new java.awt.Dimension(100,22));

        panelMasterData.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnDataPendapatan.setBackground(new java.awt.Color(0, 0, 204));
        btnDataPendapatan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnDataPendapatan.setForeground(new java.awt.Color(255, 255, 255));
        btnDataPendapatan.setText("  > Data Pendapatan");
        btnDataPendapatan.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnDataPendapatan.setContentAreaFilled(false);
        btnDataPendapatan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDataPendapatan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnDataPendapatan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDataPendapatan.setOpaque(true);
        btnDataPendapatan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDataPendapatanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDataPendapatanMouseExited(evt);
            }
        });
        btnDataPendapatan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDataPendapatanActionPerformed(evt);
            }
        });

        btnDataPengeluaran.setBackground(new java.awt.Color(0, 0, 204));
        btnDataPengeluaran.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnDataPengeluaran.setForeground(new java.awt.Color(255, 255, 255));
        btnDataPengeluaran.setText("> Data Pengeluaran");
        btnDataPengeluaran.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnDataPengeluaran.setContentAreaFilled(false);
        btnDataPengeluaran.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDataPengeluaran.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnDataPengeluaran.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDataPengeluaran.setOpaque(true);
        btnDataPengeluaran.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDataPengeluaranMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDataPengeluaranMouseExited(evt);
            }
        });
        btnDataPengeluaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDataPengeluaranActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelMasterDataLayout = new javax.swing.GroupLayout(panelMasterData);
        panelMasterData.setLayout(panelMasterDataLayout);
        panelMasterDataLayout.setHorizontalGroup(
            panelMasterDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnDataPendapatan, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
            .addComponent(btnDataPengeluaran, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        panelMasterDataLayout.setVerticalGroup(
            panelMasterDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMasterDataLayout.createSequentialGroup()
                .addComponent(btnDataPendapatan, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDataPengeluaran, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelTransaksi.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnSaldoKas.setBackground(new java.awt.Color(0, 0, 204));
        btnSaldoKas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSaldoKas.setForeground(new java.awt.Color(255, 255, 255));
        btnSaldoKas.setText("  > Saldo Kas");
        btnSaldoKas.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnSaldoKas.setContentAreaFilled(false);
        btnSaldoKas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSaldoKas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnSaldoKas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSaldoKas.setOpaque(true);
        btnSaldoKas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSaldoKasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSaldoKasMouseExited(evt);
            }
        });
        btnSaldoKas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaldoKasActionPerformed(evt);
            }
        });

        btnBiayaOperasional.setBackground(new java.awt.Color(0, 0, 204));
        btnBiayaOperasional.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnBiayaOperasional.setForeground(new java.awt.Color(255, 255, 255));
        btnBiayaOperasional.setText("  > Biaya Operasional");
        btnBiayaOperasional.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnBiayaOperasional.setContentAreaFilled(false);
        btnBiayaOperasional.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBiayaOperasional.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnBiayaOperasional.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBiayaOperasional.setOpaque(true);
        btnBiayaOperasional.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBiayaOperasionalMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBiayaOperasionalMouseExited(evt);
            }
        });
        btnBiayaOperasional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBiayaOperasionalActionPerformed(evt);
            }
        });

        btnDetailKeuangan.setBackground(new java.awt.Color(0, 0, 204));
        btnDetailKeuangan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnDetailKeuangan.setForeground(new java.awt.Color(255, 255, 255));
        btnDetailKeuangan.setText("  > Detail Keuangan");
        btnDetailKeuangan.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnDetailKeuangan.setContentAreaFilled(false);
        btnDetailKeuangan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDetailKeuangan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnDetailKeuangan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDetailKeuangan.setOpaque(true);
        btnDetailKeuangan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDetailKeuanganMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDetailKeuanganMouseExited(evt);
            }
        });
        btnDetailKeuangan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetailKeuanganActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelTransaksiLayout = new javax.swing.GroupLayout(panelTransaksi);
        panelTransaksi.setLayout(panelTransaksiLayout);
        panelTransaksiLayout.setHorizontalGroup(
            panelTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnBiayaOperasional, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
            .addComponent(btnSaldoKas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnDetailKeuangan, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        panelTransaksiLayout.setVerticalGroup(
            panelTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTransaksiLayout.createSequentialGroup()
                .addComponent(btnSaldoKas, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnBiayaOperasional, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnDetailKeuangan, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelLaporan.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnLapKeuangan.setBackground(new java.awt.Color(0, 0, 204));
        btnLapKeuangan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnLapKeuangan.setForeground(new java.awt.Color(255, 255, 255));
        btnLapKeuangan.setText("  > Laporan Keuangan");
        btnLapKeuangan.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnLapKeuangan.setContentAreaFilled(false);
        btnLapKeuangan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLapKeuangan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnLapKeuangan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLapKeuangan.setOpaque(true);
        btnLapKeuangan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLapKeuanganMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLapKeuanganMouseExited(evt);
            }
        });
        btnLapKeuangan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLapKeuanganActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLaporanLayout = new javax.swing.GroupLayout(panelLaporan);
        panelLaporan.setLayout(panelLaporanLayout);
        panelLaporanLayout.setHorizontalGroup(
            panelLaporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnLapKeuangan, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        panelLaporanLayout.setVerticalGroup(
            panelLaporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnLapKeuangan, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/background.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");

        javax.swing.GroupLayout panelUtamaLayout = new javax.swing.GroupLayout(panelUtama);
        panelUtama.setLayout(panelUtamaLayout);
        panelUtamaLayout.setHorizontalGroup(
            panelUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelUtamaLayout.createSequentialGroup()
                .addComponent(panelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelMasterData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelLaporan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 996, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelUtamaLayout.setVerticalGroup(
            panelUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUtamaLayout.createSequentialGroup()
                .addComponent(panelHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelUtamaLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(panelUtamaLayout.createSequentialGroup()
                                .addComponent(panelMasterData, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(73, 73, 73)
                                .addComponent(panelTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(panelLaporan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(241, 415, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelUtama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelUtama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseEntered
        btnClose.setBackground(Color.red);
    }//GEN-LAST:event_btnCloseMouseEntered

    private void btnCloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseExited
        btnClose.setBackground(new Color(102,0,153));
    }//GEN-LAST:event_btnCloseMouseExited

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        String ObjButton[] = {"YES","NO"};
        int pilihan = JOptionPane.showOptionDialog(null,"Apakah Anda yakin ingi keluar?","Message", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                null,ObjButton,ObjButton[1]);
        if(pilihan == 0){
            System.exit(0);
        }
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnMinimizeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizeMouseEntered
        btnMinimize.setBackground(new Color(102,102,102));
    }//GEN-LAST:event_btnMinimizeMouseEntered

    private void btnMasterDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMasterDataMouseClicked
        panelMasterData.setVisible(true);
        panelTransaksi.setVisible(false);
        panelLaporan.setVisible(false);
    }//GEN-LAST:event_btnMasterDataMouseClicked

    private void btnTransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTransaksiMouseClicked
        panelTransaksi.setVisible(true);
        panelMasterData.setVisible(false);
        panelLaporan.setVisible(false);
    }//GEN-LAST:event_btnTransaksiMouseClicked

    private void btnLaporanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLaporanMouseClicked
        panelLaporan.setVisible(true);
        panelTransaksi.setVisible(false);
        panelMasterData.setVisible(false);
    }//GEN-LAST:event_btnLaporanMouseClicked

    private void btnDataPendapatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDataPendapatanActionPerformed
        panelMasterData.setVisible(false);
        new PendapatanData(this, rootPaneCheckingEnabled).show();
    }//GEN-LAST:event_btnDataPendapatanActionPerformed

    private void panelUtamaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelUtamaMouseClicked
        panelMasterData.setVisible(false);
        panelTransaksi.setVisible(false);
        panelLaporan.setVisible(false);
    }//GEN-LAST:event_panelUtamaMouseClicked

    private void btnMasterDataMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMasterDataMouseEntered
        btnMasterData.setForeground(Color.red);
        btnMasterData.setBackground(new Color(0,0,102));
    }//GEN-LAST:event_btnMasterDataMouseEntered

    private void btnMasterDataMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMasterDataMouseExited
        btnMasterData.setForeground(Color.white);
        btnMasterData.setBackground(new Color(0,0,204));
    }//GEN-LAST:event_btnMasterDataMouseExited

    private void btnTransaksiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTransaksiMouseEntered
        btnTransaksi.setForeground(Color.red);
        btnTransaksi.setBackground(new Color(0,0,102));
    }//GEN-LAST:event_btnTransaksiMouseEntered

    private void btnTransaksiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTransaksiMouseExited
        btnTransaksi.setForeground(Color.white);
        btnTransaksi.setBackground(new Color(0,0,204));
    }//GEN-LAST:event_btnTransaksiMouseExited

    private void btnLaporanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLaporanMouseEntered
        btnLaporan.setForeground(Color.red);
        btnLaporan.setBackground(new Color(0,0,102));
    }//GEN-LAST:event_btnLaporanMouseEntered

    private void btnLaporanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLaporanMouseExited
        btnLaporan.setForeground(Color.white);
        btnLaporan.setBackground(new Color(0,0,204));
    }//GEN-LAST:event_btnLaporanMouseExited

    private void btnDataPendapatanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDataPendapatanMouseEntered
        btnDataPendapatan.setForeground(Color.red);
        btnDataPendapatan.setBackground(new Color(0,0,102));
    }//GEN-LAST:event_btnDataPendapatanMouseEntered

    private void btnDataPendapatanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDataPendapatanMouseExited
        btnDataPendapatan.setForeground(Color.white);
        btnDataPendapatan.setBackground(new Color(0,0,204));
    }//GEN-LAST:event_btnDataPendapatanMouseExited

    private void btnDataPengeluaranMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDataPengeluaranMouseEntered
        btnDataPengeluaran.setForeground(Color.red);
        btnDataPengeluaran.setBackground(new Color(0,0,102));
    }//GEN-LAST:event_btnDataPengeluaranMouseEntered

    private void btnDataPengeluaranMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDataPengeluaranMouseExited
        btnDataPengeluaran.setForeground(Color.white);
        btnDataPengeluaran.setBackground(new Color(0,0,204));
    }//GEN-LAST:event_btnDataPengeluaranMouseExited

    private void btnSaldoKasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaldoKasMouseEntered
        btnSaldoKas.setForeground(Color.red);
        btnSaldoKas.setBackground(new Color(0,0,102));
    }//GEN-LAST:event_btnSaldoKasMouseEntered

    private void btnSaldoKasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaldoKasMouseExited
        btnSaldoKas.setForeground(Color.white);
        btnSaldoKas.setBackground(new Color(0,0,204));
    }//GEN-LAST:event_btnSaldoKasMouseExited

    private void btnBiayaOperasionalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBiayaOperasionalMouseEntered
        btnBiayaOperasional.setForeground(Color.red);
        btnBiayaOperasional.setBackground(new Color(0,0,102));
    }//GEN-LAST:event_btnBiayaOperasionalMouseEntered

    private void btnBiayaOperasionalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBiayaOperasionalMouseExited
        btnBiayaOperasional.setForeground(Color.white);
        btnBiayaOperasional.setBackground(new Color(0,0,204));
    }//GEN-LAST:event_btnBiayaOperasionalMouseExited

    private void btnLapKeuanganMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLapKeuanganMouseEntered
        btnLapKeuangan.setForeground(Color.red);
        btnLapKeuangan.setBackground(new Color(0,0,102));
    }//GEN-LAST:event_btnLapKeuanganMouseEntered

    private void btnLapKeuanganMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLapKeuanganMouseExited
        btnLapKeuangan.setForeground(Color.white);
        btnLapKeuangan.setBackground(new Color(0,0,204));
    }//GEN-LAST:event_btnLapKeuanganMouseExited

    private void btnMaximizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMaximizeMouseClicked
        if(maximixed){
            menuUtama1.this.setExtendedState(JFrame.MAXIMIZED_BOTH);
            GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
            menuUtama1.this.setMaximizedBounds(env.getMaximumWindowBounds());
            maximixed = false;
        } else {
            setExtendedState(JFrame.NORMAL);
            maximixed = true;
        }
    }//GEN-LAST:event_btnMaximizeMouseClicked

    private void btnMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizeMouseClicked
        this.setState(Frame.ICONIFIED);
    }//GEN-LAST:event_btnMinimizeMouseClicked

    private void labelNamaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelNamaMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_labelNamaMousePressed

    private void labelNamaMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelNamaMouseDragged
        if(maximixed){
            int x = evt.getXOnScreen();
            int y = evt.getYOnScreen();
            this.setLocation(x - xMouse, y - yMouse);
        }
    }//GEN-LAST:event_labelNamaMouseDragged

    private void btnDataPengeluaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDataPengeluaranActionPerformed
        panelMasterData.setVisible(false);
        new Pengeluaran(this, rootPaneCheckingEnabled).show();
    }//GEN-LAST:event_btnDataPengeluaranActionPerformed

    private void btnSaldoKasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaldoKasActionPerformed
        panelTransaksi.setVisible(false);
        new SaldoKas(this, rootPaneCheckingEnabled).show();
    }//GEN-LAST:event_btnSaldoKasActionPerformed

    private void btnBiayaOperasionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBiayaOperasionalActionPerformed
        panelTransaksi.setVisible(false);
        new TransaksiBiayaOperasional(this, rootPaneCheckingEnabled).show();
    }//GEN-LAST:event_btnBiayaOperasionalActionPerformed

    private void btnLapKeuanganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLapKeuanganActionPerformed
        panelLaporan.setVisible(false);
        new LaporanKeuangan(this, rootPaneCheckingEnabled).show();
    }//GEN-LAST:event_btnLapKeuanganActionPerformed

    private void btnAboutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAboutMouseEntered
        btnAbout.setForeground(Color.red);
        btnAbout.setBackground(new Color(0,0,102));
    }//GEN-LAST:event_btnAboutMouseEntered

    private void btnAboutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAboutMouseExited
        btnAbout.setForeground(Color.white);
        btnAbout.setBackground(new Color(0,0,204));
    }//GEN-LAST:event_btnAboutMouseExited

    private void btnAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAboutActionPerformed
        new about1(this, rootPaneCheckingEnabled).show();
    }//GEN-LAST:event_btnAboutActionPerformed

    private void btnDetailKeuanganMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDetailKeuanganMouseEntered
        btnDetailKeuangan.setForeground(Color.red);
        btnDetailKeuangan.setBackground(new Color(0,0,102));
    }//GEN-LAST:event_btnDetailKeuanganMouseEntered

    private void btnDetailKeuanganMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDetailKeuanganMouseExited
        btnDetailKeuangan.setForeground(Color.white);
        btnDetailKeuangan.setBackground(new Color(0,0,204));
    }//GEN-LAST:event_btnDetailKeuanganMouseExited

    private void btnDetailKeuanganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetailKeuanganActionPerformed
        panelMasterData.setVisible(false);
        new DetailKeuangan(this, rootPaneCheckingEnabled).show();
    }//GEN-LAST:event_btnDetailKeuanganActionPerformed

    private void btnmbookMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnmbookMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnmbookMouseEntered

    private void btnmbookMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnmbookMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnmbookMouseExited

    private void btnmbookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmbookActionPerformed
        // 
        try{
            File file = new File("D:\\AMIKOM 23\\pbo\\PROJECT AKHIr\\"
                    + "KeuanganPerusahaan2\\src\\pdf\\MBOOK.pdf");
            if(file.exists()){
                if(Desktop.isDesktopSupported()){
                    Desktop.getDesktop().open(file);
                }else{
                    JOptionPane.showMessageDialog(this, "");
                }
            }else{
                JOptionPane.showMessageDialog(this, "File Not Exist");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnmbookActionPerformed

 
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(menuUtama1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menuUtama1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menuUtama1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menuUtama1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                menuUtama1 mn = new menuUtama1();
                mn.setExtendedState(JFrame.MAXIMIZED_BOTH);
                mn.setVisible(true);
            }           
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbout;
    private javax.swing.JButton btnBiayaOperasional;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDataPendapatan;
    private javax.swing.JButton btnDataPengeluaran;
    private javax.swing.JButton btnDetailKeuangan;
    private javax.swing.JButton btnLapKeuangan;
    private javax.swing.JButton btnLaporan;
    private javax.swing.JButton btnMasterData;
    private javax.swing.JButton btnMaximize;
    private javax.swing.JButton btnMinimize;
    private javax.swing.JButton btnSaldoKas;
    private javax.swing.JButton btnTransaksi;
    private javax.swing.JButton btnmbook;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jam;
    private javax.swing.JLabel labelNama;
    private javax.swing.JPanel panelHeader;
    private javax.swing.JPanel panelJam;
    private javax.swing.JPanel panelLaporan;
    private javax.swing.JPanel panelMasterData;
    private javax.swing.JPanel panelMenu;
    private javax.swing.JPanel panelTransaksi;
    private javax.swing.JPanel panelUtama;
    private javax.swing.JLabel tgl;
    // End of variables declaration//GEN-END:variables
}
