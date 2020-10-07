/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.dao;

import DataBase.conexao;
import Model.Bean.UsuarioBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Evand
 */
public class UsuarioDao {
    Connection conn;
    /** Creates a new instance of usuarioDao */
    public UsuarioDao()throws Exception{
        try {
            this.conn = conexao.getConnection();
        } catch( Exception e ) {
            throw new Exception( "Erro: " +  ":\n" + e.getMessage( ) );
        }
    }
    public void salvar(UsuarioBean usuario)  throws Exception{
        PreparedStatement ps = null;
        Connection conn = null;
        if (usuario == null)
            throw new Exception("O valor passado não pode ser nulo");
        try {
            
            String SQL = "INSERT INTO usuario (Nome_Usuario, Cargo, Login, Email, Senha) "+ "values (?, ?, ?, ?, ?)";
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            ps.setString(1, usuario.getNomeuser());
            ps.setString(2, usuario.getCargouser());
            ps.setString(3, usuario.getLoginuser());
            ps.setString(4, usuario.getEmailuser());
            ps.setString(5, usuario.getSenhauser());
            ps.executeUpdate( );
        } catch (SQLException sqle) {
            throw new
                    Exception("Erro ao inserir dados "+ sqle);
        } finally {
            conexao.closeConnection(conn, ps);
        }
    }
    
    public UsuarioBean autenticacaoLogin(String login, String senha) throws SQLException {
        UsuarioBean usuario = null;
        //PreparedStatement ps = null;
        Connection conn = null;
        //ResultSet rs = null;
        conn = this.conn;
        
        String SQL = "SELECT * FROM usuario WHERE Login =? AND Senha =?";
        
        PreparedStatement ps = conn.prepareStatement(SQL);
        ps.setObject(1, login);
        ps.setObject(2, senha);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            usuario = new UsuarioBean();
            usuario.setNomeuser(rs.getString("Nome_Usuario"));
        }
        return usuario;
    }
    
    /**
     * Método que exclui uma linha na tabela usuario
     * @param usuario - recebe o objeto UsuarioBeans
     * @throws  se não for possível excluir o usuario
   */
    public void excluir(UsuarioBean usuario) throws Exception {
        PreparedStatement ps = null;
        Connection conn = null;
        if (usuario == null)
            throw new
                    Exception("O valor passado não pode ser nulo");
        try {
            conn = this.conn;
            ps = conn.prepareStatement("delete from usuario where ID_Usuario=?");
            ps.setString(1, usuario.getCoduser());
            ps.executeUpdate( );
        } catch (SQLException sqle) {
            throw new Exception("Erro ao excluir dados:" + sqle);
        } finally {
            conexao.closeConnection(conn, ps);
        }
        
    }
}
