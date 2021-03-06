/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Canvas;

import DataBase.conexao;
import Model.Bean.AluguelBeans;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Evand
 */
public class Faturamento extends javax.swing.JInternalFrame {

    AluguelBeans aluguel;
    /**
     * Creates new form Faturamento
     */
    public Faturamento() {
        initComponents();
    }

    private void connectionDB(DefaultTableModel modelTable){
        try
        {
            String clientDateHome = txtDateHome.getText();
            String clientDateFinaly = txtDateFinally.getText();
            Connection con = conexao.getConnection();
            PreparedStatement pstm;
            ResultSet rs;
            aluguel = new AluguelBeans();
            
            pstm = con.prepareStatement("SELECT Data_Aluguel, Veiculo, Cliente, Valor_Pago FROM aluguel WHERE Data_Aluguel BETWEEN ('" + clientDateHome + "') AND ('" + clientDateFinaly + "')");
            rs = pstm.executeQuery();
            this.listTable(rs, modelTable);
            conexao.closeConnection(con, pstm, rs);
           
        }
        catch(Exception ErroSql)
        {
            JOptionPane.showMessageDialog(null, "Periodo inexistente " + ErroSql, "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void listTable(ResultSet rs, DefaultTableModel modelTable) throws SQLException{
        float valor = 0;
        float total = 0;
        while(rs.next()){
            modelTable.addRow(new Object[]{
                rs.getString(1),
                rs.getString(2),
                rs.getString(3),
                valor = rs.getFloat(4),
                total += valor 
            });
            txtTotal.setText(String.valueOf(total));
        }
    }
    private void verificacaoDeLinhas(){
        while (tabelaListFaturamento.getModel().getRowCount() > 0) {  
           ((DefaultTableModel) tabelaListFaturamento.getModel()).removeRow(0);  
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txtDateFinally = new javax.swing.JTextField();
        aoClicarConsultar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtDateHome = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaListFaturamento = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();

        setClosable(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(txtDateFinally, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, 100, 30));

        aoClicarConsultar.setBackground(new java.awt.Color(75, 0, 130));
        aoClicarConsultar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        aoClicarConsultar.setForeground(new java.awt.Color(255, 255, 255));
        aoClicarConsultar.setText("Consultar");
        aoClicarConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aoClicarConsultarActionPerformed(evt);
            }
        });
        jPanel2.add(aoClicarConsultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, 110, 30));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setText("De:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, 30));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setText("Até");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, -1, 30));
        jPanel2.add(txtDateHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 100, 30));

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data ", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 1, 24))); // NOI18N
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, 441, 92));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        tabelaListFaturamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data", "Placa", "CPF", "Valor"
            }
        ));
        jScrollPane1.setViewportView(tabelaListFaturamento);
        if (tabelaListFaturamento.getColumnModel().getColumnCount() > 0) {
            tabelaListFaturamento.getColumnModel().getColumn(0).setMinWidth(100);
            tabelaListFaturamento.getColumnModel().getColumn(0).setPreferredWidth(100);
            tabelaListFaturamento.getColumnModel().getColumn(0).setMaxWidth(100);
            tabelaListFaturamento.getColumnModel().getColumn(1).setMinWidth(140);
            tabelaListFaturamento.getColumnModel().getColumn(1).setPreferredWidth(140);
            tabelaListFaturamento.getColumnModel().getColumn(1).setMaxWidth(140);
            tabelaListFaturamento.getColumnModel().getColumn(2).setMinWidth(100);
            tabelaListFaturamento.getColumnModel().getColumn(2).setPreferredWidth(100);
            tabelaListFaturamento.getColumnModel().getColumn(2).setMaxWidth(100);
            tabelaListFaturamento.getColumnModel().getColumn(3).setMinWidth(70);
            tabelaListFaturamento.getColumnModel().getColumn(3).setPreferredWidth(70);
            tabelaListFaturamento.getColumnModel().getColumn(3).setMaxWidth(70);
        }

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Total:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(123, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(88, 88, 88))
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 570));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(385, 385, 385)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setBounds(285, 30, 480, 600);
    }// </editor-fold>//GEN-END:initComponents

    private void aoClicarConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aoClicarConsultarActionPerformed

        if(tabelaListFaturamento.getRowCount() > 0){
          verificacaoDeLinhas();
          if(tabelaListFaturamento.getRowCount() <= 0){
              DefaultTableModel modelo = (DefaultTableModel) tabelaListFaturamento.getModel();
              this.connectionDB(modelo);
          }
        }else{
          DefaultTableModel modelo = (DefaultTableModel) tabelaListFaturamento.getModel();
          this.connectionDB(modelo);
        }
    }//GEN-LAST:event_aoClicarConsultarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aoClicarConsultar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tabelaListFaturamento;
    private javax.swing.JTextField txtDateFinally;
    private javax.swing.JTextField txtDateHome;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
