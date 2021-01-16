package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import View.CadastroInimigosMarioFrame;
import View.ListarInimigosMarioFrame;
import View.MenuInimigosMarioFrame;
import View.MenuUsuarioFrame;

public class InputListenerMenuInimigosMarioFrame implements ActionListener {
	
	private MenuInimigosMarioFrame menuInimigos;

	public InputListenerMenuInimigosMarioFrame(MenuInimigosMarioFrame menuInimigos) {
		this.menuInimigos = menuInimigos;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Voltar")){
			menuInimigos.dispose();  
			new MenuUsuarioFrame().setVisible(true);
		}else if(e.getActionCommand().equals("Sair")){
			JOptionPane.showMessageDialog(null, "Saindo...");
			menuInimigos.dispose();
			System.exit(1);	
		}else if(e.getActionCommand().equals("Cadastrar")){
			menuInimigos.dispose();
			new CadastroInimigosMarioFrame().setVisible(true);
		}else if(e.getActionCommand().equals("Listar")){
			menuInimigos.dispose();
			new ListarInimigosMarioFrame().setVisible(true);
		}
	}

}
