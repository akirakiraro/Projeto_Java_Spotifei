package controller;

import view.usuario.TelaPlaylist;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.*;

/**
 *
 * @author Akira
 */
public class PlaylistController implements ActionListener {
    
    private Tela telaPrincipal;
    private TelaPlaylist telaPlaylist;
    
    public PlaylistController(Tela telaPrincipal, TelaPlaylist telaPlaylist) {
        this.telaPrincipal = telaPrincipal;
        this.telaPlaylist = telaPlaylist;

        // conecta eventos
        this.telaPlaylist.setController(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        
        switch (comando) {
            case "Criar Playlist":
                break;
            case "Voltar":
                telaPrincipal.mostrarTela("usuario Inicio");
                break;
            case "Renomear":
                break;
            case "Excluir":
                break;
        }
    }
        
}
