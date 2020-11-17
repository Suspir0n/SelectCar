/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.selectcar.database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Suspir0n
 */
public class connection {
    // Atributos \\
    private static Connection conexao = null; // é a conexão que será fabricada e retornada para o usuario
    private static final String URL_CONNECTION = "jdbc:mysql://localhost/selectcar?useTimezone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false"; // local onde está o banco
    private static final String USER = "root"; // nome da conexão
    private static final String PASSWORD = ""; // senha da conexão
    
    // Constructor \\
    public connection() {
        
    }
    
    // Metodos \\
    public static Connection getConnection( ) throws Exception {
         // verifica se a conexão não foi criada
        if (conexao == null) {
            // tenta criar uma nova conexão
            try {
                Class.forName("com.mysql.cj.jdbc.Driver"); // nome do driver Mysql
                conexao = DriverManager.getConnection(URL_CONNECTION, USER, PASSWORD);
            } catch (ClassNotFoundException e) {
                throw new Exception("Erro de driver!");
            } catch (SQLException e) {
                e.printStackTrace();
                throw new Exception("Erro de SQL!");
            }
        }
        return conexao;
    }
    public static void closeConnection(java.sql.Connection conn,
            Statement stmt, ResultSet rs) throws Exception {
        close(conn, stmt, rs);
    }
    public static void closeConnection(java.sql.Connection conn, Statement stmt)     throws Exception {
        close(conn, stmt, null);
    }
    public static void closeConnection(java.sql.Connection conn)    throws Exception {
        close(conn, null, null);
    }
    private static void close(java.sql.Connection conn,Statement stmt, ResultSet rs)   throws Exception {
        try {
            if (rs != null) rs.close( );
            if (stmt != null)stmt.close( );
            if (conn != null)conn.close( );
        } catch (Exception e) {
            throw new Exception(e.getMessage( ));
        }
    }
}