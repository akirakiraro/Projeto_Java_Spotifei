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
    public static boolean adicionarMusica(Musica musica, String nomeArtista) {
        String sqlBuscarIdArtista = "SELECT id_artista FROM artista WHERE nome = ?";
        String sqlUsuario = "INSERT INTO musica (titulo, duracao, status, id_artista) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmtBuscaNomeArtista = conn.prepareStatement(sqlBuscarIdArtista)) {
            
                // Verifica se tem algum nome igual no banco de dados
                stmtBuscaNomeArtista.setString(1, nomeArtista);
                ResultSet rs = stmtBuscaNomeArtista.executeQuery();

                if (rs.next()) {
                    int idArtista = rs.getInt("id_artista");
                    // coloca aki as informacoes para as musicas
                    try (PreparedStatement stmt = conn.prepareStatement(sqlUsuario)) {
                        stmt.setString(1, musica.getTitulo());
                        stmt.setInt(2, musica.getDuracao());
                        stmt.setInt(3, musica.getStatus());
                        stmt.setInt(4, idArtista);
                        stmt.executeUpdate();
                    }

                    System.out.println("Musica cadastrado com sucesso!");
                    return true;
                } else {
                    System.out.println("Artista não encontrado: " + nomeArtista);
                    return false;
                }
                
                
        } catch (SQLException e) {
            System.out.println("Erro ao adicionar a musica: " + e.getMessage());
            return false;
        }
    }
    
    
    
}
