package controller.usuario;

import dao.MusicaDAO;
import view.usuario.TelaUsuarioInicial;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.Musica;
import model.MusicaSelecionada;
import view.*;

/**
 *
 * @author Akira
 */
public class UsuarioController implements ActionListener {
    
    private Tela telaPrincipal;
    private TelaUsuarioInicial telaUsuarioInicial;
    
    public UsuarioController(Tela telaPrincipal, TelaUsuarioInicial telaUsuarioInicial) {
        this.telaPrincipal = telaPrincipal;
        this.telaUsuarioInicial = telaUsuarioInicial;

        // conecta eventos
        this.telaUsuarioInicial.setController(this);
        
        // Roda caso a tela seja chamada
        this.telaUsuarioInicial.addAncestorListener(new AncestorListener() {
            @Override
            public void ancestorAdded(AncestorEvent evt) {
                System.out.println("\nTela Inicial do Usuario.");
                // lista de musica
                listarMusicas();
                
            }

            @Override
            public void ancestorMoved(AncestorEvent evt) {} // roda quando a tela eh movida
            @Override
            public void ancestorRemoved(AncestorEvent evt) {} // roda quando a tela eh removida
        });
        
        // Fica vendo a busca de musica conforme for digitando
        telaUsuarioInicial.listenerBusca(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                listarMusicasBuscada(telaUsuarioInicial.getCampoBuscador());
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                listarMusicasBuscada(telaUsuarioInicial.getCampoBuscador());
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                listarMusicasBuscada(telaUsuarioInicial.getCampoBuscador());
            }
        });
        
        // Fica de olho na lista para selecionar
        telaUsuarioInicial.listenerSeleciona(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    MusicaSelecionada MusicaSelecionada;
                    ;
                    
                    telaUsuarioInicial.setInfoMusica(getInfoMusicaSelecionada(telaUsuarioInicial.getStringMusicaSelecionada()));
                }
            }
        });
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        
        switch (comando) {
            // btns parte de cima
            case "Menu":
                telaPrincipal.mostrarTela("home");
                break;
            // botoes parte lateral
            case "Inicio":
                break;
            case "Playlist":
                telaPrincipal.mostrarTela("playlist");
                break;
            case "Historico":
                telaPrincipal.mostrarTela("historico");
                break;
            // botoes parte baixo
            case "like":
                break;
            case "Deslike":
                break;
            case "Voltar":
                break;
            case "PlayPause":
                break;
            case "Proximo":
                break;
        }
    }
 
    public void listarMusicas(){
        telaUsuarioInicial.limparListaMusicas();
        String strInicio = String.format("%-20s | %5s | %-15s | %-10s", "Nome da Música", "Tempo", "Artista", "Gênero");
        telaUsuarioInicial.addListaMusica(strInicio);
        List<Musica> listaMusicas = MusicaDAO.getMusicas();
        
        for (Musica musica : listaMusicas){
            int minutos = musica.getDuracao() / 60;
            int segundos = musica.getDuracao() % 60;
            
            String strFormatada = String.format("%-20s | %02d:%02d | %-15s | %-10s", musica.getTitulo(), minutos, segundos, musica.getArtista(), musica.getGenero());
            telaUsuarioInicial.addListaMusica(strFormatada);
        }
    }
    
    public void listarMusicasBuscada(String busca){
        telaUsuarioInicial.limparListaMusicas();
        String strInicio = String.format("%-20s | %5s | %-15s | %-10s", "Nome da Música", "Tempo", "Artista", "Gênero");
        telaUsuarioInicial.addListaMusica(strInicio);
        List<Musica> listaMusicas = MusicaDAO.buscarMusicas(busca);
        
        for (Musica musica : listaMusicas){
            int minutos = musica.getDuracao() / 60;
            int segundos = musica.getDuracao() % 60;
            
            String strFormatada = String.format("%-20s | %02d:%02d | %-15s | %-10s", musica.getTitulo(), minutos, segundos, musica.getArtista(), musica.getGenero());
            telaUsuarioInicial.addListaMusica(strFormatada);
        }
    }
    
    public MusicaSelecionada getInfoMusicaSelecionada(String stringMusicaSelecionada){
        // Divide a string em partes com base no separador "|"
        String[] partes = stringMusicaSelecionada.split("\\|");

        // Remove espaços em excesso de cada parte
        String titulo = partes[0].trim();
        String duracao = partes[1].trim();
        String artista = partes[2].trim();
        String genero = partes[3].trim();
        
        MusicaSelecionada musicaSelecionada = new MusicaSelecionada(titulo, duracao, artista, genero);
        
        System.out.println("\nMusica no getInfoMusicaSelecionada");
        System.out.println("Titulo: " + titulo);
        System.out.println("Duracao: " + duracao);
        System.out.println("Artista: " + artista);
        System.out.println("Genero: " + genero);
        
        return musicaSelecionada;
    }
}
