/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Canvas;

import Model.Bean.UsuarioBean;
import Model.dao.UsuarioDao;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Evand
 */
public class SignUp extends javax.swing.JFrame {
    private int operacao;
    /**
     * Creates new form SignU
     */
    public SignUp() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jtfName = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        theClickSaveDB = new javax.swing.JButton();
        theClickSignIn = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jtfPassword = new javax.swing.JPasswordField();
        jtfOffice = new javax.swing.JTextField();
        jtfEmail = new javax.swing.JTextField();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(420, 780));
        jPanel1.setPreferredSize(new java.awt.Dimension(420, 780));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Aqui você terá experiências inesquecieveis");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Venha Conosco");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 430, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\gabri\\OneDrive\\Área de Trabalho\\Faculdade\\Pi Modelo 3 Semestre\\Projeto POO\\SelectCar 2.0\\resources\\degarderlogo.png")); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 780));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel5.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, -1, -1));

        jLabel17.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel17.setText("Registrer");
        jPanel5.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 160, -1, -1));

        jLabel18.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel18.setText("Registrer User:");
        jPanel5.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, -1, -1));
        jPanel5.add(jtfName, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 490, 40));

        jLabel19.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel19.setText("Registrer E-mail:");
        jPanel5.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, -1, -1));

        theClickSaveDB.setBackground(new java.awt.Color(75, 0, 130));
        theClickSaveDB.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        theClickSaveDB.setForeground(new java.awt.Color(255, 255, 255));
        theClickSaveDB.setText("Registrer");
        theClickSaveDB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                theClickSaveDBActionPerformed(evt);
            }
        });
        jPanel5.add(theClickSaveDB, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 580, 100, 30));

        theClickSignIn.setBackground(new java.awt.Color(75, 0, 130));
        theClickSignIn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        theClickSignIn.setForeground(new java.awt.Color(255, 255, 255));
        theClickSignIn.setText("Login");
        theClickSignIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                theClickSignInActionPerformed(evt);
            }
        });
        jPanel5.add(theClickSignIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 650, 100, 30));

        jLabel20.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel20.setText("Registrer Office:");
        jPanel5.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, -1, -1));

        jLabel21.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel21.setText("Registrer Password:");
        jPanel5.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 460, -1, -1));
        jPanel5.add(jtfPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 490, 490, 40));
        jPanel5.add(jtfOffice, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 490, 40));
        jPanel5.add(jtfEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 410, 490, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(1018, 807));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void theClickSaveDBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_theClickSaveDBActionPerformed
        switch (this.operacao)
       {
           case 0:{// incluir registro
                    try
                    {
                      UsuarioBean cl1 = new UsuarioBean();
                      UsuarioDao con = new UsuarioDao();  
                      cl1.setNomeuser(jtfName.getText());
                      cl1.setCargouser(jtfOffice.getText());
                      cl1.setEmailuser(jtfEmail.getText());
                      cl1.setSenhauser(jtfPassword.getText());
                      cl1.setLoginuser(jtfName.getText());
                      con.salvar(cl1);
                      JOptionPane.showMessageDialog(null,"Operação Concluída com Sucesso","Inclusão",JOptionPane.INFORMATION_MESSAGE);
                    }
                    catch (Exception e)
                    {
                        JOptionPane.showMessageDialog(null,"Houve um erro na inclusão" + e,"",JOptionPane.ERROR_MESSAGE);
                        
                    } 
            }break;
        }
           SignIn login = new SignIn();
           login.setVisible(true);
           dispose();
    }//GEN-LAST:event_theClickSaveDBActionPerformed

    private void theClickSignInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_theClickSignInActionPerformed
        SignIn login = new SignIn();
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_theClickSignInActionPerformed

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
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignUp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField jtfEmail;
    private javax.swing.JTextField jtfName;
    private javax.swing.JTextField jtfOffice;
    private javax.swing.JPasswordField jtfPassword;
    private javax.swing.JButton theClickSaveDB;
    private javax.swing.JButton theClickSignIn;
    // End of variables declaration//GEN-END:variables
}
