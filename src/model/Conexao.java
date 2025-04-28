package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    
    public static Connection conectar() {
        Connection SQL = null;
        
        // nome do seu banco
        // seu usuário PostgreSQL
        // sua senha PostgreSQL
        String url = "jdbc:postgresql://localhost:4352/SpotiFEI";
        String usuario = "postgres";
        String senha = "4352";

        try {
            SQL = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conectado com sucesso ao PostgreSQL!");
        } catch (SQLException e) {
            System.out.println("Erro na conexao: " + e.getMessage());
        }

        return SQL;
    }
    
    
    
    
}
