package model;

import model.*;
import java.sql.*;

/**
 *  Fazer funcao para adicionar ou no email, ou no telefone ou os dois juntos
 *  
 * 
*/
public class UsuarioDAO {
    
    // Funcao para cadastrar alguem no SQL
    // So funciona se for minusculo no banco de dados
    public static void adicionar(Usuario usuario) {
        String sql = "INSERT INTO usuarios (nome, email, senha) VALUES (?, ?, ?)";
        try (Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            // mostra no console
            System.out.println("Fazendo Cadastro com os dados: ");
            System.out.println("Usuario: " + usuario.getNome());
            System.out.println("E-mail: " + usuario.getEmail());
            System.out.println("Senha: " + usuario.getSenha());
            
            // add na string
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSenha());
            stmt.executeUpdate();

            System.out.println("Usuario adicionado!");
        } catch (SQLException e) {
            System.out.println("Erro ao adicionar: " + e.getMessage());
        }
    }
    
    
    
}
