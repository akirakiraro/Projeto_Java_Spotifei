
import model.Conexao;
import view.*;
import controller.*;
import java.sql.Connection;
import java.sql.SQLException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */



/**
 *
 * @author Akira
 */
public class Main {
    
    public static void main(String[] args) {
        
        try {
            Connection conn = Conexao.getConnection();
            System.out.println("Conexão feita com sucesso!");
            conn.close();
        } catch (SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
        }
        
        TelaPrincipal tela = new TelaPrincipal();
        tela.setVisible(true);

        // passa as views e conecta os controllers
        new HomeController(tela, tela.getTelaHome());
        new LoginController(tela, tela.getTelaLogin());
        new CadastroController(tela, tela.getTelaCadastro());
    }
    
}
