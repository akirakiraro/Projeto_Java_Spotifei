/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.adm;

import java.awt.event.*;
import view.Adm.TelaCadastroArtista;
import view.Tela;

/**
 *
 * @author Akira
 */
public class ArtistaController implements ActionListener{
    private Tela telaPrincipal;
    private TelaCadastroArtista telaCadastroArtista;
    
    public ArtistaController(Tela telaPrincipal, TelaCadastroArtista telaCadastroArtista) {
        this.telaPrincipal = telaPrincipal;
        this.telaCadastroArtista = telaCadastroArtista;

        // conecta eventos
        this.telaCadastroArtista.setController(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        switch (comando) {
            case "Cadastro Artista":
                telaPrincipal.mostrarTela("login");
                break;
            case "Voltar":
                telaPrincipal.mostrarTela("adm Inicio");
                break;
        }
    }
}
