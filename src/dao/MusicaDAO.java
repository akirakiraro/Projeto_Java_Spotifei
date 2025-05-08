/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Musica;

/**
 *
 * @author Akira
 */
public class MusicaDAO {
    public static boolean adicionarMusica(Musica musica) {
        String verificarSql = "SELECT * FROM artista WHERE nome = ?";
        String sqlUsuario = "INSERT INTO artista (nome) VALUES (?)";
        
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmtVerificacao = conn.prepareStatement(verificarSql)) {
            
                // Verifica se tem algum nome igual no banco de dados
                stmtVerificacao.setString(1, artista.getNome());
                ResultSet rs = stmtVerificacao.executeQuery();

                if (rs.next()) {
                    System.out.println("Nome ja existe.");
                    return false;
                }
                try (PreparedStatement stmt = conn.prepareStatement(sqlUsuario)) {
                    stmt.setString(1, artista.getNome());
                    stmt.executeUpdate();
                }
                
                System.out.println("Artista cadastrado com sucesso!");
                
        } catch (SQLException e) {
            System.out.println("Erro ao adicionar a musica: " + e.getMessage());
            return false;
        }
        return true;
    }
}
