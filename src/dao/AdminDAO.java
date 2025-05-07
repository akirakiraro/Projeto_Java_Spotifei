/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.*;

/**
 *
 * @author Akira
 */
public class AdminDAO {
    
    // Adiciona o login do ADM 
    // Nome:  "Admin"
    // Senha: "Admin"
    public static void AddAdmin(){
        String verificarSql = "SELECT * FROM administrador WHERE nome = ?";
        String sqlAdministrador = "INSERT INTO administrador (nome, senha) VALUES (?, ?)";
        
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmtVerificar = conn.prepareStatement(verificarSql)) {
            
            stmtVerificar.setString(1, "Admin");
            ResultSet rs = stmtVerificar.executeQuery();
            
            if (rs.next()) {
                System.out.println("Admin ja existe.");
                return;
            }
            
            // Insere o Admin na tabela de administrador
            try (PreparedStatement stmtAdmin = conn.prepareStatement(sqlAdministrador)) {
                stmtAdmin.setString(1, "Admin");
                stmtAdmin.setString(2, "Admin");
                stmtAdmin.executeUpdate();
            }
            
            System.out.println("Admin Adicionado!");
            
        } catch (SQLException e) {
            System.out.println("Erro ao adicionar administrador: " + e.getMessage());
        }
    }
    
    // Funcao para validar o login do usuario
    public boolean validarLoginAdmin(String nome, String senha){
        String sql = "SELECT * FROM administrador WHERE nome = ? AND senha = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nome);
            stmt.setString(2, senha);

            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                // Usuario valido
                System.out.println("Login do admin valida!");
                return true;
            } else {
                // Usuario ou senha invalido
                System.out.println("Login do admin invalida!");
                return false;
            }
            

        } catch (SQLException e) {
            System.out.println("Erro ao fazer login: " + e.getMessage());
            return false;
        }
    }
    
}
