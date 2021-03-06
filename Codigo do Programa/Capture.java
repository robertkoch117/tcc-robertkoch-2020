/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capture;

import Principal.Home;
import Util.ConectaBanco;
import Util.ControlPerson;
import Util.ControlUser;
import Util.ModelPerson;
import Util.ModelUser;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import org.bytedeco.opencv.opencv_objdetect.*;
import static org.bytedeco.opencv.global.opencv_core.*;
import static org.bytedeco.opencv.global.opencv_imgproc.*;
import org.bytedeco.opencv.opencv_videoio.*;
import static org.bytedeco.opencv.global.opencv_imgcodecs.*;
import org.bytedeco.opencv.opencv_face.*;
import org.bytedeco.opencv.global.opencv_imgproc;
/**
 *
 * @author KOCH
 */
public class Capture extends javax.swing.JFrame {

    /**
     * Creates new form Capture
     */
    
    private Capture.DaemonThread myThread = null;
    
    //JavaCV
    VideoCapture webSource = null;
    Mat cameraImage = new Mat();
    CascadeClassifier cascade = new CascadeClassifier("C:\\RFDados\\haarcascade_frontalface_alt.xml");
    
    BytePointer mem = new BytePointer();
    RectVector detectedFaces = new RectVector();
    
    //Vars Personal
    String root, firstNamePerson, lastNamePerson, officePerson, dobPerson, pass;
    int idPerson=0;
    
    //Ordinal
    int numSamples = 30, sample = 1;
    
    // Vars User
    String user, password;
    int idUser=0;
    
    //Utils
    ConectaBanco conecta = new ConectaBanco();
    
    //Vars restaurar Home
    Home home;
    
    //Register User
    public Capture(int id, String User, String Password, Home home){
        
        initComponents();
        this.home = home;
        
        user = User;
        idUser = id;
        password = Password;
        
        startCamera();
    }
    
    //Register Person
    public Capture(int id, String fName, String lName, String office, String dob,String pass, Home home) {
        initComponents();
        this.home = home;
        
        idPerson = id;
        firstNamePerson = fName;
        lastNamePerson = lName;
        officePerson = office;
        dobPerson = dob;
        this.pass = pass;
        startCamera();
        
    }

    private Capture() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        label_photo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        counterLabel = new javax.swing.JLabel();
        saveButton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btn_minimizar = new javax.swing.JLabel();
        btn_fechar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Security System - Capture Photos");
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_photo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 200, 200)));
        jPanel1.add(label_photo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 370, 380));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        counterLabel.setBackground(new java.awt.Color(251, 82, 82));
        counterLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        counterLabel.setForeground(new java.awt.Color(255, 255, 255));
        counterLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        counterLabel.setText("00");
        counterLabel.setOpaque(true);
        jPanel2.add(counterLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 80, 40));

        saveButton.setBackground(new java.awt.Color(78, 78, 78));
        saveButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        saveButton.setForeground(new java.awt.Color(255, 255, 255));
        saveButton.setText("Capture");
        saveButton.setContentAreaFilled(false);
        saveButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        saveButton.setOpaque(true);
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        
        btn_minimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_minimizarMousePressed(evt);
            }
        });
        jPanel4.add(btn_minimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, -1, 28));

        btn_fechar.setBackground(new java.awt.Color(54, 33, 89));
        btn_fechar.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        btn_fechar.setForeground(new java.awt.Color(255, 255, 255));
        btn_fechar.setText("X");
        btn_fechar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_fecharMousePressed(evt);
            }
        });
        jPanel4.add(btn_fechar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, -1, 28));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 550));

        setSize(new java.awt.Dimension(398, 527));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saveButtonActionPerformed

    private void btn_minimizarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_minimizarMousePressed
        // TODO add your handling code here:
        setState(Frame.ICONIFIED); // comando que minimiza a tela
    }//GEN-LAST:event_btn_minimizarMousePressed

    private void btn_fecharMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_fecharMousePressed
        // TODO add your handling code here:

        stopCamera(); //fecho o frame atual (Register)

        home.setState(Frame.NORMAL); //restauro o jframe 'home'
    }//GEN-LAST:event_btn_fecharMousePressed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Capture.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Capture.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Capture.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Capture.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Capture().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btn_fechar;
    private javax.swing.JLabel btn_minimizar;
    private javax.swing.JLabel counterLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel label_photo;
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables

    class DaemonThread implements Runnable {

        protected volatile boolean runnable = false;

        @Override
        public void run() {
            synchronized (this) {
                while (runnable) {
                    try {
                        if (webSource.grab()) {
                            webSource.retrieve(cameraImage);
                            
                            for (int i = 0; i < detectedFaces.size(); i++) {
                                Rect dadosFace = detectedFaces.get(0);
                                
                                
                                //DECISÃO DE ONDE SALVAR AS FOTOS
                                if (saveButton.getModel().isPressed()) {
                                    if (sample <= numSamples) {
                                        
                                       
                                        System.out.println("Foto " + sample + " salva.\n");
                                        counterLabel.setText(String.valueOf(sample));
                                        sample++;
                                    }
                                    
                                    
                                        }
                                    }
                                }
                            }

                            imencode(".bmp", cameraImage, mem);
                            
                        }

                    } catch (IOException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Erro ao iniciar camera (IOEx)\n" + ex);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Erro ao iniciar camera (Interrupted)\n" + ex);
                    }
                }
            }
        }
    }


    public void generate(){
       
        FilenameFilter filter = new FilenameFilter() {

            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".jpg") || name.endsWith(".png");
            }
        };
        
         if(idPerson>0){
            File directory = new File("C:\\RFDados\\photos_person");
            
             }
            
            FaceRecognizer lbph = LBPHFaceRecognizer.create(13,12,15,15,0);
            
            lbph.train(photos, labels);
            lbph.save("C:\\RFDados\\photos_person\\classifierLBPHperson.yml");
            
            
        }else{
            File directory = new File("C:\\RFDados\\photos_user");
            File[] files = directory.listFiles(filter);
            
            
                counter++;
             }
             
                       
            lbph.train(photos, labels);
            lbph.save("C:\\RFDados\\photos_user\\classifierLBPHuser.yml");
        }
         
    }
    
    public void insertDatabasePerson(){
        ControlPerson cod = new ControlPerson();
        ModelPerson mod = new ModelPerson();
        
        mod.setId(idPerson);
        mod.setPassword(pass);
        
        cod.inserir(mod);
    }
     public void insertDatabaseUser(){
        ControlUser cod = new ControlUser();
        ModelUser mod = new ModelUser();
        
        mod.setId(idUser);
        cod.inserir(mod);
    }
    
    private void stopCamera(){
        myThread.runnable = false;
        webSource.release();
        dispose();
    }
    
    private void startCamera(){
        webSource = new VideoCapture(0);
        t.start();
    }
    
    
    
}
