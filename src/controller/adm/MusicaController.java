package controller.adm;

import dao.ArtistaDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import view.Adm.TelaCadastroExcluirMusica;
import view.Tela;

/**
 *
 * @author Akira
 */
public class MusicaController implements ActionListener{
    private Tela telaPrincipal;
    private TelaCadastroExcluirMusica telaCadastroExcluirMusica;
    
    public MusicaController(Tela telaPrincipal, TelaCadastroExcluirMusica telaCadastroExcluirMusica) {
        this.telaPrincipal = telaPrincipal;
        this.telaCadastroExcluirMusica = telaCadastroExcluirMusica;

        // conecta eventos
        this.telaCadastroExcluirMusica.setController(this);
        
        listarArtistasEsquerda();
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        switch (comando) {
            case "Cadastrar":
                
                break;
            case "Voltar":
                telaPrincipal.mostrarTela("adm Inicio");
                break;
        }
    }
    
    public void listarArtistasEsquerda(){
        List<String> listaArtistas = ArtistaDAO.getArtistas();
        
        for (String nomeArtista : listaArtistas){
            telaCadastroExcluirMusica.addArtistaComboBoxEsquerda(nomeArtista);
        }
    }
    
}
