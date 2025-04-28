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
public class HomeController implements ActionListener {
    
    private Tela telaPrincipal;
    private TelaHome telaHome;
    
    public HomeController(Tela telaPrincipal, TelaHome telaHome) {
        this.telaPrincipal = telaPrincipal;
        this.telaHome = telaHome;

        // conecta eventos
        this.telaHome.setController(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        switch (comando) {
            case "Login":
                telaPrincipal.mostrarTela("login");
                break;
            case "Cadastro":
                telaPrincipal.mostrarTela("cadastro");
                break;
            case "Sair":
                System.exit(0);
                break;
        }
    }
    
    
}
