
import view.*;
import controller.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */



/**
 *
 * @author Akira
 */
public class Main {
    
    public static void main(String[] args) {
        TelaPrincipal tela = new TelaPrincipal();
        tela.setVisible(true);

        // passa as views e conecta os controllers
        new HomeController(tela, tela.getTelaHome());
        new LoginController(tela, tela.getTelaLogin());
        new CadastroController(tela, tela.getTelaCadastro());
    }
    
}
