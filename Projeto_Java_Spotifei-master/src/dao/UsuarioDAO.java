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
        String sqlPessoa = "INSERT INTO pessoa (nome, email, senha) VALUES (?, ?, ?) RETURNING id";
        String sqlUsuario = "INSERT INTO usuario (id_usuario) VALUES (?)";
        
        try (Connection conn = Conexao.conectar()) {
            // Inicia uma transação manual
            conn.setAutoCommit(false);
            
            // 1. Inserir na tabela pessoa
            try (PreparedStatement stmtPessoa = conn.prepareStatement(sqlPessoa)) {
                stmtPessoa.setString(1, usuario.getNome());
                stmtPessoa.setString(2, usuario.getEmail());
                stmtPessoa.setString(3, usuario.getSenha());

                ResultSet rs = stmtPessoa.executeQuery();
                
                if (rs.next()) {
                    int idPessoa = rs.getInt("id");

                    // 2. Inserir na tabela usuario usando o id gerado
                    try (PreparedStatement stmtUsuario = conn.prepareStatement(sqlUsuario)) {
                        stmtUsuario.setInt(1, idPessoa);
                        stmtUsuario.executeUpdate();
                    }
                    
                    // Finaliza a transação
                    conn.commit();
                
                    System.out.println("Usuario cadastrado com sucesso!");
                } else {
                    conn.rollback();
                    System.out.println("Erro ao cadastrar pessoa.");
                }
            }
        } catch (SQLException e) {
        System.out.println("Erro ao adicionar usuario: " + e.getMessage());
        }
    }
    
    // Funcao para validar o login do usuario
    public boolean validarLoginUsuario(String nome, String senha){
        String sql = "SELECT p.id FROM pessoa p " + "JOIN usuario u ON p.id = u.id_usuario " + "WHERE p.email = ? AND p.senha = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nome);
            stmt.setString(2, senha);

            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                // Usuario valido
                System.out.println("Validacao do usuario valida!");
                return true;
            } else {
                // Usuario ou senha invalido
                System.out.println("Validacao do usuario invalida!");
                return false;
            }
            

        } catch (SQLException e) {
            System.out.println("Erro ao fazer login: " + e.getMessage());
            return false;
        }
    }
    
 
}
