package dao;

import model.*;
import java.sql.*;
import model.Usuario;

/**
 *  Fazer funcao para adicionar ou no email, ou no telefone ou os dois juntos
 *  
 * 
*/
public class UsuarioDAO {
    
    // Funcao para cadastrar alguem no SQL
    // So funciona se for minusculo no banco de dados
    public static void adicionar(Usuario usuario) {
        String sqlUsuario = "INSERT INTO usuario (nome, email, telefone, senha) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sqlUsuario)) {
             
                stmt.setString(1, usuario.getNome());
                //stmt.setString(2, usuario.getEmail());
                stmt.setString(2, "");
                stmt.setString(3, "");
                stmt.setString(4, usuario.getSenha());

                stmt.executeUpdate();
                
                System.out.println("Usuario cadastrado com sucesso!");
        } catch (SQLException e) {
        System.out.println("Erro ao adicionar usuario: " + e.getMessage());
        }
    }
    
    // Funcao para validar o login do usuario
    public boolean validarLoginUsuario(String nome, String senha){
        String sql = "SELECT * FROM usuario WHERE nome = ? AND senha = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nome);
            stmt.setString(2, senha);

            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                // Usuario valido
                System.out.println("Login do usuario valida!");
                return true;
            } else {
                // Usuario ou senha invalido
                System.out.println("Login do usuario invalida!");
                return false;
            }
            

        } catch (SQLException e) {
            System.out.println("Erro ao fazer login: " + e.getMessage());
            return false;
        }
    }
    
 
}
