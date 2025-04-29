package controller;

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
            case "Deslike":
                
                break;
            case "Like":
                break;
            case "Voltar":
                break;
            case "PlayPause":
                break;
            case "Proximo":
                break;
            case "Menu":
                telaPrincipal.mostrarTela("home");
                break;
        }
    }
        
}
