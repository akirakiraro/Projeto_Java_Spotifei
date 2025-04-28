/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.*;
import view.*;
import dao.*;

/**
 *
 * @author Akira
 */
public class LoginController implements ActionListener{
    
    private Tela telaPrincipal;
    private TelaLogin telaLogin;
    
    public LoginController(Tela telaPrincipal, TelaLogin telaLogin) {
        this.telaPrincipal = telaPrincipal;
        this.telaLogin = telaLogin;

        // conecta eventos
        this.telaLogin.setController(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        switch (comando) {
            case "Logar":
                UsuarioDAO usuario = new UsuarioDAO();
                
                usuario.validarLoginUsuario(telaLogin.getCampoUsuario(), telaLogin.getCampoSenha());
                telaPrincipal.mostrarTela("Usuario Inicio");
                break;
            case "Cadastro":
                telaPrincipal.mostrarTela("cadastro");
                break;
            case "Voltar":
                telaPrincipal.mostrarTela("home");
                break;
        }
    }
    
    
}
