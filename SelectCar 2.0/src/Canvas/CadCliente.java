/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Canvas;

import DataBase.conexao;
import Model.Bean.ClienteBeans;
import Model.dao.ClienteDAO;
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
public class CadCliente extends javax.swing.JInternalFrame {

    private int operacao;
    /**
     * Creates new form CadCliente
     */
    public CadCliente() {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtCod = new javax.swing.JTextField();
        aoClicarConsultar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxUF = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtCpf = new javax.swing.JTextField();
        aoClicarExcluir = new javax.swing.JButton();
        aoClicarConfirmar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaListClient = new javax.swing.JTable();
        txtEnd = new javax.swing.JTextField();
        txtTel = new javax.swing.JTextField();
        aoClicarAtualizar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();

        setClosable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("Digite o CPF:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 30));
        jPanel1.add(txtCod, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 100, 30));

        aoClicarConsultar.setBackground(new java.awt.Color(75, 0, 130));
        aoClicarConsultar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        aoClicarConsultar.setForeground(new java.awt.Color(255, 255, 255));
        aoClicarConsultar.setText("Consultar");
        aoClicarConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aoClicarConsultarActionPerformed(evt);
            }
        });
        jPanel1.add(aoClicarConsultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, 110, 30));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Nome:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, 20));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Endereço:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, 20));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("UF:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 200, -1, 20));

        jComboBoxUF.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
        jComboBoxUF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxUFActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBoxUF, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 200, 60, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Tel:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, 20));

        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });
        jPanel1.add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 250, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("E-mail:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, 20));
        jPanel1.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 250, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setText("CPF:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        txtCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCpfActionPerformed(evt);
            }
        });
        jPanel1.add(txtCpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 260, -1));

        aoClicarExcluir.setBackground(new java.awt.Color(75, 0, 130));
        aoClicarExcluir.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        aoClicarExcluir.setForeground(new java.awt.Color(255, 255, 255));
        aoClicarExcluir.setText("Excluir");
        aoClicarExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aoClicarExcluirActionPerformed(evt);
            }
        });
        jPanel1.add(aoClicarExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 490, -1, -1));

        aoClicarConfirmar.setBackground(new java.awt.Color(75, 0, 130));
        aoClicarConfirmar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        aoClicarConfirmar.setForeground(new java.awt.Color(255, 255, 255));
        aoClicarConfirmar.setText("Confirmar");
        aoClicarConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aoClicarConfirmarActionPerformed(evt);
            }
        });
        jPanel1.add(aoClicarConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 490, -1, -1));

        tabelaListClient.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Endereco", "UF", "Telefone", "CPF"
            }
        ));
        jScrollPane2.setViewportView(tabelaListClient);
        if (tabelaListClient.getColumnModel().getColumnCount() > 0) {
            tabelaListClient.getColumnModel().getColumn(0).setMinWidth(100);
            tabelaListClient.getColumnModel().getColumn(0).setPreferredWidth(100);
            tabelaListClient.getColumnModel().getColumn(0).setMaxWidth(100);
            tabelaListClient.getColumnModel().getColumn(1).setMinWidth(150);
            tabelaListClient.getColumnModel().getColumn(1).setPreferredWidth(150);
            tabelaListClient.getColumnModel().getColumn(1).setMaxWidth(150);
            tabelaListClient.getColumnModel().getColumn(2).setMinWidth(30);
            tabelaListClient.getColumnModel().getColumn(2).setPreferredWidth(30);
            tabelaListClient.getColumnModel().getColumn(2).setMaxWidth(30);
            tabelaListClient.getColumnModel().getColumn(3).setMinWidth(80);
            tabelaListClient.getColumnModel().getColumn(3).setPreferredWidth(80);
            tabelaListClient.getColumnModel().getColumn(3).setMaxWidth(80);
            tabelaListClient.getColumnModel().getColumn(4).setMinWidth(90);
            tabelaListClient.getColumnModel().getColumn(4).setPreferredWidth(90);
            tabelaListClient.getColumnModel().getColumn(4).setMaxWidth(90);
        }

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 70, 450, 400));
        jPanel1.add(txtEnd, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 220, -1));
        jPanel1.add(txtTel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 170, -1));

        aoClicarAtualizar.setBackground(new java.awt.Color(75, 0, 130));
        aoClicarAtualizar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        aoClicarAtualizar.setForeground(new java.awt.Color(255, 255, 255));
        aoClicarAtualizar.setText("Atualizar");
        aoClicarAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aoClicarAtualizarActionPerformed(evt);
            }
        });
        jPanel1.add(aoClicarAtualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 490, -1, -1));

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastro de Cliente", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 1, 14))); // NOI18N
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 330, 470));

        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista de Clientes", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 1, 18))); // NOI18N
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 30, 490, 510));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, 570));

        setBounds(65, 30, 900, 600);
    }// </editor-fold>//GEN-END:initComponents

    private void aoClicarConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aoClicarConsultarActionPerformed
         try
        {
         ClienteDAO dao = new ClienteDAO();
         ClienteBeans cli1 = dao.procurarCliente(String.valueOf(txtCod.getText()));   
         txtNome.setText(cli1.getNomeCliente());
         txtEnd.setText(cli1.getEndereco());
         jComboBoxUF.setSelectedItem(String.valueOf(cli1.getUf()));
         txtTel.setText(cli1.getTelefone());
         txtCpf.setText(cli1.getCpf());
         txtEmail.setText(cli1.getEmail());
         aoClicarExcluir.setEnabled(true);
         this.operacao=1;
         
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,"Erro ao Pesquisar" + e,"Erro",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_aoClicarConsultarActionPerformed

    private void aoClicarExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aoClicarExcluirActionPerformed
        int resp = JOptionPane.showConfirmDialog(null,"Deseja Excluir o Registro?","Exclusão de Registro",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        
        if (resp==0) 
        {
            this.operacao=1;
            this.aoClicarConfirmarActionPerformed(evt);
        }
        else
        {
            txtCod.requestFocus();
        }
    }//GEN-LAST:event_aoClicarExcluirActionPerformed

    private void aoClicarConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aoClicarConfirmarActionPerformed
         switch (this.operacao)
       {
           case 0:{// incluir registro
                    try
                    {
                      ClienteBeans cl1 = new ClienteBeans();
                      ClienteDAO con = new ClienteDAO();  
                      cl1.setNomeCliente(txtNome.getText());
                      cl1.setEndereco(txtEnd.getText());
                      cl1.setTelefone(txtTel.getText());
                      cl1.setCpf(txtCpf.getText());
                      cl1.setEmail(txtEmail.getText());
                      cl1.setUf((String) jComboBoxUF.getSelectedItem());
                      con.salvar(cl1);
                      JOptionPane.showMessageDialog(null,"Operação Concluída com Sucesso","Inclusão",JOptionPane.INFORMATION_MESSAGE);
                      txtNome.setText("");
                      txtEnd.setText("");
                      txtTel.setText("");
                      txtCpf.setText("");
                      txtEmail.setText("");
                      jComboBoxUF.setSelectedItem(null);
                    }
                    catch (Exception e)
                    {
                        JOptionPane.showMessageDialog(null,"Houve um erro na inclusão" + e,"",JOptionPane.ERROR_MESSAGE);
                        
                    }
                    
                    
                    
                  }      break;
           case 1:{ // excluir registro
                    try
                    {
                      ClienteBeans cl1 = new ClienteBeans();
                      ClienteDAO con = new ClienteDAO();  
                      cl1.setNomeCliente(txtNome.getText());
                      cl1.setEndereco(txtEnd.getText());
                      cl1.setTelefone(txtTel.getText());
                      cl1.setCpf(txtCpf.getText());
                      cl1.setEmail(txtEmail.getText());
                      cl1.setUf((String) jComboBoxUF.getSelectedItem());
                      con.excluir(cl1);
                      JOptionPane.showMessageDialog(null,"Operação Concluída com Sucesso","Exclusão",JOptionPane.INFORMATION_MESSAGE);
                      txtNome.setText("");
                      txtEnd.setText("");
                      txtTel.setText("");
                      txtCpf.setText("");
                      txtEmail.setText("");
                      jComboBoxUF.setSelectedItem(null);
                      txtCod.setText("");
                      txtCod.requestFocus();
                    }
                    catch (Exception e)
                    {
                        JOptionPane.showMessageDialog(null,"Houve um erro na exclusão" + e,"Exclusão",JOptionPane.ERROR_MESSAGE);
                    }
    
                  }
       } 
    }//GEN-LAST:event_aoClicarConfirmarActionPerformed

    private void jComboBoxUFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxUFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxUFActionPerformed

     private void connectionDB(DefaultTableModel modelTable){
        try
        {
            Connection con = conexao.getConnection();
            PreparedStatement pstm;
            ResultSet rs;
            
            pstm = con.prepareStatement("select * from cliente;");
            rs = pstm.executeQuery();
            this.ListaClient(rs, modelTable);
            conexao.closeConnection(con, pstm, rs);
        }
        catch(Exception ErroSql)
        {
            JOptionPane.showMessageDialog(null, "Erro ao carregar a tabela de dados: " + ErroSql, "ERRO", JOptionPane.ERROR_MESSAGE);
        }
     }
    
    private void ListaClient(ResultSet rs, DefaultTableModel modelTable) throws SQLException{
        while(rs.next()){
            modelTable.addRow(new Object[]{
                rs.getString(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5)    
                });
        }
    }
    
    private void verificacaoDeLinhas(){
        while (tabelaListClient.getModel().getRowCount() > 0) {  
           ((DefaultTableModel) tabelaListClient.getModel()).removeRow(0);  
        }
    }
    
    private void CarregarTable(){
        if(this.operacao == 0 || this.operacao == 1){
            DefaultTableModel modelo = (DefaultTableModel) tabelaListClient.getModel();
            this.connectionDB(modelo);
        }
    }
    
    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void aoClicarAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aoClicarAtualizarActionPerformed
        if(tabelaListClient.getRowCount() > 0){
          verificacaoDeLinhas();
          if(tabelaListClient.getRowCount() <= 0){
            CarregarTable();
          }
        }else{
          CarregarTable();
        }    
    }//GEN-LAST:event_aoClicarAtualizarActionPerformed

    private void txtCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCpfActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aoClicarAtualizar;
    private javax.swing.JButton aoClicarConfirmar;
    private javax.swing.JButton aoClicarConsultar;
    private javax.swing.JButton aoClicarExcluir;
    private javax.swing.JComboBox<String> jComboBoxUF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable tabelaListClient;
    private javax.swing.JTextField txtCod;
    private javax.swing.JTextField txtCpf;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEnd;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtTel;
    // End of variables declaration//GEN-END:variables
}
