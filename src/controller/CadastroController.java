/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.UsuarioDAO;
import java.awt.event.*;
import view.*;
import model.*;

/**
 *
 * @author Akira
 * 
 * 
 */
public class CadastroController implements ActionListener {
    private Tela telaPrincipal;
    private TelaCadastro telaCadastro;
    
    public CadastroController(Tela telaPrincipal, TelaCadastro telaCadastro) {
        this.telaPrincipal = telaPrincipal;
        this.telaCadastro = telaCadastro;

        // conecta eventos
        this.telaCadastro.setController(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        switch (comando) {
            case "Cadastrar":
                Usuario user = new Usuario();
                user.UsuarioEmail(
                    telaCadastro.getCampoUsuario(),
                    telaCadastro.getCampoEmailTelefone(),
                    telaCadastro.getCampoSenha());
                UsuarioDAO.adicionar(user);
                break;
            case "Login":
                telaPrincipal.mostrarTela("login");
                break;
            case "Voltar":
                telaPrincipal.mostrarTela("home");
                break;
        }
    }
}
