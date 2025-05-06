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
        String verificarSql = "SELECT * FROM administrador WHERE id_administrador = ?";
        String sqlPessoa = "INSERT INTO pessoa (id, nome, email, senha) VALUES (?, ?, ?, ?)";
        String sqlAdministrador = "INSERT INTO administrador (id_administrador) VALUES (?)";
        
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmtVerificar = conn.prepareStatement(verificarSql)) {
            
            stmtVerificar.setInt(1, 1);
            ResultSet rs = stmtVerificar.executeQuery();
            
            if (rs.next()) {
                System.out.println("Admin ja existe.");
                return;
            }
            
            // Insere pessoa na tabela
            try (PreparedStatement stmt1 = conn.prepareStatement(sqlPessoa)) {
                stmt1.setInt(1, 1);
                stmt1.setString(2, "Admin");
                stmt1.setString(3, "Admin@spotifei.com");
                stmt1.setString(4, "Admin");
                stmt1.executeUpdate();
            }
            
            // Insere na tabela de Admin
            try (PreparedStatement stmt2 = conn.prepareStatement(sqlAdministrador)){
                stmt2.setInt(1, 1);
                stmt2.executeUpdate();
            }
            
            System.out.println("Admin Adicionado!");
            
        } catch (SQLException e) {
            System.out.println("Erro ao adicionar administrador: " + e.getMessage());
        }
    }
    
    // Funcao para validar o login do usuario
    public boolean validarLoginAdmin(String nome, String senha){
        String sql = "SELECT p.id FROM pessoa p " + "JOIN administrador u ON p.id = u.id_administrador " + "WHERE p.nome = ? AND p.senha = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nome);
            stmt.setString(2, senha);

            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                // Usuario valido
                System.out.println("Validacao do admin valida!");
                return true;
            } else {
                // Usuario ou senha invalido
                System.out.println("Validacao do admin invalida!");
                return false;
            }
            

        } catch (SQLException e) {
            System.out.println("Erro ao fazer login: " + e.getMessage());
            return false;
        }
    }
    
}
