package controller.usuario;

import view.usuario.TelaHistorico;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.*;

/**
 *
 * @author Akira
 */
public class HistoricoController implements ActionListener {
    
    private Tela telaPrincipal;
    private TelaHistorico telaHistorico;
    
    public HistoricoController(Tela telaPrincipal, TelaHistorico telaHistorico) {
        this.telaPrincipal = telaPrincipal;
        this.telaHistorico = telaHistorico;

        // conecta eventos
        this.telaHistorico.setController(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        
        switch (comando) {
            case "Voltar":
                telaPrincipal.mostrarTela("usuario Inicio");
                break;
        }
    }
        
}
