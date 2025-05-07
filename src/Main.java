import controller.conta.HomeController;
import controller.conta.CadastroController;
import controller.conta.LoginController;
import controller.usuario.PlaylistController;
import controller.usuario.HistoricoController;
import controller.usuario.UsuarioController;
import controller.adm.AdmController;
import model.*;
import view.*;
import dao.*;



public class Main {
    
    public static void main(String[] args) {
        
        // testa a conexao com o banco de dados
        if (Conexao.conectar() == null){
            System.out.println("\n\nErro na conexao com o banco de dados.");
            System.exit(0);
        }
        
        AdminDAO.AddAdmin();
        
        // Inicia a tela principal
        Tela tela = new Tela();
        tela.setVisible(true);
        
        // passa as views e conecta os controllers
        new HomeController(tela, tela.getTelaHome());
        new LoginController(tela, tela.getTelaLogin());
        new CadastroController(tela, tela.getTelaCadastro());
        new UsuarioController(tela, tela.getTelaUsuarioInicial());
        new PlaylistController(tela, tela.getTelaPlaylist());
        new HistoricoController(tela, tela.getTelaHistorico());
        new AdmController(tela, tela.getTelaAdmInicial());
    }
    
}
