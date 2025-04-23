package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    
    public static Connection getConnection() throws SQLException{
        Connection conexao = DriverManager.getConnection(
            "jdbc:postgresql://localhost:4352/SpotiFEI", "postgres", "4352");
        return conexao;
    }
    
    
//    public static Connection conectar() {
//        Connection conn = null;
//
//        String url = "jdbc:postgresql://localhost:4352/SpotiFEI"; // nome do seu banco
//        String usuario = "postgres"; // seu usuário PostgreSQL
//        String senha = "4352";  // sua senha PostgreSQL
//
//        try {
//            conn = DriverManager.getConnection(url, usuario, senha);
//            System.out.println("Conectado com sucesso ao PostgreSQL!");
//        } catch (SQLException e) {
//            System.out.println("Erro na conexão: " + e.getMessage());
//        }
//
//        return conn;
//    }
}
