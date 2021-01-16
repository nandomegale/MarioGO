package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import View.CadastroAmigosMarioFrame;
import View.ListarAmigosMarioFrame;
import View.MenuAmigosDoMarioFrame;
import View.MenuUsuarioFrame;

public class InputListenerMenuAmigosMarioFrame implements ActionListener {
	
	private MenuAmigosDoMarioFrame menuAmigos;

	public InputListenerMenuAmigosMarioFrame(MenuAmigosDoMarioFrame menuAmigos) {
		this.menuAmigos = menuAmigos;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Voltar")){
			menuAmigos.dispose();  
			new MenuUsuarioFrame().setVisible(true);
		}else if(e.getActionCommand().equals("Sair")){
			JOptionPane.showMessageDialog(null, "Saindo...");
			menuAmigos.dispose();
			System.exit(1);	
		}else if(e.getActionCommand().equals("Cadastrar")){
			menuAmigos.dispose();
			new CadastroAmigosMarioFrame().setVisible(true);
		}else if(e.getActionCommand().equals("Listar")){
			menuAmigos.dispose();
			new ListarAmigosMarioFrame().setVisible(true);
		}
	}

}
