package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    
    public static Connection conectar() {
        Connection SQL = null;
        
        // nome do seu banco
        // (Akira) Deixei o meu como: "jdbc:postgresql://localhost:4352/SpotiFEI"
        // na Fei o banco de dados que eu deixo é: "jdbc:postgresql://localhost:5432/SpotiFEI"
        // seu usuário PostgreSQL
        // (Akira) Deixei o meu como: "postgres"
        // (FEI) Deixei o meu como: "postgres"
        // sua senha PostgreSQL
        // (Akira) Deixei o meu como: "4352"
        // (FEI) Deixei o meu como: "fei"
        
        String urlAkiraPC = "jdbc:postgresql://localhost:4352/SpotiFEI";
        String urlAkiraNote = "jdbc:postgresql://localhost:5432/SpotiFEI";
        String usuarioAkiraPC = "postgres";
        String usuarioAkiraNote = "postgres";
        String senhaAkiraPC = "4352";
        String senhaAkiraNote = "4352";

        try {
            SQL = DriverManager.getConnection(urlAkiraPC, usuarioAkiraPC, senhaAkiraPC);
            System.out.println("\nConectado com sucesso ao PostgreSQL!");
        } catch (SQLException e) {
            System.out.println("Erro na conexao: " + e.getMessage());
            
            try {
                SQL = DriverManager.getConnection(urlAkiraNote, usuarioAkiraNote, senhaAkiraNote);
            } catch (SQLException e2) {
                System.out.println("Erro na conexao: " + e2.getMessage());
            }
            
        }
        
        return SQL;
    }
    
    
    
    
}
