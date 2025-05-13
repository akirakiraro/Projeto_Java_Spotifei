/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.conta;

import view.conta.TelaLogin;
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
                AdminDAO admin = new AdminDAO();
                
                if (admin.validarLoginAdmin(telaLogin.getCampoUsuario(), telaLogin.getCampoSenha()) == true){
                    telaPrincipal.mostrarTela("adm Inicio");
                    break;
                } else if (usuario.validarLoginUsuario(telaLogin.getCampoUsuario(), telaLogin.getCampoSenha()) == true){
                    // login certo
                    telaPrincipal.mostrarTela("usuario Inicio");
                    break;
                } else {
                    // login errado
                    TelaErro erro = new TelaErro();
                    erro.setTexto("Usuário ou senha errado.");
                    erro.setVisible(true);
                    break;
                }
            case "Cadastro":
                telaPrincipal.mostrarTela("cadastro");
                break;
            case "Voltar":
                telaPrincipal.mostrarTela("home");
                break;
        }
    }
    
    
}
