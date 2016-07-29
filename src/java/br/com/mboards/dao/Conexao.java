package br.com.mboards.dao;

import java.sql.*;

/**
 *
 * @author julio
 */
public class Conexao {

    // Acesso Remoto
    public static Connection conecta() {
        String url = "jdbc:mysql://200.234.201.118/digasim_sistema";
        String driver = "com.mysql.jdbc.Driver";
        String user = "digasim_sistema";
        String pwd = "csmdpla";//Senha do Banco de dados
        Connection con = null;

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, pwd);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (SQLException e) {
            System.out.println(e);
        }
        // System.out.println("Conectado");
        return con;
    }

    //fim da conexao
    //========================================================
    public static void main(String[] args) {
        System.out.println(conecta());
    }
}
