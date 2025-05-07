package controller;

import view.usuario.TelaUsuarioInicial;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        
}
