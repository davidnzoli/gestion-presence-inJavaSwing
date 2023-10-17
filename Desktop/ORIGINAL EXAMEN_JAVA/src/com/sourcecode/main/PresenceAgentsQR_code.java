
package com.sourcecode.main;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import static java.awt.Color.red;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class PresenceAgentsQR_code extends javax.swing.JFrame implements Runnable,ThreadFactory {

        public Connection getConnection(){
        Connection con = null;
        
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/db_gestionpresence","root","");
            return con;
        } catch (SQLException ex) {
            Logger.getLogger(Gest_personnel.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Not connected"+ ex);
            return null;
        }
    }
        
    
        
        
    private WebcamPanel panel= null;
    private Webcam webcam = null;
    private Executor executor = Executors.newSingleThreadExecutor(this);
    
    
    public PresenceAgentsQR_code() {
        initComponents();
        this.setLocationRelativeTo(null);
//        this.setSize(1150, 752);
        initwebcam();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        txtId = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        messageResult = new javax.swing.JTextField();
        iconprofil = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        journalFiche = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EFFECTUEZ LA PRESENCE");
        setUndecorated(true);

        txtId.setBackground(new java.awt.Color(255, 255, 255));
        txtId.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(0, 102, 153));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("SCAN QR CODE");

        messageResult.setBackground(new java.awt.Color(204, 204, 204));
        messageResult.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        messageResult.setForeground(new java.awt.Color(0, 102, 153));
        messageResult.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        messageResult.setText("Resultat...");
        messageResult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                messageResultActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(messageResult, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(messageResult, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        iconprofil.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        iconprofil.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconprofil.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        iconprofil.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("  Back");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        journalFiche.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "nom", "postnom", "prenom", "matricul", "post", "sexe"
            }
        ));
        jScrollPane1.setViewportView(table);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 102));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("LISTE DE PRESENCES DES AGENTS");
        jLabel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout journalFicheLayout = new javax.swing.GroupLayout(journalFiche);
        journalFiche.setLayout(journalFicheLayout);
        journalFicheLayout.setHorizontalGroup(
            journalFicheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(journalFicheLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(journalFicheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        journalFicheLayout.setVerticalGroup(
            journalFicheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(journalFicheLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setBackground(new java.awt.Color(0, 102, 153));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Print list");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(iconprofil, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(journalFiche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 733, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(journalFiche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(110, 110, 110))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(iconprofil, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        txtId.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 540));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void messageResultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_messageResultActionPerformed
    
        
    }//GEN-LAST:event_messageResultActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        Main_Windows tools = new Main_Windows();
        tools.setVisible(true);
        
        this.removeAll();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        PrinterJob job= PrinterJob.getPrinterJob();
        job.setJobName("journalFiche");
        job.setPrintable(new Printable()
            {
                public int print(Graphics pg, PageFormat pf, int pageNum){
                if(pageNum>0){
                    return Printable.NO_SUCH_PAGE;
                    }
                Graphics2D g2 =(Graphics2D)pg;
                g2.translate(pf.getImageableX(), pf.getImageableY());
                g2.scale(0.24,0.24);
                journalFiche.paint(g2);
                return Printable.PAGE_EXISTS;
                }
            });
        
        boolean ok = job.printDialog();
        if (ok){
        
        try{
        job.print();
        }catch(Exception ex){}}
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PresenceAgentsQR_code.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PresenceAgentsQR_code.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PresenceAgentsQR_code.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PresenceAgentsQR_code.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PresenceAgentsQR_code().setVisible(true);
            }
        });
    }

    private void initwebcam(){
    Dimension size = WebcamResolution.QVGA.getSize();
    webcam = Webcam.getWebcams().get(0);
    webcam.setViewSize(size);
        
    panel = new WebcamPanel (webcam);
    panel.setPreferredSize(size);
    panel.setFPSDisplayed(true);
    
//    jPanel2.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0,0,470,300));
    jPanel2.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0,0,400,300));
    
    
    
    
    executor.execute(this);
    }
    
    
    @Override
    
    public void run(){
    do{
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            Logger.getLogger(PresenceAgentsQR_code.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Result result = null;
        BufferedImage image = null;
         
        if(webcam.isOpen()){
        
                if((image=webcam.getImage())== null){
                    continue;
                }
           }
        LuminanceSource source = new BufferedImageLuminanceSource(image);
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
        
        try {
            result = new MultiFormatReader().decode(bitmap);
        } catch (NotFoundException ex) {
            Logger.getLogger(PresenceAgentsQR_code.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(result!=null){
            messageResult.setText(result.getText()); 
            
       String filtre = messageResult.getText();
       String select = "SELECT Id,Nom,Postnom,Prenom,Matricule,Poste,Sexe FROM t_personnel WHERE Nom='"+filtre+"'";
       PreparedStatement pst;
       
       try{
           Connection con = getConnection();
           pst = con.prepareStatement(select);
           ResultSet rs = pst.executeQuery();
           ResultSetMetaData RMD = rs.getMetaData();
           int c = RMD.getColumnCount();
           DefaultTableModel TM = (DefaultTableModel) table.getModel();
           TM.setRowCount(c);
           
           while(rs.next()){
               Vector v2 = new Vector();
               
               for(int i=0; i<=c; i++){
                   
                   v2.add(rs.getInt("Id"));
                    v2.add(rs.getString("Nom"));
                     v2.add(rs.getString("Postnom"));
                      v2.add(rs.getString("Prenom"));
                      v2.add(rs.getString("Matricule"));
                      v2.add(rs.getString("Poste"));
                      v2.add(rs.getString("Sexe"));
                       
               }
              TM.addRow(v2);
           }
           
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null, "erreur de la recuperation de donnée" + e);
       }
   
       
        PresenceAgentsQR_code.func f= new PresenceAgentsQR_code.func();
        rs = f.find(messageResult.getText());
        
        try {
            if (rs.next()){
                byte[] imag = rs.getBytes("Profil");
                ImageIcon photo = new ImageIcon(imag);
                Image im = photo.getImage();
                Image myimg = im.getScaledInstance(iconprofil.getWidth(), iconprofil.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon newImage =new ImageIcon(myimg);
                iconprofil.setIcon(newImage);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PresenceAgentsQR_code.class.getName()).log(Level.SEVERE, null, ex);
        }
  
            
//             try{
//                Connection con = getConnection();
//                PreparedStatement pst = con.prepareStatement("INSERT INTO t_presence (identite) values (?)");
//                pst.setString(1, messageResult.getText());
//                
//                
//                   int response =JOptionPane.showConfirmDialog(null, "Vous reconnaissez ce code QR ? Cliquez sur oui si c'est oui");
//                   if(response==0){
//                       pst.executeUpdate();
//                       String nom = messageResult.getText();
//                       viderChamp();
//                       JOptionPane.showMessageDialog(null, nom +" est reconnu");
//                       
//                   }else{
//                       String nom = messageResult.getText();
//                       viderChamp();
//                       JOptionPane.showMessageDialog(null, nom +" n'est pas reconnu");
//                   }
//                
//            }catch(Exception ex){
//               JOptionPane.showMessageDialog(null, "error"+ ex);
//            }
//      
//             
//    Connection con = getConnection();
//    String message = messageResult.getText();
//    String rqt = "SELECT * FROM t_presence"; 
//    
//     try{
//    Statement st = con.createStatement();
//    ResultSet rs = st.executeQuery(rqt);
//    
//    
//    while(rs.next()){ 
//          String prenom = rs.getString("identite");   
//             
//        String tbData[]={prenom};//id,nom,postnom,prenom,matricul,sexe,presence};
//        DefaultTableModel tblModel = (DefaultTableModel) jTable1.getModel();
//        
//        tblModel.addRow(tbData);
//    }
//        
//    }catch(Exception ex){
//        JOptionPane.showMessageDialog(null, "error"+ ex);
//    }
  
            
//             try{
//                Connection con = getConnection();
//                PreparedStatement pst = con.prepareStatement("INSERT INTO t_presence (identite) values (?)");
//                pst.setString(1, messageResult.getText());
//                
//                
//                   int response =JOptionPane.showConfirmDialog(null, "Vous reconnaissez ce code QR ? Cliquez sur oui si c'est oui");
//                   if(response==0){
//                       pst.executeUpdate();
//                       String nom = messageResult.getText();
//                       viderChamp();
//                       JOptionPane.showMessageDialog(null, nom +" est reconnu");
//                       
//                   }else{
//                       String nom = messageResult.getText();
//                       viderChamp();
//                       JOptionPane.showMessageDialog(null, nom +" n'est pas reconnu");
//                   }
//                
//            }catch(Exception ex){
//               JOptionPane.showMessageDialog(null, "error"+ ex);
//            }
//      
//             
//    Connection con = getConnection();
//    String message = messageResult.getText();
//    String rqt = "SELECT * FROM t_presence"; 
//    
//     try{
//    Statement st = con.createStatement();
//    ResultSet rs = st.executeQuery(rqt);
//    
//    
//    while(rs.next()){ 
//          String prenom = rs.getString("identite");   
//             
//        String tbData[]={prenom};//id,nom,postnom,prenom,matricul,sexe,presence};
//        DefaultTableModel tblModel = (DefaultTableModel) jTable1.getModel();
//        
//        tblModel.addRow(tbData);
//    }
//        
//    }catch(Exception ex){
//        JOptionPane.showMessageDialog(null, "error"+ ex);
//    }
            

        }      
    }while (true);
    }
     @Override
    public Thread newThread(Runnable r){
    Thread t = new Thread (r, "My Thread");
    t.setDaemon(true);
    return t;
    }
    
    public void viderChamp(){
    messageResult.setText(" ");
    
}   
        ResultSet rs;
   
         public class func{
             
        public ResultSet find(String s){
            
       String rqt = "select  * from t_personnel where Nom = ?";
       PreparedStatement pst;
            try {
             Connection con = getConnection();
             
                pst = con.prepareCall(rqt);
                pst.setString(1, s);
                rs = pst.executeQuery();
            } catch (SQLException ex) {
                Logger.getLogger(PresenceAgentsQR_code.class.getName()).log(Level.SEVERE, null, ex);
            }
            return rs;
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel iconprofil;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel journalFiche;
    private javax.swing.JTextField messageResult;
    private javax.swing.JTable table;
    private javax.swing.JPanel txtId;
    // End of variables declaration//GEN-END:variables
}
