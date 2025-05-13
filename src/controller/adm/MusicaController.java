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
import view.TelaErro;

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
                System.out.println("\nTela de Musica.");
                listarArtistasEsquerda();
                listarMusicas();
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
                                           telaCadastroExcluirMusica.getCampoDuracaoMusicaEsquerda(),
                                           telaCadastroExcluirMusica.getCampoGeneroEsquerda());
                if (musica.getDuracao() == -1) {
                    TelaErro erro = new TelaErro();
                    erro.setTexto("Duração da música inválida.");
                    erro.setVisible(true);
                    break;
                } else {
                    MusicaDAO.adicionarMusica(musica, telaCadastroExcluirMusica.getComboBoxArtistaEsquerda());
                    listarMusicas();
                    break;
                }
            case "Excluir":
                if (telaCadastroExcluirMusica.getMusicaSelecionada() == -1){
                    TelaErro erro = new TelaErro();
                    erro.setTexto("Selecione uma Música.");
                    erro.setVisible(true);
                    break;
                } else {
                    MusicaDAO.excluirMusica(telaCadastroExcluirMusica.getMusicaSelecionada());
                    listarMusicas();
                    break;
                }
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
    
    public void listarMusicas(){
        telaCadastroExcluirMusica.limparLista();
        String strInicio = String.format("%-20s | %5s | %-15s | %-10s", "Nome da Música", "Tempo", "Artista", "Gênero");
        telaCadastroExcluirMusica.addListaArtista(strInicio);
        List<Musica> listaMusicas = MusicaDAO.getMusicas();
        
        for (Musica musica : listaMusicas){
            int minutos = musica.getDuracao() / 60;
            int segundos = musica.getDuracao() % 60;
            
            String strFormatada = String.format("%-20s | %02d:%02d | %-15s | %-10s", musica.getTitulo(), minutos, segundos, musica.getArtista(), musica.getGenero());
            telaCadastroExcluirMusica.addListaArtista(strFormatada);
        }
    }
}
