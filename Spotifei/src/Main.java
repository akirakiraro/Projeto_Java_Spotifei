import model.*;
import view.*;
import controller.*;



public class Main {
    
    public static void main(String[] args) {
        
        // Inicia a tela principal
        TelaPrincipal tela = new TelaPrincipal();
        tela.setVisible(true);
        
        // passa as views e conecta os controllers
        new HomeController(tela, tela.getTelaHome());
        new LoginController(tela, tela.getTelaLogin());
        new CadastroController(tela, tela.getTelaCadastro());
    }
    
}
