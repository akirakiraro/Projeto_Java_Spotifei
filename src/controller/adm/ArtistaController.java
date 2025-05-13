/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.adm;

import dao.ArtistaDAO;
import java.awt.event.*;
import java.util.List;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import view.Adm.TelaCadastroArtista;
import view.Tela;
import model.Artista;

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
        
        // Roda caso a tela seja chamada
        this.telaCadastroArtista.addAncestorListener(new AncestorListener() {
            @Override
            public void ancestorAdded(AncestorEvent evt) {
                System.out.println("\nTela de Cadastro de Artista.");
                listarArtistas();
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
                Artista artista = new Artista(telaCadastroArtista.getCampoNome());
                if (ArtistaDAO.adicionar(artista) == true) {
                    telaCadastroArtista.addListaArtista(artista.getNome());
                    listarArtistas();
                }
                break;
            case "Excluir":
                ArtistaDAO.excluirArtista(telaCadastroArtista.getArtistaSelecionada());
                listarArtistas();
                break;
            case "Voltar":
                telaPrincipal.mostrarTela("adm Inicio");
                break;
        }
    }
    
    public void listarArtistas(){
        telaCadastroArtista.limparLista();
        List<String> listaArtistas = ArtistaDAO.getArtistas();
        
        for (String nomeArtista : listaArtistas){
            telaCadastroArtista.addListaArtista(nomeArtista);
        }
    }
    
}
