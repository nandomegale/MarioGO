package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import View.CadastroRegioesFrame;
import View.ListarRegioesFrame;
import View.MenuRegi�esFrame;
import View.MenuUsuarioFrame;

public class InputListenerMenuRegioesFrame implements ActionListener {
	
	private MenuRegi�esFrame menuRegioes;

	public InputListenerMenuRegioesFrame(MenuRegi�esFrame menuRegioes) {
		this.menuRegioes = menuRegioes;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Voltar")){
			menuRegioes.dispose();  
			new MenuUsuarioFrame().setVisible(true);
		}else if(e.getActionCommand().equals("Sair")){
			JOptionPane.showMessageDialog(null, "Saindo...");
			menuRegioes.dispose();
			System.exit(1);	
		}else if(e.getActionCommand().equals("Cadastrar")){
			menuRegioes.dispose();
			new CadastroRegioesFrame().setVisible(true);			
		}else if(e.getActionCommand().equals("Listar")){
			menuRegioes.dispose();
			new ListarRegioesFrame().setVisible(true);
		}
	}

}
