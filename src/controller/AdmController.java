/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import view.Adm.TelaAdmInicial;
import java.awt.event.*;
import view.*;

/**
 *
 * @author unieryatate
 */
public class AdmController implements ActionListener{
    private Tela telaPrincipal;
    private TelaAdmInicial telaAdmInicial;
    
    public AdmController(Tela telaPrincipal, TelaAdmInicial telaAdmInicial) {
        this.telaPrincipal = telaPrincipal;
        this.telaAdmInicial = telaAdmInicial;

        // conecta eventos
        this.telaAdmInicial.setController(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        switch (comando) {
            case "Cadastro Artista":
                telaPrincipal.mostrarTela("login");
                break;
            case "Sair":
                System.exit(0);
                break;
        }
    }
}
