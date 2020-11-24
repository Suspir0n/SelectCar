/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.selectcar.DAO;

import com.selectcar.entitys.userEntitys;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Suspir0n
 */
public class userDAO {

    // Attributes \\
    Connection connect;
    PreparedStatement ps;

    // Instances \\
    baseDAO base = new baseDAO();

    // Constructor \\
    public userDAO() {
    }

    // Methods \\
    /*
    * Method of save
    * registre the data at database.
     */
    public void save(userEntitys user) throws Exception {
        try {
            connect = com.selectcar.database.connection.getConnection(); // obtem a conexão com o BD

            base.setSomeAttributesUsers(user);
            // se é uma inserção
            ps = connect.prepareStatement("INSERT INTO user(uid, active, deleted, createAt, updateAt, name, office, login, email, password, photo) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setInt(1, user.getUid());
            ps.setBoolean(2, user.getActive());
            ps.setBoolean(3, user.getDeleted());
            ps.setString(4, user.getCreateAt());
            ps.setString(5, user.getUpdateAt());
            ps.setString(6, user.getName());
            ps.setString(7, user.getOffice());
            ps.setString(8, user.getLogin());
            ps.setString(9, user.getEmail());
            ps.setString(10, user.getPassword());
            ps.setString(11, user.getPhoto());
        } catch (SQLException e) {
            throw new Exception("Erro na preparação do SQL", e);
        }
        try {
            ps.execute();
        } catch (SQLException e) {
            throw new Exception("Erro na execução do SQL", e);
        }
    }

    /*
    * Method of search
    * search a data at database.
     */
    public userEntitys search(Integer id) throws Exception {
        connect = com.selectcar.database.connection.getConnection();
        try {
            ps = connect.prepareStatement("select * from user where uid=?"); // obtem apena uma única informação
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                userEntitys user = new userEntitys();
                user.setUid(resultSet.getInt("uid"));
                user.setActive(resultSet.getBoolean("active"));
                user.setDeleted(resultSet.getBoolean("deleted"));
                user.setCreateAt(resultSet.getString("createAt"));
                user.setUpdateAt(resultSet.getString("updateAt"));
                user.setName(resultSet.getString("name"));
                user.setOffice(resultSet.getString("office"));
                user.setLogin(resultSet.getString("login"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setPhoto(resultSet.getString("photo"));
                return user;
            }
        } catch (SQLException ex) {
            throw new Exception("Erro na execução do SQL - busca de usuário", ex);
        }
        return null;
    }

    /*
    * Method of Delete
    * delete some users register.
     */
    public void delete(userEntitys user) throws Exception {
        connect = com.selectcar.database.connection.getConnection();
        try {
            ps = connect.prepareStatement("delete from user where uid=?");
            ps.setInt(1, user.getUid());
            ps.execute();
        } catch (SQLException e) {
            throw new Exception("Erro ao deletar o usuario", e);
        }
        com.selectcar.database.connection.closeConnection(connect);
    }

    /*
    * Method of Count
    * Counts how many users are registered.
     */
    public userEntitys CountsHowManyUsers() throws Exception {
        connect = com.selectcar.database.connection.getConnection();
        try {
            ps = connect.prepareStatement("select count(*) as Usuarios from user");
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                userEntitys user = new userEntitys();
                user.setTotal(resultSet.getInt("Usuarios"));
                return user;
            }
        } catch (SQLException ex) {
            throw new Exception("Erro na execução do SQL - contador de usuário", ex);
        }
        return null;
    }

    /*
    * Method of bring all the users
    * brings all the users and put in a table.
     */
    public List<userEntitys> all() throws Exception {
        connect = com.selectcar.database.connection.getConnection();

        List<userEntitys> listUser = new ArrayList<>();
        try {
            ps = connect.prepareStatement("select * from user");
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                userEntitys user = new userEntitys();
                user.setUid(resultSet.getInt("uid"));
                user.setActive(resultSet.getBoolean("active"));
                user.setDeleted(resultSet.getBoolean("deleted"));
                user.setCreateAt(resultSet.getString("createAt"));
                user.setUpdateAt(resultSet.getString("updateAt"));
                user.setName(resultSet.getString("name"));
                user.setOffice(resultSet.getString("office"));
                user.setLogin(resultSet.getString("login"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setPhoto(resultSet.getString("photo"));
                listUser.add(user);
            }
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        }
        return listUser;
    }

    /*
    * Method of authenticate the users
    * authenticate the users to have access the system.
     */
    public boolean authenticate(userEntitys userEntitys) throws Exception {
        connect = com.selectcar.database.connection.getConnection();
        userEntitys user = new userEntitys();
        System.out.println(user);
        try {
            ps = connect.prepareStatement("select * from user where login = ? and password = ?"); // obtem apena uma única informação
            ps.setString(1, userEntitys.getLogin());
            ps.setString(2, userEntitys.getPassword());
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next() == false) // verifica se o usuário realmente está no banco de dados
            {
                throw new Exception("Login incorreto! Não existe no banco de dados!");
            }
            return true;
        } catch (SQLException ex) {
            throw new Exception("Erro na execução do SQL - busca de usuário", ex);
        }
    }
}
