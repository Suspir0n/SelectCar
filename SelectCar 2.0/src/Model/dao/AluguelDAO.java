/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.dao;

import DataBase.conexao;
import Model.Bean.AluguelBeans;
import Model.Bean.ClienteBeans;
import Model.Bean.VeiculoBeans;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Evand
 */
public class AluguelDAO {
    
    AluguelBeans teste;

    Connection conn;
    int count = 0;

    /**
     * Creates a new instance of aluguelDao
     */
    public AluguelDAO() {
         try {
             this.conn = conexao.getConnection();
         } catch (Exception ex) {
             Logger.getLogger(AluguelDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    /**
     * Método que salva os dados na tabela aluguel
     *
     * @param aluguel - recebe o objeto AluguelBeans
     */
    public void salvar(AluguelBeans aluguel) throws Exception {
        PreparedStatement ps = null;
        Connection conn = null;
        if (aluguel == null) {
            throw new Exception("O valor passado não pode ser nulo");
        }
        try {

            String SQL = "INSERT INTO aluguel (ID_Aluguel, Veiculo, Data_Aluguel, Data_Entrega, Cliente, Entregue, Observacao, Valor_Pago) values (?, ?, ?, ?, ?, ?, ?, ?);";
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            if(!verificarVeiculo(aluguel)){
                ps.setInt(1, aluguel.getIdAluguel());
                ps.setString(2, aluguel.getVeiculo().getPlaca());
                ps.setString(3, aluguel.getDataAluguel());
                ps.setString(4, aluguel.getDataEntrega());
                ps.setString(5, aluguel.getCliente().getCpf());
                ps.setString(6, String.valueOf(aluguel.getEntregue()));
                ps.setString(7, aluguel.getObservacao());
                ps.setFloat(8, aluguel.getValorPago());
                ps.executeUpdate(); 
                JOptionPane.showMessageDialog(null,"Operação Concluída com Sucesso","Inclusão",JOptionPane.INFORMATION_MESSAGE);
             }else{
                if(verificarSeOVeiculoFoiEntregue(aluguel)){
                    JOptionPane.showMessageDialog(null, "Este veiculo já foi alugado e não entregue!", "ERRO", JOptionPane.ERROR_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, "Este veiculo já foi alugado!", "ERRO", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException sqle) {
            throw new Exception("Erro ao inserir dados " + sqle);
        } finally {
            conexao.closeConnection(conn, ps);
        }
    }
    /**
     * Método que verifica veiculo uma linha na tabela aluguel
     *
     * @param aluguel - recebe o objeto AluguelBeans
     */
    public boolean verificarVeiculo(AluguelBeans aluguel) throws Exception {
        boolean result = false;
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        conn = this.conn;
        
        String SQLV = "SELECT * FROM aluguel WHERE Veiculo = '" + aluguel.getVeiculo().getPlaca() + "'";
         
        ps = conn.prepareStatement(SQLV);
        rs = ps.executeQuery();
        if(rs.next()){
            result = true;
        }
	ps.close();
	return result;
    }
    public boolean verificarSeOVeiculoFoiEntregue(AluguelBeans aluguel) throws Exception {
        boolean result = false;
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        conn = this.conn;
        
        String SQLV = "SELECT * FROM aluguel WHERE Entregue = '" + aluguel.getEntregue() + "' AND Veiculo = '" + aluguel.getVeiculo().getPlaca() + "'";
         
        ps = conn.prepareStatement(SQLV);
        rs = ps.executeQuery();
        if(rs.next()){
            result = true;
        }
	ps.close();
	return result;
    }

    /**F
     * Método que exclui uma linha na tabela aluguel
     *
     * @param aluguel - recebe o objeto AluguelBeans
     * @throws se não for possível excluir o aluguel
     */
    public void excluir(AluguelBeans aluguel) throws Exception {
        PreparedStatement ps = null;
        Connection conn = null;
        if (aluguel == null) {
            throw new Exception("O valor passado não pode ser nulo");
        }
        try {
            conn = this.conn;
            // TODO - Verificar se na linha abaixo o comportamento esperado está acontencendo
            ps = conn.prepareStatement("DELETE FROM aluguel WHERE ID_Aluguel=?");
            ps.setInt(1, aluguel.getIdAluguel());
            ps.executeUpdate();
        } catch (SQLException sqle) {
            throw new Exception("Erro ao excluir dados:" + sqle);
        } finally {
            conexao.closeConnection(conn, ps);
        }

    }
    
    /**
     * Método que retorna todos os aluguel
     *
     * @return objeto List
     * @throws java.lang.Exception se não for possível retornar o objeto List
     */
    public List <VeiculoBeans> todosVeiculos() throws Exception {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<VeiculoBeans> list = new ArrayList<>();
        try {
            conn = this.conn;
            ps = conn.prepareStatement("SELECT Placa FROM veiculo");
            rs = ps.executeQuery();
            while (rs.next()) {
                VeiculoBeans veiculo = new VeiculoBeans();
                veiculo.setPlaca(rs.getString(1));
              
                list.add(veiculo);
            }
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            conexao.closeConnection(conn, ps, rs);
        }
        return list;
    }

    /**
     * Método que retorna todos os aluguel
     *
     * @return objeto List
     * @throws java.lang.Exception se não for possível retornar o objeto List
     */
    public List <ClienteBeans> todosClientes() throws Exception {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<ClienteBeans> list = new ArrayList<>();
        try {
            conn = this.conn;
            ps = conn.prepareStatement("select Cpf from cliente");
            rs = ps.executeQuery();
            while (rs.next()) {
                ClienteBeans cliente = new ClienteBeans();
                cliente.setCpf(rs.getString(1));
              
                list.add(cliente);
            }
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            conexao.closeConnection(conn, ps, rs);
        }
        return list;
    }
    
    /**
     * Método que retorna todos os aluguel
     *
     * @return objeto List
     * @throws java.lang.Exception se não for possível retornar o objeto List
     */

    /**
     * Método responsável por pesquisar um aluguel
     *
     * @param idAluguel - recebe um Intiger como parâmetro para pesquisar pelo
     * campo codigo
     * @return objeto AluguelBeans
     * @throws java.lang.Exception se não for possível retornar o objeto aluguel
     */
    public AluguelBeans procurarAluguel(int id) throws Exception {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        //TODO = Consertar esse metodo;
        try {
            conn = this.conn;
            ps = conn.prepareStatement("select * from aluguel where ID_Aluguel=?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()) {
                throw new Exception("Não foi encontrado nenhum" + " registro com o ID: " + id);
            }
            
            VeiculoBeans veiculoBean = procurarVeiculo(rs.getString(2));
            String dataAluguel = rs.getString(3);
            String dataEntrega = rs.getString(4);
            ClienteBeans clienteBean = procurarCliente(rs.getString(5));
            char entregue = rs.getString(6).charAt(0);
            String observacao = rs.getString(7);
            float valorPago = rs.getFloat(8);

            return new AluguelBeans(id, veiculoBean, dataAluguel, dataEntrega, clienteBean, entregue, observacao, valorPago);
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            conexao.closeConnection(conn, ps, rs);
        }
    }
    
     public ClienteBeans procurarCliente(String idCpf) throws  Exception {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            conn = this.conn;
            ps = conn.prepareStatement("select * from cliente where Cpf=?");
            ps.setString(1, idCpf);
            rs = ps.executeQuery( );
            if( !rs.next( ) ) {
                throw new Exception( "Não foi encontrado nenhum" + " registro com o ID: " + idCpf );
            }
                String nomeCliente = rs.getString(2);
                String endereco = rs.getString(3);
                String uf = rs.getString(4);
                String telefone = rs.getString(5);
                String email = rs.getString(6);
            
            return new ClienteBeans( idCpf, nomeCliente, endereco, uf, telefone, email) ;
        } catch (SQLException sqle) {
            throw new  Exception(sqle);
        }/*finally {
            conexao.closeConnection(conn, ps, rs);
        }*/
    }
     
     public VeiculoBeans procurarVeiculo(String idPlaca) throws  Exception {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            conn = this.conn;
            ps = conn.prepareStatement("select * from veiculo where Placa=?");
            ps.setString(1, idPlaca);
            rs = ps.executeQuery( );
            if( !rs.next( ) ) {
                throw new Exception( "Não foi encontrado nenhum" + " registro com o ID: " + idPlaca );
            }
                String numero = rs.getString(2);
                String fabricante = rs.getString(3);
                String modelo = rs.getString(4);
                int anoModelo = rs.getInt(5);
                int qtdPortas = rs.getInt(6);
                String acessorios = rs.getString(7);
            
            return new VeiculoBeans(idPlaca, numero, fabricante, modelo, anoModelo, qtdPortas, acessorios) ;
        } catch (SQLException sqle) {
            throw new  Exception(sqle);
        }/*finally {
            conexao.closeConnection(conn, ps, rs);
        }*/
    } 
}
