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
 * 
 * 
 */
public class CadastroController implements ActionListener {
    private TelaPrincipal telaPrincipal;
    private TelaCadastro telaCadastro;
    
    public CadastroController(TelaPrincipal telaPrincipal, TelaCadastro telaCadastro) {
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
                String campoUsuario = telaCadastro.getCampoUsuario();
                String campoEmailTelefone = telaCadastro.getCampoEmailTelefone();
                String campoSenha = telaCadastro.getCampoSenha();
                
                System.out.println("Fazendo Cadastro com os dados: ");
                System.out.println("Usuario: " + campoUsuario);
                System.out.println("Email ou Telefone: " + campoEmailTelefone);
                System.out.println("Senha: " + campoSenha);
                // pega as informacoes para teste, ainda sem implementacao do banco de dados
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
