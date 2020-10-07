/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.dao;

import DataBase.conexao;
import Model.Bean.ClienteBeans;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Evand
 */
public class ClienteDAO {
   Connection conn;
    /** Creates a new instance of clienteDao */
    public ClienteDAO()throws Exception{
        try {
            this.conn = conexao.getConnection( );
        } catch( Exception e ) {
            throw new Exception( "Erro: " +  ":\n" + e.getMessage( ) );
        }
    }
    public void salvar(ClienteBeans cliente)  throws Exception{
        PreparedStatement ps = null;
        Connection conn = null;
        if (cliente == null)
            throw new Exception("O valor passado não pode ser nulo");
        try {
            
            String SQL = "INSERT INTO cliente (Nome_Cliente, Endereco, UF, Telefone, Cpf, Email) "+ "values (?, ?, ?, ?, ?, ?)";
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            ps.setString(1, cliente.getNomeCliente());
            ps.setString(2, cliente.getEndereco());
            ps.setString(3, cliente.getUf());
            ps.setString(4, cliente.getTelefone());
            ps.setString(5, cliente.getCpf());
            ps.setString(6, cliente.getEmail());
            ps.executeUpdate( );
        } catch (SQLException sqle) {
            throw new
                    Exception("Erro ao inserir dados "+ sqle);
        } finally {
            conexao.closeConnection(conn, ps);
        }
    }
    
    /**
     * Método que exclui uma linha na tabela cliente
     * @param cliente - recebe o objeto ClienteBeans
     * @throws  se não for possível excluir o cliente
   */
    public void excluir(ClienteBeans cliente) throws Exception {
        PreparedStatement ps = null;
        Connection conn = null;
        if (cliente == null)
            throw new
                    Exception("O valor passado não pode ser nulo");
        try {
            conn = this.conn;
            ps = conn.prepareStatement("delete from cliente where Cpf=?");
            ps.setString(1, cliente.getCpf());
            ps.executeUpdate( );
        } catch (SQLException sqle) {
            throw new Exception("Erro ao excluir dados:" + sqle);
        } finally {
            conexao.closeConnection(conn, ps);
        }
        
    }
    /**
     * Método que retorna todos os clientes
     * @return objeto List
     * @throws java.lang.Exception se não for possível retornar o objeto List
     */
    public List todosClientes( )  throws Exception{
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            conn = this.conn;
            ps = conn.prepareStatement("select * from cliente");
            rs = ps.executeQuery( );
            List<ClienteBeans> list = new ArrayList<ClienteBeans>();
            while( rs.next( ) ) {
                String nomeCliente = rs.getString(1);
                String endereco = rs.getString(2);
                String uf = rs.getString(3);
                String telefone = rs.getString(4);
                String cpf = rs.getString(5);
                String email = rs.getString(6);
                ClienteBeans cliente = procurarCliente(rs.getString(5));
                list.add(new ClienteBeans(nomeCliente, endereco, uf, telefone, cpf, email) );
            }
            return list;
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            conexao.closeConnection(conn, ps, rs);
        }
    }
    /**
     * Método responsável por pesquisar um cliente
     * @param idCpf - recebe um String como parâmetro para pesquisar
     * pelo campo codigo
     * @return objeto ClienteBeans
     * @throws java.lang.Exception se não for possível retornar o objeto cliente
     */
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
                String nomeCliente = rs.getString(1);
                String endereco = rs.getString(2);
                String uf = rs.getString(3);
                String telefone = rs.getString(4);
                String email = rs.getString(6);

            return new ClienteBeans(nomeCliente, endereco, uf, telefone, idCpf, email) ;
        } catch (SQLException sqle) {
            throw new  Exception(sqle);
        } finally {
            conexao.closeConnection(conn, ps, rs);
        }
    }
}
