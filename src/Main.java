import model.*;
import view.*;
import controller.*;
import dao.Conexao;



public class Main {
    
    public static void main(String[] args) {
        
        // testa a conexao com o banco de dados
        if (Conexao.conectar() == null){
            System.out.println("\n\nErro na conexao com o banco de dados.");
            System.exit(0);
        }
        
        // Inicia a tela principal
        Tela tela = new Tela();
        tela.setVisible(true);
        
        // passa as views e conecta os controllers
        new HomeController(tela, tela.getTelaHome());
        new LoginController(tela, tela.getTelaLogin());
        new CadastroController(tela, tela.getTelaCadastro());
    }
    
}
