/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.dao;

import DataBase.conexao;
import Model.Bean.VeiculoBeans;
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
public class VeiculoDAO {
 Connection conn;
    /** Creates a new instance of VeiculoDao */
    public VeiculoDAO()throws Exception{
        try {
            this.conn = conexao.getConnection( );
        } catch( Exception e ) {
            throw new Exception( "Erro: " +  ":\n" + e.getMessage( ) );
        }
    }
    public void salvar(VeiculoBeans veiculo)  throws Exception{
        PreparedStatement ps = null;
        Connection conn = null;
        if (veiculo == null)
            throw new Exception("O valor passado não pode ser nulo");
        try {
            
            String SQL = "INSERT INTO veiculo (Numero, Placa, Fabricante, Modelo, Ano_Modelo, Qtd_Portas, Acessorios) "+ "values (?, ?, ?, ?, ?, ?, ?)";
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            ps.setString(1, veiculo.getNumero());
            ps.setString(2, veiculo.getPlaca());
            ps.setString(3, veiculo.getFabricante());
            ps.setString(4, veiculo.getModelo());
            ps.setInt(5, veiculo.getAnoModelo());
            ps.setInt(6, veiculo.getQtdPortas());
             ps.setString(7, veiculo.getAcessorios());
            ps.executeUpdate( );
        } catch (SQLException sqle) {
            throw new
                    Exception("Erro ao inserir dados "+ sqle);
        } finally {
            conexao.closeConnection(conn, ps);
        }
    }
    
    /**
     * Método que exclui uma linha na tabela veiculo
     * @param veiculo - recebe o objeto VeiculoBeans
     * @throws  se não for possível excluir o veiculo
   */
    public void excluir(VeiculoBeans veiculo) throws Exception {
        PreparedStatement ps = null;
        Connection conn = null;
        if (veiculo == null)
            throw new
                    Exception("O valor passado não pode ser nulo");
        try {
            conn = this.conn;
            ps = conn.prepareStatement("delete from veiculo where Placa=?");
            ps.setString(1, veiculo.getPlaca());
            ps.executeUpdate( );
        } catch (SQLException sqle) {
            throw new Exception("Erro ao excluir dados:" + sqle);
        } finally {
            conexao.closeConnection(conn, ps);
        }
        
    }
    /**
     * Método que retorna todos os veiculos
     * @return objeto List
     * @throws java.lang.Exception se não for possível retornar o objeto List
     */
    public List todosVeiculos( )  throws Exception{
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            conn = this.conn;
            ps = conn.prepareStatement("select * from veiculo");
            rs = ps.executeQuery( );
            List<VeiculoBeans> list = new ArrayList<VeiculoBeans>();
            while( rs.next( ) ) {
                String numero = rs.getString(1);
                String placa = rs.getString(2);
                String fabricante = rs.getString(3);
                String modelo = rs.getString(4);
                int anoModelo = rs.getInt(5);
                int qtdPortas = rs.getInt(6);
                String acessorios = rs.getString(7);
                VeiculoBeans veiculo = procurarVeiculo(rs.getString(2));
                list.add(new VeiculoBeans(numero, placa, fabricante, modelo, anoModelo, qtdPortas, acessorios) );
            }
            return list;
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            conexao.closeConnection(conn, ps, rs);
        }
    }
    /**
     * Método responsável por pesquisar um veiculo
     * @param idPlaca - recebe um String como parâmetro para pesquisar
     * pelo campo codigo
     * @return objeto VeiculoBeans
     * @throws java.lang.Exception se não for possível retornar o objeto veiculo
     */
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
                String numero = rs.getString(1);
                String fabricante = rs.getString(3);
                String modelo = rs.getString(4);
                int anoModelo = rs.getInt(5);
                int qtdPortas = rs.getInt(6);
                String acessorios = rs.getString(7);
            
            return new VeiculoBeans(numero, idPlaca, fabricante, modelo, anoModelo, qtdPortas, acessorios) ;
        } catch (SQLException sqle) {
            throw new  Exception(sqle);
        } finally {
            conexao.closeConnection(conn, ps, rs);
        }
    }
}

