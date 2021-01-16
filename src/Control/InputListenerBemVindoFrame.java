package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Model.UsuarioDAO;
import View.BemVindoFrame;
import View.MenuAdminFrame;
import View.MenuUsuarioFrame;

public class InputListenerBemVindoFrame implements ActionListener {

	private BemVindoFrame menu;

	public InputListenerBemVindoFrame(BemVindoFrame menu) {
		this.menu = menu;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Sair")) {
			JOptionPane.showMessageDialog(null, "Saindo...");
			menu.dispose();
			System.exit(1);
		} else if (e.getActionCommand().equals("Entrar")) {
			if (menu.getUserTextField().getText().equals("admin")
					&& menu.getPasswordField().getText().equals("admin")) {
				menu.dispose();
				new MenuAdminFrame().setVisible(true);
			} else if (UsuarioDAO.getInstance().existeLogin(menu.getUserTextField().getText(),
					menu.getPasswordField().getText())) {
				try {
					UsuarioDAO.getInstance().estaLogado(menu.getUserTextField().getText());
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				menu.dispose();
				new MenuUsuarioFrame().setVisible(true);
			} else {
				JOptionPane.showMessageDialog(null, "Dados Incorretos!");
				menu.getUserTextField().setText(null);
				menu.getPasswordField().setText(null);
			}
		}
	}
}