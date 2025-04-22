/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.*;
import view.*;

/**
 *
 * @author Akira
 */
public class LoginController implements ActionListener{
    
    private TelaPrincipal telaPrincipal;
    private TelaLogin telaLogin;
    
    public LoginController(TelaPrincipal telaPrincipal, TelaLogin telaLogin) {
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
                String campoUsuario = telaLogin.getCampoUsuario();
                String campoSenha = telaLogin.getCampoSenha();
                
                System.out.println("Fazendo login com os dados: ");
                System.out.println("Usuario: " + campoUsuario);
                System.out.println("Senha: " + campoSenha);
                // pega as informacoes para teste, ainda sem implementacao do banco de dados
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
