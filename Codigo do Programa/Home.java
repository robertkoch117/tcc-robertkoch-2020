/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import Capture.Register;
import Recognizer.Recognizer;
import Util.ConectaBanco;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import static org.bytedeco.opencv.global.opencv_imgcodecs.*;
import org.bytedeco.opencv.opencv_face.*;
import org.bytedeco.opencv.global.opencv_imgproc;
/**
 *
 * @author KOCH
 */
public class Home extends javax.swing.JFrame {

    int id, tabela,btn;
    String nome;
    Home home;
    
    ConectaBanco conecta = new ConectaBanco();
    
     private Home.DaemonThread myThread = null;
     
    //javaCV
    VideoCapture webSource = null;
    Mat cameraImage = new Mat();
    
    FaceRecognizer recognizer = LBPHFaceRecognizer.create();
    
    BytePointer mem = new BytePointer();
    RectVector detectedFaces = new RectVector();
    /**
     * Creates new form Home
     */
    
    public Home() {
        initComponents();
    }
    
    public Home(int ids ,int type ,String user) {
        initComponents();
        //Tarefa1();
        id = ids;
        tabela = type;
        nome = user;
        txt_title_menu.setText("Bem-vindo, " + nome+".");
        home = this;
        if(id==-1){
            tabela = 1;
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

        bg = new javax.swing.JPanel();
        sidepane = new javax.swing.JPanel();
        btn_home = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        btn_login = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btn_cadastrar = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btn_facial = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                bgMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bgMousePressed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                bgFocusLost(evt);
            }
        });
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sidepane.setBackground(new java.awt.Color(151, 0, 0));
        sidepane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_home.setBackground(new java.awt.Color(251, 82, 82));
        btn_home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_homeMousePressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Home");

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icons8home20px.png"))); // NOI18N

        javax.swing.GroupLayout btn_homeLayout = new javax.swing.GroupLayout(btn_home);
        btn_home.setLayout(btn_homeLayout);
        btn_homeLayout.setHorizontalGroup(
            btn_homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_homeLayout.createSequentialGroup()
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE))
        );
        btn_homeLayout.setVerticalGroup(
            btn_homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_homeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(btn_homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addContainerGap())
        );

        sidepane.add(btn_home, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 300, 50));

        btn_login.setBackground(new java.awt.Color(216, 0, 0));
        btn_login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_loginMousePressed(evt);
            }
        });

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icons8enter20px.png"))); // NOI18N

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Logout");

        javax.swing.GroupLayout btn_loginLayout = new javax.swing.GroupLayout(btn_login);
        btn_login.setLayout(btn_loginLayout);
        btn_loginLayout.setHorizontalGroup(
            btn_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_loginLayout.createSequentialGroup()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE))
        );
        btn_loginLayout.setVerticalGroup(
            btn_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btn_loginLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(btn_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addContainerGap())
        );

        sidepane.add(btn_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 300, -1));

        btn_cadastrar.setBackground(new java.awt.Color(216, 0, 0));
        btn_cadastrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_cadastrarMousePressed(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icons8addusermale20px.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Cadastrar");

        javax.swing.GroupLayout btn_cadastrarLayout = new javax.swing.GroupLayout(btn_cadastrar);
        btn_cadastrar.setLayout(btn_cadastrarLayout);
        btn_cadastrarLayout.setHorizontalGroup(
            btn_cadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_cadastrarLayout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        btn_cadastrarLayout.setVerticalGroup(
            btn_cadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btn_cadastrarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(btn_cadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        sidepane.add(btn_cadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, -1, -1));

        btn_facial.setBackground(new java.awt.Color(216, 0, 0));
        btn_facial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_facialMousePressed(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icons8facialrecognition20px.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Reconhecimento Facial");

        javax.swing.GroupLayout btn_facialLayout = new javax.swing.GroupLayout(btn_facial);
        btn_facial.setLayout(btn_facialLayout);
        btn_facialLayout.setHorizontalGroup(
            btn_facialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_facialLayout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(113, Short.MAX_VALUE))
        );
        btn_facialLayout.setVerticalGroup(
            btn_facialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btn_facialLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(btn_facialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addContainerGap())
        );

        sidepane.add(btn_facial, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, -1, -1));

        btn_editar.setBackground(new java.awt.Color(216, 0, 0));
        btn_editar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_editarMousePressed(evt);
            }
        });

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icons8registration20px.png"))); // NOI18N

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Editar");

        javax.swing.GroupLayout btn_editarLayout = new javax.swing.GroupLayout(btn_editar);
        btn_editar.setLayout(btn_editarLayout);
        btn_editarLayout.setHorizontalGroup(
            btn_editarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_editarLayout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(113, Short.MAX_VALUE))
        );
        btn_editarLayout.setVerticalGroup(
            btn_editarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btn_editarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(btn_editarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addContainerGap())
        );

        sidepane.add(btn_editar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, -1, -1));

        btn_deletar.setBackground(new java.awt.Color(216, 0, 0));
        btn_deletar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_deletarMousePressed(evt);
            }
        });

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icons8denied20px.png"))); // NOI18N

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Deletar");

        javax.swing.GroupLayout btn_deletarLayout = new javax.swing.GroupLayout(btn_deletar);
        btn_deletar.setLayout(btn_deletarLayout);
        btn_deletarLayout.setHorizontalGroup(
            btn_deletarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_deletarLayout.createSequentialGroup()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(113, Short.MAX_VALUE))
        );
        btn_deletarLayout.setVerticalGroup(
            btn_deletarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btn_deletarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(btn_deletarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addContainerGap())
        );

        sidepane.add(btn_deletar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, -1, -1));
        sidepane.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 200, 20));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("NUCAP");
        sidepane.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, 28));

        bg.add(sidepane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 520));

        jPanel1.setBackground(new java.awt.Color(253, 26, 24));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_title_menu.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txt_title_menu.setForeground(new java.awt.Color(255, 255, 255));
      
        btn_minimizar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_minimizar.setText("-");
        btn_minimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_minimizarMousePressed(evt);
            }
        });
        jPanel2.add(btn_minimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 0, -1, 28));

        btn_fechar.setBackground(new java.awt.Color(54, 33, 89));
        btn_fechar.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        btn_fechar.setForeground(new java.awt.Color(255, 255, 255));
        btn_fechar.setText("X");
        btn_fechar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_fecharMousePressed(evt);
            }
        });
        jPanel2.add(btn_fechar, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 0, -1, 28));

        bg.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 630, 30));

        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 925, 514));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    private void bgMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bgMouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_bgMouseDragged

    private void bgMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bgMousePressed
        // TODO add your handling code here:
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_bgMousePressed

    private void btn_minimizarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_minimizarMousePressed
        // TODO add your handling code here:
        setState(Frame.ICONIFIED); // comando que minimiza a tela
    }//GEN-LAST:event_btn_minimizarMousePressed

    private void bgFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bgFocusLost
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_bgFocusLost

    private void btn_homeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_homeMousePressed
        // TODO add your handling code here:
        setColor(btn_home);
        resetColor(btn_login);
        resetColor(btn_facial);
        resetColor(btn_cadastrar);
        resetColor(btn_editar);
        resetColor(btn_deletar);
    }//GEN-LAST:event_btn_homeMousePressed

    private void btn_loginMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_loginMousePressed
        // TODO add your handling code here:
        setColor(btn_login);
        resetColor(btn_home);
        resetColor(btn_facial);
        resetColor(btn_cadastrar);
        resetColor(btn_editar);
        resetColor(btn_deletar);
        Login login = new Login();
        login.setVisible(rootPaneCheckingEnabled);
        dispose();
    }//GEN-LAST:event_btn_loginMousePressed

    private void btn_cadastrarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cadastrarMousePressed
        // TODO add your handling code here:
        setColor(btn_cadastrar);
        resetColor(btn_login);
     
        btn = 1;
        checkUsuario();
       }
    }//GEN-LAST:event_btn_cadastrarMousePressed

    private void btn_facialMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_facialMousePressed
        // TODO add your handling code here:
        setColor(btn_facial);
        resetColor(btn_login);
        resetColor(btn_home);
      
                break;
            default:
                JOptionPane.showMessageDialog(null, "ALGO DEU EXTREMAMENTE ERRADO. TENTE REINICIAR O PROGRAMA.");
                break;
        }
    }//GEN-LAST:event_btn_facialMousePressed

    private void btn_fecharMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_fecharMousePressed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btn_fecharMousePressed

    private void btn_editarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_editarMousePressed
        // TODO add your handling code here:
        setColor(btn_editar);
        resetColor(btn_login);
        resetColor(btn_home);
        resetColor(btn_deletar);
        resetColor(btn_cadastrar);
        resetColor(btn_facial);
        
        if (id==-1){
        setState(Frame.ICONIFIED); //minimizo o frame atual
        new Editar(this).setVisible(true); // estou enviando a instancia atual do frame (home) para o frame Register através do 'this'
        }else{
        recognizer.read("C:\\RFDados\\photos_user\\classifierLBPHuser.yml");
        btn=3;
        checkUsuario();
       }
    }//GEN-LAST:event_btn_editarMousePressed

    private void btn_deletarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_deletarMousePressed
        // TODO add your handling code here:
        setColor(btn_deletar);
        resetColor(btn_login);
        resetColor(btn_home);
        resetColor(btn_editar);
        resetColor(btn_cadastrar);
        resetColor(btn_facial);
        
        if (id==-1){
        setState(Frame.ICONIFIED); //minimizo o frame atual
        new Deletar(this).setVisible(true); // estou enviando a instancia atual do frame (home) para o frame Register através do 'this'
        }else{
        recognizer.read("C:\\RFDados\\photos_user\\classifierLBPHuser.yml");
        btn=2;
        checkUsuario();
       }
        
    }//GEN-LAST:event_btn_deletarMousePressed
    
    
    void setColor(JPanel panel){
        panel.setBackground(new Color(251,82,82));
    }
    
    void resetColor(JPanel panel){
        panel.setBackground(new Color(216,0,0));
    }
    
    private void sidepaneMouseDragged(java.awt.event.MouseEvent evt){
    
    }
    
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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }
    
    int xx;
    int xy;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JPanel btn_cadastrar;
    private javax.swing.JPanel btn_deletar;
    private javax.swing.JPanel btn_editar;
    private javax.swing.JPanel btn_facial;
    private javax.swing.JLabel btn_fechar;
    private javax.swing.JPanel btn_home;
    private javax.swing.JPanel btn_login;
    private javax.swing.JLabel btn_minimizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel sidepane;
    private javax.swing.JLabel txt_title_menu;
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

                            Mat imageGray = new Mat();
                            cvtColor(cameraImage, imageGray, COLOR_BGRA2GRAY);

                            
                                }
                            }

                            imencode(".bmp", cameraImage, mem);
                            Image im = ImageIO.read(new ByteArrayInputStream(mem.getStringBytes()));
                            

                            
                                if (runnable == false) {
                                    System.out.println("Salve a Foto");
                                    this.wait();    
                            }
                        }
                    } catch (IOException | InterruptedException ex) {
                        System.out.println("Error class DaemonThread da classe Recognizer: " + ex);
                    }
                }
            }
        }

    }
  

    private void stopCamera(){
         myThread.runnable = false;
        webSource.release();
    }

    private void startCamera(){
         webSource = new VideoCapture(0);
            myThread = new Home.DaemonThread();
            Thread t = new Thread(myThread);
            t.setDaemon(true);
            myThread.runnable = true;
            t.start();
    }
    
    
    public void checkUsuario(){
        if(tabela==1){
           startCamera();
        }else{
            JOptionPane.showMessageDialog(null,nome+", seu tipo de cadastro não possui permissão "
                    + "de acessar essa função.");
        }
    }

}
