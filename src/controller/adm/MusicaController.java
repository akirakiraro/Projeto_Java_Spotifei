package controller.adm;

import dao.ArtistaDAO;
import dao.MusicaDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import model.Musica;
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
        
        // Roda caso a tela seja chamada
        this.telaCadastroExcluirMusica.addAncestorListener(new AncestorListener() {
            @Override
            public void ancestorAdded(AncestorEvent evt) {
                System.out.println("\nTela de Cadastro.");
                listarArtistasEsquerda();
            }

            @Override
            public void ancestorMoved(AncestorEvent evt) {} // roda quando a tela eh movida
            @Override
            public void ancestorRemoved(AncestorEvent evt) {} // roda quando a tela eh removida
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        switch (comando) {
            case "Cadastrar":
                Musica musica = new Musica(telaCadastroExcluirMusica.getCampoNomeMusicaEsquerda(),
                                           telaCadastroExcluirMusica.getCampoDuracaoMusicaEsquerda());
                
                MusicaDAO.adicionarMusica(musica, telaCadastroExcluirMusica.getComboBoxArtistaEsquerda());
                break;
            case "Voltar":
                telaPrincipal.mostrarTela("adm Inicio");
                break;
        }
    }
    
    
    
    
    public void listarArtistasEsquerda(){
        telaCadastroExcluirMusica.limparArtistaComboBoxEsquerda();
        List<String> listaArtistas = ArtistaDAO.getArtistas();
        
        for (String nomeArtista : listaArtistas){
            telaCadastroExcluirMusica.addArtistaComboBoxEsquerda(nomeArtista);
        }
    }
}
