package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Model.UsuarioDAO;
import View.BemVindoFrame;
import View.MenuAmigosDoMarioFrame;
import View.MenuInimigosMarioFrame;
import View.MenuPoderesFrame;
import View.MenuRegi�esFrame;
import View.MenuUsuarioFrame;

public class InputListenerMenuUsuarioFrame implements ActionListener {
	
	private MenuUsuarioFrame menuUsuario;

	public InputListenerMenuUsuarioFrame(MenuUsuarioFrame menuUsuario) {
		this.menuUsuario = menuUsuario;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Voltar")){
			 int i = JOptionPane.showConfirmDialog(null ,"Deseja voltar a tela de login?", 
					 "Sa�da",JOptionPane.YES_NO_OPTION);
					 if (i == JOptionPane.YES_OPTION ) {
						 	JOptionPane.showMessageDialog(null, "Voc� est� sendo deslogado!");
						 	try {
								UsuarioDAO.getInstance().deslogarUsuario();
							} catch (SQLException e1) {
								JOptionPane.showMessageDialog(null, e1.getMessage());
							}
						 	menuUsuario.dispose();  
							new BemVindoFrame().setVisible(true);
					 }
		}else if(e.getActionCommand().equals("Sair")){
			JOptionPane.showMessageDialog(null, "Saindo...");
			menuUsuario.dispose();
			System.exit(1);	
		}else if(e.getActionCommand().equals("Amigos do M�rio")){
			menuUsuario.dispose();
			new MenuAmigosDoMarioFrame().setVisible(true);
			
		}else if(e.getActionCommand().equals("Regi�es")){
			menuUsuario.dispose();
			new MenuRegi�esFrame().setVisible(true);
			
		}else if(e.getActionCommand().equals("Poderes")){
			menuUsuario.dispose();
			new MenuPoderesFrame().setVisible(true);
			
		}else if(e.getActionCommand().equals("Inimigos do M�rio")){
			menuUsuario.dispose();
			new MenuInimigosMarioFrame().setVisible(true);
			
		}
	}

}
