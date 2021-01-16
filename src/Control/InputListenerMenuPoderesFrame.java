package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import View.CadastroPoderesFrame;
import View.ListarPoderesFrame;
import View.MenuPoderesFrame;
import View.MenuUsuarioFrame;

public class InputListenerMenuPoderesFrame implements ActionListener {
	
	private MenuPoderesFrame menuPoderes;

	public InputListenerMenuPoderesFrame(MenuPoderesFrame menuPoderes) {
		this.menuPoderes = menuPoderes;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Voltar")){
			menuPoderes.dispose();  
			new MenuUsuarioFrame().setVisible(true);
		}else if(e.getActionCommand().equals("Sair")){
			JOptionPane.showMessageDialog(null, "Saindo...");
			menuPoderes.dispose();
			System.exit(1);	
		}else if(e.getActionCommand().equals("Cadastrar")){
			menuPoderes.dispose();
			new CadastroPoderesFrame().setVisible(true);
		}else if(e.getActionCommand().equals("Listar")){
			menuPoderes.dispose();
			new ListarPoderesFrame().setVisible(true);
		}
	}

}
