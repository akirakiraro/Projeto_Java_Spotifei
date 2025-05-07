/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Artista;

/**
 *
 * @author Akira
 */
public class ArtistaDAO {
    public static void adicionar(Artista artista) {
        String sqlUsuario = "INSERT INTO artista (nome) VALUES (?)";
        
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sqlUsuario)) {
             
                stmt.setString(1, artista.getNome());

                stmt.executeUpdate();
                
                System.out.println("Artista cadastrado com sucesso!");
        } catch (SQLException e) {
        System.out.println("Erro ao adicionar o artista: " + e.getMessage());
        }
    }
}
