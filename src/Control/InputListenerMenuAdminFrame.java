package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import View.BemVindoFrame;
import View.CadastroUsuarioFrame;
import View.ListarUsuarioFrame;
import View.MenuAdminFrame;

public class InputListenerMenuAdminFrame implements ActionListener {
	
	private MenuAdminFrame menuAdmin;

	public InputListenerMenuAdminFrame(MenuAdminFrame menuAdmin) {
		this.menuAdmin = menuAdmin;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Voltar")){
			int i = JOptionPane.showConfirmDialog(null ,"Deseja voltar a tela de login?", 
					 "Saída",JOptionPane.YES_NO_OPTION);
					 if (i == JOptionPane.YES_OPTION ) {
						 	JOptionPane.showMessageDialog(null, "Você está sendo deslogado!");
							menuAdmin.dispose();  
							new BemVindoFrame().setVisible(true);
					 }
		}else if(e.getActionCommand().equals("Sair")){
			JOptionPane.showMessageDialog(null, "Saindo...");
			menuAdmin.dispose();
			System.exit(1);			
		}else if(e.getActionCommand().equals("Cadastrar Usuários")){
			menuAdmin.dispose();
			new CadastroUsuarioFrame().setVisible(true);
		}else if(e.getActionCommand().equals("Listar Usuários")){
			menuAdmin.dispose();
			new ListarUsuarioFrame().setVisible(true);
		}
	}

}
